package org.monkeyperson.message;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.monkeyperson.message.action.AddContactAction;
import org.monkeyperson.message.action.ChatAction;
import org.monkeyperson.message.action.ChatEditorAction;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	private IWorkbenchAction exitAction;

	private IWorkbenchAction aboutAction;
	
	private ChatAction chatAction;

	private AddContactAction addContactAction;
	
	private ChatEditorAction chatEditorAction;

	protected void makeActions(IWorkbenchWindow window) {
		exitAction = ActionFactory.QUIT.create(window);
		register(exitAction);
		aboutAction = ActionFactory.ABOUT.create(window);
		register(aboutAction);
		addContactAction = new AddContactAction(window);
		register(addContactAction);
		chatAction = new ChatAction(window);
		register(chatAction);
		
		chatEditorAction = new ChatEditorAction(window);
		register(chatEditorAction);
	}

	protected void fillMenuBar(IMenuManager menuBar) {
		MenuManager hyperbolaMenu = new MenuManager("&Hyperbola", "hyperbola");
		hyperbolaMenu.add(addContactAction);
		hyperbolaMenu.add(new Separator());
		hyperbolaMenu.add(exitAction);
		MenuManager helpMenu = new MenuManager("&Help", "help");
		helpMenu.add(aboutAction);
		menuBar.add(hyperbolaMenu);
		menuBar.add(helpMenu);
		
		
		/**
		 * ��GroupMarker����˵�
		 */
//		hyperbolaMenu.add(new GroupMarker("other-actions"));
//		hyperbolaMenu.appendToGroup("other-actions", aboutAction);
		
		/**
		 * �����˵�
		 */
//		MenuManager helpMenu = new MenuManager("&Help", "help");
//		helpMenu.add(aboutAction);
//		menuBar.add(hyperbolaMenu);
//		hyperbolaMenu.add(helpMenu);
	}

	protected void fillCoolBar(ICoolBarManager coolBar) {
		IToolBarManager toolbar = new ToolBarManager(coolBar.getStyle());
		coolBar.add(toolbar);
		toolbar.add(addContactAction);
		toolbar.add(new Separator());
		toolbar.add(chatAction);
	}

	
	/**
	 * <p>��ΪbarAdvisor�Ǵ���<code>action</code>�ĵط�,�����������Ѿ������õ�<code>action</code>ע�ᵽ�������Ŀ�ݲ˵�,�ﵽ���õ�Ŀ��</p>
	 * @param trayItem
	 */
	protected void fillTrayItem(IMenuManager trayItem) {
		trayItem.add(aboutAction);
		trayItem.add(exitAction);
	}
	
	@Override
	protected void fillStatusLine(IStatusLineManager statusLine) {
		// TODO Auto-generated method stub
		super.fillStatusLine(statusLine);
	}
}
