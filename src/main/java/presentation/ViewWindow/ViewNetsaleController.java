package presentation.ViewWindow;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import vo.ClientVO;
import vo.NetsaleVO;

public class ViewNetsaleController {
	@FXML
	Label netsaleid;
	@FXML
	Label netsalename;
	@FXML
	Label phone;
	
	
	@FXML
	Button close;
	
	public static RunView rv;
	 NetsaleVO netsalevo;
	public void initialize() {
		
//		credit.setText(String.valueOf(clientvo.getCredit().get()));
//		birthday.setText(clientvo.getBirthday().get());
	}
	public void CloseClicked(){
		rv.getPrimaryStage().close();
	}
	
	public void SetRunView(RunView runview){
		this.rv=runview;
		
		this.netsalevo=runview.netsaleVO;
//		System.out.println(netsalevo.getUserId().get());
		
		netsaleid.setText(netsalevo.getUserId().get());
		netsalename.setText("gg");
		phone.setText(netsalevo.getContact().get());
		initialize();
//		System.out.println("gg"+clientvo.getUserId().get());
		
	}

}
