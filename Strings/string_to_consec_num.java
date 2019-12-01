import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static void separateNumbers(String s) {
        long flag=0;   //to check if this is first number
        long flag1=0;  //to check for non consecutive num or starting with 0
        int k=0;       //current length int the iteration
        int i=0;
        long prev=0;
        long first=0;
        long minfirst=Long.MAX_VALUE;
        long n=s.length();

        for(int l=1;l<=n/2;l++){  //check for increasing length of num in each iteration
            i=0;
            flag=0;
            flag1=0;
            k=l;
            first=0;
            while(i+k<=n){
                long pres=Long.parseLong(s.substring(i,i+k));
                if(s.charAt(i)=='0'){
                    flag1=1;
                    break;
                }
                i=i+k;  //update i to point to start of next number
                if(Math.pow(10,k)-1==pres){
                    k++;    //update length to be considered for next num
                }
                if(flag==0){
                    first=pres;
                    prev=pres;
                    flag=1;
                    continue;
                }
                if(pres-prev!=1){
                    flag1=1;
                    break;
                }
                prev=pres;
            }
            if(flag1!=1 && i>=n){
                minfirst=Math.min(minfirst,first);
                break;
            }
            flag1=0;
            flag=0;
            first=0;
        }
        if(minfirst!=Long.MAX_VALUE){
            System.out.println("YES "+minfirst);
        }
        else{
            System.out.println("NO");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        long q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (long qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            separateNumbers(s);
        }

        scanner.close();
    }
}
