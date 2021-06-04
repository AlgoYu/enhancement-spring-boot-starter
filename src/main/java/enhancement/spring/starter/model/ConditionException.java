package enhancement.spring.starter.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author XiaoYu
 * @Description TODO
 * @Date 2021/6/4 1:46 下午
 * @Email 794763733@qq.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConditionException extends RuntimeException {
    private String code;
    private String msg;
}
