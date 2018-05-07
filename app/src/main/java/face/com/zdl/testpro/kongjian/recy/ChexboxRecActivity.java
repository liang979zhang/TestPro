package face.com.zdl.testpro.kongjian.recy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import face.com.zdl.testpro.R;

public class ChexboxRecActivity extends AppCompatActivity {

    @BindView(R.id.recycler)
    RecyclerView recycler;

    Myadapter myadapter;
    List<RelBean> relBeans = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chexbox_rec);
        ButterKnife.bind(this);

        recycler.setLayoutManager(new LinearLayoutManager(this));



        for (int i = 0; i < 52; i++) {
            RelBean relBean = new RelBean();
            relBean.setIschek(false);
            relBeans.add(relBean);

        }
        recycler.setAdapter(new Myadapter(relBeans));

    }
}
