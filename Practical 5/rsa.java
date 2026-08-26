import java.math.BigInteger;
import java.util.Scanner;

public class RSAExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Plain Text: ");
        String text = sc.nextLine();

        // Two prime numbers
        BigInteger p = new BigInteger("61");
        BigInteger q = new BigInteger("53");

        // Calculate n and phi
        BigInteger n = p.multiply(q);

        BigInteger phi = p.subtract(BigInteger.ONE)
                .multiply(q.subtract(BigInteger.ONE));

        // Public key
        BigInteger e = new BigInteger("17");

        // Private key
        BigInteger d = e.modInverse(phi);

        System.out.println("Public Key: (" + e + ", " + n + ")");
        System.out.println("Private Key: (" + d + ", " + n + ")");

        // Encryption
        System.out.print("Encrypted Text: ");

        String[] encrypted = new String[text.length()];

        for (int i = 0; i < text.length(); i++) {

            BigInteger m =
                    BigInteger.valueOf((int) text.charAt(i));

            encrypted[i] =
                    m.modPow(e, n).toString();

            System.out.print(encrypted[i] + " ");
        }

        System.out.println();

        // Decryption
        System.out.print("Decrypted Text: ");

        for (String value : encrypted) {

            BigInteger c = new BigInteger(value);

            BigInteger m =
                    c.modPow(d, n);

            System.out.print((char) m.intValue());
        }

        System.out.println();

        sc.close();
    }
}
