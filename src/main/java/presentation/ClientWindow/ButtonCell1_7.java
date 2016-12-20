package presentation.ClientWindow;


import businesslogic.hotelbl.HotelController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import presentation.ClientWindow.ClientAnchor1_7Controller;

import vo.OrderVO;

public class ButtonCell1_7 extends TableCell<OrderVO,Boolean> {
	ClientAnchor1_7Controller viewcontrol ;
	public void SetViewcontrol(ClientAnchor1_7Controller controller){
		this.viewcontrol=controller;
		
	}
	
	final Button cellButton = new Button("查看");
	
	ButtonCell1_7(){
		cellButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
            public void handle(ActionEvent t) {
//                	viewcontrol.OrderClicked();
				try{
				HotelController hotelContr=new HotelController();
				OrderVO ordervo = getTableView().getItems().get( getIndex() );
//				viewcontrol.hotelName.setText(ordervo.getHotel_id().get());//通过hotelid搜索hotel名称
				viewcontrol.businessCircle.setText(ordervo.getStartTime().get());
				viewcontrol.checkinTime.setText(ordervo.getExecuteTime().get());
				viewcontrol.roomType.setText(ordervo.getRoomType().get());
				viewcontrol.operateOrder_id.setText(ordervo.getOrder_id().get());
				
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
