public class Address {
    private String streetName;
    private String unitNum;
    private String city;
    private String zipCode;
    
    // Default constructor
    public Address() {
    }
    
    // Constructor with parameters
    public Address(String streetName, String unitNum, String city, String zipCode) {
        this.streetName = streetName;
        this.unitNum = unitNum;
        this.city = city;
        this.zipCode = zipCode;
    }
    
    // Getters and Setters
    public String getStreetName() {
        return streetName;
    }
    
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    
    public String getUnitNum() {
        return unitNum;
    }
    
    public void setUnitNum(String unitNum) {
        this.unitNum = unitNum;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getZipCode() {
        return zipCode;
    }
    
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", unitNum='" + unitNum + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}