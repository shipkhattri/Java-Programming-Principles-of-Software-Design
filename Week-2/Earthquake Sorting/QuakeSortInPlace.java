import java.util.*;

public class QuakeSortInPlace {
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i = from +1; i < quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
        //count from 0 to < in.size()
        for(int i = 0; i < in.size(); i++) {
            /* find the index of the smallest quake*/
            int minIdx = getSmallestMagnitude(in, i);
            /* swap the ith quake with the minIdxth quake */
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i, qmin);
            in.set(minIdx, qi);
        }
    }
    
    public void sortByMagnitudeWithCheck(ArrayList<QuakeEntry> in) {
        //count from 0 to < in.size()
        int i;
        for(i = 0; i < in.size(); i++) {
            if(checkInSortedOrder(in))
                break;
            /* find the index of the smallest quake*/
            int minIdx = getSmallestMagnitude(in, i);
            /* swap the ith quake with the minIdxth quake */
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i, qmin);
            in.set(minIdx, qi);
        }
        System.out.println("Pass needed to sort elements: "+i);
    }
    
    public int getLargestDepth(ArrayList<QuakeEntry> quakeData, int from) {
        int maxIdx = from;
        for (int i = from +1; i < quakeData.size(); i++) {
            if (quakeData.get(i).getDepth() > quakeData.get(maxIdx).getDepth()) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }
    
    public void sortByLargestDepth(ArrayList<QuakeEntry> in) {
        //count from 0 to < in.size()
        for(int i = 0; i < 70; i++) {
            /* find the index of the smallest quake*/
            int maxIdx = getLargestDepth(in, i);
            /* swap the ith quake with the minIdxth quake */
            QuakeEntry qi = in.get(i);
            QuakeEntry qmax = in.get(maxIdx);
            in.set(i, qmax);
            in.set(maxIdx, qi);
        }
    }
    
    public boolean checkInSortedOrder(ArrayList<QuakeEntry> quakes){
        for(int i=0; i<quakes.size()-1; i++){
            if(quakes.get(i).getMagnitude()>quakes.get(i+1).getMagnitude()){
                return false;
            }
        }
        return true;
    }
    
    public void onePassBubbleSort(ArrayList<QuakeEntry> in, int numSorted){
        int n=in.size()-numSorted;
        for(int i=0; i<n-1; i++){
            if(in.get(i).getMagnitude()>in.get(i+1).getMagnitude()){
                QuakeEntry qi = in.get(i);
                QuakeEntry qj = in.get(i+1);
                in.set(i, qj);
                in.set(i+1, qi);
            }
        }
        /*System.out.println("Printing quakes after pass "+numSorted);
        for(QuakeEntry qe: in) {
            System.out.println(qe);
        }*/
    }
    
    public void sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> in){
        for(int i=0;i<in.size();i++){
            onePassBubbleSort(in,i);
        }
    }
    
    public void sortByMagnitudeWithBubbleSortWithCheck(ArrayList<QuakeEntry> in){
        int i;
        for(i=0;i<in.size();i++){
            if(checkInSortedOrder(in))
                break;
            onePassBubbleSort(in,i);
        }
        System.out.println("Pass needed to sort elements: "+i);
    }
    /* tester method to use in BlueJ */
    public void testSort(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/earthQuakeDataWeekDec6sample1.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        //sortByMagnitude(list);
        //sortByMagnitudeWithCheck(list);
        //sortByLargestDepth(list);
        //sortByMagnitudeWithBubbleSort(list);
        sortByMagnitudeWithBubbleSortWithCheck(list);
        //System.out.println("Earthquakes in Sorted Order: ");
        /*for(QuakeEntry qe: list) {
            System.out.println(qe);
        }*/
    }
    
}
