import java.util.Scanner;

public class FractionalKnapsack {
    private static double[] knapsack(int W, int size, int[] weight, int[] value) {
        int weightleft=W;
        double x[]=new double[size];
        for(int i=0;i<size;i++){
            x[i]=0;
            if(weight[i]<weightleft){
                x[i]=1;
                weightleft-=weight[i];
            }else{
                x[i]=(double)(weightleft)/(double)(weight[i]);
                weightleft=0;
            }
        }
        return x;
    }    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the max weight that can be taken");
        int W=sc.nextInt();
        System.out.println("Enter the total number of elements");
        int size=sc.nextInt();
        int[] value=new int[size];
        int[] weight=new int[size];
        int index[]=new int[size];
        for(int i=0;i<size;i++){
            System.out.println("Enter the weight of "+(i+1)+" element");
            weight[i]=sc.nextInt();
            System.out.println("Enter the value of "+(i+1)+" element");
            value[i]=sc.nextInt();
            index[i]=i+1;
        }
        double vw[]=new double[size];
        for(int i=0;i<size;i++){
            vw[i]=(double)(value[i])/(double)(weight[i]);
        }
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                if (vw[i]<vw[j]){
                    double temp=vw[j];
                    vw[j]=vw[i];
                    vw[i]=temp;

                    int t=value[j];
                    value[j]=value[i];
                    value[i]=t;

                    t=weight[j];
                    weight[j]=weight[i];
                    weight[i]=t;

                    t=index[j];
                    index[j]=index[i];
                    index[i]=t;
                }
            }
        }
        
        double X[]=knapsack(W,size,weight,value);
        double Profit=0;
        for(int i=0;i<size;i++){
            System.out.println("Object number "+index[i]);
            System.out.println("Portion taken "+X[i]);
            Profit+=X[i]*(double)(value[i]);
        }
        System.out.println("Total profit is "+Profit);
    }
}

