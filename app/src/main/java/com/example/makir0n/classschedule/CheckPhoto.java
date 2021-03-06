package com.example.makir0n.classschedule;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CheckPhoto extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_photo);

       getPhoto();
    }
    void getPhoto() {
        //TextView sizeText = (TextView) findViewById(R.id.sizeinfo);
        TextView dateText = (TextView) findViewById(R.id.dateinfo);
        //TextView latlongText = (TextView) findViewById(R.id.latlonginfo);
        ImageView thumbnailView = (ImageView) findViewById(R.id.thumbnail);
        // ExifInterfaceのインスタンス取得
        ExifInterface exif = null;
        try {
            exif = new ExifInterface(Environment.getExternalStorageDirectory() + "/DCIM/100ANDRO/" + "DSC_0811.JPG");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (exif != null) {
            // 画像情報
            /*
            String info = String.format("size: %d x %d",
                    exif.getAttributeInt(ExifInterface.TAG_IMAGE_WIDTH, -1),
                    exif.getAttributeInt(ExifInterface.TAG_IMAGE_LENGTH, -1));
            sizeText.setText(info);
*/
            String info = String.format("date: %s", exif.getAttribute(ExifInterface.TAG_DATETIME));
            dateText.setText(info);
            //loat[] latlong = new float[2];
            //exif.getLatLong(latlong);
            //info = String.format("latlong: %f, %f", latlong[0], latlong[1]);
            //latlongText.setText(info);
            // サムネイル
            if (exif.hasThumbnail()) {
                byte[] image = exif.getThumbnail();
                Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
                thumbnailView.setImageBitmap(bitmap);
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_camera, menu);
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


