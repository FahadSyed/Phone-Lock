package com.example.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{
    Button done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        done = (Button)findViewById(R.id.destroyPhone);
        done.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Start service upong click and display toast to let user know phone has been locked
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.destroyPhone:
                Intent svc = new Intent(this, FilterService.class);
                startService(svc);
                Toast.makeText(this, "Phone locked", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
