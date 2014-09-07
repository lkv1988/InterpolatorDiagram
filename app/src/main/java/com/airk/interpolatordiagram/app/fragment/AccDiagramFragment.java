package com.airk.interpolatordiagram.app.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.EditText;

import com.airk.interpolatordiagram.app.R;
import com.airk.interpolatordiagram.app.widget.DiagramView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by kevin on 14-9-5.
 *
 * Acc
 */
public class AccDiagramFragment extends Fragment implements TextWatcher {
    @InjectView(R.id.factor)
    EditText mFactor;
    @InjectView(R.id.diagram)
    DiagramView mDiagram;
    private Interpolator mInterpolator;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.acc_fragment, container, false);
        ButterKnife.inject(this, v);
        mInterpolator = new AccelerateInterpolator();
        mDiagram.setInterpolator(mInterpolator);
        mFactor.addTextChangedListener(this);
        return v;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        float factor;
        if (TextUtils.isEmpty(s)) {
            factor = 1f;
        } else {
            factor = Float.valueOf(s.toString());
        }
        mInterpolator = null;
        mInterpolator = new AccelerateInterpolator(factor);
        mDiagram.setInterpolator(mInterpolator);
    }

    @Override
    public void afterTextChanged(Editable s) {
    }
}
