package com.example.marathon;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class CertificateController {
    @FXML
    TableView tableView = new TableView();
    @FXML
    TableColumn<Teilnehmer, String> columnAnrede = new TableColumn<>("Anrede");
    @FXML
    TableColumn<Teilnehmer, String> columnVorname = new TableColumn<>("Vorname");

    public static ArrayList<Teilnehmer> teilnehmerListe = new ArrayList<>();

    public void initialize() throws FileNotFoundException {



        columnAnrede.setCellValueFactory(new PropertyValueFactory<>("anrede"));
        tableView.getItems().add(columnAnrede);
        
        columnVorname.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        tableView.getColumns().add(columnVorname);



        Teilnehmer eins = new Teilnehmer("Herr","Hans", "Weinberg", "10km Lauf", 10.14);

        tableView.getItems().add(eins);




        Teilnehmer zwei = new Teilnehmer("","Kevin", "Kampus",  "10km Lauf", 10.15);
        Teilnehmer drei = new Teilnehmer("Herr","Petri", "Kollach",  "10km Lauf", 11.00);
        Teilnehmer vier = new Teilnehmer("Herr","Sullivan", "Trammel",  "10km Lauf", 16.45);
        Teilnehmer fuenf = new Teilnehmer("Frau","Serna", "Imbuktu",  "10km Lauf", 9.25);
        Teilnehmer sechs = new Teilnehmer("Herr","Olliver", "Zappel",  "10km Lauf", 18.47);

        teilnehmerListe.add(eins);
        teilnehmerListe.add(zwei);
        teilnehmerListe.add(drei);
        teilnehmerListe.add(vier);
        teilnehmerListe.add(fuenf);
        teilnehmerListe.add(sechs);


        //testing if sorting algorithm worked correctly
        Collections.sort(teilnehmerListe);
        for (Teilnehmer a : teilnehmerListe) {
            System.out.println(a);
        }

        ArrayList<Teilnehmer> podiumsBesetzer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            podiumsBesetzer.add(teilnehmerListe.get(i));
        }

        for (int i = 0; i < teilnehmerListe.size(); i++) {
            Teilnehmer urkundenEmpfaenger = teilnehmerListe.get(i);
            String vorname = urkundenEmpfaenger.getVorname();
            String nachname = urkundenEmpfaenger.getNachname();

            String PATH = "src/main/resources/certificate" + "_" + vorname + "_" + nachname + ".pdf";



            PdfDocument pdfDoc = new PdfDocument(new PdfWriter(PATH));
            Document document = new Document(pdfDoc);

            String platzierung = "die Teilname";
            int platzZahl = 1;
            for (Teilnehmer t : podiumsBesetzer) {
                if (urkundenEmpfaenger.equals(t)) {
                    platzierung =  "den " + platzZahl + "ten Platz ";
                }
                platzZahl++;
            }

            Paragraph para1 = new Paragraph("Urkunde für "  + platzierung + " im");
            Paragraph para2 = new Paragraph(urkundenEmpfaenger.getWettbewerb());
            Paragraph para3 = new Paragraph("");
            Paragraph para4 = new Paragraph("");
            Paragraph para5 = new Paragraph(urkundenEmpfaenger.getAnrede() + " " + urkundenEmpfaenger.getVorname() + " " + urkundenEmpfaenger.getNachname());
            Paragraph para6 = new Paragraph("");
            Paragraph para7 = new Paragraph("");
            Paragraph para8 = new Paragraph("mit einer Laufzeit von: " + urkundenEmpfaenger.getLaufzeit() + " Minuten");


            para1.setTextAlignment(TextAlignment.CENTER);
            para2.setTextAlignment(TextAlignment.CENTER);
            para3.setTextAlignment(TextAlignment.CENTER);
            para5.setTextAlignment(TextAlignment.CENTER);
            para8.setTextAlignment(TextAlignment.CENTER);


            document.add(para1);
            document.add(para2);
            document.add(para3);
            document.add(para4);
            document.add(para5);
            document.add(para8);


            document.close();
        }
    }

}