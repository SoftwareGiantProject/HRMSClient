package presentation.ClientWindow;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

public class ClientAnchor1Controller {
	@FXML
	Label name;
	@FXML
	Label account;
	@FXML 
	Label phone;
	@FXML
	Label credit;
	
	
	
	RunClient1 runClient1;
	
	
	
	public ClientAnchor1Controller(){
		
	}
	
	
	public void initialize(){
		try{
			//需要调用
			name.setText("zhangsan");
			account.setText("151250001");
			credit.setText("0");
			phone.setText("000000000");
		    
		    
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
