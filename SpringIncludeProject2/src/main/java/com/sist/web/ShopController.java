package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.dao.*;
@Controller
public class ShopController {
   @Autowired
   private ShopDAO dao;
   
   @GetMapping("shop/list.do")
   public String shop_list(String page,String cno,Model model)
   {
	   if(cno==null)
		   cno="45";
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int rowSize=18;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   
	   map.put("start", start);
	   map.put("end", end);
	   map.put("cno", Integer.parseInt(cno));
	   List<ShopVO> list=dao.shopGoodsListData(map);
	   for(ShopVO vo:list)
	   {
		   String s=vo.getTitle();
		   if(s.length()>13)
		   {
			   s=s.substring(0,13)+"...";
			   vo.setTitle(s);
		   }
	   }
	   int totalpage=dao.shopGoodsTotalPage(Integer.parseInt(cno));
	   model.addAttribute("main_jsp", "../shop/list.jsp");
	   model.addAttribute("list", list);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("cno", cno);
	   return "main/main";
   }
   /*
    *   NO      NOT NULL NUMBER        
		CNO              NUMBER        
		TITLE   NOT NULL VARCHAR2(300) 
		POSTER  NOT NULL VARCHAR2(500) 
		PRICE   NOT NULL VARCHAR2(30)  
		ACCOUNT          NUMBER
    */
   /*
    *   GetMapping : <a> location.href="" , sendRedirect => POST(X),GET
    *   PostMapping : <form method="POST"> , ajax => type='POST'
    */
   @GetMapping("shop/detail.do")
   public String shop_detail(int no,Model model)
   {
	   ShopVO vo=dao.shopGoodsDetailData(no);
	   model.addAttribute("vo", vo);
	   model.addAttribute("main_jsp", "../shop/detail.jsp");
	   return "main/main";
   }
   /*
   @GetMapping(value="vuejs/list.do",produces="text/plain;charset=UTF-8")
   public String vuejs_list()
   {
	   return "vuejs/list";
   }*/
   @PostMapping("shop/input.do")
   public String shop_input(int no,String price,int su,HttpSession session,Model model)
   {
	   String id=(String)session.getAttribute("id");
	   String address=(String)session.getAttribute("address");
	   String tel=(String)session.getAttribute("tel");
	   String email=(String)session.getAttribute("email");
	   String sp=price.replaceAll("[^0-9]", "");
	   // 39500
	   System.out.println("tel:"+tel);
	   System.out.println("id:"+id);
	   System.out.println("address:"+address);
	   System.out.println("email:"+email);
	   System.out.println("sp:"+sp);
	   int total=Integer.parseInt(sp)*su;
	   ShopInputVO vo=new ShopInputVO();
	   vo.setAddress(address);
	   vo.setEmail(email);
	   vo.setTel(tel);
	   vo.setId(id);
	   vo.setGoods_no(no);
	   vo.setGoods_count(su);
	   vo.setTotal_price(total);
	   vo.setGoods_price(Integer.parseInt(sp));
	   // DB
	   dao.shopGoodsInputInsert(vo);
	   //model.addAttribute("main_jsp", "../shop/mypage.jsp");
	   return "redirect:../shop/mypage.do";
   }
   @GetMapping("shop/mypage.do")
   public String shop_mypage(HttpSession session,Model model)
   {
	   String id=(String)session.getAttribute("id");
	   List<ShopInputVO> list=dao.myAdminPageListData(id);
	   model.addAttribute("list", list);
	   model.addAttribute("main_jsp", "../shop/mypage.jsp");
	   return "main/main";
   }
   
   @GetMapping("shop/admin.do")
   public String shop_admin(Model model)
   {
	   List<ShopInputVO> list=dao.adminPageListData();
	   model.addAttribute("list", list);
	   model.addAttribute("main_jsp", "../shop/admin.jsp");
	   return "main/main";
   }
   
   @GetMapping("shop/admin_ok.do")
   public String shop_admin_ok(int no)
   {
	   dao.adminOkUpdate(no);
	   return "redirect:../shop/admin.do";
   }
}





