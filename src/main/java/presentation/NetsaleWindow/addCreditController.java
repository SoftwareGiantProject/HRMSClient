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
		if(tf.getText().length() != 0){
			//需要一个判断该账号是否存在的方法
			String id1=String.valueOf(tf.getText());
			ClientController clientController=new ClientController();
			ResultMessage res=clientController.checkClientExist(id1);
//			System.out.println(id1);
//			System.out.println(res);
			if(res==ResultMessage.SUCCESS){
//				System.out.println(String.valueOf(tf.getText()));
//				System.out.println("111111111111111111111111");
				CreditController creditController=new CreditController();
//				System.out.println("222222222222222222222");
			    creditVO=creditController.getCredit(id1);
//			    System.out.println("333333333333333333333");
			    id.setText(creditVO.getUserId().get());
			    credit.setText(String.valueOf(creditVO.getCredit().get()));
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
		if(money.getText().length()!= 0){
			int charge=Integer.parseInt(money.getText());
			CreditController creditController=new CreditController();
			ResultMessage resultMessage=creditController.deposit(creditVO.getUserId().get(), charge);
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
