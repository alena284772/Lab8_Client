package Controls;

import Client_side.Sender;
import Commands.Command;
import Vehicle.*;
import Vehicle.VehicleType;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import javafx.util.Callback;
import java.awt.Color;


import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    @FXML
    private Button Help,Show,Clear,Insert,Remove_key,Remove_greater,History,Update,Replace_if_greater,remove_any,count_less,print_field,execute_script;
    @FXML
    private Button Info;
    public static Sender sender;
    private Parent root;
    @FXML
    private Label answer,Filter,User;
    private static Stage help_stage = new Stage();
    private static Stage Insert_stage = new Stage();
    private static Stage Update_stage = new Stage();
    @FXML
    private static Stage Remove_k = new Stage();
    private static Stage Remove_any = new Stage();
    private static Stage Count_less = new Stage();
    private static Stage Execute_script = new Stage();
    private static Stage Open_stage=new Stage();
    private static ResourceBundle rbB;
    private static String login;
    private static byte[] p;
    private Timestamp last_change;
    @FXML
    private Label x1,x3,x5,x7,x9,x11,x13,x15,x17,x19,x21,x23,x25,x27,y1,y3,y5,y7,y9,y11,y13,y15,y17,y19;
    private ObservableList<Map.Entry<Integer, Vehicle>> items = FXCollections.observableArrayList();
    private TableColumn<Map.Entry<Integer, Vehicle>, Integer> KeyColumn = new TableColumn<>("Key");
    private  TableColumn<Map.Entry<Integer, Vehicle>, Timestamp> CDColumn = new TableColumn<>("Creation Date");
    private TableColumn<Map.Entry<Integer, Vehicle>, Long> IdColumn = new TableColumn<>("Id");
    private TableColumn<Map.Entry<Integer, Vehicle>, String> NameColumn = new TableColumn<>("Name");
    private TableColumn<Map.Entry<Integer, Vehicle>, Double> CXColumn = new TableColumn<>("Coordinate x");
    private TableColumn<Map.Entry<Integer, Vehicle>, Long> CYColumn = new TableColumn<>("Coordinate y");
    private TableColumn<Map.Entry<Integer, Vehicle>, Float> EPColumn = new TableColumn<>("Engine Power");
    private TableColumn<Map.Entry<Integer, Vehicle>, Long> NOWColumn = new TableColumn<>("Number of wheels");
    private  TableColumn<Map.Entry<Integer, Vehicle>, VehicleType> TypeColumn = new TableColumn<>("Type");
    private TableColumn<Map.Entry<Integer, Vehicle>, FuelType> FuelTypeColumn = new TableColumn<>("Fuel type");
    private TableColumn<Map.Entry<Integer, Vehicle>, String> UserColumn = new TableColumn<>("User");

    private ClientSide.HistoryList historyList = new ClientSide.HistoryList(6);
    @FXML
    private TableView<Map.Entry<Integer, Vehicle>> table;
    @FXML
    private TextField filter;
    @FXML
    private Canvas canvas;
    HashMap<String, Color> colorHashMap=new HashMap<String, Color>();
    @FXML
    private ComboBox<Locale> languages;


    public Parent getRoot() {
        return root;
    }

    public Timestamp getLast_change() {
        return last_change;
    }

    public void setRoot(ResourceBundle rbB) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/Resources/Main.fxml");
        loader.setLocation(xmlUrl);
        this.rbB=rbB;
        root = loader.load();


    }

    public void setSender(Sender sender) {
        Main.sender = sender;
    }

    public void help() throws IOException {
        Help help = new Help();
        help.setRoot();
        help_stage.setScene(new Scene(help.getRoot()));
        help_stage.show();
        historyList.insert("help");
    }

    public void info() throws IOException {
        Command command2 = new Command("info");
        command2.setLogin(login);
        command2.setPassword(new String(p));
        answer.setText(sender.sendMessage(command2).getAnswer());
        historyList.insert("info");
    }

    public void insert() throws IOException {
        Command command = new Command("insert");
        command.setLogin(login);
        command.setPassword(new String(p));
        Insert insert = new Insert();
        insert.setRoot(sender, command, answer,rbB);
        Insert_stage.setScene(new Scene(insert.getRoot()));
        Insert_stage.show();
        historyList.insert("insert");


    }

    public void clear() throws IOException {
        Command command7 = new Command("clear");
        command7.setLogin(login);
        command7.setPassword(new String(p));
        answer.setText(sender.sendMessage(command7).getAnswer());
        historyList.insert("clear");
    }

    public void show() throws IOException, VehicleTypeException, FuelTypeException {

        Map<Integer, Vehicle> map = new LinkedHashMap<Integer, Vehicle>();
        initData(map);
        up_show(map);
        //System.out.println(sender.sendMessage(command3).getMap().size());
        //ref();
        historyList.insert("show");
    }

    public void history() {
        answer.setText(historyList.getH().toString());
        historyList.insert("history");
    }

    public void update() throws IOException {
        Command command = new Command("update");
        command.setLogin(login);
        command.setPassword(new String(p));
        Update update = new Update();
        update.setRoot(sender, command, answer,rbB);
        Update_stage.setScene(new Scene(update.getRoot()));
        Update_stage.show();
        historyList.insert("update");

    }

    public void remove_key() throws IOException {
        Command command = new Command("remove_key");
        command.setLogin(login);
        command.setPassword(new String(p));
        Key key = new Key();
        key.setRoot(sender, command, answer,rbB);
        Remove_k.setScene(new Scene(key.getRoot()));
        Remove_k.show();
        historyList.insert("remove_key");
    }

    public void remove_greater() throws IOException {
        Command command = new Command("remove_greater");
        command.setLogin(login);
        command.setPassword(new String(p));
        Insert insert = new Insert();
        insert.setRoot(sender, command, answer,rbB);
        Insert_stage.setScene(new Scene(insert.getRoot()));
        Insert_stage.show();
        historyList.insert("remove_greater");
    }

    public void replace_if_greater() throws IOException {
        Command command = new Command("replace_if_greater");
        command.setLogin(login);
        command.setPassword(new String(p));
        Insert insert = new Insert();
        insert.setRoot(sender, command, answer,rbB);
        Remove_k.setScene(new Scene(insert.getRoot()));
        Remove_k.setTitle("Remove_if_greater_by_key");
        Remove_k.show();
        historyList.insert("replace_if_greater");
    }

    public void remove_any() throws IOException {
        Command command = new Command("remove_any_by_number_of_wheels");
        command.setLogin(login);
        command.setPassword(new String(p));
        NumberOfWheels numberOfWheels = new NumberOfWheels();
        numberOfWheels.setRoot(sender, command, answer,rbB);
        Remove_any.setScene(new Scene(numberOfWheels.getRoot()));
        Remove_any.setTitle("Remove_any_by_number_of_wheels");
        Remove_any.show();
        historyList.insert("remove_any_by_number_of_wheels");
    }

    public void count_less() throws IOException {
        Command command = new Command("count_less_than_engine_power");
        command.setLogin(login);
        command.setPassword(new String(p));
        EnginePower enginePower = new EnginePower();
        enginePower.setRoot(sender, command, answer,rbB);
        Count_less.setScene(new Scene(enginePower.getRoot()));
        Count_less.setTitle("Count_less_than_engine_power");
        Count_less.show();
        historyList.insert("count_less_than_engine_power");
    }

    public void print() {
        List<VehicleType> VehT = Arrays.asList(VehicleType.values());
        Collections.sort(VehT);
        answer.setText(VehT.toString());
        historyList.insert("print_field_ascending_type");
    }

    public void execute_script() throws IOException {
        Script script = new Script();
        answer.setText("");
        script.setRoot(historyList, sender, login, p, answer, help_stage,rbB);
        Execute_script.setScene(new Scene(script.getRoot()));
        Execute_script.show();

    }

    public void setP(byte[] p) {
        Main.p = p;
    }

    public void setLogin(String login) {
        Main.login = login;
    }

    public void initialize() throws IOException, VehicleTypeException, FuelTypeException {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        for (int i=0;i<canvas.getWidth();i=i+20){
            gc.strokeLine(i,0,i,canvas.getHeight());
        }
        for (int j=0;j<canvas.getHeight();j=j+20){
            gc.strokeLine(0,j,canvas.getWidth(),j);
        }


        //canvas.setOnMouseClicked((MouseEvent event) -> {
        //    System.out.println("mouseClicked");
       // });


        items.removeAll();
        Map<Integer, Vehicle> map = new LinkedHashMap<Integer, Vehicle>();
        up_show(map);
        initData(map);
        //TableColumn<Map.Entry<Integer, Vehicle>, Integer> KeyColumn = new TableColumn<>("Key");
        KeyColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Integer, Vehicle>, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Map.Entry<Integer, Vehicle>, Integer> param) {
                return new SimpleObjectProperty<>(param.getValue().getKey());
            }
        });


        IdColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Integer, Vehicle>, Long>, ObservableValue<Long>>() {
            @Override
            public ObservableValue<Long> call(TableColumn.CellDataFeatures<Map.Entry<Integer, Vehicle>, Long> param) {
                return new SimpleObjectProperty<>(param.getValue().getValue().getId());
            }
        });
        NameColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Integer, Vehicle>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<Integer, Vehicle>, String> param) {
                return new SimpleObjectProperty<>(param.getValue().getValue().getName());
            }
        });
        CXColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Integer, Vehicle>, Double>, ObservableValue<Double>>() {
            @Override
            public ObservableValue<Double> call(TableColumn.CellDataFeatures<Map.Entry<Integer, Vehicle>, Double> param) {
                return new SimpleObjectProperty<>(param.getValue().getValue().c.getX());
            }
        });
        CYColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Integer, Vehicle>, Long>, ObservableValue<Long>>() {
            @Override
            public ObservableValue<Long> call(TableColumn.CellDataFeatures<Map.Entry<Integer, Vehicle>, Long> param) {
                return new SimpleObjectProperty<>(param.getValue().getValue().c.getY());
            }
        });
        CDColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Integer, Vehicle>, Timestamp>, ObservableValue<Timestamp>>() {
            @Override
            public ObservableValue<Timestamp> call(TableColumn.CellDataFeatures<Map.Entry<Integer, Vehicle>, Timestamp> param) {
                return new SimpleObjectProperty<>(param.getValue().getValue().getCreationDate());
            }
        });
        EPColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Integer, Vehicle>, Float>, ObservableValue<Float>>() {
            @Override
            public ObservableValue<Float> call(TableColumn.CellDataFeatures<Map.Entry<Integer, Vehicle>, Float> param) {
                return new SimpleObjectProperty<>(param.getValue().getValue().getEnginePower());
            }
        });
        NOWColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Integer, Vehicle>, Long>, ObservableValue<Long>>() {
            @Override
            public ObservableValue<Long> call(TableColumn.CellDataFeatures<Map.Entry<Integer, Vehicle>, Long> param) {
                return new SimpleObjectProperty<>(param.getValue().getValue().getNumberOfWheels());
            }
        });
        TypeColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Integer, Vehicle>, VehicleType>, ObservableValue<VehicleType>>() {
            @Override
            public ObservableValue<VehicleType> call(TableColumn.CellDataFeatures<Map.Entry<Integer, Vehicle>, VehicleType> param) {
                return new SimpleObjectProperty<>(param.getValue().getValue().getType());
            }
        });
        FuelTypeColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Integer, Vehicle>, FuelType>, ObservableValue<FuelType>>() {
            @Override
            public ObservableValue<FuelType> call(TableColumn.CellDataFeatures<Map.Entry<Integer, Vehicle>, FuelType> param) {
                return new SimpleObjectProperty<>(param.getValue().getValue().getFuelType());
            }
        });
        UserColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Integer, Vehicle>, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<Integer, Vehicle>, String> param) {
                return new SimpleObjectProperty<>(param.getValue().getValue().getUser());
            }
        });
        items.setAll(map.entrySet());
        table.setItems(items);
        table.getColumns().setAll(KeyColumn, IdColumn, NameColumn, CXColumn, CYColumn, CDColumn, EPColumn, NOWColumn, TypeColumn, FuelTypeColumn, UserColumn);
        last_change = Timestamp.valueOf(LocalDateTime.now());
        up.setDaemon(true);
        up.start();
        //initFilter();

        ArrayList<Locale> listLocale = new ArrayList<>(4);
        listLocale.add(new Locale("ru", "RU")); //русский, Россия
        listLocale.add(new Locale("nd", "ND")); //нидерландский, Нидерланды
        listLocale.add(new Locale("vn", "VN")); //венгерский, Венгрия
        listLocale.add(new Locale("en", "NZ")); //английский, Новая зеландия
        languages.setItems(FXCollections.observableArrayList(listLocale));
        Locale.setDefault(new Locale("ru", "RU"));

        languages.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if(newSel != null)
            setL10nRoot(languages.getValue());
        });

        setL10nRoot(rbB.getLocale());
    }

    public void setL10nRoot(Locale loc){
        this.rbB = ResourceBundle.getBundle("Languages.MLang",loc);
        Show.setText(rbB.getString("bShow"));
        Help.setText(rbB.getString("bHelp"));
        Info.setText(rbB.getString("bInfo"));
        Insert.setText(rbB.getString("bAdd"));
        Clear.setText(rbB.getString("bClear"));
        Filter.setText(rbB.getString("lFilter"));
        Remove_key.setText(rbB.getString("bremove_key"));
        Remove_greater.setText(rbB.getString("bremove_greater"));
        History.setText(rbB.getString("bhistory"));
        Update.setText(rbB.getString("bupdate"));
        Replace_if_greater.setText(rbB.getString("breplace_if_greater"));
        remove_any.setText(rbB.getString("bremove_any"));
        count_less.setText(rbB.getString("bcount_less"));
        print_field.setText(rbB.getString("bprint_field"));
        execute_script.setText(rbB.getString("bexecute_script"));
        languages.setPromptText(rbB.getString("cblanguages"));
        answer.setText(rbB.getString("LAnswer"));
        User.setText(rbB.getString("LUser"));
        CDColumn.setText(rbB.getString("CDColumn"));
        NameColumn.setText(rbB.getString("NameColumn"));
        KeyColumn.setText(rbB.getString("KeyColumn"));
        CXColumn.setText(rbB.getString("CXColumn"));
        CYColumn.setText(rbB.getString("CYColumn"));
        EPColumn.setText(rbB.getString("EPColumn"));
        NOWColumn.setText(rbB.getString("NOWColumn"));
        TypeColumn.setText(rbB.getString("TypeColumn"));
        FuelTypeColumn.setText(rbB.getString("FuelTypeColumn"));
        UserColumn.setText(rbB.getString("UserColumn"));
        initFilter();


        CDColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Integer, Vehicle>, Timestamp>, ObservableValue<Timestamp>>() {
            @Override
            public ObservableValue<Timestamp> call(TableColumn.CellDataFeatures<Map.Entry<Integer, Vehicle>, Timestamp> param) {
                SimpleDateFormat dateFormat=new SimpleDateFormat(rbB.getString("dataFormat"));
                return new SimpleObjectProperty(dateFormat.format(param.getValue().getValue().getCreationDate()));
            }
        });

    }


    public void up_show(Map map) throws VehicleTypeException, FuelTypeException {
        LinkedHashMap<Integer,Vehicle> Map=new LinkedHashMap<Integer, Vehicle>();
        Map.putAll(map);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0,0,canvas.getWidth(),canvas.getHeight());
        gc.setStroke(javafx.scene.paint.Color.BLACK);
        for (double i=0;i<canvas.getWidth();i=i+40){
            gc.strokeLine(i,0,i,canvas.getHeight());
        }
        for (double j=canvas.getHeight();j>0;j=j-40){
            gc.strokeLine(0,j,canvas.getWidth(),j);
        }
        /*String creationData= String.valueOf(LocalDateTime.now());
        Vehicle vehicle=new Vehicle("Alena1",55,77,creationData,78,96,"CAR","KEROSENE","III");
        vehicle.setCanvas(canvas);
        vehicle.setColor(Color.BLUE);
        vehicle.setDrawer(Open_stage,login,p,rbB,sender,answer);
        Vehicle vehicle2=new Vehicle("Alena2",155,177,creationData,78,96,"CAR","KEROSENE","III");
        vehicle2.setCanvas(canvas);
        vehicle2.setColor(Color.BLUE);
        vehicle2.setDrawer(Open_stage,login,p,rbB,sender,answer);*/


        Double extraX=0.0;
        Double extraY=0.0;
        Double negX=0.0;
        Double negY=0.0;
        Double cofX=1.0;
        Double cofY=1.0;
        AtomicReference<Double> maxX= new AtomicReference<>(0.0);
        AtomicReference<Double> maxY = new AtomicReference<>(0.0);
        AtomicReference<Double> minX= new AtomicReference<>(0.0);
        AtomicReference<Double> minY = new AtomicReference<>(0.0);
        System.out.println("WC: "+canvas.getWidth()+" HC: "+canvas.getHeight());
        System.out.println(Map.size());
