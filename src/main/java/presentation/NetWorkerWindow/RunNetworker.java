package presentation.NetWorkerWindow;

import java.io.IOException;
import java.nio.channels.NetworkChannel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import vo.NetworkerVO;



public class RunNetworker extends Application {
	
	private BorderPane border;
	private Stage primaryStage;
	public static int anchor1=0;
	public static NetworkerVO networkervo=new NetworkerVO("UserId","UserName",
				"Password","Contact");

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
	
	
    public static void SetNetworkerVO(NetworkerVO networkervo){
    	RunNetworker.networkervo=networkervo;
    }
    public static NetworkerVO GetNetWorkerVO(){
    	return RunNetworker.networkervo;
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
//			case 1:
//				FXMLLoader loader1=new FXMLLoader();
//	            loader1.setLocation(RunNetworker.class.getResource("NetworkerAnchor1.1.fxml"));
//	            AnchorPane NetworkerAnchor1=(AnchorPane)loader1.load();
//	            border.setCenter(NetworkerAnchor1);
//	            NetworkerAnchor1_1Controller controller1=loader1.getController();
//	            controller1.SetRunNetworker(this);
//	            break;
			case 2:
				FXMLLoader loader2=new FXMLLoader();
	            loader2.setLocation(RunNetworker.class.getResource("NetworkerAnchor1.2.fxml"));
	            AnchorPane NetworkerAnchor2=(AnchorPane)loader2.load();
	            border.setCenter(NetworkerAnchor2);
	            NetworkerAnchor1_2Controller controller2=loader2.getController();
	            controller2.SetRunNetworker(this);
	            break;
//			case 3:
//				FXMLLoader loader3=new FXMLLoader();
//	            loader3.setLocation(RunNetworker.class.getResource("NetworkerAnchor1.3.fxml"));
//	            AnchorPane NetworkerAnchor3=(AnchorPane)loader3.load();
//	            border.setCenter(NetworkerAnchor3);
//	            break;
//	            
			case 4:
				FXMLLoader loader4=new FXMLLoader();
	            loader4.setLocation(RunNetworker.class.getResource("NetworkerAnchor1.4.fxml"));
	            AnchorPane NetworkerAnchor4=(AnchorPane)loader4.load();
	            border.setCenter(NetworkerAnchor4);
	            NetworkerAnchor1_4Controller controller4=loader4.getController();
	            controller4.SetRunNetworker(this);
	            break;
			case 5:
				FXMLLoader loader5=new FXMLLoader();
	            loader5.setLocation(RunNetworker.class.getResource("NetworkerAnchor1.5.fxml"));
	            AnchorPane NetworkerAnchor5=(AnchorPane)loader5.load();
	            border.setCenter(NetworkerAnchor5);
	            NetworkerAnchor1_5Controller controller5=loader5.getController();
	            controller5.SetRunNetworker(this);
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
