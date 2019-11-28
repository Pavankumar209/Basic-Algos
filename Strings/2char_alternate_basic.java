import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {
    static int alternate(String s) {
        int c[]=new int[26];
        int maxx=0;
        for(int i=0;i<s.length();i++){
            c[s.charAt(i)-'a']++;
        }
        for(int i=0;i<25;i++){
            for(int j=i+1;j<26;j++){
                if(Math.abs(c[i]-c[j])<=1){
                    int num=c[i];
                    char char1=(char)(i+'a');
                    char char2=(char)(j+'a');
                    char prev='0';
                    int count=0;
                    int k;
                    for(k=0;k<s.length();k++){
                        if(s.charAt(k)==char1){
                            if(prev=='0'){
                                prev=char1;
                            }
                            else if(prev==char2){
                                count++;
                                prev=char1;
                            }
                            else{
                                break;
                            }
                        }
                        else if(s.charAt(k)==char2){
                            if(prev=='0'){
                                prev=char2;
                            }
                            else if(prev==char1){
                                count++;
                                prev=char2;
                            }
                            else{
                                break;
                            }
                        }
                    }
                    if(k==s.length() && count!=0){
                        maxx=Math.max(maxx,count+1);
                    }

                }
            }
        }
        return maxx;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
