package id.myholiday.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtWidth, edtLength, edtHeight;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWidth        = (EditText) findViewById(R.id.edt_width);
        edtHeight       = (EditText) findViewById(R.id.edt_height);
        edtLength       = (EditText) findViewById(R.id.edt_length);
        btnCalculate    = (Button) findViewById(R.id.btn_calculate);
        tvResult        = (TextView) findViewById(R.id.tv_result);
        btnCalculate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.btn_calculate){
            String length   = edtLength.getText().toString().trim();
            String width    = edtWidth.getText().toString().trim();
            String height   = edtHeight.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(length)){
                isEmptyFields = true;
                edtLength.setError("Tidak boleh kosong");
            }
            if (TextUtils.isEmpty(width)){
                isEmptyFields = true;
                edtWidth.setError("Tidak Boleh Kosong");
            }
            if (TextUtils.isEmpty(height)){
                isEmptyFields = true;
                edtHeight.setError("Tidak boleh kosong");
            }
            if (!isEmptyFields){
                double l    = Double.parseDouble(length);
                double w    = Double.parseDouble(width);
                double h    = Double.parseDouble(height);
                double volume = l * w * h;
                tvResult.setText(String.valueOf(volume));
            }
        }
    }
}
