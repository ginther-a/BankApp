package bankapp;

import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginUI extends Application
{
   @Override // Override the start method in the Application class
   public void start (Stage primaryStage) throws FileNotFoundException
   {
      primaryStage.setTitle("Mobile Banking");

      //set gridpane with padding of 10 on all sides and gap between items to 10
      GridPane grid = new GridPane();
      grid.setPadding(new Insets(10, 10, 10, 10));
      grid.setVgap(10);
      grid.setHgap(10);

      //set image at center of grid
      ImageView imageBank = new ImageView(new Image(LoginUI.class.getResourceAsStream("bank.png")));
      imageBank.setFitHeight(200);
      imageBank.setFitWidth(280);
      grid.add(imageBank, 0, 1);
      grid.setAlignment(Pos.CENTER);

      Scene scene = new Scene(grid, 300, 400);
      primaryStage.setScene(scene);

      //set position of title to center
      VBox title = new VBox();
      Label label = new Label("Simply Financial");
      title.setAlignment(Pos.CENTER);
      label.setStyle("-fx-font-size:30; -fx-font-weight:bold; -fx-font-smoothing-type:lcd;");
      GridPane.setConstraints(label, 0, 0);
      title.getChildren().add(label);
      grid.getChildren().add(title);

      //textfield 1
      final TextField user = new TextField();
      user.setPromptText("Username");
      user.setAlignment(Pos.CENTER);
      user.setPrefWidth(280);
      user.setMaxWidth(280);
      user.setPrefColumnCount(30);
      user.setFocusTraversable(false);
      user.getText();
      GridPane.setConstraints(user, 0, 2);
      grid.getChildren().add(user);

      //textfield 2
      final TextField pass = new TextField();
      pass.setPromptText("Password");
      pass.setAlignment(Pos.CENTER);
      pass.setPrefWidth(280);
      pass.setMaxWidth(280);
      pass.setPrefColumnCount(30);
      pass.setFocusTraversable(false);
      pass.getText();
      GridPane.setConstraints(pass, 0, 3);
      grid.getChildren().add(pass);

      //login button
      VBox login = new VBox();
      Button but = new Button("SIGN IN");
      but.setMaxWidth(280);
      but.setMaxHeight(280);
      login.getChildren().add(but);
      GridPane.setConstraints(login, 0, 4);
      grid.getChildren().add(login);

      primaryStage.show();
   }

   /**
    * The main method is only needed for the IDE with limited
    * JavaFX support. Not needed for running from the command line.
    */
   public static void main (String[] args)
   {
      launch(args);
   }
}
