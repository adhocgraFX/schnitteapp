import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.event.Event;

import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.DatePicker;

import static java.time.LocalDate.now;
import java.time.format.DateTimeFormatter;

import static java.math.RoundingMode.DOWN;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by Hock on 06.10.2016.
 */

public class Controller {

    // datumsformat
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    String formattedDateValue;

    // Button Reset
    @FXML
    private Button btnBerechnen;
    // Button Reset
    @FXML
    private Button btnReset;
    // Combo Kurs
    @FXML
    private ComboBox<Kurse> comboKurs;
    private ObservableList<Kurse> myComboKursData = FXCollections.observableArrayList();

    // Combo Semester
    @FXML
    private ComboBox<Semester> comboSemester;
    private ObservableList<Semester> myComboSemesterData = FXCollections.observableArrayList();
    @FXML
    private DatePicker pickerDate;
    // Text Area output
    @FXML
    private TextArea txtErgebnis;
    // Spinner
    // Noten
    @FXML
    private Spinner<Integer> N1;
    @FXML
    private Spinner<Integer> N2;
    @FXML
    private Spinner<Integer> N3;
    @FXML
    private Spinner<Integer> N4;
    @FXML
    private Spinner<Integer> N5;
    @FXML
    private Spinner<Integer> N6;
    // Punkte
    @FXML
    private Spinner<Integer> P0;
    @FXML
    private Spinner<Integer> P1;
    @FXML
    private Spinner<Integer> P2;
    @FXML
    private Spinner<Integer> P3;
    @FXML
    private Spinner<Integer> P4;
    @FXML
    private Spinner<Integer> P5;
    @FXML
    private Spinner<Integer> P6;
    @FXML
    private Spinner<Integer> P7;
    @FXML
    private Spinner<Integer> P8;
    @FXML
    private Spinner<Integer> P9;
    @FXML
    private Spinner<Integer> P10;
    @FXML
    private Spinner<Integer> P11;
    @FXML
    private Spinner<Integer> P12;
    @FXML
    private Spinner<Integer> P13;
    @FXML
    private Spinner<Integer> P14;
    @FXML
    private Spinner<Integer> P15;
    // tabs
    // Tab selection
    private boolean tabSelection = false;
    private boolean initReady = false;
    private String tabModus;
    @FXML
    private Tab tabNoten;
    @FXML
    private Tab tabPunkte;

    public Controller() {
        // Create data for the Combo Boxes
        myComboKursData.add(new Kurse("1ku1"));
        myComboKursData.add(new Kurse("1ku2"));
        myComboKursData.add(new Kurse("1ku3"));
        myComboKursData.add(new Kurse("2ku1"));
        myComboKursData.add(new Kurse("2ku2"));
        myComboKursData.add(new Kurse("2ku3"));

        myComboSemesterData.add(new Semester("11/1"));
        myComboSemesterData.add(new Semester("11/2"));
        myComboSemesterData.add(new Semester("12/1"));
        myComboSemesterData.add(new Semester("12/2"));
    }

    @FXML
    private void actionBerechnen(ActionEvent actionEvent) {
        // berechnen code
        if (tabModus.equals("tabPunkte")) {
            punkteBerechnen();
            System.out.println("Punkte Berechnen button has been clicked");
        } else if (tabModus.equals("tabNoten")) {
            notenBerechnen();
            System.out.println("Noten Berechnen button has been clicked");
        }
    }

    @FXML
    private void actionReset(ActionEvent actionEvent) {
        // reset code
        if (tabModus.equals("tabPunkte")) {
            punkteReset();
            System.out.println("Punkte Reset button has been clicked");
        } else if (tabModus.equals("tabNoten")) {
            notenReset();
            System.out.println("Noten Reset button has been clicked");
        }
    }

    @FXML
    private void actionChooseDate(ActionEvent actionEvent) {
        Berechnungen.datum = pickerDate.getValue();
        System.out.println("pickerDate Action selected: " + Berechnungen.datum);
    }

