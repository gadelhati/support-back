package mb.clti.support.controller;

import mb.clti.support.persistence.payload.request.DTORequestHost;
import mb.clti.support.persistence.payload.response.DTOResponseHost;
import mb.clti.support.service.ServiceHost;
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

@RestController @RequestMapping("/host") @RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerHost implements ControllerInterface<DTOResponseHost, DTORequestHost> {

    private final ServiceHost serviceHost;

    @PostMapping("") @Override @PreAuthorize("hasAnyHost('OPERATOR', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseHost> create(@RequestBody @Valid DTORequestHost created){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/host").toUriString());
        return ResponseEntity.created(uri).body(serviceHost.create(created));
    }
    @GetMapping("") @Override @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Page<DTOResponseHost>> retrieve(@RequestParam(name = "key", defaultValue = "", required = false) String key, @RequestParam(name = "value", defaultValue = "", required = false) String value, Pageable pageable){
        return ResponseEntity.ok().body(serviceHost.retrieve(pageable, key, value));
    }
    @PutMapping("") @Override @PreAuthorize("hasAnyHost('OPERATOR', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseHost> update(@RequestBody @Valid DTORequestHost updated){
        return ResponseEntity.accepted().body(serviceHost.update(updated.getId(), updated));
    }
    @DeleteMapping("/{id}") @Override @PreAuthorize("hasAnyHost('OPERATOR', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<DTOResponseHost> delete(@PathVariable UUID id){
        return ResponseEntity.accepted().body(serviceHost.delete(id));
    }
    @DeleteMapping("") @Override @PreAuthorize("hasAnyHost('OPERATOR', 'MODERATOR', 'ADMIN')")
    public ResponseEntity<HttpStatus> delete(){
        try {
            serviceHost.delete();
            return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }
    }
}