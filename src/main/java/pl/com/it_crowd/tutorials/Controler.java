package pl.com.it_crowd.tutorials;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
        
@SessionScoped
@ManagedBean
public class Controler implements Serializable {
// ------------------------------ FIELDS ------------------------------

    private String response;
    private String password;
    private String username;
    private String buttonText = "login";
    private int cnt = 0;
    private boolean session = false;
    private List<Item> records = null;
    
// --------------------- GETTER / SETTER METHODS ---------------------
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

// -------------------------- OTHER METHODS --------------------------

    
    private void initRecords() {
        records = new ArrayList<Item>();
        Item item;
        item = new Item("Peter", "Griffin", 30);
        //item.setName("Peter");
        //item.setLastName("Griffin");
        //item.setAge(30);
        records.add(item);
        item = new Item("Lois", "Griffin", 29);
        records.add(item);
        item = new Item("Chris", "Griffin", 16);
        records.add(item);
        item = new Item("Meg", "Griffin", 15);
        records.add(item);
        item = new Item("Stewie", "Griffin", 1);
        records.add(item);
        item = new Item("Brian", "Dog", 10);
        records.add(item);

        
    }
    
    public List<Item> getRecords() {
        if (records == null) {
            initRecords();
        }
        return records;
    }
 
    public void setRecords(List<Item> records) {
        this.records = records;
    }
    
}
