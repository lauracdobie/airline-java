import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static java.lang.Math.round;

public class FlightManager {

    Flight flight;

    public FlightManager (Flight flight) {
        this.flight = flight;
    }

    public int getPassengerBaggageWeight(Passenger passenger) {
        int bagWeight = getFlightBaggageWeight() / this.flight.getPlane().getCapacity();
        return passenger.getNumberOfBags() * bagWeight;
    }

    public int getTotalPassengerBaggageWeight() {
        int totalWeight = 0;
        ArrayList<Passenger> flightPassengers = this.flight.getPassengerList();
        for (Passenger passenger : flightPassengers) {
            totalWeight += getPassengerBaggageWeight(passenger);
        }

        return totalWeight;
    }

    public int getFlightBaggageWeight() {
        return this.flight.getPlane().getTotalWeight() / 2;
    }

    public int calculateRemainingBaggageWeight() {
        return this.getFlightBaggageWeight() - this.getTotalPassengerBaggageWeight();
    }

    public void assignFlightToPassenger(Passenger passenger) {
//        ArrayList<Passenger> flightPassengers = this.flight.getPassengerList();
//        for (Passenger passenger : flightPassengers) {
//            passenger.setFlight(this.flight);
//        }
        passenger.setFlight(this.flight);
    }

    public void assignSeatNumberToPassenger(Passenger passenger) {
        int passengerSeatNumber = this.flight.getPlane().getSeatNumbers().remove(0);
        passenger.setSeatNumber(passengerSeatNumber);
    }

    public void bookPassengerOntoFlight(Passenger passenger) {
        this.flight.addPassengerToFlight(passenger);
        this.assignSeatNumberToPassenger(passenger);
        this.assignFlightToPassenger(passenger);
    }

    public ArrayList<Integer> getPassengerSeatNumbers() {
        ArrayList<Integer> seatNumbers = new ArrayList<>();
        ArrayList<Passenger> passengerList = this.flight.getPassengerList();
        for (Passenger flightPassenger : passengerList){
            seatNumbers.add(flightPassenger.getSeatNumber());
        }
        System.out.println(seatNumbers);
        return seatNumbers;
    }

    public ArrayList<Passenger> passengerSeatBubbleSort(){
        boolean swapped = true;
        ArrayList<Passenger> passengerList = this.flight.getPassengerList();
        while (swapped == true){
            for (int i = 0; i < passengerList.size() - 1; i++) {
                Passenger flightPassenger = passengerList.get(i);
                Passenger adjacentPassenger = passengerList.get(i + 1);
                swapped = false;
                if (flightPassenger.getSeatNumber() > adjacentPassenger.getSeatNumber()) {
                    Collections.swap(passengerList, i, i +1);
                    swapped = true;
                }

            }
        }
        return passengerList;
    }

//    public Passenger findPassengerBySeatNumber(int seatNumber){
//        Passenger passenger = null;
//        // Sort the list
//        ArrayList<Passenger> sortedList = this.passengerSeatBubbleSort();
//        // Set the min and max
//        int min = 0;
//        int max = sortedList.size() - 1;
//        //While min is less than or equal to max
//        while (min <= max) {
//            // Find the mid point
//            int mid = (min + max) / 2;
//
//            passenger = sortedList.get(mid);
//            // If the number is higher than the mid point, set the min to mid point + 1
//            if (passenger.getSeatNumber() > seatNumber){
//                min = mid + 1;
//            }
//            // If the number is lower than the mid point, set the max to mid point - 1
//            if (passenger.getSeatNumber() < seatNumber){
//                max = mid - 1;
//            }
//            // If the mid point is the same as the number, set found to true and return the passenger object
//            if (passenger.getSeatNumber() == seatNumber){
//                return passenger;
//            }
//        }
//        return passenger;
//    }

    public ArrayList<Integer> seatNumberBubbleSort(){
        boolean swapped = true;
        ArrayList<Integer> seatNumbers = this.getPassengerSeatNumbers();
        while (swapped == true){
            for (int i = 0; i < seatNumbers.size() - 1; i++) {
                int number = seatNumbers.get(i);
                int adjacentNumber = seatNumbers.get(i + 1);
                swapped = false;
                if (number > adjacentNumber) {
                    Collections.swap(seatNumbers, i, i +1);
                    swapped = true;
                }

            }
        }
        return seatNumbers;
    }

    public int findSeatNumber(int seatNumber){
        // Sort the list
        ArrayList<Integer> sortedList = this.seatNumberBubbleSort();
        int index = -1;
        // Set the min and max
        int min = 0;
        int max = sortedList.size() - 1;
        //While min is less than or equal to max
        while (min <= max) {
            // Find the mid point
            int mid = ((min + max) / 2);
            int midValue = sortedList.get(mid);
            // If the number is higher than the mid point, set the min to mid point + 1
            if (seatNumber > midValue){
                min = mid + 1;
            }
            // If the number is lower than the mid point, set the max to mid point - 1
            if (seatNumber < midValue){
                max = mid - 1;
            }
            // If the mid point is the same as the number, set found to true and return the passenger object
            if (seatNumber == midValue){
                index = midValue;
                break;
            }
        }
        return index;
    }

    public Passenger findPassengerBySeatNumber(int seatNumber){
        Passenger foundPassenger = null;
        int foundSeatNumber = this.findSeatNumber(seatNumber);
        if (foundSeatNumber == -1) {
            return null;
        }
        ArrayList<Passenger> passengerList = this.flight.getPassengerList();
        for (Passenger passenger : passengerList) {
            if (passenger.getSeatNumber() == foundSeatNumber){
                foundPassenger = passenger;
                break;
            }
        }
        return foundPassenger;
    }

//    public Passenger findPassengerBySeatNumber(int seatNumber){
//        Passenger foundPassenger = null;
//        ArrayList<Integer> sortedList = this.seatNumberBubbleSort();
//        int value = Collections.binarySearch(sortedList, seatNumber);
//        ArrayList<Passenger> passengerList = this.flight.getPassengerList();
//        for (Passenger passenger : passengerList) {
//            if (passenger.getSeatNumber() == value) {
//                foundPassenger = passenger;
//            }
//        }
//        return foundPassenger;
//    }
}
