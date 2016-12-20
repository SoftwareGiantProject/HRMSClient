package presentation.NetsaleWindow;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

import vo.PromotionVO;

public class ButtonCellDraft2 extends TableCell<PromotionVO, Boolean>{
	strategiesManagementController sController;
	
	public void SetViewcontrol(strategiesManagementController strategiesManagementController){
		this.sController=strategiesManagementController;
		
	}

	public PromotionVO getPromotionVO(){
		PromotionVO promotion = getTableView().getItems().get( getIndex() );
		return promotion;
	}
	
	final Button cellButton = new Button("查看");
	
	 public ButtonCellDraft2() {
		// TODO Auto-generated constructor stub()
		cellButton.setOnAction(new EventHandler<ActionEvent>(){
			@SuppressWarnings("unchecked")
			@Override
            public void handle(ActionEvent t) {
				
				PromotionVO promotion = getTableView().getItems().get( getIndex() );
				sController.straName.setText(promotion.getPromotionName().get());
				sController.people.setValue(promotion.getPromoitonObject().get());
				sController.discount.setValue(promotion.getCount().get());
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
