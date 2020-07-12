
/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class Tester {
    public void testGetFollows(){
        String st="this is a test yes this is a test.";
        MarkovOne markov = new MarkovOne();
        markov.setTraining(st);
        ArrayList<String> follows = markov.getFollows("t.");
        System.out.println(follows.size()+" "+follows);
        
    }
    public void testGetFollowsWithFile () {
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        
        MarkovOne markov = new MarkovOne ();
        markov.setTraining(st);
        
        String key = "o";
        ArrayList<String> follows = markov.getFollows(key);
        //System.out.println("Letters that follow \"" + key + "\": " + follows);
        System.out.println("There are " + follows.size() + " letters that follow \"" + key + "\"");
    }
}
