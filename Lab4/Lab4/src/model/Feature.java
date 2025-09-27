
package model;

/**
 *
 * @author agnel
 */
public class Feature {
    private String name;
    private String value;
    
    // Default constructor
    public Feature() {
        this.name = "";
        this.value = "";
    }
    
    // Parameterized constructor
    public Feature(String name, String value) {
        this.name = name;
        this.value = value;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public String getValue() {
        return value;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return name + ": " + value;
    }
}