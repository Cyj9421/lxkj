package ct.com.lxkj.service.impl;

import ct.com.lxkj.Vo.UserVo;
import ct.com.lxkj.dao.UserDao;
import ct.com.lxkj.entitys.User;
import ct.com.lxkj.exception.LoginException;
import ct.com.lxkj.service.UserService;
import ct.com.lxkj.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(UserVo userVo) {
        String username = userVo.getUsername();
        if (!StringUtils.isEmpty(username)) {
            User user = userDao.findUserByUsername(username);
            if (user == null) {
                throw new LoginException("用户不存在");
            }
            String dbPassword = user.getPassword();
            String password = MD5Utils.md5(userVo.getPassword());
            if (!dbPassword.equals(password)) {
                throw new LoginException("密码错误");
            }
            return user;
        }
        return null;
    }
}
