package application;

import java.util.List;

import matcher.WordMatcher;
import universe.TreeUniverse;
import universe.Universe;
import entity.MatchEntity;

public class App {

	public static void main (String[] args)
	{
		String[] entities = {"bat","cat","actor","catch","lake","smearing","travelalerter"};
		
		Universe universe = new TreeUniverse();
		universe.buildUniverse(entities);
		
		WordMatcher wordMatcher = new WordMatcher(universe);
		List<MatchEntity> matchedWordsInTheUniverse = wordMatcher.matchWordToUniverse("sat");
		
		System.out.println(matchedWordsInTheUniverse);
	}
	
}
