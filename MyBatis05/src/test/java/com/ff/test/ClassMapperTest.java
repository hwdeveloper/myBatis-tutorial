package com.ff.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.ff.mapper.ClassRoomMapper;
import com.ff.po.ClassRoom;
import com.ff.util.DBUtil;

public class ClassMapperTest {

	public void selectAllClass() {
		// ����SqlSession�Ự����
		SqlSession session = DBUtil.getSqlSessionFactory().openSession();
		// ��������ӳ����
		ClassRoomMapper classRoomMapper = session.getMapper(ClassRoomMapper.class);
		// ��������
		ClassRoom room = classRoomMapper.selectClass();
		System.out.print(room);
		// �Ự�ύ
		session.commit();
		// �Ự�ر�
		session.close();
	}

	public void selectAllClassAndStu() {
		// ����SqlSession�Ự����
		SqlSession session = DBUtil.getSqlSessionFactory().openSession();
		// ��������ӳ����
		ClassRoomMapper classRoomMapper = session.getMapper(ClassRoomMapper.class);
		// ��������
		List<ClassRoom> rooms = classRoomMapper.selectAllClassAndStu();
		System.out.print(rooms);
		// �Ự�ύ
		session.commit();
		// �Ự�ر�
		session.close();
	}

	public static void main(String[] args) {
		ClassMapperTest test = new ClassMapperTest();
		test.selectAllClass();
	}
}