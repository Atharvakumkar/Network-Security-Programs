import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class AESExample {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Plain Text: ");
        String plainText = sc.nextLine();

        // AES key must be 16 characters (128 bits)
        String key = "1234567890123456";

        SecretKeySpec secretKey =
                new SecretKeySpec(key.getBytes(), "AES");

        // Encryption
        Cipher encryptCipher = Cipher.getInstance("AES");
        encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encrypted =
                encryptCipher.doFinal(plainText.getBytes());

        String encryptedText =
                Base64.getEncoder().encodeToString(encrypted);

        System.out.println("Encrypted Text: " + encryptedText);

        // Decryption
        Cipher decryptCipher = Cipher.getInstance("AES");
        decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] decrypted =
                decryptCipher.doFinal(
                        Base64.getDecoder().decode(encryptedText)
                );

        String decryptedText = new String(decrypted);

        System.out.println("Decrypted Text: " + decryptedText);

        sc.close();
    }
}
