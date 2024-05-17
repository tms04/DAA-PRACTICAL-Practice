import java.util.Scanner;

public class SumOfSubsets {
    private static void SumOfSubset(int sum, int k, int r, int[] weights,int[] X,int M) {
        X[k]=1;
        if(sum+weights[k]==M){
            System.out.println("Solution:");
            for(int i=0;i<weights.length;i++){
                System.out.println((i+1)+":\t"+X[i]);
            }
        }else{
            if(sum+weights[k]+weights[k+1]<=M){
                SumOfSubset(sum+weights[k], k+1, r-weights[k], weights, X, M);
            }
        }
        if(sum+r-weights[k]>=M && sum+weights[k+1]<=M){
            
                X[k]=0;
                SumOfSubset(sum, k+1, r-weights[k], weights, X, M);
            
        }
        X[k]=0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the sum required");
        int M=sc.nextInt();
        System.out.println("Enter the number of nodes");
        int num=sc.nextInt();
        int weights[]=new int[num];
        System.out.println("Enter the weight of each node");
        int sum=0;
        for(int i=0;i<num;i++){
            weights[i]=sc.nextInt();
            sum+=weights[i];
        }
        int X[]=new int[num];
        SumOfSubset(0,0,sum,weights,X,M);
    }
}
