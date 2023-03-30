package com.han.core.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BaseDialog extends Dialog {
    public BaseDialog(@NonNull Context context) {
        this(context,-1);
    }

    public BaseDialog(@NonNull Context context, int themeResId) {
        this(context, false,null);

    }

    protected BaseDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initConfig();


    }

    private void initConfig() {
        Window window = getWindow();

        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        window.setBackgroundDrawable(
                getContext().getResources().getDrawable(android.R.color.transparent));
        WindowManager.LayoutParams params = window.getAttributes();// 先获得窗体的原始样式,我们在这个基础上改
        params.gravity = Gravity.CENTER;// 设置弹出位置
        window.setAttributes(params);

//        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE |
//                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

}
