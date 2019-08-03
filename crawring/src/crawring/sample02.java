package crawring;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class sample02 {
	public static void main(String[] args) throws IOException {
		try {
			OutputStream output = new FileOutputStream("C:/Temp/output.txt");
			//new TwoSixHundred();
			new Polzzak();

		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
}
