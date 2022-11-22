package com.example.ex0831;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    ListView lv;
    TextView tv1,tv2,tv3,tv4;
    Spinner spin;
    String[] classes={"classes", "First", "Second", "Third", "Fourth"};
    String[][] names={{"a","b","c","d","e","f","g","h","i","j"},
            {"a2","b2","c2","d2","e2","f2","g2","h2","i2","j2"},
            {"a3","b3","c3","d3","e3","f3","g3","h3","i3","j3"},
            {"a4","b4","c4","d4","e4","f4","g4","h4","i4","j4"}};
    String[][] lastN={{"A","B","C","D","E","F","G","H","I","J"},
            {"A2","B2","C2","D2","E2","F2","G2","H2","I2","J2"},
            {"A3","B3","C3","D3","E3","F3","G3","H3","I3","J3"},
            {"A4","B4","C4","D4","E4","F4","G4","H4","I4","J4"}};
    String[][] dates={{"12/1/2006","2/11/2006","3/4/2006","4/7/2006","5/1/2006","6/12/2006","17/1/2006","8/9/2006","9/1/2006","10/11/2006"},
            {"14/12/2006","22/5/2006","11/4/2006","14/2/2006","18/12/2006","27/2/2006","17/12/2006","8/2/2006","9/2/2006","10/2/2006"},
            {"1/1/2006","2/1/2006","3/1/2006","4/1/2006","5/1/2006","6/1/2006","7/1/2006","8/1/2006","9/1/2006","10/1/2006"},
            {"1/1/2006","2/1/2006","3/1/2006","4/1/2006","5/1/2006","6/1/2006","7/1/2006","8/1/2006","9/1/2006","10/1/2006"}};
    String[][] phoneN={{"0504442905","0502007135","0542007112","052358168","0545381648","0525341648","0525381648","0502007135","0543312678","0525347855"},
            {"0504407135","0502007112","0542007112","052358168","0545381648","0525341648","0525381648","0502007135","0543312678","0525347855"},
            {"0504407135","0502007112","0542007112","052358168","0545381648","0525341648","0525381648","0502007135","0543312678","0525347855"},
            {"0504407135","0502007112","0542007112","052358168","0545381648","0525341648","0525381648","0502007135","0543312678","0525347855"}};
    int count=0;
    int num=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        ArrayAdapter<String> adp= new ArrayAdapter<>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, classes);
        spin.setAdapter(adp);
        spin.setOnItemSelectedListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setOnItemClickListener(this);
    }
    void initialize(){
        lv=findViewById(R.id.lv);
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);
        tv3=findViewById(R.id.tv3);
        tv4=findViewById(R.id.tv4);
        spin=findViewById(R.id.spin);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        count++;
        if (count>1){
            if (i==1){
                ArrayAdapter<String> adp=new ArrayAdapter<String>(this,
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, names[0]);
                lv.setAdapter(adp);
                num=0;
            }
            else if (i==2){
                ArrayAdapter<String> adp=new ArrayAdapter<String>(this,
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, names[1]);
                lv.setAdapter(adp);
                num=1;
            }
            else if (i==3){
                ArrayAdapter<String> adp=new ArrayAdapter<String>(this,
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, names[2]);
                lv.setAdapter(adp);
                num=2;
            }
            else if (i==4){
                ArrayAdapter<String> adp=new ArrayAdapter<String>(this,
                        androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, names[3]);
                lv.setAdapter(adp);
                num=3;
            }

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        tv1.setText(lastN[num][i]);
        tv2.setText(names[num][i]);
        tv3.setText(dates[num][i]);
        tv4.setText(phoneN[num][i]);
    }
}