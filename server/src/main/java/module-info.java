module gov.iti.jets.server {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.sql.rowset;
    requires java.rmi;
    requires java.desktop;
    requires com.google.common;
    requires lombok;
    requires mysql.connector.j;
    requires gov.iti.jets.common;
    requires com.jfoenix;

    exports gov.iti.jets.server;
    exports gov.iti.jets.server.presentation.controllers;
}
