package org.monkeyperson.message;

import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
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

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	private IWorkbenchAction exitAction;

	private IWorkbenchAction aboutAction;

	private AddContactAction addContactAction;

	protected void makeActions(IWorkbenchWindow window) {
		exitAction = ActionFactory.QUIT.create(window);
		register(exitAction);
		aboutAction = ActionFactory.ABOUT.create(window);
		register(aboutAction);
		addContactAction = new AddContactAction(window);
		register(addContactAction);
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
		 * 用GroupMarker插入菜单
		 */
//		hyperbolaMenu.add(new GroupMarker("other-actions"));
//		hyperbolaMenu.appendToGroup("other-actions", aboutAction);
		
		/**
		 * 级联菜单
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
	}

	protected void fillTrayItem(IMenuManager trayItem) {
		trayItem.add(aboutAction);
		trayItem.add(exitAction);
	}
}
