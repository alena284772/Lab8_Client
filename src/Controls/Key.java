package Controls;

import Client_side.Sender;
import Commands.Command;
import Vehicle.FuelType;
import Vehicle.VehicleType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Key {

    private Parent root;
    private static Sender sender;
    private static Command command;
    @FXML
    private TextField key;
    @FXML
    private Label ErrorKey,K;
    private static Label answer;
    private static ResourceBundle rbB;
    @FXML
    private Button Send;
    private String errorKey;
    private String enterKey;



    public Parent getRoot() {
        return root;
    }

    public void setRoot(Sender sender, Command command,Label answer,ResourceBundle rbB) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/Resources/Key.fxml");
        loader.setLocation(xmlUrl);
        this.rbB=rbB;
        root = loader.load();
        Key.sender = sender;
        Key.command=command;
        Key.answer=answer;

    }
    @FXML
    private void initialize() {
        setL10nRoot(this.rbB);
    }


    public void setL10nRoot(ResourceBundle rbB){
        K.setText(rbB.getString("KeyColumn"));
        Send.setText(rbB.getString("bSend"));
        errorKey=rbB.getString("errorKey");
        enterKey=rbB.getString("enterKey");

    }
    public void click() throws IOException {
        Integer k=null;
        if(key.getText()!=null){
            try {
                k= Integer.valueOf(key.getText());
                command.setKey(k);
                answer.setText(sender.sendMessage(command).getAnswer());
            }catch (NumberFormatException e){
                ErrorKey.setText(errorKey);
            }
        }else{
            ErrorKey.setText(enterKey);
        }
    }
}
