package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecommandController {
   @GetMapping("movie/list.do")
   public String movie_list(Model model)
   {
	   String[] category={"상황","감성","스타일","날씨/계절"};
	   model.addAttribute("category", category);
	   return "movie/list";
   }
   
}
