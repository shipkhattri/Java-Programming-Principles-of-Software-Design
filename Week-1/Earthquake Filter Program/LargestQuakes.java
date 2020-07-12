
/**
 * Write a description of LargestQuakes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class LargestQuakes {
    public int indexOfLargest(ArrayList<QuakeEntry> data){
        int index = 0;
        double max = data.get(0).getMagnitude();
        for (int i=0; i<data.size();i++) {
            QuakeEntry qe = data.get(i);
            if (qe.getMagnitude() > max){
                max = qe.getMagnitude();
                index = i;
            }
        }
        return index;
    }
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
        ArrayList<QuakeEntry> copy=new ArrayList<QuakeEntry>(quakeData);
        ArrayList<QuakeEntry> ret=new ArrayList<QuakeEntry>();
        for(int k=0;k<howMany;k++){
            int indx=indexOfLargest(copy);
            ret.add(copy.get(indx));
            copy.remove(indx);
        }
        return ret;
    }
    public void findLargestQuakes(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        /*
        for (QuakeEntry qe : list) {
           System.out.println(qe); 
        } */
        System.out.println("# quakes read: " + list.size());
        
        ArrayList<QuakeEntry> largest=getLargest(list,50);
        for (QuakeEntry qe : largest) {
           System.out.println(qe); 
        }
    }
}
