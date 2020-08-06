package com.db.ibatx.provider;

import com.db.ibatx.sql.builder.SqlBuilder;

/**
 * 插入单个
 */
public class InsertOneProvider extends BaseProvider {

    @Override
    public String produce(ParamProviderContext paramProviderContext) {
        return SqlBuilder.insert(paramProviderContext.getEntityInfo())
                .entity(getEntityParam(paramProviderContext.getParameters(), paramProviderContext.getEntityInfo().getEntityClass()))
                .isSelective(false)
                .getSql();
    }
}
