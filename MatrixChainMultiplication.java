import java.util.Scanner;

public class MatrixChainMultiplication {
    static int MatrixChain(int[] dimensions){
        // int cost=0;
        int num=dimensions.length;
        int dp[][]=new int[num][num];
        for(int i=1;i<num;i++){
            dp[i][i]=0;
        }
        for(int l=2;l<num;l++){
            for(int i=1;i<num-l+1;i++){
                int j=i+l-1;
                dp[i][j]=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int a=dp[i][k]+dp[k+1][j]+dimensions[i-1]*dimensions[k]*dimensions[j];
                    if(dp[i][j]>a){
                        dp[i][j]=a;
                    }
                }
            }
        }
        return dp[1][num-1];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of matrices");
        int num=sc.nextInt();
        System.out.println("Enter the dimensions");
        int dimensions[]=new int[num+1];
        for(int i=0;i<=num;i++){
            dimensions[i]=sc.nextInt();
        }
        int cost=MatrixChain(dimensions);
        System.out.println("\n"+cost);
    }
}
