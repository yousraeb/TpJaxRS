package ma.emsi.tp_jax_rs.repositories;

import ma.emsi.tp_jax_rs.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepo extends JpaRepository<Compte, Long> {
}
