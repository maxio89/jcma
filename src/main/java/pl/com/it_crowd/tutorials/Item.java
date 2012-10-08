/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.com.it_crowd.tutorials;

/**
 *
 * @author piotrek
 */
public class Item {
    private String name;
    private String lastName;
    private int age;
 
    public Item(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;

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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
}
