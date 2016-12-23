package presentation.WorkerWindow;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import vo.PromotionVO;
import vo.WorkerVO;


public class RunWorker extends Application{
	private Stage primaryStage;
    private BorderPane rootLayout;
    private int anchor1=0;
    private static WorkerVO workerVO;
    private static PromotionVO promotionVO;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
    @Override
    public void start(Stage primaryStage) {
    	try{
    		        this.primaryStage = primaryStage;
                    this.primaryStage.setTitle("酒店工作人员");

                    initRootLayout();

                    showTools();
                    showWorker();
    	}catch(Exception e){
    		e.printStackTrace();
    	}


    }
    
   
    
    public static void setWorkerVO(WorkerVO worker){
    	RunWorker.workerVO=worker;
    }
    
    public static WorkerVO getWorkerVO(){
    	return workerVO;
    }
    
    
    
    public static void setPromotionVO(PromotionVO vo){
    	RunWorker.promotionVO=vo;
    }
    
    public static PromotionVO getPromotionVO(){
    	return promotionVO;
    }
    

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(RunWorker.class.getResource("WorkerBorder.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showWorker(){
    	try{

    		switch (anchor1){
    		case 1:
    			FXMLLoader loader1=new FXMLLoader();
    	        loader1.setLocation(RunWorker.class.getResource("HotelInfoView.fxml"));
    	        AnchorPane HotelInfoView=(AnchorPane)loader1.load();
    	        rootLayout.setCenter(HotelInfoView);
    	        break;
    		case 2:
    			FXMLLoader loader2=new FXMLLoader();
    	        loader2.setLocation(RunWorker.class.getResource("addAvailbleRoom.fxml"));
    	        AnchorPane addAvailbleRoom=(AnchorPane)loader2.load();
    	        rootLayout.setCenter(addAvailbleRoom);
    	        break;
    		case 3:
    			FXMLLoader loader3=new FXMLLoader();
    	        loader3.setLocation(RunWorker.class.getResource("draftStrategies.fxml"));
    	        AnchorPane draftStrategies=(AnchorPane)loader3.load();
    	        rootLayout.setCenter(draftStrategies);
    	        break;
    		case 4:
    			FXMLLoader loader4=new FXMLLoader();
    	        loader4.setLocation(RunWorker.class.getResource("refreshRoom.fxml"));
    	        AnchorPane refreshRoom=(AnchorPane)loader4.load();
    	        rootLayout.setCenter(refreshRoom);
    	        break;
    		case 5:
    			FXMLLoader loader5=new FXMLLoader();
    	        loader5.setLocation(RunWorker.class.getResource("ScanOrders.fxml"));
    	        AnchorPane ScanOrder=(AnchorPane)loader5.load();
    	        rootLayout.setCenter(ScanOrder);
    	        break;
    		case 6:
    			FXMLLoader loader6=new FXMLLoader();
    	        loader6.setLocation(RunWorker.class.getResource("executeOrder.fxml"));
    	        AnchorPane executeOrder=(AnchorPane)loader6.load();
    	        rootLayout.setCenter(executeOrder);
    	        break;
    		}
    			
    		
    		
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    }
    
    /**
     * Shows the LoginAnchor inside the root layout.
     */
    public void showTools() {
        try {

            FXMLLoader loader2=new FXMLLoader();
            loader2.setLocation(RunWorker.class.getResource("WorkerMenu.fxml"));
            AnchorPane WorkerMenu=(AnchorPane)loader2.load();
            FXMLLoader loader3=new FXMLLoader();
            loader3.setLocation(RunWorker.class.getResource("State.fxml"));
            AnchorPane State=(AnchorPane)loader3.load();

            rootLayout.setLeft(WorkerMenu);
            rootLayout.setBottom(State);
            
            
            //set controller
            HotelInfoMenuController controller2=loader2.getController();
            controller2.setRunWorker(this);
            
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
