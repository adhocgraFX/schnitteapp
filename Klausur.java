/**
 * Created by Hock on 02.10.2016.
 */

public class Klausur {
// Variablen zum Rechnen
    /**
     * enthält die Anzahl der Punkte-Werte
     */
    int[][] punkte = new int[16][2];
    /**
     * enthält die Anzahl der Noten-Werte
     */
    int[][] noten = new int[7][2];

    /**
     * Konstruktor für Objekte der Klasse Klausur
     */
    public Klausur(int[][] punkte, int[][] noten) {
        // Instanzvariable initialisieren
        for (int i = 15; i >= 0; i--) {
            this.punkte[i][0] = punkte[i][0];
            this.punkte[i][1] = punkte[i][1];
        }
        for (int i = 0; i < 6; i++) {
            this.noten[i][0] = noten[i][0];
            this.noten[i][1] = noten[i][1];
        }
    }

    /**
     * Konstruktor für Objekte der Klasse Klausur
     */
    public Klausur(int[][] noten) {
        // Instanzvariable initialisieren
        for (int i = 0; i < 6; i++) {
            this.noten[i][0] = noten[i][0];
            this.noten[i][1] = noten[i][1];
        }
    }

    // Methoden

    /**
     * Gibt die Noten dieser Klausur zurück
     */
    public int getNoten(int i) {
        return noten[i][1];
    }

    /**
     * Verändert die Noten dieser Klausur
     */
    public void setNoten(int i, int value) {
        noten[i][1] = value;
    }

    /**
     * Gibt die Punkte dieser Klausur zurück
     */
    public int getPunkte(int i) {
        return punkte[i][1];
    }

    /**
     * Verändert die Punkte dieser Klausur
     */
    public void setPunkte(int i, int value) {
        punkte[i][1] = value;
    }
}