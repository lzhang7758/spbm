package com.zl.spbm;

import com.auth0.jwt.interfaces.Claim;
import com.zl.spbm.utils.JwtToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

/**
 * @Author: lzhang
 * @Date: 2019/6/13 13:15
 */
public class JWTTest {

    @Test
    public void JwtBuilder(){
        JwtBuilder builder = Jwts.builder()
                .setId("001")
                .setSubject("lufei")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "demaxiya");
        System.out.println(builder.compact());
    }

    @Test
    public void parser(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIwMDEiLCJzdWIiOiJsdWZlaSIsImlhdCI6MTU2MDQwNDE4NX0.gU4tsE40VmtrBp8xOmZeSlk2Bk4mi0PeuJMuI9UC-kw";
        Claims claims = Jwts.parser().setSigningKey("demaxiya").parseClaimsJws(token).getBody();
        System.out.println("id:" + claims.getId());
        System.out.println("subject:" + claims.getSubject());
        System.out.println("IssuedAt:" + claims.getIssuedAt());
    }

    @Test
    public void JwtBuilderExpiration(){
        Long now = System.currentTimeMillis();
        //过期时间1分钟
        Long expiration = now + 1000 * 60;
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("002")
                .setSubject("suoLong")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "demaxiya")
                .setExpiration(new Date(expiration))
                .claim("roles", "admin")
                .claim("logo", "suoLong.jpg");
        System.out.println(jwtBuilder.compact());
    }

    @Test
    public void parserJwtBuilderExpration(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIwMDIiLCJzdWIiOiJzdW9Mb25nIiwiaWF0IjoxNTYwNDA2MTA5LCJleHAiOjE1NjA0MDYxNjgsInJvbGVzIjoiYWRtaW4iLCJsb2dvIjoic3VvTG9uZy5qcGcifQ.RR3YrZqVn-686cIweVYsZcawVP-rfEfgINowP2JTXgM";
        Claims claims = Jwts.parser().setSigningKey("demaxiya").parseClaimsJws(token).getBody();
        System.out.println("id = " + claims.getId());
        System.out.println("subject = " + claims.getSubject());
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        System.out.println("签发时间：" + sdf.format(claims.getIssuedAt()));
        System.out.println("过期时间：" + sdf.format(claims.getExpiration()));
        System.out.println("当前时间：" + DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss").format(LocalDateTime.now()));
        System.out.println("roles" + claims.get("roles"));
        System.out.println("logo" + claims.get("logo"));
    }

    @Test
    public void JwtTokenTest() throws Exception {
        String token = JwtToken.createToken(1220L,"jack");
        System.out.println(token);
        Map<String, Claim> very = JwtToken.verifyToken(token);
        very.forEach((k, v) -> {
            System.out.println(k + ":" + v.asString());
        });
        System.out.println("AppUID = " + JwtToken.getAppUID(token));
    }

}
