package com.sist.web;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.vo.*;
import com.sist.dao.*;

@Controller
public class RecipeController {
	@Autowired
    private RecipeDAO rDao;
	
	@GetMapping("recipe/list.do")
	public String recipe_list(String page,Model model)
	{
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);
		Map map=new HashMap();
		int rowSize=12;
		int start=(rowSize*curpage)-(rowSize-1);
		int end=rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		// 목록
		List<RecipeVO> list=rDao.recipeListData(map);
		for(RecipeVO vo:list)
		{
			String s=vo.getTitle();
			if(s.length()>15)
			{
				s=s.substring(0,15)+"...";
				vo.setTitle(s);
			}
		}
		// 총페이지
		int totalpage=rDao.recipeTotalPage();
		// BLOCK 단위 
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1;
		int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
		/*
		 *   1~10page => startPage=1 , endPage=10
		 *   11~20page => startPage=11 , endPage=20
		 *   
		 *   totalpage=19 
		 */
		int allPage=totalpage;
		if(endPage>allPage)
		{
			endPage=allPage;
		}
		
		int count=rDao.recipeCount();
		// JSP에 출력할 데이터를 전송 
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("allPage", allPage);
		model.addAttribute("BLOCK",BLOCK);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("count", count);
		return "recipe/list";
	}
	
	@GetMapping("recipe/detail.do")
	public String recipe_detail(int no,Model model)
	{
		// DAO에서 데이터 읽기 => 해당 JSP로 값을 전송 
		RecipeDetailVO vo=rDao.recipeDetailData(no);
		String[] make=vo.getFood_make().split("\n");// 분리
		vo.setList(Arrays.asList(make));//배열 => List형태로 변경 
		model.addAttribute("vo", vo);
		return "recipe/detail";
	}
	/*
	 *   String[] data= {
			  "밑반찬","메인반찬","국|탕","찌개","초스피드","손님접대","밥|죽|떡","술안주","면|만두",
			  "일상","빵","다이어트","디저트","샐러드","양식","김치|젓갈|장류","도시락","간식",
			  "돼지고기","영양식","과자","양념|소스|잼","차|음료|술","닭고기","야식","채소류","볶음",
			  "스프","소고기","해물류","푸드스타일링","육류","달걀|유제품","부침","조림","이유식",
			  "무침","해장","명절","버섯류","가공식품류","과일류","튀김","끓이기","찜","비빔",
			  "밀가루","건어물류","절임","굽기","삶기","회","쌀","콩|견과류","곡류","데치기","퓨전"  
	  };
	 */
	@GetMapping("recipe/find.do")
	public String recipe_find(Model model)
	{
		String[] data= {
				  "전체","밑반찬","메인반찬","국/탕","찌개","초스피드","손님접대","밥/죽/떡","술안주","면/만두",
				  "일상","빵","다이어트","디저트","샐러드","양식","김치/젓갈/장류","도시락","간식",
				  "돼지고기","영양식","과자","양념/소스/잼","차/음료/술","닭고기","야식","채소류","볶음",
				  "스프","소고기","해물류","푸드스타일링","육류","달걀/유제품","부침","조림","이유식",
				  "무침","해장","명절","버섯류","가공식품류","과일류","튀김","끓이기","찜","비빔",
				  "밀가루","건어물류","절임","굽기","삶기","회","쌀","콩/견과류","곡류","데치기","퓨전"  
		  };
		  model.addAttribute("names", data);
		 return "recipe/find";
	}
	@PostMapping("recipe/find_ok.do")
	public String recipe_find_ok(String no,Model model)
	{
		if(no==null)
			no="0";
		int i=Integer.parseInt(no);
		String[] data= {
				  "전체","밑반찬","메인반찬","국|탕","찌개","초스피드","손님접대","밥|죽|떡","술안주","면|만두",
				  "일상","빵","다이어트","디저트","샐러드","양식","김치|젓갈|장류","도시락","간식",
				  "돼지고기","영양식","과자","양념|소스|잼","차|음료|술","닭고기","야식","채소류","볶음",
				  "스프","소고기","해물류","푸드스타일링","육류","달걀|유제품","부침","조림","이유식",
				  "무침","해장","명절","버섯류","가공식품류","과일류","튀김","끓이기","찜","비빔",
				  "밀가루","건어물류","절임","굽기","삶기","회","쌀","콩/견과류","곡류","데치기","퓨전"  
		  };
		 List<RecipeVO> list=new ArrayList<RecipeVO>();
		 if(i==0)
		 {
			 list=rDao.findAllData();
		 }
		 else
		 {
			 list=rDao.findRequestData(data[i]);
		 }
		 model.addAttribute("list", list);
		 
		 return "recipe/find_ok";
	}
}














