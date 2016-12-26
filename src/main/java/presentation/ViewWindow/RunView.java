package presentation.ViewWindow;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import presentation.NetsaleWindow.strategiesManagementController;
import presentation.NetWorkerWindow.RunNetworker;
import vo.ClientVO;
import vo.HotelVO;
import vo.NetsaleVO;
import vo.OrderVO;
import vo.PromotionVO;
import vo.WorkerVO;

public class RunView extends Application {
	private BorderPane border;
	private Stage primaryStage;
	public static int anchor1=0;
	
	public static OrderVO orderVO;
	public static PromotionVO promotionVO;
	public static ClientVO clientVO;
	public static NetsaleVO netsaleVO;
	public static WorkerVO workerVO;
	public static HotelVO hotelVO;
	
public static void setAnchor1(int anchor1) {
		RunView.anchor1 = anchor1;
	}
public static void SetClientVO(ClientVO client){
	RunView.clientVO=client;
//	System.out.println(RunView.clientVO.getUserId().get());
}

public static ClientVO GetClientVO(){
	return RunView.clientVO;
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
	            ViewClientController controller1=loader1.getController();
	            controller1.SetRunView(this);
	            break;
			case 2:
				FXMLLoader loader2=new FXMLLoader();
	            loader2.setLocation(RunView.class.getResource("ViewAnchorNetsale.fxml"));
	            AnchorPane NetsaleAnchor=(AnchorPane)loader2.load();
	            border.setCenter(NetsaleAnchor);
	            ViewNetsaleController controller2=loader2.getController();
	            controller2.SetRunView(this);
	            break;
	            
			case 3:
				FXMLLoader loader3=new FXMLLoader();
	            loader3.setLocation(RunView.class.getResource("ViewAnchorWorker.fxml"));
	            AnchorPane WorkerAnchor=(AnchorPane)loader3.load();
	            border.setCenter(WorkerAnchor);
	            ViewWorkerController controller3=loader3.getController();
	            controller3.SetRunView(this);
	            break;
			case 4:
				FXMLLoader loader4=new FXMLLoader();
	            loader4.setLocation(RunView.class.getResource("ModifyPasswordAnchor.fxml"));
	            AnchorPane modifyAnchor=(AnchorPane)loader4.load();
	            border.setCenter(modifyAnchor);
	            ModifyPasswordController controller4=loader4.getController();
	            controller4.SetRunView(this);
	            break;
			case 5:
				FXMLLoader loader5=new FXMLLoader();
	            loader5.setLocation(RunView.class.getResource("ShowCreditHistoryAnchor.fxml"));
	            AnchorPane creditAnchor=(AnchorPane)loader5.load();
	            border.setCenter(creditAnchor);
	            ShowCreditController controller5=loader5.getController();
	            controller5.SetRunView(this);
	            break;
			case 6:
				FXMLLoader loader6=new FXMLLoader();
	            loader6.setLocation(RunView.class.getResource("ModifyNetsale.fxml"));
	            AnchorPane modifyNetsaleAnchor=(AnchorPane)loader6.load();
	            border.setCenter(modifyNetsaleAnchor);
	            ModifyNetsaleController controller6=loader6.getController();
	            controller6.SetRunView(this);
	            break;
			case 7:
				FXMLLoader loader7=new FXMLLoader();
	            loader7.setLocation(RunView.class.getResource("ModifyWorker.fxml"));
	            AnchorPane modifyWorkerAnchor=(AnchorPane)loader7.load();
	            border.setCenter(modifyWorkerAnchor);
	            ModifyWorkerController controller7=loader7.getController();
	            controller7.SetRunView(this);
	            break;
			case 8:
				FXMLLoader loader8=new FXMLLoader();
	            loader8.setLocation(RunView.class.getResource("AddNetsale.fxml"));
	            AnchorPane addNetsaleAnchor=(AnchorPane)loader8.load();
	            border.setCenter(addNetsaleAnchor);
	            AddNetsaleController controller8=loader8.getController();
	            break;
//	            controller8.SetRunView(this);
			case 9:
				FXMLLoader loader9=new FXMLLoader();
	            loader9.setLocation(RunView.class.getResource("AddWorker.fxml"));
	            AnchorPane addWorkerAnchor=(AnchorPane)loader9.load();
	            border.setCenter(addWorkerAnchor);
	            AddWorkerController controller9=loader9.getController();
	            break;
			case 10:
				FXMLLoader loader10=new FXMLLoader();
	            loader10.setLocation(RunView.class.getResource("AddHotel.fxml"));
	            AnchorPane addHotelAnchor=(AnchorPane)loader10.load();
	            border.setCenter(addHotelAnchor);
	            AddHotelController controller10=loader10.getController();
	            break;
			case 11:
				FXMLLoader loader11=new FXMLLoader();
	            loader11.setLocation(RunView.class.getResource("ViewHistoryOrder.fxml"));
	            AnchorPane viewHistoryAnchor=(AnchorPane)loader11.load();
	            border.setCenter(viewHistoryAnchor);
	            ViewHistoryController controller11=loader11.getController();
//	            controller11.Set(this.hotelVO, this.clientVO);
	            controller11.SetRunView(this);
	            break;
			case 12:
				FXMLLoader loader12=new FXMLLoader();
	            loader12.setLocation(RunView.class.getResource("ViewPromotion.fxml"));
	            AnchorPane viewPromotionAnchor=(AnchorPane)loader12.load();
	            border.setCenter(viewPromotionAnchor);
	            AddHotelController controller12=loader12.getController();
	            controller12.SetRunView(this);
	            break;
	            
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle(" ");
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
