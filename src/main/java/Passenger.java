public class Passenger {
    private String name;
    private int bags;

    public Passenger(String name, int bags){
        this.name = name;
        this.bags = bags;
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

//    public int getBaggageWeight() {
//        return this.bags * 15;
//    }
}
