package entity;

import utils.Utilities;

public class UniverseEntity {

	final int productOfChars;
	final String originalEntry;
	
	public UniverseEntity(String originalEntry) {
		this.originalEntry = originalEntry;
		productOfChars = calculateProductOfChars(originalEntry);
	}

	protected int calculateProductOfChars(String originalEntry) {
	  return Utilities.calculateProductOfChars(originalEntry);
	}
	
	public int getProductOfChars()
	{
		return productOfChars;
	}
	
	public String getOriginalEntry()
	{
		return originalEntry;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UniverseEntity [productOfChars=");
		builder.append(productOfChars);
		builder.append(", originalEntry=");
		builder.append(originalEntry);
		builder.append("]");
		return builder.toString();
	}
	
	
}
