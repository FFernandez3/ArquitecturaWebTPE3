package repository;

import java.io.Serializable;
import java.util.List;

//no tiene ningun uso despues borrarlas
public interface Repository <Entity, ID extends Serializable> {
	public Entity findById(ID id);
	public Entity persist(Entity entity);
	public Entity delete(ID id);
	public List<Entity> findAll();

}
