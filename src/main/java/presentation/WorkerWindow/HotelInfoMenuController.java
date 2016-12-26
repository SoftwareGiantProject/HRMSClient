package presentation.WorkerWindow;





import businesslogic.hotelbl.HotelController;
import businesslogic.userbl.worker.WorkerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
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
	
	WorkerController workerController;
	
	BorderPane rootLayout;
	
	RunWorker runWorker;
		WorkerVO workerVO;
		
	public void setBorder(){
		this.rootLayout=runWorker.getRootLayout();
	}
	
	public HotelInfoMenuController(){
		
	}
	
	
	//点击 维护信息
	@SuppressWarnings("static-access")
	public void hotelInfoClicked() throws Exception{
		
		RunWorker rc=new RunWorker();
//		String id=runWorker.getWorkerVO().getHotel_id().get();
//		String name=new HotelController().getNmaeById(id);
//		rc.setHotelVO(new HotelController().seekHotel(name));
		rc.SetAnchor1(1);
		rc.setWorkerVO(new WorkerController().getWorkerInfo(RunWorker.getWorkerVO().getUserId().get()));
		rc.start(new Stage());

		this.runWorker.getPrimaryStage().close();
		
	}
	
	//点击 添加住房
	public void addavailableroomClicked(){
		try{
		RunWorker rc=new RunWorker();
		rc.SetAnchor1(2);
		RunWorker.setWorkerVO(new WorkerController().getWorkerInfo(RunWorker.getWorkerVO().getUserId().get()));
		rc.start(new Stage());
		this.runWorker.getPrimaryStage().close();
		}catch (Exception e){
			e.printStackTrace();
		}
		
//		FXMLLoader loader2=new FXMLLoader();
//        loader2.setLocation(HotelInfoMenuController.class.getResource("addAvailbleRoom.fxml"));
//        AnchorPane addAvailbleRoom;
//        System.out.println("Save here");
//		try {
//			addAvailbleRoom = (AnchorPane)loader2.load();
//			
//			rootLayout.setCenter(addAvailbleRoom);
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
	}
	
	//点击 制定促销策略
	public void draftstrategiesClicked(){
		try{
			RunWorker rc=new RunWorker();
			rc.SetAnchor1(3);
			rc.setWorkerVO(new WorkerController().getWorkerInfo(rc.getWorkerVO().getUserId().get()));
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
			rc.setWorkerVO(new WorkerController().getWorkerInfo(rc.getWorkerVO().getUserId().get()));
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
			rc.setWorkerVO(new WorkerController().getWorkerInfo(rc.getWorkerVO().getUserId().get()));
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
			rc.setWorkerVO(new WorkerController().getWorkerInfo(rc.getWorkerVO().getUserId().get()));
			rc.start(new Stage());
			this.runWorker.getPrimaryStage().close();
			}catch (Exception e){
				e.printStackTrace();
			}
	}
	
	/**
	 * 获取酒店工作人员信息
	 * 初始化信息列表
	 */
	@SuppressWarnings("static-access")
	public void initialize(){
		this.workerVO=runWorker.getWorkerVO();
		workerid.setText(workerVO.getUserId().get());
		workername.setText(workerVO.getUserName().get());
		hotelid.setText(workerVO.getHotel_id().get());
		
	}
	
	
	public void setRunWorker(RunWorker runworker){
		this.runWorker=(RunWorker)runworker;
		initialize();
	}


	

}
