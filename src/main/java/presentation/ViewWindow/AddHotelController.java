package presentation.ViewWindow;

import java.rmi.RemoteException;

import businesslogic.hotelbl.HotelController;
import businesslogic.userbl.netsale.NetsaleController;
import businesslogic.userbl.worker.WorkerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.WarningWindow.RunWarning;
import util.ResultMessage;
import vo.ClientVO;
import vo.HotelVO;
import vo.NetsaleVO;
import vo.WorkerVO;

public class AddHotelController {
	@FXML
	TextField hotelid;
	@FXML
	TextField hotelname;
	@FXML
	TextField level;
	
	
	
	
	@FXML
	Button add;
	
	public static RunView rv;
	WorkerVO workervo;
	public void initialize() {
		
	}
	public void AddClicked(){
//		rv.getPrimaryStage().close();
		if(hotelid.getText().length()==0||hotelname.getText().length()==0
				||level.getText().length()==0){
			RunWarning runWarning =new RunWarning();
			runWarning.SetWarning("信息不能为空！");
			runWarning.start(new Stage());
		}else{
		
		
		
		try {
			
				HotelController controller=new HotelController();
				HotelVO vo=new HotelVO(hotelid.getText(), hotelname.getText(), " "," ", Integer.parseInt(level.getText()), 0,
						" ", " ", " ", " ");
				ResultMessage resultMessage=controller.addHotel(vo);
				if(resultMessage!=ResultMessage.SUCCESS){
				RunWarning runWarning =new RunWarning();
				runWarning.SetWarning("酒店id已存在！请重试！");
				runWarning.start(new Stage());
				//删除之前的酒店vo
				
				}else{
					RunWarning runWarning =new RunWarning();
					runWarning.SetWarning("添加成功！");
					runWarning.start(new Stage());
				}
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		}
	}
	
	public void SetRunView(RunView runview){
		this.rv=runview;
		
		this.workervo=runview.workerVO;
//		initialize();
//		workerid.setText(workervo.getUserId().get());
//		
//		
//		hotelid.setText(workervo.getHotel_id().get());
//		save.setText("保存修改");
		
		
//		System.out.println("gg"+clientvo.getUserId().get());
		
	}

}
