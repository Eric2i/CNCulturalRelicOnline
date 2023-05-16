// Generated code from Butter Knife. Do not modify!
package com.app.demo.fragments;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.app.demo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class StypeFragment_ViewBinding implements Unbinder {
  private StypeFragment target;

  @UiThread
  public StypeFragment_ViewBinding(StypeFragment target, View source) {
    this.target = target;

    target.tv_title_right = Utils.findRequiredViewAsType(source, R.id.tv_title_right, "field 'tv_title_right'", TextView.class);
    target.tv_0 = Utils.findRequiredViewAsType(source, R.id.tv_0, "field 'tv_0'", TextView.class);
    target.tv_1 = Utils.findRequiredViewAsType(source, R.id.tv_1, "field 'tv_1'", TextView.class);
    target.tv_2 = Utils.findRequiredViewAsType(source, R.id.tv_2, "field 'tv_2'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    StypeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tv_title_right = null;
    target.tv_0 = null;
    target.tv_1 = null;
    target.tv_2 = null;
  }
}
