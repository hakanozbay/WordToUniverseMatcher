package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import universe.TreeUniverse;
import entity.UniverseEntity;

public class TreeUniverseTest {

	private final String[] entities = {"bat","cat","actor","catch","lake","smearing","travelalerter"};
	
	TreeUniverse treeUniverse;
	
	@Before
	public void setUp()
	{
		treeUniverse = new TreeUniverse();
		treeUniverse.buildUniverse(entities);
	
	}
	
	@Test
	public void testSizeOfUniverse() {
		assertEquals(4, treeUniverse.sizeOfUniverse());
	}
	
	@Test
	public void testGetSubSetOfUniverse()
	{
		assertEquals(2, treeUniverse.getSubSetOfUniverse(3).size());
	}
	
	@Test
	public void testAddToUniverseOfNewLengthWord()
	{
		assertEquals(0, treeUniverse.getSubSetOfUniverse(1).size());
		assertTrue(treeUniverse.addToUniverse("a"));
		assertEquals(1, treeUniverse.getSubSetOfUniverse(1).size());
	}
	
	@Test
	public void testAddToUniverseOfExistingLengthWord()
	{
		assertEquals(2, treeUniverse.getSubSetOfUniverse(3).size());
		assertTrue(treeUniverse.addToUniverse("hat"));
		assertEquals(3, treeUniverse.getSubSetOfUniverse(3).size());
	}
	
	@Test
	public void testGetSubSetRangeOfUniverse()
	{
		List<UniverseEntity> subset = treeUniverse.getSubSetRangeOfUniverse(3, 6);
		assertEquals(5, subset.size());
		System.out.println(subset);
	}

}
