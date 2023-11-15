package ma.merbah.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ma.merbah.project.Dao.IDao;
import ma.merbah.project.entities.Service;
import ma.merbah.project.repository.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceService implements IDao<Service> {
	
	@Autowired
	ServiceRepository serviceRepository ;

	@Override
	public Service create(Service o) {
		// TODO Auto-generated method stub
		return serviceRepository.save(o);
	}

	@Override
	public List<Service> findAll() {
		// TODO Auto-generated method stub
		return serviceRepository.findAll();
	}

	@Override
	public Service update(Service o) {
		// TODO Auto-generated method stub
		return serviceRepository.save(o);
	}

	@Override
	public boolean delete(Service o) {
		// TODO Auto-generated method stub
		try {
			serviceRepository.delete(o);
            return true;
        } catch (Exception e) {
            return false;
        }
	}

	@Override
	public Service findById(Long id) {
		// TODO Auto-generated method stub
		return serviceRepository.findById(id).orElse(null);
	}

}
