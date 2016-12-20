package presentation.ClientWindow;

import businesslogic.memberbl.MemberController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.WarningWindow.RunWarning;
import util.ResultMessage;
import vo.ClientVO;

public class ClientAnchor1_10Controller {
	@FXML
	Label CorpNameLabel;
	@FXML
	Label birthdayLabel;
	@FXML
	RadioButton comMember;
	@FXML
	RadioButton corMember;
	@FXML
	DatePicker birthday;
	@FXML
	TextField corpName;
	
	@FXML
	Button register;
	
	RunClient1 runClient;
	ClientVO clientvo;
	
	
	public void RegisterClicked(){
		try{
		String birthdayString=birthday.getValue().toString();
		
		MemberController controller=new MemberController();
		if(comMember.isSelected()){
			
			ResultMessage result=controller.registerComMember(birthdayString, clientvo.getUserId().get());
			if(result==ResultMessage.SUCCESS){
				RunWarning runWarning=new RunWarning();
				runWarning.SetWarning("注册成功!");
				runWarning.start(new Stage());
		
			
			}else{
				RunWarning runWarning=new RunWarning();
				runWarning.SetWarning("注册失败!");
				runWarning.start(new Stage());
		}
		}else{
			ResultMessage result=controller.registerCorMember(birthdayString, clientvo.getUserId().get(), corpName.getText());
			if(result==ResultMessage.SUCCESS){
				RunWarning runWarning=new RunWarning();
				runWarning.SetWarning("注册成功!");
				runWarning.start(new Stage());
		
			
			}else{
				RunWarning runWarning=new RunWarning();
				runWarning.SetWarning("注册失败!");
				runWarning.start(new Stage());
		}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void corpMemberClicked(){
		comMember.setSelected(false);
		corMember.setSelected(true);
		
		corpName.setVisible(true);
		CorpNameLabel.setVisible(true);
		
	}
	
	public void comMemberClicked(){
		comMember.setSelected(true);
		corMember.setSelected(false);
		
		corpName.setVisible(false);
		CorpNameLabel.setVisible(false);
		
	}
	
	public void initialize(){
		comMember.setSelected(true);
		corMember.setSelected(false);
		
		corpName.setVisible(false);
		CorpNameLabel.setVisible(false);
		
		
	}
	
	public void setRunClient(RunClient1 runClient){
		this.runClient=runClient;
		this.clientvo=runClient.GetClientVO();
		initialize();
	}

}
