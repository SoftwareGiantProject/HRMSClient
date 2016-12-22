package presentation.ClientWindow;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.orderbl.OrderController;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;
import presentation.WarningWindow.RunWarning;
import util.ResultMessage;
import vo.ClientVO;
import vo.OrderVO;

public class ClientAnchor1_7Controller {
	@FXML
	TableView<OrderVO> orderList;
	@FXML
	TableColumn<OrderVO,String> orderColumn;
	@FXML
	TableColumn<OrderVO,Boolean>viewColumn;
	@FXML
	Button currentOrderBt;
	@FXML
	Button abnormalOrderBt;
	@FXML
	Button operate;
	@FXML
	Label hotelName;
	@FXML
	Label businessCircle;
	@FXML
	Label operateOrder_id;
	@FXML 
	Label checkinTime;//入住时间 分清楚 
	@FXML
	Label roomType;
	
	
	
	RunClient1 runClient;
	ClientVO clientvo;
	
	ArrayList<OrderVO> currentList;
	ArrayList<OrderVO> abnormalList;
	
	
	public ClientAnchor1_7Controller GetClient1_7Controller(){
		return this;
	}
	
	public void initialize(){
		try{
		//初始化表格
		OrderController controller=new OrderController();
		currentList=controller.viewReversedOrderByClient(clientvo.getUserId().get());
		abnormalList=controller.viewAbnormalOrderByClient(clientvo.getUserId().get());
		}catch(NullPointerException e){
			e.printStackTrace();
			RunWarning runWarning=new RunWarning();
			runWarning.SetWarning("空指针");
			runWarning.start(new Stage());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void CurrrentOrderClicked(){
		operate.setText("取消订单");
		
		ObservableList<OrderVO> currentListData
        = FXCollections.observableArrayList();
		currentListData.addAll(currentList);
		orderList.setItems(currentListData);
		orderColumn.setCellValueFactory(cellData->cellData.getValue().getOrder_id());
		
		
		viewColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OrderVO, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<OrderVO, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue()!=null);
            }
        });

        viewColumn.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() {
            @Override
            public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> p) {
            	ButtonCell1_7 bc=new ButtonCell1_7();
            	bc.SetViewcontrol(GetClient1_7Controller());
                return bc;
            }
        });
	}
	
	public void AbnormalOrderClicked(){
		operate.setText("订单申诉");
		
		ObservableList<OrderVO> abnormalListData
        = FXCollections.observableArrayList();
		abnormalListData.addAll(abnormalList);
		orderList.setItems(abnormalListData);
		orderColumn.setCellValueFactory(cellData->cellData.getValue().getOrder_id());
		
		
		viewColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OrderVO, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<OrderVO, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue()!=null);
            }
        });

        viewColumn.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() {
            @Override
            public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> p) {
            	ButtonCell1_7 bc=new ButtonCell1_7();
            	bc.SetViewcontrol(GetClient1_7Controller());
                return bc;
            }
        });
	}
	
	public void operateClicked() throws RemoteException{
		if(operate.getText().equals("取消订单")){
			OrderController ordercon=new OrderController();
			Date now=new Date();
			DateFormat sd=new SimpleDateFormat("yyyy-mm-dd hh-mm-ss");
			String time=sd.format(now);
			ResultMessage rm=ordercon.undoOrder(clientvo.getUserId().get(), operateOrder_id.getText(), time);
			if(rm==ResultMessage.SUCCESS){
				RunWarning rw=new RunWarning();
				rw.SetWarning("取消成功！");
				rw.start(new Stage());
			}else{
				RunWarning rw=new RunWarning();
				rw.SetWarning("订单撤销失败，请重试！");
				rw.start(new Stage());
			}
		}else{
			RunWarning rw=new RunWarning();
			rw.SetWarning("订单已经提交申诉，等待客服审核！");
		    rw.start(new Stage());
		}
	}
	
	public void SetRunClient(RunClient1 runClient){
		this.runClient=runClient;
		clientvo=runClient.GetClientVO();
		
	}

}
