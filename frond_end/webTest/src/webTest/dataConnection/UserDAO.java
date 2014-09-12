//package webTest.dataConnection;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//
//import webTest.entity.User;
//
//public class UserDAO extends Tranaction<User> {
//
//	public UserDAO(EntityManager em) {
//		super(em);
//	}
//
//	public LgUser getUserByUsername(String username) {
//		super.em.getTransaction().begin();
//		Query query = super.em.createQuery("from User s where s.username like :username", User.class);
//		query.setParameter("username",username);
//		User user = (User) query.getResultList().get(0);
//		super.em.getTransaction().commit();
//		return user;
//	}
//
//}
