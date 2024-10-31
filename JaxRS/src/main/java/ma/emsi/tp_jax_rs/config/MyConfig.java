package ma.emsi.tp_jax_rs.config;
import ma.emsi.tp_jax_rs.service.CompteRestJaxRSAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.glassfish.jersey.server.ResourceConfig;

@Configuration
public class MyConfig {
    @Bean
    public ResourceConfig resourceConfig() {
        ResourceConfig jerseyServlet = new ResourceConfig() ;
        jerseyServlet.register(CompteRestJaxRSAPI.class) ;
        return jerseyServlet;
    }
}