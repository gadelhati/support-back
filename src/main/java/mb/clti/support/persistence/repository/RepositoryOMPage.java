package mb.clti.support.persistence.repository;

import mb.clti.support.persistence.model.OM;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryOMPage extends PagingAndSortingRepository<OM, UUID>, RepositoryInterfacePage<OM> {

}