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

package com.business.trip.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BtReimbursementSAPInfoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BtReimbursementSAPInfoLocalService
 * @generated
 */
public class BtReimbursementSAPInfoLocalServiceWrapper
	implements BtReimbursementSAPInfoLocalService,
		ServiceWrapper<BtReimbursementSAPInfoLocalService> {
	public BtReimbursementSAPInfoLocalServiceWrapper(
		BtReimbursementSAPInfoLocalService btReimbursementSAPInfoLocalService) {
		_btReimbursementSAPInfoLocalService = btReimbursementSAPInfoLocalService;
	}

	/**
	* Adds the bt reimbursement s a p info to the database. Also notifies the appropriate model listeners.
	*
	* @param btReimbursementSAPInfo the bt reimbursement s a p info
	* @return the bt reimbursement s a p info that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtReimbursementSAPInfo addBtReimbursementSAPInfo(
		com.business.trip.model.BtReimbursementSAPInfo btReimbursementSAPInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btReimbursementSAPInfoLocalService.addBtReimbursementSAPInfo(btReimbursementSAPInfo);
	}

	/**
	* Creates a new bt reimbursement s a p info with the primary key. Does not add the bt reimbursement s a p info to the database.
	*
	* @param btReimbursementSAPInfoId the primary key for the new bt reimbursement s a p info
	* @return the new bt reimbursement s a p info
	*/
	@Override
	public com.business.trip.model.BtReimbursementSAPInfo createBtReimbursementSAPInfo(
		long btReimbursementSAPInfoId) {
		return _btReimbursementSAPInfoLocalService.createBtReimbursementSAPInfo(btReimbursementSAPInfoId);
	}

	/**
	* Deletes the bt reimbursement s a p info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btReimbursementSAPInfoId the primary key of the bt reimbursement s a p info
	* @return the bt reimbursement s a p info that was removed
	* @throws PortalException if a bt reimbursement s a p info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtReimbursementSAPInfo deleteBtReimbursementSAPInfo(
		long btReimbursementSAPInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _btReimbursementSAPInfoLocalService.deleteBtReimbursementSAPInfo(btReimbursementSAPInfoId);
	}

	/**
	* Deletes the bt reimbursement s a p info from the database. Also notifies the appropriate model listeners.
	*
	* @param btReimbursementSAPInfo the bt reimbursement s a p info
	* @return the bt reimbursement s a p info that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtReimbursementSAPInfo deleteBtReimbursementSAPInfo(
		com.business.trip.model.BtReimbursementSAPInfo btReimbursementSAPInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btReimbursementSAPInfoLocalService.deleteBtReimbursementSAPInfo(btReimbursementSAPInfo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _btReimbursementSAPInfoLocalService.dynamicQuery();
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
		return _btReimbursementSAPInfoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtReimbursementSAPInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _btReimbursementSAPInfoLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtReimbursementSAPInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _btReimbursementSAPInfoLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _btReimbursementSAPInfoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _btReimbursementSAPInfoLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.business.trip.model.BtReimbursementSAPInfo fetchBtReimbursementSAPInfo(
		long btReimbursementSAPInfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btReimbursementSAPInfoLocalService.fetchBtReimbursementSAPInfo(btReimbursementSAPInfoId);
	}

	/**
	* Returns the bt reimbursement s a p info with the primary key.
	*
	* @param btReimbursementSAPInfoId the primary key of the bt reimbursement s a p info
	* @return the bt reimbursement s a p info
	* @throws PortalException if a bt reimbursement s a p info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtReimbursementSAPInfo getBtReimbursementSAPInfo(
		long btReimbursementSAPInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _btReimbursementSAPInfoLocalService.getBtReimbursementSAPInfo(btReimbursementSAPInfoId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _btReimbursementSAPInfoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the bt reimbursement s a p infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtReimbursementSAPInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt reimbursement s a p infos
	* @param end the upper bound of the range of bt reimbursement s a p infos (not inclusive)
	* @return the range of bt reimbursement s a p infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.business.trip.model.BtReimbursementSAPInfo> getBtReimbursementSAPInfos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btReimbursementSAPInfoLocalService.getBtReimbursementSAPInfos(start,
			end);
	}

	/**
	* Returns the number of bt reimbursement s a p infos.
	*
	* @return the number of bt reimbursement s a p infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBtReimbursementSAPInfosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btReimbursementSAPInfoLocalService.getBtReimbursementSAPInfosCount();
	}

	/**
	* Updates the bt reimbursement s a p info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param btReimbursementSAPInfo the bt reimbursement s a p info
	* @return the bt reimbursement s a p info that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtReimbursementSAPInfo updateBtReimbursementSAPInfo(
		com.business.trip.model.BtReimbursementSAPInfo btReimbursementSAPInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btReimbursementSAPInfoLocalService.updateBtReimbursementSAPInfo(btReimbursementSAPInfo);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _btReimbursementSAPInfoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_btReimbursementSAPInfoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _btReimbursementSAPInfoLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.business.trip.model.BtReimbursementSAPInfo saveOrUpdateBtReimbursementSAPInfo(
		com.business.trip.model.BtReimbursementSAPInfo btReimbursementSAPInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btReimbursementSAPInfoLocalService.saveOrUpdateBtReimbursementSAPInfo(btReimbursementSAPInfo);
	}

	@Override
	public com.business.trip.model.BtReimbursementSAPInfo fetchByB_C(
		java.lang.String currency, long businessTripPkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btReimbursementSAPInfoLocalService.fetchByB_C(currency,
			businessTripPkId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BtReimbursementSAPInfoLocalService getWrappedBtReimbursementSAPInfoLocalService() {
		return _btReimbursementSAPInfoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBtReimbursementSAPInfoLocalService(
		BtReimbursementSAPInfoLocalService btReimbursementSAPInfoLocalService) {
		_btReimbursementSAPInfoLocalService = btReimbursementSAPInfoLocalService;
	}

	@Override
	public BtReimbursementSAPInfoLocalService getWrappedService() {
		return _btReimbursementSAPInfoLocalService;
	}

	@Override
	public void setWrappedService(
		BtReimbursementSAPInfoLocalService btReimbursementSAPInfoLocalService) {
		_btReimbursementSAPInfoLocalService = btReimbursementSAPInfoLocalService;
	}

	private BtReimbursementSAPInfoLocalService _btReimbursementSAPInfoLocalService;
}