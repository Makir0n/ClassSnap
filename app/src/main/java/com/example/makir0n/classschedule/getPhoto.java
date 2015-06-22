package com.example.makir0n.classschedule;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by makir0n on 15/06/22.
 */
public class getPhoto extends Activity {

    getPhoto() {
        //TextView sizeText = (TextView) findViewById(R.id.sizeinfo);
        TextView dateText = (TextView) findViewById(R.id.dateinfo);
        //TextView latlongText = (TextView) findViewById(R.id.latlonginfo);
        ImageView thumbnailView = (ImageView) findViewById(R.id.thumbnail);
        // ExifInterfaceのインスタンス取得
        ExifInterface exif = null;
        try {
            exif = new ExifInterface(Environment.getExternalStorageDirectory().getPath() + "/DSC_0811.jpg");
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

}
