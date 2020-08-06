package com.db.ibatx.mapper;

import com.db.ibatx.core.entity.ParamConstant;
import com.db.ibatx.core.mapper.BaseMapper;
import com.db.ibatx.provider.LogicDeleteByPrimaryKeyProvider;
import com.db.ibatx.provider.anno.DeleteSqlProvider;
import org.apache.ibatis.annotations.Param;

public interface SoftDeleteMapper<T> extends BaseMapper<T> {

    /**
     * 逻辑删除
     *
     * @param t
     * @return
     */
    @DeleteSqlProvider(provider = LogicDeleteByPrimaryKeyProvider.class)
    int softDeletex(@Param(ParamConstant.PRIMARY_KEY) Object t);

}
