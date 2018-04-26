package face.com.zdl.testpro;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Administrator on 2018/4/26.
 */

public class MyApplication extends Application {

    private static Realm realm;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration config =
                new RealmConfiguration.Builder()
                        // 文件名
                        .name("test.realm")
                        // 版本号
                        .schemaVersion(1)
                        .build();
        realm = Realm.getInstance(config);

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());


    }


    public static Realm getRealm() {
        return realm;
    }
}
