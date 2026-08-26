import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class DESExample {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Plain Text: ");
        String plainText = sc.nextLine();

        // DES key must be 8 characters (64 bits)
        String key = "12345678";

        SecretKeySpec secretKey =
                new SecretKeySpec(key.getBytes(), "DES");

        // Encryption
        Cipher encryptCipher = Cipher.getInstance("DES");
        encryptCipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encrypted =
                encryptCipher.doFinal(plainText.getBytes());

        String encryptedText =
                Base64.getEncoder().encodeToString(encrypted);

        System.out.println("Encrypted Text: " + encryptedText);

        // Decryption
        Cipher decryptCipher = Cipher.getInstance("DES");
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
