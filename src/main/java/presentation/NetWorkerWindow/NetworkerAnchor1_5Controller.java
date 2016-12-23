package presentation.NetWorkerWindow;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.hotelbl.HotelController;
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
import vo.NetsaleVO;
import vo.NetworkerVO;
import vo.WorkerVO;

public class NetworkerAnchor1_5Controller {
	@FXML
	TableView<WorkerVO>List;
	@FXML
	TableColumn<WorkerVO,String> hotelColumn;
	@FXML
	TableColumn<WorkerVO, String>workerColumn;
	@FXML
	TableColumn<WorkerVO,Boolean>viewColumn;
	@FXML
	Button addHotelBt;
	
	
	
	
	
	RunNetworker runNetworker;
	NetworkerVO networkerVO;
	public NetworkerAnchor1_5Controller(){
		
	}
	
	public void AddHotelClicked(){
		
	}
	
	
	
	
	
	public void initialize(){
		//初始化2个tableview
		NetworkerController controller;
		try {
			controller = new NetworkerController();
			ArrayList<WorkerVO> workerArray=controller.getAllWorkerInfo();
			ObservableList<WorkerVO> workerData= FXCollections.observableArrayList();
			workerData.addAll(workerArray);
			List.setItems(workerData);
			workerColumn.setCellValueFactory(cellData->cellData.getValue().getUserName());
			
			hotelColumn.setCellValueFactory(cellData->cellData.getValue().getHotel_id());
			
			viewColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<WorkerVO, Boolean>, ObservableValue<Boolean>>() {
	          @Override
	          public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<WorkerVO, Boolean> p) {
	              return new SimpleBooleanProperty(p.getValue()!=null);
	          }
	      });

	      viewColumn.setCellFactory(new Callback<TableColumn<WorkerVO, Boolean>, TableCell<WorkerVO, Boolean>>() {
	          @Override
	          public TableCell<WorkerVO, Boolean> call(TableColumn<WorkerVO, Boolean> p) {
	              return new ButtonCell1_5();
	          }
	      });
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
	
	public void SetRunNetworker(RunNetworker runNetworker){
		
		this.runNetworker=runNetworker;
		networkerVO=runNetworker.GetNetWorkerVO();
		System.out.println("gg");
		initialize();
		
	}

}
