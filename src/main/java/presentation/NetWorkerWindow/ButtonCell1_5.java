package presentation.NetWorkerWindow;




import businesslogic.hotelbl.HotelController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.stage.Stage;
import presentation.ClientWindow.ClientAnchor1_4Controller;
import presentation.ViewWindow.RunView;
import vo.ClientVO;
import vo.NetsaleVO;
import vo.OrderVO;
import vo.WorkerVO;

public class ButtonCell1_5 extends TableCell<WorkerVO,Boolean> {
	ClientAnchor1_4Controller viewcontrol ;
	public void SetViewcontrol(ClientAnchor1_4Controller controller){
		this.viewcontrol=controller;
		
	}
	
	final Button cellButton = new Button("查看");
	
	ButtonCell1_5(){
		cellButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
            public void handle(ActionEvent t) {
//                	viewcontrol.OrderClicked();
				
				WorkerVO workervo = getTableView().getItems().get( getIndex() );
				//跳转窗口 实现客户查看 修改
				RunView runView=new RunView();
				runView.setAnchor1(3);
				runView.workerVO=workervo;
				runView.start(new Stage());
//				viewcontrol.hotelLevel.setText(ordervo.getHotel_id().get());
//				viewcontrol.businessCircle.setText(ordervo.getStartTime().get());
//				viewcontrol.checkinTime.setText(ordervo.getExecuteTime().get());
//				viewcontrol.roomType.setText(ordervo.getRoomType().get());
//				viewcontrol.roomNum.setText(Integer.toString(ordervo.getNumber().get()));
//				viewcontrol.peopleNum.setText(Integer.toString(ordervo.getPeople().get()));
//				viewcontrol.price.setText(Integer.toString(ordervo.getOrderPrice().get()));
				
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

