
/**
 * Write a description of MarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class MarkovModel extends AbstractMarkovModel{
    private int n;
    
    public MarkovModel(int i){
        n=i;
    }
    public String toString(){
        return "Markov Model of order "+ n;
    }
    public String getRandomText(int numChars){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-n);
        String key = myText.substring(index,index+n);
        sb.append(key);
        
        for(int k=0; k < numChars-n; k++){
        ArrayList<String> follows = getFollows(key);
        //System.out.println("key "+key+" "+follows);
        if(follows.size()==0)
          break;
        index = myRandom.nextInt(follows.size());
        String next = follows.get(index);
        sb.append(next);
        key=key.substring(1) + next;
            }
        
            return sb.toString();
    }
}
