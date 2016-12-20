package presentation.WorkerWindow;



import java.rmi.RemoteException;

import businesslogic.hotelbl.HotelController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import presentation.WarningWindow.RunWarning;
import util.ResultMessage;
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
	TextField location;
	//酒店简介
	@FXML
	TextField introduction;
	//所属商圈
	@FXML
	TextField area;
	//设施服务
	@FXML
	TextField sheshi;
	//酒店星级
	@FXML
	TextField level;
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
	@FXML
	public void initial() throws RemoteException{
		HotelController hController=new HotelController();
		hotelVO=hController.seekHotel(runWorker.getWorkerVO().getHotel_id());
//		System.out.println("aaaa");
		name.setText(hotelVO.getHotelName().get());
		location.setText(hotelVO.getHotelAddress().get());
		introduction.setText(hotelVO.getHotelIntro().get());
		area.setText(hotelVO.getHotelArea().get());
		sheshi.setText(hotelVO.getHotelServe().get());
		level.setText(String.valueOf(hotelVO.getHotel_level()));
	}
	
	@SuppressWarnings("static-access")
	public void modifyClicked() throws RemoteException{
		HotelVO vo=new HotelVO();
		vo=hotelVO;
		if(name.getText()!=null&&location.getText()!=null&&introduction.getText()!=null&&area.getText()!=null&&sheshi.getText()!=null&&level.getText()!=null){
			vo=new HotelVO(vo.getHotelId().get(),name.getText() , location.getText(), area.getText(), Integer.parseInt(level.getText()), vo.getHotel_score().get(), introduction.getText(), sheshi.getText(), vo.getHotelRoom().get(), vo.getCity().get());
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
	
	public void setRunWorker(RunWorker rw) throws RemoteException{
		this.runWorker=rw;
		initial();
	}

}
