public class Kmp {
    public static void main(String[] args) {
        String P="ABABD";
        String T="ABABCABCABABABD";
        int lps[]=LPS(P);
        // for(int i=0;i<P.length();i++){
        //     System.out.println(lps[i]);
        // }
        int index=kmp(T,P,lps);
        System.out.println(index);
    }

    private static int kmp(String t, String p, int[] lps) {
        int n=t.length();
        int m=p.length();
        int i=0;
        int j=0;
        while (i<n) {
            if(t.charAt(i)==p.charAt(j)){
                if(j==m-1){
                    return i-m+1;
                }
                i++;
                j++;
            }else if(j>0){
                j=lps[j-1];
            }else{
                i++;
            }
        }
        return -1;
    }

    private static int[] LPS(String p) {
        int lps[]=new int[p.length()];
        int i=1;
        int j=0;
        while(i<p.length()){
            if(p.charAt(i)==p.charAt(j)){
                lps[i]=j+1;
                i++;
                j++;
            }else if(j<1){
                lps[i]=0;
                i++;        
            }else{
                j=lps[j-1];
            }
        }
        return lps;
    }
}
