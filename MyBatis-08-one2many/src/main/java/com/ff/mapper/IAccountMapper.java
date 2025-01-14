package com.ff.mapper;

import java.util.List;

import com.ff.bean.Account;
import com.ff.bean.AccountUser;


public interface IAccountMapper {

    /**
     * 查询所有账户，同时还要获取到当前账户的所属用户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户，并且带有用户名称和地址信息
     * @return
     */
    List<AccountUser> findAllAccount();
}
