package gov.iti.jets;


import gov.iti.jets.controller.ConnectionController;
import gov.iti.jets.controller.UserController;
import gov.iti.jets.dto.UserDto;
import gov.iti.jets.dto.registration.UserRegistrationDto;
import gov.iti.jets.network.RMIManager;
import gov.iti.jets.service.CheckConnectedClientStatus;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) {

        try {
            Thread th = new Thread(new CheckConnectedClientStatus());
            th.start();
            Registry reg = RMIManager.getRegistry();
            UserController obj = new UserController();
            reg.rebind("UserRemote",obj);
            ConnectionController obj2 = new ConnectionController();
            reg.rebind("connection",obj2);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

//        UserDto userDto = new UserDto();
//        userDto.setId("01111315022");
//        UserRegistrationDto dto = new UserRegistrationDto();
//        dto.setUserDto(userDto);
//        dto.setPassword("abdoamr123");
//        try {
//            UserController userController = new UserController();
//            System.out.println(userController.login(dto.getUserDto().getId(), dto.getPassword()));
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//        try {
//            Registry reg = LocateRegistry.createRegistry(1099);
//            reg.rebind("server",new UserController());

//
//            UserController userController = new UserController();
//            UserDto dto = new UserDto();
//            dto.setPhoneNumber("01111315011");
//
//            userController.register(new UserRegistrationDto(dto,"asasasasaasa"));
//        } catch (RemoteException e) {
////            e.printStackTrace();
//        }

        System.out.println("Hello World!");
    }


}
