package mb.clti.support.persistence.repository;

import mb.clti.support.persistence.model.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryRolePage extends PagingAndSortingRepository<Role, UUID>, RepositoryInterfacePage<Role> {

}