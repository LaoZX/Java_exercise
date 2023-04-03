public class MiniVan extends Vehicle {
    int numberOfSeats;
    boolean airConditionOn=false, hasAutoDoor;

    public MiniVan(String modInfo, String companyInfo, String ownerInfo, String engineInfo, double tankInfo, double fuelConsu, int seat, boolean
    door){
        this.modelName=modInfo;
        this.company=companyInfo;
        this.owner=ownerInfo;
        this.engineType=engineInfo;
        this.tankSize=tankInfo;
        this.fuelConsumption=fuelConsu;
        setNumberOfSeat(seat);
        setHasAutoDoor(door);
    }

    void setAirConditionOn(){
        this.airConditionOn = true;
        this.fuelConsumption *= 0.75;
    }
    void setAirConditionOff(){this.airConditionOn=false;}
    double costFor100Km(PetroleumPrice priceInfo){
        double price = (this.engineType.equals("Gasoline")) ? priceInfo.getGasolineCost(): priceInfo.getDieselCost();
    
        return 100 / this.fuelConsumption * price;
    }

    void setNumberOfSeat(int n){this.numberOfSeats=n;}
    void setHasAutoDoor(boolean b){this.hasAutoDoor=b;}
    public String toString(){
        return super.toString() + ", NumberOfSeat: "+numberOfSeats + ", HasAutoDoor: "+hasAutoDoor;
    }
}
