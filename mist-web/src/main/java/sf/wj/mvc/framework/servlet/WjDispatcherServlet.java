package sf.wj.mvc.framework.servlet;

import sf.wj.mvc.framework.annocation.WjAutowired;
import sf.wj.mvc.framework.annocation.WjController;
import sf.wj.mvc.framework.annocation.WjRequestMapping;
import sf.wj.mvc.framework.annocation.WjService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * Created by wangjun32 on 2019/2/12.
 */
public class WjDispatcherServlet extends HttpServlet {
    //所有的配置都存入了Properties中
    private Properties p = new Properties();

    private List<String> classNames = new ArrayList<>();

    private Map<String, Object> ioc = new HashMap<String, Object>();

    private Map<String, Method> handerMapping = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("---------wj mvc init()...---------------");

        //1、加载配置文件
        doLoadConfig(config.getInitParameter("contextConfigLocation"));
        //2、根据配置文件扫描所有相关文件
        doScanner(p.getProperty("wjtest"));
        //3、初始化所有相关类的实例，并且将其放入IOC容器之中，也就是Map中
        doInstance();
        //4、实现自动依赖注入
        doAutoWired();
        //5、初始化HanderMapping
        initHanderMapping();


    }

    private void initHanderMapping() {
        if (ioc.isEmpty()) {
            return;
        }

        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();
            if (!clazz.isAnnotationPresent(WjController.class)) {
                continue;
            }
            String baseUrl = "";
            if (clazz.isAnnotationPresent(WjRequestMapping.class)) {
                WjRequestMapping requestMapping = clazz.getAnnotation(WjRequestMapping.class);
                baseUrl = requestMapping.value();
            }

            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (!method.isAnnotationPresent(WjRequestMapping.class)) {
                    return;
                }
                WjRequestMapping requestMapping = method.getAnnotation(WjRequestMapping.class);
                String url = baseUrl + requestMapping.value().replaceAll("/+", "/");
                handerMapping.put(url, method);
                System.out.println("Mapping:" + url + "，method:" + method);
            }


        }
    }

    private void doAutoWired() {
        if (ioc.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> entry : ioc.entrySet()) {
            //首先第一步要获取到所有字段的field

            //不管是private还是protected还是default都要强制注入
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAnnotationPresent(WjAutowired.class)) {
                    continue;
                }
                WjAutowired autowired = field.getAnnotation(WjAutowired.class);
                String beanName = autowired.value().trim();
                if ("".equals(beanName)) {
                    beanName = field.getType().getName();
                }

                //要想访问到私有的，需要授权
                field.setAccessible(true);

                try {
                    field.set(entry.getValue(), ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void doInstance() {
        if (classNames.isEmpty()) {
            return;
        }
        //如果不为空，利用反射机制将刚刚扫描进来的的所有className初始化
        try {
            for (String className : classNames) {
                Class<?> clazz = Class.forName(className);
                //接下来进入bean实例化阶段，初始化IOC容器

                //IOC容器规则
                try {
                    if (clazz.isAnnotationPresent(WjController.class)) {
                        //1、key默认用类名首字母小写
                        String beanName = lowerFirstCase(clazz.getSimpleName());

                        ioc.put(beanName, clazz.newInstance());

                    } else if (clazz.isAnnotationPresent(WjService.class)) {
                        //2、如果用户自定义名字，那么要优先选择用自定义名字
                        WjService service = clazz.getAnnotation(WjService.class);
                        String beanName = service.value();
                        if (!"".equals(beanName.trim())) {
                            ioc.put(lowerFirstCase(beanName), clazz.newInstance());
                        } else {
                            ioc.put(lowerFirstCase(clazz.getSimpleName()), clazz.newInstance());
                        }

                        //3、如果是接口的话我们可以巧妙的用接口的类型作为key实例化其实现类
                        Class<?>[] interfaces = clazz.getInterfaces();
                        for (Class<?> anInterface : interfaces) {
                            //将接口的类型作为key
                            ioc.put(anInterface.getName(), clazz.newInstance());
                        }
                    } else {
                        continue;
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String lowerFirstCase(String str) {
        char[] charArray = str.toCharArray();
        charArray[0] += 32;
        return String.valueOf(charArray);
    }

    private void doScanner(String packageName) {
        //进行递归扫描
        URL url = this.getClass().getClassLoader().getResource("/" + packageName.replaceAll("\\.", "/"));
        File classDir = new File(url.getFile());
        for (File file : classDir.listFiles()) {
            if (file.isDirectory()) {
                doScanner(packageName + "." + file.getName());
            } else {
                String className = packageName + "." + file.getName().replace(".class", "");
                classNames.add(className);
            }
        }
    }

    private void doLoadConfig(String location) {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(location);
        try {
            p.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    //6、等待请求

    //运行时阶段要执行的方法
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replace(contextPath, "").replaceAll("/+", "/");

        if (!handerMapping.containsKey(url)) {
            resp.getWriter().write("404 not found!!!");
            return;
        }
        Method method = handerMapping.get(url);

        //反射的方法
        //需要拿到两个参数，第一个是这个方法的instance，第二个要拿到实参，request获取
        System.out.println(method);
    }


}
