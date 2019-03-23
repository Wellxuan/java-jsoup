package Weather;
import java.io.IOException;
 
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class TestJsoup {
		public  Document getDocument (String url){
        try {
       	 //5000是设置连接超时时间，单位ms
            return Jsoup.connect(url).timeout(5000).get();
        } catch (IOException e) {
        		e.printStackTrace();
        	}
        	return null;
		}
		public static void main(String[] args) {
			TestJsoup te = new TestJsoup();
			Document doc = te.getDocument("http://www.weather.com.cn/weather/101120710.shtml");
			Elements ele1 = doc.select("[class=t clearfix]");
			//获取内容
			//Elements ele2 = ele1.select("[class=sky skyid lv2 on]");
		    //String today = ele2.get(0).text();
		    //System.out.println(" "+today);
		    //获取日期
		    Elements ele3 = ele1.select("h1");
		    String date = ele3.get(0).text();
		    System.out.println("日期 ： "+date);
		    //获取天气
		    Elements ele4 =ele1.select("[class=wea]");
		    String weat = ele4.get(0).text();
		    System.out.println("天气 ： "+weat);
		    //获取最高温
		    Elements ele10 = ele1.select(".tem span");
		    String ssdd = ele10.get(0).text();
		    System.out.println("最高温 ： "+ssdd+"℃");
		    //获取最低温
		    Elements ele5 = ele1.select(".tem i");
		    String ssd = ele5.get(0).text();
		    System.out.println("最低温 ： "+ssd);
		  //获取风力
		    Elements ele6 =ele1.select(".win i");
		    String win = ele6.get(1).text();
		    System.out.println("风力 ： "+win);
		    /*Elements ele7 = doc.select("[class=crumbs fl]");
		    Elements ele8 = ele7.select("span");
		    String place = ele8.get(2).text();
		    System.out.println("地点 ： "+place);*/
		    
		    Elements ele9 = doc.select("[class=con today clearfix]");
            Elements ele11 = ele9.select("[class=left fl]");
            Elements ele12 = ele11.select("[class=ctop clearfix]");
            //Elements ele13 = ele12.select("[class=time fr]");
		    String update = ele12.get(0).text();
		    System.out.println("地点 ："+update);
		   
		}
}