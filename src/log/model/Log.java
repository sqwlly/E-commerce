package log.model;
import java.util.Date;

/**
 * @描述：日志
 * @创建者：程新状
 * @创建日期：2020/4/26
 */

public class Log {

    private String level;       //日志级别
    private String stackTrace;  //堆栈信息
    private String message;     //日志消息
    private Date createdTime;   //创建时间

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
