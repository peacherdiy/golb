package rcp_02.perspective;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import rcp_02.view.FirstView;

public class PerspectiveFactory1 implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.addView(FirstView.ID, IPageLayout.RIGHT, 0.2f, editorArea);
	}

}
