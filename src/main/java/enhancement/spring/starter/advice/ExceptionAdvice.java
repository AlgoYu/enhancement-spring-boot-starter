package enhancement.spring.starter.advice;

import enhancement.spring.starter.model.BaseResponse;
import enhancement.spring.starter.model.ConditionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author XiaoYu
 * @Description TODO 异常处理
 * @Date 2021/6/4 1:31 下午
 * @Email 794763733@qq.com
 */
@ControllerAdvice
public class ExceptionAdvice {
    /**
     * @Author XiaoYu
     * @Description TODO 对接口的报错异常进行处理
     * @Datetime 2021/6/4 1:33 下午
     * @Param []
     * @Return java.lang.Object
     **/
    @ExceptionHandler(value = Exception.class)
    public Object exceptionHandler(Exception e) {
        if (e instanceof ConditionException) {
            ConditionException exception = (ConditionException) e;
            return new BaseResponse<>("FAIL", exception.getCode(), exception.getMsg());
        }
        return BaseResponse.FAIL;
    }
}
