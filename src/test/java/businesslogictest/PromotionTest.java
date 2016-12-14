package businesslogictest;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.controllerfactory.ControllerFactory;
import businesslogic.promotionbl.PromotionController;
import vo.MemberPromotionVO;
import vo.PromotionVO;

public class PromotionTest {

	PromotionController promotionController;
	
	@Before
	public void init() throws RemoteException{
		promotionController = (PromotionController) ControllerFactory.getPromotionBLServiceInstance();
	}
	
	/**
	@Test 获得促销策略 测试成功
	public void testGetPromotion(){
		String name = "双十一促销策略";
		
		PromotionVO vo = new PromotionVO();
		
		vo = promotionController.getPromotion(name);
		
		System.out.println(vo.getPromotionName());
		System.out.println(vo.getPromoitonObject());
		System.out.println(vo.getTime());
		System.out.println(vo.getCount());
		System.out.println(vo.getSeller());
	}
	*/
	
	/**
	@Test 获得所有促销策略 测试成功
	public void testGetAllPromotion(){
		ArrayList<PromotionVO> list = new ArrayList<>();
		
		list = promotionController.getAllPromotion();
		
		for(PromotionVO vo : list){
			System.out.println(vo.getPromotionName());
			System.out.println(vo.getPromoitonObject());
			System.out.println(vo.getTime());
			System.out.println(vo.getCount());
			System.out.println(vo.getSeller());
			System.out.println();
		}
	}
	*/
	
	/**
	@Test 添加促销策略 测试成功
	public void testAddPromotion(){
		PromotionVO vo = new PromotionVO("酒店开店促销策略","ALL",9.5,"2016-12-01 to 2016-12-07","h002");
		
		promotionController.addPromotion(vo);
		
	}
	*/
	
	/**
	@Test 修改促销策略 测试成功
	public void testModify(){
		PromotionVO vo = new PromotionVO("酒店开店促销策略","ALL",9,"2016-12-02 to 2016-12-10","h003");
	
		promotionController.modifyPromotion(vo);
	}
	*/
	
	/**
	@Test 删除促销策略 测试成功
	public void testDelPromotion(){
		PromotionVO vo = new PromotionVO("酒店开店促销策略","ALL",9,"2016-12-02 to 2016-12-10","h003");
		
		promotionController.delPromotion(vo);
	}
	*/
	
	/** 
	@Test 获得会员促销策略 测试成功
	public void testGetMemberPromotion(){
		String name = "会员特定商圈专属折扣";
		
		MemberPromotionVO vo = new MemberPromotionVO();
		
		vo = promotionController.getMemberPromotion(name);
		
		System.out.println(vo.getPromotionName());
		System.out.println(vo.getPromotionObject());
		System.out.println(vo.getTime());
		System.out.println(vo.getCount());
		System.out.println(vo.getArea());
	}
	*/
}
