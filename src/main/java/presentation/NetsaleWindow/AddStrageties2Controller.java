package presentation.NetsaleWindow;

import businesslogic.promotionbl.PromotionController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.WarningWindow.RunWarning;
import util.ResultMessage;
import vo.PromotionVO;

public class AddStrageties2Controller {
	RunAddStrategies2 runAddStrategies;
	PromotionVO promotionVO;
	RunNetSale runNetSale;
	
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
	
	
	
	public AddStrageties2Controller(){
		
	}
	
	@SuppressWarnings("unchecked")
	public void initialize(){
		object.getItems().addAll("所有人","会员");
		object.setValue("所有人");
		discount.getItems().addAll("9","8","7","6","5","4","3","2","1");
		discount.setValue("9");
	}
	
	@SuppressWarnings("static-access")
	public void saveCliked(){
		if(straname.getText()!=null&&time.getText()!=null){
			PromotionVO promotion=new PromotionVO();
			if(object.getValue()=="所有人"){
				promotion=new PromotionVO(straname.getText(),"ALL",Double.parseDouble( (String) discount.getValue()), time.getText(),"web" );

			}
			else{
				promotion=new PromotionVO(straname.getText(), "MEMBER",Double.parseDouble( (String) discount.getValue()), time.getText(),"web");

			}
//			promotion=new PromotionVO(straname.getText(), String.valueOf(object.getValue()),Double.parseDouble( (String) discount.getValue()), time.getText(),runworker.getWorkerVO().getHotel_id() );
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
	
	public void setRunAddStrategies2(RunAddStrategies2 run1){
		this.runAddStrategies=run1;
		initialize();
	}
	
	public void setRunworker(RunNetSale sale){
		this.runNetSale=sale;
	}

}
