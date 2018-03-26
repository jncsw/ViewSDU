package Jsoup;

import java.io.IOException;
import java.sql.Timestamp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class Analyse {
	public Analyse(){
		
	}
	public static Article art;
	public Article getArticle(String s,int category) throws IOException {
		// TODO Auto-generated method stub
//		String html = "";
		try{
//		Document doco = Jsoup.connect("http://www.view.sdu.edu.cn/new/2016/0410/79305.html").post();
		System.out.println(s);
		Document
		 doc = Jsoup.connect(s)

		  .data("query",
		"Java")

		  .userAgent("Mozilla")

		  .cookie("auth",
		"token")

		  .timeout(0)
		  
		  
		  .get();
		// 
		Elements el = doc.getElementsByClass("text");
		//获取标题
		Elements tit = el.select("h1");
		String t="";
		t = tit.get(0).text();
		//副标题 
		String sub = el.select("div").get(1).text();
		if(sub.startsWith("发布日期"))sub = "";
		//获取发布日期
		Elements date = doc.getElementsByAttributeValue("class","text_a");
		String da = date.text();
		String da2 = da.substring(5, 24);
//		String da3 = da2.substring(0, 10);
		Timestamp ts = Timestamp.valueOf(da2);
//		String y = da3.substring(0,4);
//		String m = da3.substring(5,7);
//		String d = da3.substring(8,10);
//		String dat = y+m+d;
//		int artdate = Integer.parseInt(dat);
		//获取作者
		String st = doc.getElementsByAttributeValue("class","text_c").text();
		//获取文章内容
		Elements article = doc.getElementsByAttributeValue("class", "text_s");
		dealingURLS(article);
		String cont = article.first().html();
		
//		String art = article.html();
		int web = 4;  
		String baseUrl =s;
		
		art = new Article(t, web, category, st,  ts, cont, baseUrl);
		}catch(Exception e){
			return null;
		}
		return art;
		//
		//图片处理
//		Elements images = doc.select("img");
//		for(int i=0;i<images.size();i++){
//			Element image = images.get(i);
//		String urls = image.absUrl("src");
//		System.out.println(urls);
//		URL   url   =   new   URL(urls); 
//		URLConnection   uc   =   url.openConnection(); 
//		InputStream   is   =   uc.getInputStream(); 
//		File   file   =   new   File( "D:\\"+i+".jpg"); 
//		FileOutputStream   out   =   new   FileOutputStream(file); 
//		int   ii=0; 
//		while   ((ii=is.read())!=-1)   { 
//			out.write(ii); 
//		} 
//		is.close();
//		
//		}
		//图片处理结束
		
	}
	public void dealingURLS(Elements e){
		if(e.isEmpty())return;
		for(int i=0;i<e.size();i++){
			Element el  = e.get(i);
			if(el.hasAttr("href")){
				el=el.attr("href",el.absUrl("href"));
			}else if(el.hasAttr("src")){
				el=el.attr("src",el.absUrl("src"));
			}
			dealingURLS(el.children());
			e.set(i,el);
		}
	}

}
