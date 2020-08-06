package com.db.ibatx.provider;

import com.db.ibatx.core.entity.Condition;
import com.db.ibatx.sql.builder.SqlBuilder;

public class UpdateByConditionSelectiveProvider extends BaseProvider {
    @Override
    public String produce(ParamProviderContext context) {
        Condition condition = getConditionParam(context.getParameters());
        return SqlBuilder.update(context.getEntityInfo())
                .isSelective(true)
                .entity(getEntityParam(context.getParameters(), context.getEntityInfo().getEntityClass()))
                .where(getConditionParam(context.getParameters()))
                .fields(condition.getFieldsNames())
                .excludeFields(condition.getExcludeFieldsNames())
                .getSql();
    }

}
