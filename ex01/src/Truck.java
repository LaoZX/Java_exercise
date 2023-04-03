public class Truck extends Vehicle{
    int numberOfSeats,HorsePower;
    boolean airConditionOn=false;

    public Truck(String modInfo, String companyInfo, String ownerInfo, String engineInfo, double tankInfo, double fuelConsu, int seat,int power){
        this.modelName=modInfo;
        this.company=companyInfo;
        this.owner=ownerInfo;
        this.engineType=engineInfo;
        this.tankSize=tankInfo;
        this.fuelConsumption=fuelConsu;
        setNumberOfSeat(seat);
        setPower(power);
    }

    void setAirConditionOn(){
        this.airConditionOn = true;
        this.fuelConsumption *= 0.75;
    }
    void setAirConditionOff(){this.airConditionOn=false;}
    double costFor100Km(PetroleumPrice price){//truck only use diesel
        return 100 / this.fuelConsumption * price.getDieselCost();
    }

    void setNumberOfSeat(int n){this.numberOfSeats=n;}
    void setPower(int p){this.HorsePower=p;}
    public String toString(){
        return super.toString() + ", NumberOfSeat: "+numberOfSeats + ", HorsePower:"+HorsePower;
    }
}
