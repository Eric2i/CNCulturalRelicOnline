// Generated code from Butter Knife. Do not modify!
package com.app.demo.activitys;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.app.demo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RegisterActivity_ViewBinding implements Unbinder {
  private RegisterActivity target;

  private View view7f090184;

  private View view7f0900b4;

  @UiThread
  public RegisterActivity_ViewBinding(RegisterActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RegisterActivity_ViewBinding(final RegisterActivity target, View source) {
    this.target = target;

    View view;
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
    target.edtAccount = Utils.findRequiredViewAsType(source, R.id.edt_account, "field 'edtAccount'", EditText.class);
    target.edtName = Utils.findRequiredViewAsType(source, R.id.edt_name, "field 'edtName'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tv_register, "field 'tvRegister' and method 'onViewClicked'");
    target.tvRegister = Utils.castView(view, R.id.tv_register, "field 'tvRegister'", TextView.class);
    view7f090184 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.edtPwd = Utils.findRequiredViewAsType(source, R.id.edt_pwd, "field 'edtPwd'", EditText.class);
    target.layout_pwd = Utils.findRequiredViewAsType(source, R.id.layout_pwd, "field 'layout_pwd'", LinearLayout.class);
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
    RegisterActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvTitle = null;
    target.edtAccount = null;
    target.edtName = null;
    target.tvRegister = null;
    target.edtPwd = null;
    target.layout_pwd = null;

    view7f090184.setOnClickListener(null);
    view7f090184 = null;
    view7f0900b4.setOnClickListener(null);
    view7f0900b4 = null;
  }
}
