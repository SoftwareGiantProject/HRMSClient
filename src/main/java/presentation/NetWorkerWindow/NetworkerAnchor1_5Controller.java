package presentation.NetWorkerWindow;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import vo.NetworkerVO;

public class NetworkerAnchor1_5Controller {
	@FXML
	TableView<Button>WorkerList;
	@FXML
	TableView<Button> HotelList;
	
	
	@FXML
	Button addHotelBt;
	@FXML
	Button addWorkerBt;
	
	
	RunNetworker runNetworker;
	NetworkerVO networkerVO;
	public NetworkerAnchor1_5Controller(){
		
	}
	
	
	
	public void AddHotelClicked(){
		
	}
	
	public void AddWorkerBt(){
		
	}
	
	
	
	
	public void initialize(){
		//初始化2个tableview
	}
	
	public void SetRunNetworker(RunNetworker runNetworker){
		this.runNetworker=runNetworker;
		networkerVO=runNetworker.GetNetWorkerVO();
		initialize();
		
	}

}
