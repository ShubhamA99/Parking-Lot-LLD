package Impl.CommandImpl;

import Contract.Commands;
import Contract.ParkingStrategy;
import Service.ParkingLotService;

public class ViewAllParkedCardCommand implements Commands {

    private ParkingLotService parkingLotService;

    public ViewAllParkedCardCommand(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @Override
    public void process() {
        parkingLotService.getAllParkedCars();
    }
}
