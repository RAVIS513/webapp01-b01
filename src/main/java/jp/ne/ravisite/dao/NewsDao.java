package jp.ne.ravisite.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import jp.ne.ravisite.dto.NewsDto;
import jp.ne.ravisite.mapper.NewsMapper;

public class NewsDao {

	private Logger logger = LogManager.getLogger(NewsDao.class);

	private NewsMapper mapper = null;

	public NewsDao(SqlSession session) {
		this.mapper = session.getMapper(NewsMapper.class);
	}

	public List<NewsDto> selectAll() {
		logger.debug("selectAll Run");
		return mapper.selectAll();
	}

	public int insert(NewsDto dto) {
		logger.debug("insert Run");
		return mapper.insert(dto);
	}

	public int deleteAll() {
		logger.debug("deleteAll Run");
		return mapper.deleteAll();
	}

}
