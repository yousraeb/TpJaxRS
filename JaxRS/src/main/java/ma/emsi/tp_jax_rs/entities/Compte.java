package ma.emsi.tp_jax_rs.entities;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    private Long id;
    private double solde;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Enumerated (EnumType.ORDINAL)
    private TypeCompte type;
}