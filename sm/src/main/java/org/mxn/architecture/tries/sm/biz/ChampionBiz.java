package org.mxn.architecture.tries.sm.biz;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.mxn.architecture.tries.sm.entity.Champion;
import org.mxn.architecture.tries.sm.mapper.ChampionMapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author moxiaonan
 * @since 2021/5/8
 */
@Service
public class ChampionBiz extends ServiceImpl<ChampionMapper, Champion> {
    private final CdBiz cdBiz;

    public ChampionBiz(@Lazy CdBiz cdBiz) {
        this.cdBiz = cdBiz;
    }
}
