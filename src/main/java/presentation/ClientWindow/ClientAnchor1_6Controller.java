package presentation.ClientWindow;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.sound.midi.Sequence;

import businesslogic.hotelbl.HotelController;
import businesslogic.roombl.RoomController;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import presentation.WarningWindow.RunWarning;
import vo.ClientVO;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomVO;

public class ClientAnchor1_6Controller {
	
	@FXML
	Button searchDown;
	
	@FXML
	ComboBox<String> star;
	@FXML
	ComboBox<String> city;
	@FXML
	ComboBox<String> businessCircle;
	@FXML
	TextField leftPrice;
	@FXML
	TextField rightPrice;
	@FXML
	RadioButton reserved;
	@FXML
	ComboBox<String> roomType;
	@FXML
	ComboBox<String> sequece;
	@FXML
	TableView<HotelVO> List;	
	@FXML
	TableColumn<HotelVO,String> HotelColumn;
	@FXML
	TableColumn<HotelVO, Boolean>viewColumn;
	@FXML
	TableColumn<HotelVO, Boolean> isReservedColumn;
	@FXML
	TableColumn<HotelVO, Boolean> canBookColumn;
	
	
	ClientVO client;
	RunClient1 runClient;
	
//	@FXML
//	Label test;
	
	
	public ClientAnchor1_6Controller(){
		
	}
	
	public ClientAnchor1_6Controller GetController(){
		return this;
	}

///** CallBack */
//    public static Callback<ListView<String>, ListCell<String>> String_CALLBACK = new Callback<ListView<String>, ListCell<String>>() {
//        @Override
//        public ListCell<String> call(ListView<String> list) { 
//        	return new ListCell<String>(){
//                @Override
//                protected void updateItem(String dep, boolean empty) { 
//                    super.updateItem(dep, empty);
//                    Label rect = new Label();
//                    if (dep != null) {
//                        rect.setText(dep);
//                        setGraphic(rect);
//                    }
//                    
//                }
//            };
//        }
//    };
	
