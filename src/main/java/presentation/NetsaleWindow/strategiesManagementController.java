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
import presentation.WorkerWindow.RunAddStrategies;
import presentation.WorkerWindow.RunWorker;
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
	RunWorker runWorker;
	
	ArrayList<PromotionVO> promotionVOs;
//	draftStrategies draftStrategies;
	
	public strategiesManagementController getdraftStrategiesController(){
		return this;
	}
	
	public strategiesManagementController(){
//		this.promotionVO=runWorker.getPromotionVO();
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
		
		
		
		discount.getItems().addAll("0.9","0.8","0.7","0.6","0.5","0.4","0.3","0.2","0.1");
		discount.setValue("0.9");
		
		people.getItems().addAll("所有人","普通会员","企业会员");
		people.setValue("所有人");
		
	}
	
	@SuppressWarnings("static-access")
	public void modifyClicked(){
		PromotionVO vo=promotionVO;
		try {
			if(time.getText()!=null){
//				vo.setPromotionObject(String.valueOf(people.getValue()));
//				vo.setCount((double)discount.getValue());
//				vo.setTime(time.getText());
				ResultMessage resultMessage=ResultMessage.FAIL;
				vo=new PromotionVO(vo.getPromotionName().get(), String.valueOf(people.getValue()), (Double)(discount.getValue()), time.getText(), vo.getSeller().get());
				
				try {
					PromotionController promotionController=new PromotionController();
					resultMessage=promotionController.modifyPromotion(vo);
					if(resultMessage==ResultMessage.SUCCESS){
						RunWarning rw=new RunWarning();
						rw.SetWarning("成功修改！");
						rw.start(new Stage());

					}
					else{
						RunWarning rw=new RunWarning();
						rw.SetWarning("成功失败！");
						rw.start(new Stage());

					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				
//				promotionController.modifyPromotion(promotionVO);
//				RunWarning rw=new RunWarning();
//				rw.SetWarning("成功修改！");
//				rw.start(new Stage());

			}
			else{
				RunWarning rw=new RunWarning();
				rw.SetWarning("请重新设置。");
				rw.start(new Stage());

			}
			
		} catch (Exception e) {
			// TODO: handle exception
//			RunWarning rw=new RunWarning();
//			rw.SetWarning("修改失败！");
//			rw.start(new Stage());
			e.printStackTrace();

		}
	}
	
	@SuppressWarnings("static-access")
	public void deleteClicked(){
		PromotionController pController=new PromotionController();
		ResultMessage resultMessage=ResultMessage.FAIL;
		try {
			resultMessage=pController.delPromotion(promotionVO);
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
		RunAddStrategies runAddStrategies=new RunAddStrategies();
		try {
			runAddStrategies.start(new Stage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setRunWorker(RunWorker worker){
		this.runWorker=worker;
		initialize();
		ButtonCellDraft2 bcd=new ButtonCellDraft2();
		this.promotionVO=bcd.getPromotionVO();
	}
	
	
	
	

}
