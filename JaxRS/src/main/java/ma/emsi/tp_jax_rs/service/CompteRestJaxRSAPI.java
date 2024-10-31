package ma.emsi.tp_jax_rs.service;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.emsi.tp_jax_rs.entities.Compte;
import ma.emsi.tp_jax_rs.repositories.CompteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Path("/banque")
public class CompteRestJaxRSAPI {
    @Autowired
    private CompteRepo compteRepo;

    // READ: Récupérer tous les comptes
    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public List<Compte> getComptes() {
        return compteRepo.findAll();
    }

    // READ: Récupérer un compte par son identifiant
    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Compte getCompte(@PathParam("id") Long id) {
        return compteRepo.findById(id).orElse(null);
    }

    // CREATE: Ajouter un nouveau compte
    @Path("/comptes")
    @POST
    @Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Compte addCompte(Compte compte) {
        return compteRepo.save(compte);
    }

    // UPDATE: Mettre à jour un compte existant
    @Path("/comptes/{id}")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public Compte updateCompte(@PathParam("id") Long id, Compte compte) {
        Compte existingCompte = compteRepo.findById(id).orElse(null);
        if (existingCompte != null) {
            existingCompte.setSolde(compte.getSolde());
            existingCompte.setDateCreation(compte.getDateCreation());
            existingCompte.setType(compte.getType());
            return compteRepo.save(existingCompte);
        }
        return null;
    }

    // DELETE: Supprimer un compte
    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    public void deleteCompte(@PathParam("id") Long id) {
        compteRepo.deleteById(id);
    }
}
