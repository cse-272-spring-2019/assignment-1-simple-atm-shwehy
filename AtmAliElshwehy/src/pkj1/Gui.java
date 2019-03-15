package pkj1;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;



public class Gui extends Application {

	MyAtm x = new MyAtm();
	public void start(Stage primaryStage) {
		
		Button b1 = new Button("WithDraw");
		b1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
		Button b2 = new Button("Deposit");
		Button b3 = new Button("Balance inquiry");
		Button b4 = new Button("Pervious");
		Button b5 = new Button("Next");
		Button b6 = new Button("Check");
		b2.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
		b3.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
		b4.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
		b5.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
		b6.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
		Label welcome = new Label("Welcome To The Bank ATM");
		welcome.setStyle("-fx-font: normal bold 20px 'serif';-fx-text-fill:brown");
		b1.setDisable(true);b2.setDisable(true);b3.setDisable(true);b4.setDisable(true);b5.setDisable(true);
		PasswordField f1 = new PasswordField();

		Label l1 = new Label("CreditCard Pass:");
		l1.setStyle("-fx-text-fill:darkcyan;-fx-font: normal bold 20px 'serif'");
		Label l3 = new Label("");
		l3.setStyle("-fx-font: bold italic 19px 'serif'");
		b6.setOnAction(e->{
			
			   String a = f1.getText();
			 
			if (x.Check(a)==1)
			{
				b1.setDisable(false);b2.setDisable(false);b3.setDisable(false);b4.setDisable(false);b5.setDisable(false);

				l3.setText("Successful");
			}
			else {
				l3.setText("Unsuccessful Try again");
				b1.setDisable(true);b2.setDisable(true);b3.setDisable(true);b4.setDisable(true);b5.setDisable(true);
			}
		});
		b1.setOnAction(e->{
			second(1,l3,primaryStage);
		});
		b2.setOnAction(e->{
			second(2,l3,primaryStage);
		});
		b3.setOnAction(e->{
			l3.setText(x.getCurrentBalance());
		});
		b5.setOnAction(e->{
			l3.setText(x.next());
		});
		b4.setOnAction(e->{
			l3.setText(x.prev());

		});
		
		HBox H1 = new HBox(20);
		welcome.setAlignment(Pos.CENTER);
		HBox H3 = new HBox(20);
		H1.getChildren().addAll(l1,f1,b6);
		H1.setAlignment(Pos.CENTER);
		H3.getChildren().addAll(b1,b2,b3,b4,b5);
		H3.setAlignment(Pos.CENTER);
		VBox v1 = new VBox(30);
		v1.getChildren().addAll(welcome,H1,l3,H3);
		v1.setAlignment(Pos.CENTER);
		v1.setStyle("-fx-background-color:beige;-fx-border-style: solid;-fx-border-width: 2;-fx-border-color: darkslateblue;");
		StackPane st = new StackPane();
		st.setMinSize(600, 50);
		st.getChildren().add(v1);
		Scene scene = new Scene(st);
		primaryStage.setTitle("My AtM");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public void second(int flag,Label l4,Stage primaryStage){
		primaryStage.close();
		Stage stage = new Stage();
		TextField f2 = new TextField();
		Button confirm = new Button("Confirm!!");
		
		f2.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
              
            	if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) 
                    f2.setText(oldValue);
                
            	
            
            }
        });
	
		Button close = new Button("Close:(");
		confirm.setStyle("-fx-font: 14 arial; -fx-base: #b6e7c9;");
		close.setStyle("-fx-font: 14 arial; -fx-base: #800000;-fx-text-fill:white;");
		close.setOnAction(e->{
			stage.close();
			primaryStage.show();
		});
		if (flag == 2){
			confirm.setOnAction(e->{
				String b =f2.getText();
				x.deposit(b);
				l4.setText("Your Transaction is sucessful and "+x.getCurrentBalance());
				stage.close();
				primaryStage.show();
			});
		}
		if (flag==1){
			confirm.setOnAction(e->{
				String b =f2.getText();
				x.withdraw(b);
				
				if(x.T.check==1){
					l4.setText("Your Transaction is sucessful and "+x.getCurrentBalance());
				}
				else if (x.T.check==-1){
					l4.setText("Your Transaction is Unsucessful and "+x.getCurrentBalance());
				}
				
					stage.close();
				primaryStage.show();
			});
		}
		Label lo = new Label("Enter The amount");
		Label la = new Label("The Transaction Department");
		la.setStyle("-fx-text-fill:brown;-fx-font: normal bold 18px 'serif'");
		lo.setStyle("-fx-text-fill:darkcyan;-fx-font: normal bold 20px 'serif'");
		HBox H2 = new HBox(30);
		HBox H4 = new HBox(30);
		H2.getChildren().addAll(lo,f2);
		H4.getChildren().addAll(confirm,close);
		VBox v2 = new VBox(30);
		v2.getChildren().addAll(la,H2,H4);
		v2.setAlignment(Pos.CENTER);
		H4.setAlignment(Pos.BOTTOM_CENTER);
		v2.setStyle("-fx-background-color:beige;-fx-border-style: solid;-fx-border-width: 2;-fx-border-color: navy;");
               
		StackPane st = new StackPane();
		st.getChildren().add(v2);
		st.setMinSize(500, 60);
		Scene scene = new Scene(st);
		stage.setScene(scene);
		stage.show();
		
	}
	public void Start(String[] args){
		Application.launch(args);
	}
	

}
