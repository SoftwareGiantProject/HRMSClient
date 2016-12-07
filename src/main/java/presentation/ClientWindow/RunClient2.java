package presentation.ClientWindow;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class RunClient2 extends Application {

	private Stage primaryStage;
    private BorderPane rootLayout;
//    private String Anchor1;
    
    
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
    
    
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("客户");

        initRootLayout();

        showClientAnchor();
//        chooseAnchor1();
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
//    //点击 修改信息
//    public void modifyInfoClicked(){
//
//    	
//    }

    /**
     * Shows the LoginAnchor inside the root layout.
     */
    public void showClientAnchor() {
        try {
            // Load person overview.
            FXMLLoader loader1 = new FXMLLoader();
            loader1.setLocation(RunClient1.class.getResource("ClientAnchor1.2.fxml"));
            AnchorPane ClientAnchor1 = (AnchorPane) loader1.load();
            FXMLLoader loader2=new FXMLLoader();
            loader2.setLocation(RunClient1.class.getResource("ClientAnchor2.fxml"));
            AnchorPane ClientAnchor2=(AnchorPane)loader2.load();
            FXMLLoader loader3=new FXMLLoader();
            loader3.setLocation(RunClient1.class.getResource("ClientAnchor3.fxml"));
            AnchorPane ClientAnchor3=(AnchorPane)loader3.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(ClientAnchor1);
            rootLayout.setLeft(ClientAnchor2);
            rootLayout.setBottom(ClientAnchor3);
            
            
            //set controller
//            ClientAnchor1Controller controller1=loader1.getController();
//            controller1.setRunClient(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
//    public void chooseAnchor1(){
//    	try{
//    	FXMLLoader loader1=new FXMLLoader();
//        loader1.setLocation(RunClient.class.getResource(Anchor1));
//        AnchorPane ClientAnchor1=(AnchorPane)loader1.load();
//        rootLayout.setCenter(ClientAnchor1);
//    	}catch(Exception e){
//    		e.printStackTrace();
//    	}
//    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    
}