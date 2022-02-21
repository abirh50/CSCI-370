package edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity {

    private EditText cAmount;
    private EditText size;

    private Button button;

    private EditText tip15;
    private EditText tip20;
    private EditText tip25;
    private EditText total15;
    private EditText total20;
    private EditText total25;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        cAmount = findViewById(R.id.checkAmountValue);
        size = findViewById(R.id.partySizeValue);

        tip15 = findViewById(R.id.fifteenPercentTipValue);
        tip20 = findViewById(R.id.twentyPercentTipValue);
        tip25 = findViewById(R.id.twentyfivePercentTipValue);
        total15 = findViewById(R.id.fifteenPercentTotalValue);
        total20 = findViewById(R.id.twentyPercentTotalValue);
        total25 = findViewById(R.id.twentyfivePercentTotalValue);

        button = findViewById(R.id.buttonCompute);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                calculate();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void calculate(){
        double amount; // Check amount
        double each;   // bill per person without tips
        int members;   // party size
        int tip1;      // 15% tip
        int tip2;      // 20% tip
        int tip3;      // 25% tip
        int total1;    // 15% total
        int total2;    // 20% total
        int total3;    // 25% total

        if(!cAmount.getText().toString().equals("") && !size.getText().toString().equals("")){
            amount = Double.parseDouble(cAmount.getText().toString());
            members = Integer.parseInt(size.getText().toString());
            each = amount / members;

            tip1 = (int) Math.round(each*(.15));
            tip2 = (int) Math.round(each*(.20));
            tip3 = (int) Math.round(each*(.25));

            total1 = (int) Math.round(tip1+each);
            total2 = (int) Math.round(tip2+each);
            total3 = (int) Math.round(tip3+each);

            tip15.setText(Integer.toString(tip1));
            tip20.setText(Integer.toString(tip2));
            tip25.setText(Integer.toString(tip3));

            total15.setText(Integer.toString(total1));
            total20.setText(Integer.toString(total2));
            total25.setText(Integer.toString(total3));

            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            assert imm != null;
            imm.hideSoftInputFromWindow(button.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
        }
        else {
            Context context = getApplicationContext();
            CharSequence text = "Empty or incorrect value(s)!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

}