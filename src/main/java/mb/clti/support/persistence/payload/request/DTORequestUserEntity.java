package mb.clti.support.persistence.payload.request;

import mb.clti.support.exception.annotation.*;
import mb.clti.support.persistence.model.Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.UUID;

@Getter @Setter @UniqueNameUser
public class DTORequestUserEntity {

    private UUID id;
    @NotNull(message = "{user.name.not.null}") @NotBlank(message = "{user.name.not.blank}") @HasLength
    private String username;
    @NotNull(message = "{user.email.not.null}") @NotBlank(message = "{user.email.not.blank}") @Size(max = 50) @Email
    private String email;
    @NotNull(message = "{password.not.null}") @NotBlank(message = "{password.not.blank}") @HasDigit @HasUpperCase @HasLowerCase @HasMore
    private String password;
    @NotNull(message = "{user.active.not.null}")
    private boolean active;
    private Collection<Role> role;
}