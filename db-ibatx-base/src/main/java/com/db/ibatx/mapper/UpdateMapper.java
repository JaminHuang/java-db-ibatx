package com.db.ibatx.mapper;

import com.db.ibatx.core.entity.ParamConstant;
import com.db.ibatx.core.mapper.BaseMapper;
import com.db.ibatx.provider.UpdateByPrimaryKeySelectiveProvider;
import com.db.ibatx.provider.anno.UpdateSqlProvider;
import org.apache.ibatis.annotations.Param;

/**
 * 更新
 */
public interface UpdateMapper<T> extends BaseMapper<T> {
//    /**
//     * 根据主键更新
//     *
//     * @param t 实体对象
//     * @return 更新数量
//     */PageSelectMapper
//    @UpdateSqlProvider(provider = UpdateByPrimaryKeyProvider.class)
//    int updateByPrimaryKey(@Param(ParamConstant.ENTITY) T t);

    /**
     * 根据主键更新非空字段
     *
     * @param t 实体对象
     * @return 更新数量
     */
    @UpdateSqlProvider(provider = UpdateByPrimaryKeySelectiveProvider.class)
    int updatex(@Param(ParamConstant.ENTITY) T t);

//    /**
//     * 根据条件更新 非空字段
//     *
//     * @param condition 条件
//     * @param t         实体对象
//     * @return 更新数量
//     */
//    @UpdateSqlProvider(provider = UpdateByConditionSelectiveProvider.class)
//    int updateByConditionSelective(@Param(ParamConstant.CONDITION) Condition condition, @Param(ParamConstant.ENTITY) T t);
//
//    /**
//     * 根据条件更新
//     *
//     * @param condition 条件
//     * @param t         实体对象
//     * @return 更新数量
//     */
//    @UpdateSqlProvider(provider = UpdateByConditionProvider.class)
//    int updateByCondition(@Param(ParamConstant.CONDITION) Condition condition, @Param(ParamConstant.ENTITY) T t);

}
