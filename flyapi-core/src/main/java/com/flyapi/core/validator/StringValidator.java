package com.flyapi.core.validator;

import com.baidu.unbiz.fluentvalidator.*;
/**
 * 字符串验证类
 * author: flyhero
 * Date: 2017/5/15 0015 下午 4:37
 */
public class StringValidator extends ValidatorHandler<String> implements Validator<String>{

    private int min = 0;
    private int max = 2147483647; //整型最大值
    private String fieldName = "";
    public StringValidator(String fieldName){
        this.fieldName = fieldName;
    }
    public StringValidator(int min, int max){
        this.min = min;
        this.max = max;
    }
    public StringValidator(int min, int max ,String fieldName){
        this(fieldName); //调用其它构造函数
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean validate(ValidatorContext context, String s) {
        if (null == s || "".equals(s)){
            context.addError(ValidationError.create(String.format("%s字符串不能为空!", fieldName))
                    .setErrorCode(100).setField(fieldName).setInvalidValue(s));
            return false;
        }else if(s.length() < min || s.length() > max){
            context.addError(ValidationError.create(String.format("%s长度超出范围!", fieldName))
                    .setErrorCode(101).setField(fieldName).setInvalidValue(s));
            return false;
        }
        return true;
    }

}
