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
import com.myrep.rals.tehcnicianapps.Utility.recycleviewAdapter;
import com.myrep.rals.tehcnicianapps.model.recyleview;

import java.util.ArrayList;
import java.util.List;

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

        for(i=0; i<imagedraw.length; i++)
        {
            recyleview addList = new recyleview(imagedraw[i], name[i], date[i],status[i]);
            historyList.add(addList);
        }

        recycleviewAdapter.notifyDataSetChanged();

    }
}