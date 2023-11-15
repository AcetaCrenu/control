package ma.merbah.project.controller;

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

import ma.merbah.project.entities.Service;
import ma.merbah.project.service.ServiceService;

@RestController
@RequestMapping("/api/v1/service")
public class ServiceController {

	@Autowired
    private ServiceService serviceI;
	
	@GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Service service = serviceI.findById(id);
        if (service == null) {
            return new ResponseEntity<Object>("Employe avec Id " + id + " nexiste pas", HttpStatus.BAD_REQUEST);

        } else {
            return ResponseEntity.ok(service);
        }
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<Object> deletService(@PathVariable Long id) {
		Service service = serviceI.findById(id);
        if (service == null) {
            return new ResponseEntity<Object>("Employe avec Id " + id + " nexiste pas", HttpStatus.BAD_REQUEST);
        } else {
            serviceI.delete(service);
            return ResponseEntity.ok("employe avec id " + id + " suprime");
        }
    }
	
	@PutMapping("/{id}")
    public ResponseEntity<Object> updateService(@PathVariable Long id, @RequestBody Service newservice) {

    	Service oldService = serviceI.findById(id);
        if (oldService == null) {
            return new ResponseEntity<Object>("employe avec id" + id + "nexiste pas ", HttpStatus.BAD_REQUEST);

        } else {
            newservice.setId(id);
            return ResponseEntity.ok(serviceI.update(newservice));
        }
    }
	@PostMapping
    public Service creatEmploye(@RequestBody Service service) {
        service.setId(0L);
        return serviceI.create(service);
    }
	 
}
