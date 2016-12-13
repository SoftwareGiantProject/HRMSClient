package businesslogictest;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.controllerfactory.ControllerFactory;
import businesslogic.hotelbl.HotelController;
import vo.HotelVO;

public class HotelTest {

	HotelController hotelController;
	
	@Before
	public void init() throws RemoteException{
		hotelController = (HotelController) ControllerFactory.getHotelBLServiceInstance();
	}
	
	@Test
	public void testNameById(){
		String hotel_id = "h001";
		
		assertEquals("英尊假日酒店",hotelController.getNmaeById(hotel_id));
	}
	
	/**
	@Test 根据Area 获得 hotel 测试成功
	public void testGetHotelByArea(){
		String area = "栖霞区";
		ArrayList<HotelVO> list = new ArrayList<>();
		
		list = hotelController.getHotelByArea(area);
		
		for(HotelVO vo : list){
			System.out.println(vo.getHotelId());
			System.out.println(vo.getHotelName());
			System.out.println(vo.getHotel_level());
			System.out.println(vo.getHotel_score());
			System.out.println(vo.getHotelAddress());
			System.out.println(vo.getHotelArea());
			System.out.println(vo.getHotelIntro());
			System.out.println(vo.getHotelServe());
			System.out.println(vo.getHotelRoom());
			System.out.println(vo.getCity());
		}
	}
	*/
	
	/**
	@Test
	public void testgetHotelByPrice(){
		String area = "栖霞区";
		ArrayList<HotelVO> list = new ArrayList<>();
		
		list = hotelController.getHotelByPrice(area);
		
		for(HotelVO vo : list){
			System.out.println(vo.getHotelId());
			System.out.println(vo.getHotelName());
			System.out.println(vo.getHotel_level());
			System.out.println(vo.getHotel_score());
			System.out.println(vo.getHotelAddress());
			System.out.println(vo.getHotelArea());
			System.out.println(vo.getHotelIntro());
			System.out.println(vo.getHotelServe());
			System.out.println(vo.getHotelRoom());
			System.out.println(vo.getCity());
		}
	}
	*/
	
	/**
	@Test 根据评分 获得所有酒店列表 测试成功
	public void testgetHotelBylevel(){
		String area = "栖霞区";
		ArrayList<HotelVO> list = new ArrayList<>();
		
		list = hotelController.getHotelBylevel(area);
		
		for(HotelVO vo : list){
			System.out.println(vo.getHotelId());
			System.out.println(vo.getHotelName());
			System.out.println(vo.getHotel_level());
			System.out.println(vo.getHotel_score());
			System.out.println(vo.getHotelAddress());
			System.out.println(vo.getHotelArea());
			System.out.println(vo.getHotelIntro());
			System.out.println(vo.getHotelServe());
			System.out.println(vo.getHotelRoom());
			System.out.println(vo.getCity());
		}
	}
	*/
	
	/**
	@Test 根据星级 获得酒店列表 测试成功
	public void testGetHotelByStar(){
		String area = "栖霞区";
		ArrayList<HotelVO> list = new ArrayList<>();
		
		list = hotelController.getHotelByStar(area);
		
		for(HotelVO vo : list){
			System.out.println(vo.getHotelId());
			System.out.println(vo.getHotelName());
			System.out.println(vo.getHotel_level());
			System.out.println(vo.getHotel_score());
			System.out.println(vo.getHotelAddress());
			System.out.println(vo.getHotelArea());
			System.out.println(vo.getHotelIntro());
			System.out.println(vo.getHotelServe());
			System.out.println(vo.getHotelRoom());
			System.out.println(vo.getCity());
		}
	}
	*/
	
	/**
	@Test  根据 酒店名称  浏览酒店信息 测试成功
	public void testViewHotel(){
		String name = "布丁酒店";
		
		HotelVO vo = new HotelVO();
		
		vo = hotelController.viewHotel(name);
		
			System.out.println(vo.getHotelId());
			System.out.println(vo.getHotelName());
			System.out.println(vo.getHotel_level());
			System.out.println(vo.getHotel_score());
			System.out.println(vo.getHotelAddress());
			System.out.println(vo.getHotelArea());
			System.out.println(vo.getHotelIntro());
			System.out.println(vo.getHotelServe());
			System.out.println(vo.getHotelRoom());
			System.out.println(vo.getCity());
	}
	*/
	
	/**
	@Test 获取所有城市 测试成功
	public void testGetAllCity(){
		ArrayList<String> list = new ArrayList<>();
		
		list = hotelController.getAllCity();
		
		for(String s : list){
			System.out.println(s);
		}
	}
	*/
	
	/**
	@Test 根据 城市 获得 商圈 测试成功
	public void testGetAllAreaByCity(){
		String city = "上海";
		
		ArrayList<String>  list = new ArrayList<>();
		
		list = hotelController.getAllAreaByCity(city);
		
		for(String s : list){
			System.out.println(s);
		}
	}
	*/

	/**
	@Test
	public void testSearch(){
		ArrayList<HotelVO> list = new ArrayList<>();
		
		String area = "栖霞区";
		String room = "大床房";
		int star = 4;
		int lowscore = 4;
		int highscore = 5;
		int lowprice = 0;
		int highprice = 1000;
		
		list = hotelController.search(area, room, star, lowscore, highscore, lowprice, highprice);

		System.out.println(list.size());
		for(HotelVO vo : list){
			System.out.println(vo.getHotelId());
			System.out.println(vo.getHotelName());
			System.out.println(vo.getHotel_level());
			System.out.println(vo.getHotel_score());
			System.out.println(vo.getHotelAddress());
			System.out.println(vo.getHotelArea());
			System.out.println(vo.getHotelIntro());
			System.out.println(vo.getHotelServe());
			System.out.println(vo.getHotelRoom());
			System.out.println(vo.getCity());
		}
	}
	 */
	
	/**
	@Test 根据星级 获得酒店列表 测试成功
	public void testSearchByStar(){
		String area = "栖霞区";
		int star = 4;
		
		ArrayList<HotelVO> list = new ArrayList<>();
		
		list = hotelController.searchByStar(area, star);
	
		for(HotelVO vo : list){
			System.out.println(vo.getHotelId());
			System.out.println(vo.getHotelName());
			System.out.println(vo.getHotel_level());
			System.out.println(vo.getHotel_score());
			System.out.println(vo.getHotelAddress());
			System.out.println(vo.getHotelArea());
			System.out.println(vo.getHotelIntro());
			System.out.println(vo.getHotelServe());
			System.out.println(vo.getHotelRoom());
			System.out.println(vo.getCity());
		}
	}
	*/

	/**
	@Test 根据 商圈和房间类型 获得酒店列表
	public void testSearchByRoom(){
		String area = "栖霞区";
		String room = "商务间";
		
		ArrayList<HotelVO> list = new ArrayList<>();
		
		list = hotelController.searchByRoom(area, room);
		
		for(HotelVO vo : list){
			System.out.println(vo.getHotelId());
			System.out.println(vo.getHotelName());
			System.out.println(vo.getHotel_level());
			System.out.println(vo.getHotel_score());
			System.out.println(vo.getHotelAddress());
			System.out.println(vo.getHotelArea());
			System.out.println(vo.getHotelIntro());
			System.out.println(vo.getHotelServe());
			System.out.println(vo.getHotelRoom());
			System.out.println(vo.getCity());
		}
	}
	*/
	
	@Test
	public void testSearchByScore(){
		String area = "栖霞区";
		int lowscore = 4;
		int highscore = 5;
		
		
	}
}
