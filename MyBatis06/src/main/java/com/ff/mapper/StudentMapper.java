package com.ff.mapper;

import java.util.List;

import com.ff.po.Student;

public interface StudentMapper {

	/**
	 * ����ѧ��
	 * 
	 * @param Student
	 * @return �Ƿ�ɹ�
	 */
	public int insertStudent(Student student);

	/**
	 * ��ѯ���е�ѧ��
	 * 
	 * @return
	 */
	public List<Student> selectAllStudent();

}