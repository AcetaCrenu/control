package ma.merbah.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  ma.merbah.project.Dao.IDao;
import  ma.merbah.project.entities.Employe;
import  ma.merbah.project.repository.EmployeRepository;

@Service
public class EmployeService  implements IDao<Employe> {
	
	 @Autowired
	 EmployeRepository employeRepository;

	@Override
	public Employe create(Employe o) {
		// TODO Auto-generated method stub
		return employeRepository.save(o);
	}

	@Override
	public List<Employe> findAll() {
		// TODO Auto-generated method stub
		return employeRepository.findAll() ;
	}

	@Override
	public Employe update(Employe o) {
		// TODO Auto-generated method stub
		return employeRepository.save(o);
	}

	@Override
	public boolean delete(Employe o) {
		// TODO Auto-generated method stub
		try {
			employeRepository.delete(o);
            return true;
        } catch (Exception e) {
            return false;
        }
	}

	@Override
	public Employe findById(Long id) {
		// TODO Auto-generated method stub
		return employeRepository.findById(id).orElse(null);
	}
	
	
}
