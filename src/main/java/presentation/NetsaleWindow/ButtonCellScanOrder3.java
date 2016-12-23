package presentation.NetsaleWindow;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import util.ListType;
import vo.OrderVO;

public class ButtonCellScanOrder3 extends TableCell<OrderVO, Boolean>{
	unCommonOrderController viewcontrol;
	static OrderVO orderVO;
	
	public void SetViewcontrol(unCommonOrderController un){
		this.viewcontrol=un;
	}
	
	public OrderVO getOrderVO(){
		return this.orderVO;
	}
	
final Button cellButton = new Button("查看");
	
	ButtonCellScanOrder3(){
		cellButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
            public void handle(ActionEvent t) {
				
				orderVO= getTableView().getItems().get( getIndex() );
				viewcontrol.orderid.setText(orderVO.getOrder_id().get());
				viewcontrol.begintime.setText(orderVO.getStartTime().get());
				viewcontrol.latestime.setText(orderVO.getDeadline().get());
				viewcontrol.endtime.setText(orderVO.getEndTime().get());
				viewcontrol.realexecutetime.setText(orderVO.getExecuteTime().get());
				viewcontrol.numofpeople.setText(String.valueOf(orderVO.getPeople().get()));
				if(orderVO.isHasChild().get()==false){
					viewcontrol.haschild.setText("无");
				}
				else{
					viewcontrol.haschild.setText("有");
				}
				if(orderVO.getListType()==ListType.CURRENTLIST){
					viewcontrol.state.setText("未执行");
				}
				else if(orderVO.getListType()==ListType.HISTORYLIST){
					viewcontrol.state.setText("已执行");
				}
				else if(orderVO.getListType()==ListType.ABNORMALLIST){
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
