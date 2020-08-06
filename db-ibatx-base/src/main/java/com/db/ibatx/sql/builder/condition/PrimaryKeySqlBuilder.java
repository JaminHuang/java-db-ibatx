package com.db.ibatx.sql.builder.condition;

import com.db.ibatx.core.entity.ParamConstant;
import com.db.ibatx.core.entity.ParamSymbol;
import com.db.ibatx.exception.ColumnUnknowException;
import com.db.ibatx.meta.EntityInfo;
import com.db.ibatx.meta.ParamValue;
import com.db.ibatx.meta.PrimaryKeyField;

import java.util.Objects;

public class PrimaryKeySqlBuilder extends WhereSqlBuilder {

    private String replacePlace;

    public PrimaryKeySqlBuilder(EntityInfo entityInfo) {
        super(entityInfo);
    }

    public PrimaryKeySqlBuilder(EntityInfo entityInfo, String replacePlace) {
        super(entityInfo);
        this.replacePlace = replacePlace;
    }

    @Override
    protected StringBuilder getWhereSql() {
        StringBuilder stringBuilder = new StringBuilder();
        replacePlace = hasLength(replacePlace) ? replacePlace : ParamConstant.PRIMARY_KEY;
        PrimaryKeyField primaryKeyField = getEntityInfo().getPrimaryKey();
        if (Objects.isNull(primaryKeyField)) {
            throw new ColumnUnknowException("entity 没有定义主键。");
        }
        stringBuilder.append(getParam(new ParamValue(primaryKeyField.getColumnName(), ParamSymbol.EQUAL, replacePlace)));
        this.setHasCondition(true);

        return stringBuilder;
    }
}
