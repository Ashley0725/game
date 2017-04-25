package com.example.ashleywong.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.ashleywong.myapplication.utility.Prefs;
import com.google.android.gms.location.GeofenceStatusCodes;

public class HomeActivity extends Activity {
    private Button mBtnLeaderboard;
    private Button mBtnMulti;
    private Button mBtnResume;
    private Button mBtnSingle;
    private int mLevelDuration;

    /* renamed from: net.androidiconpacks.findmulti.HomeActivity.1 */
    class C06371 implements OnClickListener {
        C06371() {
        }

        public void onClick(View v) {
            Prefs.clearPref(HomeActivity.this.getApplicationContext());
            Prefs.setStagePref(HomeActivity.this.getApplicationContext(), 1);
            HomeActivity.this.startActivity(new Intent(HomeActivity.this, PlayActivity.class));
        }
    }

    /* renamed from: net.androidiconpacks.findmulti.HomeActivity.2 */
    class C06382 implements OnClickListener {
        C06382() {
        }

        public void onClick(View v) {
            HomeActivity.this.startActivity(new Intent(HomeActivity.this, PlayActivity.class));
        }
    }

    /* renamed from: net.androidiconpacks.findmulti.HomeActivity.3 */

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.mLevelDuration = getResources().getInteger(R.integer.levelDuration);
        this.mLevelDuration *= GeofenceStatusCodes.GEOFENCE_NOT_AVAILABLE;
        this.mBtnSingle = (Button) findViewById(R.id.btnSingle);
        this.mBtnSingle.setOnClickListener(new C06371());
        this.mBtnResume = (Button) findViewById(R.id.btnResume);
        this.mBtnResume.setOnClickListener(new C06382());
        this.mBtnMulti = (Button) findViewById(R.id.btnMulti);
        if (Prefs.getResumePref(getApplicationContext()) == this.mLevelDuration) {
            this.mBtnResume.setVisibility(View.GONE);
        } else {
            this.mBtnResume.setVisibility(View.VISIBLE);
        }
    }

    protected void onRestart() {
        super.onRestart();
        if (Prefs.getResumePref(getApplicationContext()) == this.mLevelDuration) {
            this.mBtnResume.setVisibility(View.GONE);
        } else {
            this.mBtnResume.setVisibility(View.VISIBLE);
        }
    }
}
