package com.sprapp.springdata;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MainRepository<T, PK extends Serializable> extends JpaRepository<T, PK> {

}
