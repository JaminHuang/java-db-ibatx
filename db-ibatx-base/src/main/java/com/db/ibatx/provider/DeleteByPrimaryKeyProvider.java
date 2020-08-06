package com.db.ibatx.provider;

import com.db.ibatx.sql.builder.SqlBuilder;

/**
 *
 * @author lgt
 * @date 2019/5/22 : 10:05 AM
 */
public class DeleteByPrimaryKeyProvider extends BaseProvider {
    @Override
    public String produce(ParamProviderContext paramProviderContext) {
        return SqlBuilder.delete(paramProviderContext.getEntityInfo())
                .wherePk()
                .getSql();
    }

}
