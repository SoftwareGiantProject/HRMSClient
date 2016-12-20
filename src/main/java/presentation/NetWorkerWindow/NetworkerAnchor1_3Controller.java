package presentation.NetWorkerWindow;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import vo.NetworkerVO;

public class NetworkerAnchor1_3Controller {
	@FXML
	TableView<Button>WorkerList;
	
	
	@FXML
	Button viewWorkerBt;
	
	
	RunNetworker runNetworker;
	NetworkerVO networkerVO;
	public NetworkerAnchor1_3Controller(){
		
	}
	
	
	
	public void ViewWorkerClicked(){
		
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
