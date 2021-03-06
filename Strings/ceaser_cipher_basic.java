import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static String caesarCipher(String s, int k) {
        char c[]=s.toCharArray();
        for(int i=0;i<s.length();i++){
            if((c[i]>='a' && c[i]<='z')){
                int j=(int)c[i];
                k=k%26;
                j=(j+k);
                if((char)j>'z'){
                    j=j-(int)'z'+(int)'a'-1;
                }
                c[i]=(char)j;
            }
            else if((c[i]>='A' && c[i]<='Z')){
                int j=(int)c[i];
                k=k%26;
                j=(j+k);
                if((char)j>'Z'){
                    j=j-(int)'Z'+(int)'A'-1;
                }
                c[i]=(char)j;
            }
        }
        String s1=new String(c);
        System.out.println(s1);
        return s1;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
