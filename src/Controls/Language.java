package Controls;

import Client_side.Sender;
import Commands.Command;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.ResourceBundle;

public class Language {
    private Parent root;

    @FXML
    private ComboBox<Locale> languages;
    @FXML
    private Label language;
    @FXML
    private Button choose;
    private static Stage stage;
    @FXML
    private Label ErrorLanguage;
    private String error;
    private static Locale locale;
    private ResourceBundle rbB;


    public void setStage(Stage stage) {
        this.stage = stage;
    }


    public Parent getRoot() {
        return root;
    }

    public void setRoot() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/Resources/Language.fxml");
        loader.setLocation(xmlUrl);
        root = loader.load();
    }

    public void click() throws IOException {

        if(languages.getValue()!=null){
               Port port=new Port();
              // port.setLocale(locale);
               port.setRoot(rbB);
               port.setStage(stage);

               //System.out.println(locale);

               //port.setLocale(locale);
               stage.setScene(new Scene(port.getRoot()));

        }else{
            ErrorLanguage.setText(error);
        }
    }
    public void initialize() {
        ArrayList<Locale> listLocale = new ArrayList<>(4);
        listLocale.add(new Locale("ru", "RU")); //русский, Россия
        listLocale.add(new Locale("nd", "ND")); //нидерландский, Нидерланды
        listLocale.add(new Locale("vn", "VN")); //венгерский, Венгрия
        listLocale.add(new Locale("en", "NZ")); //английский, Новая зеландия
        languages.setItems(FXCollections.observableArrayList(listLocale));
        //setL10nRoot(new Locale("en","NZ"));
        //Locale.setDefault(new Locale("ru", "RU"));
        languages.setOnAction(event -> setL10nRoot(languages.getValue()));

        //languages.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
        //    if(newSel != null)
        //        setL10nRoot(languages.getValue());
       // });

        // setL10nRoot(new Locale("ru", "RU"));
    }

    public void setL10nRoot(Locale loc){
        this.locale=loc;
        rbB = ResourceBundle.getBundle("Languages.MLang",loc);
        language.setText(rbB.getString("LLanguage"));
        choose.setText(rbB.getString("bChoose"));
        error=rbB.getString("eLanguage");
        stage.setTitle(rbB.getString("lang_title"));
    }
}

