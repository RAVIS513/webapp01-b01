package jp.ne.ravisite.execute;

import java.util.ResourceBundle;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import jp.ne.ravisite.exception.BatchException;

public abstract class BatchAbstract {

	protected Logger logger = LogManager.getLogger(BatchAbstract.class);

	/**
	 * バッチ個別処理
	 * @param rb
	 */
	public int mainProcess(ResourceBundle rb, String date){
		return 0;
	}

	/**
	 * バッチ実行
	 * @param date
	 * @return
	 */
	public int execute(String date) {
		try {
			// プロパティファイル取得
			ResourceBundle rb = ResourceBundle.getBundle("batch");
			// バッチ個別処理
			return mainProcess(rb, date);
		} catch (Exception e) {
			throw new BatchException("BatchAbstract Error", e);
		}
	}
}
