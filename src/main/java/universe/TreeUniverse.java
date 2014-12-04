package universe;

import java.util.*;

import entity.UniverseEntity;


public class TreeUniverse implements Universe {

	TreeMap<Integer, List<UniverseEntity>> universe;
	
	public TreeUniverse()
	{
		universe = new TreeMap<>();
	}
	
	@Override
	public void buildUniverse(String[] entities) {
		
		for (String entity : entities)
			addToUniverse(entity);
		
	}

	@Override
	public boolean addToUniverse(String entity) {
		try {
		if (universe.containsKey(entity.length()))
		{
			List<UniverseEntity> entities = universe.get(entity.length());
			entities.add(new UniverseEntity(entity));
			universe.put(entity.length(), entities);
			return true;
		}

		else
		{
			List<UniverseEntity> entities = new ArrayList<>();
			entities.add(new UniverseEntity(entity));
			universe.put(entity.length(), entities);
			return true;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public int sizeOfUniverse() {
		return universe.size();
	}


	@Override
	public List<UniverseEntity> getSubSetOfUniverse(Object key) {
		return universe.get(key) == null?Collections.<UniverseEntity>emptyList():universe.get(key);
	}

	@Override
	public List<UniverseEntity> getSubSetRangeOfUniverse(Object fromKey, Object toKey) {
		SortedMap<Integer, List<UniverseEntity>> rangeMap = universe.subMap((Integer)fromKey, (Integer)toKey);
		Collection<List<UniverseEntity>> collectionOfValues = rangeMap.values();
		Iterator<List<UniverseEntity>> iterator = collectionOfValues.iterator();
		
		List<UniverseEntity> cumulativeEntities = new ArrayList<>();
		
		while(iterator.hasNext())
		{
			cumulativeEntities.addAll(iterator.next());
		}
		
		return cumulativeEntities;
	}

	

}
