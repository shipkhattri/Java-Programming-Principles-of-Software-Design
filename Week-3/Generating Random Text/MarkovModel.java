
/**
 * Write a description of MarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class MarkovModel {
    private int n;
    private String myText;
	private Random myRandom;
	
	public MarkovModel(int i) {
	    n=i;  
	    myRandom = new Random();
	}
	
	public void setRandom(int seed){
		myRandom = new Random(seed);
	}
	
	public void setTraining(String s){
		myText = s.trim();
	}
	
    	public ArrayList<String> getFollows(String key){
    	    ArrayList<String> answer = new ArrayList<String> ();
            int keyLength = key.length();
            
            for (int i=0; i < myText.length()-keyLength; i++) {
                if (myText.substring(i, i+keyLength).equals(key)) {
                    String next = myText.substring(i+keyLength, i+keyLength+1);
                    answer.add(next);
                }
            }
            
            return answer;
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
