package cn.qzhenghao.error;

/**
 * @author suiyue
 * @ClassName ErrorInfo
 * @Description TODO
 * @date 2019/1/8 16:13
 */



public class ErrorInfo<T> {
    public static final Integer SUCCESS=200;
    public static final Integer ERROR=100;
    private Integer code;
    private String message;
    private String url;
    private T data;

    public ErrorInfo() {
    }

    @Override
    public String toString() {
        return "ErrorInfo{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", url='" + url + '\'' +
                ", data=" + data +
                '}';
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static Integer getSUCCESS() {

        return SUCCESS;
    }

    public static Integer getERROR() {
        return ERROR;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getUrl() {
        return url;
    }

    public T getData() {
        return data;
    }
}
