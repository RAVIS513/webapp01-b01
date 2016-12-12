package jp.ne.ravisite.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jp.ne.ravisite.constant.Const;

public class StringUtil {

	/**
	 * REPLACE ESCAPE CHARACTER
	 * @param target
	 * @return
	 */
	public static String replaceCharacter(String target) {
		String result = target;
		for (int i = 0; i < Const.REPLACE_BEFORE_CHARA.length; i++) {
			Pattern p = Pattern.compile(Const.REPLACE_BEFORE_CHARA[i]);
			Matcher m = p.matcher(result);
			result = m.replaceAll(Const.REPLACE_AFTER_CHARA[i]);
		}
		return result;
	}

	/**
	 * REPOSIT ESCAPE CHARACTER
	 * @param target
	 * @return
	 */
	public static String repositCharacter(String target) {
		String result = target;
		for (int i = 0; i < Const.REPLACE_AFTER_CHARA.length; i++) {
			Pattern p = Pattern.compile(Const.REPLACE_AFTER_CHARA[i]);
			Matcher m = p.matcher(result);
			result = m.replaceAll(Const.REPLACE_BEFORE_CHARA[i]);
		}
		return result;
	}

}
