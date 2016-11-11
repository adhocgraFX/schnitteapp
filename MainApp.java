import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * Created by Hock on 06.10.2016.
 */

public class MainApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("SchnitteApp");

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainApp.fxml"));
            BorderPane page = loader.load();
            Scene scene = new Scene(page, 500, 440);
            scene.getStylesheets().add("styles.css");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.getIcons().add(new Image("drawable/cut.png"));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}