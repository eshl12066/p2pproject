package com.gg.microservicecommon.entity.sys;

/**
 * @Description: 定义公共常量
 * @Author: cpc
 * @Date: 2019-10-19 11:33
 * @Version: V1.0
 */
public class CommonConstant {
    /* JWT_WEB_TTL：WEBAPP应用中token的有效时间,默认30分钟 */
    public static final long  JWT_WEB_TTL  =  60 * 1000;;

    /* redis里面的默认时间,默认1小时 */
    public static final long  REDIS_TIMEOUT  =  60 * 60;;

    /*  将jwt令牌保存到header中的key名称 用于权限认证*/
    public static final String JWT_HEADER_KEY = "jwt";

    /* 用户信息存入到redis中*/
    public static final String HEADER_PREFIX ="redisjwt_";

    /*用户状态*/
    public static final String USERFLAG_PREFIX ="UserFlag_";

    /*用户角色*/
    public static final String USERROLE_PREFIX ="UserRole_";
    /*用户权限*/
    public static final String USERPERMISSION_PREFIX ="UserPermission_";


    /*用户*/
    public static  final  String USER_PREFIX ="User_";

    /*这是保存验证码颁发的jwt令牌*/
    public static final String JWT_VERIFICATION_KEY = "verificationJwt";

    /* 用户存入reids中的验证码前缀*/
    public static final String VERIFICATION_PREFIX = "verificationCode_";

    /**字典翻译文本后缀*/
    public static final String DICT_TEXT_SUFFIX = "_dictText";
}
