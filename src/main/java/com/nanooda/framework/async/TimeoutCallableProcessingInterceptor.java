package com.nanooda.framework.async;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptorAdapter;

import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * User: JAEGER
 * Date: 13. 8. 16
 * Time: 오후 12:59
 * To change this template use File | Settings | File Templates.
 */
public class TimeoutCallableProcessingInterceptor extends CallableProcessingInterceptorAdapter {

    @Override
    public <T> Object handleTimeout(NativeWebRequest request, Callable<T> task) throws Exception {
        throw new IllegalStateException("[" + task.getClass().getName() + "] timed out");
    }

}
