package com.e.closing.model.custom;

import java.util.Date;

public class KaleoInstanceObject {
	long kaleoInstanceId;
	long groupId;
	long companyId;
	long userId;
	String userName;
	Date createDate;
	Date modifiedDate;
	long kaleoDefinitionId;
	String kaleoDefinitionName;
	int kaleoDefinitionVersion;
	long rootKaleoInstanceTokenId;
	String className;
	long classPK;
	boolean completed;
	Date completionDate;
	String workflowContext;

	public long getKaleoInstanceId() {
		return kaleoInstanceId;
	}

	public void setKaleoInstanceId(long kaleoInstanceId) {
		this.kaleoInstanceId = kaleoInstanceId;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public long getKaleoDefinitionId() {
		return kaleoDefinitionId;
	}

	public void setKaleoDefinitionId(long kaleoDefinitionId) {
		this.kaleoDefinitionId = kaleoDefinitionId;
	}

	public String getKaleoDefinitionName() {
		return kaleoDefinitionName;
	}

	public void setKaleoDefinitionName(String kaleoDefinitionName) {
		this.kaleoDefinitionName = kaleoDefinitionName;
	}

	public int getKaleoDefinitionVersion() {
		return kaleoDefinitionVersion;
	}

	public void setKaleoDefinitionVersion(int kaleoDefinitionVersion) {
		this.kaleoDefinitionVersion = kaleoDefinitionVersion;
	}

	public long getRootKaleoInstanceTokenId() {
		return rootKaleoInstanceTokenId;
	}

	public void setRootKaleoInstanceTokenId(long rootKaleoInstanceTokenId) {
		this.rootKaleoInstanceTokenId = rootKaleoInstanceTokenId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public long getClassPK() {
		return classPK;
	}

	public void setClassPK(long classPK) {
		this.classPK = classPK;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public String getWorkflowContext() {
		return workflowContext;
	}

	public void setWorkflowContext(String workflowContext) {
		this.workflowContext = workflowContext;
	}

}
