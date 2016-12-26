package presentation.WorkerWindow;

import businesslogic.hotelbl.HotelController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import vo.HotelVO;
import vo.WorkerVO;

public class HotelInfoController {

	@FXML
	ImageView imageView;
	@FXML
	Label hotelname;
	@FXML
	Label address;
	@FXML
	Label introduce;
	@FXML
	Label area;
	@FXML
	Label service;
	@FXML
	Label level;
	
	@FXML
	Button modify;
	
	RunWorker runWorker;
	WorkerVO workerVO;
	HotelVO hotelVO;
	
	public HotelInfoController(){
		
	}
	

	public void setRunWorker(RunWorker worker){
		this.runWorker=worker;
		System.out.println("bbbbbbbbbbbb");
		
		initialize();
	}
	
	public void initialize(){
		try {
			HotelController hotelController = new HotelController();
			this.workerVO=runWorker.getWorkerVO();
			String hotelid=workerVO.getHotel_id().get();
			String hotelname1=hotelController.getNmaeById(hotelid);
		    this.hotelVO=hotelController.seekHotel(hotelname1);
//			this.hotelVO=runWorker.getHotelVO();
		    hotelname.setText(hotelVO.getHotelName().get());
		    address.setText(hotelVO.getHotelAddress().get());
		    introduce.setText(hotelVO.getHotelIntro().get());
		    area.setText(hotelVO.getHotelArea().get());
		    service.setText(hotelVO.getHotelServe().get());
		    level.setText(String.valueOf(hotelVO.getHotel_level().get()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void modifyClicked(){
//		modifyHotelInfoController mController=new modifyHotelInfoController();
//		mController.setRunWorker(runWorker);
		RunModifyHotelInfo runModifyHotelInfo=new RunModifyHotelInfo();
		try {
			runModifyHotelInfo.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
