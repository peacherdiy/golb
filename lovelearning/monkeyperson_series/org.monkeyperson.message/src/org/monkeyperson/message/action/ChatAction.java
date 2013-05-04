package org.monkeyperson.message.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.monkeyperson.message.Application;
import org.monkeyperson.message.IImageKeys;
import org.monkeyperson.message.editor.ChatEditor;
import org.monkeyperson.message.editorinput.ChatEditorInput;
import org.monkeyperson.message.model.ContactsEntry;

/**
 * 打开聊天窗口action
 * 
 * @author monkeyperson
 */
public class ChatAction extends Action implements ISelectionListener {

	private final IWorkbenchWindow window;

	public final static String ID = "org.eclipsercp.hyperbola.chat";

	private IStructuredSelection selection;

	public ChatAction(IWorkbenchWindow window) {
		this.window = window;
		setId(ID);
		setText("&Chat");
		setToolTipText("Chat with the selected contact.");
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(
				Application.PLUGIN_ID, IImageKeys.CHAT));
		window.getSelectionService().addSelectionListener(this);
	}

	public void dispose() {
		window.getSelectionService().removeSelectionListener(this);
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection incoming) {
		if (incoming instanceof IStructuredSelection) {
			selection = (IStructuredSelection) incoming;
			setEnabled(selection.size() == 1
					&& selection.getFirstElement() instanceof ContactsEntry);
		} else {
			// Other selections, for example containing text or of other kinds.
			setEnabled(false);
		}
	}

	@Override
	public void run() {
		Object item = selection.getFirstElement();
		ContactsEntry entry = (ContactsEntry) item;
		IWorkbenchPage page = window.getActivePage();
		ChatEditorInput input = new ChatEditorInput(entry.getName());
		try {
			page.openEditor(input, ChatEditor.ID);
		} catch (PartInitException e) {
			// handle error
		}
	}

}
