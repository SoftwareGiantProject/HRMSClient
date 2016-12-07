package presentation.NetWorkerWindow;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class NetworkerAnchor2Controller {
	@FXML
	Label type;
	@FXML
	Label name;
	@FXML
	Label id;
	@FXML
	ImageView clientView;
	
	
	@FXML
	Button userManageBt;
	
	@FXML
	Button viewClientInfoBt;
	
	@FXML
	Button viewWorkerInfoBt;
	
	@FXML
	Button viewNetsaleInfoBt;
	
	@FXML
	Button addHotelBt;
	
	
	@FXML
	RunNetworker runNetworker;
	
	
	public void UserManageClicked(){
		try{
		RunNetworker rn=new RunNetworker();
		rn.setanchor1(1);
		rn.start(new Stage());
		this.runNetworker.getPrimaryStage().close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void ViewClientInfoClicked(){
		try{
		RunNetworker rn=new RunNetworker();
		rn.setanchor1(2);
		rn.start(new Stage());
		this.runNetworker.getPrimaryStage().close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void ViewWorkerInfoClicked(){
		try{
		RunNetworker rn=new RunNetworker();
		rn.setanchor1(3);
		rn.start(new Stage());
		this.runNetworker.getPrimaryStage().close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void ViewNetsaleInfoClicked(){
		try{
		RunNetworker rn=new RunNetworker();
		rn.setanchor1(4);
		rn.start(new Stage());
		this.runNetworker.getPrimaryStage().close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void AddHotelClicked(){
		try{
		RunNetworker rn=new RunNetworker();
		rn.setanchor1(5);
		rn.start(new Stage());
		this.runNetworker.getPrimaryStage().close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void initialize(){
		
	}
	
	public void setRunNetworker(RunNetworker runNetworker){
		this.runNetworker=runNetworker;
		initialize();
	}
	
	
}
