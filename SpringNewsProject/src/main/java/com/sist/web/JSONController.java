package com.sist.web;
// http://www.weather.go.kr/weather/forecast/mid-term-xml.jsp
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.json.*;
@Controller
public class JSONController {
	@Autowired
    private JSONManager jm;
	
	@RequestMapping("movie/movie_list.do")
	public String movie_movie(String no,Model model)
	{
		if(no==null)
			no="1";
		String json=jm.jsonRead(Integer.parseInt(no));
		model.addAttribute("json", json);
		return "movie/movie_list";
	}
	@RequestMapping("movie/movie.do")
	public String movie()
	{
		return "movie/movie";
	}
}
