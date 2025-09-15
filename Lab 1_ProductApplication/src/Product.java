public class Product {
    private String name;
    private String description;
    private int availNum;
    private double price;
    private Address manufactureAddress;
    private Address shippingAddress;
    
    // Constructor
    public Product() {
        this.manufactureAddress = new Address();
        this.shippingAddress = new Address();
    }
    
    // Constructor with parameters
    public Product(String name, String description, int availNum, double price) {
        this.name = name;
        this.description = description;
        this.availNum = availNum;
        this.price = price;
        this.manufactureAddress = new Address();
        this.shippingAddress = new Address();
    }
    
    // Getters and Setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getAvailNum() {
        return availNum;
    }
    
    public void setAvailNum(int availNum) {
        this.availNum = availNum;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public Address getManufactureAddress() {
        return manufactureAddress;
    }
    
    public void setManufactureAddress(Address manufactureAddress) {
        this.manufactureAddress = manufactureAddress;
    }
    
    public Address getShippingAddress() {
        return shippingAddress;
    }
    
    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
    
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", availNum=" + availNum +
                ", price=" + price +
                ", manufactureAddress=" + manufactureAddress +
                ", shippingAddress=" + shippingAddress +
                '}';
    }
}