package sf.wj.common.utils;

import com.swetake.util.Qrcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by wangjun32 on 2018/9/5.
 */
public class QrCodeUtil {
    /**
     * 生成二维码
     *
     * @param content
     * @param imgPath
     * @param logoPath
     * @return
     */
    public static boolean createQRCode(String content, String imgPath, String logoPath) {
        try {
            Qrcode qrcodeHandler = new Qrcode();
            // 设置二维码排错率，可选L(7%)、M(15%)、Q(25%)、H(30%)，排错率越高可存储的信息越少，但对二维码清晰度的要求越小
            qrcodeHandler.setQrcodeErrorCorrect('M');
            // N代表数字,A代表字符a-Z,B代表其他字符
            qrcodeHandler.setQrcodeEncodeMode('B');
            // 设置设置二维码版本，取值范围1-40，值越大尺寸越大，可存储的信息越大
            qrcodeHandler.setQrcodeVersion(9);
            // 设置编码格式为UTF-8
            byte[] contentBytes = content.getBytes("utf-8");
            BufferedImage bufImg = new BufferedImage(168, 168, BufferedImage.TYPE_INT_RGB);
            Graphics2D gs = bufImg.createGraphics();
            // 设置背景色为白色
            gs.setBackground(Color.white);
            gs.clearRect(0, 0, 168, 168);
            // 设定图像颜色 为黑色
            gs.setColor(Color.BLACK);
            // 设置偏移量 不设置可能导致解析出错
            int pixoff = 2;
            // 输出内容 > 二维码
            if (contentBytes.length > 0 && contentBytes.length < 150) {
                boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);
                for (int i = 0; i < codeOut.length; i++) {
                    for (int j = 0; j < codeOut.length; j++) {
                        if (codeOut[j][i]) {
                            gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
                        }
                    }
                }
            } else {
                return false;
            }
            //TODO 转换成流
            // 实例化一个Image对象。
            Image img = ImageIO.read(new File(logoPath));
            // 60,60是距离gs两个边的距离，45,45是中间logo的大小
            gs.drawImage(img, 60, 60, 45, 45, null);
            gs.dispose();
            bufImg.flush();
            File imgFile = new File(imgPath);
            ImageIO.write(bufImg, "png", imgFile);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
