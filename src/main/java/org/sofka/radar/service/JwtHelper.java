package org.sofka.radar.service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.sofka.radar.model.User;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtHelper {
    private final static int TIME_JWT_EXPIRE = 6 * 60 * 60;

    private final static String JWT_SECRET = "RadarSofKaU2022LigasEntreNamiento";

    private final SignatureAlgorithm signatureAlg = SignatureAlgorithm.ES256;


    public String createJWT(Map<String, Object> claims, int time, String uid){
           SecretKey key = encodeKey();
       return    Jwts.builder()
               .setClaims(claims)
               .setId(uid)
               .setIssuedAt(new Date(System.currentTimeMillis()))
               .signWith(key, signatureAlg)
               .setExpiration(new Date(System.currentTimeMillis() + time))
               .compact();
    }

    private SecretKey encodeKey() {
        byte[] encodeKey = Base64.getDecoder().decode(JWT_SECRET);
        return  new SecretKeySpec(encodeKey, 0 , encodeKey.length, "AES");
    }

    public String generateLoginToken(User user){
        Map<String, Object> map = new HashMap<>();
        map.put("name", user.getName());
        map.put("rol", user.getRole());
        map.put("email", user.getEmail());
        return createJWT(map, TIME_JWT_EXPIRE, user.getId() );
    }


}
