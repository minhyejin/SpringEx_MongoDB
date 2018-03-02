package kr.co.mhj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mhj.mongo.dao.MongoDAO;
import kr.co.mhj.mongo.vo.MongoTestVO;

@Controller
public class MongoTestController {
	
	@Autowired
	MongoDAO mongoDAO;
	
	@RequestMapping(value = "/save")
	@ResponseBody public String saveTest() {
		
		MongoTestVO mongoTestVO = new MongoTestVO();
		mongoTestVO.set_id("1");
		mongoTestVO.setData1("데이터1");
		mongoTestVO.setData2("my Data2");
		
		mongoDAO.saveMongoData(mongoTestVO);
		return mongoTestVO.toString() + " saved!";
	}
	@RequestMapping(value = "/find")
	@ResponseBody public String findTest() {
		
		return mongoDAO.findMongoData("_id", "1").toString();
	}
	
}
