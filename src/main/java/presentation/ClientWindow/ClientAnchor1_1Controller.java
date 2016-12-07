package presentation.ClientWindow;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
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
	
	
	public void initialize(){
		try{
			//需要调用
			name.setText(client.getUserName());
			account.setText(client.getUserId());
			credit.setText(Integer.toString(client.getCredit()));
			phone.setText(client.getContact());
		    
		    
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public void setRunClient(RunClient1 runClient1){
		this.runClient1=runClient1;
		//添加监听
		initialize();
	}

}
