package com.example.i.mob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mob.MobSDK;
import com.mob.cms.gui.CMSGUI;
import com.mob.cms.gui.themes.defaultt.DefaultTheme;
import com.mob.tools.utils.DeviceHelper;
import com.mob.ums.OperationCallback;
import com.mob.ums.User;
import com.mob.ums.gui.UMSGUI;

public class MobActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mob);

        MobSDK.init(this);

        Button login = findViewById(R.id.button);
        Button user = findViewById(R.id.button2);
        Button recent = findViewById(R.id.button3);
        Button cmssdk = findViewById(R.id.button4);
        Button custom = findViewById(R.id.button5);
        Button anonyouse = findViewById(R.id.button6);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMSGUI.showLogin(new OperationCallback<User>(){
                    public void onSuccess(User myInfo) {
                        Toast.makeText(MobActivity.this, "SUCCESS", Toast.LENGTH_SHORT).show();
                    }

                    public void onFailed(Throwable t) {
                        Toast.makeText(MobActivity.this, "FALIED", Toast.LENGTH_SHORT).show();
                    }
                });
        }
        });
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMSGUI.showProfilePage();
            }
        });
        recent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UMSGUI.showRecommendationPage();
            }
        });

        cmssdk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CMSGUI.setTheme(DefaultTheme.class);
                // to use this entrance, you have to integrate UMSSDK first
                CMSGUI.showNewsListPageWithUMSSDKUser();
            }
        });
        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CMSGUI.setTheme(DefaultTheme.class);
                // this entrance will allow you to input your own user id, nickname and avatar to CMSSDK
                String uid = "12345";
                String nickname = "Player";
                String avatarUrl = "http://www.mob.com/public/images/logo_black.png";
                CMSGUI.showNewsListPageWithCustomUser(uid, nickname, avatarUrl);
            }
        });
        anonyouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CMSGUI.setTheme(DefaultTheme.class);
                // this entrance will create an anonymous user for CMSSDK
                CMSGUI.showNewsListPageWithAnonymousUser();
            }
        });
    }
}
