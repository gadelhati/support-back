package mb.clti.support.persistence.repository;

import java.util.UUID;

public interface RepositoryInterface<T> {

    T findByName(String name);
    boolean existsByNameIgnoreCaseAndIdNot(String username, UUID id);
    boolean existsByNameIgnoreCase(String value);
}