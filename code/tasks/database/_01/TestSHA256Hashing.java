package tasks.database._01;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class TestSHA256Hashing
{
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String input = "password";

        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte[] bytes = algorithm.digest(input.getBytes(StandardCharsets.UTF_8));

        String output = Base64.getEncoder().encodeToString(bytes);

        System.out.println(output);
    }
}
