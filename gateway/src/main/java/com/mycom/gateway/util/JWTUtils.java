package com.mycom.gateway.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：songdalin
 * @date ：2022-4-20 下午 04:27
 * @description：jwt工具类
 * @modified By：
 * @version: 1.0
 */
public class JWTUtils {

    // token 签名的秘钥，可设置到配置文件中
    private static final String SECRET_KEY = "secretKey:123456";
    // token过期时间 10min
    public static final long TOKEN_EXPIRE_TIME = 10 * 60 * 1000;

    /**
     * 生成jwt
     */
    public static String createJwt(String userId){
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        //设置头信息
        HashMap<String, Object> header = new HashMap<>(2);
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        // 生成 token：头部+载荷+签名
        return JWT.create().withHeader(header)
                .withClaim("USER_ID", userId)
                .withExpiresAt(new Date(System.currentTimeMillis()+TOKEN_EXPIRE_TIME)).sign(algorithm);
    }

    /**
     * 解析jwt
     */
    public static Map<String, Claim> parseJwt(String token) {
        Map<String, Claim> claims = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            claims = jwt.getClaims();
            return claims;
        } catch (Exception e) {
            return null;
        }
    }
}