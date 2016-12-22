package presentation.NetsaleWindow;






import java.rmi.RemoteException;

import businesslogic.creditbl.CreditController;
import businesslogic.userbl.client.ClientController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.WarningWindow.RunWarning;
import util.ResultMessage;
import vo.ClientVO;
import vo.CreditVO;

public class addCreditController {
	//搜索框
	
	@FXML
	TextField tf;
	
	//搜索按钮
	@FXML
	Button search;
	
	//客户编号
	@FXML
	Label id;
	
	//信用值
	@FXML
	Label credit;
	
	@FXML
	TextField money;
	
	//充值按钮
	@FXML
	Button recharge;
	
	RunNetSale runNetSale;
	CreditVO creditVO;
	ClientVO clientVO;
	
	public addCreditController(){
		
	}
	
	@SuppressWarnings("static-access")
	public void searchClicked() throws RemoteException{
		if(tf.getText()!=null){
			//需要一个判断该账号是否存在的方法
			ClientController clientController=new ClientController();
			ResultMessage res=clientController.checkClientExist(tf.getText());
			if(res==ResultMessage.EXIST){
				CreditController creditController=new CreditController();
			    creditVO=creditController.getCredit(tf.getText());
			    id.setText(creditVO.getUserId());
			    credit.setText(String.valueOf(creditVO.getCredit()));
			}
			else{
				RunWarning rWarning=new RunWarning();
				rWarning.SetWarning("该用户不存在！");
				rWarning.start(new Stage());
			}
			
		}
		else{
			RunWarning rWarning=new RunWarning();
			rWarning.SetWarning("请输入用户id！");
			rWarning.start(new Stage());
		}
	}
	
	@SuppressWarnings("static-access")
	public void rechargeClicked() throws RemoteException{
		if(money.getText()!=null){
			int charge=Integer.parseInt(money.getText());
			CreditController creditController=new CreditController();
			ResultMessage resultMessage=creditController.deposit(creditVO.getUserId(), charge);
			if(resultMessage==ResultMessage.SUCCESS){
				RunWarning rWarning=new RunWarning();
				rWarning.SetWarning("充值成功！");
				rWarning.start(new Stage());
			}
			else{
				RunWarning rWarning=new RunWarning();
				rWarning.SetWarning("充值失败！");
				rWarning.start(new Stage());
			}
		}
		else{
			RunWarning rWarning=new RunWarning();
			rWarning.SetWarning("请输入充值金额！");
			rWarning.start(new Stage());
		}
		
	}
	

}
