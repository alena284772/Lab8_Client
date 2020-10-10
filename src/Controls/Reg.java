package Controls;

import Client_side.Sender;
import Commands.Command;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Reg {
    private Parent root;
    @FXML
    private TextField Login_field;
    @FXML
    private PasswordField Password_field;
    @FXML
    private Button sign_in_button;
    @FXML
    private Button reg_button;
    private String login;
    private byte[] p;
    @FXML
    private Label Answer,Login,Password;
    //public String add;
    //public static int port;
    public static Sender sender=new Sender();
    private static Stage stage;
    private static ResourceBundle rbB;
    private String goodanswer;
    private String pas_inc_answer;
    private String User_inc_answer;
    private String user_ex_answer;
    private String server_error_answer;

    //SocketAddress socketAddress=new InetSocketAddress("localhost",7418);


    public void setStage(Stage stage) {
       this.stage = stage;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Sender getSender() {
        return sender;
    }

    public Parent getRoot() {
        return root;
    }

    public void setRoot(ResourceBundle rbB) throws IOException, NoSuchAlgorithmException {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/Resources/Reg.fxml");
        loader.setLocation(xmlUrl);
        this.rbB=rbB;
        root = loader.load();


        //wait_to();
        //System.out.println("SetRoot"+port);

    }
    public void wait_to() throws NoSuchAlgorithmException {

            if(Answer.getText()=="Обработка запроса"){
                Command command=new Command();
                command.setName("avtor");
                login=Login_field.getText();
                String password;
                password=Password_field.getText();
                p = MessageDigest.getInstance("MD5").digest(password.getBytes());
                command.setLogin(login);
                command.setPassword(new String(p));
                //System.out.println("wait_to"+this.getPort());


        }
    }
    public void initialize() {

        setL10nRoot(rbB);
    }

    public void setL10nRoot(ResourceBundle rbB){
        Answer.setText(rbB.getString("LAnswer"));
        sign_in_button.setText(rbB.getString("SIButton"));
        reg_button.setText(rbB.getString("RegButton"));
        Login.setText(rbB.getString("Login"));
        Password.setText(rbB.getString("Password"));
        goodanswer=rbB.getString("good_answer");
        pas_inc_answer=rbB.getString("pas_inc_answer");
        User_inc_answer=rbB.getString("user_inc_answer");
        user_ex_answer=rbB.getString("user_ex_answer");
        server_error_answer=rbB.getString("server_error_answer");

    }


    public void sign_in() throws NoSuchAlgorithmException, IOException {
       // System.out.println(getPort());
       // System.out.println(socketAddress.toString());
        Command command=new Command();
        command.setName("avtor");
        login=Login_field.getText();
        String password;
        password=Password_field.getText();
        p = MessageDigest.getInstance("MD5").digest(password.getBytes());
        command.setLogin(login);
        command.setPassword(new String(p));
        String answer=" ";
        System.out.println("Sender "+sender.toString());
        answer=this.sender.sendMessage(command).getAnswer();
        if (this.sender.sendMessage(command).getAnswer().equals("Авторизация прошла успешно.")) {
                 Answer.setTextFill(Color.BLUE);
                 Answer.setText(goodanswer);
                 Main main=new Main();
                 main.setLogin(login);
                 main.setP(p);
                 main.setSender(this.getSender());
                 main.setRoot(rbB);
                 //Stage stage=new Stage();
                 stage.setScene(new Scene(main.getRoot()));
                 //stage.show();
             }else {if(answer.equals("Password is uncorrect")){

                 Answer.setTextFill(Color.RED);
                 Answer.setText(pas_inc_answer);
        }else {
                 if(answer.equals("A user with this username does not exist")){
                 Answer.setText(User_inc_answer);
                     Answer.setTextFill(Color.RED);}else{
                     Answer.setText(server_error_answer);
                     Answer.setTextFill(Color.RED);
                 }
        }
        }
       // Answer.setText("Обработка запроса");
       // wait_to();



}
@FXML
private void reg() throws NoSuchAlgorithmException, IOException {
        Command command=new Command();
    command.setName("reg");
    login=Login_field.getText();
    String password;
    password=Password_field.getText();
    p = MessageDigest.getInstance("MD5").digest(password.getBytes());
    command.setLogin(login);
    command.setPassword(new String(p));
    String answer=" ";
    answer=this.sender.sendMessage(command).getAnswer();
    if (answer.equals("Пользователь добавлен")) {
        Answer.setTextFill(Color.BLUE);
        //Answer.setText(goodanswer);
        Main main=new Main();
        main.setLogin(login);
        main.setP(p);
        main.setSender(this.getSender());
        main.setRoot(rbB);
        //Stage stage=new Stage();
        stage.setScene(new Scene(main.getRoot()));
        //stage.show();
    }else {if(answer.equals("Пользователь с таким именем уже существует")){
        Answer.setTextFill(Color.RED);
        Answer.setText(user_ex_answer);
    }else {
        if(answer.equals("В данный момент нет доступа к серверу. Попробуйте сделать запрос позже")){
            Answer.setTextFill(Color.RED);
            Answer.setText(user_ex_answer);
        }
    }
    }

}
}
