package com.ff.test;

import com.ff.bean.User;
import com.ff.mapper.IUserMapper;
import com.ff.mybatis.util.DBUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


public class UserTest {
	
	public static void main(String[] args) {
		UserTest test = new UserTest();
		test.firstLevelCache();
	}



    /**
     * 测试一级缓存
     */
    @Test
    public void firstLevelCache(){
    	
      	SqlSession session = DBUtil.getSqlSessionFactory().openSession();
      	IUserMapper mapper = session.getMapper(IUserMapper.class);
        User user1 = mapper.findById(41);
        System.out.println(user1);

//        sqlSession.close();
        //再次获取SqlSession对象
//        sqlSession = factory.openSession();

        session.clearCache();//此方法也可以清空缓存

        mapper = session.getMapper(IUserMapper.class);

        User user2 = mapper.findById(41);
        System.out.println(user2);

        System.out.println(user1 == user2);
    }

    /**
     * 测试缓存的同步
     */
    @Test
    public void clearlCache(){
    	SqlSession session = DBUtil.getSqlSessionFactory().openSession();
      	IUserMapper mapper = session.getMapper(IUserMapper.class);
        //1.根据id查询用户
        User user1 = mapper.findById(41);
        System.out.println(user1);

        //2.更新用户信息
        user1.setUsername("update user clear cache");
        user1.setAddress("北京市海淀区");
        mapper.updateUser(user1);

        //3.再次查询id为41的用户
        User user2 = mapper.findById(41);
        System.out.println(user2);

        System.out.println(user1 == user2);
    }
}
