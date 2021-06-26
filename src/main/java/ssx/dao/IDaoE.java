package ssx.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import ssx.entity.DBScheamE;

import java.util.List;

@Repository("iDaoE")
public interface IDaoE {

    @Select("SELECT id myId,name myName FROM `demo`.`ssm_six` LIMIT 0,1000")
    List<DBScheamE> queryAll();

    @Insert("insert into `demo`.`ssm_six` values(#{myId},#{myName})")
    boolean addOne(DBScheamE dbScheamE);
}
