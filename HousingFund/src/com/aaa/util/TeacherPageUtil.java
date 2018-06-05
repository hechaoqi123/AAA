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
				//ÿҳ����
				q.setMaxResults(page.getPageSize());
				
				return q.list();
			}
		});
		//����ѯ�Ľ����װ��page.list����
		page.setList(list);
		//��ѯȫ��
		
		List list2=ht.find(sql);
		//�õ���ҳ��
		int count=list2!=null?list2.size():0;
		
		//�жϵõ���ҳ��
		if(count%page.getPageSize()==0){
			page.setAllPage(count/page.getPageSize());
		}else{
			page.setAllPage(count/page.getPageSize()+1);
		}
		return page;
		
		
	}
}
