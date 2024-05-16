public class FloydWarshall {
    public static void main(String[] args) {
        int distance[][]=new int[][]{
            {0,8,1000,1},
            {1000,0,1,1000},
            {4,1000,0,1000},
            {1000,2,1,0},
        };
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(distance[i][j]+" ");
            }
            System.out.println("");
        }
        Floyd_Warshall(distance);
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(distance[i][j]+" ");
            }
            System.out.println("");
        }
    }

    private static void Floyd_Warshall(int[][] distance) {
        int length=distance.length;
        for(int k=0;k<length;k++){
            for(int i=0;i<length;i++){
                for(int j=0;j<length;j++){
                    int cost=distance[i][k]+distance[k][j];
                    if(cost<distance[i][j]){
                        distance[i][j]=cost;
                    }
                }
            }
        }
    }
}
