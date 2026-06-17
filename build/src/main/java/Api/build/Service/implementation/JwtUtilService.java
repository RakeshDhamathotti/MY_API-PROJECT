<<<<<<< HEAD
package Api.build.Service.implementation;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

// import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import Api.build.Service.JwtService;
import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtUtilService implements JwtService{
    

    private final String SECRET="my-secure-key-my-secure-key-123456";
    // private final Environment env;


    // JwtUtilService(Environment env) {
    //     this.env = env;
    // }


    private Key getKey()
    {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }




    @Override
    public String generateToken(String Username)
    {
        return Jwts.builder()
        .subject(Username)
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis()+1000*60*30))
        .signWith(getKey())
        .compact();
    }

    @Override
    public String extractUserName(String token)
    {
        return Jwts.parser()
            .verifyWith((SecretKey) getKey())
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getSubject();
    }
    

    @Override
    public boolean validatToken(String token, UserDetails userDetails) {
       return extractUserName(token).equals(userDetails.getUsername());
    }
}
=======
package Api.build.Service.implementation;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

// import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import Api.build.Service.JwtService;
import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtUtilService implements JwtService{
    

    private final String SECRET="my-secure-key-my-secure-key-123456";
    // private final Environment env;


    // JwtUtilService(Environment env) {
    //     this.env = env;
    // }


    private Key getKey()
    {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }




    @Override
    public String generateToken(String Username)
    {
        return Jwts.builder()
        .subject(Username)
        .issuedAt(new Date())
        .expiration(new Date(System.currentTimeMillis()+1000*60*30))
        .signWith(getKey())
        .compact();
    }

    @Override
    public String extractUserName(String token)
    {
        return Jwts.parser()
            .verifyWith((SecretKey) getKey())
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getSubject();
    }
    

    @Override
    public boolean validatToken(String token, UserDetails userDetails) {
       return extractUserName(token).equals(userDetails.getUsername());
    }
}
>>>>>>> 606cd7d39036706b88a9651523fd3ec9a3d8ac67
