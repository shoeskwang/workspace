package com.kwang.forecastCourse.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kwang.forecastCourse.model.dto.GeoVO;

@Repository
public class CourseDAOImpl implements CourseDAO {
	
	@Inject
	SqlSession SqlSession;
	
	@Override
	public GeoVO view(int gno) throws Exception {
		return SqlSession.selectOne("course.view", gno);
	}

	@Override
	public void insert(GeoVO vo) throws Exception {
		SqlSession.insert("course.insert",vo);
	}

	@Override
	public List<GeoVO> listAll(int start, int end, String searchOption, String keyword) throws Exception {
		Map<String,Object> map = new HashMap<String, Object>();
		// paging 처리
		map.put("start", start);
		map.put("end", end);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		return SqlSession.selectList("course.listAll", map);
	}

	@Override
	public void update(GeoVO vo) throws Exception {
		// 미구현
	}

	@Override
	public void delete(int gno) throws Exception {
		SqlSession.delete("course.deleteArticle",gno);
	}

	@Override
	public void increaseViewcnt(int gno) throws Exception {
		SqlSession.update("course.increaseViewcnt", gno);
	}

	@Override
	public int countArticle() throws Exception {
		return SqlSession.selectOne("course.countArticle", null);
	}

}
