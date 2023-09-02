package mb.clti.support.persistence.payload.request;

import mb.clti.support.exception.annotation.UniqueNameOM;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter @UniqueNameOM
public class DTORequestOM {

    private UUID id;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
}