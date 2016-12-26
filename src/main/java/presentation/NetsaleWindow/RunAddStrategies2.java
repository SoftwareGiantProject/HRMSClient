package presentation.NetsaleWindow;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RunAddStrategies2 extends Application{
	private BorderPane borderPane;
	private Stage primarystage;
	
	public RunAddStrategies2(){
		
	}
	
	 public void setBorderPane() {
			try {
	            // Load root layout from fxml file.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(RunAddStrategies2.class.getResource("subBorder.fxml"));
	            borderPane = (BorderPane) loader.load();

	            // Show the scene containing the root layout.
	            Scene scene = new Scene(borderPane);
	            primarystage.setScene(scene);
	            primarystage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
	 
	 public void setlayout(){
			try{
				FXMLLoader loader=new FXMLLoader();
				loader.setLocation(RunAddStrategies2.class.getResource("addStrategies2.fxml"));
				AnchorPane modifyroomstate=(AnchorPane)loader.load();
				borderPane.setCenter(modifyroomstate);
				
				//set controller
				AddStrageties2Controller controller=loader.getController();
				controller.setRunAddStrategies2(this);
			}catch(IOException e){
				e.printStackTrace();
			}
			
		}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		this.primarystage=primaryStage;
		this.primarystage.setTitle("新增促销策略");
		setBorderPane();
		setlayout();
		
	}
	
	public Stage getPrimaryStage(){
		return primarystage;
	}


}

