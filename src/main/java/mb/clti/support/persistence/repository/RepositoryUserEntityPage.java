package mb.clti.support.persistence.repository;

import mb.clti.support.persistence.model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryUserEntityPage extends PagingAndSortingRepository<UserEntity, UUID> {

    Page<UserEntity> findByIdOrderByIdAsc(Pageable pageable, UUID id);
    Page<UserEntity> findByUsernameContainingIgnoreCaseOrderByUsernameAsc(Pageable pageable, String username);
    Page<UserEntity> findByEmailContainingIgnoreCaseOrderByEmailAsc(Pageable pageable, String username);
}