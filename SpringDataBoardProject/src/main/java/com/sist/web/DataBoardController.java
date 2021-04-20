package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
// JSP로 요청한 데이터를 보낸다 
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.*;
/*
 *    자바 화면 이동
 *      sendRedirect() => GET => @RequestMapping,@GetMapping
 *    HTML 화면 이동
 *      <a> : GET => @RequestMapping,@GetMapping
 *      <form> GET/POST => @RequestMapping,@PostMapping
 *    JavaScript 화면 이동
 *       location.href="" => GET => @RequestMapping,@GetMapping
 *    Ajax 화면 이동 
 *       type:GET,POST => POST => @RequestMapping,@PostMapping
 *                                ===============
 *                                 GET/POST 동시에 처리가 가능 
 *                                 Spring 4.3이상 
 */
@Controller
public class DataBoardController {
   // 요청 처리 => DataBoardDAO의 객체를 스프링으로 얻어 온다 
   @Resource(name="dataBoardDAO")
   private DataBoardDAO dao;
   
   // 목록 요청 처리 : String 리턴형 => "어떤 파일에 보여주는 확인" 
   // list.do?page=1
   @GetMapping("databoard/list.do")
   public String databoard_list(String page,Model model)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   int rowSize=10;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   
	   Map map=new HashMap();
	   map.put("start", start);
	   map.put("end", end);
	   List<DataBoardVO> list=dao.databoardListData(map);
	   int totalpage=dao.databoardTotalPage();
	   // JSP출력에 필요한 데이터 전송 
	   model.addAttribute("list", list);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   return "databoard/list";
   }
   // 데이터 추가  : 출력 화면 => String
   @GetMapping("databoard/insert.do")
   public String databoard_insert()
   {
	   return "databoard/insert";
   }
   @PostMapping("databoard/insert_ok.do")
   public String databoard_insert_ok(DataBoardVO vo)
   {
	   List<MultipartFile> list=vo.getFiles();
	   if(list==null) // 업로드가 안된 상태
	   {
		   vo.setFilename("");
		   vo.setFilesize("");
		   vo.setFilecount(0);
	   }
	   else // 업로드가 된 상태 
	   {
		   String tempFile="";
		   String tempSize="";		   
		   for(MultipartFile mf:list)
		   {
			   try
			   {
				  String strFile=mf.getOriginalFilename(); 
				  File file=new File("c:\\spring-upload\\"+strFile);
				  mf.transferTo(file);// 서버에 업로드(서버 폴더에 파일 저장)
				  // 오라클에 파일명을 묶어서 저장  a.jpg,b.png,c.jpg
			      tempFile+=strFile+",";
			      tempSize+=file.length()+",";
			   }catch(Exception ex){}
			   
		   }
		   tempFile=tempFile.substring(0,tempFile.lastIndexOf(","));
		   tempSize=tempSize.substring(0,tempSize.lastIndexOf(","));
		   vo.setFilename(tempFile);
		   vo.setFilesize(tempSize);
		   vo.setFilecount(list.size());
	   }
	   dao.databoardInsert(vo);
	   return "redirect:list.do";
   }
   // 상세보기 : 출력 화면 => String
   @GetMapping("databoard/detail.do")
   public String databoard_detail(int no,Model model)
   {
	   DataBoardVO vo=dao.databoardDetailData(no);
	   List<String> fn=new ArrayList<String>();
	   List<String> fs=new ArrayList<String>();
	   String s1=vo.getFilename();
	   String s2=vo.getFilesize();
	  
	  if(vo.getFilecount()!=0)
	  {
		   StringTokenizer st=new StringTokenizer(s1,",");
		   while(st.hasMoreTokens())
		   {
			   fn.add(st.nextToken());
		   }
		   
		   st=new StringTokenizer(s2,",");
		   while(st.hasMoreTokens())
		   {
			   fs.add(st.nextToken());
		   }
		   model.addAttribute("fn", fn);
		   model.addAttribute("fs", fs);
	  }
	   model.addAttribute("vo", vo);
	  
	   return "databoard/detail";
   }
   // 다운로드 : void
   @GetMapping("databoard/download.do")
   public void databoard_download(String fn,HttpServletResponse response)
   {
	   try
	   {
		   File file=new File("c:\\spring-upload\\"+fn);
		   // 파일 정보 얻기 
		   response.setHeader("Content-Disposition", "attachement;filename="
				       +URLEncoder.encode(fn, "UTF-8"));
		   response.setContentLength((int)file.length());
		   
		   BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
		   // 서버에서 파일을 읽어 온다
		   BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());
		   // 다운로드하는 사람에게 파일을 보내준다 
		   byte[] buffer=new byte[1024];
		   int i=0;// 읽은 바이트 
		   while((i=bis.read(buffer, 0, 1024))!=-1) //-1 file end => EOF
		   {
			   // 다운로드하는 사람에게 보내라 
			   bos.write(buffer, 0, i);
		   }
		   bis.close();
		   bos.close();
	   }catch(Exception ex){}
   }
   // 삭제창을 보여준다
   @GetMapping("databoard/delete.do")
   public String databoard_delete(int no,Model model)
   {
	   model.addAttribute("no", no);
	   return "databoard/delete";
   }
}



















