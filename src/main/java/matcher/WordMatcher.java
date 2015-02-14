package matcher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import universe.Universe;
import utils.Utilities;
import entity.MatchEntity;
import entity.UniverseEntity;

public class WordMatcher implements IWordMatcher {

	private Universe universe;
	private int acceptableEditDistance = 10;
	private int lowerBoundOfSubSetFromWordLength = 1;
	private int upperBoundOfSubSetFromWordLength = 4;

	public WordMatcher(Universe universe)
	{
		this.universe = universe;
	}

	@Override
	public List<MatchEntity> matchWordToUniverse(String word) 
	{

		Set<MatchEntity> uniqueMatches = new HashSet<>();
		uniqueMatches.addAll(findAnagrams(word));
		uniqueMatches.addAll(findPotentialMatchesThroughCompositionAndEditDistance(word));
		uniqueMatches.addAll(findPotentialMatchesThroughApproximation(word));

		List<MatchEntity> matches = new ArrayList<>(uniqueMatches);

		Utilities.rankAndOrderMatches(matches);
		return matches;
	}


	@Override
	public List<MatchEntity> findAnagrams(String word) 
	{
		List<UniverseEntity> listOfEntitiesWithSameLength =  universe.getSubSetOfUniverse(word.length());
		List<MatchEntity> listOfAnagrams = new ArrayList<>();

		long productOfCharsForWord = Utilities.calculateProductOfChars(word);

		for (UniverseEntity entity : listOfEntitiesWithSameLength)
			if (entity.getProductOfChars() == productOfCharsForWord)
				listOfAnagrams.add(new MatchEntity(entity.getOriginalEntry(), Utilities.LevenshteinDistance(word, entity.getOriginalEntry())));

		return listOfAnagrams;
	}

	@Override
	public List<MatchEntity> findPotentialMatchesThroughCompositionAndEditDistance(String word) 
	{
		List<UniverseEntity> rangeOfEntitesToMatch = universe.getSubSetRangeOfUniverse(word.length() - 1, word.length() + 4);

		long productOfCharsForWord = Utilities.calculateProductOfChars(word);

		List<MatchEntity> listOfMatches = new ArrayList<>();

		for (UniverseEntity entity : rangeOfEntitesToMatch)
			if (entity.getProductOfChars() % productOfCharsForWord == 0)
				listOfMatches.add(
						new MatchEntity(entity.getOriginalEntry(), Utilities.LevenshteinDistance(word, entity.getOriginalEntry())));
		
		return listOfMatches;
	}

	@Override
	public List<MatchEntity> findPotentialMatchesThroughApproximation(String word) 
	{

		List<UniverseEntity> rangeOfEntitesToMatch;

		if(word.length() == 1)
			rangeOfEntitesToMatch = universe.getSubSetRangeOfUniverse(word.length(), word.length() + getUpperBoundOfSubSetFromWordLength());
		else
			rangeOfEntitesToMatch = universe.getSubSetRangeOfUniverse(word.length() - getLowerBoundOfSubSetFromWordLength(), word.length() + getUpperBoundOfSubSetFromWordLength());

		List<MatchEntity> listOfMatches = new ArrayList<>();

		for (UniverseEntity entity : rangeOfEntitesToMatch)
		{
			int editDistance = Utilities.LevenshteinDistance(word, entity.getOriginalEntry()) ; 
			if (editDistance < getAcceptableEditDistance())
				listOfMatches.add(new MatchEntity(entity.getOriginalEntry(), editDistance));
		}
		return listOfMatches;

	}

	protected int getLowerBoundOfSubSetFromWordLength() {
		return lowerBoundOfSubSetFromWordLength;
	}

	protected int getUpperBoundOfSubSetFromWordLength() {
		return upperBoundOfSubSetFromWordLength;
	}

	protected int getAcceptableEditDistance() 
	{
		return acceptableEditDistance;
	}


}
