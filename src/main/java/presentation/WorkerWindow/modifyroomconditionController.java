package presentation.WorkerWindow;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import businesslogic.roombl.RoomController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import presentation.WarningWindow.RunWarning;
import util.ResultMessage;
import util.RoomCondition;
import vo.RoomConditionDateVO;

public class modifyroomconditionController {
	
	runModifyRoomCondition runModifyRoomCondition;
	static RoomConditionDateVO roomconditionvo;
	
	@FXML
	Label roomid;
	@SuppressWarnings("rawtypes")
	@FXML
	ChoiceBox date;
	@SuppressWarnings("rawtypes")
	@FXML
	ChoiceBox state;
	
	@FXML
	Button save;
	static RunWorker runWorker;
//	runModifyRoomCondition runModifyRoomCondition2
	
	public modifyroomconditionController(){
		
	}
	
	public static String getFutureDate(int num){
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR)+num);
		java.util.Date today=calendar.getTime();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String result=format.format(today);
//		Log.e(null,result);
		return result;
	}

	
	@SuppressWarnings("unchecked")
	public void initialize(){
		ButtonCellrefreshRoom bcf=new ButtonCellrefreshRoom();
		RoomConditionDateVO room1=bcf.getvo();
		roomid.setText(room1.getRoomNumber().get());
		ArrayList<String> date1=new ArrayList<>();
		for(int i=0;i<7;i++){
			date1.add(getFutureDate(i));
		}
		date.getItems().addAll(date1.get(0),date1.get(1),date1.get(2),date1.get(3),date1.get(4),date1.get(5),date1.get(6));
		date.setValue(date1.get(0));
		
		state.getItems().addAll("已预定","未预订","已入住");
		state.setValue("未预订");
	}
	
	@SuppressWarnings("static-access")
	public void saveClicked(){
		ButtonCellrefreshRoom buttonCellrefreshRoom=new ButtonCellrefreshRoom();
		roomconditionvo=buttonCellrefreshRoom.getvo();
		RoomConditionDateVO roomConditionDateVO1=roomconditionvo;
		if(String.valueOf(state.getValue()).equals("已预定")){
//			roomConditionDateVO1=new RoomConditionDateVO(String.valueOf(date.getValue()), roomid.getText(), RoomCondition.RESERVED, String.valueOf(roomconditionvo.getHotelId()));
			roomConditionDateVO1=new RoomConditionDateVO(String.valueOf(date.getValue()), roomid.getText(), RoomCondition.RESERVED,roomconditionvo.getHotelId().get(), roomconditionvo.getOrder_id().get());
		}
		else if(String.valueOf(state.getValue()).equals("未预订")){
			roomConditionDateVO1=new RoomConditionDateVO(String.valueOf(date.getValue()), roomid.getText(), RoomCondition.UNRESERVED,String.valueOf(roomconditionvo.getHotelId()), roomconditionvo.getOrder_id().get());
		}
		else if(String.valueOf(state.getValue()).equals("已入住")){
			roomConditionDateVO1=new RoomConditionDateVO(String.valueOf(date.getValue()), roomid.getText(), RoomCondition.CHECKIN,String.valueOf(roomconditionvo.getHotelId()), roomconditionvo.getOrder_id().get());
		}
		
		try{
			RoomController roomController=new RoomController();
			ResultMessage resultMessage=roomController.modifyCondition(roomConditionDateVO1);		
		    if(resultMessage==ResultMessage.SUCCESS){
//		    	this.runWorker.getPrimaryStage().close();
//		    	RunWorker run1=new RunWorker();
//				run1.SetAnchor1(4);
//				run1.start(new Stage());
				this.runModifyRoomCondition.getPrimaryStage().close();
				
				
		    	RunWarning rw=new RunWarning();
				rw.SetWarning("修改成功！");
				rw.start(new Stage());
//				this.runWorker.getPrimaryStage().close();
		    }
		    else{
		    	RunWarning runWarning=new RunWarning();
			    runWarning.SetWarning("修改失败!");
			    runWarning.start(new Stage());
		    }
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void setRunmodifyroomcondition(runModifyRoomCondition runModifyRoomCondition){
		this.runModifyRoomCondition=runModifyRoomCondition;
		initialize();
	}
	
	public void setRunWorker(){
		refreshRoomController refreshRoomController=new refreshRoomController();
		this.runWorker=refreshRoomController.getRunWorker();
	}


}
