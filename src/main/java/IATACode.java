public enum IATACode {
    ABZ("Aberdeen Dyce Airport"),
    BFS("Belfast International Airport"),
    BHX("Birmingham International Airport"),
    BRS("Bristol Airport"),
    CWL("Cardiff International Airport"),
    EDI("Edinburgh Airport"),
    GLA("Glasgow International Airport"),
    LGW("London Gatwick Airport"),
    LHR("London Heathrow Airport"),
    MAN("Manchester Airport"),
    NCL("Newcastle Airport");

    public final String airportName;

    IATACode(String airportName){
        this.airportName = airportName;
    }

    public String getAirportName(){
        return this.airportName;
    }
}


