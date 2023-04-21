package dev.m3s.programming2.homework3;

public class HourBasedPayment implements Payment {

    private double eurosPerHour = 0;
    private double hours = 0;

    public double getEurosPerHour() {
        return eurosPerHour;
    }

    public void setEurosPerHour(double eurosPerHour){

        if(eurosPerHour > 0.0){
            this.eurosPerHour = eurosPerHour;
        }
    }

    public double getHours(){
        return hours;
    }

    public void setHours(double hours){

        if(hours > 0.0){
            this.hours = hours;
        }
    }

    public double calculatePayment(){

        double salary = 0;
        salary = getHours() * getEurosPerHour();
        

        return salary;
    }
    
}
