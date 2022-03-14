module com.schwabarista.baristaview {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires aws.java.sdk.sqs;
    requires aws.java.sdk.core;
    requires software.amazon.awssdk.regions;

    opens com.schwabarista.baristaview to javafx.fxml;
    exports com.schwabarista.baristaview;
    exports com.schwabarista.baristaview.core.controllers;
    opens com.schwabarista.baristaview.core.controllers to javafx.fxml;
}