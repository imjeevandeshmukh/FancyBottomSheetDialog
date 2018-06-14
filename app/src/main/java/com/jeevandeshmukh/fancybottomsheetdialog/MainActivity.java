package com.jeevandeshmukh.fancybottomsheetdialog;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jeevandeshmukh.fancybottomsheetdialoglib.FancyBottomSheetDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = (Button)findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 showDiolog();
            }
        });


    }
    public void showDiolog(){
        new FancyBottomSheetDialog.Builder(this)
                .setTitle("Alert bottom sheet dialog")
                .setMessage("This is where we show the information.This is a message.This is where we show message explain or showing the information.")
                .setBackgroundColor(Color.parseColor("#3F51B5"))
                .setIcon(R.drawable.ic_pan_tool_black_24dp,true)
                .isCancellable(false)
                .OnNegativeClicked(new FancyBottomSheetDialog.FancyBottomSheetDialogListener() {
                    @Override
                    public void OnClick() {

                    }
                })
                .OnPositiveClicked(new FancyBottomSheetDialog.FancyBottomSheetDialogListener() {
                    @Override
                    public void OnClick() {

                    }
                })
                .setNegativeBtnText("Cancel")
                .setPositiveBtnText("Ok")
                .setPositiveBtnBackground(Color.parseColor("#3F51B5"))
                .setNegativeBtnBackground(Color.WHITE)
                .build();
    }
}
