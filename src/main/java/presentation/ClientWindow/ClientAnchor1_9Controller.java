package presentation.ClientWindow;

import java.text.SimpleDateFormat;
import java.util.Date;

import businesslogic.hotelbl.HotelController;
import businesslogic.orderbl.OrderController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.WarningWindow.RunWarning;
import util.ListType;
import util.ResultMessage;
import vo.ClientVO;
import vo.HotelEvaluationVO;
import vo.HotelVO;
import vo.OrderVO;

public class ClientAnchor1_9Controller {
	@FXML
	Label hotelName;
	@FXML
	Label hotelAddress;
	@FXML
	Label hotelIntro;
	@FXML
	Label businessCircle;
	@FXML
	Label serve;
	@FXML
	TextField roomNum;
	@FXML
	Label hotelLevel;
	@FXML
	Label hotelScore;
	
	@FXML
	ComboBox<String> roomType;
	@FXML
	TextField peopleNum;
	@FXML
	DatePicker checkindate;
	@FXML
	DatePicker checkoutdate;
	@FXML
	ComboBox<String> hasChild;
	
	@FXML
	Button reserve;
	
	RunClient1 runClient;
	HotelVO hotelvo;
	
	
	ClientVO clientvo;
	
	
	public ClientAnchor1_9Controller(){
		
	}
	
	public void ReserveClicked(){
		try{
		String checkinTime=String.valueOf(checkindate.getValue());
		String checkoutTime=String.valueOf(checkoutdate.getValue());
		int people=Integer.parseInt(peopleNum.getText());
		String type=roomType.getValue();
		boolean haveChild;
		if(hasChild.getValue()=="有"){
			haveChild=true;
		}else{
			haveChild=false;
		}
		Date date=new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String startTime=dateFormat.format(date);
		
		OrderVO ordervo=new OrderVO(clientvo.getUserId().get(),hotelvo.getHotelId().get(),startTime,checkinTime,checkoutTime,type,Integer.parseInt(roomNum.getText()),people,haveChild,ListType.CURRENTLIST);
//		String user_id, String hotel_id, String startTime, String predictCheckInTime, String predictCheckOutTime, String roomType, int number, int people, boolean hasChild, ListType listType

		OrderController controller=new OrderController();
		
		ResultMessage result=controller.addOrder(ordervo);
		if(result==ResultMessage.SUCCESS){
			RunWarning warning=new RunWarning();
			warning.SetWarning("预定成功!");
			warning.start(new Stage());
		}else{
			RunWarning warning =new RunWarning();
			warning.SetWarning("预定失败！");
			warning.start(new Stage());
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void initialize(){
		//要得到具体的hotelvo 对象
		hotelvo=runClient.GetHotelVO();
		
		
		hotelName.setText(hotelvo.getHotelName().get());
		hotelAddress.setText(hotelvo.getHotelAddress().get());
		hotelIntro.setText(hotelvo.getHotelIntro().get());
		businessCircle.setText(hotelvo.getHotelArea().get());
		serve.setText(hotelvo.getHotelServe().get());
		hotelLevel.setText(Double.toString(hotelvo.getHotel_score().get()));
		hotelScore.setText(hotelvo.getHotel_score().getName());
		
		
		//combox 初始化
		
	}
	
	public void SetRunClient(RunClient1 runClient){
		this.runClient=runClient;
		clientvo=runClient.GetClientVO();
		initialize();
		
	}


}
