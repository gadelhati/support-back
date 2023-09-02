package mb.clti.support.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;

@Audited @Entity @Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class Privilege extends GenericEntity {

    private String name;

//    @ManyToMany(mappedBy = "privileges")
//    private Set<Role> roles = new HashSet<>();
}