    @FXML
    private void initialize() {
        // Init ComboBox items.
        comboKurs.setItems(myComboKursData);
        comboSemester.setItems(myComboSemesterData);

        // allgemeiner reset
        Berechnungen.punkteInstanziieren();
        Berechnungen.notenInstanziieren();

        // punkte-anzahlen zu noten-anzahlen
        Berechnungen.notenSynchronisieren();

        // noten inputs resetten
        resetNotenInputValues();
        // punkte inputs reset
        resetPunkteInputValues();

        // combos, datepicker und txt ergebnis resetten
        resetInputValues();

        System.out.println("initialize ausgeführt");
    }

    @FXML
    private void actionChooseKurs(ActionEvent actionEvent) {
        Kurse selectedKurs = comboKurs.getSelectionModel().getSelectedItem();
        System.out.println("comboKurs Action (selected: " + selectedKurs.toString() + ")");
    }

    @FXML
    private void actionChooseSemester(ActionEvent actionEvent) {
        Semester selectedSemester = comboSemester.getSelectionModel().getSelectedItem();
        System.out.println("comboSemester Action (selected: " + selectedSemester.toString() + ")");
    }

    /**
     * Methode: noten-anzahlen aus jspinner einlesen und noten-array [i][1] damit füllen
     */
    private void getNotenAnzahlen() {
        // Noten in array einlesen
        Berechnungen.noten[6][1] = N6.getValue();
        Berechnungen.noten[5][1] = N5.getValue();
        Berechnungen.noten[4][1] = N4.getValue();
        Berechnungen.noten[3][1] = N3.getValue();
        Berechnungen.noten[2][1] = N2.getValue();
        Berechnungen.noten[1][1] = N1.getValue();
    }

    /**
     * Methode: punkte-anzahlen aus jspinner einlesen und punkte-array [i][1] damit füllen
     */
    private void getPunkteAnzahlen() {
        // zweiten wert mit punkte-anzahlen füllen
        Berechnungen.punkte[15][1] = P15.getValue();
        Berechnungen.punkte[14][1] = P14.getValue();
        Berechnungen.punkte[13][1] = P13.getValue();
        Berechnungen.punkte[12][1] = P12.getValue();
        Berechnungen.punkte[11][1] = P11.getValue();
        Berechnungen.punkte[10][1] = P10.getValue();
        Berechnungen.punkte[9][1] = P9.getValue();
        Berechnungen.punkte[8][1] = P8.getValue();
        Berechnungen.punkte[7][1] = P7.getValue();
        Berechnungen.punkte[6][1] = P6.getValue();
        Berechnungen.punkte[5][1] = P5.getValue();
        Berechnungen.punkte[4][1] = P4.getValue();
        Berechnungen.punkte[3][1] = P3.getValue();
        Berechnungen.punkte[2][1] = P2.getValue();
        Berechnungen.punkte[1][1] = P1.getValue();
        Berechnungen.punkte[0][1] = P0.getValue();
    }

    @FXML
    void tabNotenSelected(Event event) {
        if (checkTab()) {
            tabModus = tabNoten.getId();
            System.out.println(tabModus);
        }

        if (!checkInit()) {
            punkteReset();
            System.out.println("Punktereset nicht bei init");
        }
    }

    @FXML
    void tabPunkteSelected(Event event) {
        if (checkTab()) {
            tabModus = tabPunkte.getId();
            System.out.println(tabModus);
        }

        if (!checkInit()) {
            notenReset();
            System.out.println("Notenreset nicht bei init");
        }
    }

    private boolean checkTab() {
        tabSelection = !tabSelection;
        return tabSelection;
    }

    private boolean checkInit() {
        initReady = !initReady;
        return initReady;
    }

