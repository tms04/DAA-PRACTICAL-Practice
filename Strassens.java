//USED THE TECHNIQUE TAUGHT BY ABDUL BARI

import java.util.Scanner;

public class Strassens {
    static int [][] split(int A[][],int i,int j){
        int C[][]=new int[2][2];
        int r=0;
        int c=0;
        int I;
        int J;
        for(I=i;I<i+2;I++,r++){
            for(J=j,c=0;J<j+2;J++,c++){
                C[r][c]=A[I][J];
            }
        }
        return C;
    }
    public static void combine(int A[][],int B[][],int i,int j){
        int r=0;
        int c;
        int J;
        for(int I=i;I<i+2;I++,r++){
            for(J=j,c=0;J<j+2;J++,c++){
                // System.out.println(r+" "+c+" "+I+""+J);
                A[I][J]=B[r][c];
                
            }
        }
    }
    public static int[][] subMatrices(int[][] A,int[][] B){
        int C[][]=new int[2][2];
        for(int i=0;i<2;i++){    
            for(int j=0;j<2;j++){    
                C[i][j]=A[i][j]-B[i][j];          
                }        
            }
        return C;    
    }
    public static int[][] addMatrices(int[][] A,int[][] B){
        int C[][]=new int[2][2];
        for(int i=0;i<2;i++){    
            for(int j=0;j<2;j++){    
                C[i][j]=A[i][j]+B[i][j];          
                }        
            }
        return C;    
    }
    
    public static int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        int[][] product = new int[2][2];
        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }

        return product;
    }
    
    public static void main(String[] args) {
        int X[][]=new int[4][4];
        int Y[][]=new int[4][4];
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first 4x4 matrix");
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                X[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter the second 4x4 matrix");
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                Y[i][j]=sc.nextInt();
            }
        }
        int A[][]=split(X,0,0);
        int B[][]=split(X,0,2);
        int C[][]=split(X,2,0);
        int D[][]=split(X, 2, 2);
        int E[][]=split(Y,0,0);
        int F[][]=split(Y,0,2);
        int G[][]=split(Y,2,0);
        int H[][]=split(Y, 2, 2);
        int M1[][]=multiplyMatrices(addMatrices(A, C),addMatrices(E, F));
        int M2[][]=multiplyMatrices(addMatrices(B, D),addMatrices(G, H));
        int M3[][]=multiplyMatrices(subMatrices(A, D),addMatrices(E, H) );
        int M4[][]=multiplyMatrices(A, subMatrices(F,H));
        int M5[][]=multiplyMatrices(addMatrices(C, D), E);
        int M6[][]=multiplyMatrices(addMatrices(A, B), H);
        int M7[][]=multiplyMatrices(D, subMatrices(G, E));
        int I[][]=subMatrices(addMatrices(M2, M3), addMatrices(M6, M7));
        int J[][]=addMatrices(M4,M6);
        int K[][]=addMatrices(M5,M7);
        int L[][]=subMatrices(subMatrices(M1, M3), addMatrices(M4, M5));
        combine(X, I, 0, 0);
        combine(X, J, 0, 2);
        combine(X, K, 2, 0);
        combine(X, L, 2, 2);
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(X[i][j]+"\t");
            }
            System.out.println();
        }

        

        // for(int i=0;i<2;i++){
        //     for(int j=0;j<2;j++){
        //         System.out.print(M1[i][j]+"\t");
        //     }
        //     System.out.println();
        // }
    }
}