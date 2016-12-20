package presentation.WorkerWindow;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class runModifyRoomCondition extends Application{
	private BorderPane borderPane;
	private Stage primarystage;
	
	public runModifyRoomCondition(){
		
	}
	
	
	
	public void setlayout(){
		try{
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(runModifyRoomCondition.class.getResource("modifyroomstate.fxml"));
			AnchorPane modifyroomstate=(AnchorPane)loader.load();
			borderPane.setCenter(modifyroomstate);
			
			//set controller
			modifyroomconditionController controller=loader.getController();
			controller.setRunmodifyroomcondition(this);
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
    public void setBorderPane() {
		try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(runModifyRoomCondition.class.getResource("modifyroomconditionBorder.fxml"));
            borderPane = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(borderPane);
            primarystage.setScene(scene);
            primarystage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}



	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		this.primarystage=primaryStage;
		this.primarystage.setTitle("修改房间状态");
		setBorderPane();
		setlayout();
		
	}

}
