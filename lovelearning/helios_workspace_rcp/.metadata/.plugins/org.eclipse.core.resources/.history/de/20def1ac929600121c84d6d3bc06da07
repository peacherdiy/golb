package rcp_02.view;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class FirstView extends ViewPart {

	private Table table;
	private Text text_1;
	private Text text;
	public static final String ID = "cn.blogjava.youxia.views.FirstView"; //$NON-NLS-1$

	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);

		final Label label = new Label(container, SWT.NONE);
		label.setText("name:");
		label.setBounds(56, 41, 36, 12);

		text = new Text(container, SWT.BORDER);
		text.setBounds(98, 38, 80, 15);

		final Label label_1 = new Label(container, SWT.NONE);
		label_1.setText("sex:");
		label_1.setBounds(212, 41, 30, 12);

		text_1 = new Text(container, SWT.BORDER);
		text_1.setBounds(252, 38, 80, 15);

		final TableViewer tableViewer = new TableViewer(container, SWT.BORDER);
		// tableViewer.setInput(new Object());
		table = tableViewer.getTable();
		table.setBounds(56, 75, 374, 143);
		table.setItemCount(10);
		table.setLinesVisible(true);
		//
		createActions();
		initializeToolBar();
		initializeMenu();

	}

	/**
	 * Create the actions
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars()
				.getToolBarManager();
	}

	/**
	 * Initialize the menu
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars()
				.getMenuManager();
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
