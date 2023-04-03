public abstract class Vehicle {
    String modelName, company, owner, engineType;
    double tankSize, fuelConsumption;

    public String toString(){
        return "ModelName: "+modelName + ", Company: "+company
         + ", Owner: "+owner + ", EngineType: "+engineType
         + ", TankSize: "+tankSize + ", FuelConsumption: "+fuelConsumption;
    }
    public double movableDistance(){//when the tank is filled fully.
        return tankSize * fuelConsumption;
    }

    abstract double costFor100Km(PetroleumPrice price);//money for 100km
    abstract void setAirConditionOn();
    abstract void setAirConditionOff();

}
