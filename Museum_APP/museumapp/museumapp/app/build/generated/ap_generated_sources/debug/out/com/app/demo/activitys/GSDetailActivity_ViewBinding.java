// Generated code from Butter Knife. Do not modify!
package com.app.demo.activitys;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.app.demo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GSDetailActivity_ViewBinding implements Unbinder {
  private GSDetailActivity target;

  private View view7f090186;

  private View view7f09017a;

  private View view7f090175;

  private View view7f090171;

  @UiThread
  public GSDetailActivity_ViewBinding(GSDetailActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public GSDetailActivity_ViewBinding(final GSDetailActivity target, View source) {
    this.target = target;

    View view;
    target.iv_pic = Utils.findRequiredViewAsType(source, R.id.iv_pic, "field 'iv_pic'", ImageView.class);
    target.tv_name = Utils.findRequiredViewAsType(source, R.id.tv_name, "field 'tv_name'", TextView.class);
    target.tv_theme = Utils.findRequiredViewAsType(source, R.id.tv_theme, "field 'tv_theme'", TextView.class);
    target.tv_content = Utils.findRequiredViewAsType(source, R.id.tv_content, "field 'tv_content'", TextView.class);
    view = Utils.findRequiredView(source, R.id.tv_shoucang, "field 'tv_shoucang' and method 'onViewClicked'");
    target.tv_shoucang = Utils.castView(view, R.id.tv_shoucang, "field 'tv_shoucang'", TextView.class);
    view7f090186 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_fenxiang, "field 'tv_fenxiang' and method 'onViewClicked'");
    target.tv_fenxiang = Utils.castView(view, R.id.tv_fenxiang, "field 'tv_fenxiang'", TextView.class);
    view7f09017a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_close, "field 'tv_close' and method 'onViewClicked'");
    target.tv_close = Utils.castView(view, R.id.tv_close, "field 'tv_close'", TextView.class);
    view7f090175 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_1, "method 'onViewClicked'");
    view7f090171 = view;
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
    GSDetailActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.iv_pic = null;
    target.tv_name = null;
    target.tv_theme = null;
    target.tv_content = null;
    target.tv_shoucang = null;
    target.tv_fenxiang = null;
    target.tv_close = null;

    view7f090186.setOnClickListener(null);
    view7f090186 = null;
    view7f09017a.setOnClickListener(null);
    view7f09017a = null;
    view7f090175.setOnClickListener(null);
    view7f090175 = null;
    view7f090171.setOnClickListener(null);
    view7f090171 = null;
  }
}
