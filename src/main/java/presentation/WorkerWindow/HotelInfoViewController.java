package presentation.WorkerWindow;



import java.rmi.RemoteException;

import businesslogic.hotelbl.HotelController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import vo.HotelVO;

public class HotelInfoViewController {
	//酒店图片
	@FXML
	ImageView image;
	//酒店名字
	@FXML
	Label name;
	//酒店地址
	@FXML
	Label location;
	//酒店简介
	@FXML
	Label introduction;
	//所属商圈
	@FXML
	Label area;
	//设施服务
	@FXML
	Label sheshi;
	//酒店星级
	@FXML
	Label level;
	//修改按钮
	@FXML
	Button modify;
	
	RunWorker runWorker;
	HotelVO hotelVO;
	
//	HotelInfoView hotelInfoView;
	
//	@SuppressWarnings("static-access")
	public HotelInfoViewController(){
//		hotelVO=runWorker.getHotelVO();
	}
	
//	@SuppressWarnings("static-access")
	@SuppressWarnings("static-access")
	@FXML
	public void initial() throws RemoteException{
		HotelController hController=new HotelController();
		this.hotelVO=hController.seekHotel(runWorker.getWorkerVO().getHotel_id());
		HotelVO vo=hotelVO;
//		System.out.println("aaaa");
		name.setText(vo.getHotelName().get());
		location.setText(vo.getHotelAddress().get());
		introduction.setText(vo.getHotelIntro().get());
		area.setText(vo.getHotelArea().get());
		sheshi.setText(vo.getHotelServe().get());
		level.setText(String.valueOf(vo.getHotel_level()));
	}
	
	public void modifyClicked() throws RemoteException{
		RunModifyHotelInfo runModifyHotelInfo=new RunModifyHotelInfo();
		try {
			runModifyHotelInfo.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setRunWorker(RunWorker rw) throws RemoteException{
		this.runWorker=rw;
		initial();
	}

}
