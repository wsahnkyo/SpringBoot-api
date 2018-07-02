package com.example.ahn.pojo;

public class ResultData {

    // 返回状态
    private boolean success;
    // 错误中文描述 比如 "正常"，"日期格式不正确"， "缺少permit参数"
    private String message;
    // 返回数据
    private Object data;

    public ResultData() {
    }

    public ResultData(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}