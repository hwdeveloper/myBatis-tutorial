package com.ff.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.ff.mapper.StudentMapper;
import com.ff.po.Student;
import com.ff.util.DBUtil;

public class StudentMapperTest {

	public void selectStudentById() {
		// ����SqlSession�Ự����
		SqlSession session = DBUtil.getSqlSessionFactory().openSession();
		// ��������ӳ����
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);

		Student student = new Student();
		student.setName("С��");
		student.setClassroomId(3);
		//����ѧ����ִ�к󻺴�����
		int index=  studentMapper.insertStudent(student);
		System.out.print(index);

		// �Ự�ύ��ִ�к󻺴�����
		session.commit();
        //sqlSession.clearCache();//ִ�к󻺴�����
		// �Ự�ر�
		session.close();
	}

	public void selectAllStudent() {
		
		
		// ����SqlSession�Ự����
		SqlSession session = DBUtil.getSqlSessionFactory().openSession();
		// ��������ӳ����
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);

		// ���ѧ���б�
		List<Student> list = studentMapper.selectAllStudent();
		System.out.print(list);
		// �Ự�ύ
		session.commit();
		// �Ự�ر�
		session.close();
	}
	public static void main(String[] args) {
		StudentMapperTest test = new StudentMapperTest();
		test.selectStudentById();
	}
}