package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import matcher.WordMatcher;

import org.junit.Before;
import org.junit.Test;

import universe.TreeUniverse;
import entity.MatchEntity;

public class WordMatcherTest {

	private final String[] entities = {"bat","cat","actor","catch","lake","smearing","travelalerter"};
	
	WordMatcher wordMatcher;
	
	@Before
	public void setUp()
	{
	
		TreeUniverse treeUniverse = new TreeUniverse();
		treeUniverse.buildUniverse(entities);
		
		wordMatcher = new WordMatcher(treeUniverse);
		
	}
	
	@Test
	public void testFindAnagrams() {
		List<MatchEntity> anagrams = wordMatcher.findAnagrams("cat");
		assertTrue(anagrams.size() == 1);
		
		assertEquals("cat", anagrams.get(0).getWord());
	}
	
	@Test
	public void testFindMatchesThroughCompositionAndEditDistance()
	{
		List<MatchEntity> potentialMatch = wordMatcher.findPotentialMatchesThroughCompositionAndEditDistance("cat");
		assertEquals(3,potentialMatch.size());
		
		System.out.println(potentialMatch);
		
	}
	
	@Test
	public void testFindMatchesThroughApproximation()
	{
		List<MatchEntity> potentialMatch = wordMatcher.findPotentialMatchesThroughApproximation("sat");
		assertEquals(2,potentialMatch.size());
		
		System.out.println(potentialMatch);
		
	}
	
	@Test
	public void testMatchWordToUniverse()
	{
		List<MatchEntity> potentialMatch = wordMatcher.matchWordToUniverse("cat");
		assertEquals(4,potentialMatch.size());
		
		System.out.println(potentialMatch);
		
	}

}
