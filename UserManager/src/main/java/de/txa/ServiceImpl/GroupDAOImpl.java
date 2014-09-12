package de.txa.ServiceImpl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import de.txa.entity.GroupEntity;
import de.txa.service.GroupDAO;

@Component
@Transactional(propagation =  Propagation.SUPPORTS)
public class GroupDAOImpl extends BaseDAOImpl<GroupEntity> implements GroupDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<GroupEntity> findGroupByName(String groupName) {
		Query q = em.createQuery("SELECT g FROM GroupEntity g WHERE g.name=:groupName");
		q.setParameter("groupName", groupName);
		return (List<GroupEntity>) q.getResultList();
	}

	@Override
	public GroupEntity findGroupById(long id) {
		return em.find(GroupEntity.class, id);
	}
}
