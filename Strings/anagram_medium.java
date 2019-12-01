import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int sherlockAndAnagrams(String s) {
        int n=s.length();
        char[] c=s.toCharArray();
        HashMap<Character,Integer> h[]=new HashMap[n*n+2];
        int k=0,cn=0;
        for(int i=0;i<n;i++){
            h[k]=new HashMap<>();
            //int x=h[]
            if(h[k].get(c[i])==null){
                h[k].put(c[i],1);
            }
            else{
                h[k].put(c[i],h[k].get(c[i])+1);
            }
            k++;
            for(int j=i+1;j<n;j++){
                h[k]=new HashMap<>();
                h[k].putAll(h[k-1]);
                if(h[k].get(c[j])==null){
                    h[k].put(c[j],1);
                }
                else{
                    h[k].put(c[j],h[k].get(c[j])+1);
                }
                k++;
            }
        }
        for(int i=0;i<k;i++){
            for(int j=i+1;j<k;j++){
                if(h[i].equals(h[j])){
                    cn++;
                }
            }
        }
        return cn;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
