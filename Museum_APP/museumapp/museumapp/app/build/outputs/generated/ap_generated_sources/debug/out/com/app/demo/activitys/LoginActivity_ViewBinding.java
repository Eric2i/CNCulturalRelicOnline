// Generated code from Butter Knife. Do not modify!
package com.app.demo.activitys;

import android.view.View;
import android.widget.EditText;
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

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view7f0900b4;

  private View view7f090166;

  private View view7f090184;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity target, View source) {
    this.target = target;

    View view;
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.inputName = Utils.findRequiredViewAsType(source, R.id.inputName, "field 'inputName'", EditText.class);
    target.inputpwd = Utils.findRequiredViewAsType(source, R.id.inputpwd, "field 'inputpwd'", EditText.class);
    view = Utils.findRequiredView(source, R.id.imgv_return, "field 'imgv_return' and method 'onViewClicked'");
    target.imgv_return = Utils.castView(view, R.id.imgv_return, "field 'imgv_return'", ImageView.class);
    view7f0900b4 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.toLogin, "method 'onViewClicked'");
    view7f090166 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_register, "method 'onViewClicked'");
    view7f090184 = view;
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
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvTitle = null;
    target.inputName = null;
    target.inputpwd = null;
    target.imgv_return = null;

    view7f0900b4.setOnClickListener(null);
    view7f0900b4 = null;
    view7f090166.setOnClickListener(null);
    view7f090166 = null;
    view7f090184.setOnClickListener(null);
    view7f090184 = null;
  }
}
