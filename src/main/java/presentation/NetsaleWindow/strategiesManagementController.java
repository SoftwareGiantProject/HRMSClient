package presentation.NetsaleWindow;


import java.util.ArrayList;

import businesslogic.promotionbl.PromotionController;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;
import presentation.WarningWindow.RunWarning;
import util.ResultMessage;
import vo.PromotionVO;

public class strategiesManagementController {
	//促销名称
	@FXML
	TableView<PromotionVO> allpromotion;
	@FXML
	TableColumn<PromotionVO, String> Promotionname;
	@FXML
	TableColumn<PromotionVO, Boolean> viewcolumn;
	
	//促销名称
	@FXML
	javafx.scene.control.Label straName;
	//促销对象
	@SuppressWarnings("rawtypes")
	@FXML
	ChoiceBox people;
	//促销折扣
	@SuppressWarnings("rawtypes")
	@FXML
	ChoiceBox discount;
	//促销时间
	@FXML
	TextField time;
	
	@FXML
	Button add;
	
	@FXML
	Button delete;
	
	@FXML
	Button modify;
	
	PromotionVO promotionVO;
	RunNetSale runNetSale;
	
	ArrayList<PromotionVO> promotionVOs;
//	draftStrategies draftStrategies;
	
	public strategiesManagementController getdraftStrategiesController(){
		return this;
	}
	
	public strategiesManagementController(){
		
	}
	
	
	@SuppressWarnings("unchecked")
	public void initialize(){
		try {
			PromotionController promotionController=new PromotionController();
		    promotionVOs=promotionController.getAllPromotion();
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		ObservableList<PromotionVO> promotion=FXCollections.observableArrayList();
		try {
			promotion.addAll(promotionVOs);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		allpromotion.setItems(promotion);
		Promotionname.setCellValueFactory(cellData->cellData.getValue().getPromotionName());
		viewcolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<PromotionVO, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<PromotionVO, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue()!=null);
            }
        });

        viewcolumn.setCellFactory(new Callback<TableColumn<PromotionVO,Boolean>, TableCell<PromotionVO,Boolean>>() {
        	@Override
            public TableCell<PromotionVO, Boolean> call(TableColumn<PromotionVO, Boolean> p) {
            	ButtonCellDraft2 bc=new ButtonCellDraft2();
            	bc.SetViewcontrol(getdraftStrategiesController());
                return bc;
            }
		});
		
		
		
		discount.getItems().addAll("9","8","7","6","5","4","3","2","1");
//		discount.setValue("0.9");
		
		people.getItems().addAll("所有人","会员");
//		people.setValue("所有人");
		
	}
	
	@SuppressWarnings("static-access")
	public void modifyClicked(){
		try {
			if(time.getText().length()!=0){
				PromotionVO vo2=new PromotionVO();
				if(people.getValue()=="所有人"){
					vo2=new PromotionVO(straName.getText(), "ALL", Double.parseDouble((String) discount.getValue()), time.getText(), "web");
				}
				else{
					vo2=new PromotionVO(straName.getText(), "MEMBER", Double.parseDouble((String) discount.getValue()), time.getText(), "web");

				}
				
				ResultMessage resultMessage=ResultMessage.FAIL;
				try {
					PromotionController promotionController=new PromotionController();
					resultMessage=promotionController.modifyPromotion(vo2);
					if(resultMessage==ResultMessage.SUCCESS){
						RunWarning rw=new RunWarning();
				        rw.SetWarning("成功修改！");
				        rw.start(new Stage());
					}
					else{
						RunWarning rw=new RunWarning();
				        rw.SetWarning("修改失败！");
				        rw.start(new Stage());
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				

			}
			else{
				RunWarning rw=new RunWarning();
				rw.SetWarning("请重新设置。");
				rw.start(new Stage());

			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
	}
	
	@SuppressWarnings("static-access")
	public void deleteClicked(){
        ResultMessage resultMessage=ResultMessage.FAIL;
		
		try {
			PromotionVO vo3=new PromotionVO();
			vo3=new PromotionVO(straName.getText(), "ALL", Double.parseDouble((String) discount.getValue()), time.getText(), "web");
		    PromotionController pController=new PromotionController();	
			resultMessage=pController.delPromotion(vo3);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if(resultMessage==ResultMessage.SUCCESS){
			RunWarning rw=new RunWarning();
			rw.SetWarning("已删除该促销策略");
			rw.start(new Stage());
		}
		else{
			RunWarning rw=new RunWarning();
			rw.SetWarning("删除失败，请重试！");
			rw.start(new Stage());
		}
	}
	
	public void addClicked(){
		RunAddStrategies2 runAddStrategies2=new RunAddStrategies2();
		try {
			runAddStrategies2.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setNetsale(RunNetSale netSale){
		this.runNetSale=netSale;
		initialize();
		ButtonCellDraft2 bcd=new ButtonCellDraft2();
		this.promotionVO=bcd.getPromotionVO();
	}
	
	
	
	

}
