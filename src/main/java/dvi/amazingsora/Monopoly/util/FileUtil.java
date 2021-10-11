package dvi.amazingsora.Monopoly.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class FileUtil {
	public static void readFile(String url) throws IOException {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(url);
		try (Scanner sc = new Scanner(is)) {
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static InputStream readFileInputStream(String url) throws IOException {
		return Thread.currentThread().getContextClassLoader().getResourceAsStream(url);

	}

	public static List<Map<String, String>> getCoordinatedata(InputStream is) {
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		try (Scanner sc = new Scanner(is)) {
			while (sc.hasNextLine()) {

				String str = sc.nextLine();
				if (StringUtils.isBlank(str)) {
					break;
				}
				String value[] = str.split(",");
				Map<String, String> map = new HashMap<String, String>();
				map.put("X", value[0].trim());
				map.put("Y", value[1].trim());
				result.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	

	public static void main(String[] args) throws IOException {
//		readFile("data/coordinate.txt");
		System.out.println(getCoordinatedata(readFileInputStream("data/coordinate.txt")));
	}

}
