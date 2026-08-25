
import java.util.*;

class Practical1a {

    public static void main(String args[]) {

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String key = "QWERTYUIOPASDFGHJKLZXCVBNM";

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter string");
        String text = sc.next();

        String cipher = "";

        // Encryption
        for (int i = 0; i < text.length(); i++) {
            char ch = Character.toUpperCase(text.charAt(i));
            int index = alphabet.indexOf(ch);
            cipher = cipher + key.charAt(index);
        }

        System.out.println("Cipher: " + cipher);

        // Decryption
        String plain = "";

        for (int i = 0; i < cipher.length(); i++) {
            char ch = cipher.charAt(i);
            int index = key.indexOf(ch);
            plain = plain + alphabet.charAt(index);
        }

        System.out.println("Plain Text: " + plain);

        sc.close();
    }
}
