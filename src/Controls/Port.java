package Controls;

import Client_side.Client;
import Client_side.Sender;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.ResourceBundle;

public class Port {
private Parent root;
@FXML
private TextField address;
@FXML
private TextField port;
@FXML
private Button send_button;
@FXML
private Label answer,enter,enter_port;
private String add;
private int Port;
public Sender sender=new Sender();
private String answ;
private String nexttitle;
private static ResourceBundle rbB;
private static Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Parent getRoot() {
        return root;
    }


    public void setRoot(ResourceBundle rbB) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/Resources/Port.fxml");
        loader.setLocation(xmlUrl);

        this.rbB=rbB;
        root = loader.load();

        //System.out.println(locale.toString());
    }



    public void send() throws IOException, NoSuchAlgorithmException {
        add=address.getText();
        Port= Integer.parseInt(port.getText());
        if (Port < 0 || Port > 65535) {
                        answer.setText(answ);
                    } else {
            answer.setText("Port is now: " + Port);
            Reg reg=new Reg();
            reg.setRoot(rbB);
            reg.setStage(stage);
            SocketAddress socketAddress=new InetSocketAddress(add,Port);
            sender.setSocketAddress(socketAddress);
            reg.setSender(sender);
            System.out.println("Sender "+sender.toString());
            System.out.println(sender.getSocketAddress());
            //reg.setAdd(add);
            System.out.println(Port);
            //reg.setPort(Port);
            //System.out.println(reg.getPort());
            //reg.setRoot(Port);

            stage.setTitle(nexttitle);
            stage.setScene(new Scene(reg.getRoot()));
            //stage.close();


                    }

    }
    public void initialize() {

        setL10nRoot(this.rbB);
    }


    public void setL10nRoot(ResourceBundle rbB){
        System.out.println(rbB.getString("bSend"));
        send_button.setText(rbB.getString("bSend"));
        answer.setText(rbB.getString("LAnswer"));
        enter.setText(rbB.getString("LEnter"));
        enter_port.setText(rbB.getString("LEnterPort"));
        answ=rbB.getString("WrongPort");
        nexttitle=rbB.getString("Regtitle");
    }

}
