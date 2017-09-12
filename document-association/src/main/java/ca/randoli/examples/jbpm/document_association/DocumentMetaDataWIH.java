package ca.randoli.examples.jbpm.document_association;

import java.util.HashMap;
import java.util.Map;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

public class DocumentMetaDataWIH implements WorkItemHandler {

	public void abortWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
		System.out.println("DocumentMetaDataWIH Aborted!");
	}

	public void executeWorkItem(WorkItem workItem, WorkItemManager workItemManager) {
		System.out.println("=======================================");
		System.out.println("DocumentMetaDataWIH documentId : " + workItem.getParameter("documentId"));
		
		
		Map<String,Object> results = new HashMap<String,Object>();
		results.put("document-type", "pay-stub");
		workItemManager.completeWorkItem(workItem.getId(),results);		
	}

}
