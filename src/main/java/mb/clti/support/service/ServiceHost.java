package mb.clti.support.service;

import mb.clti.support.persistence.MapStruct;
import mb.clti.support.persistence.payload.request.DTORequestHost;
import mb.clti.support.persistence.payload.response.DTOResponseHost;
import mb.clti.support.persistence.repository.RepositoryHost;
import mb.clti.support.persistence.repository.RepositoryHostPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceHost implements ServiceInterface<DTOResponseHost, DTORequestHost> {

    private final RepositoryHost repositoryHost;
    private final RepositoryHostPage repositoryHostPage;

    public DTOResponseHost create(DTORequestHost created){
        return MapStruct.MAPPER.toDTO(repositoryHost.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseHost> retrieve(Pageable pageable, String key, String value) {
        switch (key) {
            case "id": {
                return repositoryHostPage.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
            }
            case "name": {
                return repositoryHostPage.findByNameContainingIgnoreCaseOrderByNameAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            case "ip": {
                return repositoryHostPage.findByIpContainingIgnoreCaseOrderByIpAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryHostPage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponseHost update(UUID id, DTORequestHost updated){
        return MapStruct.MAPPER.toDTO(repositoryHost.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseHost delete(UUID id){
        DTOResponseHost dtoResponseHost = MapStruct.MAPPER.toDTO(repositoryHost.findById(id).orElse(null));
        repositoryHost.deleteById(id);
        return dtoResponseHost;
    }
    public void delete() {
        repositoryHost.deleteAll();
    }

    public boolean existsByName(String value) {
        return repositoryHost.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryHost.existsByNameIgnoreCaseAndIdNot(value, id);
    }
    public boolean existsByIp(String value) {
        return repositoryHost.existsByIpIgnoreCase(value);
    }
    public boolean existsByIpAndIdNot(String value, UUID id) {
        return repositoryHost.existsByIpIgnoreCaseAndIdNot(value, id);
    }
    public boolean existsByMac(String value) {
        return repositoryHost.existsByMacIgnoreCase(value);
    }
    public boolean existsByMacAndIdNot(String value, UUID id) {
        return repositoryHost.existsByMacIgnoreCaseAndIdNot(value, id);
    }
}