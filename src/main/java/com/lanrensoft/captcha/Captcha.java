package com.lanrensoft.captcha;

public interface Captcha {

    /**
     * 验证码图像和验证码字符串。
     *
     * @return 返回验证码图像和验证码字符串。
     */
    public ImageCode getImageCode();

    /**
     * 校验来自客服端输入的验证码是否相同。
     *
     * @param code 服务器端的验证码。
     * @param clientCode 来自客服端的验证码。
     * @return
     */
    public boolean checkCaptcha(String code, String clientCode);
}
