package mb.clti.support.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;

@Audited @Entity @Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false)
public class Host extends GenericEntity {

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