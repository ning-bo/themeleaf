package com.example.themeleaf.jpa;

import com.example.themeleaf.entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author NingBo
 * @create 2018-05-23 14:38
 * @desc
 **/
@Repository
public interface DemoJPA extends
        JpaRepository<DemoEntity,Long>, //SpringDataJPA提供的简单数据操作接口  paRepository需要泛型接口参数，第一个参数是实体，第二则是主键的类型
        JpaSpecificationExecutor<DemoEntity>,  //SpringDataJPA提供的复杂查询接口
        Serializable {

    @Modifying    //@Query注解好像只是用来查询的，但是如果配合@Modifying注解一共使用，则可以完成数据的删除、添加、更新操作
    @Query(value = "select * from test where id < ?1", nativeQuery = true)   //nativeQuery = true才是表明了使用原生的sql，如果不配置，默认是false，则使用HQL查询方式
    List<DemoEntity> findIdLt20(Long id);

    List<DemoEntity> findByTitle(String aaa);
    List<DemoEntity> findByIdIn(List<Long> ids);


}
