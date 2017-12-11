package com.example.repository;

import com.example.model.InformationBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationRepository extends CrudRepository<InformationBean,Integer>{

    <S extends InformationBean> S save(S s);

    <S extends InformationBean> S findByUid(Integer uid);
}
