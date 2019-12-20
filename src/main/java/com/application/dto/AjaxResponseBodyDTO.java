package com.application.dto;

import java.util.ArrayList;
import java.util.List;

public class AjaxResponseBodyDTO {

    String msg;
    List<Object> result;

    public AjaxResponseBodyDTO() {
        result = new ArrayList<>();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Object> getResult() {
        return result;
    }

    public void setResult(List<Object> result) {
        this.result = result;
    }
}