package com.r2apps.monitoring.rest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by ravindra.kambale on 3/18/2017.
 */

public interface ApiService {
    @POST("notify")
    Call<ResponseBody> sendMail(@Body MailMetaData data);
}
