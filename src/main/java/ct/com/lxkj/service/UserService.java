package ct.com.lxkj.service;

import ct.com.lxkj.Vo.UserVo;
import ct.com.lxkj.entitys.User;

public interface UserService {
    User login(UserVo userVo);
}
