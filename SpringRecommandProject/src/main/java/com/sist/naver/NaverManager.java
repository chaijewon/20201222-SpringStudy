package com.sist.naver;
// XML => 파싱 (jaxb)
/*
 *   <rss> ====> class => Rss
 *     <channel> ===> class => Channel
 *       <item>  ===> Item
 *        <title>제목</title> => Item 변수 
 *        <description>블로그글</description>
 *       </item>
 *     </channel>
 *   </rss>
 */
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 *  xzCkjdHVMmHBQA5GsaNk
xpoZsdLvAt
 */

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

@Component
public class NaverManager{
	
    public void naverGetData(String finddata) {
        String clientId = "xzCkjdHVMmHBQA5GsaNk"; //애플리케이션 클라이언트 아이디값"
        String clientSecret = "xpoZsdLvAt"; //애플리케이션 클라이언트 시크릿값"
        String text = null;
        try {
            text = URLEncoder.encode(finddata+"에 볼 영화 추천", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패",e);
        }


        //String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text;    // json 결과
        String apiURL = "https://openapi.naver.com/v1/search/blog.xml?display=100&query="+ text; // xml 결과


        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientId);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
        String responseBody = get(apiURL,requestHeaders);


        System.out.println(responseBody);
        try
        {
        	FileWriter fw=new FileWriter("c:\\upload\\recommand.xml");
        	fw.write(responseBody);
        	fw.close();
        }catch(Exception ex){}
    }


    private static String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }


            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 에러 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }


    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }


    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);


        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();


            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }


            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
    
    public List<String> naverBlogData(String finddata)
    {
    	List<String> list=new ArrayList<String>();
    	try
    	{
    		// XML을 저장 
    		naverGetData(finddata);
    		// 파싱 
    		JAXBContext jb=JAXBContext.newInstance(Rss.class);
    		// xml태그를 자바객체로 변환 
    		/*
    		 *   XML => 자바 (Unmarshaller)
    		 *   자바 => XML (Marshaller) 
    		 */
    		Unmarshaller un=jb.createUnmarshaller();
    		Rss rss=(Rss)un.unmarshal(new File("c:\\upload\\recommand.xml"));
    		List<Item> nList=rss.getChannel().getItem();
    		for(Item i:nList)
    		{
    			list.add(i.getDescription());
    		}
    	}catch(Exception ex){}
    	return list;
    }
}














