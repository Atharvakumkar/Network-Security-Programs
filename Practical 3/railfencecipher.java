import java.util.*;

public class RailFenceCipher {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Plain Text: ");
        String text = sc.nextLine();

        System.out.print("Enter Number of Rails: ");
        int key = sc.nextInt();

        System.out.println("Encrypted Text: " + encrypt(text, key));

        sc.close();
    }

    static String encrypt(String text, int key) {

        if (key <= 1) {
            return text;
        }

        StringBuilder[] rail = new StringBuilder[key];

        for (int i = 0; i < key; i++) {
            rail[i] = new StringBuilder();
        }

        int row = 0;
        boolean down = true;

        for (char ch : text.toCharArray()) {
            rail[row].append(ch);

            if (row == 0) {
                down = true;
            } else if (row == key - 1) {
                down = false;
            }

            row += down ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder sb : rail) {
            result.append(sb);
        }

        return result.toString();
    }
}
