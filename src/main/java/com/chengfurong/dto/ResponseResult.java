package com.chengfurong.dto;

public class ResponseResult {

    /**
     * 状态码
     */
    private Integer status;
    /**
     * 提示消息
     */
    private String message;
    /**
     * 应答内容
     */
    private Object data;
    /**
     * 应答分页
     */
    private PageEntity page;

    public static ResponseResult ok(){
        ResponseResult result = new ResponseResult();
        result.status=0;
        result.message="success";
        return result;
    }

    public static ResponseResult ok(Object data){
        ResponseResult result = new ResponseResult();
        result.status=0;
        result.message="success";
        result.data = data;
        return result;
    }
    public static ResponseResult ok(Object data, PageEntity page){
        ResponseResult result = new ResponseResult();
        result.status=0;
        result.message="success";
        result.data = data;
        result.page = page;
        return result;
    }

    public static ResponseResult failed(){
        ResponseResult result = new ResponseResult();
        result.status=-1;
        result.message="failed";
        return result;
    }
    public static ResponseResult failed(String msg){
        ResponseResult result = new ResponseResult();
        result.status=-1;
        result.message=msg;
        return result;
    }

    public static ResponseResult failed(Integer code,String msg){
        ResponseResult result = new ResponseResult();
        result.status=-1;
        result.message=msg;
        return result;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public PageEntity getPage() {
        return page;
    }

    public void setPage(PageEntity page) {
        this.page = page;
    }
}
