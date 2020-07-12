
/**
 * Write a description of DistanceFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DistanceFilter implements Filter
{
    private double dist;
    private Location city;
    public DistanceFilter(double lat, double lang,double d){
        city = new Location(lat,lang);
        dist=d;
    }
    
    public boolean satisfies(QuakeEntry qe){
        return (qe.getLocation().distanceTo(city) < dist);
    }
    public String getName(){
        return "Distance ";
    }
}
