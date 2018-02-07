package com.myrep.rals.tehcnicianapps;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myrep.rals.tehcnicianapps.Utility.SessionManager;
import com.myrep.rals.tehcnicianapps.model.PersonalData;
import com.myrep.rals.tehcnicianapps.model.PersonalInfo;
import com.myrep.rals.tehcnicianapps.service.ApiClient;
import com.myrep.rals.tehcnicianapps.service.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.profile_fragment,container,false);
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        SessionManager sessionManager =  new SessionManager(getContext());
        String bearer = sessionManager.getToken();
        Call<PersonalData> infoCall = apiInterface.getPersonalInfo("Bearer " + bearer);
        infoCall.enqueue(new Callback<PersonalData>() {
            @Override
            public void onResponse(Call<PersonalData> call, Response<PersonalData> response) {
                PersonalData info = response.body();
                if(info.getStatus().equalsIgnoreCase("Ok")){
                    PersonalInfo data = info.getData();
                }
            }

            @Override
            public void onFailure(Call<PersonalData> call, Throwable t) {
                t.printStackTrace();
            }
        });


        return view;
    }
}