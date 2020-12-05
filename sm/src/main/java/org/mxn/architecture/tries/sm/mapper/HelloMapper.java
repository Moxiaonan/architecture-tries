package org.mxn.architecture.tries.sm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mxn.architecture.tries.sm.entity.StarResume;
import org.mxn.architecture.tries.sm.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface HelloMapper extends BaseMapper {
    User hello();
    List<StarResume> stars();
}
