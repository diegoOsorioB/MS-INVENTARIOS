package MS_Inventarios.Inventarios.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Base64;

public class JwtUtil {
    private static final String SECRET = "S3lUd1p3aXhXWnZxVjNrZFRzRW4zR1l4cXBaVjhpV3hCUXlqV1lYcGh0ZA==";

    private Key secretKey()
    {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public Claims parseToken(String token)
    {
        token=token.trim();
        return Jwts.parserBuilder()
                .setSigningKey(secretKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String getUsername(String token)
    {
        return parseToken(token).getSubject();
    }
}
