


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	Button buttonHello;
	Button buttonHowdy;
	Button buttonChinese;
	Button buttonPortuguese;
	Button buttonClear;
	Button buttonExit;
	Label label1;
	TextField myfield;
	//  declare two HBoxes
	HBox hBox1;
	HBox hBox2;
	
	//student Task #4:
	//  declare an instance of DataManager
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		buttonHello = new Button("Hello");
		buttonHowdy = new Button("Howdy");
		buttonChinese= new Button("Chinese");
		buttonPortuguese= new Button("Portuguese");
		buttonClear = new Button("Clear");
		buttonExit = new Button("Exit");
		label1 = new Label("Feedback:");
		myfield = new TextField();
		
		
		//  instantiate the HBoxes
		hBox1 = new HBox();
		hBox2 = new HBox();
		//Scene scene = new Scene(hBox1);
		//student Task #4:
		//  instantiate the DataManager instance
		//DataManager myDM = new DataManager();
		buttonHello.setOnAction(new ButtonHandler());
		buttonHowdy.setOnAction(new ButtonHandler());
		buttonChinese.setOnAction(new ButtonHandler());
		buttonClear.setOnAction(new ButtonHandler());
		buttonExit.setOnAction(new ButtonHandler());
		buttonPortuguese.setOnAction(new ButtonHandler());
		//  set margins and set alignment of the components
		hBox2.setMargin(label1, new Insets(20,10,0,0)); 
		hBox2.setMargin(myfield , new Insets(20,10,0,0)); 
		hBox1.setMargin(buttonHello, new Insets(5,5,5,5)); 
		hBox1.setMargin(buttonHowdy, new Insets(5,5,5,5));
		hBox1.setMargin(buttonChinese, new Insets(5,5,5,5));
		hBox1.setMargin(buttonClear, new Insets(5,5,5,5));
		hBox1.setMargin(buttonExit, new Insets(5,5,5,5));
		hBox1.setMargin(buttonPortuguese, new Insets(5,5,5,5));
		hBox1.setAlignment(Pos.CENTER); 
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		 hBox1.getChildren().addAll(label1, myfield);
		//  add the buttons to the other HBox
		 hBox2.getChildren().addAll(buttonHello, buttonHowdy, buttonChinese, buttonPortuguese, buttonClear, buttonExit);
		//  add the HBoxes to this FXMainPanel (a VBox) 
		 getChildren().addAll(hBox1, hBox2);
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	public class ButtonHandler implements EventHandler<ActionEvent>
	{
		
		public void handle(ActionEvent event) {
			DataManager myDM = new DataManager();
			
			//i
			if((event.getTarget())==buttonHello) {
				myfield.setText(myDM.getHello());
			}
			else if((event.getTarget())==buttonHowdy) {
				myfield.setText(myDM.getHowdy());
			}
			else if((event.getTarget())==buttonChinese) {
				myfield.setText(myDM.getChinese());
			}
			else if((event.getTarget())==buttonPortuguese) {
				myfield.setText(myDM.getPortuguese());
			}
			
			//ii
			else if((event.getTarget())==buttonClear) {
				myfield.setText("");
			}
			
			//iii
			else if((event.getTarget())==buttonExit) {
				Platform.exit();
				System.exit(0); 
			}
			
			
		}
	}
}
	
