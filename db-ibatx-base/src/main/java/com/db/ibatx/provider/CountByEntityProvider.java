package com.db.ibatx.provider;

import com.db.ibatx.sql.builder.SqlBuilder;

/**
 * 根据实体类查询数量
 */
public class CountByEntityProvider extends BaseProvider {

    @Override
    public String produce(ParamProviderContext paramProviderContext) {
        return SqlBuilder.select(paramProviderContext.getEntityInfo())
                .where(getEntityParam(paramProviderContext.getParameters(), paramProviderContext.getEntityInfo().getEntityClass()))
                .count()
                .getSql();
    }
}
