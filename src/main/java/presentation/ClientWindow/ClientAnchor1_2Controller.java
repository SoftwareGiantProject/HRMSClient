package presentation.ClientWindow;

import businesslogic.userbl.client.ClientController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.WarningWindow.RunWarning;
import util.ResultMessage;
import vo.ClientVO;

public class ClientAnchor1_2Controller {
	@FXML
	TextField name;
	@FXML
	Label account;
	@FXML 
	TextField phone;
	@FXML
	Label credit;
	
	ClientVO client;
	
	RunClient1 runClient1;
	
	
	
	public ClientAnchor1_2Controller(){
		
	}
	//点击修改信息 监听
	public void modifyClicked(){
		try{
			if(name.getText().length()!=0&&phone.getText().length()!=0){
		ClientVO clientvo=new ClientVO();
		clientvo=client;
		clientvo.setUserName(name.getText());
		clientvo.setContact(phone.getText());
		ClientController cl=new ClientController();
		ResultMessage result=cl.modifyInfo(clientvo);
		if(result==ResultMessage.SUCCESS){
			//弹窗 修改成功
			
			
			//回到查看信息栏
			RunClient1 rc=new RunClient1();
			rc.SetAnchor1(1);
			rc.start(new Stage());
			runClient1.getPrimaryStage().close();
			RunWarning rw=new RunWarning();
			rw.SetWarning("信息修改成功");
			rw.start(new Stage());
		}else{
			//弹窗修改失败
			RunWarning rw=new RunWarning();
			rw.SetWarning("修改失败，请重试");
			rw.start(new Stage());
		}
		
			}else{
				RunWarning rw=new RunWarning();
				rw.SetWarning("请输入新的姓名和联系方式");
				rw.start(new Stage());
			}
//		//回到查看信息栏
//		RunClient1 rc=new RunClient1();
//		rc.SetAnchor1(1);
//		rc.start(new Stage());
//		runClient1.getPrimaryStage().close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void initialize(){
		try{
			//需要调用
			
			
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