    // Methode punkte inputs reset
    private void resetPunkteInputValues() {
        P15.getValueFactory().setValue(0);
        P14.getValueFactory().setValue(0);
        P13.getValueFactory().setValue(0);
        P12.getValueFactory().setValue(0);
        P11.getValueFactory().setValue(0);
        P10.getValueFactory().setValue(0);
        P9.getValueFactory().setValue(0);
        P8.getValueFactory().setValue(0);
        P7.getValueFactory().setValue(0);
        P6.getValueFactory().setValue(0);
        P5.getValueFactory().setValue(0);
        P4.getValueFactory().setValue(0);
        P3.getValueFactory().setValue(0);
        P2.getValueFactory().setValue(0);
        P1.getValueFactory().setValue(0);
        P0.getValueFactory().setValue(0);
    }

    // Methode combos, datepicker und txt ergebnis reset
    private void resetInputValues() {
        txtErgebnis.setText(null);
        comboSemester.getSelectionModel().select(0);
        comboKurs.getSelectionModel().select(0);
        pickerDate.setValue(now());
    }

    // Methode Punkte Reset
    private void punkteReset() {
        // allgemeiner reset
        Berechnungen.punkteInstanziieren();
        Berechnungen.notenInstanziieren();

        // punkte-anzahlen zu noten-anzahlen
        Berechnungen.notenSynchronisieren();

        // punkte inputs reset
        resetPunkteInputValues();

        // combos, datepicker und txt ergebnis reset
        resetInputValues();
    }

    // Methode noten inputs reset
    private void resetNotenInputValues() {
        // Wert auf 0 synchnisieren
        N6.getValueFactory().setValue(0);
        N5.getValueFactory().setValue(0);
        N4.getValueFactory().setValue(0);
        N3.getValueFactory().setValue(0);
        N2.getValueFactory().setValue(0);
        N1.getValueFactory().setValue(0);
    }

    // Method action notenReset
    private void notenReset() {
        // allgemeiner reset
        Berechnungen.punkteInstanziieren();
        Berechnungen.notenInstanziieren();

        // punkte-anzahlen zu noten-anzahlen
        Berechnungen.notenSynchronisieren();

        // noten inputs resetten
        resetNotenInputValues();

        // combos, datepicker und txt ergebnis resetten
        resetInputValues();
    }

    /**
     * Methode Zahlen anch 2 kommastellen abschneiten
     */
    private String formatErgebnis(double ergebnis) {
        // double auf 2 stellen hinter komma abschneiden, nicht runden
        NumberFormat numberFormat = new DecimalFormat("0.00");
        numberFormat.setRoundingMode(DOWN);

        // formatiertes ergebnis ausgeben
        return numberFormat.format(ergebnis);
    }

