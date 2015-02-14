package utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entity.MatchEntity;

public class Utilities {

	public static long calculateProductOfChars(String originalEntry) {
		char chars[] = originalEntry.toLowerCase().toCharArray();
		
		long product = 1;
		for (char character : chars)
		{
			product = product * Character.getNumericValue(character);
		}
		
		return product;
	}
	
	
	public static void rankAndOrderMatches(List<MatchEntity> matches)
	{
		Collections.sort(matches, new Comparator<MatchEntity>() {

			@Override
			public int compare(MatchEntity o1, MatchEntity o2) {
				return (o1.getConfidenceLevelAsPercentage() < o2.getConfidenceLevelAsPercentage())? 1:
					(o1.getConfidenceLevelAsPercentage() > o2.getConfidenceLevelAsPercentage())? -1
					:0;
			}
		});
	}
	
	// source: http://en.wikibooks.org/wiki/Algorithm_Implementation/Strings/Levenshtein_distance 
	public static int LevenshteinDistance (String word, String potentialMatch) 
	{                          
	    int wordLength = word.length() + 1;                                                     
	    int potentialMatchLength = potentialMatch.length() + 1;                                                     
	 
	    // the array of distances                                                       
	    int[] cost = new int[wordLength];                                                     
	    int[] newcost = new int[wordLength];                                                  
	 
	    // initial cost of skipping prefix in String s0                                 
	    for (int i = 0; i < wordLength; i++) cost[i] = i;                                     
	 
	    // dynamicaly computing the array of distances                                  
	 
	    // transformation cost for each letter in s1                                    
	    for (int j = 1; j < potentialMatchLength; j++) {                                                
	        // initial cost of skipping prefix in String s1                             
	        newcost[0] = j;                                                             
	 
	        // transformation cost for each letter in s0                                
	        for(int i = 1; i < wordLength; i++) {                                             
	            // matching current letters in both strings                             
	            int match = (word.charAt(i - 1) == potentialMatch.charAt(j - 1)) ? 0 : 1;             
	 
	            // computing cost for each transformation                               
	            int costOfreplace = cost[i - 1] + match;                                 
	            int costOfInsert  = cost[i] + 1;                                         
	            int costOfDelete  = newcost[i - 1] + 1;                                  
	 
	            // keep minimum cost                                                    
	            newcost[i] = Math.min(Math.min(costOfInsert, costOfDelete), costOfreplace);
	        }                                                                           
	 
	        // swap cost/newcost arrays                                                 
	        int[] swap = cost; cost = newcost; newcost = swap;                          
	    }                                                                               
	 
	    // the distance is the cost for transforming all letters in both strings        
	    return cost[wordLength - 1];                                                          
	}


}
