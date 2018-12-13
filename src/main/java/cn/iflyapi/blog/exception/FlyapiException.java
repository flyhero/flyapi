package cn.iflyapi.blog.exception;

import cn.iflyapi.blog.enums.CodeMsgEnum;

/**
 * @author: qfwang
 * @date: 2018-12-13 11:08 AM
 */
public class FlyapiException extends RuntimeException {

    private CodeMsgEnum codeMsgEnum;

    public FlyapiException(CodeMsgEnum codeMsgEnum) {
        this.codeMsgEnum = codeMsgEnum;
    }

    public CodeMsgEnum getCodeMsgEnum() {
        return codeMsgEnum;
    }

    public void setCodeMsgEnum(CodeMsgEnum codeMsgEnum) {
        this.codeMsgEnum = codeMsgEnum;
    }
}
