package presentation.WarningWindow;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class WarningAnchorController {
	@FXML
	Text text;
	@FXML
	Button close;
	
	String warning;
	
	RunWarning runWarning;
	
	public WarningAnchorController(){
		
	}
	
	public void CloseClicked(){
		this.runWarning.getPrimaryStage().close();
	}
	
	public void initialize(){
		
		warning=RunWarning.GetWarning();
		text.setText(warning);
	}
	public void setRunWarning(RunWarning runWarning){
		this.runWarning=runWarning;
		initialize();
	}
	

}
