package presentation.ClientWindow;

import java.text.SimpleDateFormat;
import java.util.Date;

import businesslogic.hotelbl.HotelController;
import businesslogic.orderbl.OrderController;
import businesslogic.roombl.RoomController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.ViewWindow.RunView;
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
	Label dachuangfang;//拼音 实在是英语水平有限
	@FXML
	Label biaozhunjian;
	@FXML
	Label shangwujian;
	@FXML
	Button viewHistory;
	
	
	
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
	
//	public void SetHoteVO(HotelVO vo){
//		this.hotelvo=vo;
//	}
	public void ReserveClicked(){
		
		
		try{
			
		
		if(checkindate.getValue()==null||checkoutdate.getValue()==null||peopleNum.getText().length()==0||roomNum.getText().length()==0
				||hasChild.getSelectionModel().getSelectedItem()==null||roomType.getSelectionModel().getSelectedItem()==null){
			RunWarning runWarning=new RunWarning();
			runWarning.SetWarning("请输入订单信息！");
			runWarning.start(new Stage());
		}else{
			
			String checkinTime=String.valueOf(checkindate.getValue());
			String checkoutTime=String.valueOf(checkoutdate.getValue());
			System.out.println(checkinTime);
			System.out.println(checkoutTime);
			int people=Integer.parseInt(peopleNum.getText());
			String type=roomType.getValue();
			boolean haveChild;
			if(hasChild.getValue()=="有"){
				haveChild=true;
			}else{
				haveChild=false;
			}
		Date date=new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
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
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void viewHistoryClicked(){
		RunView runView=new RunView();
		runView.setAnchor1(11);
		runView.hotelVO=this.hotelvo;
		runView.SetClientVO(this.clientvo);
		runView.start(new Stage());
	}
	
	@FXML
	public void initialize(){
		//要得到具体的hotelvo 对象
		hotelvo=runClient.GetHotelVO();
		
		
		hotelName.setText(hotelvo.getHotelName().get());
		hotelAddress.setText(hotelvo.getHotelAddress().get());
		hotelIntro.setText(hotelvo.getHotelIntro().get());
		businessCircle.setText(hotelvo.getHotelArea().get());
		serve.setText(hotelvo.getHotelServe().get());
		hotelLevel.setText(Integer.toString(hotelvo.getHotel_level().get()));
		hotelScore.setText(Double.toString(hotelvo.getHotel_score().get()));
		
		
		//combox 初始化
		roomType.getItems().addAll("大床房","标准间","商务间");
		hasChild.getItems().addAll("有","无");
		RoomController controller=new RoomController();
//		System.out.println(controller.findRooms(hotelvo.getHotelId().get(), "大床房").get(0).getRoomPrice().get());
//		System.out.println(controller.findRooms(hotelvo.getHotelId().get(), "标准间").get(0).getRoomPrice().get());
//		System.out.println(controller.findRooms(hotelvo.getHotelId().get(), "商务间").get(0).getRoomPrice().get());
//		
		dachuangfang.setText(Integer.toString(controller.findRooms(hotelvo.getHotelId().get(), "大床房").get(0).getRoomPrice().get()));
//		biaozhunjian.setText(Integer.toString(controller.findRooms(hotelvo.getHotelId().get(), "标准间").get(0).getRoomPrice().get()));
//		shangwujian.setText(Integer.toString(controller.findRooms(hotelvo.getHotelId().get(), "商务间").get(0).getRoomPrice().get()));
	}
	
	public void SetRunClient(RunClient1 runClient){
		this.runClient=runClient;
		clientvo=runClient.GetClientVO();
		hotelvo=runClient.GetHotelVO();
//		initialize();
		
	}


}
