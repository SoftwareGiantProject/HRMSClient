package vo;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import util.RoomCondition;

public class RoomVO {

	// 房间类型
	private SimpleStringProperty Room_type=new SimpleStringProperty();

	// 房间价格
	private SimpleIntegerProperty Room_price=new SimpleIntegerProperty();

	// 房间编号
	private SimpleStringProperty Room_number=new SimpleStringProperty();

	// 房间状态
	RoomCondition Room_condition;

	// 酒店编号
	private SimpleStringProperty Hotel_id=new SimpleStringProperty();

	public RoomVO(String rt, int rp, String rnb, String ho, RoomCondition rc) {

		Room_type = new SimpleStringProperty(rt);
		Room_price = new SimpleIntegerProperty(rp);
		Room_number = new SimpleStringProperty(rnb);
		Hotel_id =new SimpleStringProperty( ho);
		Room_condition = rc;
	}

	public RoomVO() {

	}

	public SimpleStringProperty getRoomType() {
		return Room_type;
	}

	public SimpleIntegerProperty getRoomPrice() {
		return Room_price;
	}

	public SimpleStringProperty getRoomNumber() {
		return Room_number;
	}

	public RoomCondition getRoomCondition() {
		return Room_condition;
	}

	public SimpleStringProperty getHotel_id() {
		return Hotel_id;
	}

	public RoomVO getRoomVO() {
		return this;
	}

}
