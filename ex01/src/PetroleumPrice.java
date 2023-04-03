public class PetroleumPrice {
    protected double gasolinePrice;
    protected double dieselPrice;
    
    public PetroleumPrice(double gasoline, double diesel){
        gasolinePrice=gasoline;
        dieselPrice=diesel;
    }
    public double getGasolineCost(){
        return this.gasolinePrice;
    }
    public double getDieselCost(){
        return this.dieselPrice;
    }
}