    // Methode Punkte berechnen
    private void punkteBerechnen() {

        // punkte-anzahlen aus jspinner einlesen und punkte-array [i][1] damit füllen
        getPunkteAnzahlen();

        // punkte-anzahlen zu noten-anzahlen
        Berechnungen.notenSynchronisieren();

        // temporäre Berechnungen
        Berechnungen.tempPunkteBerechnungen();

        // Berechnungen
        Berechnungen.klausurenAnzahlBerechnen();

        if (Berechnungen.klausurenAnzahlBerechnen() != 0) {
            Berechnungen.punkteSchnittBerechnen(Berechnungen.temppunktesumme, Berechnungen.anzahl);
            Berechnungen.notenSchnittBerechnen(Berechnungen.tempnotensumme, Berechnungen.anzahl);
            Berechnungen.ungenuegendBerechnen(Berechnungen.tempungenuegend, Berechnungen.anzahl);

            // combos auslesen
            Berechnungen.kursName = comboKurs.getSelectionModel().getSelectedItem();
            Berechnungen.semester = comboSemester.getSelectionModel().getSelectedItem();
            Berechnungen.datum = pickerDate.getValue();
            formattedDateValue = (pickerDate.getValue()).format(formatter);

            // neues Objekt
            Schnitte schnitteP = new Schnitte(Berechnungen.kursName, Berechnungen.semester,
                    Berechnungen.datum, Berechnungen.anzahl, Berechnungen.punkteschnitt,
                    Berechnungen.notenschnitt, Berechnungen.ungenuegend);

            // Ergebnis
            txtErgebnis.setText(null);
            txtErgebnis.setText("Kurs: " + schnitteP.kurs.kursName + "\n" +
                    "Semester: " + schnitteP.kurs.semester + "\n" +
                    "Datum: " + formattedDateValue + "\n" +
                    "Anzahl der Arbeiten: " + schnitteP.anzahl + "\n" +
                    "Punkteschnitt: " + formatErgebnis(schnitteP.schnittPunkte) + "\n" +
                    "Notenschnitt: " + formatErgebnis(schnitteP.schnittNoten) + "\n" +
                    "Arbeiten mit mangelhaft bzw. ungenügend: " + formatErgebnis(schnitteP.prozentUngenuegend) + "%");
        } else if (Berechnungen.klausurenAnzahlBerechnen() == 0) {
            txtErgebnis.setText(null);
            txtErgebnis.setText("Geben Sie zuerst Zahlenwerte ein.");
        }

        // allgemeiner reset
        Berechnungen.punkteInstanziieren();
        Berechnungen.notenInstanziieren();

        // punkte-anzahlen zu noten-anzahlen
        Berechnungen.notenSynchronisieren();
    }

    // Methode Noten berechnen
    private void notenBerechnen() {
        // noten-anzahlen aus jspinner einlesen und punkte-array [i][1] damit füllen
        getNotenAnzahlen();

        // temporäre Berechnungen
        Berechnungen.tempNotenBerechnungen();

        // Berechnungen
        Berechnungen.schulaufgabenAnzahlBerechnen();

        if (Berechnungen.schulaufgabenAnzahlBerechnen() != 0) {
            Berechnungen.notenSchnittBerechnen(Berechnungen.tempnotensumme, Berechnungen.anzahl);
            Berechnungen.ungenuegendBerechnen(Berechnungen.tempungenuegend, Berechnungen.anzahl);

            // combos auslesen
            Berechnungen.kursName = comboKurs.getSelectionModel().getSelectedItem();
            Berechnungen.semester = comboSemester.getSelectionModel().getSelectedItem();
            Berechnungen.datum = pickerDate.getValue();
            formattedDateValue = (pickerDate.getValue()).format(formatter);

            // neues Objekt
            Schnitte schnitteN = new Schnitte(Berechnungen.kursName, Berechnungen.semester,
                    Berechnungen.datum, Berechnungen.anzahl,
                    Berechnungen.notenschnitt, Berechnungen.ungenuegend);

            // Ergebnis
            txtErgebnis.setText(null);
            txtErgebnis.setText("Kurs: " + schnitteN.kurs.kursName + "\n" +
                    "Semester: " + schnitteN.kurs.semester + "\n" +
                    "Datum: " + formattedDateValue + "\n" +
                    "Anzahl der Arbeiten: " + schnitteN.anzahl + "\n" +
                    "Notenschnitt: " + formatErgebnis(schnitteN.schnittNoten) + "\n" +
                    "Arbeiten mit mangelhaft bzw. ungenügend: " + formatErgebnis(schnitteN.prozentUngenuegend) + "%");
        } else if (Berechnungen.schulaufgabenAnzahlBerechnen() == 0) {
            txtErgebnis.setText(null);
            txtErgebnis.setText("Geben Sie zuerst Zahlenwerte ein.");
        }

        // allgemeiner reset
        Berechnungen.punkteInstanziieren();
        Berechnungen.notenInstanziieren();

        // punkte-anzahlen zu noten-anzahlen
        Berechnungen.notenSynchronisieren();
    }
}
