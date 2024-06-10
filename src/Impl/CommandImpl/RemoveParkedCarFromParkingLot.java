package Impl.CommandImpl;

import Contract.Commands;
import Service.ParkingLotService;
import Util.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveParkedCarFromParkingLot implements Commands {

    private ParkingLotService parkingLotService;

    public RemoveParkedCarFromParkingLot(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @Override
    public void process() {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String slotNumber = null;
        while(true){
            try {
                slotNumber = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if(Util.isNumber(slotNumber)){
                int parsedSlotNumber = Integer.parseInt(slotNumber);
               parkingLotService.removeParkedCarFromParkingLot(parsedSlotNumber);
                break;
            }
        }
    }
}
