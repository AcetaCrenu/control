package ma.merbah.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.merbah.project.entities.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {

	
}
