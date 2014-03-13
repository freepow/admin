package com.brewduck.framework.data;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 커스텀 아규먼트 리졸버
 *
 * User: JAEGER
 * Date: 13. 8. 16
 */
public class CustomArgumentResolver implements HandlerMethodArgumentResolver {

    public boolean supportsParameter(MethodParameter parameter) {
        return (parameter.getParameterAnnotation(RequestAttribute.class) != null);
    }

    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        RequestAttribute attr = parameter.getParameterAnnotation(RequestAttribute.class);
        return webRequest.getAttribute(attr.value(), WebRequest.SCOPE_REQUEST);
    }

}
