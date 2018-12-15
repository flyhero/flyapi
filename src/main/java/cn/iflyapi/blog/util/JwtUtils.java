package cn.iflyapi.blog.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {

    private final static Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    //一个月
    private static long EXPIRED_TIME = 60 * 60 * 24 * 30;

    private static String key = "secret";

    public static String getToken(Long userId, String nickName) throws Exception {
        Map<String, Object> mapHeader = new HashMap<>(2);
        mapHeader.put("alg", "HS256");
        mapHeader.put("typ", "JWT");
        long iat = System.currentTimeMillis();
        long exp = iat + EXPIRED_TIME * 1000L;
        return JWT.create()
                .withHeader(mapHeader)
                .withIssuedAt(new Date(iat))
                .withExpiresAt(new Date(exp))
                .withClaim("userId", String.valueOf(userId))
                .withClaim("nickName", nickName)
                .sign(Algorithm.HMAC256(key));
    }

    public static Map<String, Claim> verify(String token) {
        DecodedJWT jwt;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(key)).build();
            jwt = verifier.verify(token);
            Map<String, Claim> claims = jwt.getClaims();
            return jwt.getClaims();
        } catch (Exception ex) {
            logger.error("verify jwt token failed, token={}", token, ex);
            return null;
        }

    }


/*    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("userName", "flyhero");
        try {
            String t = getToken(map);
            Thread.sleep(10000);
            verify(t);
        } catch (InvalidClaimException e) {
            System.out.println("InvalidClaimException");
        } catch (SignatureVerificationException e) {
            System.out.println("SignatureVerificationException");
        } catch (Exception e) {

        }
    }*/
}
