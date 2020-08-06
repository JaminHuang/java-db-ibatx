package com.db.ibatx.mapper;

import com.db.ibatx.core.entity.ParamConstant;
import com.db.ibatx.core.mapper.BaseMapper;
import com.db.ibatx.provider.DeleteByPrimaryKeyProvider;
import com.db.ibatx.provider.anno.DeleteSqlProvider;
import org.apache.ibatis.annotations.Param;

/**
 * 删除mapper
 *
 * @author lgt
 * @date 2019/5/22 : 10:04 AM
 */
public interface DeleteMapper<T> extends BaseMapper<T> {

    /**
     * 物理删除
     *
     * @param t 主键
     * @return 删除结果
     */
    @DeleteSqlProvider(provider = DeleteByPrimaryKeyProvider.class)
    int realDeletex(@Param(ParamConstant.PRIMARY_KEY) Object t);

}
