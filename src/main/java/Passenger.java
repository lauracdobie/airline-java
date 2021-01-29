public class Passenger {
    private String name;
    private int bags;
    private Flight flight;

    public Passenger(String name, int bags){
        this.name = name;
        this.bags = bags;
        this.flight = null;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getNumberOfBags() {
        return this.bags;
    }

    public void setNumberOfBags(int bags) {
        this.bags = bags;
    }

    public Flight getFlight() {
        return this.flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
