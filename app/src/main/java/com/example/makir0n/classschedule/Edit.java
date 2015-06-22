package com.example.makir0n.classschedule;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;


public class Edit extends Activity {

    //String text;
    String LOCAL_FILE = "classschedule.txt";
    EditText inputText = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        FileInputStream in;
        String lineBuffer;
        inputText = (EditText)this.findViewById(R.id.editText);

        try {
            in = openFileInput(LOCAL_FILE); //LOCAL_FILE = "log.txt";
            BufferedReader reader= new BufferedReader(new InputStreamReader(in,"UTF-8"));
            while( (lineBuffer = reader.readLine()) != null ){
                inputText.append(lineBuffer);
            }
        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            inputText.setText("error");
        }
        final Button backBtn = (Button) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                inputText.selectAll();
                String s = inputText.getText().toString();
                //System.out.print(s);
                try{

                    FileOutputStream out = openFileOutput(LOCAL_FILE,MODE_PRIVATE);
                    PrintWriter writer =
                    new PrintWriter(new OutputStreamWriter(out,"UTF-8"));
                    writer.append(s);
                    writer.close();
                }catch(IOException e){
                    e.printStackTrace();
                    System.out.print("error");
                }

                backScheduleActivity();
            }
        });
    }

    public void backScheduleActivity() {
        Intent intent = new Intent(this, Scedule.class);
        startActivityForResult(intent, 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit1, menu);
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
