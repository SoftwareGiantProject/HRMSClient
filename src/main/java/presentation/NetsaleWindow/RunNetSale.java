package presentation.NetsaleWindow;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import vo.OrderVO;


public class RunNetSale extends Application{
	private BorderPane border;
	private Stage primaryStage;
	private int anchor1=0;
	
	OrderVO ordervo;

	@Override
	public void start(Stage primaryStage) {
		try{
			this.primaryStage = primaryStage;
            this.primaryStage.setTitle("网站营销人员");
		    setBorder();
            setTools();
		    setNetsale();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public void setOrderVO(OrderVO vo){
		ordervo=vo;
	}
	
	public OrderVO getOrderVO(){
		return ordervo;
	}
	
	
//	public RunNetSale(){
//		
//	}

    public void setanchor1(int anchor1){
    	this.anchor1=anchor1;
    }
	
	
	//底层容器
	public void setBorder(){
		try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(RunNetSale.class.getResource("NetsaleBorder.fxml"));
            border = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(border);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void setTools(){
		try {
            // Load person overview.
//			FXMLLoader loader1=new FXMLLoader();
//          loader1.setLocation(RunNetworker.class.getResource("NetworkerAnchor1.1.fxml"));
//          AnchorPane NetworkerAnchor1=(AnchorPane)loader1.load();
            FXMLLoader loader2=new FXMLLoader();
            loader2.setLocation(RunNetSale.class.getResource("NetSaleMenu.fxml"));
            AnchorPane NetSaleMenu=(AnchorPane)loader2.load();
            FXMLLoader loader3=new FXMLLoader();
            loader3.setLocation(RunNetSale.class.getResource("State.fxml"));
            AnchorPane State=(AnchorPane)loader3.load();

            // Set person overview into the center of root layout.
//            border.setCenter(NetworkerAnchor1);
            border.setLeft(NetSaleMenu);
            border.setBottom(State);
            
            
            //set controller
            NetSaleMenuController controller2=loader2.getController();
            controller2.setRunNetsale(this);;
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void setNetsale() throws IOException{
		switch (anchor1){
		case 1:
			FXMLLoader loader1=new FXMLLoader();
            loader1.setLocation(RunNetSale.class.getResource("strategiesManagement.fxml"));
            AnchorPane strategiesManagement=(AnchorPane)loader1.load();
            border.setCenter(strategiesManagement);
            break;
		case 2:
			FXMLLoader loader2=new FXMLLoader();
            loader2.setLocation(RunNetSale.class.getResource("uncommonOrders.fxml"));
            AnchorPane uncommonOrders=(AnchorPane)loader2.load();
            border.setCenter(uncommonOrders);
            break;
		case 3:
			FXMLLoader loader3=new FXMLLoader();
            loader3.setLocation(RunNetSale.class.getResource("addCredit.fxml"));
            AnchorPane addCredit=(AnchorPane)loader3.load();
            border.setCenter(addCredit);
            break;
		
		}
	}
	
	public Stage getPrimaryStage() {
        return primaryStage;
    }

	public static void main(String[] args) {
		launch(args);
	}



}
