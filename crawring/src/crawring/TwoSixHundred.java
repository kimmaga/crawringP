package crawring;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TwoSixHundred {
	Integer pageLimit = 5;
	KeywordDAO keywordDAO = new KeywordDAO();

	public TwoSixHundred() {
		super();
		twoSixHundred();
	}

	private void twoSixHundred() {
		String big_url = "http://www.260mm.com";
		String url = "http://www.260mm.com/shop/shopbrand.html?xcode=001&type=X";
		String productUrl = "/shop/shopbrand.html?";
		String param1 = "xcode=";
		String pamra2 = "type=";
		CommonCrawring archdailyCrawring = new CommonCrawring(url);
		Document document = archdailyCrawring.commonCrawler();
		Elements total_numb = document.getElementsByTag("strong");
		BigDecimal total_number = new BigDecimal(total_numb.text());
		BigDecimal page_limit = new BigDecimal("80");
		BigDecimal finalPage = total_number.divide(page_limit, BigDecimal.ROUND_HALF_UP);
		for (int j = 1; j <= finalPage.intValue(); j++) {
			CommonCrawring page260 = new CommonCrawring(
					"http://www.260mm.com/shop/shopbrand.html?page=" + j + "&xcode=001&type=X");
			Document page260_document = page260.commonCrawler();
			Elements elements = page260_document.select(".product_table .Brand_prodtHeight a");

			Integer index = 0;
			for (Element ele : elements) {
				String detailUrl = ele.attr("href");
				CommonCrawring detailCrawring = new CommonCrawring(big_url + detailUrl);
				Document document_detail = detailCrawring.commonCrawler();
				String image = document_detail.select(".detail_image").attr("src");
				String price = document_detail.select("#price_text").text();
				String title = document_detail.select("title").text();
				Elements options = document_detail.select("select.vo_value_list > option");

				title = title.replace("[", "").replace("]", "").replace("해외", "").replace("260mm  ", "");
				String product_title = StringUtils.split(title, "(")[0];
				String product_id = StringUtils.split(title, "(")[1].replace(")", "");

				System.out.println("index = " + index);
				System.out.println("product_id = " + product_id);
				System.out.println("product_title = " + product_title);
				System.out.println("price = " + price);
				System.out.println("imageUrl = " + image);
				System.out.println("finalPage = " + finalPage);
				index++;
				for (Element ele1 : options) {
					if (!ele1.text().equals("--- 필수 옵션입니다 ---")) {
						// System.out.println("options = " + ele1.text());
					}
				}

			}

		}
	}

}
