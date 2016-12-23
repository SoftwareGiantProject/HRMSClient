package presentation.WorkerWindow;



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
import vo.OrderVO;

public class executeOrderController {
	@FXML
	TableView<OrderVO> orderlist;
	@FXML
	TableColumn<OrderVO, String> orderid;
	@FXML
	TableColumn<OrderVO, Boolean> viewcolumn;
	
	@FXML
	Label clientid;
	//订单号
	@FXML
	Label num;
	//订单开始时间
	@FXML
	Label begintime;
	//订单最晚执行时间
	@FXML
	Label latesettime;
	//退房时间
	@FXML
	Label backtime;
	//实际执行时间
	@FXML
	Label realexecutetime;
	//预计人数
	@FXML
	Label numofPeople;
	//有无儿童
	@FXML
	Label hasChild;
	//订单状态
	@FXML
	Label state;
	//修改按钮
	@FXML
	Button execute;
	
	@FXML
	Button end;
	
	@FXML
	Button undo;
	
	RunWorker runWorker;
	
	OrderVO orderVO;
	
	static ArrayList<OrderVO> currentList;
	
	public executeOrderController(){
		
		
	}
	
	public executeOrderController getexecuteOrderController(){
		return this;
	}
	
	@SuppressWarnings({ "static-access" })
	public void initialize() throws RemoteException{
		
		try{
			OrderController controller=new OrderController();
		currentList=controller.getUndoOrders(runWorker.getWorkerVO().getHotel_id().get());

		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		//把未执行订单显示到tableview
		ObservableList<OrderVO> currentListData
        = FXCollections.observableArrayList();
		currentListData.addAll(currentList);
		orderlist.setItems(currentListData);
		orderid.setCellValueFactory(cellData->cellData.getValue().getOrder_id());
		
		viewcolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OrderVO, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<OrderVO, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue()!=null);
            }
        });

        viewcolumn.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() {
            @Override
            public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> p) {
            	ButtonCellexecuteOrder bc=new ButtonCellexecuteOrder();
            	bc.SetViewcontrol(getexecuteOrderController());
                return bc;
            }
        });
		
		
		
	}
	
	/**
	 * 点击退房按钮
	 * @throws RemoteException
	 */
	@SuppressWarnings({ "static-access" })
	public void backClicked() throws RemoteException{
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		
		
		OrderController oController=new OrderController();
		ResultMessage resultMessage=ResultMessage.FAIL;
		resultMessage=oController.recordCheckoutTime(num.getText(), time);
		if(resultMessage==ResultMessage.SUCCESS){
			RunWorker run1=new RunWorker();
			run1.SetAnchor1(6);
			run1.start(new Stage());
			this.runWorker.getPrimaryStage().close();
			RunWarning rWarning=new RunWarning();
			rWarning.SetWarning("修改成功！");
			rWarning.start(new Stage());
		}
		else{
			RunWarning rWarning2=new RunWarning();
			rWarning2.SetWarning("修改失败！");
			rWarning2.start(new Stage());
		}
		
	}
	
	
	/**
	 * 点击订单执行按钮
	 */
	@SuppressWarnings("static-access")
	public void executeClicked(){
		  Date date=new Date();
		  DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  String time=format.format(date);
		  String orderid=num.getText();
		  try {
			OrderController orderController=new OrderController();
			ResultMessage resultMessage=ResultMessage.FAIL;
			resultMessage=orderController.evecuteOrder(orderid, time);
			if(resultMessage==ResultMessage.SUCCESS){
				/**
				 * 这边我要做一个刷新，but how？？？？
				 */
//				RunWorker run1=new RunWorker();
//				run1.SetAnchor1(6);
//				run1.start(new Stage());
//				this.runWorker.getPrimaryStage().close();
				RunWarning rWarning=new RunWarning();
				rWarning.SetWarning("修改成功！");
				rWarning.start(new Stage());
			}
			else{
				RunWarning rWarning2=new RunWarning();
				rWarning2.SetWarning("修改失败！");
				rWarning2.start(new Stage());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	}
	
	
	/**
	 * 点击撤销按钮
	 */
	@SuppressWarnings("static-access")
	public void undoClicked(){
		Date date=new Date();
		  DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  String time=format.format(date);
		  String orderid=num.getText();
		  String client=clientid.getText();
		  OrderController orderController;
		try {
			orderController = new OrderController();
			ResultMessage resultMessage=ResultMessage.FAIL;
			resultMessage=orderController.undoOrder(client, orderid, time);
			if(resultMessage==ResultMessage.SUCCESS){
				RunWorker run1=new RunWorker();
				run1.SetAnchor1(6);
				run1.start(new Stage());
				this.runWorker.getPrimaryStage().close();
				RunWarning rWarning=new RunWarning();
				rWarning.SetWarning("修改成功！");
				rWarning.start(new Stage());
			}
			else{
				RunWarning rWarning2=new RunWarning();
				rWarning2.SetWarning("修改失败！");
				rWarning2.start(new Stage());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
		  
	}
	
	public void setRunWorker(RunWorker rWorker) throws RemoteException{
		this.runWorker=rWorker;
		initialize();

		
	}
	


}
