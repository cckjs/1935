package com.cckjs.cmall.dao.user;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cckjs.cmall.model.user.UserModel;
public interface UserDao extends PagingAndSortingRepository<UserModel, Integer> {

}
