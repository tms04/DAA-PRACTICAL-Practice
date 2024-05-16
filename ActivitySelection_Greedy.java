import java.util.Scanner;

public class ActivitySelection_Greedy {
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
        
    }
}
