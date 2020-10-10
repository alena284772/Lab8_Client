package Controls;

import Client_side.Sender;
import Commands.Command;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NumberOfWheels {
    private Parent root;
    private static Sender sender;
    private static Command command;
    @FXML
    private TextField number;
    @FXML
    private Label ErrorNumber,NOW;
    private static Label answer;
    private static ResourceBundle rbB;
    private String errorNumber;
    private String enterNumber;
    @FXML
    private Button Send;



    public Parent getRoot() {
        return root;
    }

    public void setRoot(Sender sender, Command command,Label answer,ResourceBundle rbB) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/Resources/Number_of_wheels.fxml");
        loader.setLocation(xmlUrl);
        this.rbB=rbB;
        root = loader.load();
        NumberOfWheels.sender = sender;
        NumberOfWheels.command=command;
        NumberOfWheels.answer=answer;

    }
    @FXML
    private void initialize() {
        setL10nRoot(this.rbB);
    }


    public void setL10nRoot(ResourceBundle rbB){
        NOW.setText(rbB.getString("NOWColumn"));
        Send.setText(rbB.getString("bSend"));
        errorNumber=rbB.getString("errorEngine");
        enterNumber=rbB.getString("enterEngine");

    }
    public void click() throws IOException {
        Long n=null;
        if(number.getText()!=null){
            try {
                n= Long.valueOf(number.getText());
                command.setNumber(n);
                answer.setText(sender.sendMessage(command).getAnswer());
            }catch (NumberFormatException e){
                ErrorNumber.setText(errorNumber);
            }
        }else{
            ErrorNumber.setText(enterNumber);
        }
    }
}
