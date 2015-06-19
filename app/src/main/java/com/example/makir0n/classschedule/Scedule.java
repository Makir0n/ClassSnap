package com.example.makir0n.classschedule;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Scedule extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scedule);

        final Button EditBtn = (Button) findViewById(R.id.EditBtn);
        EditBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startEditActivity();
            }
        });

        final Button CameraBtn = (Button) findViewById(R.id.CameraBtn);
        CameraBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startCameraActivity();
            }
        });

        final Button CheckPhotoBtn = (Button) findViewById(R.id.CheckPhotoBtn);
        CheckPhotoBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startCheckPhotoActivity();
            }
        });
    }
    private void startEditActivity(){
        Intent intent=new Intent(this,Edit.class);
        startActivityForResult(intent, 0);
    }
    private void startCameraActivity(){
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        startActivityForResult(intent, 0);
    }
    private void startCheckPhotoActivity(){
        Intent intent=new Intent(this,CheckPhoto.class);
        startActivityForResult(intent,0);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scedule, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up edit, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
