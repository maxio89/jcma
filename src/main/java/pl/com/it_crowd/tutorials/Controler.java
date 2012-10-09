package pl.com.it_crowd.tutorials;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
        
@RequestScoped
@ManagedBean
public class Controler implements Serializable {
// ------------------------------ FIELDS ------------------------------

    private boolean filter = false;
    private int lessNumber;
    private int greaterNumber;
    private String name;
    private String lastName;

   

    private List<Item> records = null;
    
    
    
// --------------------- GETTER / SETTER METHODS ---------------------


    public void setFilter() {
        this.filter = filter;
    }

    public int getLessNumber() {
        return lessNumber;
    }

    public void setLessNumber(int lessNumber) {
        this.lessNumber = lessNumber;
    }

    public int getGreaterNumber() {
        return greaterNumber;
    }

    public void setGreaterNumber(int greaterNumber) {
        this.greaterNumber = greaterNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
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
    


// -------------------------- OTHER METHODS --------------------------

  private void initRecords() {
        records = new ArrayList<Item>();
        Item item;
        item = new Item("Peter", "Griffin", 30);
        item.setName("Peter");
        item.setLastName("Griffin");
        item.setAge(30);
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
  
  }