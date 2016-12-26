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
	RunWorker runworker;
	
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
		object.getItems().addAll("所有人","会员");
		object.setValue("所有人");
		discount.getItems().addAll("9","8","7","6","5","4","3","2","1");
		discount.setValue("9");
	}
	
	
	/**
	 * 点击保存按钮
	 */
	@SuppressWarnings("static-access")
	public void saveCliked(){
		if(straname.getText().length()!=0&&time.getText().length()!=0){
			PromotionVO promotion=new PromotionVO();
			if(object.getValue()=="所有人"){
				promotion=new PromotionVO(straname.getText(),"ALL",Double.parseDouble( (String) discount.getValue()), time.getText(),runworker.getWorkerVO().getHotel_id().get() );

			}
			else{
				promotion=new PromotionVO(straname.getText(), "MEMBER",Double.parseDouble( (String) discount.getValue()), time.getText(),runworker.getWorkerVO().getHotel_id().get() );

			}
			addforall(promotion);
		}
		else{
			RunWarning runWarning=new RunWarning();
			runWarning.SetWarning("请填写完整信息");
			runWarning.start(new Stage());
		}
	}
	
	/**
	 * 用来保存到数据库的
	 * @param p
	 */
	@SuppressWarnings("static-access")
	public void addforall(PromotionVO p){
		PromotionController pController1=new PromotionController();
		try {
			ResultMessage resultMessage=pController1.addPromotion(p);
			if(resultMessage==ResultMessage.SUCCESS){
				runAddStrategies.getPrimaryStage().close();
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
	
	
	public void setRunAddStrategies(RunAddStrategies run1){
		this.runAddStrategies=run1;
//		initialize();
	}
	
	public void setRunworker(RunWorker worker){
		this.runworker=worker;
	}

}
