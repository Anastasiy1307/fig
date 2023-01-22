package com.example.myapplication;

import android.provider.ContactsContract;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface RetrofitUpdate {
    @PUT ("Autoes/")
    Call<DataModal>
    updateData(@Query("Id") int id, @Body DataModal dataModal);
}
