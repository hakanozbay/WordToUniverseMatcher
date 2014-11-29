package universe;

import java.util.List;

import entity.UniverseEntity;



public interface Universe {

	public void buildUniverse(String[] entities);
	public boolean addToUniverse(String entity);
	public int sizeOfUniverse();
	public List<UniverseEntity> getSubSetOfUniverse(Object key);
	public List<UniverseEntity> getSubSetRangeOfUniverse(Object keyFrom, Object KeyTo);
}
