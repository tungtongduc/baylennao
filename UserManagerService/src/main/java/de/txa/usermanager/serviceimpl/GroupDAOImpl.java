package de.txa.usermanager.serviceimpl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;

import de.txa.usermanager.entity.GroupEntity;
import de.txa.usermanager.entity.UserEntity;
import de.txa.usermanager.service.GroupDAO;

@Component
public class GroupDAOImpl extends BaseDAOImpl<GroupEntity> implements GroupDAO{

	private static final String SELECT = "SELECT g ";
	private static final String FROM_GROUPENTITY = "FROM GroupEntity g ";
	private static final String WHERE = "WHERE ";
	private static final String FILTER_BY_GROUPNAME = "g.groupName=:groupName ";

	@SuppressWarnings("unchecked")
	@Override
	public List<GroupEntity> findGroupByName(String groupName) {
		Query q = em.createQuery( SELECT + FROM_GROUPENTITY + WHERE + FILTER_BY_GROUPNAME);
		q.setParameter("groupName", groupName);
		return (List<GroupEntity>) q.getResultList();
	}

	@Override
	public GroupEntity findGroupById(long id) {
		return em.find(GroupEntity.class, id);
	}

	@Override
	public List<UserEntity> findAllUserFromGroup() {
		// TODO Auto-generated method stub
		return null;
	}
}
