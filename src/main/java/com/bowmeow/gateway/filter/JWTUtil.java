package com.bowmeow.gateway.filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JWTUtil {

    @Value("${jwt.secret-key}")
    private static String secretKey;

    private JWTUtil() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void validateToken( String token) {
        try {
            Jwts.parser()
                    .setSigningKey( secretKey )
                    .parseClaimsJws( token )
                    .getBody();
        } catch (SignatureException | MalformedJwtException | ExpiredJwtException | UnsupportedJwtException e) {
            throw new RuntimeException("Invalid or expired token");
        }
    }
}
