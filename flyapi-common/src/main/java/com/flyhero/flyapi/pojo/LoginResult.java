package com.flyhero.flyapi.pojo;

import com.flyhero.flyapi.utils.LoginEnum;

public class LoginResult extends JSONResult{
	
	public LoginResult(LoginEnum loginEnum) {
		super(loginEnum.getMsg(), loginEnum.getCode());
	}

	public LoginResult(LoginEnum loginEnum, Object data) {
		super(loginEnum.getMsg(), loginEnum.getCode(), data);
	}

}
