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
			new Crawring();

		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
}
