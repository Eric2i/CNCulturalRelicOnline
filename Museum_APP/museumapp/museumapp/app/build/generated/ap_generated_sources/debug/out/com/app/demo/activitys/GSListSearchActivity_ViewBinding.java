// Generated code from Butter Knife. Do not modify!
package com.app.demo.activitys;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.app.demo.R;
import com.youth.banner.Banner;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GSListSearchActivity_ViewBinding implements Unbinder {
  private GSListSearchActivity target;

  private View view7f0900b4;

  @UiThread
  public GSListSearchActivity_ViewBinding(GSListSearchActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public GSListSearchActivity_ViewBinding(final GSListSearchActivity target, View source) {
    this.target = target;

    View view;
    target.recy = Utils.findRequiredViewAsType(source, R.id.recy, "field 'recy'", RecyclerView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.edtSearch = Utils.findRequiredViewAsType(source, R.id.edt_search, "field 'edtSearch'", EditText.class);
    target.btSearch = Utils.findRequiredViewAsType(source, R.id.bt_search, "field 'btSearch'", Button.class);
    target.banner = Utils.findRequiredViewAsType(source, R.id.banner, "field 'banner'", Banner.class);
    view = Utils.findRequiredView(source, R.id.imgv_return, "method 'onViewClicked'");
    view7f0900b4 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    GSListSearchActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recy = null;
    target.tvTitle = null;
    target.edtSearch = null;
    target.btSearch = null;
    target.banner = null;

    view7f0900b4.setOnClickListener(null);
    view7f0900b4 = null;
  }
}
