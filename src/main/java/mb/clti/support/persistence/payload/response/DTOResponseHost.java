package mb.clti.support.persistence.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor @Getter
public class DTOResponseHost {

    private UUID id;
    private String ip;
    private String name;
    private String so;
    private String seal;
    private String memory;
    private String hd;
    private String processor;
    private String mac;
    private boolean active;
}
