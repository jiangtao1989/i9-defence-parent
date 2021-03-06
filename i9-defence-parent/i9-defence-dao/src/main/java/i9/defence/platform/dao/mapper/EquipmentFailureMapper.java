package i9.defence.platform.dao.mapper;

import i9.defence.platform.model.EquipmentFailure;
import i9.defence.platform.model.EquipmentFailureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EquipmentFailureMapper {
    int countByExample(EquipmentFailureExample example);

    int deleteByExample(EquipmentFailureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EquipmentFailure record);

    int insertSelective(EquipmentFailure record);

    List<EquipmentFailure> selectByExample(EquipmentFailureExample example);

    EquipmentFailure selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EquipmentFailure record, @Param("example") EquipmentFailureExample example);

    int updateByExample(@Param("record") EquipmentFailure record, @Param("example") EquipmentFailureExample example);

    int updateByPrimaryKeySelective(EquipmentFailure record);

    int updateByPrimaryKey(EquipmentFailure record);
}