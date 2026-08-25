import java.util.*;

class Practical2a{
    static char[][] matrix = new char[5][5];

    static void generateMatrix(String key){
        String s = "";
        key = key.toUpperCase().replace("J", "I");

        for(char ch : key.toCharArray()){
            if(ch >= 'A' && ch <= 'Z' && s.indexOf(ch) == -1)
                s += ch;
        }

        for(char ch = 'A'; ch <= 'Z'; ch++){
            if(ch == 'J') continue;
            if(s.indexOf(ch) == -1) s += ch;
        }

        int k = 0;
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++)
                matrix[i][j] = s.charAt(k++);
    }

    static int[] find(char ch){
        if(ch == 'J') ch = 'I';
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++)
                if(matrix[i][j] == ch)
                    return new int[]{i, j};
        return null;
    }

    static String prepare(String text){
        text = text.toUpperCase().replace("J", "I");
        String s = "";
        for(char ch : text.toCharArray())
            if(ch >= 'A' && ch <= 'Z') s += ch;

        String result = "";
        int i = 0;

        while(i < s.length()){
            char a = s.charAt(i);
            char b;

            if(i + 1 >= s.length()){
                b = 'X';
                i++;
            }
            else if(a == s.charAt(i + 1)){
                b = 'X';
                i++;
            }
            else{
                b = s.charAt(i + 1);
                i += 2;
            }

            result += "" + a + b;
        }
        return result;
    }

    static String encrypt(String text){
        String p = prepare(text);
        String result = "";

        for(int i = 0; i < p.length(); i += 2){
            int[] a = find(p.charAt(i));
            int[] b = find(p.charAt(i + 1));

            if(a[0] == b[0]){
                result += matrix[a[0]][(a[1] + 1) % 5];
                result += matrix[b[0]][(b[1] + 1) % 5];
            }
            else if(a[1] == b[1]){
                result += matrix[(a[0] + 1) % 5][a[1]];
                result += matrix[(b[0] + 1) % 5][b[1]];
            }
            else{
                result += matrix[a[0]][b[1]];
                result += matrix[b[0]][a[1]];
            }
        }
        return result;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter key");
        String key = sc.next();

        System.out.println("Enter string");
        String text = sc.next();

        generateMatrix(key);
        System.out.println("Cipher: " + encrypt(text));

        sc.close();
    }
}

