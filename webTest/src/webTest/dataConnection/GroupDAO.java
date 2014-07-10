package webTest.dataConnection;

import javax.persistence.EntityManager;

import webTest.entity.Group;

public class GroupDAO extends Tranaction<Group> {

	public GroupDAO(EntityManager em) {
		super(em);
	}

}
