package ct.com.lxkj.util;

import ct.com.lxkj.exception.TokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;


public class JwtTokenUtils {

    public static final String TOKEN_HEADER = "token";
    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String SECRET = "jwtsecretdemo";
    public static final String ISS = "echisan";

    public static String LOGIN_USER = "login_user";

    // 过期时间是3600秒，既是1个小时
    private static final long EXPIRATION = Integer.MAX_VALUE;


    // 创建token
    public static String createToken(Integer userId, String username) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", userId);
        map.put("username", username);
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setClaims(map)
                .setIssuer(ISS)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION * 1000))
                .compact();
    }

    public static Integer getUserId(String token) {
        return ((Integer) getTokenBody(token).get("userId"));
    }

    public static String getUsername(String token) {
        return getTokenBody(token).get("username").toString();
    }

    // 是否已过期
    public static boolean isExpiration(String token) {
        return getTokenBody(token).getExpiration().before(new Date());
    }

    private static Claims getTokenBody(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new TokenException("token过期");
        } catch (Exception e) {
            throw new TokenException("token错误");
        }
    }

    public static void main(String[] args) {
//        String admin = JwtTokenUtils.createToken(123L, "admin");
//        System.out.println(admin);

    }
}
