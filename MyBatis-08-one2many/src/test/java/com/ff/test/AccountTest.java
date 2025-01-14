package com.ff.test;

import com.ff.bean.Account;
import com.ff.bean.AccountUser;
import com.ff.mapper.IAccountMapper;
import com.ff.mapper.IUserMapper;
import com.ff.mybatis.util.DBUtil;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


public class AccountTest {
	
	public static void main(String[] args) {
		AccountTest test = new AccountTest();
		test.findAll();
		
	}




    public void findAll(){
    	SqlSession session = DBUtil.getSqlSessionFactory().openSession();
    	IAccountMapper mapper = session.getMapper(IAccountMapper.class);
        List<Account> accounts = mapper.findAll();
        for(Account account : accounts){
            System.out.println(account);
        }
    }



    public void findAllAccountUser(){
    	SqlSession session = DBUtil.getSqlSessionFactory().openSession();
    	IAccountMapper mapper = session.getMapper(IAccountMapper.class);
        List<AccountUser> aus = mapper.findAllAccount();
        for(AccountUser au : aus){
            System.out.println(au);
        }
    }
}
