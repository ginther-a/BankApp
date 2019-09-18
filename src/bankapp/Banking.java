package bankapp;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * @author Rich Smith at ZenOfProgramming.com
 */
public class Banking extends Application
{
   CustomerList x;
   Customer createCustomer;
   Scene scene1, scene2, scene3, logScene, sceneCreate;
   Stage window;
   Customer currentCustomer;
   Button submit = new Button("Submit");
   Button find = new Button("Find");
   Button editer = new Button("Edit Name");
   Button editer2 = new Button("Edit Address");
   Button addNam = new Button("Add Name");
   Button setPass = new Button("Set Password");
   Button addAddress = new Button("Create Account");
   ComboBox comboBox;
   ComboBox comboBox2;
   TextField dep, newName, newName2, address, postal, city, firstNam, lastNam, pass, address1, city1, province1, postal1;
   String cusCheq;
   String cusSav;
   String cusFirstName;
   String cusLastName;
   Label che;
   Label sav;
   Label firstName;
   Label lastName;
   String cusAd;
   Label ad;
   String cusCit;
   Label cit;
   String cusPost;
   Label post;
   String cusBranch;
   Label branch;
   Label name3;
   String cusBranchAddress;
   String newFirstName;
   String newLastName;
   String newPassword;
   String newAddress, newCity, newProvince, newPostal;




