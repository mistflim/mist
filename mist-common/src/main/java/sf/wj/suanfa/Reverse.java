package sf.wj.suanfa;

/**
 * 倒序输出字符串
 * Created by wangjun32 on 2018/10/19.
 */
public class Reverse {

    private static String sbReverse(String s) {
        StringBuffer sbf = new StringBuffer();
        sbf.append(s);
        return sbf.reverse().toString();
    }

    private static String reverse(String s) {
        if (s.length() < 1) {
            return "";
        }
        String s2 = s.substring(s.length() - 1);
        System.out.print(s2);
        return reverse(s.substring(0, s.length() - 1));
    }

    public static void main(String[] args) {
//        String s = "abc";
//        System.out.println(s.substring(s.length() - 1));
//        System.out.println(s.substring(0, s.length() - 1));
        
//        System.out.println(sbReverse("abcd"));
        System.out.println(reverse("abcdefefe"));
    }


}
