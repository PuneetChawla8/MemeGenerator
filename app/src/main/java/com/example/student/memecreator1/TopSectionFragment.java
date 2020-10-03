package com.example.student.memecreator1;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.view.ViewGroup;

public class TopSectionFragment extends Fragment {
    private EditText topInput;
    private EditText bottomInput;

    public interface TopSectionListener
    {
        public void createMeme(String top,String bottom);
    }
    TopSectionListener activityCommander;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.topsectionfragment,container,false);
        topInput=(EditText)view.findViewById(R.id.topInput);
        bottomInput=(EditText)view.findViewById(R.id.bottomInput);
   final Button button=(Button)view.findViewById(R.id.button);
        button.setOnClickListener(
        new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {


                activityCommander.createMeme(topInput.getText().toString(), bottomInput.getText().toString());
            }
        }
        );
        return view;

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try
        {
            activityCommander=(TopSectionListener)activity;
        }
        catch(ClassCastException e)
        {
            throw new ClassCastException(activity.toString());
        }
    }
}
