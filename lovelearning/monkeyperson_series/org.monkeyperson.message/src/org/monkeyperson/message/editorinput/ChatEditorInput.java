package org.monkeyperson.message.editorinput;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

/**
 * ±à¼­Æ÷ÏÔÊ¾ÄÚÈÝ
 * 
 * @author monkeyperson
 */
public class ChatEditorInput implements IEditorInput {

	private String participant;

	public ChatEditorInput(String participant) {
		super();
		Assert.isNotNull(participant);
		this.participant = participant;
	}

	@Override
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return participant;
	}

	@Override
	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToolTipText() {
		return participant;
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj))
			return true;
		if (!(obj instanceof ChatEditorInput))
			return false;
		ChatEditorInput other = (ChatEditorInput) obj;
		return participant.equals(other.participant);
	}
	
	public int hashCode() {
		return participant.hashCode();
	}
}
