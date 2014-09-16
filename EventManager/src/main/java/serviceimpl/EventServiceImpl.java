package serviceimpl;

import java.util.List;

import javax.inject.Inject;

import service.EventDAO;
import service.EventService;
import dto.EventDTO;

public class EventServiceImpl implements EventService {
	@Inject
	private EventDAO eventDao;
	
	@Override
	public void create(EventDTO eventDTO) {
		eventDao.create(eventDTO);
	}

	@Override
	public void delete(EventDTO eventDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EventDTO> findByEventName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventDTO findByEventID(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
