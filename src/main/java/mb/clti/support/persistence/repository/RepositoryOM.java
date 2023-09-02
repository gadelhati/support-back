package mb.clti.support.persistence.repository;

import mb.clti.support.persistence.model.OM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryOM extends JpaRepository<OM, UUID>, RepositoryInterface<OM> {

}