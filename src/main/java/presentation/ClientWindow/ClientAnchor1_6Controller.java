package presentation.ClientWindow;

import java.util.ArrayList;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import vo.ClientVO;

public class ClientAnchor1_6Controller {
	@FXML
	Button searchUp;
	@FXML
	Button searchDown;
	@FXML
	TextField searchField;
	@FXML
	ComboBox<String> star;
	@FXML
	ComboBox<String> city;
	@FXML
	ComboBox<String> businessCircle;
	@FXML
	ComboBox<String> price;
	@FXML
	ComboBox<String> roomType;
	@FXML
	ComboBox<String> sequece;
	@FXML
	TableView<Button> List;	
	@FXML
	TableColumn<String,String> firstColumn;
	
	
	ClientVO client;
	RunClient1 runClient;
	
	@FXML
	Label test;
	
	
	public ClientAnchor1_6Controller(){
		
	}
	

/** CallBack */
    public static Callback<ListView<String>, ListCell<String>> String_CALLBACK = new Callback<ListView<String>, ListCell<String>>() {
        @Override
        public ListCell<String> call(ListView<String> list) { 
        	return new ListCell<String>(){
                @Override
                protected void updateItem(String dep, boolean empty) { 
                    super.updateItem(dep, empty);
                    Label rect = new Label();
                    if (dep != null) {
                        rect.setText(dep);
                        setGraphic(rect);
                    }
                    
                }
            };
        }
    };

	public void initialize(){
		
		city.setAccessibleText("南京");
		test.setText("已连接");
		
		
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
		initialize();
		
	}

}
