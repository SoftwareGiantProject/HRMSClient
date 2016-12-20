package presentation.ClientWindow;


import businesslogic.hotelbl.HotelController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import presentation.ClientWindow.ClientAnchor1_4Controller;

import vo.OrderVO;

public class ButtonCell1_4 extends TableCell<OrderVO,Boolean> {
	ClientAnchor1_4Controller viewcontrol ;
	public void SetViewcontrol(ClientAnchor1_4Controller controller){
		this.viewcontrol=controller;
		
	}
	
	final Button cellButton = new Button("查看");
	
	ButtonCell1_4(){
		cellButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
            public void handle(ActionEvent t) {
//                	viewcontrol.OrderClicked();
				
				OrderVO ordervo = getTableView().getItems().get( getIndex() );
				viewcontrol.hotelLevel.setText(ordervo.getHotel_id().get());
				viewcontrol.businessCircle.setText(ordervo.getStartTime().get());
				viewcontrol.checkinTime.setText(ordervo.getExecuteTime().get());
				viewcontrol.roomType.setText(ordervo.getRoomType().get());
				viewcontrol.roomNum.setText(Integer.toString(ordervo.getNumber().get()));
				viewcontrol.peopleNum.setText(Integer.toString(ordervo.getPeople().get()));
				viewcontrol.price.setText(Integer.toString(ordervo.getOrderPrice().get()));
				
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

