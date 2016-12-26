package presentation.ClientWindow;


import businesslogic.hotelbl.HotelController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.stage.Stage;
import presentation.ClientWindow.ClientAnchor1_4Controller;
import vo.HotelVO;
import vo.OrderVO;

public class ButtonCell1_6View extends TableCell<HotelVO,Boolean> {
	ClientAnchor1_6Controller viewcontrol ;
	public void SetViewcontrol(ClientAnchor1_6Controller controller){
		this.viewcontrol=controller;
		
	}
	
	final Button cellButton = new Button("查看");
	
	ButtonCell1_6View(){
		cellButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
            public void handle(ActionEvent t) {
//                	viewcontrol.OrderClicked();
				try{
				HotelVO hotelvo = getTableView().getItems().get( getIndex() );
//				String hotelid=ordervo.getHotel_id().get();
//				HotelController hotelController=new HotelController();
//				viewcontrol.hotelLevel.setText(hotelController.getNmaeById(hotelid));
//				viewcontrol.businessCircle.setText(hotelController.viewHotel(hotelController.getNmaeById(hotelid)).getHotelArea().get());
//				viewcontrol.checkinTime.setText(ordervo.getExecuteTime().get());
//				viewcontrol.roomType.setText(ordervo.getRoomType().get());
//				viewcontrol.roomNum.setText(Integer.toString(ordervo.getNumber().get()));
//				viewcontrol.peopleNum.setText(Integer.toString(ordervo.getPeople().get()));
//				viewcontrol.price.setText(Integer.toString(ordervo.getOrderPrice().get()));
				RunClient1 runClient1=new RunClient1();
				runClient1.SetAnchor1(9);
				runClient1.SetHotelVO(hotelvo);
				runClient1.start(new Stage());
				viewcontrol.runClient.getPrimaryStage().close();
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

