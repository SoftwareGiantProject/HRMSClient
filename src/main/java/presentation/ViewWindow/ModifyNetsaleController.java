package presentation.ViewWindow;

import java.rmi.RemoteException;

import businesslogic.userbl.netsale.NetsaleController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.WarningWindow.RunWarning;
import util.ResultMessage;
import vo.ClientVO;
import vo.NetsaleVO;

public class ModifyNetsaleController {
	@FXML
	Label netsaleid;
	@FXML
	TextField netsalename;
	@FXML
	TextField phone;
	
	
	@FXML
	Button save;
	
	public static RunView rv;
	 NetsaleVO netsalevo;
	public void initialize() {
		
//		credit.setText(String.valueOf(clientvo.getCredit().get()));
//		birthday.setText(clientvo.getBirthday().get());
	}
	public void SaveClicked(){
		if(netsalename.getText().length()==0||phone.getText().length()==0){
			RunWarning runWarning =new RunWarning();
			runWarning.SetWarning("请输入新的信息！");
			runWarning.start(new Stage());
		}else{
		NetsaleController controller=new NetsaleController();
		NetsaleVO vo=netsalevo;
		vo.setUserName(netsalename.getText());
		vo.setContact(phone.getText());
		try {
			ResultMessage resultMessage=controller.modifyInfo(vo);
			if(resultMessage==ResultMessage.SUCCESS){
				RunWarning runWarning =new RunWarning();
				runWarning.SetWarning("修改成功！");
				runWarning.start(new Stage());
				this.rv.getPrimaryStage().close();
			}else{
				RunWarning runWarning =new RunWarning();
				runWarning.SetWarning("修改失败！");
				runWarning.start(new Stage());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		}
	}
	
	public void SetRunView(RunView runview){
		this.rv=runview;
		
		this.netsalevo=runview.netsaleVO;
//		System.out.println(netsalevo.getUserId().get());
		
		netsaleid.setText(netsalevo.getUserId().get());
		
		initialize();
//		System.out.println("gg"+clientvo.getUserId().get());
		save.setText("保存修改");
	}

}
