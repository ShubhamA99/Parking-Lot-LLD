package Contract;

import model.CarDetail;

public interface ParkingStrategy {


    public void parkingSpots(Integer capacity);

    public Integer getNextSlotNumber();

    public  void removeSlotNumber(Integer slotNumber);

    public void addSlotNumber(Integer slotNumber);

    public boolean isEmpty();

}
