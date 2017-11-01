package star.yx.widegt;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import star.yx.tabview.R;


/**
 * Created by ${廖昭启} on 2017/10/25.
 */

public class RedpackDialog extends Dialog {
    public RedpackDialog(@NonNull Context context) {
        super(context);
    }

    public RedpackDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    protected RedpackDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public static class Builder {
        private Context context;
        private String name;//发红包者的名称

        private TextView red_page;

        //拆红包按钮
        private String openButtonText;
        private OnClickListener openButtonClickListener;

        //关闭按钮
        private String closeButtonText;
        private OnClickListener closeButtonClickListener;

        private OnClickListener  toLookRecordClickListener;

        private int  type;
        private String  blessing;
        public  Builder   setType(int type){
            this.type = type;
            return this;
        }

        public   Builder  setBlessing(String  blessing){
            this.blessing  = blessing;
            return  this;
        }


        public Builder(Context context, int dialog) {
            this.context = context;
        }

        /**
         * Set the Dialog title from resource
         *
         * @param name
         * @return
         */
        public Builder setName(int name) {
            this.name = (String) context.getText(name);
            return this;
        }

        /**
         * 设置发红包的人的名字
         *
         * @param name
         * @return
         */

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        /**
         * Set the positive button resource and it's listener
         *
         * @param closeButtonText
         * @return
         */
        public Builder setCloseButton(int closeButtonText,
                                      OnClickListener listener) {
            this.closeButtonText = (String) context
                    .getText(closeButtonText);
            this.closeButtonClickListener = listener;
            return this;
        }

        public Builder setCloseButton(String closeButtonText,
                                      OnClickListener listener) {
            this.closeButtonText = closeButtonText;
            this.closeButtonClickListener = listener;
            return this;
        }

        public  Builder  setTolookRecord(OnClickListener listener){
            this.toLookRecordClickListener = listener;
            return this;
        }

        /**
         * Set the positive button resource and it's listener
         *
         * @param openButtonText
         * @return
         */
        public Builder setOpenButton(int openButtonText,
                                     OnClickListener listener) {
            this.openButtonText = (String) context
                    .getText(openButtonText);
            this.openButtonClickListener = listener;
            return this;
        }

        public Builder setOpenButton(String openButtonText,
                                     OnClickListener listener) {
            this.openButtonText = openButtonText;
            this.openButtonClickListener = listener;
            return this;
        }


        public RedpackDialog create() {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //加载布局
            final RedpackDialog dialog = new RedpackDialog(context, R.style.Dialog);
            View layout = inflater.inflate(R.layout.dialog_redpack_openable, null);

            red_page = (TextView) layout.findViewById(R.id.tv_open);
            //red指的是需要播放动画的ImageView控件
            TextView tv_type = (TextView) layout.findViewById(R.id.tv_type);
            tv_type.setText(type == 0 ? "给你发了一个红包" : "发了一个红包，金额随机");
            TextView tv_blessing = (TextView) layout.findViewById(R.id.tv_blessing);
            tv_blessing.setText(blessing);
          /*  AnimationDrawable animationDrawable = (AnimationDrawable)red_page.getBackground();
            animationDrawable.start();//启动动画</span>
*/
            dialog.addContentView(layout, new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            //设置发红包者姓名
            ((TextView) layout.findViewById(R.id.tv_name)).setText(name);

            //设置拆红包的按钮

            if (openButtonClickListener != null) {
                ((TextView) layout.findViewById(R.id.tv_open))
                        .setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                openButtonClickListener.onClick(dialog,
                                        DialogInterface.BUTTON_POSITIVE);
                            }
                        });
            }


            //设置关闭按钮
            if (closeButtonText != null) {
              /*  ((ImageView) layout.findViewById(R.id.iv_cancel))
                        .setText(closeButtonText);*/
                if (closeButtonClickListener != null) {
                    ((ImageView) layout.findViewById(R.id.iv_cancel))
                            .setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    closeButtonClickListener.onClick(dialog,
                                            DialogInterface.BUTTON_POSITIVE);
                                }
                            });
                }
            } else {
                // if no confirm button just set the visibility to GONE
                layout.findViewById(R.id.iv_cancel).setVisibility(
                        View.GONE);
            }

            if (closeButtonClickListener != null) {
                ((TextView) layout.findViewById(R.id.tv_lookForLuck))
                        .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        toLookRecordClickListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
                    }
                });
            }


            dialog.setContentView(layout);
            return dialog;
        }

    }
}
