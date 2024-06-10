package Impl.CommandImpl;

import Contract.Commands;
import Service.ParkingLotService;
import model.CarDetail;
import model.ParkingLot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParkCarCommand implements Commands {

    private ParkingLotService parkingLotService;

    public ParkCarCommand(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @Override
    public void process() {


        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            final String input;
            try {
                input = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
           String[] userInputCardDetails = input.split(" ");
            if(userInputCardDetails.length < 2){
                System.out.println("please Enter number<Space>Details");
            }else{
                CarDetail carDetail = new CarDetail(userInputCardDetails[0],userInputCardDetails[1]);
               parkingLotService.parkCar(carDetail);
                break;
            }
        }
    }
}
