package com.flyhero.flyapi.entity;

public class InterfaceWithBLOBs extends Interface {
    private String param;

    private String requestexam;

    private String responseparam;

    private String trueexam;

    private String falseexam;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param == null ? null : param.trim();
    }

    public String getRequestexam() {
        return requestexam;
    }

    public void setRequestexam(String requestexam) {
        this.requestexam = requestexam == null ? null : requestexam.trim();
    }

    public String getResponseparam() {
        return responseparam;
    }

    public void setResponseparam(String responseparam) {
        this.responseparam = responseparam == null ? null : responseparam.trim();
    }

    public String getTrueexam() {
        return trueexam;
    }

    public void setTrueexam(String trueexam) {
        this.trueexam = trueexam == null ? null : trueexam.trim();
    }

    public String getFalseexam() {
        return falseexam;
    }

    public void setFalseexam(String falseexam) {
        this.falseexam = falseexam == null ? null : falseexam.trim();
    }
}