package webTest.dataConnection;

import javax.persistence.EntityManager;

import webTest.enumClass.TransactionEnum;

public abstract class Tranaction<E> {

	protected final EntityManager em;

	public Tranaction(EntityManager em) {
		this.em = em;
	}

	public EntityManager getEm() {
		return em;
	}

	public E execute(TransactionEnum action, E entity) {
		E e = null;
		em.getTransaction().begin();
		try {
			switch (action) {
			case CREATE:
				create(entity);
				break;
			case UPDATE:
				update(entity);
				break;
			case DELETE:
				deleted(entity);
				break;
			default:
				break;
			}
			em.getTransaction().commit();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		} finally {
			em.close();
		}

		return e;
	}

	protected void create(E entity) {
		em.persist(entity);
	}

	protected void update(E entity) {
		em.merge(entity);
	}

	protected void deleted(E entity) {
		em.remove(entity);
	}

	public E findByID(long id, Class<E> e) {
		E eFind = null;
		em.getTransaction().begin();
		try {
			eFind = em.find(e, id);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		} finally {
			em.close();
		}
		return eFind;
	}
}
