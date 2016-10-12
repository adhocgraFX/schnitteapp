import java.time.LocalDate;

/**
 * Created by Hock on 02.10.2016.
 * die Klasse Schnitte repräsentiert die für das Schnitte-Programm
 * notwendigen Attribute des Notenschnitts.
 */
public class Schnitte {
    private Kurse kursName;
    private Semester semester;
    private LocalDate datum;
    // Instanzvariablen
    /**
     * enthält Anzahl der Arbeiten
     */
    int anzahl;
    /**
     * enthält den Punkteschnitt
     */
    double schnittPunkte;
    /**
     * enthält den Notenschnitt
     */
    double schnittNoten;
    /**
     * enthält den % der Punkte/Noten unter P4 bzw N4
     */
    double prozentUngenuegend;
    /**
     * enthält Kurs
     */
    Kurs kurs;
    /**
     * enthält Klausur
     */
    Klausur klausur;

    /**
     * Konstruktor für Objekte der Klasse Schnitte
     * @param kursName
     * @param semester
     * @param datum
     * @param anzahl
     * @param punkteschnitt
     * @param notenschnitt
     * @param ungenuegend
     */



    /**
     * Konstruktor für Objekte der Klasse Schnitte
     */
    public Schnitte(Kurse kursName, Semester semester, LocalDate datum, int anzahl, double schnittPunkte, double schnittNoten, double prozentUngenuegend) {
        this.kursName = kursName;
        this.semester = semester;
        this.datum = datum;
        // Instanzvariable initialisieren
        this.kurs = new Kurs(kursName, semester, datum);
        this.anzahl = anzahl;
        this.schnittPunkte = schnittPunkte;
        this.schnittNoten = schnittNoten;
        this.prozentUngenuegend = prozentUngenuegend;
    }

    /**
     * Konstruktor für Objekte der Klasse Schnitte
     */
    public Schnitte(Kurse kursName, Semester semester, LocalDate datum, int anzahl, double schnittNoten, double prozentUngenuegend) {
        this.kursName = kursName;
        this.semester = semester;
        this.datum = datum;
        // Instanzvariable initialisieren
        this.kurs = new Kurs(kursName, semester, datum);
        this.anzahl = anzahl;
        this.schnittNoten = schnittNoten;
        this.prozentUngenuegend = prozentUngenuegend;
    }

    /**
     * Konstruktor für Objekte der Klasse Schnitte
     */
    public Schnitte(int[][] punkte, int[][] noten) {
        // Instanzvariable initialisieren
        this.klausur = new Klausur(punkte, noten);
    }

    /**
     * Konstruktor für Objekte der Klasse Schnitte
     */
    public Schnitte(int[][] noten) {
        // Instanzvariable initialisieren
        this.klausur = new Klausur(noten);
    }

    /**
     * Konstruktor für Objekte der Klasse Schnitte
     */
    public Schnitte(Kurse kursName, Semester semester, LocalDate datum) {
        // Instanzvariable initialisieren
        this.kurs = new Kurs(kursName, semester, datum);
    }

    // Methoden

    /**
     * Gibt die Anzahl der Schüler dieser Klausur zurück
     */
    public int getAnzahl() {
        return anzahl;
    }

    /**
     * Verändert den Kursnamen dieser Klausur
     */
    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    /**
     * Gibt den Punkteschnitt dieser Klausur zurück
     */
    public double getSchnittPunkte() {
        return schnittPunkte;
    }

    /**
     * Verändert den Punkteschnitt dieser Klausur
     */
    public void setSchnittPunkte(double schnittPunkte) {
        this.schnittPunkte = schnittPunkte;
    }

    /**
     * Gibt den Notenschnitt dieser Klausur zurück
     */
    public double getSchnittNoten() {
        return schnittNoten;
    }

    /**
     * Verändert den Notenschnitt dieser Klausur
     */
    public void setSchnittNoten(double schnittNoten) {
        this.schnittNoten = schnittNoten;
    }

    /**
     * Gibt die Prozentzahl der Noten ab Ungenuegend dieser Klausur zurück
     */
    public double getprozentUngenuegend() {
        return prozentUngenuegend;
    }

    /**
     * Verändert die Prozentzahl der Noten ab Ungenuegend dieser Klausur
     */
    public void setProzentUngenuegend(double prozentUngenuegend) {
        this.prozentUngenuegend = prozentUngenuegend;
    }
}