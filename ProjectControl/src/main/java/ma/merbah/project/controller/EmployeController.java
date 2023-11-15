package ma.merbah.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.ensaj.gestionprof.entities.Professseur;
import ma.merbah.project.entities.Employe;
import ma.merbah.project.service.EmployeService;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeController {

	@Autowired
    private EmployeService service;
	
	 @GetMapping("/{id}")
	    public ResponseEntity<Object> findById(@PathVariable Long id) {
	        Employe employe = service.findById(id);
	        if (employe == null) {
	            return new ResponseEntity<Object>("Employe avec Id " + id + " nexiste pas", HttpStatus.BAD_REQUEST);

	        } else {
	            return ResponseEntity.ok(employe);
	        }
	    }
	 @DeleteMapping("/{id}")
	    public ResponseEntity<Object> deletEmploye(@PathVariable Long id) {
		 Employe employe = service.findById(id);
	        if (employe == null) {
	            return new ResponseEntity<Object>("Employe avec Id " + id + " nexiste pas", HttpStatus.BAD_REQUEST);
	        } else {
	            service.delete(employe);
	            return ResponseEntity.ok("employe avec id " + id + " suprime");
	        }
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Object> updateEmploye(@PathVariable Long id, @RequestBody Employe newemploye) {

	    	Employe oldEmploye = service.findById(id);
	        if (oldEmploye == null) {
	            return new ResponseEntity<Object>("employe avec id" + id + "nexiste pas ", HttpStatus.BAD_REQUEST);

	        } else {
	            newemploye.setId(id);
	            return ResponseEntity.ok(service.update(newemploye));
	        }
	    }

	    @PostMapping
	    public Employe creatEmploye(@RequestBody Employe employe) {
	        employe.setId(0L);
	        return service.create(employe);
	    }
	    @GetMapping
	    public List<Employe> findAllEmployees() {
	        return service.findAll();
	    }
	    
	 
}
