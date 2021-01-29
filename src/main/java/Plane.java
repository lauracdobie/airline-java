public class Plane {

    private PlaneType model;
    private int capacity;
    private int totalWeight;

    public Plane(PlaneType model, int capacity, int totalWeight){
        this.model = model;
        this.capacity = capacity;
        this.totalWeight = totalWeight;
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

    public int getTotalWeight() {
        return this.totalWeight;
    }

    public void setTotalWeight(int weight) {
        this.totalWeight = weight;
    }
}
