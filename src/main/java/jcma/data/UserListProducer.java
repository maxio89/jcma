package jcma.data;

import jcma.model.User;
import jcma.model.User_;
import jcma.view.LoginView;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;

import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@RequestScoped
public class UserListProducer {
// ------------------------------ FIELDS ------------------------------

   @Inject
   private EntityManager em;

   private List<User> users;

//    @ManagedProperty(value="#{loginView}")
//    private LoginView bean;


// --------------------- GETTER / SETTER METHODS ---------------------

   @Produces
   @Named
   public List<User> getUsers() {
      return users;
   }

// -------------------------- OTHER METHODS --------------------------

   public void onUserListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final User user) {
      retrieveAllMembersOrderedByName();
   }

   @PostConstruct
   public void retrieveAllMembersOrderedByName() {
      CriteriaBuilder cb = em.getCriteriaBuilder();
      CriteriaQuery<User> criteria = cb.createQuery(User.class);
      Root<User> user = criteria.from(User.class);
      //criteria.select(user).orderBy(cb.asc(user.get(User_.userName)));
      Object obj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginView");
      LoginView bean = (LoginView)obj;
       String userName = bean.getFilterUserName();

       String gender = bean.getFilterGender();
       System.out.println("############################" + userName + gender);
       System.out.println("############################" + bean.toString());
       //String userName = "p";
       //criteria.select(user);
       //ParameterExpression<String> nameTmp = cb.parameter( String.class );
       criteria.where(cb.like(user.get(User_.userName), "%" + userName + "%"));
       //TypedQuery<User> query = em.createQuery( criteria );
       //query.setParameter( nameTmp, "%" + userName + "%" );

      users = em.createQuery(criteria).getResultList();
   }


}
