package presentation.WorkerWindow;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.stage.Stage;
import vo.RoomConditionDateVO;

public class ButtonCellrefreshRoom extends TableCell<RoomConditionDateVO, Boolean>{
	refreshRoomController viewcontrol;
	static RoomConditionDateVO roomConditionDateVO;
	public void SetViewcontrol(refreshRoomController controller){
		this.viewcontrol=controller;
		
	}
	
	@SuppressWarnings("static-access")
	public RoomConditionDateVO getvo(){
//		RoomConditionDateVO vo1 = getTableView().getItems().get( getIndex() );
		return this.roomConditionDateVO;
//		return vo1;
	}
	
	final Button cellButton = new Button("修改");
	
	public ButtonCellrefreshRoom() {
		// TODO Auto-generated constructor stub
		cellButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
            public void handle(ActionEvent t) {
				roomConditionDateVO= getTableView().getItems().get( getIndex() );
//				System.out.println(roomConditionDateVO.getHotelId().get()+"**************bbbbbbbbbb");
				runModifyRoomCondition run=new runModifyRoomCondition();
				try {
					run.start(new Stage());
				} catch (Exception e) {
					// TODO Auto-generated catch block
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
	
