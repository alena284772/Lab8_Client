package Controls;

import Client_side.Sender;
import Commands.Command;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Update {
    private Parent root;
    private static Command command;
    private static Sender sender;
    private static Label answer;
    @FXML
    private Label ErrorId,Enter_id;
    @FXML
    private Button Update;
    @FXML
    private TextField Id;
    private Stage Insert_stage=new Stage();
    private static ResourceBundle rbB;
    private  String error_Id,enter_Id;

   

    public Parent getRoot() {
        return root;
    }

    public void setRoot(Sender sender,Command command,Label answer,ResourceBundle rbB) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/Resources/Update.fxml");
        loader.setLocation(xmlUrl);
        this.rbB=rbB;
        root = loader.load();
        this.sender=sender;
        this.command=command;
        this.answer=answer;

    }
    @FXML
    private void initialize() {
        setL10nRoot(this.rbB);
    }


    public void setL10nRoot(ResourceBundle rbB){
Update.setText(rbB.getString("bupdate"));
enter_Id=rbB.getString("enter_Id");
error_Id=rbB.getString("error_Id");

    }
    public void update() throws IOException {
        if(Id.getText()!=null){
            try{
                command.setID(Long.valueOf(Id.getText()));}catch(NumberFormatException e){
                ErrorId.setText(error_Id);
            }
            Insert insert = new Insert();
            insert.setRoot(sender,command,answer,rbB);
            Insert_stage.setScene(new Scene(insert.getRoot()));
            Insert_stage.show();
        }else{ErrorId.setText(enter_Id);}
    }
}
