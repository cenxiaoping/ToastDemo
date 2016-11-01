package spanlogistics.oxbix.com.toastdemo;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnNorToast;
    private Button mBtnCusToast;
    private Toast mToast;
    private View mView;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnNorToast = (Button) findViewById(R.id.btn_nortoast);
        mBtnCusToast = (Button) findViewById(R.id.btn_custoast);

        mBtnNorToast.setOnClickListener(this);
        mBtnCusToast.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_nortoast:
                Toast.makeText(this, "Hello_Toast", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_custoast:
                ToastCompat.makeText(this, "Hello_Toast", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
