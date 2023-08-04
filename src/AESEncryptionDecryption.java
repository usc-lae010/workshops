import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class AESEncryptionDecryption {

    public static void main(String[] args) {
        try {
            // Generate a true random encryption key
            byte[] encryptionKey = generateTrueRandomKey();

            String originalMessage = "This is a secret message,Perth380*145 but you can read now.";

            // Encrypt the message
            String encryptedMessage = encrypt(originalMessage, encryptionKey);
            System.out.println("Encrypted Message: " + encryptedMessage);

            // Decrypt the message
            String decryptedMessage = decrypt(encryptedMessage, encryptionKey);
            System.out.println("Decrypted Message: " + decryptedMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] generateTrueRandomKey() throws NoSuchAlgorithmException {
        // Create a secure random object
        SecureRandom secureRandom = SecureRandom.getInstanceStrong();
        byte[] key = new byte[16]; // AES-128 key size
        secureRandom.nextBytes(key);
        return key;
    }

    public static String encrypt(String message, byte[] encryptionKey) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(encryptionKey, "AES");
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);

            byte[] encryptedBytes = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String encryptedMessage, byte[] encryptionKey) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(encryptionKey, "AES");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);

            byte[] decodedBytes = Base64.getDecoder().decode(encryptedMessage);
            byte[] decryptedBytes = cipher.doFinal(decodedBytes);
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
