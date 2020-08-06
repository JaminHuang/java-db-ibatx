package com.db.ibatx.provider;

import com.db.ibatx.sql.builder.SqlBuilder;

public class DeleteByPrimaryKeyProvider extends BaseProvider {
    @Override
    public String produce(ParamProviderContext paramProviderContext) {
        return SqlBuilder.delete(paramProviderContext.getEntityInfo())
                .wherePk()
                .getSql();
    }

}
