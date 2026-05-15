package chapter1.test.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static final String SECRET_KEY = "VGhpcyBpcyBhIGtleSBiYXNlZCBvbiBCYXNlNjQgZW5jcnlwdGlvbg==";    // 密钥
    private static final long EXPIRATION_TIME = 12 * 60 * 60 * 1000;        // 12h

    /*
     * 生成JWT令牌
     *
     * @param claims 自定义信息
     * @return JWT令牌
     */
    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)   // 签名算法，密钥
                .addClaims(claims)     // 添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))      // 设置过期时间
                .compact();     // 生成JWT令牌
    }

    /*
     * 解析JWT令牌
     *
     * @param token JWT令牌
     * @return 自定义信息
     */
    public static Claims parseToken(String token) throws Exception{
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)   // 密钥
                .parseClaimsJws(token)      // 解析令牌
                .getBody();     // 获取自定义信息
    }
}
