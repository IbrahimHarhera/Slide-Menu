package com.example.ibrahim.slidemenu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

    public ImageView imgMenuIcon, btnBack;
    public TextView tvTitle;
    private View toolBarContainer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBehindView();
        initViews();
        initActionDriven();
    }


    private void initViews() {
        toolBarContainer =(View)findViewById(R.id.tool_bar_main_activity);
        imgMenuIcon = (ImageView) toolBarContainer.findViewById(R.id.img_actionbar_menu_icon);
        btnBack = (ImageView) toolBarContainer.findViewById(R.id.btn_back);
        tvTitle = (TextView) toolBarContainer.findViewById(R.id.tv_actionbar_menu_title);

        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setShadowWidthRes(R.dimen.shadow_width);
        slidingMenu.setShadowDrawable(R.drawable.shadow);
        slidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
//        slidingMenu.setFadeDegree(4/8);
//        slidingMenu.setFadeEnabled(true);
        slidingMenu.setTouchModeAbove(SlidingMenu.SLIDING_CONTENT);
            slidingMenu.setMode(0);
    }


    private void initActionDriven() {
        imgMenuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle();
            }
        });

    }

    private void setBehindView() {
        setBehindContentView(R.layout.menu_slide);
        transactionFragments(MenuFragment.newInstance(), R.id.menu_slide);
    }

    public void transactionFragments(Fragment fragment, int viewResource) {

         getSupportFragmentManager().beginTransaction().replace(viewResource,fragment).commit();
        toggle();
//        getSlidingMenu().showContent();
//        showContent();
    }
}
