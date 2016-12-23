package presentation.WorkerWindow;


import java.util.ArrayList;

import businesslogic.roombl.RoomController;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import util.RoomCondition;
import vo.RoomConditionDateVO;

public class refreshRoomController {
	@FXML
	TableView<RoomConditionDateVO> room;
	
	@FXML
	TableColumn<RoomConditionDateVO, String>  roomid;
	
	@FXML
	TableColumn<RoomConditionDateVO, String> daTableColumn;
	
	@FXML
	TableColumn<RoomConditionDateVO, String> roomstate;
	
	@FXML
	TableColumn<RoomConditionDateVO, Boolean> viewColumn;
	
	ArrayList<RoomConditionDateVO> allroom;
	RunWorker runWorker;
	
	public refreshRoomController(){
		
	}
	
	public refreshRoomController getrefreshRoomController(){
		return this;
	}
	
	@SuppressWarnings("static-access")
	public void initialize(){
		RoomController roomController=new RoomController();
		try{
			allroom=roomController.getRoomConditionByHotel(runWorker.getWorkerVO().getHotel_id().get());
			ObservableList<RoomConditionDateVO> roomListData
            = FXCollections.observableArrayList();
		    roomListData.addAll(allroom);
		    room.setItems(roomListData);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		roomid.setCellValueFactory(cellData->cellData.getValue().getRoomNumber());
		daTableColumn.setCellValueFactory(cellData->cellData.getValue().getRoomDate());
		roomstate.setCellValueFactory(cellData->toSimpleStringProperty(cellData.getValue().getRoomCondition()));
		
		
		viewColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<RoomConditionDateVO, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<RoomConditionDateVO, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue()!=null);
            }
        });

        viewColumn.setCellFactory(new Callback<TableColumn<RoomConditionDateVO, Boolean>, TableCell<RoomConditionDateVO, Boolean>>() {
            @Override
            public TableCell<RoomConditionDateVO, Boolean> call(TableColumn<RoomConditionDateVO, Boolean> p) {
            	ButtonCellrefreshRoom bc=new ButtonCellrefreshRoom();
            	bc.SetViewcontrol(getrefreshRoomController());
                return bc;
            }
        });
		
	}
	
	public SimpleStringProperty toSimpleStringProperty(RoomCondition condition){
		if(condition==RoomCondition.CHECKIN){
			return new SimpleStringProperty("已入住");
		}
		else if(condition==RoomCondition.RESERVED){
			return new SimpleStringProperty("已预定");
		}
		else{
			return new SimpleStringProperty("未预订");
		}
	}
	
	
	
	public void setRunworker(RunWorker runWorker){
		this.runWorker=runWorker;
		initialize();
		System.out.println("hhhhh");
//		setrooms();
	}
	
	public RunWorker getRunWorker(){
		return this.runWorker;
	}
	
}
