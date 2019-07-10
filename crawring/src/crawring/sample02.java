package crawring;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class sample02 {
	public static void main(String[] args) throws IOException {
		try {
			OutputStream output = new FileOutputStream("C:/Temp/output.txt");
			architizer();

		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	private static void architizer () throws IOException {
		String architizerAdress_A = "https://architizer.com";
		String architizerAdress_B = "/projects/q/page:";
		final Integer pageLimit = 3;
		for (int page = 1;page<=pageLimit;page++) {// architizer.com
			System.out.println("adress : " + architizerAdress_A+architizerAdress_B+page);
			Document architizer = connectSite(architizerAdress_A+architizerAdress_B+page);
			Elements architizerProject = architizer.select("a.js-use-pushstate");
				for (int i = 6; i < architizerProject.size(); i++) {
				String detail_url = architizerAdress_A+architizerProject.get(i).attr("href");
				Document architizer_detail = connectSite(detail_url);
				Elements title = architizer_detail.select("h1.name");
				Elements location = architizer_detail.select("div.location-txt");
				Elements imageUrl = architizer_detail.select("div.img-holder>.img");
				Elements contents = architizer_detail.select("span.js-copy");
				for(Element element : title) {
					System.out.println("url = " + detail_url + "\r\n"+"title = " + element.text() + "\r\n"+"location = " + location.text() +"\r\n"
							+"image_url = " + imageUrl.attr("data-url") + "\r\n"+ "contents = " 
							+ (contents.text().isEmpty()?"":contents.text().substring(0,30)));
					System.out.println("=========================================================================================================");
				}
				
			}
			System.out.println("page = " + page);
		}
	}
	private static Document connectSite (String url) throws IOException {
		Document targetSite = Jsoup.connect(url)
				.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko)")
				.header("Connection", "keep-alive").get();
		return targetSite;
	}
}
