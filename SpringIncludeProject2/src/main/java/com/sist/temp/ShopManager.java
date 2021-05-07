package com.sist.temp;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.ShopDAO;
import com.sist.dao.ShopVO;
// https://jjan.shop/product/list.html?cate_no=45 59 83 60
/*
 *   <li id="anchorBoxId_56" class="item hovimg xans-record-">
  <div class="thumbnail">
      
    <div class="prdImg">

            <div class="leftper">
        <div style="display:none;"> <span class="price">0원</span> <span class="sale">39,500원</span> </div>
      </div>
      <div class="leftper2">
        <div style="display:none;"> <span class="price2">39,500원</span> <span class="sale2"></span> </div>
      </div>
      <div class="leftper3">
        <div style="display:none;"> <span class="price3">0원</span> <span class="sale3"></span> </div>
      </div>
         

      <a href="/product/매콤순살염지육-닭갈비용-매콤순살치킨용2kg10kg냉동-수입산/56/category/45/display/1/" name="anchorBoxName_56"><img src="//jjan.shop/web/product/medium/202102/75c294f2350d212977d0f40448b5742d.jpg" onmouseover="this.src='//jjan.shop/web/product/big/202102/ed128d04098986a078c70f0c4737cce4.jpg'" onmouseout="this.src='//jjan.shop/web/product/medium/202102/75c294f2350d212977d0f40448b5742d.jpg'" id="eListPrdImage56_1" alt="매콤순살염지육 닭갈비용 매콤순살치킨용/2kg,10kg/냉동 수입산"/><span class="xans-element- xans-product xans-product-imagestyle xans-record-"><span class="prdIcon ec-product-bgLT" style="background-image:url('/web/upload/image_custom_416058605783943.png');"></span>
</span>
<span class="xans-element- xans-product xans-product-imagestyle xans-record-"><span class="prdIcon ec-product-bgLT" style="background-image:url('/web/upload/image_custom_116058605783192.png');"></span>
</span>
</a> 
<div class="description"> 
    <div class="promotion">     </div>
    <strong class="name"><a href="/product/매콤순살염지육-닭갈비용-매콤순살치킨용2kg10kg냉동-수입산/56/category/45/display/1/" class=""><span class="title displaynone"><span style="font-size:12px;color:#555555;">상품명</span> :</span> <span style="font-size:12px;color:#555555;">매콤순살염지육 닭갈비용 매콤순살치킨용/2kg,10kg/냉동 수입산</span></a></strong>
    
    <ul class="xans-element- xans-product xans-product-listitem spec"><li class=" xans-record-">
<p class="perhan"></p> <strong class="title displaynone"><span style="font-size:12px;color:#555555;">상품요약정보</span> :</strong> <span style="font-size:12px;color:#555555;">뼈없는 매콤 양념 닭다릿살</span></li>
<li class=" xans-record-">
<p class="perhan"></p> <strong class="title displaynone"><span style="font-size:12px;color:#008BCC;font-weight:bold;">판매가</span> :</strong> <span style="font-size:12px;color:#008BCC;font-weight:bold;">39,500원</span><span id="span_product_tax_type_text" style=""> </span></li>
</ul>
 */
@Component
public class ShopManager {
   @Autowired
   private ShopDAO dao;
   public static void main(String[] args) {
	  String[] xml={"application-context.xml","application-datasource.xml"};
	  ApplicationContext app=
			  new ClassPathXmlApplicationContext(xml);
	  ShopManager s=(ShopManager)app.getBean("shopManager");
	  s.shopGetData(60);
   }
   public void shopGetData(int cno)
   {
	   try
	   {
		   // 연결 
		   //for(int i=1;i<=2;i++)
		   {
			   Document doc=Jsoup.connect("https://jjan.shop/product/list.html?cate_no="+cno/*+"&page="+i*/).get();
		       Elements title=doc.select("strong.name a[href*=/product/]");
		       Elements poster=doc.select("div.prdImg img[id*=eListPrdImage]");
		       Elements price=doc.select("div.leftper span.sale");
		       for(int j=0;j<title.size();j++)
		       {
		    	   String ss=title.get(j).attr("href");
		    	   ss=ss.substring(ss.indexOf("t")+2);
		    	   System.out.println(ss.substring(0,ss.indexOf("/")));
		    	   System.out.println(poster.get(j).attr("src"));
		    	   System.out.println(price.get(j).text());
		    	   System.out.println("============================================");
		    	   ShopVO vo=new ShopVO();
		    	   vo.setCno(cno);
		    	   vo.setTitle(ss.substring(0,ss.indexOf("/")));
		    	   vo.setPoster(poster.get(j).attr("src"));
		    	   vo.setPrice(price.get(j).text());
		    	   vo.setAccount((int)(Math.random()*20)+1);
		    	   dao.shopGoodsInsert(vo);
		       }
		   }
	   }catch(Exception ex){}
   }
}











