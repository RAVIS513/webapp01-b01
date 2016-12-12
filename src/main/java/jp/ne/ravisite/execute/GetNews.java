package jp.ne.ravisite.execute;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import jp.ne.ravisite.constant.Const;
import jp.ne.ravisite.dao.NewsDao;
import jp.ne.ravisite.dto.GetNewsDto;
import jp.ne.ravisite.dto.NewsDto;
import jp.ne.ravisite.exception.BatchException;
import jp.ne.ravisite.utils.DbSessionUtil;
import jp.ne.ravisite.utils.StringUtil;

public class GetNews extends BatchAbstract{

	private Logger logger = LogManager.getLogger(GetNews.class);

	@Override
	public int mainProcess(ResourceBundle rb, String date) {
		DbSessionUtil sessionUtil = new DbSessionUtil();
		SqlSession session = null;
		try {
			logger.info("GetNews Start [" + date + "]");

			// DB接続設定
			session = sessionUtil.open();
			NewsDao dao = new NewsDao(session);

			// ニュース結果取得＆インサートデータ作成
			List<NewsDto> list = createInsertData(getNewsFromOnline(rb), dao.selectAll());

			// ニュース結果登録（全削除 => 新規登録）
			if (list != null && !list.isEmpty()) {
				dao.deleteAll();
				for (NewsDto d : list) {
					dao.insert(d);
				}
			}

			// DB正常終了
			sessionUtil.close(session);
			return Const.RESULT_SUCCESS;

		} catch (Exception e) {
			e.printStackTrace();
			if (session != null) {
				//DB異常終了
				sessionUtil.rollback(session);
			}
			throw new BatchException("GetNews Error [" + date + "]", e);
		}
	}

	/**
	 * ニュース スクレイピング
	 * @param rb
	 * @return
	 */
	private List<GetNewsDto> getNewsFromOnline(ResourceBundle rb) {
		List<GetNewsDto> list = new ArrayList<GetNewsDto>();
		try {
			logger.debug("GetNewsUrl : " + rb.getString("newsURL"));
			logger.debug("GetNewsQuery : " + rb.getString("newsQuery"));
			Document document = Jsoup.connect(rb.getString("newsURL")).get();
			Elements elements = document.select(rb.getString("newsQuery"));
			if (elements != null && !elements.isEmpty()) {
				logger.info("Get News Numbers : " + elements.size());
				for (Element e : elements) {
					GetNewsDto dto = new GetNewsDto();
//					dto.setTitle(e.text());
					dto.setTitle(StringUtil.replaceCharacter(e.text()));
					dto.setUrl(e.attr(rb.getString("newsQueryUrl")));
					list.add(dto);
				}
			} else {
				throw new BatchException("News Access Error");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BatchException("News Get Error", e);
		}
		return list;
	}

	/**
	 * ニューステーブルインサートデータ作成
	 * @param onList
	 * @param dbList
	 * @return ニュース記事に更新が無い場合、空のリストを返す
	 */
	private List<NewsDto> createInsertData(List<GetNewsDto> onList, List<NewsDto> dbList) {
		List<NewsDto> list = new ArrayList<NewsDto>();
		if (onList != null && !onList.isEmpty()) {
			// 新規ニュース有無確認
			int cnt = 0;
			if (dbList != null && !dbList.isEmpty()) {
				for (GetNewsDto on : onList) {
					for (NewsDto db : dbList) {
						if (on.getUrl().equals(db.getUrl())) {
							cnt++;
						}
					}
				}
			}
			// 新規ニュース用インサートデータ作成
			if (onList.size() != cnt) {
				Boolean newFlag = true;
				for (GetNewsDto on : onList) {
					newFlag = true;
					// 新規ニュースかチェックする
					if (dbList != null && !dbList.isEmpty()) {
						for (NewsDto db : dbList) {
							if (on.getUrl().equals(db.getUrl())) {
								newFlag = false;
							}
						}
					}
					// インサートデータ作成
					NewsDto dto = new NewsDto();
					dto.setTitle(on.getTitle());
					dto.setUrl(on.getUrl());
					dto.setNewFlag(newFlag == true ? "1" : "0");
					dto.setCreateTime(new Timestamp(System.currentTimeMillis()));
					list.add(dto);
				}
			}
		}
		return list;
	}

}
