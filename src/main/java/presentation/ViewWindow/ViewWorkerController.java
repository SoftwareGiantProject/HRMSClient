package presentation.ViewWindow;

import java.rmi.RemoteException;

import businesslogic.hotelbl.HotelController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import vo.ClientVO;
import vo.WorkerVO;

public class ViewWorkerController {
	@FXML
	Label workerid;
	@FXML
	Label workername;
	@FXML
	Label phone;
	@FXML
	Label hotelid;
	@FXML
	Label hotelname;
	@FXML
	Button close;
	
	public static RunView rv;
	WorkerVO workervo;
	public void initialize() {
		
	}
	public void CloseClicked(){
//		rv.getPrimaryStage().close();
		RunView runView=new RunView();
		runView.setAnchor1(7);
		runView.start(new Stage());
		this.rv.getPrimaryStage().close();
	}
	
	public void SetRunView(RunView runview){
		this.rv=runview;
		
		this.workervo=runview.workerVO;
		initialize();
		workerid.setText(workervo.getUserId().get());
		workername.setText(workervo.getUserName().get());
		phone.setText(workervo.getContact().get());
		hotelid.setText(workervo.getHotel_id().get());
		close.setText("修改");
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
