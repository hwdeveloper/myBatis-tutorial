package com.ff.test;

import com.ff.bean.User;
import com.ff.mapper.IUserMapper;
import com.ff.mybatis.util.DBUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;



public class SecondLevelCacheTest {
	
	public static void main(String[] args) {
		SecondLevelCacheTest test = new SecondLevelCacheTest();
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
        session.close();//一级缓存消失

    	SqlSession session2 = DBUtil.getSqlSessionFactory().openSession();
        IUserMapper dao2 = session2.getMapper(IUserMapper.class);
        User user2 = dao2.findById(41);
        System.out.println(user2);
        session2.close();

        System.out.println(user1 == user2);
    }


}
