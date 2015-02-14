package matcher;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

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
		System.out.println(potentialMatch);
		
		assertEquals(3,potentialMatch.size());
		
	}
	
	@Test
	public void testFindMatchesThroughApproximation()
	{
		List<MatchEntity> potentialMatch = wordMatcher.findPotentialMatchesThroughApproximation("sat");
		System.out.println(potentialMatch);
		
		assertEquals(5,potentialMatch.size());
		
	}
	
	@Test
	public void testMatchWordToUniverse()
	{
		List<MatchEntity> potentialMatch = wordMatcher.matchWordToUniverse("cat");
		System.out.println(potentialMatch);
		
		assertEquals(5,potentialMatch.size());
		
	}

}
