package enhancement.spring.starter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author XiaoYu
 * @Description TODO 开启增强
 * @Date 2021/6/4 12:16 下午
 * @Email 794763733@qq.com
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface EnableEnhancement {
    boolean value() default true;
}
