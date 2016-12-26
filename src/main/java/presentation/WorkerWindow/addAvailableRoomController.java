package presentation.WorkerWindow;





import businesslogic.roombl.RoomController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.WarningWindow.RunWarning;
import util.ResultMessage;
import util.RoomCondition;
import vo.RoomVO;

public class addAvailableRoomController {
	@SuppressWarnings("rawtypes")
	//房间类型
	@FXML
	ChoiceBox cb;
	@FXML
	TextField roomid;
	@FXML
	TextField price;
	@FXML
	TextField hotelid;
	@FXML
	Button add;
	
	RoomVO rVo;
	
	RunWorker runWorker;
	
	
	
	
	public addAvailableRoomController(){
				
	}
	
	/**
	 * 点击增加促销策略
	 */
	
	@SuppressWarnings("static-access")
	public void addClicked(){
		if(cb.getValue()!=null&&roomid.getText().length()!=0&&price.getText().length()!=0&&hotelid.getText().length()!=0){
			RoomVO vo=rVo;
			
			vo=new RoomVO((String) cb.getValue(), Integer.parseInt(price.getText()), roomid.getText(), hotelid.getText(), RoomCondition.UNRESERVED);
			RoomController rController=new RoomController();
			
			try{
				ResultMessage rv1=rController.addRoom(vo);
				if(rv1==ResultMessage.SUCCESS){
					RunWarning rw=new RunWarning();
				    rw.SetWarning("成功添加！");
				    rw.start(new Stage());
				}
				else{
					RunWarning rw=new RunWarning();
				    rw.SetWarning("添加失败！");
				    rw.start(new Stage());
				}
				
			}catch(Exception exception ){
				exception.printStackTrace();
			}
			
			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public void initialize(){
		//初始化choice box
		cb.getItems().addAll("标准间","大床房","商务间");
		cb.setValue("标准间");
	}
	
	public void setRunWorker(RunWorker rw){
		
		this.runWorker=rw;
		initialize();
		
	}
	


}
