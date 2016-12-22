package presentation.ClientWindow;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import businesslogic.hotelbl.HotelController;
import businesslogic.orderbl.OrderController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.stage.Stage;
import presentation.ClientWindow.ClientAnchor1_4Controller;
import presentation.WarningWindow.RunWarning;
import util.ResultMessage;
import vo.OrderVO;

public class ButtonCell1_4Undo extends TableCell<OrderVO,Boolean> {
	ClientAnchor1_4Controller viewcontrol ;
	public void SetViewcontrol(ClientAnchor1_4Controller controller){
		this.viewcontrol=controller;
		
	}
	
	final Button cellButton = new Button("取消");
	
	ButtonCell1_4Undo(){
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
				try{
				OrderController controller=new OrderController();
				Date now=new Date();
				SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
				String time=format.format(now);
				ResultMessage rs=controller.undoOrder(viewcontrol.client.getUserId().get(), ordervo.getOrder_id().get(), time);
				if(rs==ResultMessage.SUCCESS){
					RunWarning rw=new RunWarning();
					rw.SetWarning("取消订单成功！");
					rw.start(new Stage());
				}else{
					RunWarning rw=new RunWarning();
					rw.SetWarning("取消订单失败！");
					rw.start(new Stage());
				}
				
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
