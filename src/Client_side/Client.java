package Client_side;

import Commands.Command;
import Controls.*;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client extends Application {


    public static void main(String[] args) throws Exception {
        Application.launch();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.show();
        Language language=new Language();
        language.setRoot();
        language.setStage(primaryStage);
        primaryStage.setTitle("Choose language");

        primaryStage.setScene(new Scene(language.getRoot()));

    }



}
