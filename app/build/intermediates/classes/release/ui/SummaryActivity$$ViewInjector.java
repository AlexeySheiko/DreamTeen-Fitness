// Generated code from Butter Knife. Do not modify!
package ui;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class SummaryActivity$$ViewInjector {
  public static void inject(Finder finder, final ui.SummaryActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131558462, "field 'mUnitsLabel'");
    target.mUnitsLabel = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131558461, "field 'mDistanceLabel'");
    target.mDistanceLabel = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131558463, "field 'mNameField'");
    target.mNameField = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131558467, "field 'mDiscardButton'");
    target.mDiscardButton = (android.widget.TextView) view;
  }

  public static void reset(ui.SummaryActivity target) {
    target.mUnitsLabel = null;
    target.mDistanceLabel = null;
    target.mNameField = null;
    target.mDiscardButton = null;
  }
}
