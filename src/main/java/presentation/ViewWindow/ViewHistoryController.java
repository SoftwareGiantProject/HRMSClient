package presentation.ViewWindow;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.creditbl.CreditController;
import businesslogic.hotelbl.HotelController;
import businesslogic.orderbl.OrderController;
import businesslogic.userbl.client.ClientController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import presentation.ClientWindow.ClientAnchor1_2Controller;
import presentation.WarningWindow.RunWarning;
import util.ResultMessage;
import vo.ClientVO;
import vo.CreditVO;
import vo.HotelVO;
import vo.OrderVO;

public class ViewHistoryController {
	@FXML
	TableView<OrderVO> historyList;
	@FXML
	TableColumn<OrderVO,String> orderColumn;

	@FXML
	TableColumn<OrderVO,Number> typeColumn;
	@FXML
	TableColumn<OrderVO, String>timeColumn;
	
	
	
	public static ClientVO clientvo;
	public static HotelVO hotelVO;
	RunView runView;
	
	
	
	
	
	//构造
	 public ViewHistoryController() {
	}
	
	
		
		
		
	
	
	private void initialize() {
        // Initialize the person table with the two columns.
		
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
//    public void setClient1_2Controller(ClientAnchor1_2Controller client1_2) {
//        this.client1_2 = client1_2;
//        clientvo=client1_2.client;
//
//        // Add observable list data to the table
//        initialize();
//        
//    }
    public void Set(HotelVO hotelvo,ClientVO clientvo){
    	this.clientvo=clientvo;
    	this.hotelVO=hotelvo;
    }
	
    public void SetRunView(RunView rv){
    	this.runView=rv;
    	this.clientvo=rv.GetClientVO();
    	this.hotelVO=rv.hotelVO;
//    	System.out.println(clientvo.getUserId().get());
//    	System.out.println(hotelVO.getHotelId().get());
    	initialize();
    	
    	try {
			OrderController controller=new OrderController();
			ArrayList<OrderVO> OrderArray=controller.getExcutedOrderByHotelClient(hotelVO.getHotelId().get(), clientvo.getUserId().get());
			ObservableList<OrderVO> orderData=FXCollections.observableArrayList();
			orderData.addAll(OrderArray);
			historyList.setItems(orderData);
			
			orderColumn.setCellValueFactory(cellData->cellData.getValue().getOrder_id());
			typeColumn.setCellValueFactory(cellData->cellData.getValue().getOrderPrice());
			timeColumn.setCellValueFactory(cellData->cellData.getValue().getExecuteTime());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    }

}
