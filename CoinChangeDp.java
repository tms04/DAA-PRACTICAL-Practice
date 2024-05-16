import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class CoinChangeDp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the total change required");
        int change=sc.nextInt();
        System.out.println("Enter the number of different coins you have");
        int noOfCoins=sc.nextInt();
        int Coins[]=new int[noOfCoins];
        for(int i=0;i<noOfCoins;i++){
            System.out.println("Enter the value of the coin");
            Coins[i]=sc.nextInt();
        }
        Arrays.sort(Coins);
        int CoinChange[][]=new int[noOfCoins-1][change+1];
        for(int i=0;i<noOfCoins-1;i++){
            for(int j=0;j<change+1;j++){
                if(j==0){
                    CoinChange[i][j]=0;
                }else if(i==0 && Coins[i]>j){
                    CoinChange[i][j]=Integer.MAX_VALUE;
                }else if(i==0 && Coins[i]<=j){
                    CoinChange[i][j]=1+CoinChange[i][j-Coins[i]];
                }else if(Coins[i]>j){
                    CoinChange[i][j]=CoinChange[i-1][j];
                }else if(Coins[i]<=j){
                    CoinChange[i][j]=(CoinChange[i-1][j]>(1+CoinChange[i][j-Coins[i]])?(1+CoinChange[i][j-Coins[i]]):CoinChange[i-1][j]);
                }
            }
        }
        int i=noOfCoins-2;
        int j=change;
        Vector<Integer> v1=new Vector<Integer>();

        while(j>0){
            if(CoinChange[i][j]==CoinChange[i-1][j]){
                i--;
            }else{
                j=j-Coins[i];
                v1.add(Coins[i]);
            }
        }
        System.out.println("Values of coins to be given as change are as follows");
        for(int k=0;k<v1.size();k++){
            System.out.println(v1.elementAt(k));
        }
    }    
}
