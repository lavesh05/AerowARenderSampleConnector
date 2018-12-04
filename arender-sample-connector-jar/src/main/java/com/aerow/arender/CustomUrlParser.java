package com.aerow.arender;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.arondor.viewer.client.api.document.DocumentFormatNotSupportedException;
import com.arondor.viewer.client.api.document.DocumentId;
import com.arondor.viewer.client.api.document.DocumentNotAvailableException;
import com.arondor.viewer.client.api.document.id.DocumentIdParameter;
import com.arondor.viewer.common.document.id.DocumentIdFactory;
import com.arondor.viewer.common.document.id.URLDocumentIdParameter;
import com.arondor.viewer.common.documentaccessor.DocumentAccessorByteArray;
import com.arondor.viewer.rendition.api.DocumentServiceURLParser;
import com.arondor.viewer.rendition.api.document.DocumentAccessor;
import com.arondor.viewer.rendition.api.document.DocumentService;

public class CustomUrlParser implements DocumentServiceURLParser {
	
	// The URL parameter to use to get document reference
	private String docRefParameter = "documentIdObject";
	private static final Logger LOGGER = Logger.getLogger(CustomUrlParser.class);

	public boolean canParse(DocumentService documentService, ServletContext application, HttpServletRequest request) {
		// TODO Auto-generated method stub
		readUrlParams(request);
		// The connector is enabled/used when ARender URL contains defined parameter
		return request.getParameter(docRefParameter) != null;
	}

	public DocumentId parse(DocumentService documentService, ServletContext application, HttpServletRequest request)
			throws DocumentNotAvailableException, DocumentFormatNotSupportedException {
		
		
		String docRef = request.getParameter(docRefParameter);
		DocumentAccessor documentAccessor = null;
		
		//TODO here implement CustomDocumentAccessor
/*		if(docRef!=null) {	
		   DocumentId documentId = DocumentIdFactory.getInstance().generate(docRef);
		 documentAccessor = new CustomDocumentAccessor(docRef,documentId);
		documentService.loadDocumentAccessor(documentAccessor);
		return documentAccessor.getDocumentId();
		}*/
		
		return loadDocumentFromLocalResource(documentService, "aerow.pdf");
		
	}
	
	private void readUrlParams(HttpServletRequest request) {
		Map m = request.getParameterMap();
		Set s = m.entrySet();
		Iterator it = s.iterator();

		while (it.hasNext()) {

			Map.Entry<String, String[]> entry = (Map.Entry<String, String[]>) it.next();

			String key = entry.getKey();
			String[] value = entry.getValue();
			LOGGER.debug("Key: " + key);
			LOGGER.debug("Value is " + value[0].toString());
		}
	}
	
	private DocumentId loadDocumentFromLocalResource(DocumentService documentService, String resourceName)
			throws DocumentNotAvailableException, DocumentFormatNotSupportedException {
		DocumentId documentId = DocumentIdFactory.getInstance().generate("res#" + resourceName);
		if (documentService.hasDocument(documentId)) {
			return documentId;
		}
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resourceName);
		if (inputStream == null) {
			LOGGER.error("Could not load local document :" + resourceName);
			throw new DocumentNotAvailableException("Could not load local document :" + resourceName);
		}

		try {
			DocumentAccessorByteArray documentAccessor = new DocumentAccessorByteArray(documentId, inputStream);
			documentAccessor.setDocumentTitle(resourceName);
			documentService.loadDocumentAccessor(documentAccessor);
			return documentAccessor.getUUID();
		} catch (IOException e) {
			throw new DocumentNotAvailableException("Could not load local document :" + resourceName);
		}
	}

}
