package cc.cleverfan.module;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Created by chengfan on 2017/6/4.
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ReturnCode {

    SUCCESS(1, "SUCCESS");

    private int rerurnId;
    private String message;

    ReturnCode(int i, String msg) {
        this.rerurnId = i;
        this.message = msg;
    }

    public int getRerurnId() {
        return rerurnId;
    }

    public String getMessage() {
        return message;
    }

    public void setRerurnId(int rerurnId) {
        this.rerurnId = rerurnId;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
