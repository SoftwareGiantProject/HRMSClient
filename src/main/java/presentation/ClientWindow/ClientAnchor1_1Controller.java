package presentation.ClientWindow;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import vo.ClientVO;

public class ClientAnchor1_1Controller {
	@FXML
	Label name;
	@FXML
	Label account;
	@FXML 
	Label phone;
	@FXML
	Label credit;
	
	ClientVO client;
	
	RunClient1 runClient1;
	
	
	
	public ClientAnchor1_1Controller(){
		
	}
	
	//点击修改
	public void modifyClicked(){
		try{
		RunClient1 rc=new RunClient1();
		rc.SetAnchor1(2);
		rc.start(new Stage());
		runClient1.getPrimaryStage().close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void initialize(){
		try{
			//需要调用
			
			name.setText(client.getUserName().get());
			account.setText(client.getUserId().get());
			credit.setText(Integer.toString(client.getCredit().get()));
			phone.setText(client.getContact().get());
		    
		    
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public void setRunClient(RunClient1 runClient1){
		this.runClient1=runClient1;
		this.client=runClient1.GetClientVO();
		//添加监听
		initialize();
	}

}
