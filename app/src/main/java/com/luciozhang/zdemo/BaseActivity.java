package com.luciozhang.zdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

import com.luciozhang.zdemo.utils.ToastUtils;

public class BaseActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private WebView webview;
    String api;
    String article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        setUpView();
    }

    protected void setUpView() {
        toolbar = (Toolbar) findViewById(R.id.zdemo_activity_base_toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {   // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        webview=(WebView)findViewById(R.id.zdemo_activity_base_wv_web);
    }

    public void setApi(String api) {
        this.api = api;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public void setToolbarTitle(String title){
        if(toolbar!=null)
            toolbar.setTitle(title);
    }

    public void showWeb(String url){
        webview.setVisibility(View.VISIBLE);
        webview.loadUrl(url);
    }

    public void hideWeb(){
        webview.setVisibility(View.GONE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.base_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id==android.R.id.home){
            if(webview.getVisibility()==View.VISIBLE){
                hideWeb();
            }else {
                finish();
            }
            return true;
        } else if (id == R.id.action_api) {
            showWeb(api);
            return true;
        } else if (id == R.id.action_article) {
            showWeb(article);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(webview.getVisibility()==View.VISIBLE){
            hideWeb();
        }else {
            super.onBackPressed();
        }

    }
}
