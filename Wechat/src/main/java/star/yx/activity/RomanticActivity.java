package star.yx.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import star.yx.tabview.R;
import star.yx.widegt.TreeView;

/**
 * Created by ${廖昭启} on 2017/11/2.
 */

public class RomanticActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        TreeView treeView = new TreeView(this);
        setContentView(R.layout.activity_romantic);

    }
}
