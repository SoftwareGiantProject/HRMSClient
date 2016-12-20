package presentation.WorkerWindow;





import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import vo.WorkerVO;

public class HotelInfoMenuController {
	//用户头像
	@FXML
	ImageView image;
	//酒店工作人员名字
	@FXML
	Label workername;
	//酒店工作人员id
	@FXML
	Label workerid;
	
	@FXML
	Label hotelid;
	
	//维护酒店信息
	
	@FXML
	Button hotelInfo;
	//录入可用客房
	@FXML
	Button addavailableroom;
	//制定酒店促销策略
	@FXML
	Button draftstrategies;
	//更新入住和退房信息
	@FXML
	Button refreshroom;
	//浏览订单
	@FXML
	Button scanorders;
	//订单执行
	@FXML
	Button executeorders;
	
	RunWorker runWorker;
		WorkerVO workerVO;
	
	public HotelInfoMenuController(){
		
	}
	//点击 维护信息
	public void hotelInfoClicked() throws Exception{
		
		RunWorker rc=new RunWorker();
		rc.SetAnchor1(1);
		rc.start(new Stage());

		this.runWorker.getPrimaryStage().close();
	}
	
	//点击 添加住房
	public void addavailableroomClicked(){
		try{
		RunWorker rc=new RunWorker();
		rc.SetAnchor1(2);
		rc.start(new Stage());
		this.runWorker.getPrimaryStage().close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	//点击 制定促销策略
	public void draftstrategiesClicked(){
		try{
			RunWorker rc=new RunWorker();
			rc.SetAnchor1(3);
			rc.start(new Stage());
			this.runWorker.getPrimaryStage().close();
			}catch (Exception e){
				e.printStackTrace();
			}
		
	}
	
	//点击更新住房信息
	public void refreshroomClicked(){
		try{
			RunWorker rc=new RunWorker();
			rc.SetAnchor1(4);
			rc.start(new Stage());
			this.runWorker.getPrimaryStage().close();
			}catch (Exception e){
				e.printStackTrace();
			}
	}
	
	//点击浏览订单
	public void scanordersClicked(){
		try{
			RunWorker rc=new RunWorker();
			rc.SetAnchor1(5);
			rc.start(new Stage());
			this.runWorker.getPrimaryStage().close();
			}catch (Exception e){
				e.printStackTrace();
			}
	}
	
	
	//点击订单执行
	public void executeordersClicked(){
		try{
			RunWorker rc=new RunWorker();
			rc.SetAnchor1(6);
			rc.start(new Stage());
			this.runWorker.getPrimaryStage().close();
			}catch (Exception e){
				e.printStackTrace();
			}
	}
	
	
	@SuppressWarnings("static-access")
	public void initialize(){
//		@SuppressWarnings("unused")
//		WorkerVO workervo=new WorkerVO();
		this.workerVO=runWorker.getWorkerVO();
		workerid.setText(workerVO.getUserId());
		workername.setText(workerVO.getUserName());
		hotelid.setText(workerVO.getHotel_id());
		
	}
	
	
	public void setRunWorker(RunWorker runworker){
		this.runWorker=(RunWorker)runworker;
//		this.runClient2=(RunClient2)runClient;
//		this.runClient3=(RunClient3)runClient;
		//添加监听
		initialize();
	}


	

}
