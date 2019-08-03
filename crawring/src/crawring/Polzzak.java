package crawring;

import java.math.BigDecimal;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Polzzak {
	KeywordDAO keywordDAO = new KeywordDAO();
	public Polzzak() {
		super();
		polzzak();
	}

	private void polzzak() {
		String big_url = "http://www.poljjak.com";
		String url = "http://www.poljjak.com/goods/goods_list.php?cateCd=005001";
		String productUrl = "/shop/shopbrand.html?";
		String param1 = "xcode=";
		String pamra2 = "type=";
		CommonCrawring polzzak = new CommonCrawring(url);//item_photo_box
		Document document = polzzak.commonCrawler();
		String total_numb = document.getElementsByClass("pick_list_num").select("strong").text();
		BigDecimal total_number = new BigDecimal(StringUtils.replace(total_numb,",",""));
		System.out.println(total_number);
		BigDecimal page_limit = new BigDecimal("80");
		BigDecimal finalPage = total_number.divide(page_limit, BigDecimal.ROUND_HALF_UP);
		System.out.println("finalPage = " + finalPage);
	for (int j = 1; j <= finalPage.intValue(); j++) {
			CommonCrawring page_polzzak = new CommonCrawring(
					//"http://www.poljjak.com/goods/goods_list.php?page="+j+"&cateCd=005001"
							"http://www.poljjak.com/goods/goods_list.php?cateCd=005001");
			Document document_polzzak = page_polzzak.commonCrawler();
			Elements elements = document_polzzak.select(".item_photo_box a");
			Integer index = 0;
			for (Element ele : elements) {
				String detailUrl = ele.attr("href");
				CommonCrawring detailCrawring = new CommonCrawring(big_url + StringUtils.replace(detailUrl,"..",""));
				Document document_detail = detailCrawring.commonCrawler();
				String image = document_detail.select("#mainImage > img").attr("src");
				String price = StringUtils.replace(
						StringUtils.replace(StringUtils.replace(document_detail.select(".item_price").text(),"판매가 ",""),"원",""),",","");
				String title = document_detail.select(".item_detail_tit > h3").text();
				Elements options = document_detail.select("select.chosen-select > option");
				String[] productArray = StringUtils.split(title,",");
				String product_title = productArray[0];
				String product_id = StringUtils.replace(productArray[productArray.length-1]," ","");

				System.out.println("index = " + index);
				System.out.println("product_id = " + product_id);
				System.out.println("product_title = " + product_title);
				System.out.println("price = " + price);
				System.out.println("imageUrl = " + image);
				System.out.println("통화 = KRW");
//				System.out.println("finalPage = " + finalPage);
				index++;
				String[] polzzakSize= {"220","225","230","235","240","245","250","255","260","265","270","275","280","285","290","295","300","305","310"
						,"XS","S","M","L","XL","2XL","3XL"};
				//System.out.println(options);
				boolean flag =false;
				for (Element ele1 : options) {
					flag = false;
					String oldtext = ele1.text();
					if(!oldtext.contains("[품절]")) {
						String sizeText = StringUtils.replace(StringUtils.split(StringUtils.replace(ele1.text()," ",""),"/")[0],"mm","");
						for(int z=0;z<polzzakSize.length;z++) {
							if(polzzakSize[z].equals(sizeText)) {
								flag = true;
							}
						}
						if(flag) System.out.println(sizeText);
					}
				}
			}

		}//for
	}
}
