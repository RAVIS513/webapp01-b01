package jp.ne.ravisite.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import jp.ne.ravisite.exception.BatchException;

public class FileUtil {

	/**
	 * ニュース取得結果ファイル出力
	 * @param map
	 * @param filePath
	 */
	public static void createFile(LinkedHashMap<String, String> map, String filePath) {
		File f = new File(filePath);
		PrintWriter pw = null;
		BufferedWriter bw = null;
		try {
			pw = new PrintWriter(f, "UTF-8");
			for (Map.Entry<String, String> e : map.entrySet()) {
				pw.println(e.getKey());
				pw.println(e.getValue());
			}
		} catch (Exception e) {
			throw new BatchException("News Result File Output Error", e);
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (pw != null) {
					pw.close();
				}
			} catch (Exception e2) {
				throw new BatchException("News Result File Close Error", e2);
			}
		}
	}
}
