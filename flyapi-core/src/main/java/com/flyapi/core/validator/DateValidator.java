package com.flyapi.core.validator;

import com.baidu.unbiz.fluentvalidator.ValidationError;
import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

import java.util.Date;

/**
 * 日期验证类
 * author: flyhero
 * Date: 2017/5/15 0015 下午 6:09
 */
public class DateValidator extends ValidatorHandler<Date> implements Validator<Date>{
    private Date minDate = new Date(System.currentTimeMillis());
    private Date maxDate = new Date(2100,1,1,10,10,10);
    private String fieldName = "";
    public DateValidator(String fieldName){
        this.fieldName = fieldName;
    }
    public DateValidator(Date minDate,Date maxDate){
        this.minDate = minDate;
        this.maxDate = maxDate;
    }
    public DateValidator(Date minDate,Date maxDate,String fieldName){
        this(fieldName);
        this.minDate = minDate;
        this.maxDate = maxDate;
    }

    @Override
    public boolean validate(ValidatorContext context, Date date) {
        if (date.before(maxDate) && date.after(minDate)){
            context.addError(ValidationError.create(String.format("日期%s不在范围内",fieldName))
                    .setField(fieldName).setErrorCode(100).setInvalidValue(date));
            return false;
        }
        return true;
    }
}
