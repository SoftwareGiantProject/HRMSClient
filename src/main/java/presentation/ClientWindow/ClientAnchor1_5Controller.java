package presentation.ClientWindow;

import java.util.ArrayList;

import businesslogic.hotelbl.HotelController;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import vo.ClientVO;
import vo.HotelVO;
import vo.OrderVO;

public class ClientAnchor1_5Controller {
	@FXML
	TableView<HotelVO> historyHotelList;
	@FXML
	TableView<OrderVO> hotelOrderList;
	@FXML
	TableColumn<HotelVO,String> hotelColumn;
	@FXML
	TableColumn<OrderVO,String>orderColumn;
	@FXML
	TableColumn<HotelVO,Boolean>viewColumn;
	@FXML
	TableColumn<OrderVO,Boolean>viewOrderColumn;
	@FXML
	TableColumn<OrderVO,Boolean>evaluateColumn;
	@FXML
	Label hotelName;
	@FXML
	Label businessCircle;
	@FXML 
	Label hotelAddress;
	@FXML
	Label hotelLevel;
	@FXML
	Label hotelIntro;
	@FXML
	Label hotelServe;
	@FXML
	Label hotelEvaluation;
	
	@FXML
	Label label1;
	@FXML
	Label label2;
	@FXML
	Label label3;
	@FXML
	Label label4;
	@FXML
	Label label5;
	@FXML
	Label label6;
	@FXML
	Label label7;
	
	
	RunClient1 runClient;
	ClientVO clientvo;
	ArrayList<HotelVO> hotelArray;
	ArrayList<OrderVO> orderArray;
	
	
	public ClientAnchor1_5Controller GetClient1_5Controller(){
		return this;
	}
	
	public void initialize(){
		try{
		//初始化表格
		HotelController controller=new HotelController();
		hotelArray=controller.viewReservedHotel(clientvo.getUserId().get());
		
		
		ObservableList<HotelVO> HotelListData
        = FXCollections.observableArrayList();
		HotelListData.addAll(hotelArray);
		historyHotelList.setItems(HotelListData);
		hotelColumn.setCellValueFactory(cellData->cellData.getValue().getHotelName());
		
		
		viewColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HotelVO, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<HotelVO, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue()!=null);
            }
        });

        viewColumn.setCellFactory(new Callback<TableColumn<HotelVO, Boolean>, TableCell<HotelVO, Boolean>>() {
            @Override
            public TableCell<HotelVO, Boolean> call(TableColumn<HotelVO, Boolean> p) {
            	ButtonCell1_5 bc=new ButtonCell1_5();
            	bc.SetViewcontrol(GetClient1_5Controller());
                return bc;
            }
        });
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void SetRunClient(RunClient1 runClient){
		this.runClient=runClient;
		clientvo=runClient.GetClientVO();
		initialize();
		
	}
	
	

}
