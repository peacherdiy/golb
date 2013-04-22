package org.monkeyperson.task.ui.wizard;

import java.io.IOException;
import java.net.MalformedURLException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.mylyn.tasks.core.RepositoryStatus;
import org.eclipse.mylyn.tasks.core.RepositoryTemplate;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.wizards.AbstractRepositorySettingsPage;
import org.eclipse.swt.widgets.Composite;
import org.monkeyperson.task.core.CoreActivator;
import org.monkeyperson.task.core.MonkeyStatus;
import org.monkeyperson.task.ui.Activator;

public class MonkeyRepositorySettingsPage extends AbstractRepositorySettingsPage {

	public MonkeyRepositorySettingsPage(TaskRepository taskRepository) {
		super("Monkey Repository Settings", "Settings for Monkey Repository", taskRepository);
		setNeedsAnonymousLogin(false);
		setNeedsEncoding(false);
		setNeedsTimeZone(false);
		setNeedsAdvanced(false);
		setNeedsProxy(false);
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		addRepositoryTemplatesToServerUrlCombo();
	}



	@Override
	protected void createAdditionalControls(Composite arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getConnectorKind() {
		return Activator.CONNECTOR_KIND;
	}

	@Override
	protected Validator getValidator(TaskRepository repository) {
		return new MonkeyTaskValidator(repository);
	}
	
	public class MonkeyTaskValidator extends Validator {

		
		
		final TaskRepository repository;

		public MonkeyTaskValidator(TaskRepository repository) {
			this.repository = repository;
		}

		@Override
		public void run(IProgressMonitor monitor) throws CoreException {
			try {
				validate(monitor);
			} catch (Exception e) {
				displayError(repository.getRepositoryUrl(), e);
			}
		}

		private void displayError(final String serverUrl, Throwable e) {
			IStatus status;
			if (e instanceof MalformedURLException) {
				status = new MonkeyStatus(IStatus.WARNING, CoreActivator.PLUGIN_ID,
						RepositoryStatus.ERROR_NETWORK, "Server URL is invalid");
			} else if (e instanceof CoreException) {
				status = ((CoreException) e).getStatus();
			} else if (e instanceof IOException) {
				status = new MonkeyStatus(IStatus.WARNING,CoreActivator.PLUGIN_ID, RepositoryStatus.ERROR_IO,serverUrl, e.getMessage());
			} else {
				status = new MonkeyStatus(IStatus.WARNING,CoreActivator.PLUGIN_ID,RepositoryStatus.ERROR_NETWORK, serverUrl, e.getMessage());
			}
			setStatus(status);
		}

		public void validate(IProgressMonitor monitor) throws IOException, CoreException {

			if (monitor == null) {
				monitor = new NullProgressMonitor();
			}
			try {
				monitor.beginTask("验证服务器设置",IProgressMonitor.UNKNOWN);
//				BugzillaClient client = null;
//
//				client = BugzillaClientFactory.createClient(repository);
//				client.validate(monitor);
				
			} finally {
				monitor.done();
			}
		}

	}
	
	@Override
	protected void repositoryTemplateSelected(RepositoryTemplate template) {
		repositoryLabelEditor.setStringValue(template.label);
		setUrl(template.repositoryUrl);
		setUserId("user");
		setPassword("pass");
		
		getContainer().updateButtons();
	}

	@Override
	protected boolean isValidUrl(String url) {
		return url != null && url.trim().length() > 0;
	}
	
	
	
	
}
