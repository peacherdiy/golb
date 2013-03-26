package rcp_01;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import rcp_01.actions.Action1;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	private  IWorkbenchAction action1;
	 
    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    protected void makeActions(IWorkbenchWindow window) {
    	 action1  =   new  Action1(window);
    	 action1.setText( " ��һ���˵��� " );
    	 action1.setId( " cn.blogjava.youxia.actions.action1 " );
    	 register(action1);
    }

    protected void fillMenuBar(IMenuManager menuBar) {
    	MenuManager newMenu  =   new  MenuManager( " ��һ���˵� " , " cn.blogjava.youxia.firstmenu " );
    	menuBar.add(newMenu);
    	newMenu.add(action1);
    }
    
}