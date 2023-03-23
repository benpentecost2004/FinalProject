import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckListExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        CheckBox checkingCheckBox = new CheckBox("Checking");
        CheckBox savingsCheckBox = new CheckBox("Savings");

        VBox root = new VBox(10, checkingCheckBox, savingsCheckBox);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root, 200, 150);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}



