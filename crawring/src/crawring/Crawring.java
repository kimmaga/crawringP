package crawring;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawring {
	//https://www.archdaily.com/search/projects
	Integer pageLimit = 5;
	KeywordDAO keywordDAO = new KeywordDAO();
	
	public Crawring() {
		super();
		archdaily();
	}

	private void archdaily() {
		String archdailyA = "https://www.archdaily.com";
		String archdailyB = "/search/projects";
		String pageVariable = "?page=";
		String[] specrArr = {"architects","location","category" ,"partnerInCharge","projectArchitect" ,"projectTeam" ,"projectYear","photographs" ,"clients","lightingConsultant"};
		CommonCrawring archdailyCrawring = new CommonCrawring(archdailyA,archdailyB,pageVariable);
		for(int page=1;page<pageLimit;page++) {
			Document document = archdailyCrawring.commonCrawler(page);
			Elements elements = document.select(".afd-search-list__link");
			for (Element element : elements) {
				String detailUrl = element.attr("href");
				CommonCrawring detailCrawring = new CommonCrawring(archdailyA,detailUrl);
				Document detailDocument =  detailCrawring.commonCrawler();
				Elements title = detailDocument.select("h1.afd-title-big");
				Elements regDate = detailDocument.select("li.theDate");
				Elements author = detailDocument.select("li.theAuthor");
				Elements img_url = detailDocument.select("a.js-image-size__link");
				Elements textElements = detailDocument.select("div.afd-char-text");
				System.out.println(title.text());
				System.out.println(regDate.text().substring(17,21)+"-"+regDate.text().substring(11,15)+"-"+regDate.text().substring(8,10)+" "
						+regDate.text().substring(0,5));
				for(int j=0;j<textElements.size();j++) {
					System.out.println(specrArr[j] + " = " + textElements.get(j).text());
				}
			}
		}
		
	}
	
	
		
}
