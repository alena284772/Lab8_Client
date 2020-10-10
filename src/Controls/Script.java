package Controls;

import ClientSide.HistoryList;
import Client_side.Sender;
import Commands.Command;
import Vehicle.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Script {

    private static ArrayList<String> files = new ArrayList<String>();
    private static ClientSide.HistoryList historyList;
    public static Sender sender;
    private static String login;
    private static byte[] p;
    private static Label answer;
    private static Stage help_stage;
    private static Stage script;
    private Parent root;
    private Label label;
    private static ResourceBundle rbB;
    @FXML
    private Label ErrorScript,File;
    @FXML
    private TextField script_file;
    @FXML
    private Button Send;
    private String error_File,enterFile,File_was_used;

    public Parent getRoot() {
        return root;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public void setRoot(HistoryList historyList, Sender sender, String login, byte[] p, Label answer, Stage help_stage,ResourceBundle rbB) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/Resources/Script.fxml");
        loader.setLocation(xmlUrl);
        this.rbB=rbB;
        Script.historyList=historyList;
        Script.sender=sender;
        Script.login=login;
        Script.p=p;
        Script.answer=answer;
        Script.help_stage=help_stage;
        root = loader.load();
    }
    @FXML
    private void initialize() {
        setL10nRoot(this.rbB);
    }


    public void setL10nRoot(ResourceBundle rbB){
       File.setText(rbB.getString("File"));
        Send.setText(rbB.getString("bSend"));
        enterFile=rbB.getString("enter_File");
        error_File=rbB.getString("error_File");
        File_was_used=rbB.getString("File_was_used");

    }
    public void click() throws IOException {
        if(script_file.getText()!=null){
            String string=script_file.getText();
            if (files.contains(string) == false) {
                files.add(string);
                File file1 = new File(string);
                try {
                    Scanner scan = new Scanner(file1);
                    while (scan.hasNextLine()) {
                        //answer.setText("File is reading");
                        execute(scan);
                        ErrorScript.setText("");
                    }
                    scan.close();
                } catch (FileNotFoundException |SecurityException e) {
                    ErrorScript.setText(error_File);

                }
                historyList.insert("Execute_script");
            } else {
                ErrorScript.setText(File_was_used);
            }
            files.clear();
        }else{
            ErrorScript.setText(enterFile);
        }
    }

    public void read_script() throws IOException {
        script.setTitle("Script");
        script.setScene(new Scene(this.getRoot()));
        script.show();
    }
    public void read_script(String string) throws IOException {
        if (files.contains(string) == false) {
            files.add(string);
            File file1 = new File(string);
            try {
                Scanner scan = new Scanner(file1);
                while (scan.hasNextLine()) {
                    execute(scan);
                }
                scan.close();
            } catch (FileNotFoundException|SecurityException e) {
                label.setText("Some problems with file");
                label.setText("Try again");

            }
            historyList.insert("Execute_script");
        } else {
            label.setText("The file specified in the execute method is already used, you cannot use it again");
        }

        files.clear();

    }
    public void execute(Scanner scanner)throws IOException{
        while (scanner.hasNext()) {
            String clientcom = scanner.nextLine();
            String[] input_ar = clientcom.split(" ");
            switch (input_ar[0]) {

                case ("help"):
                    Help help = new Help();
                    help.setRoot();
                    help_stage.setScene(new Scene(help.getRoot()));
                    help_stage.show();
                    historyList.insert("help");
                    break;

                case ("info"):
                    Command command2 = new Command("info");
                    command2.setLogin(login);
                    command2.setPassword(new String(p));
                    setLabel(Script.answer);
                    label.setText(sender.sendMessage(command2).getAnswer());
                    historyList.insert("info");
                    break;

                case ("show"):
                    setLabel(Script.answer);

                    label.setText("show");

                    historyList.insert("show");
                    break;

                case ("insert"):
                    try {
                        Integer Key = Key_check(input_ar[1]);
                        Vehicle vehicle = new Vehicle(scanner);
                        vehicle.setUser(login);
                        Command command4 = new Command("insert");
                        command4.setKey(Key);
                        command4.setVehicle(vehicle);
                        command4.setLogin(login);
                        command4.setPassword(new String(p));
                        answer.setText(sender.sendMessage(command4).getAnswer());
                        historyList.insert("insert");
                        break;}catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("The arguments to the command are incorrect. Use the help command");
                        break;
                    }

                case ("update"):
                    try {
                        Long ID = Long_check(input_ar[1]);
                        Vehicle vehicle1 = new Vehicle(scanner);
                        vehicle1.setUser(login);
                        Command command5 = new Command("update");
                        command5.setID(ID);
                        command5.setVehicle(vehicle1);
                        command5.setLogin(login);
                        command5.setPassword(new String(p));
                        answer.setText(sender.sendMessage(command5).getAnswer());
                        historyList.insert("update");
                        break;}catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("The arguments to the command are incorrect. Use the help command");
                        break;
                    }

                case ("remove_key"):
                    try{
                        Integer key = Key_check(input_ar[1]);
                        Command command6 = new Command("remove_key");
                        command6.setKey(key);
                        command6.setLogin(login);
                        command6.setPassword(new String(p));
                        answer.setText(sender.sendMessage(command6).getAnswer());
                        historyList.insert("remove_key");
                        break;}catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("The arguments to the command are incorrect. Use the help command");
                        break;
                    }

                case ("clear"):
                    Command command7 = new Command("clear");
                    command7.setLogin(login);
                    command7.setPassword(new String(p));
                    answer.setText(sender.sendMessage(command7).getAnswer());
                    historyList.insert("clear");
                    break;

                case ("execute_script"):
                    try{
                        read_script(input_ar[1]);
                        historyList.insert("execute_script");
                        break;}catch (ArrayIndexOutOfBoundsException e){
                        answer.setText("The arguments to the command are incorrect. Use the help command");
                        break;
                    }

                case ("exit"):
                    break;

                case ("remove_greater"):
                    Vehicle vehicle2 = new Vehicle(scanner);
                    vehicle2.setUser(login);
                    Command command10 = new Command("remove_greater");
                    command10.setVehicle(vehicle2);
                    command10.setLogin(login);
                    command10.setPassword(new String(p));
                    answer.setText(sender.sendMessage(command10).getAnswer());
                    historyList.insert("remove_greater");
                    break;

                case ("history"):
                    historyList.show();
                    historyList.insert("history");
                    break;

                case ("replace_if_greater"):
                    try{
                        Integer Key1 = Key_check(input_ar[1]);
                        Vehicle vehicle3 = new Vehicle(scanner);
                        vehicle3.setUser(login);
                        Command command12 = new Command("replace_if_greater");
                        command12.setKey(Key1);
                        command12.setVehicle(vehicle3);
                        command12.setLogin(login);
                        command12.setPassword(new String(p));
                        answer.setText(sender.sendMessage(command12).getAnswer());
                        historyList.insert("replace_if_greater");
                        break;}catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("The arguments to the command are incorrect. Use the help command");
                        break;
                    }

                case ("remove_any_by_number_of_wheels"):
                    try{
                        Long number = Long_check(input_ar[1]);
                        Command command13 = new Command("remove_any_by_number_of_wheels");
                        command13.setNumber(number);
                        command13.setLogin(login);
                        command13.setPassword(new String(p));
                        answer.setText(sender.sendMessage(command13).getAnswer());
                        historyList.insert("remove_any_by_number_of_wheels");
                        break;}catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("The arguments to the command are incorrect. Use the help command");
                        break;
                    }

                case ("count_less_than_engine_power"):
                    try{
                        Float power = Float_check(input_ar[1]);
                        Command command14 = new Command("count_less_than_engine_power");
                        command14.setPower(power);
                        command14.setLogin(login);
                        command14.setPassword(new String(p));
                        answer.setText(sender.sendMessage(command14).getAnswer());
                        historyList.insert("count_less_than_engine_power");
                        break;}catch (ArrayIndexOutOfBoundsException e){
                        System.out.println("The arguments to the command are incorrect. Use the help command");
                        break;
                    }
                case ("print_field_ascending_type"):
                    List<VehicleType> VehT = Arrays.asList(VehicleType.values());
                    Collections.sort(VehT);
                    System.out.println(VehT);
                    historyList.insert(input_ar[0]);
                    break;

                default:
                    answer.setText(input_ar[0]+" "+"Incorrect command. Try again");

            }
            continue;

        }
    }
    public Integer Key_check(String string) {
        Integer Key = null;
        try {
            Key = Integer.valueOf(string);
        } catch (NumberFormatException E) {
            answer.setText("Input arg of key is incorrect.It must be Integer value. Try again");
        }
        return Key;
    }
    public Long Long_check(String string) {
        Long aLong = null;
        try {
            aLong = Long.valueOf(string);
        } catch (NumberFormatException E) {
            answer.setText("Input arg of long value is incorrect. Try again");
        }
        return aLong;
    }

    public Float Float_check(String string) {
        Float aFloat = null;
        try {
            aFloat = Float.valueOf(string);
        } catch (NumberFormatException E) {
            answer.setText("Input arg of float value is incorrect. Try again");
        }
        return aFloat;
    }


}
