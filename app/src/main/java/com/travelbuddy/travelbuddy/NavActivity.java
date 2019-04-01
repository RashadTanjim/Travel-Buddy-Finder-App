package com.travelbuddy.travelbuddy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


import android.app.ProgressDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NavActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView recyclerView;
    private List<ListItem> listItems;
    private MyAdapter myAdapter;
    private static final String REQUEST_URL = "https://newsapi.org/v2/top-headlines?country=in&apiKey=3d5998d023614120acefd255e7017c2a";
    private Button postExp, postShare;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        postShare = (Button) findViewById(R.id.post_share);


        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();

        loadRecyclerViewData();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        //group for Main Activities

        if (id == R.id.nav_timeline) {
            // Handle the timeline action
            Intent intent = new Intent(NavActivity.this, Timeline.class);
            startActivity(intent);

        } else if (id == R.id.nav_massage) {
            Intent intent = new Intent(NavActivity.this, Explore.class);
            startActivity(intent);

        } else if (id == R.id.nav_stories) {
            Intent intent = new Intent(NavActivity.this, Explore.class);
            startActivity(intent);


        } else if (id == R.id.nav_explore) {
            Intent intent = new Intent(NavActivity.this, Home_Map.class);
            startActivity(intent);

        } else if (id == R.id.nav_settings) {
            Intent intent = new Intent(NavActivity.this, Login_main.class);
            startActivity(intent);

        } else if (id == R.id.nav_book) {
            Intent intent = new Intent(NavActivity.this, Book.class);
            startActivity(intent);

        } else if (id == R.id.nav_history) {
            Intent intent = new Intent(NavActivity.this, Travel_History.class);
            startActivity(intent);


         //group for Contact & Share

        } else if (id == R.id.nav_contact) {
            //contact web view

        } else if (id == R.id.nav_share) {
            //sending feed back to via others
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "\nWe are Travel Buddy:\n\n ";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));


        } else if (id == R.id.nav_about) {
            //about this app

        } else if (id == R.id.nav_feedback) {
            Intent intent = new Intent(NavActivity.this, Travel_complete_rating.class);
            startActivity(intent);

        } else if (id == R.id.nav_exit) {
            // exiting app
            finish();
            moveTaskToBack(true);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void loadRecyclerViewData(){

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                REQUEST_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject baseobject = new JSONObject(response);
                            JSONArray articles = baseobject.getJSONArray("articles");

                            for (int i=0; i<articles.length(); i++){
                                JSONObject jsonObject = articles.getJSONObject(i);
                                ListItem listItem = new ListItem(jsonObject.getString("title"),
                                        jsonObject.getString("description"),
                                        jsonObject.getString("urlToImage"),
                                        jsonObject.getString("url"));

                                progressDialog.dismiss();
                                listItems.add(listItem);
                            }

                            MyAdapter myAdapter = new MyAdapter(listItems, getApplicationContext());
                            recyclerView.setAdapter(myAdapter);

                        } catch (JSONException e) {
                            Toast.makeText(NavActivity.this, "Error Fetching Data", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}
