package presentation.ViewWindow;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import vo.ClientVO;

public class ViewClientController {
	@FXML
	Label clientid;
	@FXML
	Label clientname;
	@FXML
	Label phone;
	@FXML
	Label credit;
	@FXML
	Label birthday;
	@FXML
	Button close;
	
	public static RunView rv;
	 
    public static ClientVO clientvo;
	public void initialize() {
//		System.out.println("ll"+clientvo.getUserId().get());
		
	}
	public void CloseClicked(){
		rv.getPrimaryStage().close();
	}
	
	public void SetRunView(RunView runview){
		this.rv=runview;
		
		this.clientvo=runview.GetClientVO();
		
//		System.out.println("gg"+clientvo.getUserId().get());
		clientid.setText(clientvo.getUserId().get());
		clientname.setText(clientvo.getUserName().get());
		phone.setText(clientvo.getContact().get());
		credit.setText(String.valueOf(clientvo.getCredit().get()));
		birthday.setText(clientvo.getBirthday().get());
		initialize();
		
	}

}
