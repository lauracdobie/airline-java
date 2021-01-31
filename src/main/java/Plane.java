import java.util.ArrayList;

public class Plane {

    private PlaneType model;
    private int capacity;
    private int totalWeight;
    private int seats;
    private ArrayList<Integer> seatNumbers;

    public Plane(PlaneType model, int capacity, int totalWeight){
        this.model = model;
        this.capacity = capacity;
        this.seats = seats;
        this.totalWeight = totalWeight;
        this.seatNumbers = new ArrayList<>();
        int seatNumber = 1;
        while (seatNumbers.size() < this.capacity) {
            seatNumbers.add(seatNumber);
            seatNumber ++;
        }
    }

    public PlaneType getModel(){
        return this.model;
    }

    public void setModel(PlaneType model) {
        this.model = model;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Integer> getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(ArrayList<Integer> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    //    public int getSeats() {
//        return this.seats;
//    }
//
//    public void setSeats(int number) {
//        this.seats = number;
//    }

    public int getTotalWeight() {
        return this.totalWeight;
    }

    public void setTotalWeight(int weight) {
        this.totalWeight = weight;
    }
}
