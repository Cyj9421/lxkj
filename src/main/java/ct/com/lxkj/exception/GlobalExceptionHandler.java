package ct.com.lxkj.exception;

import ct.com.lxkj.Vo.Resp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TokenException.class)
    public Resp handleTokenException(TokenException e) {
        Resp resp=new Resp("401","请求超时",e.getMessage());
        return resp;
    }

    @ExceptionHandler(LoginException.class)
    public Resp handleLoginException(LoginException e) {
        Resp resp=new Resp("402","登录超时",e.getMessage());
        return resp;
    }

    @ExceptionHandler(Exception.class)
    public Resp handleException(Exception e) {
        Resp resp=new Resp("500","错误",e.getMessage());
        return resp;
    }

}
