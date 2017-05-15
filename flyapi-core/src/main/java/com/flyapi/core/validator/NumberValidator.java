package com.flyapi.core.validator;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

/**
 * author: flyhero
 * Date: 2017/5/15 0015 下午 5:55
 */
public class NumberValidator extends ValidatorHandler<Integer> implements Validator<Integer> {
    private int min = 0;
    private int max = 0;
    private String fieldName = "";
    public NumberValidator(String fieldName){
        this.fieldName=fieldName;
    }
    public NumberValidator(int min,int max){
        this.min = min;
        this.max = max;
    }
    public NumberValidator(int min,int max,String fieldName){
        this(fieldName);
        this.min = min;
        this.max = max;
    }

    public boolean validator(ValidatorContext context,Integer num){
        if(null == num || 0 == num){
            context.addError(ValidationError.create(String.format("%s不能为空或 0 ！",fieldName))
                    .setErrorCode(100).setField(fieldName).setInvalidValue(num));
            return false;
        }else if(num < min || num >max){
            context.addError(ValidationError.create(String.format("%s超出了范围！",fieldName))
                    .setErrorCode(101).setField(fieldName).setInvalidValue(num));
            return false;
        }
        return true;
    }

}
