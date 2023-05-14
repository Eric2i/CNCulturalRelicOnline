// Generated code from Butter Knife. Do not modify!
package com.app.demo.activitys;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.app.demo.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class GSLiulanListActivity_ViewBinding implements Unbinder {
  private GSLiulanListActivity target;

  private View view7f0900b4;

  @UiThread
  public GSLiulanListActivity_ViewBinding(GSLiulanListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public GSLiulanListActivity_ViewBinding(final GSLiulanListActivity target, View source) {
    this.target = target;

    View view;
    target.recy = Utils.findRequiredViewAsType(source, R.id.recy, "field 'recy'", RecyclerView.class);
    target.tvTitle = Utils.findRequiredViewAsType(source, R.id.tv_title, "field 'tvTitle'", TextView.class);
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
    GSLiulanListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recy = null;
    target.tvTitle = null;

    view7f0900b4.setOnClickListener(null);
    view7f0900b4 = null;
  }
}
