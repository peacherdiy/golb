package org.monkeyperson.ui.mybookmark;


import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.source.IVerticalRulerInfo;
import org.eclipse.ui.texteditor.AbstractRulerActionDelegate;
import org.eclipse.ui.texteditor.ITextEditor;
import org.monkeyperson.ui.mybookmark.popup.actions.MyMarkerRulerAction;
import org.monkeyperson.ui.mybookmark.views.Messages;

public class Action1 extends AbstractRulerActionDelegate {

	/*
	 * @see AbstractRulerActionDelegate#createAction(ITextEditor, IVerticalRulerInfo)
	 */
	@Override
	protected IAction createAction(ITextEditor editor, IVerticalRulerInfo rulerInfo) {
		return new MyMarkerRulerAction(Messages.getBundleForConstructedKeys(), "Editor.ManageBookmarks.", editor, rulerInfo, IMarker.BOOKMARK, true); //$NON-NLS-1$
		//return new MarkerRulerAction(TextEditorMessages.getBundleForConstructedKeys(), "Editor.ManageBookmarks.", editor, rulerInfo, IMarker.BOOKMARK, true); //$NON-NLS-1$
	}
}
