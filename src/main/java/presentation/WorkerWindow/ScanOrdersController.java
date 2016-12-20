package presentation.WorkerWindow;

import java.rmi.RemoteException;
import java.util.ArrayList;

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
import javafx.util.Callback;
import vo.OrderVO;

public class ScanOrdersController {
	//订单号
	@FXML
	Label orderid;
	
	//订单开始时间
	@FXML
	Label begintime;
	
	//订单最晚执行时间
	@FXML
	Label latestime;
	
	//退房时间
	@FXML
	Label endtime;
	
	//实际执行时间
	@FXML
	Label realtime;
	
	//预计人数
	@FXML
	Label numofpeople;
	
	//有无儿童
	@FXML
	Label haschild;
	
	//订单状态
	@FXML
	Label state;
	
	//未执行订单按钮
	@FXML
	Button unexecuted;
	
	//已执行订单按钮
	@FXML
	Button executed;
	
	//异常订单按钮
	@FXML
	Button abnormal;
	
	//已撤销订单按钮
	@FXML
	Button undo;
	
//	@SuppressWarnings("rawtypes")
	@FXML
	TableView<OrderVO>  tableView;
	
	@FXML
	TableColumn<OrderVO, String> ordercolum;
	@FXML
	TableColumn<OrderVO,Boolean> viewColumn;
	
	//获得所有已执行*****订单
	ArrayList<OrderVO> allList;
	static ArrayList<OrderVO> currentList;
	ArrayList<OrderVO> historyList;
	ArrayList<OrderVO> abnormalList;
	ArrayList<OrderVO> undoList;
	
	RunWorker runWorker;
	OrderVO orderVO;
	
	public ScanOrdersController(){
		
	}
	
	public ScanOrdersController GetScanOrdersController(){
		return this;
	}
	
	
	
	@SuppressWarnings("static-access")
	public void initialize() throws RemoteException{
		

		try{
			OrderController controller=new OrderController();
			allList=controller.getAllOrders(runWorker.getWorkerVO().getHotel_id());
		currentList=controller.getUndoOrders(runWorker.getWorkerVO().getHotel_id());
		historyList=controller.getExecutedOrders(runWorker.getWorkerVO().getHotel_id());
		abnormalList=controller.getAbnormalOrders(runWorker.getWorkerVO().getHotel_id());
		undoList=controller.getReversedOrders(runWorker.getWorkerVO().getHotel_id());

		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public  void executedClicked(){
		ObservableList<OrderVO> currentListData
        = FXCollections.observableArrayList();
		currentListData.addAll(historyList);
		tableView.setItems(currentListData);
		ordercolum.setCellValueFactory(cellData->cellData.getValue().getOrder_id());
		
		viewColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OrderVO, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<OrderVO, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue()!=null);
            }
        });

        viewColumn.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() {
            @Override
            public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> p) {
            	ButtonCellScanOrder bc=new ButtonCellScanOrder();
            	bc.SetViewcontrol(GetScanOrdersController());
                return bc;
            }
        });
	}
	
	public void unexecutedClicked(){
		ObservableList<OrderVO> unexecutedListData
		=FXCollections.observableArrayList();
		unexecutedListData.addAll(currentList);
		tableView.setItems(unexecutedListData);
		ordercolum.setCellValueFactory(cellData->cellData.getValue().getOrder_id());
		
		viewColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OrderVO, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<OrderVO, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue()!=null);
            }
        });

        viewColumn.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() {
            @Override
            public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> p) {
            	ButtonCellScanOrder bc=new ButtonCellScanOrder();
            	bc.SetViewcontrol(GetScanOrdersController());
                return bc;
            }
        });
		
	}
	
	public void abnormalClicked(){
		ObservableList<OrderVO> abnormalListData
		=FXCollections.observableArrayList();
		abnormalListData.addAll(abnormalList);
		tableView.setItems(abnormalListData);
		ordercolum.setCellValueFactory(cellData->cellData.getValue().getOrder_id());
		
		viewColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OrderVO, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<OrderVO, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue()!=null);
            }
        });

        viewColumn.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() {
            @Override
            public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> p) {
            	ButtonCellScanOrder bc=new ButtonCellScanOrder();
            	bc.SetViewcontrol(GetScanOrdersController());
                return bc;
            }
        });
	}
	
	public void undoClicked(){
		ObservableList<OrderVO> undoListData
		=FXCollections.observableArrayList();
		undoListData.addAll(undoList);
		tableView.setItems(undoListData);
		ordercolum.setCellValueFactory(cellData->cellData.getValue().getOrder_id());
		
		viewColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OrderVO, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<OrderVO, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue()!=null);
            }
        });

        viewColumn.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() {
            @Override
            public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> p) {
            	ButtonCellScanOrder bc=new ButtonCellScanOrder();
            	bc.SetViewcontrol(GetScanOrdersController());
                return bc;
            }
        });
	}
	
	public  void setRunWorker(RunWorker runWorker) throws RemoteException{
		this.runWorker=runWorker;
		initialize();
	}
	

}
