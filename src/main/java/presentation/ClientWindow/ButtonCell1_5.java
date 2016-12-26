package presentation.ClientWindow;


import java.util.ArrayList;

import businesslogic.hotelbl.HotelController;
import businesslogic.orderbl.OrderController;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import javafx.util.Callback;
import presentation.ClientWindow.ClientAnchor1_4Controller;
import presentation.WarningWindow.RunWarning;
import vo.HotelVO;
import vo.OrderVO;

public class ButtonCell1_5 extends TableCell<HotelVO,Boolean> {
	ClientAnchor1_5Controller viewcontrol ;
	public void SetViewcontrol(ClientAnchor1_5Controller controller){
		this.viewcontrol=controller;
		
	}
	
	public ButtonCell1_5 GetButtonCell1_5(){
		return this;
	}
	final Button cellButton = new Button("查看");
	
	ButtonCell1_5(){
		cellButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
            public void handle(ActionEvent t) {
//                	viewcontrol.OrderClicked();
				//右侧酒店信息显示
				try{
				HotelVO hotelvo = getTableView().getItems().get( getIndex() );
				viewcontrol.hotelName.setText(hotelvo.getHotelName().get());
				viewcontrol.businessCircle.setText(hotelvo.getHotelArea().get());
				viewcontrol.hotelAddress.setText(hotelvo.getHotelAddress().get());
				viewcontrol.hotelLevel.setText(Integer.toString(hotelvo.getHotel_level().get()));
				viewcontrol.hotelIntro.setText(hotelvo.getHotelIntro().get());
				viewcontrol.hotelServe.setText(hotelvo.getHotelServe().get());
				viewcontrol.hotelEvaluation.setText(String.valueOf(hotelvo.getHotel_score().get()));
				
				viewcontrol.label1.setText("酒店名称");
				viewcontrol.label2.setText("所属商圈");
				viewcontrol.label3.setText("地址");
				viewcontrol.label4.setText("星级");
				viewcontrol.label5.setText("简介");
				viewcontrol.label6.setText("服务");
				viewcontrol.label7.setText("评价");
				
				//显示中间的tableview
//				viewcontrol.orderArray=
				try{
				OrderController controller=new OrderController();
				ArrayList<OrderVO> orderList=
controller.getAllOrderByHotelClient(hotelvo.getHotelId().get(), viewcontrol.clientvo.getUserId().get());
				ObservableList<OrderVO> orderListData =FXCollections.observableArrayList();
				orderListData.addAll(orderList);
				viewcontrol.hotelOrderList.setItems(orderListData);
				
				
				viewcontrol.orderColumn.setCellValueFactory(cellData->cellData.getValue().getOrder_id());
				}catch(NullPointerException e){
					RunWarning runWarning=new RunWarning();
					runWarning.SetWarning("空指针");
					runWarning.start(new Stage());
				}
				
				
				viewcontrol.viewOrderColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OrderVO, Boolean>, ObservableValue<Boolean>>() {
		            @Override
		            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<OrderVO, Boolean> p) {
		                return new SimpleBooleanProperty(p.getValue()!=null);
		            }
		        });

		        viewcontrol.viewOrderColumn.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() {
		            @Override
		            public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> p) {
		            	ButtonCell1_5view bc=new ButtonCell1_5view();
		            	bc.SetViewcontrol(GetButtonCell1_5());
		                return bc;
		            }
		        });
		        
		        
		        viewcontrol.evaluateColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OrderVO, Boolean>, ObservableValue<Boolean>>() {
		            @Override
		            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<OrderVO, Boolean> p) {
		                return new SimpleBooleanProperty(p.getValue()!=null);
		            }
		        });

		        viewcontrol.evaluateColumn.setCellFactory(new Callback<TableColumn<OrderVO, Boolean>, TableCell<OrderVO, Boolean>>() {
		            @Override
		            public TableCell<OrderVO, Boolean> call(TableColumn<OrderVO, Boolean> p) {
		            	ButtonCell1_5Evaluate bc=new ButtonCell1_5Evaluate();
		            	bc.SetViewcontrol(GetButtonCell1_5());
		                return bc;
		            }
		        });
				}catch(Exception e){
					e.printStackTrace();
				}
				
				}
            });
        }

        //Display button if the row is not empty
        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
                setGraphic(cellButton);
            }
        }
}

