package com.jeevandeshmukh.fancybottomsheetdialoglib;

import android.app.Activity;
import android.app.Dialog;
import android.support.annotation.ColorInt;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class FancyBottomSheetDialog {

    private String title, message, positiveBtnText, negativeBtnText;
    private Activity activity;
    private int icon;
    private Boolean visibility;
    private FancyBottomSheetDialogListener pListener, nListener;
    private int pBtnColor, nBtnColor, bgColor;
    private boolean cancel;

    public interface FancyBottomSheetDialogListener {
        void OnClick();
    }
    private FancyBottomSheetDialog(Builder builder){
        this.title=builder.title;
        this.message=builder.message;
        this.activity=builder.activity;
        this.icon=builder.icon;
        this.visibility=builder.visibility;
        this.pListener=builder.pListener;
        this.nListener=builder.nListener;
        this.positiveBtnText=builder.positiveBtnText;
        this.negativeBtnText=builder.negativeBtnText;
        this.pBtnColor=builder.pBtnColor;
        this.nBtnColor=builder.nBtnColor;
        this.bgColor=builder.bgColor;
        this.cancel=builder.cancel;
    }


    public static class Builder {
        private String title, message, positiveBtnText, negativeBtnText;
        private Activity activity;
        private int icon;
        private Boolean visibility;
        private FancyBottomSheetDialogListener pListener, nListener;
        private int pBtnColor, nBtnColor, bgColor;
        private boolean cancel;

        public Builder(Activity activity) {
            this.activity = activity;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setBackgroundColor(@ColorInt int bgColor) {
            this.bgColor = bgColor;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setPositiveBtnText(String positiveBtnText) {
            this.positiveBtnText = positiveBtnText;
            return this;
        }

        public Builder setPositiveBtnBackground(@ColorInt int pBtnColor) {
            this.pBtnColor = pBtnColor;
            return this;
        }

        public Builder setNegativeBtnText(String negativeBtnText) {
            this.negativeBtnText = negativeBtnText;
            return this;
        }

        public Builder setNegativeBtnBackground(@ColorInt  int nBtnColor) {
            this.nBtnColor = nBtnColor;
            return this;
        }


        public Builder setIcon(int icon, boolean visibility) {
            this.icon = icon;
            this.visibility = visibility;
            return this;
        }


        public Builder OnPositiveClicked(FancyBottomSheetDialogListener pListener) {
            this.pListener = pListener;
            return this;
        }

        public Builder OnNegativeClicked(FancyBottomSheetDialogListener nListener) {
            this.nListener = nListener;
            return this;
        }

        public Builder isCancellable(boolean cancel) {
            this.cancel = cancel;
            return this;
        }


        public FancyBottomSheetDialog build() {
            TextView message1, title1;
            ImageView iconImg;
            Button nBtn, pBtn;
            final Dialog dialog;
            dialog = new Dialog(activity, R.style.BottomDialogTheme);
            RelativeLayout background;
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setCancelable(cancel);
            dialog.setContentView(R.layout.item_fancy_dialog);
            dialog.getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setGravity(Gravity.BOTTOM);
            title1 = (TextView) dialog.findViewById(R.id.titletv);
            message1 = (TextView) dialog.findViewById(R.id.descriptiontv);
            iconImg = (ImageView) dialog.findViewById(R.id.icon);
            nBtn = (Button) dialog.findViewById(R.id.buttonNegative);
            pBtn = (Button) dialog.findViewById(R.id.buttonPositive);
            background =(RelativeLayout)dialog.findViewById(R.id.background);
            title1.setText(title);
            message1.setText(message);
            if (positiveBtnText != null)
                pBtn.setText(positiveBtnText);
            if (pBtnColor != 0) {
                pBtn.setBackgroundColor(pBtnColor);
            }
            if (nBtnColor != 0) {
                nBtn.setBackgroundColor(nBtnColor);

            }
            if (negativeBtnText != null)
                nBtn.setText(negativeBtnText);
            iconImg.setImageResource(icon);
            if (visibility)
                iconImg.setVisibility(View.VISIBLE);
            else
                iconImg.setVisibility(View.GONE);
            if (bgColor != 0)
                background.setBackgroundColor(bgColor);
            if (pListener != null) {
                pBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pListener.OnClick();
                        dialog.dismiss();
                    }
                });
            } else {
                pBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }

                });
            }

            if (nListener != null) {
                nBtn.setVisibility(View.VISIBLE);
                nBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        nListener.OnClick();

                        dialog.dismiss();
                    }
                });
            }


            dialog.show();

            return new FancyBottomSheetDialog(this);

        }
    }


}

