package ct.com.lxkj.controller;


import ct.com.lxkj.Vo.Resp;
import ct.com.lxkj.Vo.UserVo;
import ct.com.lxkj.entitys.User;
import ct.com.lxkj.service.UserService;
import ct.com.lxkj.util.JwtTokenUtils;
import ct.com.lxkj.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static ct.com.lxkj.util.JwtTokenUtils.LOGIN_USER;


@RestController
public class LoginController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    UserService userService;
    @PostMapping("/api/lxkj/login")
    public Resp login(@RequestBody UserVo userVo) {
        User user = userService.login(userVo);
        String jwt = JwtTokenUtils.createToken(user.getUser_id(),user.getUsername());
        stringRedisTemplate.opsForValue().set(LOGIN_USER + ":token:" + 1, jwt, 1, TimeUnit.HOURS);
        Map<String,Object> map=new HashMap<>();
        map.put("token",jwt);
        map.put("user",user);
        Resp resp=new Resp("200","登录成功",map);
        return resp;
    }

    @PostMapping("/api/lxkj/logout")
    public Resp login() {
        Integer userId = UserUtils.getUserId();
        stringRedisTemplate.delete(LOGIN_USER + ":token:" + userId);
        Resp resp =new Resp("200","登出成功",null);
        return resp;
    }

    @PostMapping("/api/lxkj/test")
    public Object test() {
        return "test";
    }



}
