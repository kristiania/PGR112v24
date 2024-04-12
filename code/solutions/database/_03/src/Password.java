package solutions.database._03.src;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Password
{
    public static String hash(String value) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            byte[] bytes = algorithm.digest(value.getBytes(StandardCharsets.UTF_8));

            return Base64.getEncoder().encodeToString(bytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Fant ikke SHA-256 algoritme som kunne brukes!");
        }
    }
}
