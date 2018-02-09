package com.myrep.rals.tehcnicianapps;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myrep.rals.tehcnicianapps.Utility.RecyclerItemClickListener;
import com.myrep.rals.tehcnicianapps.Utility.SessionManager;
import com.myrep.rals.tehcnicianapps.Utility.recycleviewAdapter;
import com.myrep.rals.tehcnicianapps.model.WoData;
import com.myrep.rals.tehcnicianapps.model.WorkOrders;
import com.myrep.rals.tehcnicianapps.model.recyleview;
import com.myrep.rals.tehcnicianapps.service.ApiClient;
import com.myrep.rals.tehcnicianapps.service.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class History_Upcoming_Fragment extends Fragment {

    private List<recyleview> historyList = new ArrayList<>();
    private RecyclerView recyclerView;
    private recycleviewAdapter recycleviewAdapter;
    private int[] imagedraw = {R.drawable.profile_photo};
    private String[] name = {"Maman"};
    private String[] date = {"9/30/17 at 13:08"};
    private String[] status = {"Pending"};
    private Integer i;
    private Context ctx;
    private static View view;

    public History_Upcoming_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
       // View view = inflater.inflate(R.layout.history_upcoming_fragment,container,false);
        /*if (view != null) {
          //  Log.d("ilang","menghilang");
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null){
                parent.removeView(view);
            }

        }
        try {
            view = inflater.inflate(R.layout.history_upcoming_fragment, container, false);
            Log.d("ilang","menghilangsssdddddd");
          //  initViews(view);
        } catch (InflateException e) {
            Log.d("ilang","menghilangddddd");
            initViews(view);
        }*/

        view = inflater.inflate(R.layout.history_upcoming_fragment, container, false);

        initViews(view);
        return view;
    }

    private void initViews(View view){

        recyclerView = (RecyclerView) view.findViewById(R.id.recycleViewListupcoming);

        recycleviewAdapter  = new recycleviewAdapter(historyList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.setAdapter(recycleviewAdapter);
        prepareData();

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(ctx, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        for(i = 0; i<name[+position].length(); i++)
                        {
                            if(i == position)
                            {
                                // Intent intent = new Intent(getActivity(), ComplaintDetailActivity2.class);
                                //parseData = i;
                                //  intent.putExtra(parseData.toString(),i.toString());
                                //  startActivity(intent);
                            }
                        }
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
    }

    private void prepareData() {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        SessionManager sessionManager =  new SessionManager(getContext());
        String bearer = sessionManager.getToken();

        Call<WorkOrders> ordersCall = apiInterface.getWorkOrders("Bearer " + bearer);
        ordersCall.enqueue(new Callback<WorkOrders>() {
            @Override
            public void onResponse(Call<WorkOrders> call, Response<WorkOrders> response) {
                WorkOrders orders = response.body();
                if(orders.getStatus().equalsIgnoreCase("Ok")){
                    for (WoData d : orders.getData()) {
                        recyleview addList = new recyleview(imagedraw[0], d.getCustomer().getFirst_name(), d.getWorkorder().getWo_date(),d.getWorkorder().getJob_status());
                        historyList.add(addList);
                    }
                    recycleviewAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<WorkOrders> call, Throwable t) {

            }
        });

//        for(i=0; i<imagedraw.length; i++)
//        {
//            recyleview addList = new recyleview(imagedraw[i], name[i], date[i],status[i]);
//            historyList.add(addList);
//        }
//
//        recycleviewAdapter.notifyDataSetChanged();

    }
}