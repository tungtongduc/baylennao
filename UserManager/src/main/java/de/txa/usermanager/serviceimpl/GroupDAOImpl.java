package de.txa.usermanager.serviceimpl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import de.txa.usermanager.entity.GroupEntity;
import de.txa.usermanager.entity.UserEntity;
import de.txa.usermanager.service.GroupDAO;

@Component
@Transactional(propagation =  Propagation.SUPPORTS)
public class GroupDAOImpl extends BaseDAOImpl<GroupEntity> implements GroupDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<GroupEntity> findGroupByName(String groupName) {
		Query q = em.createQuery("SELECT g FROM GroupEntity g WHERE g.groupName=:groupName");
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