	private int[] getRank_double(double []a){
		int n = a.length;
		int result[] = new int[n];
		for(int i = 0; i < n; i++){
			result[i] = 0;
		}
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(i == j){
					continue;
				}
				if(a[i] > a[j]){
					++result[i];
				}
			}
		}
		return result;		
	}
	
	private int[] getRank_int(int []a){
		int n = a.length;
		int result[] = new int[n];
		for(int i = 0; i < n; i++){
			result[i] = 0;
		}
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(i == j){
					continue;
				}
				if(a[i] > a[j]){
					++result[i];
				}
			}
		}
		return result;		
	}
	
	/**
	 * 
	 * @param room ArrayList<RoomVO>
	 * @return ArrayList<RoomVO>里面价格最低的RoomVO
	 */
	private RoomVO getCheapestPrice(ArrayList<RoomVO> room){
		if(room.isEmpty()){
			return null;
		}
		int location = 0;
		int judge = room.get(0).getRoomPrice().get();
		for(int i = 1; i < room.size(); i++){
			if(room.get(i).getRoomPrice().get() < judge){
				location = i;
				judge = room.get(i).getRoomPrice().get();
			}
		}
		return room.get(location);

	}
	/**
	 * 对酒店价格从低到高排序的结果
	 * @param hotel
	 * @return
	 */
	private ArrayList<HotelVO> getHotelByPrice(ArrayList<HotelVO> hotel){
		ArrayList<HotelVO> list = hotel;
		ArrayList<HotelVO> result = new ArrayList<>();
		ArrayList<RoomVO> temp = new ArrayList<>();
		ArrayList<RoomVO> contain = new ArrayList<>(); 
		RoomController roomController=new RoomController();
		for(HotelVO lis : list){
			temp = roomController.getAllRoomByHotel(lis.getHotelId().get());
			contain.add(getCheapestPrice(temp));  //获得一个酒店房间价格最便宜的房间po
			}
		
		int price[] = new int [contain.size()];
			for(int i = 0; i < contain.size(); i++){
				price[i] = contain.get(i).getRoomPrice().get();
			}
			
			int rank[] = getRank_int(price);
			
			for(int i = 0; i < contain.size(); i++){
				for(int j = 0; j < contain.size(); j++){
					if(rank[j] == i){
						result.add(list.get(j));
					}
				}
			}
			
			return result;
		
	}
	
	/**
	 * 对酒店评分从高到低排序
	 * @param hotel
	 * @return
	 */
	private ArrayList<HotelVO> getHotelBylevel(ArrayList<HotelVO> hotel){
		ArrayList<HotelVO> list = hotel;
		ArrayList<HotelVO> result = new ArrayList<>();
		double level[] = new double[list.size()];
		
		for(int i = 0; i < list.size(); i++){
			level[i] = list.get(i).getHotel_score().get();
		}
		
		int rank[] = getRank_double(level);
		for(int i = 0; i < list.size(); i++){
			for(int j = 0; j < list.size(); j++){
				if(rank[j] == list.size()-1-i){
					result.add(list.get(j));
				}
			}
		}
		
		return result;
	}
	
	/**
	 * 对酒店按照星级从高到低排序
	 * @param hotel
	 * @return
	 */
	private ArrayList<HotelVO> getHotelByStar(ArrayList<HotelVO> hotel){
		ArrayList<HotelVO> list = hotel;
		ArrayList<HotelVO> result = new ArrayList<>();
		int star[] = new int[list.size()];
		
		for(int i = 0; i < list.size(); i++){
			star[i] = list.get(i).getHotel_level().get();
		}
		int rank[] = getRank_int(star);
		for(int i = 0; i < list.size(); i++){
			for(int j = 0; j < list.size(); j++){
				if(rank[j] == list.size()-1-i){
					result.add(list.get(j));
				}
			}
		}
		return result;
		
	}

	public void SequenceClicked(){
		String sequence=this.sequece.getSelectionModel().getSelectedItem();
		if(sequence.equals("价格从低到高")){
//			HotelVO[] hotelVOs=List.getItems().toArray();
//			ArrayList<HotelVO> arrayList=getHotelByPrice(new ArrayList<HotelVO>().addAll(List.getItems().toArray()));
		}else if(sequence.equals("星级从低到高")){
			
		}else if(sequence.equals("评分从高到低")){
			
		}
	}

	public void searchClicked(){
		//某些检索条件没有选择
		try{
		HotelController controller=new HotelController();
//		controller.search(area, room, star, lowscore, highscore, lowprice, highprice, reserved, client_id)
		int starlevel=-1;
		String room=null;
		int lowprice=-1;
		int highprice=-1;
		if(roomType.getSelectionModel().getSelectedItem()!=null){
			room=roomType.getSelectionModel().getSelectedItem();
		}
		if(star.getSelectionModel().getSelectedItem()!=null){
			starlevel=Integer.parseInt(star.getSelectionModel().getSelectedItem());
		}
		if(leftPrice.getText().length()!=0){
			lowprice=Integer.parseInt(leftPrice.getText());
		}
		if(rightPrice.getText().length()!=0){
			highprice=Integer.parseInt(rightPrice.getText());
		}
		if(businessCircle.getSelectionModel().getSelectedItem()==null){
			RunWarning runWarning=new RunWarning();
			runWarning.SetWarning("请输入商圈！");
		}else{
		
		ArrayList<HotelVO> hotelArray=controller.search(businessCircle.getSelectionModel().getSelectedItem(),
				room, starlevel,-1,-1,
				lowprice, highprice,reserved.isSelected(),
				client.getUserId().get());
		ObservableList<HotelVO> hotelData=FXCollections.observableArrayList(hotelArray);
		List.setItems(hotelData);
		HotelColumn.setCellValueFactory(cellData->cellData.getValue().getHotelName());
		
		viewColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HotelVO, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<HotelVO, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue()!=null);
            }
        });

        viewColumn.setCellFactory(new Callback<TableColumn<HotelVO, Boolean>, TableCell<HotelVO, Boolean>>() {
            @Override
            public TableCell<HotelVO, Boolean> call(TableColumn<HotelVO, Boolean> p) {
            	ButtonCell1_6View bc=new ButtonCell1_6View();
            	bc.SetViewcontrol(GetController());
            	
                return bc;
            }
        });
        
        
        canBookColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HotelVO,Boolean>,ObservableValue<Boolean>>(){
			@Override
			public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<HotelVO, Boolean> param){   
				
					return param.getValue().hasRoom;
				
			}   
		});
		
		canBookColumn.setCellFactory(CheckBoxTableCell.forTableColumn(canBookColumn));
		
		isReservedColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HotelVO,Boolean>,ObservableValue<Boolean>>(){
			@Override
			public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<HotelVO, Boolean> param){   
				
					return param.getValue().getReserved(client.getUserId().get());
				
			}   
		});
		
		isReservedColumn.setCellFactory(CheckBoxTableCell.forTableColumn(isReservedColumn));

		}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void cityChoosed(){
		try {
			
//			city.getItems().clear();
//			
			
			HotelController controller=new HotelController();
//			ArrayList<String> cityList=controller.getAllCity();
//			city.getItems().addAll(cityList);
			if(city.getSelectionModel().getSelectedItem()!=null){
			ArrayList<String> circleList=controller.getAllAreaByCity(city.getSelectionModel().getSelectedItem());
			businessCircle.getItems().clear();
			businessCircle.getItems().addAll(circleList);
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	public void initialize(){
		
		star.getItems().addAll("1","2","3","4","5");
		roomType.getItems().addAll("标准间","大床房","商务间");
//		test.setText("已连接");
		sequece.getItems().addAll("价格从低到高","星级从低到高","评分从高到低");
		try {
			HotelController controller=new HotelController();
			ArrayList<String> cityList=controller.getAllCity();
			city.getItems().addAll(cityList);
			if(city.getSelectionModel().getSelectedItem()!=null){
			ArrayList<String> circleList=controller.getAllAreaByCity(city.getSelectionModel().getSelectedItem());
			businessCircle.getItems().addAll(circleList);
			}
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//添加星级下拉框
//		String[] s={"1","2","3","4","5"
//				
//		};
//		ArrayList<String> starList=new ArrayList<>();
//		starList.toArray(s);
//		ObservableList<String> starItem=FXCollections.observableArrayList(starList);
//		star.setItems(starItem);
//		firstColumn.setCellValueFactory(cellData->cellData.getValue().get);
//		star.setCellFactory(String_CALLBACK);
//		
//
//		//添加价格下拉框
//		String[] p={"200以下","200到400","400以上"
//				
//		};
//		ArrayList<String> priceList=new ArrayList<>();
//		priceList.toArray(p);
//		ObservableList<String> priceItem=FXCollections.observableArrayList(priceList);
//		price.setItems(priceItem);
//		
//		//添加房间类型下拉框
//
//		String[] r={"200以下","200到400","400以上"
//				
//		};
//		ArrayList<String> roomList=new ArrayList<>();
//		roomList.toArray(r);
//		ObservableList<String> roomItem=FXCollections.observableArrayList(roomList);
//		price.setItems(roomItem);
//		
		
		
		
	}
	
	public void setRunClient(RunClient1 runClient){
		this.runClient=runClient;
		client=RunClient1.GetClientVO();
//		initialize();
		
	}

}
