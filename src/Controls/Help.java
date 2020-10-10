package Controls;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;

public class Help {
    private Parent root;

    public Parent getRoot() {
        return root;
    }

    public void setRoot() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/Resources/Help.fxml");
        loader.setLocation(xmlUrl);
        root = loader.load();


    }
}
