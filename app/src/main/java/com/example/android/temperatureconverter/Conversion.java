package com.example.android.temperatureconverter;

/**
 * Created by hernandez on 5/14/2016.
 */
public class Conversion {

    public Conversion(){

    }

    public double celsiusToFahrenheit(double celsius){

        double fahrenheit = ( ( celsius * 9 ) / 5 ) + 32;
        return fahrenheit;
    }

    public double fahrenheitToCelsius(double fahrenheit){

        double celsius = ( ( fahrenheit - 32 ) * 5 ) / 9;
        return celsius;
    }
}
