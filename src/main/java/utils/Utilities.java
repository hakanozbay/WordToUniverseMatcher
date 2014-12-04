package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import entity.MatchEntity;

public class Utilities {

	public static int calculateProductOfChars(String originalEntry) {
		char chars[] = originalEntry.toLowerCase().toCharArray();
		
		int product = 1;
		for (char character : chars)
		{
			product = product * Character.getNumericValue(character);
		}
		
		return product;
	}
	
	
	public static List<MatchEntity> removeDuplicates(List<MatchEntity> matches) {
		Set<MatchEntity> uniqueEntries = new HashSet<>();
		for (MatchEntity match: matches)
			uniqueEntries.add(match);
		
		return new ArrayList<>(uniqueEntries);
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
	public static int LevenshteinDistance (String word, String potentialMatch) {                          
	    int len0 = word.length() + 1;                                                     
	    int len1 = potentialMatch.length() + 1;                                                     
	 
	    // the array of distances                                                       
	    int[] cost = new int[len0];                                                     
	    int[] newcost = new int[len0];                                                  
	 
	    // initial cost of skipping prefix in String s0                                 
	    for (int i = 0; i < len0; i++) cost[i] = i;                                     
	 
	    // dynamicaly computing the array of distances                                  
	 
	    // transformation cost for each letter in s1                                    
	    for (int j = 1; j < len1; j++) {                                                
	        // initial cost of skipping prefix in String s1                             
	        newcost[0] = j;                                                             
	 
	        // transformation cost for each letter in s0                                
	        for(int i = 1; i < len0; i++) {                                             
	            // matching current letters in both strings                             
	            int match = (word.charAt(i - 1) == potentialMatch.charAt(j - 1)) ? 0 : 1;             
	 
	            // computing cost for each transformation                               
	            int cost_replace = cost[i - 1] + match;                                 
	            int cost_insert  = cost[i] + 1;                                         
	            int cost_delete  = newcost[i - 1] + 1;                                  
	 
	            // keep minimum cost                                                    
	            newcost[i] = Math.min(Math.min(cost_insert, cost_delete), cost_replace);
	        }                                                                           
	 
	        // swap cost/newcost arrays                                                 
	        int[] swap = cost; cost = newcost; newcost = swap;                          
	    }                                                                               
	 
	    // the distance is the cost for transforming all letters in both strings        
	    return cost[len0 - 1];                                                          
	}


}
