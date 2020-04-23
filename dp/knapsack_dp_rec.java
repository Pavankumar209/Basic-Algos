import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int c=0;
    static int maximumToys(int[] prices, int k) {
        int n = prices.length;
        int dp[][] = new int[n+1][k+1];
        c=0;
        int optimal_val = knapsack_rec(prices,dp,n,k);
        System.out.println("After all "+c);
        return optimal_val;
    }
    static int knapsack_rec(int[] prices,int[][] dp,int n,int k){
        if(n<=0){
            return 0;
        }
        if(k<=0){
            return 0;
        }
        int q1=0,q2=0;
        int qf1=0;
        int qf2=0;
        int temp = dp[n][k];
        if(k>=prices[n-1]){
            if(dp[n-1][k-prices[n-1]]==0){
                q1 = knapsack_rec(prices,dp,n-1,k-prices[n-1])+prices[n-1];
                qf1=1;
            }
            //System.out.println("Q1 "+q1);
            else
                q1 = dp[n-1][k-prices[n-1]];
        }
        if(dp[n-1][k]==0){
            q2 = knapsack_rec(prices,dp,n-1,k);
            qf2=1;
        }
        else
            q2 = dp[n-1][k];
        //System.out.println("Q2 "+q2);
        if(q1>q2){
            if(qf1==1){
                //c++;
            }
            dp[n][k]=q1;
        }
        else{
            dp[n][k]=q2;
        }
        if(temp!=dp[n][k]){
            c++;
        }
        //dp[n][k] = Math.max(q1,q2);
        return dp[n][k];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
