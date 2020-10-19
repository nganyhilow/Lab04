package com.nganphan.lab04;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class LunchList extends Activity {
    private Restaurant r = new Restaurant();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(onSave);
    }

    private View.OnClickListener onSave = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText name = (EditText)findViewById(R.id.name);
            EditText address = (EditText)findViewById(R.id.address);
            r.setName(name.getText().toString());
            r.setAddress(address.getText().toString());
            RadioGroup type = (RadioGroup)findViewById(R.id.type);
            switch (type.getCheckedRadioButtonId()) {
                case R.id.take_out:
                    r.setType("Take out");
                    break;
                case R.id.sit_down:
                    r.setType("Sit down");
                    break;
                case R.id.delivery:
                    r.setType("Delivery");
                    break;
                default:
                    break;
            }
            String result = r.getName() +" " + r.getAddress() +" "+ r.getType();
            Toast.makeText(LunchList.this, result, Toast.LENGTH_SHORT).show();
        }
    };
}