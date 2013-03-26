package rcp_02.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import rcp_02.dialog.Dialog3;

public class Action3 implements IWorkbenchWindowActionDelegate {

	private IWorkbenchWindow workbenchWindow;

	@Override
	public void run(IAction action) {
		if (workbenchWindow != null) {
			// 在这里添加功能
			Dialog3 dg = new Dialog3(workbenchWindow.getShell());
			dg.open();

		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IWorkbenchWindow window) {
		this.workbenchWindow = window;
	}

}
