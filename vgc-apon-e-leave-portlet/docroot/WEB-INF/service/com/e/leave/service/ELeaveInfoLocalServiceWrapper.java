/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.e.leave.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ELeaveInfoLocalService}.
 *
 * @author EZEYIFE
 * @see ELeaveInfoLocalService
 * @generated
 */
public class ELeaveInfoLocalServiceWrapper implements ELeaveInfoLocalService,
	ServiceWrapper<ELeaveInfoLocalService> {
	public ELeaveInfoLocalServiceWrapper(
		ELeaveInfoLocalService eLeaveInfoLocalService) {
		_eLeaveInfoLocalService = eLeaveInfoLocalService;
	}

	/**
	* Adds the e leave info to the database. Also notifies the appropriate model listeners.
	*
	* @param eLeaveInfo the e leave info
	* @return the e leave info that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.e.leave.model.ELeaveInfo addELeaveInfo(
		com.e.leave.model.ELeaveInfo eLeaveInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveInfoLocalService.addELeaveInfo(eLeaveInfo);
	}

	/**
	* Creates a new e leave info with the primary key. Does not add the e leave info to the database.
	*
	* @param eLeaveInfoId the primary key for the new e leave info
	* @return the new e leave info
	*/
	@Override
	public com.e.leave.model.ELeaveInfo createELeaveInfo(long eLeaveInfoId) {
		return _eLeaveInfoLocalService.createELeaveInfo(eLeaveInfoId);
	}

	/**
	* Deletes the e leave info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eLeaveInfoId the primary key of the e leave info
	* @return the e leave info that was removed
	* @throws PortalException if a e leave info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.e.leave.model.ELeaveInfo deleteELeaveInfo(long eLeaveInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveInfoLocalService.deleteELeaveInfo(eLeaveInfoId);
	}

	/**
	* Deletes the e leave info from the database. Also notifies the appropriate model listeners.
	*
	* @param eLeaveInfo the e leave info
	* @return the e leave info that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.e.leave.model.ELeaveInfo deleteELeaveInfo(
		com.e.leave.model.ELeaveInfo eLeaveInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveInfoLocalService.deleteELeaveInfo(eLeaveInfo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eLeaveInfoLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveInfoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.leave.model.impl.ELeaveInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveInfoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.leave.model.impl.ELeaveInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveInfoLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveInfoLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveInfoLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.e.leave.model.ELeaveInfo fetchELeaveInfo(long eLeaveInfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveInfoLocalService.fetchELeaveInfo(eLeaveInfoId);
	}

	/**
	* Returns the e leave info with the primary key.
	*
	* @param eLeaveInfoId the primary key of the e leave info
	* @return the e leave info
	* @throws PortalException if a e leave info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.e.leave.model.ELeaveInfo getELeaveInfo(long eLeaveInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveInfoLocalService.getELeaveInfo(eLeaveInfoId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveInfoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the e leave infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.leave.model.impl.ELeaveInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e leave infos
	* @param end the upper bound of the range of e leave infos (not inclusive)
	* @return the range of e leave infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.e.leave.model.ELeaveInfo> getELeaveInfos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveInfoLocalService.getELeaveInfos(start, end);
	}

	/**
	* Returns the number of e leave infos.
	*
	* @return the number of e leave infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getELeaveInfosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveInfoLocalService.getELeaveInfosCount();
	}

	/**
	* Updates the e leave info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param eLeaveInfo the e leave info
	* @return the e leave info that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.e.leave.model.ELeaveInfo updateELeaveInfo(
		com.e.leave.model.ELeaveInfo eLeaveInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveInfoLocalService.updateELeaveInfo(eLeaveInfo);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _eLeaveInfoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_eLeaveInfoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _eLeaveInfoLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.e.leave.model.ELeaveInfo> findLeaveListByELeaveId(
		long eLeaveId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveInfoLocalService.findLeaveListByELeaveId(eLeaveId);
	}

	@Override
	public boolean saveOrUpdateELeaveInfo(long eLeaveId,
		java.lang.String typeOfLeave, java.util.Date[] startDates,
		java.util.Date[] endDates, java.lang.String[] startTimes,
		java.lang.String[] endTimes, java.lang.String[] leaveDays,
		java.lang.String remark)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveInfoLocalService.saveOrUpdateELeaveInfo(eLeaveId,
			typeOfLeave, startDates, endDates, startTimes, endTimes, leaveDays,
			remark);
	}

	@Override
	public boolean isLeaveInfoExist(long eleaveId, java.lang.String typeOfLeave)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _eLeaveInfoLocalService.isLeaveInfoExist(eleaveId, typeOfLeave);
	}

	@Override
	public boolean checkDateList(java.lang.String typeOfLeaveId,
		java.util.Date startDates, java.util.Date endDates,
		java.lang.String startTimes, java.lang.String endTimes,
		java.util.List<com.e.leave.model.ELeaveInfo> eLeaveInfoList) {
		return _eLeaveInfoLocalService.checkDateList(typeOfLeaveId, startDates,
			endDates, startTimes, endTimes, eLeaveInfoList);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ELeaveInfoLocalService getWrappedELeaveInfoLocalService() {
		return _eLeaveInfoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedELeaveInfoLocalService(
		ELeaveInfoLocalService eLeaveInfoLocalService) {
		_eLeaveInfoLocalService = eLeaveInfoLocalService;
	}

	@Override
	public ELeaveInfoLocalService getWrappedService() {
		return _eLeaveInfoLocalService;
	}

	@Override
	public void setWrappedService(ELeaveInfoLocalService eLeaveInfoLocalService) {
		_eLeaveInfoLocalService = eLeaveInfoLocalService;
	}

	private ELeaveInfoLocalService _eLeaveInfoLocalService;
}