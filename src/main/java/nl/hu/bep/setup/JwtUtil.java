package nl.hu.bep.setup;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.SecureRandom;

import java.util.Base64;
import java.util.Date;

public class JwtUtil {

    private static final String SECRET_KEY = generateRandomKey();

    private static String generateRandomKey() {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[32]; // 32 bytes = 256 bits
        random.nextBytes(key);
        return Base64.getEncoder().encodeToString(key);
    }

    public static String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 dag geldig
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static String validateToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
