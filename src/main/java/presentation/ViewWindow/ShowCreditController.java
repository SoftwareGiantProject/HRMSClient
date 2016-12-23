package presentation.ViewWindow;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.creditbl.CreditController;
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

public class ShowCreditController {
	@FXML
	TableView<CreditVO> historyList;
	@FXML
	TableColumn<CreditVO, Number> creditColumn;

	@FXML
	TableColumn<CreditVO,Number> changeColumn;
	@FXML
	TableColumn<CreditVO, String>timeColumn;
	
	
	
	ClientVO clientvo;
	RunView runView;
	
	
	
	
	
	//构造
	 public ShowCreditController() {
		
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
    
    public void SetRunView(RunView rv){
    	this.runView=rv;
    	clientvo=rv.GetClientVO();
    	initialize();
    	
    	try {
			CreditController controller=new CreditController();
			ArrayList<CreditVO> creditArray=controller.getAllCredit(clientvo.getUserId().get());
			ObservableList<CreditVO> creditData=FXCollections.observableArrayList();
			creditData.addAll(creditArray);
			historyList.setItems(creditData);
			
			creditColumn.setCellValueFactory(cellData->cellData.getValue().getCredit());
			changeColumn.setCellValueFactory(cellData->cellData.getValue().getChange());
			timeColumn.setCellValueFactory(cellData->cellData.getValue().getTime());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
    	
    }

}
