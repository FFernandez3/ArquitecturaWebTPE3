package repository;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.EntityManager;

public class BaseJPARepository<Entity, ID extends Serializable> implements Repository<Entity, ID> {
	EntityManager entityManager;
	Class<Entity> entityClass;
	Class<ID> idClass;
	
	
	public BaseJPARepository(EntityManager entityManager, Class<Entity> entityClass, Class<ID> idClass) {
		super();
		this.entityManager = entityManager;
		this.entityClass = entityClass;
		this.idClass = idClass;
	}

	@Override
	public Entity findById(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity persist(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entity delete(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
