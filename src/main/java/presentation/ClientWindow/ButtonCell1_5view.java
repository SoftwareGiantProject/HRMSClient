package presentation.ClientWindow;
import businesslogic.hotelbl.HotelController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import presentation.ClientWindow.ClientAnchor1_4Controller;

import vo.OrderVO;

public class ButtonCell1_5view extends TableCell<OrderVO,Boolean> {
	ButtonCell1_5 viewcontrol ;
	public void SetViewcontrol(ButtonCell1_5 controller){
		this.viewcontrol=controller;
		
	}
	
	final Button cellButton = new Button("查看");
	
	ButtonCell1_5view(){
		cellButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
            public void handle(ActionEvent t) {
//                	viewcontrol.OrderClicked();
				
				OrderVO ordervo = getTableView().getItems().get( getIndex() );
//				viewcontrol.hotelLevel.setText(ordervo.getHotel_id().get());
//				viewcontrol.businessCircle.setText(ordervo.getStartTime().get());
//				viewcontrol.checkinTime.setText(ordervo.getExecuteTime().get());
//				viewcontrol.roomType.setText(ordervo.getRoomType().get());
//				viewcontrol.roomNum.setText(Integer.toString(ordervo.getNumber().get()));
//				viewcontrol.peopleNum.setText(Integer.toString(ordervo.getPeople().get()));
//				viewcontrol.price.setText(Integer.toString(ordervo.getOrderPrice().get()));
				viewcontrol.viewcontrol.label1.setText("订单号");
				viewcontrol.viewcontrol.label2.setText("下单时间");
				viewcontrol.viewcontrol.label3.setText("退房时间");
				viewcontrol.viewcontrol.label4.setText("房间类型");
				viewcontrol.viewcontrol.label5.setText("人员数量");
				viewcontrol.viewcontrol.label6.setText("房间数量");
				viewcontrol.viewcontrol.label7.setText("订单金额");
				
				viewcontrol.viewcontrol.hotelName.setText(ordervo.getOrder_id().get());
				viewcontrol.viewcontrol.businessCircle.setText(ordervo.getStartTime().get());
				viewcontrol.viewcontrol.hotelAddress.setText(ordervo.getEndTime().get());
				viewcontrol.viewcontrol.hotelLevel.setText(ordervo.getRoomType().get());
				viewcontrol.viewcontrol.hotelIntro.setText(String.valueOf(ordervo.getPeople().get()));
				viewcontrol.viewcontrol.hotelServe.setText(String.valueOf(ordervo.getNumber().get()));
				viewcontrol.viewcontrol.hotelEvaluation.setText(String.valueOf(ordervo.getOrderPrice().get()));
				
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
