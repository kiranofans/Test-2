package Utils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public abstract class ConnectionInterceptor implements Interceptor {
    public abstract boolean isInternetAvailable();
    public abstract void onInternetUnavailable();

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request okHttpRequest = chain.request();
        if(!isInternetAvailable()){
            onInternetUnavailable();
        }
        return chain.proceed(okHttpRequest);
    }
}
