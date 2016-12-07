package presentation.NetWorkerWindow;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class RunNetworker extends Application {
	
	private BorderPane border;
	private Stage primaryStage;
	public static int anchor1=0;

	@Override
	public void start(Stage primaryStage)throws Exception {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("网站管理人员");
		setBorder();
        setAnchor1();
		setAnchor();
		
	}
	
	
	
	public RunNetworker(){
		
	}

    public void setanchor1(int anchor1){
    	this.anchor1=anchor1;
    }
	
	
	//底层容器
	public void setBorder(){
		try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(RunNetworker.class.getResource("NetworkerBorder.fxml"));
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
		try {
            // Load person overview.
//			FXMLLoader loader1=new FXMLLoader();
//          loader1.setLocation(RunNetworker.class.getResource("NetworkerAnchor1.1.fxml"));
//          AnchorPane NetworkerAnchor1=(AnchorPane)loader1.load();
            FXMLLoader loader2=new FXMLLoader();
            loader2.setLocation(RunNetworker.class.getResource("NetworkerAnchor2.fxml"));
            AnchorPane NetworkerAnchor2=(AnchorPane)loader2.load();
            FXMLLoader loader3=new FXMLLoader();
            loader3.setLocation(RunNetworker.class.getResource("NetworkerAnchor3.fxml"));
            AnchorPane NetworkerAnchor3=(AnchorPane)loader3.load();

            // Set person overview into the center of root layout.
//            border.setCenter(NetworkerAnchor1);
            border.setLeft(NetworkerAnchor2);
            border.setBottom(NetworkerAnchor3);
            
            
            //set controller
            NetworkerAnchor2Controller controller2=loader2.getController();
            controller2.setRunNetworker(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void setAnchor1(){
		try{
//		if(anchor1==1){
//			FXMLLoader loader1=new FXMLLoader();
//            loader1.setLocation(RunNetworker.class.getResource("NetworkerAnchor1.1.fxml"));
//            AnchorPane NetworkerAnchor1=(AnchorPane)loader1.load();
//            border.setCenter(NetworkerAnchor1);
//		}else{
//			System.out.println("wrong");
//		}
			switch(anchor1){
			case 1:
				FXMLLoader loader1=new FXMLLoader();
	            loader1.setLocation(RunNetworker.class.getResource("NetworkerAnchor1.1.fxml"));
	            AnchorPane NetworkerAnchor1=(AnchorPane)loader1.load();
	            border.setCenter(NetworkerAnchor1);
	            break;
			case 2:
				FXMLLoader loader2=new FXMLLoader();
	            loader2.setLocation(RunNetworker.class.getResource("NetworkerAnchor1.2.fxml"));
	            AnchorPane NetworkerAnchor2=(AnchorPane)loader2.load();
	            border.setCenter(NetworkerAnchor2);
	            break;
			case 3:
				FXMLLoader loader3=new FXMLLoader();
	            loader3.setLocation(RunNetworker.class.getResource("NetworkerAnchor1.3.fxml"));
	            AnchorPane NetworkerAnchor3=(AnchorPane)loader3.load();
	            border.setCenter(NetworkerAnchor3);
	            break;
	            
			case 4:
				FXMLLoader loader4=new FXMLLoader();
	            loader4.setLocation(RunNetworker.class.getResource("NetworkerAnchor1.4.fxml"));
	            AnchorPane NetworkerAnchor4=(AnchorPane)loader4.load();
	            border.setCenter(NetworkerAnchor4);
	            break;
			case 5:
				FXMLLoader loader5=new FXMLLoader();
	            loader5.setLocation(RunNetworker.class.getResource("NetworkerAnchor1.5.fxml"));
	            AnchorPane NetworkerAnchor5=(AnchorPane)loader5.load();
	            border.setCenter(NetworkerAnchor5);
	            break;
			case 6:
				FXMLLoader loader6=new FXMLLoader();
	            loader6.setLocation(RunNetworker.class.getResource("NetworkerAnchor1.6.fxml"));
	            AnchorPane NetworkerAnchor6=(AnchorPane)loader6.load();
	            border.setCenter(NetworkerAnchor6);
	            break;
	            
			}
			
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Stage getPrimaryStage() {
        return primaryStage;
    }

	public static void main(String[] args) {
		launch(args);
	}
}
