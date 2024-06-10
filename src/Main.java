import Constants.Constants;
import Impl.CommandImpl.AddParkingLotCommand;
import Impl.CommandImpl.ParkCarCommand;
import Impl.CommandImpl.RemoveParkedCarFromParkingLot;
import Impl.CommandImpl.ViewAllParkedCardCommand;
import Impl.StrategyImpl.CustomStrategy1;
import Service.ParkingLotService;
import Util.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {


        ParkingLotService parkingLotService = new ParkingLotService(new CustomStrategy1());

        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println();
            System.out.println();
            System.out.println("""                
                    Enter number for Action
                    Create New parking Lot - 1
                    Park a car -2
                    Get All park cars -3   
                    remove car from parking -4              
                    """);
            String userCommandInput = null;
            try {
                userCommandInput = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            while (true){
                if(Util.isNumber(userCommandInput)){
                    break;
                }
            }

            Integer parsedCommandNumber  = Integer.parseInt(userCommandInput);

            switch (parsedCommandNumber){
                case Constants.ADD_PARKING_LOT_COMMAND_NUMBER:
                    new AddParkingLotCommand(parkingLotService).process();
                    break;
                case Constants.PARK_CAR_COMMAND_NUMBER:
                    new ParkCarCommand(parkingLotService).process();
                    break;
                case Constants.GET_ALL_CARS_FROM_PARKING_LOT_COMMAND_NUMBER:
                    new ViewAllParkedCardCommand(parkingLotService).process();
                    break;
                case Constants.REMOVE_CAR_FROM_PARKING_LOT_COMMAND_NUMBER:
                    new RemoveParkedCarFromParkingLot(parkingLotService).process();
                    break;
                default:
                    break;

            }
        }


        //--- TODO Validate if parking lot is initialized ---//


    }
}