package com.brewduck.framework.convert;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: JAEGER
 * Date: 13. 8. 16
 * Time: 오후 1:02
 * To change this template use File | Settings | File Templates.
 */
@Target(value={ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MaskFormat {
    String value();
}
