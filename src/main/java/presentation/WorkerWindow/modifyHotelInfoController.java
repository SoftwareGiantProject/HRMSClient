package presentation.WorkerWindow;

import java.rmi.RemoteException;

import businesslogic.hotelbl.HotelController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import presentation.WarningWindow.RunWarning;
import util.ResultMessage;
import vo.HotelVO;

public class modifyHotelInfoController {
	@FXML
	ImageView iamge;
	@FXML
	Label hotelname;
	
	@FXML
	TextField address;
	@FXML
	TextField introduce;
	@FXML
	TextField area;
	@FXML
	TextField service;
	
	@SuppressWarnings("rawtypes")
	@FXML
	ChoiceBox level;
	
	@FXML
	Button save;
	
	HotelVO hotelVO;
	RunWorker runWorker;
	RunModifyHotelInfo runModifyHotelInfo;
	
	public modifyHotelInfoController(){
		
	}
	
	@SuppressWarnings({ "unchecked", "static-access" })
	public void initialize() throws RemoteException{
		level.getItems().addAll("5","4","3","2","1");
		level.setValue("5");
		HotelController hController=new HotelController();
		this.hotelVO=hController.seekHotel(runWorker.getWorkerVO().getHotel_id());
		hotelname.setText(hotelVO.getHotelName().get());
	}
	
	@SuppressWarnings("static-access")
	public void saveClicked() throws RemoteException{
		HotelController hController=new HotelController();
		this.hotelVO=hController.seekHotel(runWorker.getWorkerVO().getHotel_id());
		HotelVO vo=new HotelVO();
//		vo=hotelVO;
		if(address.getText()!=null&&introduce.getText()!=null&&area.getText()!=null&&service.getText()!=null&&level.getValue()!=null){
			vo=new HotelVO(hotelVO.getHotelId().get(),hotelVO.getHotelName().get() , address.getText(), area.getText(), Integer.parseInt((String) level.getValue()), vo.getHotel_score().get(), introduce.getText(),service.getText(), hotelVO.getHotelRoom().get(), hotelVO.getCity().get());
			HotelController hotelController=new HotelController();
			ResultMessage resultMessage=ResultMessage.FAIL;
			try {
				resultMessage=hotelController.modifyHotel(vo);
				if(resultMessage==ResultMessage.SUCCESS){
					RunWarning runWarning=new RunWarning();
					runWarning.SetWarning("修改成功！");
					runWarning.start(new Stage());
				}
				else{
					RunWarning runWarning=new RunWarning();
					runWarning.SetWarning("修改失败！");
					runWarning.start(new Stage());
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		else{
			RunWarning runWarning=new RunWarning();
			runWarning.SetWarning("请填写完整信息！");
			runWarning.start(new Stage());
		}
	}
	
	public void setRunModifyHotelInfo(RunModifyHotelInfo runModifyHotelInfo1) throws RemoteException{
		this.runModifyHotelInfo=runModifyHotelInfo1;
		initialize();
	}

}
