package model;

import java.util.ArrayList;

/**
 *
 * @author Agnel
 */
public class Product {
    
    private String name;
    private int price;
    private int id;
    private ArrayList<Feature> features;

    private static int count = 0;
    
    public Product() {
        count++;
        id = count;
        features = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    // Feature management methods
    public ArrayList<Feature> getFeatures() {
        return features;
    }
    
    public void addFeature(Feature feature) {
        features.add(feature);
    }
    
    public void removeFeature(int index) {
        if (index >= 0 && index < features.size()) {
            features.remove(index);
        }
    }
    
    public void removeFeature(Feature feature) {
        features.remove(feature);
    }
    
    public Feature getFeature(int index) {
        if (index >= 0 && index < features.size()) {
            return features.get(index);
        }
        return null;
    }
    
    public int getFeatureCount() {
        return features.size();
    }
    
    @Override
    public String toString() {
        return name;
    }
}