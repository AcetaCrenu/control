package ma.merbah.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.merbah.project.entities.Service;



@Repository
public interface ServiceRepository extends JpaRepository<Service, Long>{

}
