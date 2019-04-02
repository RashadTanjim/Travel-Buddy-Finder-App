package com.travelbuddy.travelbuddy;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import adapter.PostAdapter;
import adapter.StoriesAdapter;
import model.PostModel;
import model.StoriesModel;

public class Timeline extends AppCompatActivity implements View.OnClickListener{

    public void changeHeart(View view) {

     ImageView heartLike =  (ImageView) findViewById(R.id.heartChange);
     heartLike.setImageResource(R.drawable.ic_heart_black);

      }


    private Integer[] PROFILE = {R.drawable.farhan,R.drawable.farhan_1,R.drawable.rock,R.drawable.will,R.drawable.hitler,R.drawable.mj,R.drawable.miketyson};
    private String[] NAME = {"Farhan","Imam","dip","Rasel","Rakin","Saief","Chandler"};
    private String[] LIKE = {"195","257","698","387","524","448","259"};
    private String[] CAPTION = {" #FABMovie","#GymIslyf..","Keep the smile everytime....<3","MAN IN BLACK...#MIB","Mr. Dictator","Music heals everything...","Yoo" };
    private String[] CAPTIONNAME = {"#DipuNumberTwo","#Gymfreak","#Smile","Mr.Perfect","#James_Bond_","#LinkingPark","Yoo"};

    private ArrayList<PostModel> postModelArrayList;
    private RecyclerView postrecy;
    private PostAdapter postAdapter;
    private ImageView navBar;

    private ArrayList<StoriesModel> storiesModelArrayList;
    private RecyclerView recyclerView;
    private StoriesAdapter storiesAdapter;

    LinearLayout homelinear,searchlinear,instalinear,heartlinear,profilelinear;
    ImageView home,search,insta,heart,profile, gotoMassage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);

        homelinear = findViewById(R.id.homelinear);
        searchlinear = findViewById(R.id.searchlinear);
        instalinear = findViewById(R.id.instalinear);
        heartlinear = findViewById(R.id.heartlinear);
        profilelinear = findViewById(R.id.profilelinear);

        navBar =(ImageView) findViewById(R.id.Navbar);

        home = (ImageView) findViewById(R.id.hometool);
        search =(ImageView) findViewById(R.id.searchtool);
       // insta = findViewById(R.id.map);
        heart = (ImageView)findViewById(R.id.hearttool);
        profile =(ImageView) findViewById(R.id.profiletool);
        gotoMassage =(ImageView) findViewById(R.id.nav_massage_web);


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Timeline.this, Account.class));
                profile.setImageResource(R.drawable.ic_person);
            }
        });

        gotoMassage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Timeline.this, Home_Map.class));
                //finish();
                WebView webview = findViewById(R.id.webView);
                webview.loadUrl("www.facebook.com");
            }
        });


        navBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Timeline.this, NavActivity.class));
            }
        }
        );


        /////Code for Circular Stories
        recyclerView = findViewById(R.id.recystories);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Timeline.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        storiesModelArrayList = new ArrayList<>();

        for(int i=0;i<PROFILE.length;i++){
            StoriesModel storiesModel = new StoriesModel();
            storiesModel.setProfile(PROFILE[i]);
            storiesModel.setName(NAME[i]);

            storiesModelArrayList.add(storiesModel);
        }

        storiesAdapter = new StoriesAdapter(Timeline.this,storiesModelArrayList);
        recyclerView.setAdapter(storiesAdapter);


        /////Code for Posts
        postrecy = findViewById(R.id.recypost);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(Timeline.this);
        postrecy.setLayoutManager(layoutManager1);
        postrecy.setItemAnimator(new DefaultItemAnimator());
        postModelArrayList = new ArrayList<>();

        for (int i=0;i<PROFILE.length;i++){
            PostModel postModel = new PostModel();
            postModel.setProfile(PROFILE[i]);
            postModel.setPost(PROFILE[i]);
            postModel.setName(NAME[i]);
            postModel.setLike(LIKE[i]);
            postModel.setCaption(CAPTION[i]);
            postModel.setCaptionname(CAPTIONNAME[i]);

            postModelArrayList.add(postModel);
        }

        postAdapter = new PostAdapter(Timeline.this,postModelArrayList);
        postrecy.setAdapter(postAdapter);

        homelinear.setOnClickListener(this);
        searchlinear.setOnClickListener(this);
        instalinear.setOnClickListener(this);
        heartlinear.setOnClickListener(this);
        profilelinear.setOnClickListener(this);

    }



    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.homelinear:

                home.setImageResource(R.drawable.ic_home_black);
                search.setImageResource(R.drawable.ic_search);
                insta.setImageResource(R.drawable.placeholder);
                heart.setImageResource(R.drawable.ic_heart_outline);
                profile.setImageResource(R.drawable.ic_perm_identity);

                break;

            case R.id.searchlinear:

                home.setImageResource(R.drawable.ic_home_outline);
                search.setImageResource(R.drawable.ic_search);
                insta.setImageResource(R.drawable.placeholder);
                heart.setImageResource(R.drawable.ic_heart_outline);
                profile.setImageResource(R.drawable.ic_perm_identity);

                break;



            case R.id.heartlinear:

                home.setImageResource(R.drawable.ic_home_outline);
                search.setImageResource(R.drawable.ic_search);
                insta.setImageResource(R.drawable.placeholder);
                heart.setImageResource(R.drawable.ic_heart_black);
                profile.setImageResource(R.drawable.ic_perm_identity);

                break;

            case R.id.profilelinear:

                home.setImageResource(R.drawable.ic_home_outline);
                search.setImageResource(R.drawable.ic_search);
                insta.setImageResource(R.drawable.placeholder);
                heart.setImageResource(R.drawable.ic_heart_outline);
                profile.setImageResource(R.drawable.ic_person);

                break;


        }

    }





}