   @Override
   public void start (Stage primaryStage) throws FileNotFoundException
   {
      x = new CustomerList();
      //////////////////////////////Login Scene////////////////////////////////////////////

      window = primaryStage;

      window.setTitle("Mobile Banking");

      primaryStage.setTitle("Mobile Banking");

      //set gridpane with padding of 10 on all sides and gap between items to 10
      GridPane logGrid = new GridPane();
      logGrid.setPadding(new Insets(10, 10, 10, 10));
      logGrid.setVgap(10);
      logGrid.setHgap(10);

      //set image at center of logGrid
      ImageView imageBank = new ImageView(new Image(Banking.class.getResourceAsStream("bank.png")));
      imageBank.setFitHeight(200);
      imageBank.setFitWidth(280);
      logGrid.add(imageBank, 0, 1);
      logGrid.setAlignment(Pos.CENTER);

      logScene = new Scene(logGrid, 300, 450);
      primaryStage.setScene(logScene);

      //set position of title to center
      VBox title = new VBox();
      Label label = new Label("Simply Financial");
      title.setAlignment(Pos.CENTER);
      label.setStyle("-fx-font-size:30; -fx-font-weight:bold; -fx-font-smoothing-type:lcd;");
      GridPane.setConstraints(label, 0, 0);
      title.getChildren().add(label);
      logGrid.getChildren().add(title);

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
      logGrid.getChildren().add(user);

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
      logGrid.getChildren().add(pass);

      //login button
      VBox login = new VBox();
      Button but = new Button("SIGN IN");
      but.setMaxWidth(280);
      but.setMaxHeight(280);
      login.getChildren().add(but);
      GridPane.setConstraints(login, 0, 4);
      logGrid.getChildren().add(login);
      but.setOnAction(e -> window.setScene(scene1));

      VBox create = new VBox();
      Button but2 = new Button("NEW CUSTOMER");
      but2.setMaxWidth(280);
      but2.setMaxHeight(280);
      create.getChildren().add(but2);
      GridPane.setConstraints(create, 0, 6);
      logGrid.getChildren().add(create);
      but.setOnAction(e -> window.setScene(sceneCreate));

      but.setOnAction(new EventHandler<ActionEvent>()
      {
         @Override
         public void handle (ActionEvent e)
         {
            //   try {
            System.out.println(user.getText() + pass.getText());
            currentCustomer = x.findCustomer(user.getText(), pass.getText());
            if (currentCustomer == null) {

               System.out.println("Customer not found.");
            }
            else {
               Scene scene1 = InfoPage(currentCustomer);
               primaryStage.setScene(scene1);
            }
//            }
//            catch (Exception ex) {
//               System.out.println(ex.getMessage());
//            }
         }
      }
      );



      but2.setOnAction(new EventHandler<ActionEvent>()
      {
         @Override
         public void handle (ActionEvent e)
         {
            sceneCreate = CreatePage();
            primaryStage.setScene(sceneCreate);
         }
      }
      );




      //////////////////////////////Scene 3////////////////////////////////////////////
      //define padding and space between items for gridpane
      GridPane grid3 = new GridPane();
      grid3.setPadding(new Insets(10, 10, 10, 10));
      grid3.setVgap(10);
      grid3.setHgap(10);

      scene3 = new Scene(grid3, 300, 400);

      //horizontal box to store custom image buttons
      HBox nav3 = new HBox();
      nav3.setPadding(new Insets(10, 10, 10, 10));
      nav3.setSpacing(10);
      nav3.setPrefWidth(280);
      nav3.setMaxWidth(280);
      GridPane.setConstraints(nav3, 0, 0);
      nav3.setStyle("");
      nav3.setAlignment(Pos.CENTER);

      //add image 1 balance to horizontal box nav3
      ImageButton image7 = new ImageButton("balance.png");
      image7.setOnAction(e -> window.setScene(scene1));
      nav3.getChildren().add(image7);


      //add image 2 city to horizontal box nav3
      ImageButton image8 = new ImageButton("address.png");
      nav3.getChildren().add(image8);
      image8.setOnAction(e -> window.setScene(scene2));

      //add image 3 branch3 to horizontal box nav3
      ImageButton image9 = new ImageButton("search.png");
      nav3.getChildren().add(image9);

      //add vbox credit 3 images to grid3
      grid3.getChildren().add(nav3);

      //hbox container
      HBox container3 = new HBox();
      container3.setPadding(new Insets(10, 10, 10, 10));
      container3.setSpacing(10);
      container3.maxWidth(280);
      GridPane.setConstraints(container3, 0, 1);
      container3.setStyle("");

      //left Vbox
      VBox cont5 = new VBox();
      cont5.setPadding(new Insets(10, 10, 10, 10));
      cont5.setSpacing(7);
      cont5.setPrefWidth(130);
      cont5.maxWidth(130);
      cont5.setStyle("");

      //Title for left vbox
      VBox aTitle3 = new VBox();
      Label account3 = new Label("Branch Information");
      aTitle3.setStyle("-fx-font-size:11; -fx-font-weight:bold; -fx-font-smoothing-type:lcd;");
      aTitle3.getChildren().add(account3);
      cont5.getChildren().add(aTitle3);

      //Left VBox Perameters

      cusBranchAddress = "Branch Address: \n Please Search";
      name3 = new Label(cusBranchAddress);
      name3.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
      cont5.getChildren().add(name3);

      Label userN3 = new Label("");
      userN3.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
      cont5.getChildren().add(userN3);

//      Label a2 = new Label("Address:");
//      a2.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
//      cont5.getChildren().add(a2);
//
//      Label ad3 = new Label("");
//      ad3.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
//      cont5.getChildren().add(ad3);
//
//      Label cit3 = new Label("City:");
//      cit3.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
//      cont5.getChildren().add(cit3);
//
//      Label cit4 = new Label("");
//      cit4.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
//      cont5.getChildren().add(cit4);
//
//      Label post3 = new Label("Postal Code:");
//      post3.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
//      cont5.getChildren().add(post3);
//
//      Label post4 = new Label("");
//      post4.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
//      cont5.getChildren().add(post4);
//
//      Label branch3 = new Label("Branch ID:");
//      branch3.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
//      cont5.getChildren().add(branch3);
//
//      Label branch4 = new Label("");
//      branch4.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
//      cont5.getChildren().add(branch4);

      //right vbox
      VBox cont6 = new VBox();
      cont6.setPadding(new Insets(10, 10, 10, 10));
      cont6.setSpacing(10);
      cont6.setPrefWidth(130);
      cont6.maxWidth(130);
      cont6.setStyle("");

      //right vbox title
      VBox search = new VBox();
      search.setAlignment(Pos.CENTER);
      Label search2 = new Label("Search Branch");
      search2.setStyle("-fx-font-size:11; -fx-font-weight:bold; -fx-font-smoothing-type:lcd;");
      search.getChildren().add(search2);
      cont6.getChildren().add(search);

      //right vbox perameters
      ObservableList<String> options3
              = FXCollections.observableArrayList(
                      "Branch 1",
                      "Branch 2",
                      "Branch 3",
                      "Branch 4"
              );

      final ComboBox comboBox3 = new ComboBox(options3);
      comboBox3.setPrefWidth(110);
      comboBox3.setMaxWidth(110);
      comboBox3.setPromptText("Branch");
      cont6.getChildren().add(comboBox3);

      //      find = new Button("Find");
      find.setPrefWidth(110);
      find.setMaxWidth(110);
      cont6.getChildren().add(find);

      container3.getChildren().addAll(cont5, cont6);
      grid3.getChildren().add(container3);

      window.setScene(logScene);
      window.show();

      editer.setOnAction(new EventHandler<ActionEvent>()
      {
         @Override
         public void handle (ActionEvent e)
         {
            String cusFirst = newName.getText();
            String cusLast = newName2.getText();
            if (cusFirst.equals("") && !cusLast.equals("")) {
               currentCustomer.setLastName(cusLast);
            }
            else if (!cusFirst.equals("") && cusLast.equals("")) {
               currentCustomer.setFirstName(cusFirst);
            }
            else if (!cusFirst.equals("") && !cusLast.equals("")) {
               currentCustomer.setFirstName(cusFirst);
               currentCustomer.setLastName(cusLast);
            }
            cusLastName = "Last Name: \n" + currentCustomer.getLastName();
            lastName.setText(cusLastName);
            cusFirstName = "First Name: \n" + currentCustomer.getFirstName();
            firstName.setText(cusFirstName);
            try {
               x.writeToFile();
            }
            catch (IOException ex) {
               Logger.getLogger(Banking.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
      });


      editer2.setOnAction(new EventHandler<ActionEvent>()
      {
         @Override
         public void handle (ActionEvent e)
         {
            String cusAddress = address.getText();
            String cusCity = city.getText();
            String cusPostal = postal.getText();
            if (!cusAddress.equals("")) {
               currentCustomer.setStreetAddress(cusAddress);
            }
            if (!cusCity.equals("")) {
               currentCustomer.setCity(cusCity);
            }
            if (!cusPostal.equals("")) {
               currentCustomer.setPostalCode(cusPostal);
            }
            cusAd = "Address: \n" + currentCustomer.getStreetAddress();
            ad.setText(cusAd);
            cusCit = "City: \n" + currentCustomer.getCity();
            cit.setText(cusCit);
            cusPost = "Postal Code: \n" + currentCustomer.getPostalCode();
            post.setText(cusPost);
            try {
               x.writeToFile();
            }
            catch (IOException ex) {
               Logger.getLogger(Banking.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
      });


      submit.setOnAction(new EventHandler<ActionEvent>()
      {
         @Override
         public void handle (ActionEvent e)
         {
            String account = comboBox.getValue().toString();
            String type = comboBox2.getValue().toString();
            double amount = Double.parseDouble(dep.getText());
            if (account.equals("Chequing")) {
               if (type.equals("Deposit")) {
                  currentCustomer.getChequing().deposit(amount);
               }
               else {
                  currentCustomer.getChequing().withdraw(amount);
               }
               cusCheq = "Chequing: \n $" + currentCustomer.getChequing().getBalance();
               che.setText(cusCheq);
               try {
                  x.writeToFile();
               }
               catch (IOException ex) {
                  Logger.getLogger(Banking.class.getName()).log(Level.SEVERE, null, ex);
               }

            }
            else {
               if (type.equals("Deposit")) {
                  currentCustomer.getSavings().deposit(amount);
               }
               else {
                  currentCustomer.getSavings().withdraw(amount);
               }
               cusSav = "Savings: \n $" + currentCustomer.getSavings().getBalance();
               sav.setText(cusSav);
               try {
                  x.writeToFile();
               }
               catch (IOException ex) {
                  Logger.getLogger(Banking.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
         }
      }
      );

      find.setOnAction(new EventHandler<ActionEvent>()
      {
         @Override
         public void handle (ActionEvent e)
         {
            String branchNum = comboBox3.getValue().toString();
            if (branchNum.equals("Branch 1")) {
               currentCustomer.getBranchAddress(1);

               cusBranchAddress = "Branch Address: \n " + currentCustomer.getBranchAddress(1);
               name3.setText(cusBranchAddress);

            }
            else if (branchNum.equals("Branch 2")) {
               currentCustomer.getBranchAddress(2);

               cusBranchAddress = "Branch Address: \n " + currentCustomer.getBranchAddress(2);
               name3.setText(cusBranchAddress);
            }
            else if (branchNum.equals("Branch 3")) {
               currentCustomer.getBranchAddress(3);

               cusBranchAddress = "Branch Address: \n " + currentCustomer.getBranchAddress(3);
               name3.setText(cusBranchAddress);
            }
            else if (branchNum.equals("Branch 4")) {
               currentCustomer.getBranchAddress(4);

               cusBranchAddress = "Branch Address: \n " + currentCustomer.getBranchAddress(4);
               name3.setText(cusBranchAddress);
            }
         }
      }
      );
   }

   public static void main (String[] args) throws FileNotFoundException
   {
      launch(args);
   }


   public Scene InfoPage (Customer currentCustomer)
   {
      //////////////////////////////Scene 1////////////////////////////////////////////

      //define padding and space between items for gridpane
      GridPane grid = new GridPane();
      grid.setPadding(new Insets(10, 10, 10, 10));
      grid.setVgap(10);
      grid.setHgap(10);

      scene1 = new Scene(grid, 300, 400);

      //horizontal box to store custom image buttons
      HBox nav = new HBox();
      nav.setPadding(new Insets(10, 10, 10, 10));
      nav.setSpacing(10);
      nav.setPrefWidth(280);
      nav.setMaxWidth(280);
      GridPane.setConstraints(nav, 0, 0);
      nav.setStyle("");
      nav.setAlignment(Pos.CENTER);

      //add image 1 balance to horizontal box nav3
      ImageButton image1 = new ImageButton("balance.png");
      nav.getChildren().add(image1);

      //add image 2 city to horizontal box nav3
      ImageButton image2 = new ImageButton("address.png");
      nav.getChildren().add(image2);
      Scene scene2TRY2 = EditPage();
//      image2.setOnAction(e -> window.setScene(scene2));
      image2.setOnAction(e -> window.setScene(scene2TRY2));


      //add image 3 branch3 to horizontal box nav3
      ImageButton image3 = new ImageButton("search.png");
      nav.getChildren().add(image3);
      image3.setOnAction(e -> window.setScene(scene3));

      //add vbox credit 3 images to grid3
      grid.getChildren().add(nav);


      //Hbox that will have 2 vboxes for fields side by side
      HBox container = new HBox();
      container.setPadding(new Insets(10, 10, 10, 10));
      container.setSpacing(15);
      container.maxWidth(280);
      GridPane.setConstraints(container, 0, 1);
      container.setStyle("");

      //first Vbox
      VBox cont1 = new VBox();
      cont1.setPadding(new Insets(10, 10, 10, 10));
      cont1.setSpacing(5);
      cont1.setPrefWidth(130);
      cont1.maxWidth(130);
      cont1.setStyle("");

      //Left VBox Title
      VBox aTitle = new VBox();
      aTitle.setAlignment(Pos.CENTER);
      Label account = new Label("Account Information");
      aTitle.setStyle("-fx-font-size:11; -fx-font-weight:bold; -fx-font-smoothing-type:lcd;");
      aTitle.getChildren().add(account);
      cont1.getChildren().add(aTitle);

      //Left VBox Perameters
      String cusName = "Name: \n" + currentCustomer.getFirstName() + " " + currentCustomer.getLastName();
      Label name = new Label(cusName);
      name.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
      cont1.getChildren().add(name);

//      Label userN = new Label("");
//      userN.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
//      cont1.getChildren().add(userN);

      cusCheq = "Chequing: \n $" + currentCustomer.getChequing().getBalance();
      che = new Label(cusCheq);
      che.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
      cont1.getChildren().add(che);

      Label cheq = new Label("");
      cheq.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
      cont1.getChildren().add(cheq);

      cusSav = "Savings: \n $" + currentCustomer.getSavings().getBalance();
      sav = new Label(cusSav);
      sav.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
      cont1.getChildren().add(sav);

      Label savi = new Label("");
      savi.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
      cont1.getChildren().add(savi);

      Label cred = new Label("Credit:");
      cred.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
      cont1.getChildren().add(cred);

      Label credits = new Label("");
      credits.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
      cont1.getChildren().add(credits);

      //second Vbox
      VBox cont2 = new VBox();
      cont2.setPadding(new Insets(10, 10, 10, 10));
      cont2.setSpacing(10);
      cont2.maxWidth(130);
      cont2.setPrefWidth(130);
      cont2.setStyle("");

      //right VBox perameters
      VBox edit = new VBox();
      edit.setAlignment(Pos.CENTER);
      Label editInfo = new Label("Edit Information");
      edit.setStyle("-fx-font-size:11; -fx-font-weight:bold; -fx-font-smoothing-type:lcd;");
      edit.getChildren().add(editInfo);
      cont2.getChildren().add(edit);

      ObservableList<String> options
              = FXCollections.observableArrayList(
                      "Chequing",
                      "Savings"
              );
      comboBox = new ComboBox(options);
      comboBox.setPrefWidth(110);
      comboBox.setMaxWidth(110);
      comboBox.getSelectionModel().selectFirst();
      cont2.getChildren().add(comboBox);

      ObservableList<String> options2
              = FXCollections.observableArrayList(
                      "Withdraw",
                      "Deposit"
              );

      comboBox2 = new ComboBox(options2);
      comboBox2.setPrefWidth(110);
      comboBox2.setMaxWidth(110);
      comboBox2.getSelectionModel().selectFirst();
      cont2.getChildren().add(comboBox2);

      dep = new TextField();
      dep.setAlignment(Pos.CENTER);
      dep.setPromptText("Amount");
      dep.setFocusTraversable(false);
      dep.getText();
      cont2.getChildren().add(dep);

//      submit = new Button("Submit");
      submit.setPrefWidth(110);
      submit.setMaxWidth(110);
      cont2.getChildren().add(submit);

      final TextField credit = new TextField();
      credit.setAlignment(Pos.CENTER);
      credit.setFocusTraversable(false);
      credit.setPromptText("Amount");
      credit.getText();
      cont2.getChildren().add(credit);

      Button payCred = new Button("Pay Credit");
      payCred.setPrefWidth(110);
      payCred.setMaxWidth(110);
      cont2.getChildren().add(payCred);

      //testing add vboxes to hbox then to gridpane
      container.getChildren().add(cont1);
      container.getChildren().add(cont2);
      grid.getChildren().add(container);



      return scene1;
   }

   public Scene EditPage ()
   {
      //////////////////////////////Scene 2////////////////////////////////////////////
      //define padding and space between items for gridpane
      GridPane grid2 = new GridPane();
      grid2.setPadding(new Insets(10, 10, 10, 10));
      grid2.setVgap(10);
      grid2.setHgap(10);

      scene2 = new Scene(grid2, 320, 420);

      //horizontal box to store custom image buttons
      HBox nav2 = new HBox();
      nav2.setPadding(new Insets(10, 10, 10, 10));
      nav2.setSpacing(10);
      nav2.setPrefWidth(280);
      nav2.setMaxWidth(280);
      GridPane.setConstraints(nav2, 0, 0);
      nav2.setStyle("");
      nav2.setAlignment(Pos.CENTER);

      //add image 1 balance to horizontal box nav3
      ImageButton image4 = new ImageButton("balance.png");
      image4.setOnAction(e -> window.setScene(scene1));
      nav2.getChildren().add(image4);


      //add image 2 city to horizontal box nav3
      ImageButton image5 = new ImageButton("address.png");
      nav2.getChildren().add(image5);

      //add image 3 branch3 to horizontal box nav3
      ImageButton image6 = new ImageButton("search.png");
      nav2.getChildren().add(image6);
      image6.setOnAction(e -> window.setScene(scene3));

      //add vbox credit 3 images to grid3
      grid2.getChildren().add(nav2);

      //Hbox that will have 2 vboxes for fields side by side
      HBox container2 = new HBox();
      container2.setPadding(new Insets(10, 10, 10, 10));
      container2.setSpacing(15);
      container2.maxWidth(280);
      GridPane.setConstraints(container2, 0, 1);
      container2.setStyle("");

      //first Vbox
      VBox cont3 = new VBox();
      cont3.setPadding(new Insets(10, 10, 10, 10));
      cont3.setSpacing(10);
      cont3.setPrefWidth(130);
      cont3.maxWidth(130);
      cont3.setStyle("");

      //Title for left vbox
      VBox aTitle2 = new VBox();
      aTitle2.setAlignment(Pos.CENTER);
      Label account2 = new Label("Address Information");
      aTitle2.setStyle("-fx-font-size:11; -fx-font-weight:bold; -fx-font-smoothing-type:lcd;");
      aTitle2.getChildren().add(account2);
      cont3.getChildren().add(aTitle2);

      //Left VBox Perameters
      cusFirstName = "First Name: \n" + currentCustomer.getFirstName();
      firstName = new Label(cusFirstName);
      firstName.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
      cont3.getChildren().add(firstName);

      cusLastName = "Last Name: \n" + currentCustomer.getLastName();
      lastName = new Label(cusLastName);
      lastName.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
      cont3.getChildren().add(lastName);

//      Label userN2 = new Label("");
//      userN2.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
//      cont3.getChildren().add(userN2);

      cusAd = "Address: \n" + currentCustomer.getStreetAddress();
      ad = new Label(cusAd);
      ad.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
      cont3.getChildren().add(ad);


//      Label ad2 = new Label("");
//      ad2.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
//      cont3.getChildren().add(ad2);

      cusCit = "City: \n" + currentCustomer.getCity();
      cit = new Label(cusCit);
      cit.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
      cont3.getChildren().add(cit);

//      Label cit2 = new Label("");
//      cit2.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
//      cont3.getChildren().add(cit2);

      cusPost = "Postal Code: \n" + currentCustomer.getPostalCode();
      post = new Label(cusPost);
      post.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
      cont3.getChildren().add(post);

//      Label post2 = new Label("");
//      post2.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
//      cont3.getChildren().add(post2);

      cusBranch = "Your Branch ID: " + currentCustomer.getBranchNum(currentCustomer.getCity());
      branch = new Label(cusBranch);
      branch.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
      cont3.getChildren().add(branch);

//      Label branch2 = new Label("");
//      branch2.setStyle("-fx-font-size:11; -fx-font-weight:bold;");
//      cont3.getChildren().add(branch2);

      //second Vbox
      VBox cont4 = new VBox();
      cont4.setPadding(new Insets(10, 10, 10, 10));
      cont4.setSpacing(10);
      cont4.setPrefWidth(130);
      cont4.maxWidth(130);
      cont4.setStyle("");

      //right vbox title
      VBox edit2 = new VBox();
      edit2.setAlignment(Pos.CENTER);
      Label editInfo2 = new Label("Edit Information");
      edit2.setStyle("-fx-font-size:11; -fx-font-weight:bold; -fx-font-smoothing-type:lcd;");
      edit2.getChildren().add(editInfo2);
      cont4.getChildren().add(edit2);

      //right vbox perameters
      newName = new TextField();
      newName.setPromptText("First Name");
      newName.setFocusTraversable(false);
      newName.setAlignment(Pos.CENTER);
      newName.getText();
      cont4.getChildren().add(newName);

      newName2 = new TextField();
      newName2.setPromptText("Last Name");
      newName2.setFocusTraversable(false);
      newName2.setAlignment(Pos.CENTER);
      newName2.getText();
      cont4.getChildren().add(newName2);

//      editer = new Button("Edit Name");
      editer.setPrefWidth(110);
      editer.setMaxWidth(110);
      cont4.getChildren().add(editer);

//      editer.setOnAction(new EventHandler<ActionEvent>()
//      {
//         @Override
//         public void handle (ActionEvent e)
//         {
//            String cusLast = lastName.getText();
//            while (cusLast != null) {
//               currentCustomer.setLastName(cusLast);
//            }
//            cusLastName = "Last Name: \n" + currentCustomer.getLastName();
//            lastName.setText(cusLast);
//         }
//      });

      address = new TextField();
      address.setPromptText("Address");
      address.setFocusTraversable(false);
      address.setAlignment(Pos.CENTER);
      address.getText();
      cont4.getChildren().add(address);


      city = new TextField();
      city.setPromptText("City");
      city.setFocusTraversable(false);
      city.setAlignment(Pos.CENTER);
      city.getText();
      cont4.getChildren().add(city);

      postal = new TextField();
      postal.setPromptText("Postal Code");
      postal.setFocusTraversable(false);
      postal.setAlignment(Pos.CENTER);
      postal.getText();
      cont4.getChildren().add(postal);

//      Button editer2 = new Button("Edit Address");
      editer2.setPrefWidth(110);
      editer2.setMaxWidth(110);
      cont4.getChildren().add(editer2);

      container2.getChildren().addAll(cont3, cont4);
      grid2.getChildren().add(container2);

      return scene2;
   }

   public Scene CreatePage ()
   {
      //      //////////////////////////////Scene 2////////////////////////////////////////////
//      //define padding and space between items for gridpane
      GridPane grid4 = new GridPane();
      grid4.setPadding(new Insets(10, 10, 10, 10));
      grid4.setVgap(10);
      grid4.setHgap(10);
//
      sceneCreate = new Scene(grid4, 300, 460);

      //set position of title to center
      VBox title = new VBox();
      Label label = new Label("Simply Financial");
      title.setAlignment(Pos.CENTER);
      label.setStyle("-fx-font-size:30; -fx-font-weight:bold; -fx-font-smoothing-type:lcd;");
      GridPane.setConstraints(label, 0, 0);
      title.getChildren().add(label);
      grid4.getChildren().add(title);

      //Hbox that will have 1 vbox 
      HBox container2 = new HBox();
      container2.setPadding(new Insets(10, 10, 10, 10));
      container2.setSpacing(10);
      container2.maxWidth(280);
      GridPane.setConstraints(container2, 0, 1);
      container2.setStyle("");

      //Vbox
      VBox cont4 = new VBox();
      cont4.setPadding(new Insets(10, 10, 10, 10));
      cont4.setSpacing(10);
      cont4.setPrefWidth(160);
      cont4.maxWidth(160);
      cont4.setStyle("");

      //vbox title
      VBox edit2 = new VBox();
      edit2.setAlignment(Pos.CENTER);
      Label editInfo2 = new Label("Customer Information");
      edit2.setStyle("-fx-font-size:11; -fx-font-weight:bold; -fx-font-smoothing-type:lcd;");
      edit2.getChildren().add(editInfo2);
      cont4.getChildren().add(edit2);

      //vbox perameters
      firstNam = new TextField();
      firstNam.setPromptText("First Name");
      firstNam.setFocusTraversable(false);
      firstNam.setAlignment(Pos.CENTER);
      firstNam.getText();
      cont4.getChildren().add(firstNam);

      lastNam = new TextField();
      lastNam.setPromptText("Last Name");
      lastNam.setFocusTraversable(false);
      lastNam.setAlignment(Pos.CENTER);
      lastNam.getText();
      cont4.getChildren().add(lastNam);

      pass = new TextField();
      pass.setPromptText("Password");
      pass.setFocusTraversable(false);
      pass.setAlignment(Pos.CENTER);
      pass.getText();
      cont4.getChildren().add(pass);

      address1 = new TextField();
      address1.setPromptText("Address");
      address1.setFocusTraversable(false);
      address1.setAlignment(Pos.CENTER);
      address1.getText();
      cont4.getChildren().add(address1);

      city1 = new TextField();
      city1.setPromptText("City");
      city1.setFocusTraversable(false);
      city1.setAlignment(Pos.CENTER);
      city1.getText();
      cont4.getChildren().add(city1);

      province1 = new TextField();
      province1.setPromptText("Province");
      province1.setFocusTraversable(false);
      province1.setAlignment(Pos.CENTER);
      province1.getText();
      cont4.getChildren().add(province1);

      postal1 = new TextField();
      postal1.setPromptText("Postal Code");
      postal1.setFocusTraversable(false);
      postal1.setAlignment(Pos.CENTER);
      postal1.getText();
      cont4.getChildren().add(postal1);

//      Button addAddress = new Button("Add Address");
      addAddress.setPrefWidth(160);
      addAddress.setMaxWidth(160);
      cont4.getChildren().add(addAddress);

      container2.getChildren().addAll(cont4);
      grid4.getChildren().add(container2);


      addAddress.setOnAction(new EventHandler<ActionEvent>()
      {
         @Override
         public void handle (ActionEvent e)
         {
            newFirstName = firstNam.getText();
            newLastName = lastNam.getText();
            newPassword = pass.getText();
            newAddress = address1.getText();
            newCity = city1.getText();
            newProvince = province1.getText();
            newPostal = postal1.getText();
            createCustomer = new Customer(newFirstName, newLastName, newPassword, newAddress, newCity, newProvince, newPostal, true, 21, 0.00, 0.01, false, 120, 0.00, 0.05);
            System.out.println(createCustomer);
            x.getArr().add(createCustomer);
            try {
               x.writeToFile();
            }
            catch (IOException ex) {
               Logger.getLogger(Banking.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
      }
      );


//
//      try {
//         x.writeToFile();
//      }
//      catch (IOException ex) {
//         Logger.getLogger(Banking.class.getName()).log(Level.SEVERE, null, ex);
//      }

      return sceneCreate;
   }
}
