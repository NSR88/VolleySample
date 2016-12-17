package com.example.volleysample.volleysample;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.volleysample.volleysample.constants.AppGlobalConstants;
import com.example.volleysample.volleysample.helper.Logs;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.volleysample.volleysample.helper.Logs.class_name;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        makeURLForAppAuthAndFireRequest();
    }


    private void makeURLForAppAuthAndFireRequest() {

        try {
            Uri.Builder uri = new Uri.Builder();
            uri.scheme(AppGlobalConstants.SCHEME);//basicall http or https
            uri.encodedAuthority(AppGlobalConstants.WEBSERVICE_BASE_URL); //domain name like www.google.com
            uri.path(AppGlobalConstants.PREFIX_PATH + AppGlobalConstants.WEBSERVICE_APP_AUTH); //like /app/index/file.php
//    uri.appendPath("login")//
            uri.appendQueryParameter("app_id", AppGlobalConstants.APP_ID);




            requestVolleyForAppAuthUsingVolley(
                    AppGlobalConstants.WEBSERVICE_APP_AUTH,
                    uri.toString());


        } catch (Exception e) {
            // TODO Auto-generated catch block
            Logs.setLogException(class_name, "makeURLForAppAuthAndFireRequest()", e);
        }

    }

    private class requestForUploadMedia extends AsyncTask<Context, Void, String> {
        ProgressDialog pDialog = new ProgressDialog(ctx);

        @Override
        protected String doInBackground(Context... ctx) {


            String update_user_details_json = "";


            try {

                Log.d("upload_media","file_size: (when uploading api call)"+(img_file.length()/1000));

                RequestBody requestBody = new MultipartBuilder().type(MultipartBuilder.FORM)
                        .addFormDataPart("user_id", AppSharedPreferences.loadUserIDPreference(ctx[0]))
                        .addFormDataPart("app_id", AppGlobalConstants.APP_ID)
                        .addFormDataPart("at", AppSharedPreferences.loadUserAccessTokenPreference(ctx[0]))
                        .addFormDataPart("fileToUpload", "file.png", RequestBody.create(MediaType.parse("image/*"), img_file))
                        .build();


                Request request = new Request.Builder()
                        .url(AppGlobalConstants.WEBSERVICE_BASE_URL_FULL_FOR_UPLOADING_MEDIA)
                        .post(requestBody)
                        .build();


                OkHttpClient client = new OkHttpClient();
                client.setConnectTimeout(AppGlobalConstants.IMAGE_UPLOAD_SOCKET_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS); // connect timeout
                client.setReadTimeout(AppGlobalConstants.IMAGE_UPLOAD_SOCKET_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);    // socket timeout
                com.squareup.okhttp.Response response = client.newCall(request).execute();


                server_file_name = response.body().string();
                server_file_name = server_file_name.replaceAll("\\[", "").replaceAll("\\]", "");
                server_file_name = server_file_name.replaceAll("\"", "");

                return server_file_name;



                // survey_xml = loadXMLFromPreferences("survey_xml").trim();
            } catch (Exception e) {
                Logs.setLogException(class_name, "requestForUploadMedia()", e);
            }
            return update_user_details_json;
        }

        @Override
        protected void onPostExecute(String result) {
            // parseXmlDisplayForm(result);

            try {
                pDialog.hide();
                if(!result.trim().equalsIgnoreCase("")) {
                    MessageDetailsModel msg_details_model = new MessageDetailsModel();
//                                msg_details_model.setCreated_at(CommonUtilities);
                    msg_details_model.setMsg_content("");
                    msg_details_model.setMsg_url("");
                    msg_details_model.setMsg_iso_code("CN");
                    msg_details_model.setFrom_user_id(msgUserModel.getUser_id());
                    msg_details_model.setMeReceiver(false);
                    msg_details_model.setImage_url(server_file_name);
//                                msg_details_model.setMsg_id(msgID);

                    makeURLForSendingMsgAndFireRequest(msg_details_model);
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                Logs.setLogException(class_name, "requestForUploadMedia()", e);
                pDialog.hide();
            }

        }

        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
//            pDialog = new ProgressDialog(ctx);

            pDialog.setCancelable(false);
            pDialog.setMessage(ctx.getResources().getString(R.string.please_wait));
            pDialog.show();
//            pDialog = ProgressDialog.show(ctx,
//                    ctx.getResources().getString(R.string.please_wait), "");

        }

    }


    private void requestVolleyForAppAuthUsingVolley(final String method_name, String url) {
        // TODO Auto-generated method stub
        String tag_json_arry = "json_array_req: "+method_name;
        Log.d("Http Request", url);
        final String[] responseString = {""};
//        String url = "http://carbonchase.com/v1.1/get_favs.php?user_id=123&at=0&channels";
        final ArrayList<String> list = new ArrayList<String>();

        final ProgressDialog pDialogVolley = new ProgressDialog(ctx);
        // pDialogVolley.setCancelable(false);
        if(ConnectivityUtil.isConnectedFast(ctx)) {
            pDialogVolley.setMessage(ctx.getResources().getString(R.string.please_wait));
        } else {
            pDialogVolley.setMessage(ctx.getResources().getString(R.string.loader_please_wait_low_connectivity));

        }
        pDialogVolley.show();
        StringRequest req = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Http Response", method_name + ": " + response);
                        responseString[0] = response;
                        Log.d("TAG", response.toString());
                        pDialogVolley.hide();
                        try {




                            parseAppAuthDetails(response);

                            requestForLogin();



                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }


                    }






                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("TAG", "Error: " + error.getMessage());
                pDialogVolley.hide();
                Toaster.popLowNetworkConnectionToast(ctx);
            }
        });

        req.setRetryPolicy(new DefaultRetryPolicy(
                AppGlobalConstants.WEBSERVICE_TIMEOUT_VALUE_IN_MILLIS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        // Adding request to request queue
        App.getInstance().addToRequestQueue(req, tag_json_arry);


    }



    private boolean parseAppAuthDetails(String json) {


        boolean isSuccesful= false;
        try {


            JSONObject app_auth_json_obj = new JSONObject(json);
            accessTokenForTheFirstTime= app_auth_json_obj
                    .getString("at");




        } catch (JSONException e) {
            // TODO Auto-generated catch block
            Logs.setLogException(class_name, "parseJson()", e);
        }
        return isSuccesful;

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
