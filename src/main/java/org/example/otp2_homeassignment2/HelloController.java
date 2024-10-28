package org.example.otp2_homeassignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    public Button button1;
    @FXML
    public Button button2;
    @FXML
    public Button button3;
    @FXML
    public Label label;

    public void setEN(ActionEvent actionEvent) throws IOException {
        Locale l = new Locale("en", "EN");
        loadView(l);
    }

    public void setIR(ActionEvent actionEvent) throws IOException {
        Locale l = new Locale("fa", "IR");
        loadView(l);
    }

    public void setJP(ActionEvent actionEvent) throws IOException {
        Locale l = new Locale("ja", "JP");
        loadView(l);
    }

    public void loadView(Locale locale) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        fxmlLoader.setResources(ResourceBundle.getBundle("bundle", locale));
        try {
            Parent root = fxmlLoader.load();
            Stage s = (Stage) button1.getScene().getWindow();
            s.setScene(new Scene(root));

            HelloController newController = fxmlLoader.getController();
            newController.updateLabel(locale);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void updateLabel(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("bundle", locale);
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String currentTime = dateFormat.format(new Date());
        label.setText(bundle.getString("label.text").replace("{Time}", currentTime));
        System.out.println(currentTime);
    }
}