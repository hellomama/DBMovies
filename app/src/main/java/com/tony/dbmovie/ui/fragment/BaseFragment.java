package com.tony.dbmovie.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tony.dbmovie.R;
import com.tony.dbmovie.common.Common;

import static com.tony.dbmovie.common.Common.EXTRA_ID;

/**
 * Created by bushi on 2018/3/31.
 */

public class BaseFragment extends Fragment {

    private String title = "";

    public static BaseFragment getInstance(String tag)
    {
        BaseFragment fragment = new BaseFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_ID,tag);
        fragment.setArguments(bundle);
        return fragment;
    }

    private void initArgs(){
        Bundle bundle = getArguments();
        if (bundle != null)
        {
            title = bundle.getString(EXTRA_ID);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base,container,false);
        TextView titleView = view.findViewById(R.id.fragment_text);
        initArgs();
        titleView.setText(title);
        return view;
    }
}
