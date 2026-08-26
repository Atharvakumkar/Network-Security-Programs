import java.util.*;

public class ColumnarCipher {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Plain Text: ");
        String text = sc.nextLine().replace(" ", "");

        System.out.print("Enter Key: ");
        String key = sc.nextLine();

        encrypt(text, key);

        sc.close();
    }

    static void encrypt(String text, String key) {

        int col = key.length();
        int row = (int) Math.ceil((double) text.length() / col);

        char[][] matrix = new char[row][col];

        int k = 0;

        // Fill matrix row-wise
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (k < text.length()) {
                    matrix[i][j] = text.charAt(k++);
                } else {
                    matrix[i][j] = 'X';
                }
            }
        }

        // Create array of key characters with their original positions
        Character[] keyChars = new Character[col];

        for (int i = 0; i < col; i++) {
            keyChars[i] = key.charAt(i);
        }

        // Sort key characters alphabetically
        Character[] sorted = keyChars.clone();
        Arrays.sort(sorted);

        StringBuilder cipher = new StringBuilder();

        boolean[] used = new boolean[col];

        // Read columns according to sorted key order
        for (char ch : sorted) {
            for (int c = 0; c < col; c++) {

                if (!used[c] && key.charAt(c) == ch) {

                    for (int r = 0; r < row; r++) {
                        cipher.append(matrix[r][c]);
                    }

                    used[c] = true;
                    break;
                }
            }
        }

        System.out.println("Encrypted Text: " + cipher);
    }
}
