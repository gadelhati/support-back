package mb.clti.support.persistence.repository;

import mb.clti.support.persistence.model.Host;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryHost extends JpaRepository<Host, UUID>, RepositoryInterface<Host> {
    boolean existsByIpIgnoreCaseAndIdNot(String username, UUID id);
    boolean existsByIpIgnoreCase(String value);
    boolean existsByMacIgnoreCaseAndIdNot(String username, UUID id);
    boolean existsByMacIgnoreCase(String value);
}