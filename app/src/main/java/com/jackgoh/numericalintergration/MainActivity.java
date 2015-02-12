package com.jackgoh.numericalintergration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSet = (Button)findViewById(R.id.btnSetEquation);
        final EditText txtequ= (EditText)findViewById(R.id.txtEquation);


        btnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String check=txtequ.getText().toString().trim();
                if(check.matches("") || check==null) {
                Toast.makeText(getApplicationContext(), "Please enter equation", Toast.LENGTH_SHORT).show();
                }

                else {
                    Intent rule = new Intent(getApplicationContext(), RuleActivity.class);
                    rule.putExtra("equation", txtequ.getText().toString());
                    startActivity(rule);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
