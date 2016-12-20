package presentation.ClientWindow;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import businesslogic.hotelbl.HotelController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import presentation.WarningWindow.RunWarning;
import util.ResultMessage;
import vo.ClientVO;
import vo.HotelEvaluationVO;
import vo.HotelVO;
import vo.OrderVO;

public class ClientAnchor1_8Controller {
	@FXML
	Label hotel;
	@FXML
	TextArea evaluate;
	@FXML
	ComboBox<String> star;
	@FXML
	Button submit;
	
	RunClient1 runClient;
	HotelVO hotelvo;
	OrderVO ordervo;
	
	ClientVO clientvo;
	
	
	public ClientAnchor1_8Controller(){
		
	}
	
//	
//	public void SetOrderVO(){
//		
//	}
	
	
	public void SubmitClicked(){
		try{
		String content=evaluate.getText();
		int starlevel=Integer.parseInt(star.getValue());
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-mm-dd-hh-mm-ss");
		String timeformat=format.format(date);
		HotelEvaluationVO evaluatevo=new HotelEvaluationVO(ordervo.getOrder_id().get(), clientvo.getUserId().get(), timeformat, content, starlevel);
		HotelController controller=new HotelController();
		ResultMessage result=controller.evaluateHotel(evaluatevo,hotelvo.getHotelName().get());
		if(result==ResultMessage.SUCCESS){
			RunWarning warning=new RunWarning();
			warning.SetWarning("评价提交成功!");
			warning.start(new Stage());
		}else{
			RunWarning warning =new RunWarning();
			warning.SetWarning("评价提交失败！");
			warning.start(new Stage());
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void initialize(){
		//要得到具体的hotelvo 对象
		try{
		HotelController controller=new HotelController();
		hotelvo=controller.seekHotel(ordervo.getHotel_id().get());
		
		hotel.setText(hotelvo.getHotelName().get());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//combox 初始化
		
	}
	
	public void SetRunClient(RunClient1 runClient){
		this.runClient=runClient;
		clientvo=runClient.GetClientVO();
		ordervo=runClient.GetOrderVO();
		initialize();
		
	}

}
