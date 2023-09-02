package mb.clti.support.persistence.payload.request;

import mb.clti.support.exception.annotation.UniqueHostIp;
import mb.clti.support.exception.annotation.UniqueHostMac;
import mb.clti.support.exception.annotation.UniqueNameHost;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter @UniqueNameHost @UniqueHostIp @UniqueHostMac
public class DTORequestHost {

    private UUID id;
    @NotNull(message = "{ip.not.null}") @NotBlank(message = "{ip.not.blank}")
    private String ip;
    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;
    private String so;
    private String seal;
    private String memory;
    private String hd;
    private String processor;
    @NotNull(message = "{mac.not.null}") @NotBlank(message = "{mac.not.blank}")
    private String mac;
    private boolean active;
}