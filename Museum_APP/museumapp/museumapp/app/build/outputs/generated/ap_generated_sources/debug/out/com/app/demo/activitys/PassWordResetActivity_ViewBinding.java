// Generated code from Butter Knife. Do not modify!
package com.app.demo.activitys;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.app.demo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PassWordResetActivity_ViewBinding implements Unbinder {
  private PassWordResetActivity target;

  private View view7f0900b4;

  private View view7f09017f;

  @UiThread
  public PassWordResetActivity_ViewBinding(PassWordResetActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PassWordResetActivity_ViewBinding(final PassWordResetActivity target, View source) {
    this.target = target;

    View view;
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.inputpwdNew = Utils.findRequiredViewAsType(source, R.id.inputpwd_new, "field 'inputpwdNew'", EditText.class);
    target.inputpwdRepeat = Utils.findRequiredViewAsType(source, R.id.inputpwd_repeat, "field 'inputpwdRepeat'", EditText.class);
    view = Utils.findRequiredView(source, R.id.imgv_return, "method 'onViewClicked'");
    view7f0900b4 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_modify, "method 'onViewClicked'");
    view7f09017f = view;
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
    PassWordResetActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvTitle = null;
    target.inputpwdNew = null;
    target.inputpwdRepeat = null;

    view7f0900b4.setOnClickListener(null);
    view7f0900b4 = null;
    view7f09017f.setOnClickListener(null);
    view7f09017f = null;
  }
}
