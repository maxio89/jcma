package jcma.view;

import jcma.UserDAO;
import jcma.model.User;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.PatternSyntaxException;

@Model

public class RegistrationView implements Serializable {
// ------------------------------ FIELDS ------------------------------

    private boolean confirmationPanelVisible;

    @Inject
    private UserDAO userDAO;





    List<String> countries = new ArrayList();
    List<String> genders = new ArrayList();
    List<String> jobs = new ArrayList();



// --------------------- GETTER / SETTER METHODS ------------------
    public List getGenders() {


        if (!genders.isEmpty()) genders.clear();
        genders.add("male");
        genders.add("female");

        return genders;
    }

    public List getCountries() {

        if (!countries.isEmpty()) countries.clear();
        countries.add("pl");
        countries.add("us");
        return countries;
    }

    public List getJobs() {

        if (!jobs.isEmpty()) jobs.clear();
        jobs.add("it");
        jobs.add("cos");
        return jobs;
    }



// -------------------------- OTHER METHODS --------------------------



    public void cancel()
    {
        confirmationPanelVisible = true;
    }




    public void proceedWithoutSave()
    {
//        confirmationPanelVisible = false;
//        newUser = new User();
//        password = nu  }


    }


    public void register() throws NoSuchAlgorithmException, ParseException {


        userDAO.register();

       }


}
