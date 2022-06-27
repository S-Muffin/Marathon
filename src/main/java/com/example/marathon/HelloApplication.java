package com.example.marathon;

import com.itextpdf.kernel.pdf.PdfWriter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;


public class HelloApplication extends Application {

    public static ArrayList<Teilnehmer> teilnehmerListe;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        //launch();



    Teilnehmer eins = new Teilnehmer("Hans", "Weinberg", "Herr", "10km Lauf", 10.14);
    Teilnehmer zwei = new Teilnehmer("Kevin", "Kampus", "Frau", "10km Lauf", 10.14);

        System.out.println(eins);
        PdfWriter

    }
}