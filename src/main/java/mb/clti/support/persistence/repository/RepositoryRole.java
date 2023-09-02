package mb.clti.support.persistence.repository;

import mb.clti.support.persistence.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryRole extends JpaRepository<Role, UUID>, RepositoryInterface<Role> {

}