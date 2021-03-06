package enhancement.spring.starter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author XiaoYu
 * @Description TODO 增强功能启动注解
 * @Date 2021/6/4 12:16 下午
 * @Email 794763733@qq.com
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface EnableEnhancement {
    // TODO 是否开启增强
    boolean value() default true;
}
