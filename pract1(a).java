

import java.util.*;
import java.io.*;

class Practical1{
  public static StringBuffer encryption(String text,int k){
  StringBuffer result=new StringBuffer();
  for(int i=0;i<text.length();i++){
    if(Character.isUpperCase(text.charAt(i))){
    char ch=(char)(((int)text.charAt(i)+k-65)%26+65);
    result.append(ch);
  }
    else{
    char ch=(char)(((int)text.charAt(i)+k-97)%26+97);
    result.append(ch);
  }
  }
  return result;
  }
  public static StringBuffer decryption(String text, int k){
    StringBuffer result1 = new StringBuffer();

    for(int i = 0; i < text.length(); i++){
        if(Character.isUpperCase(text.charAt(i))){
            char ch = (char)(((text.charAt(i) - 65 - k + 26) % 26) + 65);
            result1.append(ch);
        }
        else{
            char ch = (char)(((text.charAt(i) - 97 - k + 26) % 26) + 97);
            result1.append(ch);
        }
    }
    return result1;
}
  public static void main(String args[]){
  String s,str;
  StringBuffer s1;
  int k;

  System.out.println("Enter string");
  Scanner sc=new Scanner(System.in);
  s=sc.next();
  System.out.println("Enter key");
  Scanner sc1=new Scanner(System.in);
  k=sc1.nextInt ();


  s1=new StringBuffer(encryption(s,k));
  str=s1.toString();

  System.out.println("cipher: "+encryption(s,k));
  System.out.println("plain Text: "+decryption(str,k));
  }

}
