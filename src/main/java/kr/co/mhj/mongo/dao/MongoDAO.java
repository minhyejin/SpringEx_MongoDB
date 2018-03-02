package kr.co.mhj.mongo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import kr.co.mhj.mongo.vo.MongoTestVO;

@Component
public class MongoDAO {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void saveMongoData(MongoTestVO mongoTestVO) {
		mongoTemplate.save(mongoTestVO); //save를 통해서 저장하기
	}
	public MongoTestVO findMongoData(String key, String value) {
		//MongoTemplate에서 조건을 검색하기 위해 Criteria 클래스 사용 
		Criteria criteria = new Criteria();
		criteria.is(value); // 일치 하는 값을 찾기 위해 is 메소드 사용
		
		//쿼리 객체 작성 
		Query query = new Query(criteria);
		
		MongoTestVO vo = mongoTemplate.findOne(query, MongoTestVO.class);
						//.class 로 제네릭 타이틀 잡는다.
		return vo;
	}
}
