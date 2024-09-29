package com.mukheeth.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etInr;
    TextView tvResult;
    Button btnConvertToAED, btnConvertToEUR, btnConvertToUSD;

    // Hardcoded conversion rates (you can change these as needed)
    double conversionRateToAED = 0.044; // 1 INR = 0.044 AED (approximate)
    double conversionRateToEUR = 0.011; // 1 INR = 0.011 EUR (approximate)
    double conversionRateToUSD = 0.012; // 1 INR = 0.012 USD (approximate)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        etInr = findViewById(R.id.etInr);
        tvResult = findViewById(R.id.tvResult);
        btnConvertToAED = findViewById(R.id.btnConvertToAED);
        btnConvertToEUR = findViewById(R.id.btnConvertToEUR);
        btnConvertToUSD = findViewById(R.id.btnConvertToUSD);

        // Set up button click listeners for currency conversion
        btnConvertToAED.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertCurrency(conversionRateToAED, "AED");
            }
        });

        btnConvertToEUR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertCurrency(conversionRateToEUR, "EUR");
            }
        });

        btnConvertToUSD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertCurrency(conversionRateToUSD, "USD");
            }
        });
    }

    // Method to convert INR to target currency and display the result
    private void convertCurrency(double conversionRate, String currency) {
        String inrAmountStr = etInr.getText().toString();
        if (!inrAmountStr.isEmpty()) {
            double inrAmount = Double.parseDouble(inrAmountStr);
            double convertedAmount = inrAmount * conversionRate;
            tvResult.setText("Converted Amount: " + String.format("%.2f", convertedAmount) + " " + currency);
        } else {
            tvResult.setText("Please enter a valid amount.");
        }
    }
}
