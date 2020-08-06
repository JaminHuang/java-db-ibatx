package com.db.ibatx.provider;

import com.db.ibatx.sql.builder.SqlBuilder;

/**
 * 根据condition查询数量
 */
public class CountByConditionProvider extends BaseProvider {
    @Override
    public String produce(ParamProviderContext paramProviderContext) {
        return SqlBuilder.select(paramProviderContext.getEntityInfo())
                .where(getConditionParam(paramProviderContext.getParameters()))
                .count()
                .getSql();
    }

}
