import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class mainWindow {

    LoginGUI login =  new LoginGUI();

    private Label balanceLabel;
    private double balance = 1000.0;

    public void openNewWindow(Stage primaryStage) {
        // create labels and textfields
        Label titleLabel = new Label("Bank Account Information");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Label nameLabel = new Label("Name:");
        Label accountNumberLabel = new Label("Account Number:");
        Label accountTypeLabel = new Label("Account Type:");

        Label nameValueLabel = new Label("John Doe");
        Label accountNumberValueLabel = new Label("123456789");
        Label accountTypeValueLabel = new Label("Savings");

        balanceLabel = new Label("Balance: $" + balance);

        TextField depositAmountTextField = new TextField();
        TextField withdrawAmountTextField = new TextField();

        Button depositButton = new Button("Deposit");
        depositButton.setOnAction(event -> {
            double amount = Double.parseDouble(depositAmountTextField.getText());
            deposit(amount);
            textWindowOne(primaryStage);
        });

        Button withdrawButton = new Button("Withdraw");
        withdrawButton.setOnAction(event -> {
            double amount = Double.parseDouble(withdrawAmountTextField.getText());
            withdraw(amount);
            if (balance < amount) {
                textWindowThree(primaryStage);
            }
            
            if (balance > amount) {
                textWindowTwo(primaryStage);
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));
        gridPane.add(titleLabel, 0, 0, 2, 1);
        gridPane.add(nameLabel, 0, 1);
        gridPane.add(nameValueLabel, 1, 1);
        gridPane.add(accountNumberLabel, 0, 2);
        gridPane.add(accountNumberValueLabel, 1, 2);
        gridPane.add(accountTypeLabel, 0, 3);
        gridPane.add(accountTypeValueLabel, 1, 3);
        gridPane.add(balanceLabel, 0, 4, 2, 1);

        HBox depositHBox = new HBox(depositAmountTextField, depositButton);
        depositHBox.setSpacing(10);
        depositHBox.setAlignment(Pos.CENTER);

        HBox withdrawHBox = new HBox(withdrawAmountTextField, withdrawButton);
        withdrawHBox.setSpacing(10);
        withdrawHBox.setAlignment(Pos.CENTER);

        VBox vbox = new VBox(gridPane, depositHBox, withdrawHBox);
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Bank Account Program");
        primaryStage.show();
    }

    public void textWindowOne(Stage primaryStage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Window");
        alert.setHeaderText("Your balance is now " + balance + ".");
        alert.showAndWait();
    }

    public void textWindowTwo(Stage primaryStage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Window");
        alert.setHeaderText("Your balance is now " + balance + ".");
        alert.showAndWait();
    }

    public void textWindowThree(Stage primaryStage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Errow Window");
        alert.setHeaderText("You do not have sufficient funds!");
        alert.showAndWait();
    }



    private void deposit(double amount) {
        balance += amount;
        balanceLabel.setText("Balance: $" + balance);
    
    }

    private void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            balanceLabel.setText("Balance: $" + balance);
        } else {
            balanceLabel.setText("Insufficient Funds");
        }
    }




}
