package rcp_02.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Dialog3 extends Dialog {

	protected Shell shell;

	private int result;

	public Dialog3(Shell parent, int style) {
		super(parent, style);
	}

	public Dialog3(Shell parent) {
		this(parent, SWT.NONE);
	}

	public int open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		return result;
	}

	protected void createContents() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		shell.setSize(150, 70);
		shell.setText(" 第一个对话框 ");

		final Button okButton = new Button(shell, SWT.NONE);
		okButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				result = 1;
				shell.dispose();
			}
		});
		okButton.setText(" OK ");
		okButton.setBounds(10, 10, 48, 22);

		final Button cancelButton = new Button(shell, SWT.NONE);
		cancelButton.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				result = 2;
				shell.dispose();
			}
		});
		cancelButton.setText(" Cancel ");
		cancelButton.setBounds(89, 10, 48, 22);
	}
}
