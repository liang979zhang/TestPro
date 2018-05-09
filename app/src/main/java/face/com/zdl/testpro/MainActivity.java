package face.com.zdl.testpro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import face.com.zdl.testpro.dsbrige.DesBrigeActivity;
import face.com.zdl.testpro.kongjian.DragActivity;
import face.com.zdl.testpro.kongjian.baner.BannerActivity;
import face.com.zdl.testpro.kongjian.bottom.BottomActivity;
import face.com.zdl.testpro.database.RealmActivity;
import face.com.zdl.testpro.kongjian.imagesel.ImgSelActivity;
import face.com.zdl.testpro.kongjian.recy.ChexboxRecActivity;
import face.com.zdl.testpro.map.MapActivity;
import face.com.zdl.testpro.pay.PayActivity;

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

        addView();
    }

    private void addView() {
//        MoveImageView moveImageView = new MoveImageView(this);

    }

    @OnClick({R.id.btn_banner, R.id.btn_paoma})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_banner:

                startActivity(new Intent(MainActivity.this, BannerActivity.class));
                break;
            case R.id.btn_paoma:
//                startActivity(new Intent(MainActivity.this, BottomActivity.class));
                startActivity(new Intent(MainActivity.this, DragActivity.class));

//                ActionSheetDialog actionSheetDialog = new ActionSheetDialog(this);
//                actionSheetDialog.builder().addSheetItem("aaaa", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
//                    @Override
//                    public void onClick(int which) {
//
//                    }
//                })
//                        .addSheetItem("aaaa", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
//                            @Override
//                            public void onClick(int which) {
//
//                            }
//                        })
//                        .setTitle("addadad")
//                        .setCancelable(true)
//                        .show();
                break;
        }
    }

    public void databaseclick(View view) {
        startActivity(new Intent(MainActivity.this, RealmActivity.class));
    }

    public void mapclick(View view) {
        startActivity(new Intent(MainActivity.this, MapActivity.class));
    }

    public void pay(View view) {
        startActivity(new Intent(MainActivity.this, PayActivity.class));
    }

    public void imgsel(View view) {
        startActivity(new Intent(MainActivity.this, ImgSelActivity.class));

    }

    public void kongjian(View view) {
//        startActivity(new Intent(this, ChexboxRecActivity.class));
        startActivity(new Intent(this, DesBrigeActivity.class));

    }
}
