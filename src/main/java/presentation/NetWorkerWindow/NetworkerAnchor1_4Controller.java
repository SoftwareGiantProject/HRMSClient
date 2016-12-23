package presentation.NetWorkerWindow;

import java.rmi.RemoteException;
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
import vo.NetsaleVO;
import vo.NetworkerVO;

public class NetworkerAnchor1_4Controller {
	@FXML
	TableView<NetsaleVO>NetsaleList;
	@FXML
	TableColumn<NetsaleVO, String> netsaleColumn;
	@FXML
	TableColumn<NetsaleVO, Boolean> viewColumn;
	
	@FXML
	Button viewNetsaleBt;
	
	
	RunNetworker runNetworker;
	NetworkerVO networkerVO;
	public NetworkerAnchor1_4Controller(){
		
	}
	
	
	
	public void ViewNetsaleClicked(){
		
	}
	
	
	
	
	public void initialize(){
		//初始化1个tableview
		NetworkerController controller;
		try {
			controller = new NetworkerController();
			ArrayList<NetsaleVO> netsaleArray=controller.getAllNetsaleInfo();
			ObservableList<NetsaleVO> netsaleData= FXCollections.observableArrayList();
			netsaleData.addAll(netsaleArray);
			NetsaleList.setItems(netsaleData);
			netsaleColumn.setCellValueFactory(cellData->cellData.getValue().getUserId());
			
			
			viewColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<NetsaleVO, Boolean>, ObservableValue<Boolean>>() {
	          @Override
	          public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<NetsaleVO, Boolean> p) {
	              return new SimpleBooleanProperty(p.getValue()!=null);
	          }
	      });

	      viewColumn.setCellFactory(new Callback<TableColumn<NetsaleVO, Boolean>, TableCell<NetsaleVO, Boolean>>() {
	          @Override
	          public TableCell<NetsaleVO, Boolean> call(TableColumn<NetsaleVO, Boolean> p) {
	              return new ButtonCell1_4();
	          }
	      });
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void SetRunNetworker(RunNetworker runNetworker){
		this.runNetworker=runNetworker;
		networkerVO=runNetworker.GetNetWorkerVO();
		initialize();
		
	}

}
