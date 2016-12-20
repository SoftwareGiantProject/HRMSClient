package presentation.WorkerWindow;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import util.ListType;
import vo.OrderVO;

public class ButtonCellexecuteOrder extends TableCell<OrderVO,Boolean>{
	executeOrderController viewcontrol;
	
	public OrderVO getOrderVO(){
		OrderVO ordervo = getTableView().getItems().get( getIndex() );
		return ordervo;
	}
	
	public void SetViewcontrol(executeOrderController controller){
		this.viewcontrol=controller;
		
	}
	
	final Button cellButton = new Button("查看");
	
	public ButtonCellexecuteOrder() {
		// TODO Auto-generated constructor stub(){
		cellButton.setOnAction(new EventHandler<ActionEvent>(){
			@SuppressWarnings("unchecked")
			@Override
            public void handle(ActionEvent t) {
				
				OrderVO ordervo = getTableView().getItems().get( getIndex() );
				viewcontrol.orderid.setText(ordervo.getOrder_id().get());
				viewcontrol.begintime.setText(ordervo.getStartTime().get());
				viewcontrol.latesettime.setText(ordervo.getDeadline().get());
				viewcontrol.backtime.setText(ordervo.getEndTime().get());
				viewcontrol.realexecutetime.setText(ordervo.getExecuteTime().get());
				viewcontrol.numofPeople.setText(String.valueOf(ordervo.getPeople().get()));
				if(ordervo.isHasChild().get()==false){
					viewcontrol.hasChild.setText("无");
				}
				else{
					viewcontrol.hasChild.setText("有");
				}
				if(ordervo.getListType()==ListType.CURRENTLIST){
					viewcontrol.state.setValue("未执行");
				}
				else if(ordervo.getListType()==ListType.HISTORYLIST){
					viewcontrol.state.setValue("已执行");
				}
				else if(ordervo.getListType()==ListType.ABNORMALLIST){
					viewcontrol.state.setValue("异常");
				}
				else{
					viewcontrol.state.setValue("撤销订单");
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



