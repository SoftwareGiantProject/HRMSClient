package presentation.ClientWindow;


import businesslogic.hotelbl.HotelController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import presentation.ClientWindow.ClientAnchor1_4Controller;
import vo.HotelVO;
import vo.OrderVO;

public class ButtonCell1_5 extends TableCell<HotelVO,Boolean> {
	ClientAnchor1_5Controller viewcontrol ;
	public void SetViewcontrol(ClientAnchor1_5Controller controller){
		this.viewcontrol=controller;
		
	}
	
	final Button cellButton = new Button("查看");
	
	ButtonCell1_5(){
		cellButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
            public void handle(ActionEvent t) {
//                	viewcontrol.OrderClicked();
				//右侧酒店信息显示
				HotelVO hotelvo = getTableView().getItems().get( getIndex() );
				viewcontrol.hotelName.setText(hotelvo.getHotelName().get());
				viewcontrol.businessCircle.setText(hotelvo.getHotelArea().get());
				viewcontrol.hotelAddress.setText(hotelvo.getHotelAddress().get());
				viewcontrol.hotelLevel.setText(Integer.toString(hotelvo.getHotel_level().get()));
				viewcontrol.hotelIntro.setText(hotelvo.getHotelIntro().get());
				viewcontrol.hotelServe.setText(hotelvo.getHotelServe().get());
				viewcontrol.hotelEvaluation.setText(String.valueOf(hotelvo.getHotel_score().get()));
				
				//显示中间的tableview
//				viewcontrol.orderArray=
				
				
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

