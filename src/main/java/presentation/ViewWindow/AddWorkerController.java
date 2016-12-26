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

public class AddWorkerController {
	@FXML
	TextField workerid;
	@FXML
	TextField workername;
	@FXML
	TextField phone;
	
	@FXML
	PasswordField password;
	@FXML
	TextField hotelid;
	
	@FXML
	Button add;
	
	public static RunView rv;
	WorkerVO workervo;
	public void initialize() {
		
	}
	public void AddClicked(){
//		rv.getPrimaryStage().close();
		if(workername.getText().length()==0||phone.getText().length()==0
				||workerid.getText().length()==0||password.getText().length()==0
				||hotelid.getText().length()==0){
			RunWarning runWarning =new RunWarning();
			runWarning.SetWarning("信息不能为空！");
			runWarning.start(new Stage());
		}else{
		WorkerController controller=new WorkerController();
		WorkerVO workervo=new WorkerVO(workerid.getText(), workername.getText(),hotelid.getText(), password.getText(), phone.getText());
		
		
		try {
			
				ResultMessage resultMessage=controller.addWorker(workervo);
				if(resultMessage!=ResultMessage.SUCCESS){
				RunWarning runWarning =new RunWarning();
				runWarning.SetWarning("酒店工作人员id已存在或该酒店已存在工作人员！请重试！");
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
		initialize();
		workerid.setText(workervo.getUserId().get());
		
		
		hotelid.setText(workervo.getHotel_id().get());
//		save.setText("保存修改");
		
		
//		System.out.println("gg"+clientvo.getUserId().get());
		
	}

}
