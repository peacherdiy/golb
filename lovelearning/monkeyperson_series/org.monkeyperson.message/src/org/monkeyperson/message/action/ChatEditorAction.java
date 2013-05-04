package org.monkeyperson.message.action;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.monkeyperson.message.Application;
import org.monkeyperson.message.IImageKeys;

/**
 * 监听聊天窗口,当最后一个聊天窗口被关闭的时候,隐藏编辑器所在的区域 
 * @author monkeyperson
 */
public class ChatEditorAction extends Action implements IPartListener {

	private final IWorkbenchWindow window;

	public final static String ID = "org.eclipsercp.hyperbola.chateditorlistener";

	public ChatEditorAction(IWorkbenchWindow window) {
		this.window = window;
		setId(ID);
		setText("&Chat");
		setToolTipText("Chat with the selected contact.");
		setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(
				Application.PLUGIN_ID, IImageKeys.CHAT));
	}
	
	

	public void dispose() {
	}

	@Override
	public void run() {
		IWorkbenchPage page = window.getActivePage();
	}



	@Override
	public void partActivated(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void partBroughtToTop(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void partClosed(IWorkbenchPart part) {
		System.out.println("closeed");
	}



	@Override
	public void partDeactivated(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void partOpened(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		
	}

}
