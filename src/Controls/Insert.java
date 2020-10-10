package Controls;

import Client_side.Sender;
import Commands.Command;
import Vehicle.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;

public class Insert {

private Parent root;
@FXML
private Button buttonCreate;

@FXML
private TextField Name,x,y,Engine_Power,Number,Key;

@FXML
private Label labelErrorName,labelErrorX,labelErrorY,labelErrorNumber,labelErrorEngine,labelErrorType,labelErrorFuel,labelErrorKey;
@FXML
private ComboBox<VehicleType> Type;
@FXML
private ComboBox<FuelType> Fuel;
@FXML
private Label name,K,CX,CY,EP,NOW,type,FType;
private static Sender sender;
private static Command command;
private static Label answer;
    private static ResourceBundle rbB;
    private String errorKey;
    private String errorX;
    private String errorY;
    private String errorNumber;
    private String errorEngine;
    private String enterKey;
    private String enterName;
    private String enterX;
    private String enterY;
    private String enterNumber;
    private String enterEngine;
    private String enterType;
    private String enterFuel;


    public Parent getRoot() {
        return root;
    }

    public void setRoot(Sender sender,Command command,Label answer,ResourceBundle rbB) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/Resources/Insert.fxml");
        loader.setLocation(xmlUrl);
        this.rbB=rbB;
        root = loader.load();
        Insert.sender = sender;
        Insert.command=command;
        Insert.answer=answer;

    }
    @FXML
    private void initialize() {
        ArrayList<VehicleType> list = new ArrayList<>(5);
        list.add(VehicleType.CAR);
        list.add(VehicleType.PLANE);
        list.add(VehicleType.BICYCLE);
        list.add(VehicleType.MOTORCYCLE);
        list.add(VehicleType.HOVERBOARD);
        Type.setItems(FXCollections.observableArrayList(list));

        ArrayList<FuelType> l = new ArrayList<>(4);
        l.add(FuelType.KEROSENE);
        l.add(FuelType.ELECTRICITY);
        l.add(FuelType.NUCLEAR);
        l.add(FuelType.ANTIMATTER);
        Fuel.setItems(FXCollections.observableArrayList(l));
        setL10nRoot(this.rbB);
    }


    public void setL10nRoot(ResourceBundle rbB){
        K.setText(rbB.getString("KeyColumn"));
        name.setText(rbB.getString("NameColumn"));
        CX.setText(rbB.getString("CXColumn"));
        CY.setText(rbB.getString("CYColumn"));
        EP.setText(rbB.getString("EPColumn"));
        NOW.setText(rbB.getString("NOWColumn"));
        type.setText(rbB.getString("TypeColumn"));
        FType.setText(rbB.getString("FuelTypeColumn"));
        buttonCreate.setText(rbB.getString("bCreate"));
        errorKey=rbB.getString("errorKey");
        errorX=rbB.getString("errorX");
        errorY=rbB.getString("errorY");
        errorEngine=rbB.getString("errorEngine");
        errorNumber=rbB.getString("errorNumber");
        enterKey=rbB.getString("enterKey");
        enterName=rbB.getString("enterName");
        enterX=rbB.getString("enterX");
        enterY=rbB.getString("enterY");
        enterNumber=rbB.getString("enterNumber");
        enterEngine=rbB.getString("enterEngine");
        enterType=rbB.getString("enterType");
        enterFuel=rbB.getString("enterFuel");

    }

    public void clickCreate() throws EnginePowerException, NumberOfWheelsException, VehicleTypeException, FuelTypeException, IOException {
        Vehicle vehicle=new Vehicle();
        Integer key=null;

        if(Key.getText()!=null){
            try {
                key= Integer.valueOf(Key.getText());
            }catch (NumberFormatException e){
                labelErrorKey.setText(errorKey);
            }

        }else{
            labelErrorKey.setText(enterKey);
        }
        if(Name.getText()!=null && Name.getText()!=""){
            vehicle.setName(Name.getText());
        }else{
            labelErrorName.setText(enterName);
        }
        double cx=-1000;
        long cy=-1000;

        if (x.getText()!=null){
            try {
                cx=Double.valueOf(x.getText());
                if(cx>-815){}else labelErrorX.setText(errorX);
            }catch (NumberFormatException e){
                labelErrorX.setText(errorX);
            }
        }else {labelErrorX.setText(enterX);}

        if (y.getText()!=null){
            try {
                cy=Long.valueOf(y.getText());
                if(cy>-815){}else labelErrorY.setText(errorY);
            }catch (NumberFormatException e){
                labelErrorY.setText(errorY);
            }

        }else {labelErrorY.setText(enterY);}
if(cx!=-1000&&cy!=-1000){
    vehicle.setCoordinates(Double.valueOf(x.getText()),Long.valueOf(y.getText()));
}
        if(Engine_Power.getText()!=null){
            try {
                float e_p=Float.valueOf(Engine_Power.getText());
                if(e_p>0){
                    vehicle.setEnginePower(Float.valueOf(Engine_Power.getText()));
                }else{labelErrorEngine.setText(errorEngine);}
            }catch (NumberFormatException e){
                labelErrorEngine.setText(errorEngine);
            }

        }else{labelErrorEngine.setText(enterEngine);}

        if (Number.getText()!=null){
            try {
                long n=Long.valueOf(Number.getText());
                if(n>0){
                    vehicle.setNumberOfWheels(Long.valueOf(Number.getText()));
                }else{labelErrorNumber.setText(errorNumber);}
            }catch (NumberFormatException e){
                labelErrorNumber.setText(errorNumber);
            }

        }else{labelErrorNumber.setText(enterNumber);}


        if(Type.getValue()!=null){
            vehicle.setType(String.valueOf(Type.getValue()));
        }else{
            labelErrorType.setText(enterType);
        }
        if(Fuel.getValue()!=null){
            vehicle.setFuelType(String.valueOf(Fuel.getValue()));
        }else{labelErrorFuel.setText(enterFuel);}
        if(key!=null&&vehicle.getName()!=null&&vehicle.getCoordinates(vehicle.c)!=null&&vehicle.getEnginePower()!=null&&vehicle.getNumberOfWheels()!=null&&vehicle.getType()!=null&&vehicle.getFuelType()!=null){
            vehicle.setCreationDate();
            vehicle.setUser(command.getLogin());
            command.setVehicle(vehicle);
            command.setKey(key);
            answer.setText(sender.sendMessage(command).getAnswer());
        }
    }
}
