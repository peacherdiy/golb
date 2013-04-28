package org.monkeyperson.message.views;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.part.ViewPart;
import org.monkeyperson.message.HyperbolaAdapterFactory;
import org.monkeyperson.message.model.Contact;
import org.monkeyperson.message.model.ContactsEntry;
import org.monkeyperson.message.model.ContactsGroup;
import org.monkeyperson.message.model.IContactsListener;
import org.monkeyperson.message.model.Session;

public class ContactsViewPart extends ViewPart {
	public static final String ID = "org.monkeyperson.message.views.contacts";
	private TreeViewer treeViewer;

	private Session session;

	private IAdapterFactory adapterFactory = new HyperbolaAdapterFactory();

	public ContactsViewPart() {
		super();
	}

	public void createPartControl(Composite parent) {
		initializeSession(); // temporary tweak to build a fake model
		treeViewer = new TreeViewer(parent, SWT.BORDER | SWT.MULTI
				| SWT.V_SCROLL);
		getSite().setSelectionProvider(treeViewer);
		Platform.getAdapterManager().registerAdapters(adapterFactory, Contact.class);
		treeViewer.setLabelProvider(new WorkbenchLabelProvider());
		treeViewer.setContentProvider(new BaseWorkbenchContentProvider());
		treeViewer.setInput(session.getRoot());
		session.getRoot().addContactsListener(new IContactsListener() {
			public void contactsChanged(ContactsGroup contacts,
					ContactsEntry entry) {
				treeViewer.refresh();
			}
		});
	}
	
	public void dispose() {
		Platform.getAdapterManager().unregisterAdapters(adapterFactory);
		super.dispose();
	}

	private void initializeSession() {
		session = new Session();
		ContactsGroup root = session.getRoot();
		ContactsGroup friendsGroup = new ContactsGroup(root, "Friends");
		root.addEntry(friendsGroup);
		friendsGroup.addEntry(new ContactsEntry(friendsGroup, "Alize", "aliz",
				"localhost"));
		friendsGroup.addEntry(new ContactsEntry(friendsGroup, "Sydney", "syd",
				"localhost"));
		ContactsGroup otherGroup = new ContactsGroup(root, "Other");
		root.addEntry(otherGroup);
		otherGroup.addEntry(new ContactsEntry(otherGroup, "Nadine", "nad",
				"localhost"));
	}

	public void setFocus() {
		treeViewer.getControl().setFocus();
	}
}
