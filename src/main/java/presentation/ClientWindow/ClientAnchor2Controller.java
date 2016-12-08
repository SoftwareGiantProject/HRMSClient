package presentation.ClientWindow;

import com.sun.prism.paint.Color;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.stage.Stage;
import presentation.NetWorkerWindow.RunNetworker;

public class ClientAnchor2Controller {
	
	@FXML
	Button viewInfoBt;
	
	@FXML
	Button modifyInfoBt;
	
	@FXML
	Button payCreditBt;
	
	@FXML
	Button viewOrderBt;
	
	@FXML
	Button viewHotelBt;
	
	@FXML
	Button searchHotelBt;
	
	@FXML
	Button undoOrderBt;
	
	@FXML
	Button evaluateOrderBt;
	
	@FXML
	Button reserveHotelBt;
	
	@FXML
	Button memberRegisterBt;
	
	
	
	
	
	
	
	@FXML
	Label type;
	@FXML
	Label name;
	@FXML
	Label id;
	@FXML
	ImageView ClientView;
	
	
	
	
	
	RunClient1 runClient1;
//	RunClient2 runClient2;
//	RunClient3 runClient3;
	
	public ClientAnchor2Controller(){
		
	}
	//点击 维护信息
	public void modifyInfoClicked() throws Exception{
		
		RunClient1 rc=new RunClient1();
		rc.SetAnchor1(2);
		rc.start(new Stage());

		this.runClient1.getPrimaryStage().close();
	}
	
	//点击 查看信息
	public void viewInfoClicked(){
		try{
		RunClient1 rc=new RunClient1();
		rc.SetAnchor1(1);
		rc.start(new Stage());
		this.runClient1.getPrimaryStage().close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	//点击 信用充值
	public void payCreditClicked(){
		try{
			RunClient1 rc=new RunClient1();
			rc.SetAnchor1(3);
			rc.start(new Stage());
			this.runClient1.getPrimaryStage().close();
			}catch (Exception e){
				e.printStackTrace();
			}
		
	}
	
	public void ViewOrderClicked(){
		try{
			RunClient1 rc=new RunClient1();
			rc.SetAnchor1(4);
			rc.start(new Stage());
			this.runClient1.getPrimaryStage().close();
			}catch (Exception e){
				e.printStackTrace();
			}
	}
	
	
	public void ViewHotelClicked(){
		try{
			RunClient1 rc=new RunClient1();
			rc.SetAnchor1(5);
			rc.start(new Stage());
			this.runClient1.getPrimaryStage().close();
			}catch (Exception e){
				e.printStackTrace();
			}
	}
	
	public void SearchHotelClicked(){
		try{
			RunClient1 rc=new RunClient1();
			rc.SetAnchor1(6);
			rc.start(new Stage());
			this.runClient1.getPrimaryStage().close();
			}catch (Exception e){
				e.printStackTrace();
			}
	}
	
	public void UndoOrderClicked(){
		try{
			RunClient1 rc=new RunClient1();
			rc.SetAnchor1(7);
			rc.start(new Stage());
			this.runClient1.getPrimaryStage().close();
			}catch (Exception e){
				e.printStackTrace();
			}
	}
	
	
	public void EvaluateOrderClicked(){
		try{
			RunClient1 rc=new RunClient1();
			rc.SetAnchor1(8);
			rc.start(new Stage());
			this.runClient1.getPrimaryStage().close();
			}catch (Exception e){
				e.printStackTrace();
			}
	}
	
	public void ReserveHotelClicked(){
		try{
			RunClient1 rc=new RunClient1();
			rc.SetAnchor1(9);
			rc.start(new Stage());
			this.runClient1.getPrimaryStage().close();
			}catch (Exception e){
				e.printStackTrace();
			}
	}
	
	public void RegisterMemberClicked(){
		try{
			RunClient1 rc=new RunClient1();
			rc.SetAnchor1(10);
			rc.start(new Stage());
			this.runClient1.getPrimaryStage().close();
			}catch (Exception e){
				e.printStackTrace();
			}
	}
	
	public void initialize(){
		ClientView.setImage(new Image("file:src/lib/Client.png"));
//		viewInfoBt.setStyle("-fx-background-color: slateblue; -fx-text-fill: white;");
		viewInfoBt.setText("信息查看");
//		viewInfoBt.setGraphic(new ImageView(new Image("file:src/lib/Client.png")));
//		viewInfoBt=new Button("信息查看",new ImageView("file:src/lib/Client.png"));
		type.setText("客户");
		name.setText(this.runClient1.GetClientVO().getUserName());
		id.setText(this.runClient1.GetClientVO().getUserId());
		modifyInfoBt.setText("维护信息");
		payCreditBt.setText("信用充值");
		viewOrderBt.setText("浏览订单");
		viewHotelBt.setText("浏览预定过的酒店");
		searchHotelBt.setText("搜索酒店");
		undoOrderBt.setText("撤销订单");
		evaluateOrderBt.setText("订单评价");
		reserveHotelBt.setText("酒店预订");
		memberRegisterBt.setText("注册会员");
		
	}
	
	
	public void setRunClient(RunClient1 runClient){
		this.runClient1=(RunClient1)runClient;
//		this.runClient2=(RunClient2)runClient;
//		this.runClient3=(RunClient3)runClient;
		//添加监听
		initialize();
	}


}
