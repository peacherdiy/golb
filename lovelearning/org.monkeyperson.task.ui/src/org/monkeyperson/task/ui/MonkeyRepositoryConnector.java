package org.monkeyperson.task.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.mylyn.tasks.core.AbstractRepositoryConnector;
import org.eclipse.mylyn.tasks.core.IRepositoryQuery;
import org.eclipse.mylyn.tasks.core.ITask;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.core.data.TaskData;
import org.eclipse.mylyn.tasks.core.data.TaskDataCollector;
import org.eclipse.mylyn.tasks.core.sync.ISynchronizationSession;

public class MonkeyRepositoryConnector extends AbstractRepositoryConnector{

	@Override
	public boolean canCreateNewTask(TaskRepository arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canCreateTaskFromKey(TaskRepository arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getConnectorKind() {
		return Activator.CONNECTOR_KIND;
	}

	@Override
	public String getLabel() {
		return "Monkey Repository";
	}

	@Override
	public String getRepositoryUrlFromTaskUrl(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskData getTaskData(TaskRepository arg0, String arg1,
			IProgressMonitor arg2) throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTaskIdFromTaskUrl(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTaskUrl(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasTaskChanged(TaskRepository arg0, ITask arg1, TaskData arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IStatus performQuery(TaskRepository arg0, IRepositoryQuery arg1,
			TaskDataCollector arg2, ISynchronizationSession arg3,
			IProgressMonitor arg4) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRepositoryConfiguration(TaskRepository arg0,
			IProgressMonitor arg1) throws CoreException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTaskFromTaskData(TaskRepository arg0, ITask arg1,
			TaskData arg2) {
		// TODO Auto-generated method stub
		
	}

}
