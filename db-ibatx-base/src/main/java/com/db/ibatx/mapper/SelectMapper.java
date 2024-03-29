package com.db.ibatx.mapper;

import com.db.ibatx.core.entity.Condition;
import com.db.ibatx.core.entity.LimitCondition;
import com.db.ibatx.core.entity.ParamConstant;
import com.db.ibatx.core.mapper.BaseMapper;
import com.db.ibatx.provider.*;
import com.db.ibatx.provider.anno.SelectSqlProvider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 基础查询模块
 */
public interface SelectMapper<T> extends BaseMapper<T> {

    /**
     * 根据主键查询
     *
     * @param pk 主键
     * @return 返回值
     */
    @SelectSqlProvider(provider = SelectByPrimaryKeyProvider.class)
    T getx(@Param(ParamConstant.PRIMARY_KEY) Object pk);

    /**
     * 根据实体类查询单个
     * 后面limit 0，1
     *
     * @param t 实体对象参数
     * @return 查询单个
     */
    @SelectSqlProvider(provider = SelectOneByEntityProvider.class)
    T getOnex(@Param(ParamConstant.ENTITY) T t);

    /**
     * 根据实体类查询
     *
     * @param t 实体对象参数
     * @return 查询列表
     */
    @SelectSqlProvider(provider = SelectByEntityProvider.class)
    List<T> listx(@Param(ParamConstant.ENTITY) T t);

    /**
     * 根据实体类查询
     *
     * @param t 实体对象参数
     * @return 查询列表
     */
    @SelectSqlProvider(provider = SelectByEntityProvider.class)
    List<T> listLimitx(@Param(ParamConstant.ENTITY) T t, @Param(ParamConstant.LIMIT) LimitCondition limitCondition);

    /**
     * 根据Condition查询
     *
     * @param condition 条件类
     * @return 查询列表
     */
    @SelectSqlProvider(provider = SelectByConditionProvider.class)
    List<T> listByConditionx(@Param(ParamConstant.CONDITION) Condition<T> condition);

    /**
     * 根据实体类查询数量
     *
     * @param t 实体对象参数
     * @return 查询列表
     */
    @SelectSqlProvider(provider = CountByEntityProvider.class)
    int countx(@Param(ParamConstant.ENTITY) T t);

    /**
     * 根据Condition查询数量PageSelectMapper
     *
     * @param condition 条件类
     * @return 查询列表
     */
    @SelectSqlProvider(provider = CountByConditionProvider.class)
    int countByConditionx(@Param(ParamConstant.CONDITION) Condition<T> condition);

}
