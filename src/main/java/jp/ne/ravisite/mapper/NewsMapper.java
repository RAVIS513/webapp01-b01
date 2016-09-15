package jp.ne.ravisite.mapper;

import java.util.List;

import jp.ne.ravisite.dto.NewsDto;

public interface NewsMapper {

	/**
	 * 全検索
	 * @return
	 */
	List<NewsDto> selectAll();

	/**
	 * 新規作成
	 * @param dto
	 * @return
	 */
	int insert(NewsDto dto);

	/**
	 * 全削除
	 * @return
	 */
	int deleteAll();

}
