package com.tnx.sliderimage.IO.HTTP.HttpPetition;

import com.tnx.sliderimage.IO.HTTP.Connection;
import com.tnx.sliderimage.IO.HTTP.Interface.TravelLocationI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HttpTravelLocation {
    /**
     * Http petition for all data
     * @param codebar
     */
    public void getData(String codebar){
        Connection connection= Connection.getInstance();
        Retrofit retrofit = connection.getRetrofit();
        TravelLocationI jsonTravelLocationApi = retrofit.create(TravelLocationI.class);
        Call<RestActives> call = jsonTravelLocationApi.getAll(codebar);
        call.enqueue(new Callback<RestActives>() {
            @Override
            public void onResponse(Call<RestActives> call, Response<RestActives> response) {
                if (response.isSuccessful()){
                    RestActives restActives = response.body();

                    activo = restActives.getActives();

                    categories = restActives.getCategories();
                    if (restActives.getStatus().equals("success") && activo!=null){
                        ActivoModelSqlite.registroDatos(activo, fragmentActives.getActivity());
                        fragmentActives.getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Main_aplication main_aplication=(Main_aplication)fragmentActives.getActivity();
                                main_aplication.stopProgressDialog();
                                fragmentActives.setDataAcivies(activo);
                                fragmentActives.activarBotones();
                                fragmentActives.addDataMarca(categories);
                            }
                        });
                    }else{
                        message = restActives.getMessage();
                        fragmentActives.getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Main_aplication main_aplication=(Main_aplication)fragmentActives.getActivity();
                                main_aplication.stopProgressDialog();
                                main_aplication.startProgressError(message, true);
                                fragmentActives.cleanInput();
                                fragmentActives.bloquearBotones();
                            }
                        });
                    }
                }else{
                    try{
                        message = "Error inesperado";
                        errorPanel();
                    }catch (Exception exx){

                    }
                }
            }

            @Override
            public void onFailure(Call<RestActives> call, Throwable t) {
                try{
                    message = "No hay conexión";
                    errorPanel();
                }catch (Exception exx){

                }
            }
        });

    }
}
