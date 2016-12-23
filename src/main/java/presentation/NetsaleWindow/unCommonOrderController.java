package presentation.NetsaleWindow;

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

public class unCommonOrderController {
	@FXML
	TableView<OrderVO> tableView;
	@FXML
	TableColumn<OrderVO, String> orderidlist;
	@FXML
	TableColumn<OrderVO, Boolean> viewcolumn;
	
	@FXML
	Label orderid;
	@FXML
	Label begintime;
	@FXML
	Label latestime;
	@FXML
	Label realexecutetime;
	@FXML
	Label endtime;
	@FXML
	Label numofpeople;
	@FXML
	Label haschild;
	@FXML
	Label state;
	
	@FXML
	Button undohalf;
	
	@FXML
	Button undoall;
	
	ArrayList<OrderVO> abnormallist;
	
	RunNetSale netSale;
	
	
	public unCommonOrderController(){
		
	}
	
	public unCommonOrderController getuncommomOrderController(){
		return this;
	}
	
	public void initialize(){
		try {
//			OrderVO orderVO=new OrderVO();
			OrderController orderController=new OrderController();
			abnormallist=orderController.getAbnormalOrder();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		ObservableList<OrderVO> abnormal
        = FXCollections.observableArrayList();
		try {
			abnormal.addAll(abnormallist);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		tableView.setItems(abnormal);
		orderidlist.setCellValueFactory(CellData->CellData.getValue().getOrder_id());
		
		viewcolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OrderVO, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<OrderVO, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue()!=null);
            }
        });

        viewcolumn.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() {
            @Override
            public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> p) {
            	ButtonCellScanOrder3 bc=new ButtonCellScanOrder3();
            	bc.SetViewcontrol(getuncommomOrderController());
                return bc;
            }
        });
	}
	
	@SuppressWarnings("static-access")
	public void undohalfClicked(){
		ButtonCellScanOrder3 bcs=new ButtonCellScanOrder3();
		OrderVO vo2=bcs.getOrderVO();
		try {
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String time=format.format(date);
			OrderController oController2=new OrderController();
//			vo2=new OrderVO(vo2.getUser_id().get(), vo2.getHotel_id().get(), vo2.getStartTime().get(), vo2.getPredictCheckInTime().get(), vo2.getPredictCheckOutTime().get(), vo2.getRoomType().get(), vo2.getNumber().get(), vo2.getPeople().get(), vo2.isHasChild().get(), ListType.UNDOLIST);
//			ResultMessage resultMessage=oController2.undoOrder(vo2.getUser_id().get(), vo2.getOrder_id().get(),time );
			ResultMessage resultMessage=oController2.cancelAbnormalOrder(vo2.getOrder_id().get(), false, time);
			if(resultMessage==ResultMessage.SUCCESS){
				try{
					RunNetSale rn=new RunNetSale();
					rn.setanchor1(2);
					rn.start(new Stage());
					this.netSale.getPrimaryStage().close();
					}catch (Exception e){
						e.printStackTrace();
					}
				RunWarning runWarning=new RunWarning();
				runWarning.SetWarning("撤销成功！");
				runWarning.start(new Stage());
			}
			else{
				RunWarning runWarning=new RunWarning();
				runWarning.SetWarning("撤销失败！");
				runWarning.start(new Stage());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("static-access")
	public void undoallClicked(){
		ButtonCellScanOrder3 bcs=new ButtonCellScanOrder3();
		OrderVO vo2=bcs.getOrderVO();
		try {
			Date date=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String time=format.format(date);
			OrderController oController2=new OrderController();
//			vo2=new OrderVO(vo2.getUser_id().get(), vo2.getHotel_id().get(), vo2.getStartTime().get(), vo2.getPredictCheckInTime().get(), vo2.getPredictCheckOutTime().get(), vo2.getRoomType().get(), vo2.getNumber().get(), vo2.getPeople().get(), vo2.isHasChild().get(), ListType.UNDOLIST);
//			ResultMessage resultMessage=oController2.undoOrder(vo2.getUser_id().get(), vo2.getOrder_id().get(),time );
			ResultMessage resultMessage=oController2.cancelAbnormalOrder(vo2.getOrder_id().get(), true, time);
			if(resultMessage==ResultMessage.SUCCESS){
//				netSale.getPrimaryStage().close();
//				System.out.println("000000000");
				try{
					RunNetSale rn=new RunNetSale();
					rn.setanchor1(2);
					rn.start(new Stage());
					this.netSale.getPrimaryStage().close();
					}catch (Exception e){
						e.printStackTrace();
					}
				RunWarning runWarning=new RunWarning();
				runWarning.SetWarning("撤销成功！");
				runWarning.start(new Stage());
			}
			else{
				RunWarning runWarning=new RunWarning();
				runWarning.SetWarning("撤销失败！");
				runWarning.start(new Stage());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setNetSale(RunNetSale rSale){
		this.netSale=rSale;
	}
	
	

}
