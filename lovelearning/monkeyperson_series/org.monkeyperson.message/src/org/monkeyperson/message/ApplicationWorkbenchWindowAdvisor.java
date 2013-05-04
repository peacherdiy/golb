package org.monkeyperson.message;

import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * <p>
 * ϵͳ�˵���Ϊ<code>ApplicationWorkbenchWindowAdvisor</code>�Ĳ˵������ٴ��ڹرյ�ʱ��,������Ҳ��ɾ��
 * </p>
 * 
 * @author monkeyperson
 */
public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

	private Image statusImage;
	private Image trayImage;
	private TrayItem trayItem;

	private ApplicationActionBarAdvisor actionBarAdvisor;

	public ApplicationWorkbenchWindowAdvisor(
			IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	public ActionBarAdvisor createActionBarAdvisor(
			IActionBarConfigurer configurer) {
		actionBarAdvisor = new ApplicationActionBarAdvisor(configurer);
		return actionBarAdvisor;
	}

	public void preWindowOpen() {
		IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
		configurer.setInitialSize(new Point(400, 300));
		configurer.setShowCoolBar(true);
		configurer.setShowStatusLine(true);
		configurer.setShowMenuBar(true);// ��ʾĿ¼�˵�
		//configurer.setTitle("monkeyperson message"); //$NON-NLS-1$
	}

	/**
	 * 
	 * <p>
	 * <ul>
	 * <li>��ʼ��״̬��</li>
	 * <li>ע��ϵͳ�˵�</li>
	 * </ul>
	 * </p>
	 * 
	 * @since 0.1
	 */
	@Override
	public void postWindowOpen() {
		initStatusLine();

		final IWorkbenchWindow window = getWindowConfigurer().getWindow();
		trayItem = initTaskItem(window);
		if (trayItem != null) {
			hookPopupMenu(window);
			hookMinimize(window);
		}

		closeEditorArea();
	}

	
	/**
	 * <p>��⵱�༭���رյ�ʱ����ʣ��༭��������,���û����,��رձ༭��</p>
	 */
	private void closeEditorArea() {
		final IWorkbenchPage wp = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();
		if (wp != null) {
			wp.addPartListener(new IPartListener() {

				@Override
				public void partOpened(IWorkbenchPart part) {
					// TODO Auto-generated method stub

				}

				@Override
				public void partDeactivated(IWorkbenchPart part) {
					// TODO Auto-generated method stub

				}

				@Override
				public void partClosed(IWorkbenchPart part) {
					IWorkbenchWindow window = wp.getWorkbenchWindow();
					System.out.println("close editor...");
					if (window != null) {
						// already register for open editors
						IWorkbenchPage iWorkbenchPage = window.getActivePage();
						if (iWorkbenchPage != null) {
							IEditorReference[] editors = iWorkbenchPage.getEditorReferences();
							if (editors != null && editors.length == 0) {
								wp.setEditorAreaVisible(false);
							}
						}
					}

				}

				@Override
				public void partBroughtToTop(IWorkbenchPart part) {
					// TODO Auto-generated method stub

				}

				@Override
				public void partActivated(IWorkbenchPart part) {
					// TODO Auto-generated method stub

				}
			});
		}
	}

	/**
	 * ��ʼ��״̬��
	 */
	private void initStatusLine() {
		statusImage = AbstractUIPlugin.imageDescriptorFromPlugin(
				Application.PLUGIN_ID, IImageKeys.ONLINE).createImage();
		IStatusLineManager statusline = getWindowConfigurer()
				.getActionBarConfigurer().getStatusLineManager();
		statusline.setMessage(statusImage, "Online");
	}

	/**
	 * ������С��ʱ��,�������� ���ɼ�
	 * 
	 * @param window
	 */
	private void hookMinimize(final IWorkbenchWindow window) {

		window.getShell().addShellListener(new ShellAdapter() {
			public void shellIconified(ShellEvent e) {
				window.getShell().setVisible(false);
			}
		});

		// ˫��ϵͳͼ���ʱ��,��ʾ������
		trayItem.addListener(SWT.DefaultSelection, new Listener() {
			public void handleEvent(Event event) {
				Shell shell = window.getShell();
				if (!shell.isVisible()) {
					shell.setVisible(true);
					window.getShell().setMinimized(false);
				}
			}
		});
	}

	/**
	 * ��ݲ˵��ĵ����˵�
	 * 
	 * @param window
	 */
	private void hookPopupMenu(final IWorkbenchWindow window) {
		// Add listener for menu pop-up.
		trayItem.addListener(SWT.MenuDetect, new Listener() {
			public void handleEvent(Event event) {
				MenuManager trayMenu = new MenuManager();
				Menu menu = trayMenu.createContextMenu(window.getShell());
				actionBarAdvisor.fillTrayItem(trayMenu);
				menu.setVisible(true);
			}
		});
	}

	private TrayItem initTaskItem(IWorkbenchWindow window) {
		final Tray tray = window.getShell().getDisplay().getSystemTray();
		if (tray == null)
			return null;
		TrayItem trayItem = new TrayItem(tray, SWT.NONE);
		trayImage = AbstractUIPlugin.imageDescriptorFromPlugin(
				Application.PLUGIN_ID, IImageKeys.ONLINE).createImage();
		trayItem.setImage(trayImage);
		trayItem.setToolTipText("Hyperbola");
		return trayItem;
	}

	@Override
	public void dispose() {
		if (trayImage != null) {
			trayImage.dispose();
			trayItem.dispose();
		}
	}

}
