import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class GraphColoring {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of colours");
        int m=sc.nextInt();
        System.out.println("Enter number of nodes");
        int n=sc.nextInt();
        int links[][]=new int[n][n];
        for(int i=0;i<n;i++){
            links[i][i]=0;
        }
        System.out.println("Enter 1 if link is present otherwise 0");
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                System.out.println("link between "+(i+1)+"-"+(j+1));
                links[i][j]=sc.nextInt();
                links[j][i]=links[i][j];
            }
        }
        int X[]=new int[n];
        int k=0;
        GraphColoringSoln(k,X,links,m,n);
    }

    private static void GraphColoringSoln(int k,int[] x, int[][] links, int m, int n) {
        while(true){
            if(NextValue(k,x,links,m,n)){
                if(x[k]==0){
                    return;
                }
                if(k==n-1){
                    System.out.println("Solution:");
                    System.out.println("Node_no\tColorCode");
                    for(int i=0;i<n;i++){
                        System.out.println((i+1)+"\t"+x[i]);
                    }               
            }else{
                GraphColoringSoln(k+1, x, links, m, n);
            }
        }
    }
}
    private static boolean NextValue(int k,int[] x, int[][] links, int m, int n) {
        while (true) {
            x[k]=(x[k]+1)%(m+1);
            if(x[k]==0){
                return true;
            }
            int i=0;
            for(;i<n;i++){
                if(links[i][k]==1 && x[k]==x[i]){
                    break;
                }
            }if(i==n){
                return true;
            }
            }
        }
    }

