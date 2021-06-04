package enhancement.spring.starter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: API
 * @Description: TODO 用于HTTP方法或者返回值上的注解
 * @Author XiaoYu
 * @Datetime 2021/5/30 10:03 下午
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.METHOD})
public @interface API {
}
