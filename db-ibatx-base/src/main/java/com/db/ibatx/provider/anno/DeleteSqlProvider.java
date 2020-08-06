package com.db.ibatx.provider.anno;


import com.db.ibatx.provider.BaseProvider;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface DeleteSqlProvider {

    Class<? extends BaseProvider> provider() ;
}
