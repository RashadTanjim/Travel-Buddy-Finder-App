package com.travelbuddy.travelbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import adapter.RidehistoryAdapter;
import model.RidehistoryModel;

public class Travel_History extends AppCompatActivity {

    private RidehistoryAdapter ridehistoryAdapter;
    private RecyclerView recyclerview;
    private ArrayList<RidehistoryModel> ridehistoryModelArrayList;

    Integer i1[]={R.drawable.pin_black,R.drawable.pin_black,R.drawable.pin_black,R.drawable.pin_black,R.drawable.pin_black};
    Integer i2[]={R.drawable.rect_dotted,R.drawable.rect_dotted,R.drawable.rect_dotted,R.drawable.rect_dotted,R.drawable.rect_dotted};
    Integer i3[]={R.drawable.navigatiob_blue,R.drawable.navigatiob_blue,R.drawable.navigatiob_blue,R.drawable.navigatiob_blue,R.drawable.navigatiob_blue};
    String txtmall[]={"North South University","Bashundhara City ","Banani Market   ","Radison BLU    ","Dhanmondi 27   "};
    String txthome[]={"Home_Map","Home_Map","Home_Map","Home_Map","Home_Map"};
    String txtdate[]={"02 November 2018","03 November 2018","04 November 2018","05 November 2018","06 November 2018"};
    String txtprice[]={"$2.94","$2.94","$2.94","$2.94","$2.94"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel__history);

        recyclerview=findViewById(R.id.recycler1);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(Travel_History.this);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());

        ridehistoryModelArrayList = new ArrayList<>();

        for (int i=0;i<i1.length;i++){

            RidehistoryModel listModel = new RidehistoryModel(i1[i],i2[i],i3[i],txtmall[i],txthome[i],txtdate[i],txtprice[i]);

            ridehistoryModelArrayList.add(listModel);

        }
        ridehistoryAdapter = new RidehistoryAdapter(Travel_History.this,ridehistoryModelArrayList);
        recyclerview.setAdapter(ridehistoryAdapter);



    }
}
