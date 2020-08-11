package api.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import api.application.entity.Product;
import api.application.service.Service;

@RestController("product_controller")
public class ProductController implements Controller<Product> {
	@SuppressWarnings("rawtypes")
	@Autowired
	@Qualifier("product_service")
	private Service service;

	@SuppressWarnings("unchecked")
	@Override
	@GetMapping("/products")
	public ResponseEntity<?> getAllObjects() {
		List<Object> objects = new ArrayList<Object>();
		try {
			objects = service.getAll();
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(objects);
	}

	@Override
	@GetMapping("/products/{objectID}")
	public ResponseEntity<?> getObject(String objectID) {
		try {
			Object object = service.get(objectID);
			return ResponseEntity.status(HttpStatus.OK).body(object);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@PutMapping("/products/{objectID}")
	public ResponseEntity<?> updateObject(Product entity, String objectID) {
		try {
			Object object = service.update(objectID, entity);
			return ResponseEntity.status(HttpStatus.OK).body(object);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
		}
	}

	@Override
	@DeleteMapping("/products/{objectID}")
	public ResponseEntity<?> deleteObject(String objectID) {
		try {
			Object object = service.delete(objectID);
			return ResponseEntity.status(HttpStatus.OK).body(object);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@PostMapping("/products")
	public ResponseEntity<?> createObject(Product entity) {
		try {
			Object object = service.add(entity);
			return ResponseEntity.status(HttpStatus.OK).body(object);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
		}
	}
}
