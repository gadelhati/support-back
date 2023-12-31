package mb.clti.support.controller;

import mb.clti.support.persistence.payload.request.DTORequestOM;
import mb.clti.support.persistence.payload.response.DTOResponseOM;
import mb.clti.support.service.ServiceOM;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController @RequestMapping("/om") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerOM implements ControllerInterface<DTOResponseOM, DTORequestOM> {

    private final ServiceOM serviceOm;

    @PostMapping("") @Override @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DTOResponseOM> create(@RequestBody @Valid DTORequestOM created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/om").toUriString());
        return ResponseEntity.created(uri).body(serviceOm.create(created));
    }
    @GetMapping("") @Override @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Page<DTOResponseOM>> retrieve(@RequestParam(name = "key", defaultValue = "", required = false) String key, @RequestParam(name = "value", defaultValue = "", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(serviceOm.retrieve(pageable, key, value));
    }
    @PutMapping("") @Override @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DTOResponseOM> update(@RequestBody @Valid DTORequestOM updated){
        return ResponseEntity.accepted().body(serviceOm.update(updated.getId(), updated));
    }
    @DeleteMapping("/{id}") @Override @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<DTOResponseOM> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceOm.delete(id));
    }
    @DeleteMapping("") @Override @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceOm.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}