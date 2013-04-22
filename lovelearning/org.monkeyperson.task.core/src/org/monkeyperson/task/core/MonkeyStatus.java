package org.monkeyperson.task.core;

import org.eclipse.core.runtime.Status;

public class MonkeyStatus extends Status {
	
	private final String errorMessage;
	private String repositoryUrl = "";
	
	public MonkeyStatus(int severity, String pluginId, int code, String errorMessage) {
		super(severity, pluginId, code, "MylynStatus", null); //$NON-NLS-1$
		this.errorMessage = errorMessage;
	}
	
	public MonkeyStatus(int severity, String pluginId, int code, String repositoryUrl, String errorMessage) {
		super(severity, pluginId, code, "MylynStatus", null); //$NON-NLS-1$
		this.errorMessage = errorMessage;
		this.repositoryUrl = repositoryUrl;
	}
}
