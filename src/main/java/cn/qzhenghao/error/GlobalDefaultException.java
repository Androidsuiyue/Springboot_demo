package cn.qzhenghao.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author suiyue
 * @ClassName GlobalDefaultException
 * @Description TODO
 * @date 2019/1/8 16:19
 */
@ControllerAdvice(basePackages = {"package cn.qzhenghao",})
public class GlobalDefaultException {
    @ExceptionHandler({BussinessException.class})
    @ResponseBody
    public ErrorInfo defaultErrorHandler(HttpServletRequest httpServletRequest,Exception e) throws Exception{
        ErrorInfo<Object> objectErrorInfo = new ErrorInfo<>();
        objectErrorInfo.setMessage(e.getMessage());
        objectErrorInfo.setUrl(httpServletRequest.getRequestURI());
        objectErrorInfo.setCode(ErrorInfo.SUCCESS);
        return objectErrorInfo;
    }

}

