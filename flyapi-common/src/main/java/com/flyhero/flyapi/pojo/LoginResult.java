package com.flyhero.flyapi.pojo;

import com.flyhero.flyapi.utils.LoginEnum;

public class LoginResult extends JSONResult{
	
	public LoginResult(Boolean success,LoginEnum loginEnum) {
		super(success,loginEnum.getMsg(), loginEnum.getCode());
	}

	public LoginResult(Boolean success,LoginEnum loginEnum, Object data) {
		super(success,loginEnum.getMsg(), loginEnum.getCode(), data);
	}
	
	public static JSONResult ok(LoginEnum loginEnum){
		return ok(loginEnum.getCode(), loginEnum.getMsg(), null);
	}
	public static JSONResult error(LoginEnum loginEnum){
		return error(loginEnum.getCode(), loginEnum.getMsg(), null);
	}

}
