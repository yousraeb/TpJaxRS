package ma.emsi.tp_jax_rs;
import ma.emsi.tp_jax_rs.entities.Compte;
import ma.emsi.tp_jax_rs.entities.TypeCompte;
import ma.emsi.tp_jax_rs.repositories.CompteRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Date;

@SpringBootApplication
public class  TpJaxRsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpJaxRsApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepo compteRepository) {
        return args -> {
            compteRepository.save(new Compte(null, Math.random() * 9000, new
                    Date(), TypeCompte.EPARGNE));
            compteRepository.save(new Compte(null, Math.random() * 9000, new
                    Date(), TypeCompte.COURANT));
            compteRepository.save(new Compte(null, Math.random() * 9000, new
                    Date(), TypeCompte.EPARGNE));
            compteRepository.findAll().forEach(c -> {
                System.out.println(c.toString());
            });
        };
    }
}

