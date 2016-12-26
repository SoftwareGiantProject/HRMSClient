package presentation.ViewWindow;

import java.rmi.RemoteException;

import businesslogic.hotelbl.HotelController;
import businesslogic.userbl.netsale.NetsaleController;
import businesslogic.userbl.worker.WorkerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.WarningWindow.RunWarning;
import util.ResultMessage;
import vo.ClientVO;
import vo.NetsaleVO;
import vo.WorkerVO;

public class ModifyWorkerController {
	@FXML
	Label workerid;
	@FXML
	TextField workername;
	@FXML
	TextField phone;
	@FXML
	Label hotelid;
	@FXML
	Label hotelname;
	@FXML
	Button save;
	
	public static RunView rv;
	WorkerVO workervo;
	public void initialize() {
		
	}
	public void SaveClicked(){
//		rv.getPrimaryStage().close();
		if(workername.getText().length()==0||phone.getText().length()==0){
			RunWarning runWarning =new RunWarning();
			runWarning.SetWarning("请输入新的信息！");
			runWarning.start(new Stage());
		}else{
		WorkerController controller=new WorkerController();
		WorkerVO vo=workervo;
		vo.setUserName(workername.getText());
		vo.setContact(phone.getText());
		try {
			ResultMessage resultMessage=controller.modifyInfo(vo);
			if(resultMessage==ResultMessage.SUCCESS){
				RunWarning runWarning =new RunWarning();
				runWarning.SetWarning("修改成功！");
				runWarning.start(new Stage());
				this.rv.getPrimaryStage().close();
			}else{
				RunWarning runWarning =new RunWarning();
				runWarning.SetWarning("修改失败！");
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
		initialize();
		workerid.setText(workervo.getUserId().get());
		
		
		hotelid.setText(workervo.getHotel_id().get());
		save.setText("保存修改");
		String hn;
		try {
			hn = new HotelController().getNmaeById(workervo.getHotel_id().get());
			hotelname.setText(hn);
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		
//		System.out.println("gg"+clientvo.getUserId().get());
		
	}

}