Map.entrySet().stream().filter(Vehicle->Vehicle.getValue().c.getX()> maxX.get()).forEach(Vehicle-> maxX.set(Vehicle.getValue().c.getX()));
System.out.println("maxX: "+maxX.get());
Map.entrySet().stream().filter(Vehicle->Vehicle.getValue().c.getY()> maxY.get()).forEach(Vehicle-> maxY.set(Double.valueOf(Vehicle.getValue().c.getY())));
        Map.entrySet().stream().filter(Vehicle->Vehicle.getValue().c.getX()< minX.get()).forEach(Vehicle-> minX.set(Vehicle.getValue().c.getX()));
        Map.entrySet().stream().filter(Vehicle->Vehicle.getValue().c.getY()< minY.get()).forEach(Vehicle-> minY.set(Double.valueOf(Vehicle.getValue().c.getY())));
        System.out.println(canvas.getWidth());
        System.out.println(cofX);
        int prX=0;
if(maxX.get()<canvas.getWidth()){
        double pX=(canvas.getWidth()/28)*cofX;
        String[] a = String.valueOf(pX).split("[.]");
        prX = Integer.parseInt(a[0]);
}else{
    prX = (int) ((maxX.get()+Math.abs(minX.get()))/28);
}
        x1.setText(String.valueOf(minX.get()));

        x3.setText(String.valueOf(minX.get()+2*prX));  x5.setText(String.valueOf(minX.get()+4*prX));
        x7.setText(String.valueOf(minX.get()+6*prX)); x9.setText(String.valueOf(minX.get()+8*prX));
        x11.setText(String.valueOf(minX.get()+10*prX)); x13.setText(String.valueOf(minX.get()+10*prX)); x15.setText(String.valueOf(minX.get()+14*prX));
         x17.setText(String.valueOf(minX.get()+16*prX));  x19.setText(String.valueOf(minX.get()+18*prX));  x21.setText(String.valueOf(minX.get()+20*prX));
        x23.setText(String.valueOf(minX.get()+22*prX));  x25.setText(String.valueOf(minX.get()+24*prX));  x27.setText(String.valueOf(minX.get()+26*prX));
