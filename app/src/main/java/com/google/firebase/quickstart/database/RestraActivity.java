package com.google.firebase.quickstart.database;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NEERAJPC on 10/21/2016.
 */

public class RestraActivity extends BaseActivity {





    private static final String TAG = RestraActivity.class.getSimpleName();
    private  String url;


    private List<Chapter> chapterList = new ArrayList<Chapter>();
    private ListView listView;
    private TitleAdapter adapter;

    // Progress dialog
    private ProgressDialog pDialog;
    private String value;
    private String subject_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            value = extras.getString("id");
            subject_name=extras.getString("subject_name");

        }
        setContentView(R.layout.chapter_layout);
        setTitle(subject_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);

        url="http://api.examenigma.in/chapter/?subject="+value;
        listView = (ListView) findViewById(R.id.list);
        adapter = new TitleAdapter(this, chapterList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener( this);
        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();
        JsonArrayRequest blogReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                Chapter chapter = new Chapter();
                                chapter.setchapter_title(obj.getString("chapter_title"));

                                chapter.setId(obj.getString("id"));


                                chapterList.add(chapter);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();

            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(blogReq);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.menu_1:
                Intent intent = getIntent();
                finish();
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String id= chapterList.get(i).getId();
        String chapter_name=chapterList.get(i).getchapter_title();
        Intent intent = new Intent(this, DealActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("chapter_name", chapter_name);
        startActivity(intent);
    }
}



