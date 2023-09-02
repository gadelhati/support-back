package mb.clti.support.persistence;

import mb.clti.support.persistence.model.*;
import mb.clti.support.persistence.payload.request.*;
import mb.clti.support.persistence.payload.response.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapStruct {

    MapStruct MAPPER = Mappers.getMapper(MapStruct.class);
    DTOResponseHost toDTO(Host host);
    DTOResponseOM toDTO(OM om);
    DTOResponseRole toDTO(Role role);
    DTOResponseUserEntity toDTO(UserEntity userEntity);

    Host toObject(DTORequestHost dtoRequestHost);
    OM toObject(DTORequestOM dtoRequestOM);
    Role toObject(DTORequestRole dtoRequestRole);
    UserEntity toObject(DTORequestUserEntity dtoRequestUserEntity);
}