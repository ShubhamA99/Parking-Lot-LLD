package Impl.StrategyImpl;

import Contract.ParkingStrategy;
import model.CarDetail;

import java.util.TreeSet;

public class CustomStrategy1 implements ParkingStrategy {

    private TreeSet<Integer> orderedParkingSpots;

    public CustomStrategy1() {
        this.orderedParkingSpots = new TreeSet<>();
    }

    @Override
    public void parkingSpots(Integer capacity) {
        for(int i=1;i<capacity;i++){
            orderedParkingSpots.add(i);
        }
    }

    @Override
    public Integer getNextSlotNumber() {
      return orderedParkingSpots.first();
    }

    @Override
    public void removeSlotNumber(Integer slotNumber) {
        orderedParkingSpots.remove(slotNumber);
    }

    @Override
    public void addSlotNumber(Integer slotNumber) {
        orderedParkingSpots.add(slotNumber);
    }

    @Override
    public boolean isEmpty() {
        return orderedParkingSpots.isEmpty();
    }


}
