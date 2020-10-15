package ct.com.lxkj.dao;

import ct.com.lxkj.entitys.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User findUserByUsername(String username);
}
