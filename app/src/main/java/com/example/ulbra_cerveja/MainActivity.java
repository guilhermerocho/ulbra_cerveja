package com.example.ulbra_cerveja;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText vol_355 = (EditText) findViewById(R.id.textView355);
        final EditText vol_475 = (EditText) findViewById(R.id.textView475);
        final EditText vol_1 = (EditText) findViewById(R.id.textView1);
        final EditText result = (EditText) findViewById(R.id.editTextResult);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(vol_355.getText().length() == 0){
                    vol_355.setError("Enter a value");
                } else if(vol_475.getText().length() == 0){
                    vol_475.setError("Enter a value");
                } else if(vol_1.getText().length() == 0){
                    vol_1.setError("Enter a value");
                } else {
                    result.setText(calculate(vol_355, vol_475, vol_1));
                }
            }
        });
    }

    public String calculate(EditText et_355, EditText et_475, EditText et_1){
        Double v355 = Double.valueOf(et_355.getText().toString());
        Double v475 = Double.valueOf(et_475.getText().toString());
        Double v1 = Double.valueOf(et_1.getText().toString());
        String result = "";

        v355 = v355 / 355;
        v475 = v475 / 475;
        v1 = v1 / 1000;

        if ((v355 < v475) && (v355 < v1)){
            result = "Volume 355 is the cheapest one!";
        } else if ((v475 < v355) && (v475 < v1)){
            result = "Volume 475 is the cheapest one!";
        } else if ((v1 < v355) && (v1 < v475)){
            result = "Big liter is the cheapest one!";
        }

        return result;
    }
}
