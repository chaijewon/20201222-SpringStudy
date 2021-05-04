package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipeController {
   @GetMapping("recipe/main.do")
   public String recipe_main()
   {
	   return "recipe/main";
   }
}
