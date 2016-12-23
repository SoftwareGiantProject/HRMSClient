package presentation.ClientWindow;

import java.rmi.RemoteException;

import businesslogic.creditbl.CreditController;
import businesslogic.userbl.client.ClientController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.ViewWindow.RunView;
import presentation.WarningWindow.RunWarning;
import util.ResultMessage;
import vo.ClientVO;

public class ClientAnchor1_3Controller {
	@FXML
	Label name;
	@FXML
	Label account;
	@FXML 
	Label credit;
	@FXML
	TextField price;
	@FXML
	Button historyBt;
	
	ClientVO client;
	
	RunClient1 runClient1;
	
	
	
	public ClientAnchor1_3Controller(){
		
	}
	
	public void historyClicked(){
		RunView runView=new RunView();
		RunView.setAnchor1(5);
		RunView.SetClientVO(client);
		runView.start(new Stage());
	}
	
	public void payCreditClicked() throws RemoteException{
		if(price.getText().length()==0){
			RunWarning rw=new RunWarning();
			rw.SetWarning("请输入充值金额！");
			rw.start(new Stage());
		}else{
		int getPrice=Integer.parseInt(price.getText());
		CreditController creditcontro=new CreditController();
		ResultMessage result=creditcontro.deposit(client.getUserId().get(), getPrice);
		if(result==ResultMessage.SUCCESS){
			//弹窗 充值成功
			RunWarning rw=new RunWarning();
			rw.SetWarning("充值成功");
			rw.start(new Stage());
			client=new ClientController().getClientInfo(client.getUserId().get());
			credit.setText(Integer.toString(client.getCredit().get()));
		}else{
			//充值失败 弹窗
			RunWarning rw=new RunWarning();
			rw.SetWarning("充值失败，请重新充值！");
			rw.start(new Stage());
		}
		}
	}
	public void initialize(){
		try{
			//需要调用
			
			name.setText(client.getUserName().get());
			account.setText(client.getUserId().get());
			
			credit.setText(Integer.toString(client.getCredit().get()));
		    
		    
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
