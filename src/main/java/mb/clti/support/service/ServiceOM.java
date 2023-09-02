package mb.clti.support.service;

import mb.clti.support.persistence.MapStruct;
import mb.clti.support.persistence.model.OM;
import mb.clti.support.persistence.payload.request.DTORequestOM;
import mb.clti.support.persistence.payload.response.DTOResponseOM;
import mb.clti.support.persistence.repository.RepositoryOM;
import mb.clti.support.persistence.repository.RepositoryOMPage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service @RequiredArgsConstructor
public class ServiceOM implements ServiceInterface<DTOResponseOM, DTORequestOM> {

    private final RepositoryOM repositoryOM;
    private final RepositoryOMPage repositoryOMPage;

    public DTOResponseOM create(DTORequestOM created){
        return MapStruct.MAPPER.toDTO(repositoryOM.save(MapStruct.MAPPER.toObject(created)));
    }
    public Page<DTOResponseOM> retrieve(Pageable pageable, String key, String value){
        switch (key) {
            case "id": {
                return repositoryOMPage.findByIdOrderByIdAsc(pageable, UUID.fromString(value)).map(MapStruct.MAPPER::toDTO);
            }
            case "name": {
                return repositoryOMPage.findByNameContainingIgnoreCaseOrderByNameAsc(pageable, value).map(MapStruct.MAPPER::toDTO);
            }
            default: {
                return repositoryOMPage.findAll(pageable).map(MapStruct.MAPPER::toDTO);
            }
        }
    }
    public DTOResponseOM update(UUID id, DTORequestOM updated){
        return MapStruct.MAPPER.toDTO(repositoryOM.save(MapStruct.MAPPER.toObject(updated)));
    }
    public DTOResponseOM delete(UUID id){
        OM object = repositoryOM.findById(id).orElse(null);
        repositoryOM.deleteById(id);
        return MapStruct.MAPPER.toDTO(object);
    }
    public void delete() {
        repositoryOM.deleteAll();
    }
    public boolean existsByName(String value) {
        return repositoryOM.existsByNameIgnoreCase(value);
    }
    public boolean existsByNameAndIdNot(String value, UUID id) {
        return repositoryOM.existsByNameIgnoreCaseAndIdNot(value, id);
    }
}