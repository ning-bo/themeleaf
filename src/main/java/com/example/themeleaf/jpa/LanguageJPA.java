package com.example.themeleaf.jpa;

import com.example.themeleaf.entity.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * @author NingBo
 * @create 2018-05-29 16:41
 * @desc
 **/
@Repository
public interface LanguageJPA extends JpaRepository<LanguageEntity, Long>,JpaSpecificationExecutor<LanguageEntity>,Serializable {

    List<LanguageEntity> findByStatusNot(Long status);
}
