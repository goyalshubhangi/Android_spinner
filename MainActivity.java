package com.example.faisal.spinner;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String[] list;
   private TypedArray img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=getResources().getStringArray(R.array.object_array);
        img=getResources().obtainTypedArray(R.array.object_image);
        TextView text1=(TextView)findViewById(R.id.textview);
        final ImageView i1=(ImageView)findViewById(R.id.imageview);
       final Spinner spinn=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> spinnerAdapter =new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,list);
        spinn.setAdapter(spinnerAdapter);
        spinn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                i1.setImageResource(img.getResourceId(spinn.getSelectedItemPosition(),-1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

}
