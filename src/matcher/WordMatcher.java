package matcher;

import java.util.ArrayList;
import java.util.List;

import universe.Universe;
import utils.Utilities;
import entity.MatchEntity;
import entity.UniverseEntity;

public class WordMatcher implements IWordMatcher {

	Universe universe;

	public WordMatcher(Universe universe)
	{
		this.universe = universe;
	}
	
	@Override
	public List<MatchEntity> matchWordToUniverse(String word) {
		
		List<MatchEntity> matches= findAnagrams(word);
		matches.addAll(findPotentialMatchesThroughCompositionAndEditDistance(word));
		matches.addAll(findPotentialMatchesThroughApproximation(word));
		
		List<MatchEntity> uniqueMatches = Utilities.removeDuplicates(matches);
		Utilities.rankAndOrderMatches(uniqueMatches);
		return uniqueMatches;
	}


	@Override
	public List<MatchEntity> findAnagrams(String word) {
		List<UniverseEntity> listOfEntitiesWithSameLength =  universe.getSubSetOfUniverse(word.length());
		List<MatchEntity> listOfAnagrams = new ArrayList<>();

		int productOfCharsForWord = Utilities.calculateProductOfChars(word);

		for (UniverseEntity entity : listOfEntitiesWithSameLength)
		{
			if (entity.getProductOfChars() == productOfCharsForWord)
				listOfAnagrams.add(new MatchEntity(entity.getOriginalEntry(), Utilities.LevenshteinDistance(word, entity.getOriginalEntry())));
		}

		return listOfAnagrams;
	}

	@Override
	public List<MatchEntity> findPotentialMatchesThroughCompositionAndEditDistance(String word) {
		List<UniverseEntity> rangeOfEntitesToMatch = universe.getSubSetRangeOfUniverse(word.length() - 1, word.length() + 4);

		int productOfCharsForWord = Utilities.calculateProductOfChars(word);

		List<MatchEntity> listOfMatches = new ArrayList<>();

		for (UniverseEntity entity : rangeOfEntitesToMatch)
		{
			if (entity.getProductOfChars() % productOfCharsForWord == 0)
				listOfMatches.add(
						new MatchEntity(entity.getOriginalEntry(), Utilities.LevenshteinDistance(word, entity.getOriginalEntry())));
		}
		return listOfMatches;
	}

	@Override
	public List<MatchEntity> findPotentialMatchesThroughApproximation(String word) {
		List<UniverseEntity> rangeOfEntitesToMatch = universe.getSubSetRangeOfUniverse(word.length() - 1, word.length() + 4);
		List<MatchEntity> listOfMatches = new ArrayList<>();

		for (UniverseEntity entity : rangeOfEntitesToMatch)
		{
			int editDistance = Utilities.LevenshteinDistance(word, entity.getOriginalEntry()) ; 
			if (editDistance < 10)
				listOfMatches.add(new MatchEntity(entity.getOriginalEntry(), editDistance));
		}
		return listOfMatches;

	}


}
