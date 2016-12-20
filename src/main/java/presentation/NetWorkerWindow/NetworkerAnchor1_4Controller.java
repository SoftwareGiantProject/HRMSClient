package presentation.NetWorkerWindow;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import vo.NetworkerVO;

public class NetworkerAnchor1_4Controller {
	@FXML
	TableView<Button>NetsaleList;
	
	
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
	}
	
	public void SetRunNetworker(RunNetworker runNetworker){
		this.runNetworker=runNetworker;
		networkerVO=runNetworker.GetNetWorkerVO();
		initialize();
		
	}

}
