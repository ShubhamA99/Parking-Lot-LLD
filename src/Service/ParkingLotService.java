package Service;

import Contract.ParkingStrategy;
import model.CarDetail;
import model.ParkingLot;

public class ParkingLotService {

    private ParkingLot parkingLot;
    private ParkingStrategy parkingStrategy;

    public ParkingLotService(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    public Integer getParkingLotCapacity(){
        return parkingLot.getMAX_CAPACITY();
    }

    public void   assignCapacityToParkingLot(int capacity){
        parkingLot = new ParkingLot(capacity);
       parkingStrategy.parkingSpots(capacity);
    }


    public void parkCar(CarDetail carDetail){

        if(parkingLot.isFull()){
            System.out.println("Lot is Full");
        }
        Integer slotNumberForCar = parkingStrategy.getNextSlotNumber();

        //-- TODO add while to get empty slot
        if(!parkingLot.isOccupied(slotNumberForCar)){
           Integer parkedSlotNumber =  parkingLot.parkCar(slotNumberForCar,carDetail);
           parkingStrategy.removeSlotNumber(slotNumberForCar);
            System.out.println("Car is parked at slot "+parkedSlotNumber);
        }

    }

    public void getAllParkedCars(){
        System.out.println(parkingLot.getParkedCar());
    }

    public void removeParkedCarFromParkingLot(Integer slotNumber){
        if(parkingLot.isOccupied(slotNumber)){
            CarDetail carDetail = parkingLot.removeParkedCar(slotNumber);
            System.out.println("removed Car detail");
            System.out.println(carDetail.toString());
            parkingStrategy.addSlotNumber(slotNumber);
        }else{
            System.out.println("Slot is Empty no car parked");
        }
    }


}
