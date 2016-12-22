package presentation.ViewWindow;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import presentation.NetWorkerWindow.RunNetworker;
import vo.ClientVO;

public class RunView extends Application {
	private BorderPane border;
	private Stage primaryStage;
	public static int anchor1=0;
	
	ClientVO clientVO;
	
public static void setAnchor1(int anchor1) {
		RunView.anchor1 = anchor1;
	}
public void SetClientVO(ClientVO client){
	this.clientVO=client;
}
//底层容器
	public void setBorder(){
		try {
          // Load root layout from fxml file.
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(RunView.class.getResource("ViewBorder.fxml"));
          border = (BorderPane) loader.load();

          // Show the scene containing the root layout.
          Scene scene = new Scene(border);
          primaryStage.setScene(scene);
          primaryStage.show();
      } catch (IOException e) {
          e.printStackTrace();
      }
	}
	
	public void setAnchor(){
		try{
			switch(anchor1){
			case 1:
				FXMLLoader loader1=new FXMLLoader();
	            loader1.setLocation(RunView.class.getResource("ViewAnchorClient.fxml"));
	            AnchorPane ClientAnchor=(AnchorPane)loader1.load();
	            border.setCenter(ClientAnchor);
	            ViewClientController controller=loader1.getController();
	            controller.SetRunView(this);
	            break;
			case 2:
				
	            break;
			case 3:
				
	            break;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("网站管理人员");
		setBorder();
        
		setAnchor();
	}
	
	public Stage getPrimaryStage() {
        return primaryStage;
    }

	public static void main(String[] args) {
		launch(args);
	}
}
