package org.mxn.architecture.tries.sm.mapper;

import org.apache.ibatis.annotations.Param;
import org.mxn.architecture.tries.sm.entity.Champion;
import org.mxn.architecture.tries.sm.entity.StarResume;
import org.mxn.architecture.tries.sm.entity.User;

import java.util.List;
public interface HelloMapper {
    User hello();
    List<StarResume> stars();

    List<Champion> starChampion(@Param("stars") List<String> stars,@Param("test") String test);
    List<Champion> starChampion2(List<String> stars);
}
