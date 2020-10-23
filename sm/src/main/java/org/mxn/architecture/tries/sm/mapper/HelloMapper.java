package org.mxn.architecture.tries.sm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mxn.architecture.tries.sm.entity.User;
@Mapper
public interface HelloMapper {
    User hello();
}
