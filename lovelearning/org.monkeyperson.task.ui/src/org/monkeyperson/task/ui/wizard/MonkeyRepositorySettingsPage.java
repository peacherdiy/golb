package org.monkeyperson.task.ui.wizard;

import org.eclipse.mylyn.tasks.core.RepositoryTemplate;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.wizards.AbstractRepositorySettingsPage;
import org.eclipse.swt.widgets.Composite;
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
	protected Validator getValidator(TaskRepository arg0) {
		// TODO Auto-generated method stub
		return null;
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
