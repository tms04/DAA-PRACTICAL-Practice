import java.util.*;
/**
 * MinMx
 */
public class MinMx {
    static int [] minmax(int a[],int low,int high){
        int m[]=new int[2];
        int n[]=new int[2];
        // int low=0;
        // int high=size-1;
        int size=high-low+1;
        if(size==1){
            m[0]=a[low];
            m[1]=a[high];
        }else if (size==2) {
            if(a[low]>a[high]){
                m[1]=a[low];
                m[0]=a[high];
            }else{
                m[0]=a[low];
                m[1]=a[high];
            }
        }else{
            int mid=((high+low)/2);
            m=minmax(a,low,mid);
            n=minmax(a,mid+1, high);
            if(m[1]<n[1]){
                m[1]=n[1];
            }if (m[0]>n[0]) {
                m[0]=n[0];
            }
        }
        return m;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int size=sc.nextInt();
        int A[]=new int[size];
        for(int i=0;i<size;i++){
            System.out.println("Enter the "+(i+1)+"th element of the array");
            A[i]=sc.nextInt();
        }
        int minMax[]=minmax(A,0,size-1);
        System.out.println(minMax[0]+" "+minMax[1]);
    }
}