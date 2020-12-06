package org.mxn.architecture.tries.sm.mapper;

import org.mxn.architecture.tries.sm.entity.StarResume;
import org.mxn.architecture.tries.sm.entity.User;

import java.util.List;
public interface HelloMapper {
    User hello();
    List<StarResume> stars();
}
