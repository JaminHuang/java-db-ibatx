package com.db.ibatx.provider.anno;


import com.db.ibatx.provider.BaseProvider;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface UpdateSqlProvider {

    Class<? extends BaseProvider> provider();

}
