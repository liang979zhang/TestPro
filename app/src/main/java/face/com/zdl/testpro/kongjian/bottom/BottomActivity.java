package face.com.zdl.testpro.kongjian.bottom;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import face.com.zdl.testpro.R;


public class BottomActivity extends AppCompatActivity {
    AHBottomNavigation ahBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        ahBottomNavigation = findViewById(R.id.bottom_navigation);

        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Label One", R.mipmap.ic_content_add);//第三个参数是背景颜色,切换更改背景颜色
//        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Label One", R.drawable.ic_content_add);//第三个参数是背景颜色
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Label Two", R.mipmap.ic_maps_local_attraction);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Label Three", R.mipmap.ic_maps_local_bar);

// Add items
        ahBottomNavigation.addItem(item1);
        ahBottomNavigation.addItem(item2);
        ahBottomNavigation.addItem(item3);


        ahBottomNavigation.setDefaultBackgroundColor(Color.parseColor("#455C65"));//底部的背景颜色 这里设置的颜色上面就不用设置颜色了

        // Disable the translation inside the CoordinatorLayout
//        ahBottomNavigation.setBehaviorTranslationEnabled(true);

        // Change colors
        ahBottomNavigation.setAccentColor(Color.RED);//选中的颜色
        ahBottomNavigation.setInactiveColor(Color.parseColor("#747474"));//默认颜色

        // Use colored navigation with circle reveal effect
        ahBottomNavigation.setColored(false); //false 设置的颜色起作用

        // Set current item programmatically
        ahBottomNavigation.setCurrentItem(0);
    }
}
