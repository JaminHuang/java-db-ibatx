package com.db.ibatx.provider;

import com.db.ibatx.sql.builder.SqlBuilder;

/**
 * 单个插入
 */
public class InsertOneSelectiveProvider extends BaseProvider {

    @Override
    public String produce(ParamProviderContext paramProviderContext) {
        return SqlBuilder.insert(paramProviderContext.getEntityInfo())
                .entity(getEntityParam(paramProviderContext.getParameters(), paramProviderContext.getEntityInfo().getEntityClass()))
                .isSelective(true)
                .getSql();
    }
}
