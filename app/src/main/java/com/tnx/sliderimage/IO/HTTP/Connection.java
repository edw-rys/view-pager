package com.tnx.sliderimage.IO.HTTP;

import com.tnx.sliderimage.IO.HTTP.Cookies.SessionCookieJar;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Connection {
    public static final String URL="http://viewpager.edwtnx.com/";
    public static final String URL_USER   = "users";
    public static final String URL_TRAVEL = "travel";
    //public static final String URL_ACTIVES="activo";
    //public static final String URL_EMPLOYEE="employee";
    //public static final String URL_USER="user/login";
    private Retrofit instanceRetrofit;
    private static Connection connection;
    private Connection() { }

    public static Connection getInstance(){
        if (connection==null)
            connection = new Connection();
        return connection;
    }
    public Retrofit getRetrofit(){
        if (instanceRetrofit==null){
            // Asociamos el interceptor a las peticiones
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            // Asociamos el interceptor a las peticiones
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder().cookieJar(new SessionCookieJar());

            httpClient.addInterceptor(logging);

            instanceRetrofit= new Retrofit.Builder()
                    .baseUrl(Connection.URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())  // <-- usamos el log level
                    .build();
        }
        return instanceRetrofit;
    }
}
