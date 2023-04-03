public class Car extends Vehicle {
    int numberOfSeats;
    boolean airConditionOn=false;

    public Car(String modInfo, String companyInfo, String ownerInfo, String engineInfo, double tankInfo, double fuelConsu, int seat){
        this.modelName=modInfo;
        this.company=companyInfo;
        this.owner=ownerInfo;
        this.engineType=engineInfo;
        this.tankSize=tankInfo;
        this.fuelConsumption=fuelConsu;
        setNumberOfSeat(seat);
    }

    void setAirConditionOn(){
        this.airConditionOn = true;
        this.fuelConsumption *= 0.85;
    }
    void setAirConditionOff(){this.airConditionOn=false;}
    double costFor100Km(PetroleumPrice price){//car only use gasoline    
        return 100 / this.fuelConsumption * price.getGasolineCost();
    }

    void setNumberOfSeat(int n){this.numberOfSeats=n;}
    public String toString(){
        return super.toString() + ", NumberOfSeat: "+numberOfSeats;
    }
}
