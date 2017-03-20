package com.flyhero.flyapi.pojo;

import com.flyhero.flyapi.utils.TipsEnum;

public class LoginResult extends JSONResult{
	
	public LoginResult(Boolean success,TipsEnum loginEnum) {
		super(success,loginEnum.getMsg(), loginEnum.getCode());
	}

	public LoginResult(Boolean success,TipsEnum loginEnum, Object data) {
		super(success,loginEnum.getMsg(), loginEnum.getCode(), data);
	}
	
	public static JSONResult ok(TipsEnum loginEnum){
		return ok(loginEnum.getCode(), loginEnum.getMsg(), null);
	}
	public static JSONResult error(TipsEnum loginEnum){
		return error(loginEnum.getCode(), loginEnum.getMsg(), null);
	}

}
