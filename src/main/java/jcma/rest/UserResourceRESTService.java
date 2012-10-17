package jcma.rest;

import jcma.model.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/users")
@RequestScoped
public class UserResourceRESTService {
// ------------------------------ FIELDS ------------------------------

    @SuppressWarnings("unused")
    @Inject
    private EntityManager em;

// -------------------------- OTHER METHODS --------------------------

    @SuppressWarnings("unchecked")
    @GET
    @Produces("text/xml")
    public List<User> listAllUsers()
    {
        return em.createQuery("select m from User m order by m.userName").getResultList();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("text/xml")
    public User lookupMemberById(@PathParam("id") long id)
    {
        return em.find(User.class, id);
    }
}
