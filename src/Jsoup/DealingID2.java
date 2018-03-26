package Jsoup;

import java.io.IOException;

import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

public class DealingID2 {
	public static final String[][] s = new String[1000][3];
	public DealingID2() {
		s[0][0]="ɽ��Ҫ��";
		s[0][1]="http://www.view.sdu.edu.cn/new/sdnews/";
		s[1][0]="ͷ��";s[1][1]="http://www.view.sdu.edu.cn/";
		s[2][0]="�ۺ�����";
		s[2][1]="http://www.view.sdu.edu.cn/new/news/";
		s[3][0]="ѧԺ����_У԰����_ѧ���ݺ�_ѧ����̳_�߽���Ұ_ʦ������";
		s[3][1]="http://www.view.sdu.edu.cn/new/gzxy/";
		s[4][0]="��������_У�Ѷ�̬";
		s[4][1]="http://www.view.sdu.edu.cn/new/hzjl/";
		s[5][0]="ѧ��Ԥ��_ɽ������";
		s[5][1]="http://www.view.sdu.edu.cn/new/xsyg/";
			
		// TODO Auto-generated constructor stub
		for(int i= 0 ; i<s.length;i++){
			
		try {
			String t = ""+(System.currentTimeMillis()/1000);
//			System.out.println(t);
			Response res = Jsoup
					.connect("http://202.194.14.197:8283/ishandaInit/CreateCategoryServlet")
					.timeout(0)
					.data("web", "4")
					.data("name", s[i][0])
					.data("url", s[i][1])
					.data("timestamp", t)
					.data("signature", SHA1Util.encode("1" + t))
					.method(Method.POST)
					.execute();
			String doc = res.parse().text();
			/*System.out.println(SHA1Utils.hex_sha1("1" + t));
			System.out.println(doc);*/
			System.out.println(doc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		}
	}
	public static void main(String[] args){
//		DealingID2 d = new DealingID2();
		String t = ""+(System.currentTimeMillis()/1000);
		System.out.println(t);
		String ss =  SHA1Util.encode("1" + t);
		System.out.print(ss);
		
	}
}
