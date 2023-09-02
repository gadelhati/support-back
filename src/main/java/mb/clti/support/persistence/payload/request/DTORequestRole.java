package mb.clti.support.persistence.payload.request;

import mb.clti.support.exception.annotation.UniqueNameRole;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter @UniqueNameRole
public class DTORequestRole {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
}