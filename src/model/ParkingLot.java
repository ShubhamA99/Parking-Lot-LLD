package model;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    final Integer MAX_CAPACITY;
    Map<Integer,CarDetail> parkedCars;

    public ParkingLot(Integer MAX_CAPACITY) {
        this.MAX_CAPACITY = MAX_CAPACITY;
        this.parkedCars = new HashMap<>();
    }

    public Integer getMAX_CAPACITY() {
        return MAX_CAPACITY;
    }

    public Map<Integer, CarDetail> getParkedCar() {
        return parkedCars;
    }

    public boolean isFull(){
        if(MAX_CAPACITY.equals(parkedCars.size())){
            return true;
        }
        return false;
    }

    public boolean isOccupied(Integer slotNumber){
        return  parkedCars.containsKey(slotNumber);
    }

    public Integer parkCar(Integer slotNumber,CarDetail carDetail){
        parkedCars.put(slotNumber,carDetail);
        return slotNumber;
    }


    public CarDetail removeParkedCar(Integer slotNumber){
     return   parkedCars.remove(slotNumber);
    }
}
