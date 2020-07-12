
/**
 * Write a description of MarkovFour here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class MarkovFour extends AbstractMarkovModel{
    public String toString(){
        return "Markov Model of order 4";
    }
    public String getRandomText(int numChars){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-4);
        String key = myText.substring(index,index+4);
        sb.append(key);
        
        for(int k=0; k < numChars-4; k++){
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