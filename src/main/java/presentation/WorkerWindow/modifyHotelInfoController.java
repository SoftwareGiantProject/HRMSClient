package presentation.WorkerWindow;

import java.rmi.RemoteException;

import businesslogic.hotelbl.HotelController;
import businesslogic.userbl.worker.WorkerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import presentation.WarningWindow.RunWarning;
import presentation.WarningWindow.WarningAnchorController;
import util.ResultMessage;
import vo.HotelVO;
import vo.WorkerVO;

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
	WorkerVO workerVO;
	RunWorker runWorker;
	RunModifyHotelInfo runModifyHotelInfo;
	
	public modifyHotelInfoController(){
		
	}
	
	@SuppressWarnings({ "unchecked" })
	public void initialize() throws RemoteException{
		level.getItems().addAll("5","4","3","2","1");
		level.setValue("5");
		HotelController hController=new HotelController();
		String hotelid=runWorker.getWorkerVO().getHotel_id().get();
		String hotelname1=hController.getNmaeById(hotelid);
		this.hotelVO=hController.seekHotel(hotelname1);
		
//		this.hotelVO=runWorker.getHotelVO();
		hotelname.setText(hotelVO.getHotelName().get());
	}
	
	@SuppressWarnings("static-access")
	public void saveClicked() throws RemoteException{
		HotelController hController=new HotelController();
		this.workerVO=runWorker.getWorkerVO();
		String hotelid=this.workerVO.getHotel_id().get();
		String hotelname1=hController.getNmaeById(hotelid);
//		this.hotelVO=hController.seekHotel(hotelname1);
//		this.hotelVO=runWorker.getHotelVO();
		HotelVO vo=new HotelVO();
		if(address.getText().length()!=0&&introduce.getText().length()!=0&&area.getText().length()!=0&&service.getText().length()!=0){
			vo=new HotelVO(hotelid,hotelname1 , address.getText(), area.getText(), Integer.parseInt((String) level.getValue()), hotelVO.getHotel_score().get(), introduce.getText(),service.getText(), hotelVO.getHotelRoom().get(), hotelVO.getCity().get());
			HotelController hotelController=new HotelController();
			ResultMessage resultMessage=ResultMessage.FAIL;
			try {
				resultMessage=hotelController.modifyHotel(vo);
				if(resultMessage==ResultMessage.SUCCESS){
					this.runModifyHotelInfo.getPrimarystage().close();
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
			
			
//			HotelInfoMenuController hotelInfoMenuController=new HotelInfoMenuController();
//			try {
//				hotelInfoMenuController.hotelInfoClicked();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
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
	
	public void setRunWorker(RunWorker runWorker){
		this.runWorker=runWorker;
		
	}

}
