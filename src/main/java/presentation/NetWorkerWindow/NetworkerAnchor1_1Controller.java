package presentation.NetWorkerWindow;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import vo.NetworkerVO;

public class NetworkerAnchor1_1Controller {
	@FXML
	TableView<Button>ClientList;
	@FXML
	TableView<Button> WorkerList;
	@FXML
	TableView<Button> NetsaleList;
	
	@FXML
	Button addNetsaleBt;
	@FXML
	Button modifyNetsaleBt;
	@FXML
	Button modifyClientBt;
	@FXML
	Button modifyWorkerBt;
	
	RunNetworker runNetworker;
	NetworkerVO networkerVO;
	public NetworkerAnchor1_1Controller(){
		
	}
	
	
	
	public void AddNetsaleClicked(){
		
	}
	public void ModifyNetsaleClicked(){
		
	}
	public void ModifyClientClicked(){
		
	}
	
	
	
	public void initialize(){
		//初始化三个tableview
	}
	
	public void SetRunNetworker(RunNetworker runNetworker){
		this.runNetworker=runNetworker;
		networkerVO=runNetworker.GetNetWorkerVO();
		initialize();
		
	}
	

}
