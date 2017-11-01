package com.converter;

import java.io.Serializable;

/**
 * 返回通用格式数据
 */
public class CommonResponse<T> implements Serializable {
    private static final long serialVersionUID = 3713874654852996944L;
    //返回状态码
    private String code;
    //数据
    private T value;

    //返回状态码描述
    private String message;
    //返回状态 true正确 false出错
    private boolean returnStatus;

    /**
     * 调用的方法名
     */
    private String methodName;

    /**
     * 数据库操作动作update/delete/insert
     */
    private String mark;

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public boolean isReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(boolean returnStatus) {
        this.returnStatus = returnStatus;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "code='" + code + '\'' +
                ", value=" + value +
                ", message='" + message + '\'' +
                ", returnStatus=" + returnStatus +
                ", methodName='" + methodName + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }
}
