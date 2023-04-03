1. For Fields
modelName: Model name of a vehicle
company: Company to produce the model
owner: Owner of the vehicle
engineType: Type of the engine. Classified by fuel type to be used such as gasoline, diesel, or hybrid
tankSize: Size of fuel tank. Unit is liter.
fuelConsumption: Fuel consumption. Unit is km/liter.
numberOfSeats: Integer number of seats in a vehicle.
airConditionOn: Boolean status of aircondition's working: ON/OFF.
hasAutoDoor: Boolean status of a vehicle's having auto door.
power: Horse Power of a vehicles's engine.

2. For Methods
movableDistance(): Getting information of movable distance of a vehicle when the tank of the vehicle is filled fully.
costFor100Km(PetroleumPrice): Calculating cost for running 100Kms with the engine type and the petroleum price passed by as parameter. It will be different according to fuel and aircondition's status.
setAirConditionON: Setting the aircondition of the vehicle to ON.
You can guess other methods.

3. Some conditions to write methods
The Car uses only gasoline engine. 
The MiniVan can use engine of both gasoline and diesel. But the fuel consumption is same for both gasoline and diesel.
The Truck uses only diesel engine.
The engine type "Hybrid" uses only gasoline.
Default aircondition status is OFF, and the aircondition can be ON/OFF after instances being created by setAirConON/setAirConOFF methods.
Defualt fuel consumption is when aircondition is OFF.
Fuel consumption of the Car decreases by 85% when aircondition of the Car is ON.
Fuel consumption of the MiniVan and the Truck decreases by 75% when aircondition of the Car is ON.
For Petroleum Price: Gasoline(128.7 yen/liter), Diesel(105.7 yen/liter)

![image](https://user-images.githubusercontent.com/109078028/229519275-9adc9566-5f9c-414a-a09b-522d0f24fad2.png)
