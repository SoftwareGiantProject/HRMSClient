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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;
import presentation.WarningWindow.RunWarning;
import util.ListType;
import util.ResultMessage;
import vo.OrderVO;

public class executeOrderController {
	@FXML
	TableView<OrderVO> orderlist;
	@FXML
	TableColumn<OrderVO, String> orderid;
	@FXML
	TableColumn<OrderVO, Boolean> viewcolumn;
	
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
	TextField backtime;
	//实际执行时间
	@FXML
	TextField realexecutetime;
	//预计人数
	@FXML
	Label numofPeople;
	//有无儿童
	@FXML
	Label hasChild;
	//订单状态
	@SuppressWarnings("rawtypes")
	@FXML
	ChoiceBox state;
	//修改按钮
	@FXML
	Button modify;
	
	RunWorker runWorker;
	
	OrderVO orderVO;
	
	static ArrayList<OrderVO> currentList;
	
	public executeOrderController(){
		
		
	}
	
	public executeOrderController getexecuteOrderController(){
		return this;
	}
	
	@SuppressWarnings({ "unchecked", "static-access" })
	public void initialize() throws RemoteException{
		this.orderVO=RunWorker.getOrderVO();
//		System.out.println("hhhhhhhhhhh");
		state.getItems().addAll("已执行","未执行","异常","已撤销");
		state.setValue("未执行");
//		System.out.println("hhhhhhhhhhh");
		
		try{
			OrderController controller=new OrderController();
		currentList=controller.getUndoOrders(runWorker.getWorkerVO().getHotel_id());

		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		ObservableList<OrderVO> currentListData
        = FXCollections.observableArrayList();
		currentListData.addAll(currentListData);
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
		
		
//		num.setText(order1.getText());
//		begintime.setText(orderVO.getPredictCheckInTime().get());
//		latesettime.setText(orderVO.getDeadline().get());
//		numofPeople.setText(String.valueOf(orderVO.getPeople()));
//		boolean child=orderVO.isHasChild().get();
//		if(child==true){
//			hasChild.setText("有");
//		}
//		else{
//			hasChild.setText("无");
//		}
		
		
	}
	
	@SuppressWarnings("static-access")
	public void modifyClicked() throws RemoteException{
		OrderVO vo=orderVO;
		try {
			if(backtime.getText()!=null){
				vo=new OrderVO(vo.getUser_id().get(), vo.getOrder_id().get(), vo.getHotel_id().get(), vo.getStartTime().get(), backtime.getText(), vo.getDeadline().get(), vo.getExecuteTime().get(), vo.getPredictCheckInTime().get(), vo.getPredictCheckOutTime().get(), vo.getRoomType().get(),vo.getNumber().get(), vo.getPeople().get(), vo.isHasChild().get(), vo.getListType(), vo.getOrderPrice().get());
			}
			
			if(realexecutetime.getText()!=null){
				vo=new OrderVO(vo.getUser_id().get(), vo.getOrder_id().get(), vo.getHotel_id().get(), vo.getStartTime().get(), vo.getEndTime().get(), vo.getDeadline().get(), realexecutetime.getText(), vo.getPredictCheckInTime().get(), vo.getPredictCheckOutTime().get(), vo.getRoomType().get(),vo.getNumber().get(), vo.getPeople().get(), vo.isHasChild().get(), vo.getListType(), vo.getOrderPrice().get());
			}
			
			if(state.getValue().equals("未执行")){
				vo=new OrderVO(vo.getUser_id().get(), vo.getOrder_id().get(), vo.getHotel_id().get(), vo.getStartTime().get(), vo.getEndTime().get(), vo.getDeadline().get(), vo.getExecuteTime().get(), vo.getPredictCheckInTime().get(), vo.getPredictCheckOutTime().get(), vo.getRoomType().get(),vo.getNumber().get(), vo.getPeople().get(), vo.isHasChild().get(), ListType.CURRENTLIST, vo.getOrderPrice().get());
			}
			else if(state.getValue().equals("已执行")){
				vo=new OrderVO(vo.getUser_id().get(), vo.getOrder_id().get(), vo.getHotel_id().get(), vo.getStartTime().get(), vo.getEndTime().get(), vo.getDeadline().get(), vo.getExecuteTime().get(), vo.getPredictCheckInTime().get(), vo.getPredictCheckOutTime().get(), vo.getRoomType().get(),vo.getNumber().get(), vo.getPeople().get(), vo.isHasChild().get(), ListType.HISTORYLIST, vo.getOrderPrice().get());
			}
			else if(state.getValue().equals("异常")){
				vo=new OrderVO(vo.getUser_id().get(), vo.getOrder_id().get(), vo.getHotel_id().get(), vo.getStartTime().get(), vo.getEndTime().get(), vo.getDeadline().get(), vo.getExecuteTime().get(), vo.getPredictCheckInTime().get(), vo.getPredictCheckOutTime().get(), vo.getRoomType().get(),vo.getNumber().get(), vo.getPeople().get(), vo.isHasChild().get(), ListType.ABNORMALLIST, vo.getOrderPrice().get());
			}
			else{
				vo=new OrderVO(vo.getUser_id().get(), vo.getOrder_id().get(), vo.getHotel_id().get(), vo.getStartTime().get(), vo.getEndTime().get(), vo.getDeadline().get(), vo.getExecuteTime().get(), vo.getPredictCheckInTime().get(), vo.getPredictCheckOutTime().get(), vo.getRoomType().get(),vo.getNumber().get(), vo.getPeople().get(), vo.isHasChild().get(), ListType.UNDOLIST, vo.getOrderPrice().get());
			}
//			vo=new OrderVO(vo.getUser_id().get(), vo.getOrder_id().get(), vo.getHotel_id().get(), vo.getStartTime().get(), backtime.getText(), vo.getDeadline().get(), realexecutetime.getText(), vo.getPredictCheckInTime().get(), vo.getPredictCheckOutTime().get(), vo.getRoomType().get(),vo.getNumber().get(), vo.getPeople().get(), vo.isHasChild().get(), vo.getListType(), vo.getOrderPrice().get());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
//		orderVO=vo;
//		RunWorker.setOrderVO(orderVO);
		//System.out.println("hhhhhh");
		OrderController oController=new OrderController();
		ResultMessage resultMessage=ResultMessage.FAIL;
		try{
			 resultMessage=oController.modifyOrder(orderVO);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		if(resultMessage==ResultMessage.SUCCESS){
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
	
	public void setRunWorker(RunWorker rWorker) throws RemoteException{
//		System.out.println("hhhhhhhhhhh");
		this.runWorker=rWorker;
		initialize();
//		this.orderVO=RunWorker.getOrderVO();
		ButtonCellexecuteOrder buttonCellexecuteOrder=new ButtonCellexecuteOrder();
		OrderVO vo=buttonCellexecuteOrder.getOrderVO();
		this.orderVO=vo;

		
	}
	


}
