package face.com.zdl.testpro.database;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import face.com.zdl.cctools.ToastUtils;
import face.com.zdl.testpro.MyApplication;
import face.com.zdl.testpro.R;
import face.com.zdl.testpro.bean.Dog;
import face.com.zdl.testpro.bean.User;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class RealmActivity extends AppCompatActivity {

    @BindView(R.id.et)
    EditText et;
    private Realm realm;

    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm);
        ButterKnife.bind(this);

        realm = MyApplication.getRealm();


    }

    public void add(View view) {

        i += 1;
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                User user = realm.createObject(User.class);
                user.setId(123 + i);
                user.setAge(25 + i);
                user.setName("张三");


                RealmList<Dog> dogs = user.getDogs();

                Dog dog = realm.createObject(Dog.class);
                dog.setAge(2 + i);
                dog.setName("lili");

                Dog dog2 = realm.createObject(Dog.class);
                dog2.setAge(5 + i);
                dog2.setName("lisa");

                Dog dog3 = realm.createObject(Dog.class);
                dog3.setAge(15 + i);
                dog3.setName("sali");


                dogs.add(dog);
                dogs.add(dog2);
                dogs.add(dog3);


            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.e("tag", "插入数据成功");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.e("tag", "插入数据失败");

            }
        });
    }


    public void del(View view) {


        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                RealmResults<User> userall = realm.where(User.class).findAll();
                userall.deleteAllFromRealm();
                RealmResults<Dog> dogs = realm.where(Dog.class).findAll();
                dogs.deleteAllFromRealm();


            }
        });


    }

    public void edit(View view) {

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                User user = realm.where(User.class).findFirst();
                user.setName("李四");

            }
        });


    }


    public void chaf(View view) {
        String str = null;
        RealmResults<User> all = realm.where(User.class).findAll();

        for (int j = 0; j < all.size(); j++) {

            str += all.get(j).toString() + "-----";
        }

        Log.e("tag", str + "");
        ToastUtils.showShortToast(this, str);


    }

    public void chaz(View view) {
        String str = "";
        String string = et.getText().toString();
        if (string.length() == 0) {
            str = "";
            RealmResults<Dog> all = realm.where(Dog.class).findAll();

            for (int j = 0; j < all.size(); j++) {

                str += all.get(j).toString() + "-----";
            }

        } else {
            str = "";
            RealmResults<User> users = realm.where(User.class).equalTo("id", Integer.valueOf(string)).findAll();


            for (int j = 0; j < users.size(); j++) {
                str += users.get(j).toString() + "-----";
            }
        }


        Log.e("tag", str + "");
        ToastUtils.showShortToast(this, str);
    }

}
