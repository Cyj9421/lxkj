package ct.com.lxkj.Vo;

import lombok.Data;

@Data
public class Resp<E> {
    private String  code;  // 200成功  505失败   401请求超时   402登录超时
    private String  message;
    private E data;

   public Resp(String  code,String  message,E data){
        this.code=code;
        this.message=message;
        this.data=data;
    }
    public static <E>Resp<E> success(E data){
        return new Resp("200","成功",data);
    }
    public static <E>Resp<E> error(String  code,String  message,E data){
        return new Resp("505","失败",data);
    }
    public static <E>Resp<E> Time(String  code,String  message,E data){
        return new Resp("401","超时",data);
    }

}
