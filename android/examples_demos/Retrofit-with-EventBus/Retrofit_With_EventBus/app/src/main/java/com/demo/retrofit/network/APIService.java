package com.demo.retrofit.network;

import com.demo.retrofit.network.response.AbstractApiResponse;
import com.demo.retrofit.network.response.ImageListResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * The API interface for retrofit calls. This interface defines all the api calls made by the app.
 * Note: You have to pass a null value for a parameter to be skipped. Parameter values are URL
 * encoded by default. TODO: We may have to encode the parameter values before passing them to the
 * api calls here although they are URL encoded by retrofit automatically. We have to test this
 * thoroughly.
 */
public interface APIService {

    @GET("image_list.php")
    Call<ImageListResponse> getImageList();

    /**
     * Upload file to server
     *
     * @param firstName
     * @param lastName
     * @param image0
     * @return
     */
    @Multipart
    @POST("upload.php")
    Call<AbstractApiResponse> uploadFile(
            @Query("first_name") String firstName,
            @Query("last_name") String lastName,
            @Part MultipartBody.Part image0);

}
