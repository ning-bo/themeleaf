package com.example.themeleaf.jpa;

import com.example.themeleaf.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * @author NingBo
 * @create 2018-05-29 10:22
 * @desc
 **/
@Repository
public interface ArticleJPA extends JpaRepository<ArticleEntity,Long>,JpaSpecificationExecutor<ArticleEntity>,Serializable {

    List<ArticleEntity> findByStatus(Integer status);
}
