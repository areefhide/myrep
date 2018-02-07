package com.myrep.rals.tehcnicianapps;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.MarkerOptions;
import com.myrep.rals.tehcnicianapps.Utility.GpsLocation;
import com.myrep.rals.tehcnicianapps.Utility.RecyclerItemClickListener;
import com.myrep.rals.tehcnicianapps.model.recyleview;
import com.myrep.rals.tehcnicianapps.Utility.recycleviewAdapter;

import java.util.ArrayList;
import java.util.List;

public class History_Past_Fragment extends Fragment {

    private List<recyleview> historyList = new ArrayList<>();
    private RecyclerView recyclerView;
    private recycleviewAdapter recycleviewAdapter;
    private int[] imagedraw = {R.drawable.profile_photo,R.drawable.profile_photo};
    private String[] name = {"Budianto","Suliyarto"};
    private String[] date = {"9/30/17 at 13:08", "9/20/17 at 15:00"};
    private String[] status = {"Complete", "Complete"};
    private Integer i;
    private Context ctx;
    private static View view;

    public History_Past_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.history_past_fragment, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view){

        recyclerView = (RecyclerView) view.findViewById(R.id.recycleViewList);

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

        for(i=0; i<imagedraw.length; i++)
        {
            recyleview addList = new recyleview(imagedraw[i], name[i], date[i],status[i]);
            historyList.add(addList);
        }

        recycleviewAdapter.notifyDataSetChanged();

    }


}