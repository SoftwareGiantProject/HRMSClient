package presentation.WorkerWindow;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import util.ListType;
import vo.OrderVO;

public class ButtonCellScanOrder extends TableCell<OrderVO,Boolean> {
	ScanOrdersController viewcontrol ;
	public void SetViewcontrol(ScanOrdersController controller){
		this.viewcontrol=controller;
		
	}
	
	final Button cellButton = new Button("查看");
	
	ButtonCellScanOrder(){
		cellButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
            public void handle(ActionEvent t) {
				
				OrderVO ordervo = getTableView().getItems().get( getIndex() );
				viewcontrol.orderid.setText(ordervo.getOrder_id().get());
				viewcontrol.begintime.setText(ordervo.getStartTime().get());
				viewcontrol.latestime.setText(ordervo.getDeadline().get());
				viewcontrol.endtime.setText(ordervo.getEndTime().get());
				viewcontrol.realtime.setText(ordervo.getExecuteTime().get());
				viewcontrol.numofpeople.setText(String.valueOf(ordervo.getPeople().get()));
				if(ordervo.isHasChild().get()==false){
					viewcontrol.haschild.setText("无");
				}
				else{
					viewcontrol.haschild.setText("有");
				}
				if(ordervo.getListType()==ListType.CURRENTLIST){
					viewcontrol.state.setText("未执行");
				}
				else if(ordervo.getListType()==ListType.HISTORYLIST){
					viewcontrol.state.setText("已执行");
				}
				else if(ordervo.getListType()==ListType.ABNORMALLIST){
					viewcontrol.state.setText("异常");
				}
				else{
					viewcontrol.state.setText("撤销订单");
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


