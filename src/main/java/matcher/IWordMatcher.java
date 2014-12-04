package matcher;

import java.util.List;

import entity.MatchEntity;



public interface IWordMatcher {

	public List<MatchEntity> matchWordToUniverse(String word);
	public List<MatchEntity> findAnagrams(String word);
	public List<MatchEntity> findPotentialMatchesThroughCompositionAndEditDistance(String word);
	public List<MatchEntity> findPotentialMatchesThroughApproximation(String word);
	
}
