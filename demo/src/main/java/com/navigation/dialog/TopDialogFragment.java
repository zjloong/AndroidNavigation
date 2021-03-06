package com.navigation.dialog;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.navigation.R;

import me.listenzz.navigation.AwesomeFragment;

/**
 * Created by Listen on 2018/2/2.
 */
public class TopDialogFragment extends AwesomeFragment {

    Toolbar toolbar;

    @Override
    protected int preferredStatusBarColor() {
        return Color.TRANSPARENT;
    }

    @Override
    protected boolean preferredStatusBarColorAnimated() {
        return false;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.MyDialog);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dialog, container, false);
        toolbar = root.findViewById(R.id.toolbar);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // import
        appendStatusBarPadding(toolbar, getToolbarHeight());
        setStatusBarTranslucent(true);

        getDialog().setCanceledOnTouchOutside(true);  //点击外部消失
        Window window = getWindow();
        window.setGravity(Gravity.TOP);
        window.setWindowAnimations(R.style.TopDialog);
        window.setLayout(-1, -2);

    }


}
