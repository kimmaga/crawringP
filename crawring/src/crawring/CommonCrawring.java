package crawring;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 * @author Carf
 * @desc 공통 크롤링 인스턴스
 * @Ver 0.1
 * @20190710
 */
public class CommonCrawring {
	private String urlA;
	private String urlB;
	private String pageVariable;
	private CommonCrawring(String urlA,String urlB,String pageVariable) {
		this.urlA = urlA;
		this.urlB = urlB;
		this.pageVariable = pageVariable;
	}
	/**
	 * 
	 * @return
	 */
	private Document commonCrawler(String page) {
		Document targetSite = null;
		try {
			targetSite= connectSite(urlA+urlB+pageVariable+page);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return targetSite;
	}
	
	/**
	 * 
	 * @param url
	 * @return document
	 * @throws IOException
	 */
	private Document connectSite (String url) throws IOException {
		return Jsoup.connect(url)
				.header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko)")
				.header("Connection", "keep-alive").get();
		
	}
}
