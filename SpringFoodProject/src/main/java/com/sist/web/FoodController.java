package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
// Model클래스를 알려준다 : Model=클라이언트의 요청을 받아서 처리후에 JSP로 전송 (결과값)
// POJO : 단독으로 수행되는 자바 클래스 
/*
 *     동작 (스프링)
 *     1. web.xml 
 *        DispatcherServlet 생성 => 등록되어 있는 application-*.xml파일을 읽어서 클래스 메모리할당 ,DI처리 => map에 저장
 *        스프링에 존재하는 map에 저장
 *     2. MyBatis가 XML을 읽어서 => id와 sql문장을 map에 저장 
 *        MyBatis에 저장 
 *     ===============================================================================================
 *     @RequestMapping,GetMapping,PostMapping에 맞는 메소드를 호출후 수행 
 */
@Controller
public class FoodController {
    // 필요한 객체 얻기 => 자종 주입 요청 
	@Autowired
	private FoodCategoryDAO cDao;
	
	@Autowired
	private FoodHouseDAO hDao;
	
	// 사용자가 url주소를 food/category.do를 요청하면 밑에 있는 메소드를 호출해라
	// food/category.do?no=1
	
	
	@RequestMapping("food/category.do")
	public String food_category(Model model,String no)
	{
		if(no==null)
			no="1";
		int index=Integer.parseInt(no);
		int start=0;
		int end=0;
		if(index==1)
		{
			start=1;
			end=12;
		}
		else if(index==2)
		{
			start=13;
			end=18;
		}
		else if(index==3)
		{
			start=19;
			end=30;
		}
		
		Map map=new HashMap();
		map.put("start", start);
		map.put("end", end);
		
		List<FoodCategoryVO> list=cDao.foodCategoryListData(map);
		// ViewResolver로 list전송
		model.addAttribute("list", list);
		return "food/category";
	}
	
	@RequestMapping("food/food_list.do")
	// food_list.do?cno=1
	// int cno => 사용자가 요청한 데이터 => request.getParameter("cno")
	// Model model => JSP에 결과값을 전송 => request.setAttribute()
	// 스프링에서 매개변수 => 95%정도 DispatcherServlet에서 매개변수로 값을 받아 온다 
	/*
	 *    food_list.do?no=10&name=aaa
	 *    public String food_list(String no,String name) => String은 처음에 전송 null
	 *    public String food_list(int no,String name)
	 *    
	 *    food_list.do => session이 필요한 경우
	 *    public String food_list(HttpSession session) 
	 *    
	 *    food_insert.do
	 *    public String food_list(FoodHouseVO vo) 
	 *    
	 *    Cookie cookie=new Cookie("key","value") => HttpServletRequest request
	 *    
	 *    <span a="list[0]">
	 *    <span a="list[1]">
	 *    <span a="list[2]">
	 *    public String food_list(List list) 
	 *    
	 *    Spring 기반 
	 *      => Model 
	 *      => MyBatis
	 *      => JSP출력 
	 */
	public String food_list(int cno,Model model)
	{
		List<FoodHouseVO> list=hDao.categoryFoodData(cno);
		for(FoodHouseVO vo:list)
		{
			String s=vo.getPoster();
			s=s.substring(0,s.indexOf("^"));
			vo.setPoster(s);
		}
		FoodCategoryVO cvo=cDao.foodCategoryInfoData(cno);
		// food_list.jsp로 요청 결과값 전송 
		model.addAttribute("cvo", cvo);
		model.addAttribute("list", list);
		return "food/food_list";
	}
	
}











