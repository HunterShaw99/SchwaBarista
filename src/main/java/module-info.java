module com.schwabarista.baristaview {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.schwabarista.baristaview to javafx.fxml;
    exports com.schwabarista.baristaview;
}