package presentation.WorkerWindow;

import businesslogic.promotionbl.PromotionController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.WarningWindow.RunWarning;
import util.ResultMessage;
import vo.PromotionVO;

public class AddStragetiesController {
	RunAddStrategies runAddStrategies;
	PromotionVO promotionVO;
	
	@FXML
	TextField straname;
	@SuppressWarnings("rawtypes")
	@FXML
	ChoiceBox object;
	@SuppressWarnings("rawtypes")
	@FXML
	ChoiceBox discount;
	@FXML
	TextField time;
	
	@FXML
	Button save;
	
	public AddStragetiesController(){
		
	}
	
	@SuppressWarnings("unchecked")
	public void initialize(){
		object.getItems().addAll("所有人","普通会员","企业会员");
		object.setValue("所有人");
		discount.getItems().addAll("0.9","0.8","0.7","0.6","0.5","0.4","0.3","0.2","0.1");
		discount.setValue("0.9");
	}
	
	@SuppressWarnings("static-access")
	public void saveCliked(){
		if(straname.getText()!=null&&time.getText()!=null){
			PromotionVO promotion=new PromotionVO();
			promotion=new PromotionVO(straname.getText(), String.valueOf(object.getValue()),Double.parseDouble( (String) discount.getValue()), time.getText(), null);
			//PromotionController pController1=new PromotionController();
//			if(promotion.getPromoitonObject().equals("所有人")){
//				
//			}
			addforall(promotion);
		}
		else{
			RunWarning runWarning=new RunWarning();
			runWarning.SetWarning("请填写完整信息");
			runWarning.start(new Stage());
		}
	}
	
	@SuppressWarnings("static-access")
	public void addforall(PromotionVO p){
		PromotionController pController1=new PromotionController();
		try {
			ResultMessage resultMessage=pController1.addPromotion(p);
			if(resultMessage==ResultMessage.SUCCESS){
				RunWarning runWarning=new RunWarning();
				runWarning.SetWarning("已成功添加该促销策略");
				runWarning.start(new Stage());
			}
			else{
				RunWarning runWarning=new RunWarning();
				runWarning.SetWarning("添加失败");
				runWarning.start(new Stage());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
//	public void addforcommon(PromotionVO p){
//		PromotionController pController1=new PromotionController();
//		try {
//			ResultMessage resultMessage=pController1.addMemberPromotion(p);
//			if(resultMessage==ResultMessage.SUCCESS){
//				RunWarning runWarning=new RunWarning();
//				runWarning.SetWarning("已成功添加该促销策略");
//				runWarning.start(new Stage());
//			}
//			else{
//				RunWarning runWarning=new RunWarning();
//				runWarning.SetWarning("添加失败");
//				runWarning.start(new Stage());
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
	
	public void setRunAddStrategies(RunAddStrategies run1){
		this.runAddStrategies=run1;
		initialize();
	}

}
