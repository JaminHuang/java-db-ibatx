package com.db.ibatx.provider;

import com.db.ibatx.core.entity.Condition;
import com.db.ibatx.sql.builder.SqlBuilder;

public class SelectByConditionProvider extends BaseProvider {

    @Override
    public String produce(ParamProviderContext paramProviderContext) {
        Condition condition = getConditionParam(paramProviderContext.getParameters());
        return SqlBuilder.select(paramProviderContext.getEntityInfo())
                .fields(condition.getFieldsNames())
                .excludeFields(condition.getExcludeFieldsNames())
                .where(condition)
                .limit(condition.getLimitCondition())
                .forceMaster(condition.isforceMaster())
                .getSql();
    }

}
