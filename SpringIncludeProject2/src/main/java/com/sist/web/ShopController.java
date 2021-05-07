package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.dao.*;
@Controller
public class ShopController {
   @Autowired
   private ShopDAO dao;
   
   @GetMapping("shop/list.do")
   public String shop_list(Model model)
   {
	   model.addAttribute("main_jsp", "../shop/list.jsp");
	   return "main/main";
   }
}
