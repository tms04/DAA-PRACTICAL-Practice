import java.util.Arrays;

public class Prims {
    private static void PrimsMst(int[][] graph) {
        int size=graph.length;
        int key[]=new int[size];
        int parent[]=new int[size];
        boolean mstInc[]=new boolean[size];
        Arrays.fill(parent,-1);
        Arrays.fill(key,Integer.MAX_VALUE);
        key[0]=0;
        parent[0]=0;
        for(int count=0;count<size;count++){
            int u=minKey(key,mstInc);
            mstInc[u]=true;
            for(int v=0;v<size;v++){
                if(graph[u][v]!=0 && !mstInc[v] && key[v]>graph[u][v]){
                    key[v]=graph[u][v];
                    parent[v]=u;
                }
            }
        }
        PrintGraph(graph,parent);
    }
   private static void PrintGraph(int[][] graph, int[] parent) {
        System.out.println("Edge \t Weight");
        for(int v=0;v<graph.length;v++){
            System.out.println((v+1)+"-"+(parent[v]+1)+"\t"+(graph[v][parent[v]]));
        }
    }
private static int minKey(int[] key, boolean[] mstInc) {
        int min=Integer.MAX_VALUE;
        int minValue=-1;
        for(int v=0;v<key.length;v++){
            if(key[v]<min && !mstInc[v]){
                min=key[v];
                minValue=v;
            }
        }
        return minValue;
    }
 public static void main(String[] args) {
        int graph[][]=new int[][]{
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };
        PrimsMst(graph);
    }
}
