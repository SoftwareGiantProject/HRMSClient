package presentation.ClientWindow;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import presentation.NetWorkerWindow.RunNetworker;
import util.MemberType;
import vo.ClientVO;
import vo.HotelVO;
import vo.OrderVO;


public class RunClient1 extends Application {

	private Stage primaryStage;
    private BorderPane rootLayout;
    private int anchor1=0;
    private static ClientVO cv=new ClientVO("0000", "0000", "0000",
				 "0000", 0, "0000", "0000",MemberType.NONE);
    private static OrderVO ov;
    private static HotelVO hv;
    
    
//    
//    FXMLLoader loader1;
//    FXMLLoader loader2;
//    FXMLLoader loader3;

//   public RunClient(String Anchor1){
//	   this.Anchor1=Anchor1;
//   }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public static void SetHotelVO(HotelVO hv){
    	RunClient1.hv=hv;
    }
    
    public static HotelVO GetHotelVO(){
    	return hv;
    }
    public static void SetOrderVO(OrderVO ov){
    	RunClient1.ov=ov;
    }
    
    public static OrderVO GetOrderVO (){
    	
    	return ov;
    }
    public static void SetClientVO(ClientVO cv){
    	RunClient1.cv=cv;
    }
    public static ClientVO GetClientVO(){
    	return cv;
    }
    @Override
    public void start(Stage primaryStage)throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("客户");

        initRootLayout();

        showClientAnchor();
        showClientAnchor1();

    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(RunClient1.class.getResource("ClientBorder.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showClientAnchor1(){
    	try{

    			switch(anchor1){
    			case 1:
    				FXMLLoader loader1=new FXMLLoader();
    	            loader1.setLocation(RunClient1.class.getResource("ClientAnchor1.1.fxml"));
    	            AnchorPane ClientAnchor1=(AnchorPane)loader1.load();
    	            rootLayout.setCenter(ClientAnchor1);
    	            ClientAnchor1_1Controller controller1=loader1.getController();
    	            controller1.setRunClient(this); 
    	            break;
    			case 2:
    				FXMLLoader loader2=new FXMLLoader();
    	            loader2.setLocation(RunClient1.class.getResource("ClientAnchor1.2.fxml"));
    	            AnchorPane ClientAnchor2=(AnchorPane)loader2.load();
    	            rootLayout.setCenter(ClientAnchor2);
    	            ClientAnchor1_2Controller controller2=loader2.getController();
    	            controller2.setRunClient(this); 
    	            break;
    			case 3:
    				FXMLLoader loader3=new FXMLLoader();
    	            loader3.setLocation(RunClient1.class.getResource("ClientAnchor1.3.fxml"));
    	            AnchorPane ClientAnchor3=(AnchorPane)loader3.load();
    	            rootLayout.setCenter(ClientAnchor3);
    	            ClientAnchor1_3Controller controller3=loader3.getController();
    	            controller3.setRunClient(this);
    	            break;
    	            
    			case 4:
    				FXMLLoader loader4=new FXMLLoader();
    	            loader4.setLocation(RunClient1.class.getResource("ClientAnchor1.4.fxml"));
    	            AnchorPane ClientAnchor4=(AnchorPane)loader4.load();
    	            rootLayout.setCenter(ClientAnchor4);
    	            ClientAnchor1_4Controller controller4=loader4.getController();
    	            controller4.setRunClient(this);
    	            break;
    			case 5:
    				FXMLLoader loader5=new FXMLLoader();
    	            loader5.setLocation(RunClient1.class.getResource("ClientAnchor1.5.fxml"));
    	            AnchorPane ClientAnchor5=(AnchorPane)loader5.load();
    	            rootLayout.setCenter(ClientAnchor5);
    	            ClientAnchor1_5Controller controller5=loader5.getController();
    	            controller5.SetRunClient(this); 
    	            break;
    			case 6:
    				FXMLLoader loader6=new FXMLLoader();
    	            loader6.setLocation(RunClient1.class.getResource("ClientAnchor1.6.fxml"));
    	            AnchorPane ClientAnchor6=(AnchorPane)loader6.load();
    	            rootLayout.setCenter(ClientAnchor6);
    	            ClientAnchor1_6Controller controller6=loader6.getController();
    	            controller6.setRunClient(this);
    	            
    	            break;
    			case 7:
    				FXMLLoader loader7=new FXMLLoader();
    	            loader7.setLocation(RunClient1.class.getResource("ClientAnchor1.7.fxml"));
    	            AnchorPane ClientAnchor7=(AnchorPane)loader7.load();
    	            rootLayout.setCenter(ClientAnchor7);
    	            ClientAnchor1_7Controller controller7=loader7.getController();
    	            controller7.SetRunClient(this); 
    	            break;
    			case 8:
    				FXMLLoader loader8=new FXMLLoader();
    	            loader8.setLocation(RunClient1.class.getResource("ClientAnchor1.8.fxml"));
    	            AnchorPane ClientAnchor8=(AnchorPane)loader8.load();
    	            rootLayout.setCenter(ClientAnchor8);
    	            ClientAnchor1_8Controller controller8=loader8.getController();
    	            controller8.SetRunClient(this); 
    	            break;
    			case 9:
    				FXMLLoader loader9=new FXMLLoader();
    	            loader9.setLocation(RunClient1.class.getResource("ClientAnchor1.9.fxml"));
    	            AnchorPane ClientAnchor9=(AnchorPane)loader9.load();
    	            rootLayout.setCenter(ClientAnchor9);
    	            ClientAnchor1_9Controller controller9=loader9.getController();
    	            controller9.SetRunClient(this); 
    	            break;
    			case 10:
    				FXMLLoader loader10=new FXMLLoader();
    	            loader10.setLocation(RunClient1.class.getResource("ClientAnchor1.10.fxml"));
    	            AnchorPane ClientAnchor10=(AnchorPane)loader10.load();
    	            rootLayout.setCenter(ClientAnchor10);
    	            ClientAnchor1_10Controller controller10=loader10.getController();
    	            controller10.setRunClient(this);
    	            break;
    	            
    			}
    			
    		
    		
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    }
    
    /**
     * Shows the LoginAnchor inside the root layout.
     */
    public void showClientAnchor() {
        try {
            // Load person overview.
//            FXMLLoader loader1 = new FXMLLoader();
//            loader1.setLocation(RunClient1.class.getResource("ClientAnchor1.1.fxml"));
//            AnchorPane ClientAnchor1 = (AnchorPane) loader1.load();
            FXMLLoader loader2=new FXMLLoader();
            loader2.setLocation(RunClient1.class.getResource("ClientAnchor2.fxml"));
            AnchorPane ClientAnchor2=(AnchorPane)loader2.load();
            FXMLLoader loader3=new FXMLLoader();
            loader3.setLocation(RunClient1.class.getResource("ClientAnchor3.fxml"));
            AnchorPane ClientAnchor3=(AnchorPane)loader3.load();

            // Set person overview into the center of root layout.
//            rootLayout.setCenter(ClientAnchor1);
            rootLayout.setLeft(ClientAnchor2);
            rootLayout.setBottom(ClientAnchor3);
            
            
            //set controller
            ClientAnchor2Controller controller2=loader2.getController();
            controller2.setRunClient(this);
            //other controllers
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void SetAnchor1(int anchor1){
    	try{
    		this.anchor1=anchor1;
    	
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    
}
