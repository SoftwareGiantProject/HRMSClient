package presentation.ViewWindow;

import businesslogic.userbl.client.ClientController;
import businesslogic.userbl.netsale.NetsaleController;
import businesslogic.userbl.networker.NetworkerController;
import businesslogic.userbl.worker.WorkerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import presentation.ClientWindow.ClientAnchor1_2Controller;
import presentation.ClientWindow.RunClient1;
import presentation.NetWorkerWindow.RunNetworker;
import presentation.WarningWindow.RunWarning;
import presentation.WorkerWindow.RunWorker;
import presentation.loginWindow.RunLogin;
import util.ResultMessage;
import vo.ClientVO;

public class ModifyPasswordController {
	@FXML
	PasswordField oldPassword;
	@FXML
	PasswordField newPassword;

	@FXML
	Button modifyBt;
	
	
	@FXML
	ClientAnchor1_2Controller client1_2;
	
	ClientVO clientvo;
	RunView runView;
	
	
	
	
	
	//构造
	public ModifyPasswordController(){
		
	}
	@FXML
	public void ModifyClicked(){
		//判断账号和密码
		try{
		ClientController controller=new ClientController();
		ResultMessage resultMessage=controller.modifyPassword(clientvo.getUserId().get(), oldPassword.getText(), newPassword.getText());
		if(resultMessage==ResultMessage.SUCCESS){
			RunWarning runWarning=new RunWarning();
			runWarning.SetWarning("修改成功！下次登录请使用新的密码！");
			runWarning.start(new Stage());
			runView.getPrimaryStage().close();
		}else{
			RunWarning runWarning=new RunWarning();
			runWarning.SetWarning("请输入正确的密码！");
			runWarning.start(new Stage());
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		}
		
		
		
	
	
	private void initialize() {
        // Initialize the person table with the two columns.
		
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
//    public void setClient1_2Controller(ClientAnchor1_2Controller client1_2) {
//        this.client1_2 = client1_2;
//        clientvo=client1_2.client;
//
//        // Add observable list data to the table
//        initialize();
//        
//    }
    
    public void SetRunView(RunView rv){
    	this.runView=rv;
    	clientvo=rv.GetClientVO();
    	initialize();
    }

}
