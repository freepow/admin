package com.brewduck.framework.data;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * User: JAEGER
 * Date: 13. 8. 16
 * Time: 오후 12:53
 * To change this template use File | Settings | File Templates.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestAttribute {
    String value();
}
