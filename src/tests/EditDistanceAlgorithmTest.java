package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import utils.Utilities;

public class EditDistanceAlgorithmTest {

	@Test
	public void testEditDistanceAlgorithmForTheSameWord() {
		int editDistance = Utilities.LevenshteinDistance("cat", "cat");
		assertEquals(0, editDistance);
	}
	
	@Test
	public void testEditDistanceAlgorithmForTheSameWordMistype() {
		int editDistance = Utilities.LevenshteinDistance("act", "cat");
		//assertEquals(0, editDistance);
		assertEquals(2, editDistance);
	}
	
	@Test
	public void testEditDistanceAlgorithmForTheSameWordWithCaseSensitivity() {
		int editDistance = Utilities.LevenshteinDistance("Cat", "cat");
		assertEquals(1, editDistance);
	}
	
	@Test
	public void testEditDistanceAlgorithmFor1LetterVariation() {
		int editDistance = Utilities.LevenshteinDistance("bat", "cat");
		assertEquals(1, editDistance);
	}
	
	@Test
	public void testEditDistanceAlgorithmForASubsetInOrder() {
		int editDistance = Utilities.LevenshteinDistance("act", "actor");
		assertEquals(2, editDistance);
	}
	
	@Test
	public void testEditDistanceAlgorithmForASubset() {
		int editDistance = Utilities.LevenshteinDistance("act", "catch");
		assertEquals(3, editDistance);
	}

}
