package com.lanrensoft.captcha;


import com.sun.imageio.plugins.common.ImageUtil;
import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

public class ECaptchaTest {

    public static void main(String[] args) throws IOException {
        Captcha eCaptcha = new ECaptcha();
        ImageCode imageCode = eCaptcha.getImageCode();
        String code = imageCode.getCode();
        Image image = imageCode.getImage();
        boolean b = eCaptcha.checkCaptcha(code, "7");
        System.out.printf(b+"");
        ImageIO.write((RenderedImage) image, "png", new File("D:\\codeerTest\\" + code + ".png"));
    }
}
