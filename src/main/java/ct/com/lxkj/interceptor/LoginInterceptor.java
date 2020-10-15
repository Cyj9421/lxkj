package ct.com.lxkj.interceptor;

import ct.com.lxkj.exception.TokenException;
import ct.com.lxkj.util.JwtTokenUtils;
import ct.com.lxkj.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;
import static ct.com.lxkj.util.JwtTokenUtils.LOGIN_USER;
import static ct.com.lxkj.util.JwtTokenUtils.TOKEN_HEADER;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);
        String tokenHeader = request.getHeader(TOKEN_HEADER);
        String token = tokenHeader.replace(JwtTokenUtils.TOKEN_PREFIX, "");
        Integer userId = JwtTokenUtils.getUserId(token);
        if (userId != null) {
            Boolean hasKey = stringRedisTemplate.hasKey(LOGIN_USER + ":token:" + userId);
            if (hasKey != null && !hasKey) {
                throw new TokenException("token失效");
            }
            stringRedisTemplate.opsForValue().set(LOGIN_USER + ":token:" + userId, token, 1, TimeUnit.HOURS);
            ThreadLocalUtil.set(userId);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        ThreadLocalUtil.remove();
    }
}
