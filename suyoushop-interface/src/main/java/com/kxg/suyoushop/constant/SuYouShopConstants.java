package com.kxg.suyoushop.constant;

public class SuYouShopConstants {

    public final static String LOGIN_SUCCESS="登录成功";
    public final static String CODE_IS_NOT_RIGHT="手机验证码不正确，请重新确认";
    public final static String PHONE_OR_PWD_NOT_RIGHT="手机号或密码错误";
    public final static String PHONE_NUMBER_NOT_RIGHT="手机号错误";
    public final static String TOKEN_IS_NOT_RIGHT="当前token错误,请检查token是否正确，或者过期";
    public final static Short NOT_PAY_STATUS=0;
    /**
     * 支付成功
     */
    public final static Short PAY_SUCCESS=1;
    /**
     * 放弃支付
     */
    public final static Short GIVE_UP_PAY=2;
}
