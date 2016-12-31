package presentation.ViewWindow;

import java.rmi.RemoteException;

import businesslogic.userbl.netsale.NetsaleController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.WarningWindow.RunWarning;
import util.ResultMessage;
import vo.ClientVO;
import vo.NetsaleVO;
import vo.OrderVO;
import vo.PromotionVO;

public class ViewPromotionController {
	@FXML
	Label oldprice;
	@FXML
	Label promotionname;
	@FXML
	Label promotioncount;
	@FXML
	Label newprice;
	
	
	OrderVO orderVO;
	PromotionVO promotionVO;
	public static RunView rv;
	
	public void initialize() {
		
//		credit.setText(String.valueOf(clientvo.getCredit().get()));
//		birthday.setText(clientvo.getBirthday().get());
	}
//	public void AddClicked(){
//		if(netsalename.getText().length()==0||phone.getText().length()==0||
//				password.getText().length()==0||netsaleid.getText().length()==0){
//			RunWarning runWarning =new RunWarning();
//			runWarning.SetWarning("请输入新的信息！");
//			runWarning.start(new Stage());
//		}else{
//		NetsaleController controller=new NetsaleController();
//		NetsaleVO vo=new NetsaleVO(netsaleid.getText(), netsalename.getText(), password.getText(), phone.getText());
//		try {
//			ResultMessage resultMessage=controller.addNetsaleInfo(vo);
//			if(resultMessage==ResultMessage.SUCCESS){
//				RunWarning runWarning =new RunWarning();
//				runWarning.SetWarning("添加成功！");
//				runWarning.start(new Stage());
////				this.rv.getPrimaryStage().close();
//			}else{
//				RunWarning runWarning =new RunWarning();
//				runWarning.SetWarning("id已存在！请重试！");
//				runWarning.start(new Stage());
//			}
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//		}
//	}
	
	public void SetRunView(RunView runview){
		this.rv=runview;
		this.orderVO=runview.orderVO;
		this.promotionVO=runview.promotionVO;
//		this.netsalevo=runview.netsaleVO;
//		System.out.println(netsalevo.getUserId().get());
		
//		netsaleid.setText(netsalevo.getUserId().get());
		
		initialize();
		newprice.setText(String.valueOf(orderVO.getOrderPrice().get()));
		promotionname.setText(promotionVO.getPromotionName().get());
		promotioncount.setText(String.valueOf(promotionVO.getCount().get()));
		oldprice.setText(String.valueOf((int)orderVO.getOrderPrice().get()/promotionVO.getCount().get()));
		
//		System.out.println("gg"+clientvo.getUserId().get());
//		save.setText("保存修改");
	}

}
