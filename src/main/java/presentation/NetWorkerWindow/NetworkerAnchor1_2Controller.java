package presentation.NetWorkerWindow;

import java.util.ArrayList;

import businesslogic.userbl.networker.NetworkerController;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import vo.ClientVO;
import vo.NetworkerVO;
import vo.OrderVO;

public class NetworkerAnchor1_2Controller {
	@FXML
	TableView<ClientVO>ClientList;
	@FXML
	TableColumn<ClientVO,String> ClientColumn;
	@FXML
	TableColumn<ClientVO,Boolean>modifyColumn;
	
	
	
	@FXML
	Button viewClientBt;
	
	ArrayList<ClientVO> clientArray;
	
	RunNetworker runNetworker;
	NetworkerVO networkerVO;
	public NetworkerAnchor1_2Controller(){
		
	}
	
	
	
	public void ViewClientClicked(){
		
	}
	
	
	
	
	public void initialize(){
		//初始化1个tableview
		try{
		NetworkerController controller=new NetworkerController();
		clientArray=controller.getAllClientInfo();
		
		
		ObservableList<ClientVO> ClientData= FXCollections.observableArrayList();
		ClientData.addAll(clientArray);
		ClientList.setItems(ClientData);
		ClientColumn.setCellValueFactory(cellData->cellData.getValue().getUserId());
		
		
		modifyColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ClientVO, Boolean>, ObservableValue<Boolean>>() {
          @Override
          public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<ClientVO, Boolean> p) {
              return new SimpleBooleanProperty(p.getValue()!=null);
          }
      });

      modifyColumn.setCellFactory(new Callback<TableColumn<ClientVO, Boolean>, TableCell<ClientVO, Boolean>>() {
          @Override
          public TableCell<ClientVO, Boolean> call(TableColumn<ClientVO, Boolean> p) {
              return new ButtonCell1_2();
          }
      });
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void SetRunNetworker(RunNetworker runNetworker){
		this.runNetworker=runNetworker;
		networkerVO=runNetworker.GetNetWorkerVO();
		initialize();
		
	}
	

}
