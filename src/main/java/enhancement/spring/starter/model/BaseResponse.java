package enhancement.spring.starter.model;

import lombok.Data;

import javax.lang.model.type.NullType;

/**
 * @ClassName: HttpResponse
 * @Description: TODO API接口统一返回类
 * @Author XiaoYu
 * @Datetime 2021/5/30 9:30 下午
 */
@Data
public class BaseResponse<T> {
    // TODO 成功代码
    private String code;
    // TODO 信息
    private String msg;
    // TODO 数据
    private T data;

    // TODO 成功
    public static final BaseResponse<NullType> SUCCESS = new BaseResponse<>("SUCCESS", null, null);
    // TODO 失败
    public static final BaseResponse<NullType> FAIL = new BaseResponse<>("FAIL", null, null);
    // TODO 服务器忙
    public static final BaseResponse<NullType> SERVER_BUSY = new BaseResponse<>("FAIL", null, null);

    public BaseResponse() {
    }

    public BaseResponse(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * @Author XiaoYu
     * @Description TODO 是否成功
     * @Datetime 2021/5/30 10:01 下午
     * @Param []
     * @Return java.lang.Boolean
     **/
    public Boolean isSuccess() {
        return "SUCCESS".equals(code);
    }

    /**
     * @Author XiaoYu
     * @Description TODO 构建成功数据对象
     * @Datetime 2021/5/30 11:36 下午
     * @Param [object]
     * @Return cn.algorithm.www.model.BaseResponse<java.lang.Object>
     **/
    public static BaseResponse<Object> success(Object object) {
        return new BaseResponse<>("SUCCESS", null, object);
    }

    /**
     * @Author XiaoYu
     * @Description TODO 构建失败数据对象
     * @Datetime 2021/5/30 11:36 下午
     * @Param [object]
     * @Return cn.algorithm.www.model.BaseResponse<java.lang.Object>
     **/
    public static BaseResponse<Object> fail(String msg) {
        return new BaseResponse<>("FAIL", msg, null);
    }
}
