package com.kute.appletcore.util;

public class ApplicationConstant {
    
    public static final String TOOLTIPS_EXCEPTION = "系统出现异常，请联系系统管理员！";
    
   public static final String SECURITY_JWT_401 = "您未授权访问当前资源！请先登录系统！";
    
    public static final String SECURITY_JWT_403 = "禁止访问！您没有权限访问当前资源！";
    
    public static final String SAVE_SUCCESS = "保存成功！";
    
    public static final String REMOVE_SUCESS = "删除成功！";
    
public static final String LOGIN_VALIDATE_01 = "登录参数无效！";
    
    public static final String LOGIN_VALIDATE_02 = "用户名不能为空！";
    
    public static final String LOGIN_VALIDATE_03 = "密码不能为空！";
    
    public static final String LOGIN_VALIDATE_04 = "验证码不能为空！";
    
    public static final String LOGIN_VALIDATE_05 = "用户不存在！";
    
    public static final String LOGIN_VALIDATE_06 = "用户无效！";
    
    public static final String LOGIN_VALIDATE_07 = "密码不正确！";
    
    public static final String LOGIN_VALIDATE_08 = "验证码无效！";
    
    public static final String LOGIN_VALIDATE_09 = "验证码不正确！";

    public static final String SECURITY_JWT_200 = "允许访问";
    
 // 缓存超时时间:1小时
    public static final long REDIS_KEY_TIMEOUT_1 = 3600;
    
    // 缓存超时时间:1分钟
    public static final long REDIS_KEY_TIMEOUT_2 = 60;
    
    // 图形验证码
    public static final String REDIS_KEY_PREFIX_003 = "com.chawran.security.ivc.";
    
    // 短信验证码
    public static final String REDIS_KEY_PREFIX_004 = "com.chawran.security.sms.";
    
    // 短信登录验证码有效期间
    public static final String SUBMAIL_PERIOD_LOGIN_VERIFICATION_CODE = "一分钟";
    

    public static final String FIND_SUCCESS = "获取成功";
    
    public static final String FIND_FAILED = "查询失败!";

    public static final String EMPTY_PARAM = "参数为空";

    public static final String SAVE_FAILED = "保存失败!";

    public static final String REMOVE_FAILED = "删除失败!";
    
    public static final String UPDATE_SUCCESS = "更新成功";
    
    public static final String UPDATE_FAILED = "更新失败!";
    
    public static final String OPERATE_SUCCESS = "操作成功";
    
    public static final String YES = "Y";
    
    public static final String NO = "N";
    /**
	 * <p>
	 * session常量
	 * </p>
	 *
	 */
	public final static class session {
		
		public final static String USER = "_currentUser";	// 用户ID
		public final static String USER_ISACTIVE_1 = "1";	// 记录当前用户是否已登录：1,已登录
		public final static String USER_ISACTIVE_0 = "0";	// 记录当前用户是否已登录：0,未登录
		public final static String THEMES = "_THEMES_SESSION";// 主题
	}
	public final static class foreWarn{
		public final static String NUM_FORE_WARN = "num";
		public final static String TEXT_FORE_WARN = "text";
		public final static String FORE_WARN_LEVEL_NORMAL = "正常";
		public final static String FORE_WARN_LEVEL_FOREWARN = "预警";
		public final static String FORE_WARN_LEVEL_ABNORMAL = "异常";
	}
}
