package org.monkeyperson.message;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.monkeyperson.message.views.ContactsViewPart;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		//layout.addView(ContactsViewPart.ID, IPageLayout.LEFT,2.0f, layout.getEditorArea());
		layout.addStandaloneView(ContactsViewPart.ID, false, IPageLayout.TOP,1.0f, layout.getEditorArea());
	}
}
