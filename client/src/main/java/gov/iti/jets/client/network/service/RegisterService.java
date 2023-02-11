package gov.iti.jets.client.network.service;


import com.jfoenix.controls.JFXSnackbar;
import gov.iti.jets.client.presentation.controllers.RegisterController;
import gov.iti.jets.common.dto.registration.UserRegistrationDto;
import gov.iti.jets.common.network.UserRemote;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

public class RegisterService {
    public void addUser(UserRegistrationDto user, Registry registry){
        try {
            UserRemote obj = (UserRemote) registry.lookup("server");
            obj.register(user);
        } catch (RemoteException e) {
//            throw new RuntimeException(e);
            System.out.println(e.getMessage());
            JFXSnackbar snackbar = new JFXSnackbar(new RegisterController().rootPane);
            final JFXSnackbar.SnackbarEvent snackbarEvent = new JFXSnackbar.SnackbarEvent(new Label(e.getMessage()), Duration.seconds(5.33), null);
            snackbar.enqueue(snackbarEvent);
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
