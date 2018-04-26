package face.com.zdl.testpro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import face.com.zdl.testpro.baner.BannerActivity;
import face.com.zdl.testpro.bottom.BottomActivity;
import face.com.zdl.testpro.database.RealmActivity;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.btn_banner)
    Button btnBanner;
    @BindView(R.id.btn_paoma)
    Button btnPaoma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_banner, R.id.btn_paoma})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_banner:

                startActivity(new Intent(MainActivity.this, BannerActivity.class));
                break;
            case R.id.btn_paoma:
                startActivity(new Intent(MainActivity.this, BottomActivity.class));

                break;
        }
    }

    public void databaseclick(View view) {
        startActivity(new Intent(MainActivity.this, RealmActivity.class));
    }
}