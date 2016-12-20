package presentation.ClientWindow;

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
import javafx.stage.Stage;
import javafx.util.Callback;
import presentation.WarningWindow.RunWarning;
import util.ListType;
import vo.ClientVO;
import vo.OrderVO;

public class ClientAnchor1_4Controller {
	@FXML
	Button allOrder;
	@FXML
	Button currentOrder;
	@FXML
	Button historyOrder;
	@FXML
	Button abnormalOrder;
	@FXML
	Button undoOrder;
	@FXML
	TableView<OrderVO> orderlist;
	@FXML
	TableColumn<OrderVO,String> orderColumn;
	@FXML
	TableColumn<OrderVO,Boolean> viewColumn;
	@FXML
	TableColumn<OrderVO,Boolean> evaluateColumn;
	@FXML
	Label hotelLevel;
	@FXML
	Label businessCircle;
	@FXML
	Label checkinTime;//入住时间
	@FXML
	Label roomType;
	@FXML
	Label roomNum;
	@FXML
	Label peopleNum;
	@FXML
	Label price;
	
	
	RunClient1 runClient1;
	ClientVO client;
	
	ArrayList<OrderVO> allList;
	ArrayList<OrderVO> currentList;
	ArrayList<OrderVO> historyList;
	ArrayList<OrderVO> abnormalList;
	ArrayList<OrderVO> undoList;
	public ClientAnchor1_4Controller(){
		
	}
	
	public ClientAnchor1_4Controller GetClientAnchor1_4Controller(){
		return this;
	}
	
	
	
	
	public void AllOrderClicked(){
		
		ObservableList<OrderVO> allListData
        = FXCollections.observableArrayList();
		allListData.addAll(allList);
		orderlist.setItems(allListData);
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
            	ButtonCell1_4 bc=new ButtonCell1_4();
            	bc.SetViewcontrol(GetClientAnchor1_4Controller());
                return bc;
            }
        });
        evaluateColumn.setVisible(false);
	}
	
	
	
	public void CurrentOrderClicked(){
		ObservableList<OrderVO> currentListData
        = FXCollections.observableArrayList();
		currentListData.addAll(currentList);
		orderlist.setItems(currentListData);
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
            	ButtonCell1_4 bc=new ButtonCell1_4();
            	bc.SetViewcontrol(GetClientAnchor1_4Controller());
                return bc;
            }
        });
        evaluateColumn.setVisible(false);
	}
	
	
	
	public void HistoryOrderClicked(){
		ObservableList<OrderVO> historyListData
        = FXCollections.observableArrayList();
		historyListData.addAll(historyList);
		orderlist.setItems(historyListData);
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
            	ButtonCell1_4 bc=new ButtonCell1_4();
            	bc.SetViewcontrol(GetClientAnchor1_4Controller());
                return bc;
            }
        });
        evaluateColumn.setVisible(true);
        //评价的按钮列的添加
        evaluateColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OrderVO, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<OrderVO, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue()!=null);
            }
        });

        evaluateColumn.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() {
            @Override
            public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> p) {
            	ButtonCell1_4Evaluate bc=new ButtonCell1_4Evaluate();
            	bc.SetViewcontrol(GetClientAnchor1_4Controller());
                return bc;
            }
        });
        
        
        
	}
	
	
	
	
	public void AbnormalOrderClicked(){
		ObservableList<OrderVO> abnormalListData
        = FXCollections.observableArrayList();
		abnormalListData.addAll(abnormalList);
		
		orderlist.setItems(abnormalListData);
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
            	ButtonCell1_4 bc=new ButtonCell1_4();
            	bc.SetViewcontrol(GetClientAnchor1_4Controller());
                return bc;
            }
        });
        
        evaluateColumn.setVisible(false);
	}
	
	
	
	public void UndoOrderClicked(){
		
		ObservableList<OrderVO> undoListData
        = FXCollections.observableArrayList();
		undoListData.addAll(undoList);
		orderlist.setItems(undoListData);
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
            	ButtonCell1_4 bc=new ButtonCell1_4();
            	bc.SetViewcontrol(GetClientAnchor1_4Controller());
                return bc;
            }
        });
	}
	
	public void initialize(){
		OrderController controller;
		try {
			controller = new OrderController();
			
//			String s="000";
//			int i=0;
//			allList=new ArrayList<>();
//			allList.add(new OrderVO(s,s,s,s,s,s,s,s,s,s,i,i,false,ListType.ALLLIST,i));
			//String user_id,String order_id,String hotel_id,String startTime,String endTime,
			//String deadline,String executeTime,String predictCheckInTime,String predictCheckOutTime,
			//String roomType, int number, int people,boolean hasChild,ListType listType, int orderPrice
			
			
			allList=controller.viewAllOrderByClient(client.getUserId().get());
			undoList=controller.viewReversedOrderByClient(client.getUserId().get());
			historyList=controller.viewExecutedOrderByClient(client.getUserId().get());
			abnormalList=controller.viewAbnormalOrderByClient(client.getUserId().get());
			currentList=controller.viewUndoOrderByClient(client.getUserId().get());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		这个get的方法一定要改
		
		
//		String x="0000";
//		int y=0;
//		boolean z=false;
//		
//		allList=new ArrayList<>();
//		allList.add(new OrderVO(x,x,x,x,x,x,x,x,x,x,y,y,z,ListType.ALLLIST,y));
//		
//		ObservableList<OrderVO> allListData
//        = FXCollections.observableArrayList();
//		allListData.addAll(allList);
//		orderlist.setItems(allListData);
//		orderColumn.setCellValueFactory(cellData->cellData.getValue().getHotel_id());
//		
//		
//		viewColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OrderVO, Boolean>, ObservableValue<Boolean>>() {
//            @Override
//            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<OrderVO, Boolean> p) {
//                return new SimpleBooleanProperty(p.getValue()!=null);
//            }
//        });
//
//        viewColumn.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() {
//            @Override
//            public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> p) {
//                return new ButtonCell1_4();
//            }
//        });

		
		
		
		
	}
	
	public void setRunClient(RunClient1 runClient1){
		this.runClient1=runClient1;
		this.client=runClient1.GetClientVO();
		
		//添加监听
		initialize();
	}

}
