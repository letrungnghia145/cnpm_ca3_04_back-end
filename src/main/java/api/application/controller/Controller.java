package api.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public interface Controller<Entity> {
	public ResponseEntity<?> getObject(@PathVariable String objectID);

	public ResponseEntity<?> updateObject(@RequestBody Entity entity, @PathVariable String objectID);

	public ResponseEntity<?> deleteObject(@PathVariable String objectID);

	public ResponseEntity<?> createObject(@RequestBody Entity entity);

	public ResponseEntity<?> getAllObjects();
}
