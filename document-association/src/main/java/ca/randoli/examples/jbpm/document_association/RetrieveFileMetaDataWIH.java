package ca.randoli.examples.jbpm.document_association;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

public class RetrieveFileMetaDataWIH implements WorkItemHandler {

	Random rn = new Random();
	String[] docTypes = new String[]{"employment", "id", "asset"};
		
	public void abortWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
		System.out.println("RetrieveFileMetaDataWIH Aborted!");
	}

	public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
		
		String type = docTypes[rn.nextInt(3)];
		String id = (String)workItem.getParameter("documentId");
		String crn = (String)workItem.getParameter("crn");
		
		FileMetaData metaData = new FileMetaData();
		metaData.setCrn(crn);
		metaData.setDocumentId(id);
		metaData.setDocumentType(type);
		
		Map<String,Object> results = new HashMap<String,Object>();
		results.put("meta-data",metaData);
		
		System.out.println("=======================================");
		System.out.println("Retrieving Document Meta Data");
		System.out.println("DocumentMetaDataWIH documentId : " + id);
		System.out.println("DocumentMetaDataWIH crn : " + crn);
		System.out.println("DocumentMetaDataWIH document type : " + type);
		System.out.println("=======================================");
		
		workItemManager.completeWorkItem(workItem.getId(),results);		
	}

}
