package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.manger.*;
@Controller
public class NewsController {
    // Manager클래스 
	@Autowired
	private NewsManager mgr;
	
	@RequestMapping("news/news.do")
	public String news_list(String fd,Model model)
	{
		if(fd==null)
			fd="야구";
		List<Item> list=mgr.naverNeswData(fd);
		model.addAttribute("list", list);
		return "news/news";
	}
}












