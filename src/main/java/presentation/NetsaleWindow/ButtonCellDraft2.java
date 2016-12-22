package presentation.NetsaleWindow;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

import vo.PromotionVO;

public class ButtonCellDraft2 extends TableCell<PromotionVO, Boolean>{
	strategiesManagementController sController;
	PromotionVO promotionVO;
	
	public void SetViewcontrol(strategiesManagementController strategiesManagementController){
		this.sController=strategiesManagementController;
		
	}

	public PromotionVO getPromotionVO(){
		return this.promotionVO;
	}
	
	final Button cellButton = new Button("查看");
	
	 public ButtonCellDraft2() {
		// TODO Auto-generated constructor stub()
		cellButton.setOnAction(new EventHandler<ActionEvent>(){
			@SuppressWarnings("unchecked")
			@Override
            public void handle(ActionEvent t) {
				
				PromotionVO promotion = getTableView().getItems().get( getIndex() );
				promotionVO=promotion;
				sController.straName.setText(promotion.getPromotionName().get());
				if(promotion.getPromoitonObject().get().equals("ALL")){
					sController.people.setValue("所有人");
				}
				else if(promotion.getPromoitonObject().get().equals("MEMBER")){
					sController.people.setValue("会员");
				}
//				viewcontrol.people.setValue(promotion.getPromoitonObject().get());
				for(int i=1;i<=9;i++){
					if(promotion.getCount().get()==i){
						sController.discount.setValue(String.valueOf(i));
				    }
				}
				
//				viewcontrol.discount.setValue((promotion.getCount()));
				sController.time.setText(promotion.getTime().get());
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
