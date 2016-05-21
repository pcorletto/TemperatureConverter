package com.example.android.temperatureconverter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends ActionBarActivity {

    private Conversion mConversion = new Conversion();
    private double mInputCelsius;
    private double mInputFahrenheit;
    private double mOutputTemperature;

    private EditText mInputTemperature;
    private TextView mResultTemperature;
    private TextView mResultPromptDegrees;
    private Button mConvertButton;

    DecimalFormat df = new DecimalFormat("#.#");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInputTemperature = (EditText) findViewById(R.id.input_temperature_editText);
        mResultTemperature = (TextView) findViewById(R.id.result_temperature_textView);
        mResultPromptDegrees = (TextView) findViewById(R.id.result_prompt_degrees_textView);
        mConvertButton = (Button) findViewById(R.id.convert_button);

        mConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mResultTemperature.setText(df.format(mOutputTemperature));
                mResultPromptDegrees.setVisibility(View.VISIBLE);

            }
        });

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.celsius_radioButton:
                if (checked)
                    // Convert celsius to fahrenheit

                mResultTemperature.setText("");
                mResultPromptDegrees.setText("");
                mInputCelsius = Double.parseDouble(mInputTemperature.getText().toString());
                mOutputTemperature = mConversion.celsiusToFahrenheit(mInputCelsius);
                mResultPromptDegrees.setVisibility(View.INVISIBLE);
                mResultPromptDegrees.setText(getString(R.string.fahrenheit_prompt));


                    break;

            case R.id.fahrenheit_radioButton:
                if (checked)
                    // Convert fahrenheit to celsius

                mResultTemperature.setText("");
                mResultPromptDegrees.setText("");
                mInputFahrenheit = Double.parseDouble(mInputTemperature.getText().toString());
                mOutputTemperature = mConversion.fahrenheitToCelsius(mInputFahrenheit);
                mResultPromptDegrees.setVisibility(View.INVISIBLE);
                mResultPromptDegrees.setText(getString(R.string.celsius_prompt));

                    break;
        }
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
