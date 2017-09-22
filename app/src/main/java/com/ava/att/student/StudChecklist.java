package com.ava.att.student;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ava.att.MainActivity;
import com.ava.att.R;
import com.ava.att.importxls;

import java.util.ArrayList;

public class StudChecklist extends AppCompatActivity {
    public ArrayList<Student> StudList=new ArrayList<>();
    ArrayList<CheckBox>arrayCheckBox=new ArrayList<>();

    CheckBox cb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stud_checklist);
        LinearLayout CheckBoxContainer =(LinearLayout)findViewById(R.id.checkbox_container);


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
        if (id == R.id.action_importExcel) {
            Intent i4 = new Intent(StudChecklist.this, importxls.class);
            startActivityForResult(i4,1);
        }

        return super.onOptionsItemSelected(item);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String returnValue = data.getStringExtra("key2");
                Toast.makeText(getApplicationContext(), "" + returnValue, Toast.LENGTH_LONG).show();
                for (int i = 0; i < StudList.size(); i++) {
                    CheckBox ch = new CheckBox(this);
                    ch.setText(StudList.get(i).getName());
                    for(int j=0;j<StudList.size();j++)
                    {
                        cb=new CheckBox(this);
                        cb.setId(j);
                       // cb.setText(StudList.getName());
                    }

                }
                if (resultCode == RESULT_CANCELED) {
                    //Write your code if there's no result
                }
            }
        }
    }
}
