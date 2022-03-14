package com.schwabarista.baristaview;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.ListQueuesRequest;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import java.util.Date;
import software.amazon.awssdk.regions.Region;
import com.amazonaws.regions.Regions;

public class MainPageController {

    @FXML
    public ListView<OrderModel> MainListView;

    @FXML
    public Button QuitButton;

    public void initialize() {
        MainListView.setCellFactory(new OrderCellFactory());
    }

    @FXML
    void QuitButtonClicked (MouseEvent event) {
        Platform.exit();
    }
}
