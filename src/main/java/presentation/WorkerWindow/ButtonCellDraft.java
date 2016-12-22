package presentation.WorkerWindow;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import vo.PromotionVO;

public class ButtonCellDraft extends TableCell<PromotionVO, Boolean>{
	draftStrategiesController viewcontrol;
	PromotionVO promotionVO;
	
	public void SetViewcontrol(draftStrategiesController draft){
		this.viewcontrol=draft;
	}
	
	public PromotionVO getPromotionVO(){
//		PromotionVO promotion = getTableView().getItems().get( getIndex() );
//		return promotion;
		return this.promotionVO;
	}
	
	final Button cellButton = new Button("查看");
	
	 public ButtonCellDraft() {
		// TODO Auto-generated constructor stub()
		cellButton.setOnAction(new EventHandler<ActionEvent>(){
			@SuppressWarnings("unchecked")
			@Override
            public void handle(ActionEvent t) {
				
				PromotionVO promotion = getTableView().getItems().get( getIndex() );
				promotionVO=promotion;
				viewcontrol.straName.setText(promotion.getPromotionName().get());
				if(promotion.getPromoitonObject().get().equals("ALL")){
					viewcontrol.people.setValue("所有人");
				}
				else{
					viewcontrol.people.setValue("会员");
				}
//				viewcontrol.people.setValue(promotion.getPromoitonObject().get());
				for(int i=1;i<=9;i++){
					if(promotion.getCount().get()==i){
					viewcontrol.discount.setValue(String.valueOf(i));
				    }
				}
				
//				viewcontrol.discount.setValue((promotion.getCount()));
				viewcontrol.time.setText(promotion.getTime().get());
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
