package com.example.repository;

import com.example.model.UserBean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<UserBean,Integer> {

     <S extends UserBean> S save(S s);

     <S extends UserBean> S findByEmail(String email);


}
