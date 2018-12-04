package com.aerow.arender;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import com.arondor.viewer.annotation.exceptions.AnnotationsNotSupportedException;
import com.arondor.viewer.client.api.document.DocumentFormatNotSupportedException;
import com.arondor.viewer.client.api.document.DocumentId;
import com.arondor.viewer.client.api.document.DocumentNotAvailableException;
import com.arondor.viewer.client.api.document.altercontent.AlterContentDescription;
import com.arondor.viewer.client.api.document.altercontent.AlterContentOperationException;
import com.arondor.viewer.client.api.document.altercontent.AlterContentOperationNotSupportedException;
import com.arondor.viewer.client.api.document.metadata.DocumentMetadata;
import com.arondor.viewer.rendition.api.annotation.AnnotationAccessor;
import com.arondor.viewer.rendition.api.document.DocumentAccessor;
import com.arondor.viewer.rendition.api.document.DocumentAccessorHasContentSize;
import com.arondor.viewer.rendition.api.document.DocumentAccessorHasUpdateContent;
import com.arondor.viewer.rendition.api.document.DocumentService;

public class CustomDocumentAccessor implements DocumentAccessor,DocumentAccessorHasUpdateContent,DocumentAccessorHasContentSize,Serializable {

	public CustomDocumentAccessor(String url, DocumentId documentId) {
		// TODO Auto-generated constructor stub
	}

	public long getContentSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	public DocumentAccessor updateDocumentContent(DocumentService arg0, DocumentId arg1, AlterContentDescription arg2)
			throws DocumentNotAvailableException, IOException, AlterContentOperationNotSupportedException,
			DocumentFormatNotSupportedException, AlterContentOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	public DocumentAccessor asSerializableDocumentAccessor() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public AnnotationAccessor getAnnotationAccessor() throws AnnotationsNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	public DocumentId getDocumentId() {
		// TODO Auto-generated method stub
		return null;
	}

	public DocumentMetadata getDocumentMetadata() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDocumentTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public InputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMimeType() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPath() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public DocumentId getUUID() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAnnotationAccessor(AnnotationAccessor arg0) throws AnnotationsNotSupportedException {
		// TODO Auto-generated method stub
		
	}

	public void setDocumentTitle(String arg0) {
		// TODO Auto-generated method stub
		
	}

	public byte[] toByteArray() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
