package mb.clti.support.persistence.repository;

import mb.clti.support.persistence.model.Host;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface RepositoryHostPage extends PagingAndSortingRepository<Host, UUID>, RepositoryInterfacePage<Host> {

    Page<Host> findByIpContainingIgnoreCaseOrderByIpAsc(Pageable pageable, String ip);
    Page<Host> findBySoContainingIgnoreCaseOrderBySoAsc(Pageable pageable, String ip);
    Page<Host> findBySealContainingIgnoreCaseOrderBySealAsc(Pageable pageable, String ip);
    Page<Host> findByMemoryContainingIgnoreCaseOrderByMemoryAsc(Pageable pageable, String ip);
    Page<Host> findByHdContainingIgnoreCaseOrderByHdAsc(Pageable pageable, String ip);
    Page<Host> findByProcessorContainingIgnoreCaseOrderByProcessorAsc(Pageable pageable, String ip);
    Page<Host> findByMacContainingIgnoreCaseOrderByMacAsc(Pageable pageable, String ip);
}