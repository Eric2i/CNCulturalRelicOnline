// Generated code from Butter Knife. Do not modify!
package com.app.demo;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view7f09018f;

  private View view7f090190;

  private View view7f090191;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.txt_1, "field 'txt_1' and method 'onViewClicked'");
    target.txt_1 = Utils.castView(view, R.id.txt_1, "field 'txt_1'", TextView.class);
    view7f09018f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.txt_2, "field 'txt_2' and method 'onViewClicked'");
    target.txt_2 = Utils.castView(view, R.id.txt_2, "field 'txt_2'", TextView.class);
    view7f090190 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.txt_3, "field 'txt_3' and method 'onViewClicked'");
    target.txt_3 = Utils.castView(view, R.id.txt_3, "field 'txt_3'", TextView.class);
    view7f090191 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.llBottom = Utils.findRequiredViewAsType(source, R.id.ll_bottom, "field 'llBottom'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txt_1 = null;
    target.txt_2 = null;
    target.txt_3 = null;
    target.llBottom = null;

    view7f09018f.setOnClickListener(null);
    view7f09018f = null;
    view7f090190.setOnClickListener(null);
    view7f090190 = null;
    view7f090191.setOnClickListener(null);
    view7f090191 = null;
  }
}
