package com.db.ibatx.sql.builder.condition;

import com.db.ibatx.core.entity.LimitCondition;
import com.db.ibatx.meta.EntityInfo;
import com.db.ibatx.sql.builder.CommonBuilder;

public class LimitSqlBuilder extends CommonBuilder {

    private LimitCondition limitCondition;

    protected LimitSqlBuilder(EntityInfo entityInfo) {
        super(entityInfo);
    }

    public LimitSqlBuilder(EntityInfo entityInfo, LimitCondition limitCondition) {
        super(entityInfo);
        this.limitCondition = limitCondition;
    }

    @Override
    public String getSql() {
        return LIMIT +
                this.limitCondition.getOffset() +
                SEPARATOR +
                this.limitCondition.getLimit();
    }
}
