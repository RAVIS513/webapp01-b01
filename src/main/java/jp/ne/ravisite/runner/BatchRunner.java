package jp.ne.ravisite.runner;

import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import jp.ne.ravisite.constant.Const;
import jp.ne.ravisite.execute.GetNews;

public class BatchRunner {

	/**
	 * バッチ処理割り振り
	 * @param args
	 */
	public static void main(String[] args) {

		Logger logger = LogManager.getLogger(BatchRunner.class);

		try {
			String date = null;
			if (args.length > 0) {
				date = args[0];
//				String job = args[1];
			} else {
				date = new Date().toString();
			}

			GetNews batch = new GetNews();

			System.exit(batch.execute(date));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("BatchRunner Error", e);
			System.exit(Const.RESULT_ERROR);
		}
	}

}
