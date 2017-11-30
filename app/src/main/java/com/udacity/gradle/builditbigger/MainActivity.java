package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    protected ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        findViews();
    }

    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }

    protected void findViews() {
        progressBar = findViewById(R.id.progress);
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

    public void tellJoke(View view) {
        new EndpointShowJokeAsyncTask(this){
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                doBeforeExecuteTask();
            }
            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                doAfterExecuteTask();
            }
        }.execute();
    }

    protected void doBeforeExecuteTask() {
        if(progressBar != null)
            progressBar.setVisibility(View.VISIBLE);
    }

    protected void doAfterExecuteTask() {
        if(progressBar != null)
            progressBar.setVisibility(View.INVISIBLE);
    }

}
