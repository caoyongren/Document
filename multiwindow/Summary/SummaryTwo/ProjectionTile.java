package com.android.systemui.qs.tiles;

import android.view.KeyEvent;
import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;
import android.content.Context;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.util.Log;

import com.android.systemui.R;
import com.android.systemui.qs.QSTile;
import com.android.systemui.qs.QSTile.BooleanState;
import com.android.systemui.qs.QSTile.Host;
import com.android.systemui.statusbar.phone.QSTileHost;

import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.Toast;
import android.view.Gravity;

public class ProjectionTile extends QSTile<QSTile.BooleanState> {
    private static final String TAG = "ProjectionTile";
    private QSTileHost mHost;
    private Boolean mBoolean = false;
    private BooleanState mBooleanState;
  
    private PopupWindow mPopupWindow;
    private View popupView ;

    public ProjectionTile(Host host) {
        super(host);
        mHost = (QSTileHost) host;
    }

    @Override
    protected BooleanState newTileState() {
        return new BooleanState();
    }

    @Override
    public void setListening(boolean listening) {
    }

    @Override
    protected void handleClick() {
       // mBoolean = true;
       // mBooleanState.icon = ResourceIcon.get(R.drawable.ic_notification_projection_on);
        popupView = mContext.getLayoutInflater().inflate(R.layout.projection_popupwindow, null);
        mPopupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT,
                                              LinearLayout.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(mContext.getResources(), (Bitmap) null))
        mPopupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
    }

    @Override
    protected void handleUpdateState(BooleanState state, Object arg) {
       // mBooleanState = state;
        state.label = mContext.getResources().getString(R.string.quick_settings_projection_label);
        state.visible = true;
       // state.value = true;
       // if (mBoolean) {
            state.icon = ResourceIcon.get(R.drawable.ic_notification_projection_on);
       // } else {
         //   state.icon = ResourceIcon.get(R.drawable.ic_notification_projection_off);
       // }
    }
}
