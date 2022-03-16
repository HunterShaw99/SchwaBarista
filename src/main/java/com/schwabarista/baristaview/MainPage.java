package com.schwabarista.baristaview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPage extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        //FXMLLoader fxmlLoader = new FXMLLoader(MainPage.class.getResource("core/controllers/detail-page-view.fxml"));

        FXMLLoader fxmlLoader = new FXMLLoader(MainPage.class.getResource("main-page-view.fxml"));
        MainPageController mainpagecontroller = new MainPageController(new ObserverManager());
        fxmlLoader.setController(mainpagecontroller);

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("QC Employee View");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}