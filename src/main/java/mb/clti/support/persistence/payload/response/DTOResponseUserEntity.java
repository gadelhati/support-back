package mb.clti.support.persistence.payload.response;

import mb.clti.support.persistence.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;
import java.util.UUID;

@Getter @AllArgsConstructor
public class DTOResponseUserEntity {

    private UUID id;
    private String username;
    private String email;
    private String password;
    private Boolean active;
    private Collection<Role> role;
}