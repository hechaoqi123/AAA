package com.aaa.biz;

import java.util.List;

import com.aaa.entity.Role;

public interface RoleBiz {
	//���ӹ���
	public int addRole(Role role);
	//ɾ������
	public int del_Role(Role role);
	
	//��ѯ���й���
	public List<Role> getAllRole();
	
	//��ѯһ��
	public Role get_This_Role(Role role);
	//�޸�
	public int update_Role(Role role);
}