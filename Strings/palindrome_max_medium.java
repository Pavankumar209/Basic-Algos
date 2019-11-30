import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static String highestValuePalindrome(String s, int n, int k) {
        BigInteger b = new BigInteger(s);
        char[] c=s.toCharArray();
        int u=0;
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-i-1))
                u++;
        }
        if(k<u){
            System.out.println("K "+k+" U"+u);
            return "-1";
        }
        if(k==u){
            for(int i=0;i<n/2;i++){
                if(s.charAt(i)!=s.charAt(n-i-1)){
                    if(s.charAt(i)>s.charAt(n-i-1)){
                        c[n-i-1]=c[i];
                    }
                    else{
                        c[i]=c[n-i-1];
                    }
                }
            }
            String s1=new String(c);
            return s1;
        }
        if(k>u){
            int x=k-u;
            int eo=x%2;
            k=u;
            if(x>=1){
                for(int i=0;i<n/2;i++){
                    if((s.charAt(i)!='9')&&(s.charAt(n-i-1)!='9')){
                        if(x>1){
                            if(c[i]==c[n-i-1]){
                                x=x-2;
                            }
                            else{
                                x=x-1;
                                k--;
                            }
                            c[n-i-1]='9';
                            c[i]='9';
                        }
                        else if(x==1){
                            if(c[i]!=c[n-i-1]){
                                x=x-1;
                                k--;
                                c[n-i-1]='9';
                                c[i]='9';
                            }
                        }
                        
                    }
                    if(x<1)
                        break;
                }
                s=new String(c);
            }
            if(x>=1){
                if(n%2==1){
                    c[n/2]='9';
                }
                s=new String(c);
            }
            if(k!=0){
                for(int i=0;i<n/2;i++){
                    if(s.charAt(i)!=s.charAt(n-i-1)){
                        if(s.charAt(i)>s.charAt(n-i-1)){
                            c[n-i-1]=c[i];
                        }
                        else{
                            c[i]=c[n-i-1];
                        }
                        k--;
                        //if(k==0){
                        //    break;
                        //}
                    }
                }
                s=new String(c);
            }
        }
        String s1=new String(c);
        return s1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String s = scanner.nextLine();

        String result = highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
