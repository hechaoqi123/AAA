package com.aaa.util;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.aaa.entity.TeachaerPageEntity;

@Component
public class TeacherPageUtil {

	@Resource
	private HibernateTemplate ht;
	
	public TeachaerPageEntity getPage(final String sql,final TeachaerPageEntity page){
		List list=ht.executeFind(new HibernateCallback<List>() {

			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
			
			
				Query q=session.createQuery(sql);
				// 0=(1-1)*5
				// 5=(2-1)*5
				q.setFirstResult((page.getCurrPage()-1)*page.getPageSize());
				//每页条数
				q.setMaxResults(page.getPageSize());
				
				return q.list();
			}
		});
		//将查询的结果封装到page.list里面
		page.setList(list);
		//查询全部
		
		List list2=ht.find(sql);
		//得到总页数
		int count=list2!=null?list2.size():0;
		
		//判断得到总页数
		if(count%page.getPageSize()==0){
			page.setAllPage(count/page.getPageSize());
		}else{
			page.setAllPage(count/page.getPageSize()+1);
		}
		return page;
		
		
	}
}