int prY=0;
if(maxY.get()<canvas.getHeight()){
        double pY=(canvas.getHeight()/20)*cofY;
        String[] b = String.valueOf(pY).split("[.]");
        prY = Integer.parseInt(b[0]);}else{
    prY=(int) ((maxY.get()+Math.abs(minY.get()))/20);
}
        y1.setText(String.valueOf(minY.get())); y3.setText(String.valueOf(minY.get()+2*prY)); y5.setText(String.valueOf(minY.get()+4*prY)); y7.setText(String.valueOf(minY.get()+6*prY));
        y9.setText(String.valueOf(minY.get()+8*prY)); y11.setText(String.valueOf(minY.get()+10*prY)); y13.setText(String.valueOf(minY.get()+12*prY)); y15.setText(String.valueOf(minY.get()+14*prY));
        y17.setText(String.valueOf(minY.get()+18*prY)); y19.setText(String.valueOf(minY.get()+18*prY));



        if(maxX.get()+20>canvas.getWidth()){ negX=maxX.get()+20-canvas.getWidth(); }
        if(minX.get()<0){extraX=minX.get();}
        if(maxY.get()+20>canvas.getHeight()){negY=maxY.get()+20-canvas.getHeight();}
        if(minY.get()<0){extraY=minY.get();}
        if(maxX.get()+20+Math.abs(minX.get())>canvas.getWidth()){cofX=canvas.getWidth()/(maxX.get()+20+Math.abs(minX.get()));}
        if(maxY.get()+20+Math.abs(minY.get())>canvas.getHeight()){cofY=canvas.getHeight()/(maxY.get()+20+Math.abs(minY.get()));}
        if(negX>=minX.get()){
            negX=0.0;
        }
        if(negY>=minY.get()){
            negY=0.0;
        }

        Map.entrySet().stream().filter(Vehicle->!colorHashMap.containsKey(Vehicle.getValue().getUser())).forEach(Vehicle->colorHashMap.put(Vehicle.getValue().getUser(),new Color(new Random().nextInt(256), new Random().nextInt(256), new Random().nextInt(256))));
    System.out.println(colorHashMap.size());
    Map.entrySet().stream().forEach(Vehicle->Vehicle.getValue().setColor(colorHashMap.get(Vehicle.getValue().getUser())));
    Map.entrySet().stream().forEach(Vehicle->Vehicle.getValue().setKey(Vehicle.getKey()));
        Double finalExtraX = extraX;
        Double finalExtraY = extraY;
        Double finalNegX = negX;
        Double finalNegY = negY;
        Double finalCofX = cofX;
        Double finalCofY = cofY;
        System.out.println("extraX "+extraX+" extraY "+extraY+" negX "+negX+" negY "+negY+" cofX "+cofX+" cofY :"+cofY);
        System.out.println("Main:"+extraX+" "+extraY);
        System.out.println("Main2:"+finalExtraX+" "+finalExtraY);
        Map.entrySet().stream().forEach(Vehicle->Vehicle.getValue().setDrawer(Open_stage,login,p,rbB,sender,answer,canvas, finalExtraX, finalExtraY, finalNegX, finalNegY, finalCofX, finalCofY));
        //Drawer drawer=new Drawer(canvas,colorHashMap,Map);
    //drawer.draw();

    }


    public Canvas getCanvas() {
        return canvas;
    }

    public void initData(Map map) throws IOException {
        Command command = new Command("show");
        command.setLogin(login);
        //System.out.println(new String(p));
        command.setPassword(new String(p));
        map.putAll(sender.sendMessage(command).getMap());
        //System.out.println(sender.sendMessage(command).getMap());
        //LinkedHashMap<Integer,Vehicle> map=sender.sendMessage(new Command("show")).getMap();
        //usersData.addAll(map);
    }

    public void ref() throws IOException {
        Command command = new Command("last_change");
        command.setLogin(login);
        command.setPassword(new String(p));
        Timestamp time;
         time= sender.sendMessage(command).getTime();
        System.out.println(time);
        if(time!=null) {
            if (time.equals(last_change)) {
            } else {
                setLast_change(time);
                items.removeAll();
                Map<Integer, Vehicle> map = new LinkedHashMap<Integer, Vehicle>();
                initData(map);
                items.setAll(map.entrySet());
                table.refresh();
            }
        }
    }

    Thread up = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(2000);
                    ref();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    public void setLast_change(Timestamp last_change) {
        this.last_change = last_change;
    }

    private void initFilter() {

        filter.textProperty().addListener(new InvalidationListener() {


            @Override
            public void invalidated(Observable observable) {
                if (filter.textProperty().get().isEmpty()) {
                    table.setItems(items);
                    return;
                }
                ObservableList<Map.Entry<Integer, Vehicle>> tableItems = FXCollections.observableArrayList();
                ObservableList<TableColumn<Map.Entry<Integer, Vehicle>, ?>> cols = table.getColumns();
                for (int i = 0; i < items.size(); i++) {
                    for (int j = 0; j < cols.size(); j++) {
                       // items.stream().filter(TableColumn -> TableColumn.equals());
                        ////int finalJ = j;
                        //int finalI = i;
                        //tableItems.stream().filter(TableColumn -> TableColumn.getValue().)
                        TableColumn col = cols.get(j);
                        String cellValue = col.getCellData(items.get(i)).toString();
                        cellValue = cellValue.toLowerCase();
                        if (cellValue.contains(filter.textProperty().get().toLowerCase())) {
                            tableItems.add(items.get(i));
                            break;
                        }
                    }

                }
                table.setItems(tableItems);
            }
        });
    }

    public void open(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Map.Entry<Integer, Vehicle> m = (Map.Entry<Integer, Vehicle>) table.getSelectionModel().getSelectedItem();
        Integer key=m.getKey();
        Vehicle vehicle=m.getValue();
        Command command=new Command();
        command.setLogin(login);
        command.setPassword(new String(p));
        Open open=new Open();
        open.setRoot(sender,command,answer,key,vehicle,Open_stage,rbB);
        Open_stage.setScene(new Scene(open.getRoot()));
        Open_stage.show();
    }


}

