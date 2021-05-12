package org.mxn.architecture.tries.sm.biz;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author moxiaonan
 * @since 2021/5/12
 */
@Service
public class CdBiz {
    private final ChampionBiz championBiz;

    public CdBiz(@Lazy ChampionBiz championBiz) {
        this.championBiz = championBiz;
    }
}
