package enhancement.spring.starter.advice;

import enhancement.spring.starter.annotation.API;
import enhancement.spring.starter.model.BaseResponse;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.annotation.Annotation;

/**
 * @ClassName: BaseResponseAdvice
 * @Description: TODO 对HTTP返回值进行处理
 * @Author XiaoYu
 * @Datetime 2021/5/30 11:09 下午
 */
@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    // TODO API注解的类型
    private static final Class<? extends Annotation> API_ANNOTATION_TYPE = API.class;

    /**
     * @Author XiaoYu
     * @Description TODO
     * @Datetime 2021/5/30 11:25 下午
     * @Param [returnType, converterType]
     * @Return boolean
     **/
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.hasMethodAnnotation(API_ANNOTATION_TYPE) || AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), API_ANNOTATION_TYPE);
    }

    /**
     * @Author XiaoYu
     * @Description TODO 返回前
     * @Datetime 2021/5/30 11:31 下午
     * @Param [body, returnType, selectedContentType, selectedConverterType, request, response]
     * @Return java.lang.Object
     **/
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // TODO 防止重复包裹
        if (body instanceof BaseResponse) {
            return body;
        }
        return BaseResponse.success(body);
    }
}
