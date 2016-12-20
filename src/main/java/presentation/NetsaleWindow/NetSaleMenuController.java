package presentation.NetsaleWindow;





import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import vo.NetsaleVO;

public class NetSaleMenuController {
	@FXML
	ImageView imageView;
	
	@FXML
	Label name;
	
	@FXML
	Label id;
	
	@FXML
	Button strategies;
	
	@FXML
	Button uncommonOrders;
	
	@FXML
	Button credit;
	
	RunNetSale runNetSale;
	NetsaleVO netsaleVO;
	
	public NetSaleMenuController(){
		
	}
	
	

	//点击促销策略管理
	
	public void strategiesClicked(){
		try{
		RunNetSale rn=new RunNetSale();
		rn.setanchor1(1);
			
		rn.start(new Stage());
		this.runNetSale.getPrimaryStage().close();	
//		System.out.println("hhhhhhhhhhhhhh");
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	//点击异常订单管理
	public void uncommonClicked(){
		try{
		RunNetSale rn=new RunNetSale();
		rn.setanchor1(2);
		rn.start(new Stage());
		this.runNetSale.getPrimaryStage().close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	//点击信用充值
	public void creditClicked(){
		try{
		RunNetSale rn=new RunNetSale();
		rn.setanchor1(3);
		rn.start(new Stage());
		this.runNetSale.getPrimaryStage().close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void initialize(){
		
	}
	
	public void setRunNetsale(RunNetSale rn){
		this.runNetSale=(RunNetSale)rn;
//		System.out.println("hhhhh");
		initialize();
	}




}
