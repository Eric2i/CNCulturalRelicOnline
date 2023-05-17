// Generated code from Butter Knife. Do not modify!
package com.app.demo.fragments;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.app.demo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MineFragment_ViewBinding implements Unbinder {
  private MineFragment target;

  private View view7f090180;

  private View view7f090186;

  private View view7f090183;

  private View view7f09017d;

  private View view7f09017c;

  @UiThread
  public MineFragment_ViewBinding(final MineFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tv_my_info, "method 'onViewClicked'");
    view7f090180 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_shoucang, "method 'onViewClicked'");
    view7f090186 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_pwd, "method 'onViewClicked'");
    view7f090183 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_logout, "method 'onViewClicked'");
    view7f09017d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_liulan, "method 'onViewClicked'");
    view7f09017c = view;
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
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view7f090180.setOnClickListener(null);
    view7f090180 = null;
    view7f090186.setOnClickListener(null);
    view7f090186 = null;
    view7f090183.setOnClickListener(null);
    view7f090183 = null;
    view7f09017d.setOnClickListener(null);
    view7f09017d = null;
    view7f09017c.setOnClickListener(null);
    view7f09017c = null;
  }
}
