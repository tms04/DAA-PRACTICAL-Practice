import java.util.*;
public class FlowShopSchedulingJohnson {
    static class Job {
        int jobNumber;
        int[] processingTime;
        Job(int jobNumber, int[] processingTime) {
            this.jobNumber = jobNumber;
            this.processingTime = processingTime;
        }
    }
    static class processingTimeM1Comaparator implements Comparator<Job>{
        @Override
        public int compare(Job o1, Job o2) {
            return o1.processingTime[0]-o2.processingTime[0];
        }
    }
    static class processingTimeM2Comaparator implements Comparator<Job>{
        @Override
        public int compare(Job o1, Job o2) {
            return o1.processingTime[1]-o2.processingTime[1];
        }
    }
    static void johnsonsAlgorithm(int[][] processingTimes) {
        boolean a[]=new boolean[processingTimes.length];
        int ans[]=new int[processingTimes.length];
        List<Job> l1=new ArrayList<Job>();
        for(int i=0;i<processingTimes.length;i++){
            l1.add(new Job(i, processingTimes[i]));
        }
        List<Job> l2=new ArrayList<Job>(l1);
        l1.sort(new processingTimeM1Comaparator());
        l2.sort(new processingTimeM2Comaparator());
        int j=processingTimes.length-1;
        int i=0;
        while (i<=j) {
                Job a1=l1.getFirst();
                Job a2=l2.getFirst();
                if(a1.processingTime[0]<a2.processingTime[1]){
                    ans[i]=a1.jobNumber;
                    i++;
                    l2.remove(a1);
                    l1.remove(a1);
                }else{
                    ans[j]=a2.jobNumber;
                    j--;
                    l1.remove(a2);
                    l2.remove(a2);
                }  
        }
        for(int k=0;k<ans.length;k++){
            System.out.println(ans[k]);
        }   
    }
    public static void main(String[] args) {
        int[][] processingTimes = {
                {10, 6},
                {6, 12},
                {8, 9},
                {8,10},
                {12,5}
        };
        johnsonsAlgorithm(processingTimes);
    }
}
