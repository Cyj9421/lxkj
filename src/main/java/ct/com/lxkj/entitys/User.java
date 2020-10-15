package ct.com.lxkj.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int user_id;        //用户id
    private String username;    //用户名
    private String password;    //密码

}
