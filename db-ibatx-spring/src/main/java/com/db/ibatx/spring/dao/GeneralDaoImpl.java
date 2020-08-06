package com.db.ibatx.spring.dao;

import com.db.ibatx.helper.MapperHelper;
import com.db.ibatx.provider.BaseProvider;
import com.db.ibatx.provider.ParamProviderContext;
import com.db.ibatx.provider.SelectByPrimaryKeyProvider;
import com.db.ibatx.provider.SelectOneByEntityProvider;
import com.db.ibatx.spring.dao.rowmapper.ParamBoundSql;
import com.db.ibatx.spring.dao.rowmapper.RowMapperStorage;
import com.db.ibatx.sql.ProviderSourceFactory;
import org.apache.ibatis.parsing.PropertyParser;
import org.apache.ibatis.session.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.Assert;

/**
 * 简单的DAO
 */
public class GeneralDaoImpl implements BasicDao {

    private JdbcTemplate jdbcTemplate;

    private Configuration configuration;

    private GeneralSqlSourceParser sqlSourceParser;

    private RowMapperStorage rowMapperStorage = new RowMapperStorage();

    public GeneralDaoImpl(JdbcTemplate jdbcTemplate, Configuration configuration) {
        this.configuration = configuration;
        this.jdbcTemplate = jdbcTemplate;
        this.sqlSourceParser = new GeneralSqlSourceParser(configuration);

    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public <T> T get(Object pk, Class<T> tClass) {
        Assert.notNull(pk, "主键 不能为空");
        BaseProvider baseProvider = ProviderSourceFactory.getProvider(SelectByPrimaryKeyProvider.class);
        ParamProviderContext paramProviderContext = new ParamProviderContext();
        paramProviderContext.setEntityInfo(MapperHelper.getEntityInfo(tClass));
        RowMapper<T> rowMapper = rowMapperStorage.getEntityRowMapper(tClass);
        String sql = PropertyParser.parse(baseProvider.produce(paramProviderContext), configuration.getVariables());
        ParamBoundSql boundSql = sqlSourceParser.parse(paramProviderContext.getEntityInfo(), sql, pk);
        return jdbcTemplate.queryForObject(boundSql.getSql(), new Object[]{pk}, rowMapper);
    }

    @Override
    public <T> T selectOne(T entity) {
        Assert.notNull(entity, "entity 不能为空");
        Class<T> tClass = (Class<T>) entity.getClass();
        BaseProvider baseProvider = ProviderSourceFactory.getProvider(SelectOneByEntityProvider.class);
        ParamProviderContext paramProviderContext = new ParamProviderContext();
        paramProviderContext.setEntityInfo(MapperHelper.getEntityInfo(tClass));
        paramProviderContext.setParameters(entity);
        RowMapper<T> rowMapper = rowMapperStorage.getEntityRowMapper(tClass);
        String sql = PropertyParser.parse(baseProvider.produce(paramProviderContext), configuration.getVariables());
        ParamBoundSql boundSql = sqlSourceParser.parse(paramProviderContext.getEntityInfo(), sql, entity);
        return jdbcTemplate.queryForObject(boundSql.getSql(), boundSql.getParams(), rowMapper);
    }

    private Class<?> getParamType(Object param) {
        return param == null ? Object.class : param.getClass();
    }

}
