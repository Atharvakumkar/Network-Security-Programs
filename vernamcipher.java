import java.util.*;

class Practical2{
    static String encrypt(String text, String key){
        String result = "";
        for(int i = 0; i < text.length(); i++){
            int p = text.charAt(i) - 'A';
            int k = key.charAt(i) - 'A';
            result += (char)((p + k) % 26 + 'A');
        }
        return result;
    }

    static String decrypt(String text, String key){
        String result = "";
        for(int i = 0; i < text.length(); i++){
            int c = text.charAt(i) - 'A';
            int k = key.charAt(i) - 'A';
            result += (char)((c - k + 26) % 26 + 'A');
        }
        return result;
    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter string");
        String text = sc.next().toUpperCase();

        System.out.println("Enter key");
        String key = sc.next().toUpperCase();

        if(text.length() != key.length()){
            System.out.println("Key length must be equal to text length");
            return;
        }

        String cipher = encrypt(text, key);

        System.out.println("Cipher: " + cipher);
        System.out.println("Plain Text: " + decrypt(cipher, key));

        sc.close();
    }
}

