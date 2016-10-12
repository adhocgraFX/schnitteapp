import java.time.LocalDate;

/**
 * die Klasse Kurs repräsentiert die für das Schnitte-Programm
 * notwendigen Attribute des Kurses
 * Created by Hock on 02.10.2016.
 */
public class Kurs {
    // Instanzvariablen
    /**
     * enthält den Kursnamen
     */
    Kurse kursName;
    /**
     * enthält das Semester
     */
    Semester semester;
    /**
     * enthält das Datum
     */
    LocalDate datum;

    /**
     * Konstruktor für Objekte der Klasse Kurs
     */
    public Kurs(Kurse kursName, Semester semester, LocalDate datum) {
        // Instanzvariable initialisieren
        this.kursName = kursName;
        this.semester = semester;
        this.datum = datum;
    }

    // Methoden

    /**
     * Gibt den Kursnamen dieses Kurses zurück
     */
    public Kurse getKursName() {
        return kursName;
    }

    /**
     * Verändert den Kursnamen dieses Kurses
     * @param kursName
     */
    public void setKursName(Kurse kursName) {
        this.kursName = kursName;
    }

    /**
     * Gibt das Semester dieses Kurses zurück
     */
    public Semester getSemester() {
        return semester;
    }

    /**
     * Verändert das Semester dieses Kurses
     */
    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    /**
     * Gibt das Datum dieses Kurses/der Arbeit zurück
     */
    public LocalDate getDatum() {
        return datum;
    }

    /**
     * Verändert das Datum dieses Kurses/der Arbeit
     */
    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }
}
