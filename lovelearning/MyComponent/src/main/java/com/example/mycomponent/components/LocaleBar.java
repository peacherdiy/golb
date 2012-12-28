package com.example.mycomponent.components;

import java.util.Locale;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.Service;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.services.SymbolProvider;
import org.apache.tapestry5.services.PersistentLocale;

public class LocaleBar {
	@Property
	private String locale;

	@Inject
	private Locale currentLocale;

	@Inject
	@Service("ApplicationDefaults")
	private SymbolProvider symbolProvider;

	@Inject
	private PersistentLocale persistentLocale;

	public String[] getLocales() {
		String symbol = symbolProvider
				.valueForSymbol(SymbolConstants.SUPPORTED_LOCALES);
		return symbol.split(",");
	}

	public String getLocaleName() {
		Locale l = toLocale(locale);
		return l.getDisplayName(l);
	}

	private Locale toLocale(String shortName) {
		String[] result = shortName.split("_");
		if (result.length == 1) {
			return new Locale(result[0]);
		} else {
			return new Locale(result[0], result[1]);
		}
	}

	public boolean isCurrentLocale() {
		return toLocale(locale).equals(currentLocale);
	}

	void onActionFromSwitch(String shortName) {
		persistentLocale.set(toLocale(shortName));
	}
}
