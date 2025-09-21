/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class VitalSign {
    String date;
    float temperature;
    double bloodPressure;
    int pulse;
    boolean isConcious;
    
    public VitalSign(){
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Double getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(Double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public Boolean getIsConcious() {
        return isConcious;
    }

    public void setIsConcious(Boolean isConcious) {
        this.isConcious = isConcious;
    }
    
    @Override
    public String toString(){
        return getDate();
    }
}
