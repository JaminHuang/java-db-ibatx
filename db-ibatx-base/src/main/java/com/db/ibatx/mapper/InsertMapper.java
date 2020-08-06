package com.db.ibatx.mapper;

import com.db.ibatx.core.entity.ParamConstant;
import com.db.ibatx.core.mapper.BaseMapper;
import com.db.ibatx.provider.InsertBatchProvider;
import com.db.ibatx.provider.InsertOneSelectiveProvider;
import com.db.ibatx.provider.anno.InsertSqlProvider;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface InsertMapper<T> extends BaseMapper<T> {

    @InsertSqlProvider(provider = InsertOneSelectiveProvider.class)
    int savex(T t);



    @InsertSqlProvider(provider = InsertBatchProvider.class)
    int saveBatchx(@Param(ParamConstant.ENTITY_LIST) List<T> t);


    //    @InsertSqlProvider(provider = InsertOneProvider.class)
//    int savex(T t);
}
