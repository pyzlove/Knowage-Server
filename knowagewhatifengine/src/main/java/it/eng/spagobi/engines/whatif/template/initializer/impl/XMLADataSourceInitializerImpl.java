/**
 *
 */
package it.eng.spagobi.engines.whatif.template.initializer.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import it.eng.spago.base.SourceBean;
import it.eng.spago.base.SourceBeanAttribute;
import it.eng.spagobi.engines.whatif.template.WhatIfTemplate;
import it.eng.spagobi.engines.whatif.template.initializer.AbstractInitializer;

/**
 * @author Dragan Pirkovic
 *
 */
public class XMLADataSourceInitializerImpl extends AbstractInitializer {

	public static transient Logger logger = Logger.getLogger(XMLADataSourceInitializerImpl.class);

	public static final String TAG_XMLA_DATASOURCE = "xmlaserver";

	@Override
	public void init(SourceBean template, WhatIfTemplate toReturn) {
		List<SourceBeanAttribute> xmlaConnectionProperties;
		Map<String, String> xmlaConnectionPropertiesMap = new HashMap<String, String>();
		SourceBeanAttribute aXmlaConnectionProperty;
		String name;
		String value;

		logger.debug("IN. loading the xmla datasource config");
		SourceBean xmlaSB = (SourceBean) template.getAttribute(TAG_XMLA_DATASOURCE);
		if (xmlaSB != null) {

			logger.debug(TAG_XMLA_DATASOURCE + ": " + xmlaSB);
			xmlaConnectionProperties = xmlaSB.getContainedAttributes();
			if (xmlaConnectionProperties != null) {
				for (int i = 0; i < xmlaConnectionProperties.size(); i++) {
					aXmlaConnectionProperty = xmlaConnectionProperties.get(i);
					name = aXmlaConnectionProperty.getKey();
					value = ((SourceBean) aXmlaConnectionProperty.getValue()).getCharacters();
					xmlaConnectionPropertiesMap.put(name, value);
				}

				logger.debug("Updating the xmla datasource in the template");
				toReturn.setXmlaServerProperties(xmlaConnectionPropertiesMap);

			}
		} else {
			logger.debug(TAG_XMLA_DATASOURCE + ": no xmla data source defined in the template");
		}

	}

}
