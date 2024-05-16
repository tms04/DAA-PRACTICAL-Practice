public class NQueens {
    private static void nQueens(int[] chessboard, int queens,int k) {
        for(int i=0;i<queens;i++){
            if(Place(k,i,chessboard)){
                chessboard[k]=i;
                if(k>=queens-1){
                    System.out.println("Solution:");
                    for(int a=0;a<queens;a++){
                        System.out.println(chessboard[a]);
                    }
                }else{
                    nQueens(chessboard,queens,(k+1));
                }
            }
        }
    }
  private static boolean Place(int k,int i,int[] chessboard) {
        for(int j=0;j<k;j++){
            if(chessboard[j]==i || (Math.abs(chessboard[j]-i)==Math.abs(j-k))){
                return false;
            }
        }
        return true;
    }
  public static void main(String[] args) {
        int chessboard[]=new int[4];
        nQueens(chessboard,4,0);
    }
    
}
