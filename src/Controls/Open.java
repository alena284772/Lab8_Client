package Controls;

import Client_side.Sender;
import Commands.Command;
import Vehicle.FuelType;
import Vehicle.*;
import Vehicle.VehicleType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Open {
    private Parent root;
    @FXML
    private TextField Name,x,y,Engine_Power,Number,Key;

    @FXML
    private Label labelErrorName,labelErrorX,labelErrorY,labelErrorNumber,labelErrorEngine,labelErrorType,labelErrorFuel,labelErrorKey;
    @FXML
    private Label K,name,CX,CY,EP,NOW,type,FType;
    @FXML
    private ComboBox<VehicleType> Type;
    @FXML
    private ComboBox<FuelType> Fuel;
    @FXML
    private Button show,buttonDelete,buttonChange;
    private static Sender sender;
    private static Command command;
    private static Label answer;
    private static Vehicle vehicle;
    private static Integer key;
    private static Stage Open_stage;
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

    public void setRoot(Sender sender, Command command, Label answer,Integer k,Vehicle v,Stage stage,ResourceBundle rbB) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/Resources/Open.fxml");
        loader.setLocation(xmlUrl);
        this.rbB=rbB;
        root = loader.load();
        Open.sender = sender;
        Open.command=command;
        Open.answer=answer;
        Open.key=k;
        Open.vehicle=v;
        Open.Open_stage=stage;

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
        show.setText(rbB.getString("bShowData"));
        buttonChange.setText(rbB.getString("bChange"));
        buttonDelete.setText(rbB.getString("bDelete"));
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

    public void fill(){
        //System.out.println(k);
        //Key.setText("777");
        Key.setText(String.valueOf(key));
        Name.setText(vehicle.getName());
        x.setText(String.valueOf(vehicle.c.getX()));
        y.setText(String.valueOf(vehicle.c.getY()));
        Engine_Power.setText(String.valueOf(vehicle.getEnginePower()));
        Number.setText(String.valueOf(vehicle.getNumberOfWheels()));
        Type.setValue(vehicle.getType());
        Fuel.setValue(vehicle.getFuelType());
    }
    public void clickChange() throws EnginePowerException, NumberOfWheelsException, VehicleTypeException, FuelTypeException, IOException {
        Vehicle veh=new Vehicle();
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
            veh.setName(Name.getText());
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
            veh.setCoordinates(Double.valueOf(x.getText()),Long.valueOf(y.getText()));
        }
        if(Engine_Power.getText()!=null){
            try {
                float e_p=Float.valueOf(Engine_Power.getText());
                if(e_p>0){
                    veh.setEnginePower(Float.valueOf(Engine_Power.getText()));
                }else{labelErrorEngine.setText(errorEngine);}
            }catch (NumberFormatException | EnginePowerException e){
                labelErrorEngine.setText(errorEngine);
            }

        }else{labelErrorEngine.setText(enterEngine);}

        if (Number.getText()!=null){
            try {
                long n=Long.valueOf(Number.getText());
                if(n>0){
                    veh.setNumberOfWheels(Long.valueOf(Number.getText()));
                }else{labelErrorNumber.setText(errorNumber);}
            }catch (NumberFormatException e){
                labelErrorNumber.setText(errorNumber);
            }

        }else{labelErrorNumber.setText(enterNumber);}


        if(Type.getValue()!=null){
            veh.setType(String.valueOf(Type.getValue()));
        }else{
            labelErrorType.setText(enterType);
        }
        if(Fuel.getValue()!=null){
            veh.setFuelType(String.valueOf(Fuel.getValue()));
        }else{labelErrorFuel.setText(enterFuel);}
        if(key!=null&&veh.getName()!=null&&veh.getCoordinates(veh.c)!=null&&veh.getEnginePower()!=null&&veh.getNumberOfWheels()!=null&&veh.getType()!=null&&veh.getFuelType()!=null){
            veh.setCreationDate();
            veh.setUser(command.getLogin());
            command.setName("update");
            command.setID(vehicle.getId());
            command.setVehicle(veh);
            command.setKey(key);
            answer.setText(sender.sendMessage(command).getAnswer());
            if(answer.getText().equals("Object with this id is update")||answer.getText().equals("The item was not updated because the item with this ID has another user")){Open_stage.close();}

        }
    }
    public void clickDelete() throws IOException {
        command.setName("remove_key");
        command.setKey(key);
        answer.setText(sender.sendMessage(command).getAnswer());
        if(answer.getText().equals("Element was deleted")||answer.getText().equals("Element was not deleted, because it has another user")){Open_stage.close();}
    }
    }

