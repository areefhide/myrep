package com.myrep.rals.tehcnicianapps;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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


    private TextView tvName;
    private TextView tvDescription;
    private TextView tvPhone;
    private TextView tvMobile;
    private ImageView ivProfile;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.profile_fragment,container,false);
        tvName = (TextView)view.findViewById(R.id.tvName);
        tvDescription = (TextView)view.findViewById(R.id.tvDescription);
        tvPhone = (TextView)view.findViewById(R.id.tvPhone);
        tvMobile = (TextView)view.findViewById(R.id.tvMobile);
        ivProfile = (ImageView)view.findViewById(R.id.ivProfile);
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        SessionManager sessionManager =  new SessionManager(getContext());
        String bearer = sessionManager.getToken();
        Call<PersonalData> infoCall = apiInterface.getPersonalInfo("Bearer " + bearer);
        infoCall.enqueue(new Callback<PersonalData>() {
            @Override
            public void onResponse(Call<PersonalData> call, Response<PersonalData> response) {
                PersonalData info = response.body();
                final String BaseUrl = "http://myrep.nagasakti.team/assets/uploads/installers/";
                if(info.getStatus().equalsIgnoreCase("Ok")){
                    PersonalInfo data = info.getData();
                    tvName.setText(data.getFirst_name());
                    String desc = data.getVendor_type() + " " + data.getVendor_title();
                    tvDescription.setText(desc);
                    tvMobile.setText(data.getMobile());
                    tvPhone.setText(data.getPhone());
                    Glide.with(getContext()).load(BaseUrl + data.getPhoto()).into(ivProfile);
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