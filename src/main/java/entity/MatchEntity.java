package entity;

public class MatchEntity {

	private String word;
	private int editDistance;
	private int confidenceLevelAsPercentage;
	
	public MatchEntity(String word, int editDistance) 
	{
		super();
		this.word = word;
		this.editDistance = editDistance;
		this.confidenceLevelAsPercentage = calculateConfidenceLevelAsPercentage(editDistance); 
	}

	protected int calculateConfidenceLevelAsPercentage(int editDistance) 
	{
		return 100 - (editDistance * 10);
	}

	public String getWord() 
	{
		return word;
	}

	public int getEditDistance() 
	{
		return editDistance;
	}

	public int getConfidenceLevelAsPercentage() 
	{
		return confidenceLevelAsPercentage;
	}

	@Override
	public String toString() 
	{
		StringBuilder builder = new StringBuilder();
		builder.append("MatchEntity [word=");
		builder.append(word);
		builder.append(", editDistance=");
		builder.append(editDistance);
		builder.append(", confidenceLevelAsPercentage=");
		builder.append(confidenceLevelAsPercentage);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + confidenceLevelAsPercentage;
		result = prime * result + editDistance;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatchEntity other = (MatchEntity) obj;
		if (confidenceLevelAsPercentage != other.confidenceLevelAsPercentage)
			return false;
		if (editDistance != other.editDistance)
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}
	
}
