package org.sofka.radar.service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.sofka.radar.document.UserDocument;
import org.sofka.radar.model.User;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.KeyPair;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtHelper {

    private KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);

    public String createJwt(UserDocument user){
        Map<String, String> map = new HashMap<>();
        map.put("name", user.getName());
        map.put("rol", user.getRole());
        return Jwts.builder()
                .setClaims(map)
                .signWith(keyPair.getPrivate(), SignatureAlgorithm.RS256 )
                .setSubject(user.getIdentification())
                .setIssuer("identity")
                .setExpiration(Date.from(Instant.now().plus(Duration.ofHours(1))))
                .setIssuedAt(Date.from(Instant.now()))
                .compact();
    }
   /* private final static int TIME_JWT_EXPIRE = 6 * 60 * 60;

    private final static String JWT_SECRET = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=";




    public String createJWT(Map<String, Object> claims, int time, String uid){
           SecretKey key = encodeKey();SignatureAlgorithm signatureAlg = SignatureAlgorithm.ES256;
          // Key key = Keys.secretKeyFor(signatureAlg);
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

    public String generateLoginToken(UserDocument user){
        Map<String, Object> map = new HashMap<>();
        map.put("name", user.getName());
        map.put("rol", user.getRole());
        map.put("email", user.getEmail());
        return createJWT(map, TIME_JWT_EXPIRE, user.getIdentification() );
    }
*/

}
