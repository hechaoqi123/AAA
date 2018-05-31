package com.aaa.actions;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Controller;

import com.aaa.biz.CauseOfExtractionBiz;
import com.aaa.entity.Indinfo;
import com.alibaba.fastjson.JSON;

@ParentPackage("struts-default")
@Controller
public class CauseAction  extends BaseAction<Indinfo>{

	@Resource
	private CauseOfExtractionBiz biz;
	@Action("cause_Sele")
	public String causeSele() throws IOException{
		
		List list=biz.sele_cause();
		String json=JSON.toJSONString(list);
		System.out.println(json);
		getOut().print(json);
		return null;
	}
	
}
