import java.util.Scanner;

public class Strassens {
    static int [][] split(int A[][],int i,int j){
        int C[][]=new int[2][2];
        int I=i;
        int J=j;
        int c;
        for(int r=0;i<I+2;i++,r++){
            for(c=0,j=J;j<J+2;j++,c++){
                C[r][c]=A[i][j];
            }
        }
        return C;
    }
    static int [][] Sum(int A[][],int B[][],int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                A[i][j]=A[i][j]+B[i][j];
            }
        }
        return A;
    }
    private static int[][] Multiply(int[][] a, int[][] b, int size) {
        int K[][]=new int[4][4];
        if(size==2){
            int J[][]=new int[2][2];
            J[0][0]=a[0][0]*b[0][0]+a[0][1]*b[1][0];
            J[0][1]=a[0][0]*b[0][1]+a[0][1]*b[1][1];
            J[1][0]=a[1][0]*b[0][0]+a[1][1]*b[1][0];
            J[1][1]=a[1][0]*b[0][1]+a[1][1]*b[1][1];
            return J;
        }else{
            int A[][]=split(a, 0, 0);
            int B[][]=split(a, 0, 2);
            int C[][]=split(a, 2, 0);
            int D[][]=split(a, 2, 2);
            int W[][]=split(b, 0, 0);
            int X[][]=split(b, 0, 2);
            int Y[][]=split(b, 2, 0);
            int Z[][]=split(b, 2, 2);
            A=Sum(Multiply(A, W, 2), Multiply(B, Y, 2), 2);
            B=Sum(Multiply(A, X, 2), Multiply(B, Z, 2), 2);
            C=Sum(Multiply(C, W, 2), Multiply(D, Y, 2), 2);
            D=Sum(Multiply(C, X, 2), Multiply(D, Z, 2), 2);
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    System.out.print(K[i][j]);
                }
                System.out.println("");
            }
            Combine(K,A,0,0);
            Combine(K,B,0,2);
            Combine(K,C,2,0);
            Combine(K,D,2,2);
        }
        return K;
    } 
    static void Combine(int[][] k, int[][] a, int i, int j) {
        
        int c;
        int I=i;
        int J=j;
        for(int r=0;i<I+2;i++,r++){
            for(c=0,j=J;j<J+2;j++,c++){
                k[i][j]=a[r][c];
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int A[][]=new int[4][4];
        int B[][]=new int[4][4];
        System.out.println("Enter the elements of matrix A");
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                A[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter the elements of matrix B");
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                B[i][j]=sc.nextInt();
            }
        }
        int K[][]=Multiply(A,B,4);
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(K[i][j]);
            }
            System.out.println("");
        }
    }   
}
