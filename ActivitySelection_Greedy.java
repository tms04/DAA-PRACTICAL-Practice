import java.util.Scanner;

public class ActivitySelection_Greedy {
    private static int[] ActicitySelection(int[] start, int[] finish, int num) {
        int X[]=new int[num];
        X[0]=1;
        int currentTime=finish[0];
        for(int i=1;i<num;i++){
            X[i]=0;
            if(currentTime<=start[i]){
                X[i]=1;
                currentTime=finish[i];
            }
        }
        return X;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of activities");
        int num=sc.nextInt();
        int index[]=new int[num];
        int start[]=new int[num];
        int finish[]=new int[num];
        for(int i=0;i<num;i++){
            System.out.println("Enter the start time of the "+(i+1)+" element");
            start[i]=sc.nextInt();
            System.out.println("Enter the finish time of the "+(i+1)+" element");
            finish[i]=sc.nextInt();
            index[i]=i+1;
        }
        for(int i=0;i<num;i++){
            for(int j=i;j<num;j++){
                if(finish[i]>finish[j]){
                    int t=finish[i];
                    finish[i]=finish[j];
                    finish[j]=t;

                    t=start[i];
                    start[i]=start[j];
                    start[j]=t;

                    t=index[i];
                    index[i]=index[j];
                    index[j]=t;
                }
            }
        }
        int X[]=ActicitySelection(start,finish,num);
        for(int i=0;i<num;i++){
            if(X[i]==1){
                System.out.println("Activity number "+index[i]+" is selected");
            }else{
                System.out.println("Activity number "+index[i]+" is not selected");
            }
            
        }
    }
}
