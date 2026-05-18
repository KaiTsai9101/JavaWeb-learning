package chapter1.test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    // 生成JWT令牌
    @Test
    public void testGenerate() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id", 1);
        dataMap.put("username", "admin");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "VGhpcyBpcyBhIGtleSBiYXNlZCBvbiBCYXNlNjQgZW5jcnlwdGlvbg==")   // 指定加密签名算法，密钥
                .addClaims(dataMap)     // 添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))      // 设置过期时间（System.currentTimeMillis()为当前系统时间戳，单位：毫秒）
                .compact();     // 生成JWT令牌

        System.out.println(jwt);
    }

    // 解析JWT令牌
    @Test
    public void testParseJWT() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTc3ODc4MTk3MX0.37QmZqvNScRiKY6CYJfMUmLD5vtspgeFjkEFrgjqbC0";
        Claims claims = Jwts.parser().setSigningKey("VGhpcyBpcyBhIGtleSBiYXNlZCBvbiBCYXNlNjQgZW5jcnlwdGlvbg==")   // 指定密钥（需要与加密密钥的一致）
                .parseClaimsJws(token)      // 解析令牌
                .getBody();     // 获取自定义信息
        System.out.println(claims);
    }
}
