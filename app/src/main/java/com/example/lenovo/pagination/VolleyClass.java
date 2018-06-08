package com.example.lenovo.pagination;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class VolleyClass extends AppCompatActivity {
TextView textView;
ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_class);
        textView=(TextView)findViewById(R.id.textview);
        image=(ImageView)findViewById(R.id.image);
        String url = "https://gulllak.com/efs/resources/gulllakapi/authanticatelogin.php";
        RequestQueue queue= Volley.newRequestQueue(this);

        StringRequest jsonObjectRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.d("edwaess",response.toString());
                textView.setText("Response => "+response.toString());

                //findViewById(R.id.progressBar1).setVisibility(View.GONE);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

    })
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();


                params.put("username","pooja.sangwan134@gmail.com");
                params.put("password","467@pooja");



                return params;
            }

        }

                ;

        queue.add(jsonObjectRequest);
    }
}
