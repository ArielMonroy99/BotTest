package bo.edu.ucb.ingsoft.rest.delivery.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Service
public interface SequenceDao {
    @Select("SELECT nextval(#{sequenceName}::regclass)")
    Integer getSequence(@Param("sequenceName") String sequenceName);
}
