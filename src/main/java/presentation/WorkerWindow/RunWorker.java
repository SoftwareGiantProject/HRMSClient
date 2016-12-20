package presentation.WorkerWindow;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import util.ListType;
import vo.HotelVO;
import vo.OrderVO;
import vo.PromotionVO;
import vo.WorkerVO;


public class RunWorker extends Application{
	private Stage primaryStage;
    private BorderPane rootLayout;
    private int anchor1=0;
    private static WorkerVO workerVO;
    private static PromotionVO promotionVO;
    private static OrderVO orderVO=new OrderVO("111", "123456", "15151", "0.00", "0.50", "5.00", "5.41", "4.20", "88.00", "dac", 100, 5, true, ListType.CURRENTLIST, 100);
//    private static PromotionVO promotionVO=new PromotionVO("双十一", "所有人", 7.0, "20161512103");
    private static HotelVO hotelVO=new HotelVO("123", "gelinhaotai", "gagagag", "nanda", 4, 4, "good", "hotwater", "222", "nanjing");
    
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
    
//    public static String getHotelid(){
//    	return workerVO.getHotel_id();
//    }
    
    public static void setOrderVO(OrderVO vo){
    	RunWorker.orderVO=vo;
    }
    
    public static OrderVO getOrderVO(){
    	return orderVO;
    }
    
    public static void setPromotionVO(PromotionVO vo){
    	RunWorker.promotionVO=vo;
    }
    
    public static PromotionVO getPromotionVO(){
    	return promotionVO;
    }
    
    public static void setHotelVO(HotelVO vo){
    	RunWorker.hotelVO=vo;
    }
    
    public static HotelVO getHotelVO(){
    	return hotelVO;
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
            // Load person overview.

            FXMLLoader loader2=new FXMLLoader();
            loader2.setLocation(RunWorker.class.getResource("WorkerMenu.fxml"));
//            System.out.println("aaaa");
            AnchorPane WorkerMenu=(AnchorPane)loader2.load();
//            System.out.println("bbbb");
            FXMLLoader loader3=new FXMLLoader();
            loader3.setLocation(RunWorker.class.getResource("State.fxml"));
            AnchorPane State=(AnchorPane)loader3.load();

            // Set person overview into the center of root layout.
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
