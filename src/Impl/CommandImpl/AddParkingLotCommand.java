package Impl.CommandImpl;

import Contract.Commands;
import Service.ParkingLotService;
import Util.Util;
import model.ParkingLot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddParkingLotCommand implements Commands {

   private ParkingLotService parkingLotService;


    public AddParkingLotCommand(ParkingLotService parkingLotService) {
        this.parkingLotService =  parkingLotService;
    }

    @Override
    public void process() {
        assignparkingCapacity();
    }

    public void assignparkingCapacity(){
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String parkingCapacity = null;
        while(true){
            try {
                parkingCapacity = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if(Util.isNumber(parkingCapacity)){
                int parsedParkingCapacity = Integer.parseInt(parkingCapacity);
                parkingLotService.assignCapacityToParkingLot(parsedParkingCapacity);
                break;
            }
        }

    }
}
