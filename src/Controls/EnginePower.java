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

public class EnginePower {
    private Parent root;
    private static Sender sender;
    private static Command command;
    @FXML
    private TextField engine_power;
    @FXML
    private Label ErrorPower,EP;
    private static Label answer;
    @FXML
    private Button Send;
    private static ResourceBundle rbB;
    private String errorEngine;
    private String enterEngine;



    public Parent getRoot() {
        return root;
    }

    public void setRoot(Sender sender, Command command,Label answer,ResourceBundle rbB) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/Resources/Engine_power.fxml");
        loader.setLocation(xmlUrl);
        this.rbB=rbB;
        root = loader.load();
        EnginePower.sender = sender;
        EnginePower.command=command;
        EnginePower.answer=answer;

    }
    @FXML
    private void initialize() {
        setL10nRoot(this.rbB);
    }


    public void setL10nRoot(ResourceBundle rbB){
        EP.setText(rbB.getString("EPColumn"));
        Send.setText(rbB.getString("bSend"));
        errorEngine=rbB.getString("errorEngine");
        enterEngine=rbB.getString("enterEngine");

    }
    public void click() throws IOException {
        Float en=null;
        if(engine_power.getText()!=null){
            try {
                en= Float.valueOf(engine_power.getText());
                command.setPower(en);
                answer.setText(sender.sendMessage(command).getAnswer());
            }catch (NumberFormatException e){
                ErrorPower.setText(errorEngine);
            }
        }else{
            ErrorPower.setText(enterEngine);
        }
    }
}
