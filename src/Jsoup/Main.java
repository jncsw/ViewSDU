package Jsoup;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;

public class Main {
	public static String[] tagClass = {
		"colcont_side sdnews_a",
		"toutiao",
		"pleft_left",
		"pleft_right",
		"pright",
		"border_n bg colcont_side", 
	};
	public static int[] tagID = {33,34,35,36,37,38};
	public static ArrayList<Article> al;
	public static ArrayList<String> jug;
	@SuppressWarnings("deprecation")
	public static String doMain(long  qqtime,long  eetime) throws IOException {
		// TODO Auto-generated method stub
		//处理日期
//		System.out.print(qqtime+"\n"+eetime+"\n");
		Date date = new Date(qqtime);
		Date date2 = new Date(eetime);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timestamp qtime = Timestamp.valueOf(formatter.format(date));
		Timestamp etime = Timestamp.valueOf(formatter.format(date2));
		if(qtime.equals(etime)){
			String s =  ""+(1900+qtime.getYear())+"-"+((1+qtime.getMonth())<10?"0"+(1+qtime.getMonth()):(1+qtime.getMonth()))+"-"+qtime.getDate();
			String st =s+" 00:00:00";
			String ed =s+" 24:00:00";
			qtime = Timestamp.valueOf(st);
			etime = Timestamp.valueOf(ed);
		}
		
		Document doc = Jsoup.connect("http://www.view.sdu.edu.cn/").get();
		Analyse a = new Analyse();
//		new Analyse("http://www.view.sdu.edu.cn/new/2016/0410/79305.html");
		//山大要闻
		//Elements els=  doc.getElementsByAttributeValue("class", "colcont_side sdnews_a");
		//综合新闻
		Article art;
		al = new ArrayList<Article>();
		jug = new ArrayList<String>();
		////Gson
		Gson gson = new Gson();  
//		String ans="[";
		for(int i = 0;i< tagClass.length;i++){
			Elements els=  doc.getElementsByAttributeValue("class", tagClass[i]);
			//处理网址
			Elements links = els.select("a[href]");
			for (Element link : links) {
				String ts = link.attr("href");
				if(ts.matches("[0-9]{4}/[0-9]{4}/[0-9]*.html")){
					art = a.getArticle(link.attr("abs:href"),tagID[i]);
					if(!jug.contains(ts)){
						jug.add(ts);
						if(null != art)
							if((art.ts.after(qtime) && art.ts.before(etime))||art.ts.equals(qtime)){
								al.add(art);
						}
					}
				}
				
	        }
		}
		
		String username = "山大视点";
		String signature = SHA1Util.encode(username+(qqtime/1000)+""+(eetime/1000));
		//创建消息
		message m = new message(signature, ""+(qqtime/1000)+""+(eetime/1000), al);
		String ans = gson.toJson(m);
		return ans;
	}
//	public String getAns() throws IOException{
//		Main.main();
//		return Main.ans;
//	}

}
