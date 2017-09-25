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
 * Provides a wrapper for {@link BtFlightTrainInfoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BtFlightTrainInfoLocalService
 * @generated
 */
public class BtFlightTrainInfoLocalServiceWrapper
	implements BtFlightTrainInfoLocalService,
		ServiceWrapper<BtFlightTrainInfoLocalService> {
	public BtFlightTrainInfoLocalServiceWrapper(
		BtFlightTrainInfoLocalService btFlightTrainInfoLocalService) {
		_btFlightTrainInfoLocalService = btFlightTrainInfoLocalService;
	}

	/**
	* Adds the bt flight train info to the database. Also notifies the appropriate model listeners.
	*
	* @param btFlightTrainInfo the bt flight train info
	* @return the bt flight train info that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtFlightTrainInfo addBtFlightTrainInfo(
		com.business.trip.model.BtFlightTrainInfo btFlightTrainInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btFlightTrainInfoLocalService.addBtFlightTrainInfo(btFlightTrainInfo);
	}

	/**
	* Creates a new bt flight train info with the primary key. Does not add the bt flight train info to the database.
	*
	* @param btFlightTrainInfoId the primary key for the new bt flight train info
	* @return the new bt flight train info
	*/
	@Override
	public com.business.trip.model.BtFlightTrainInfo createBtFlightTrainInfo(
		long btFlightTrainInfoId) {
		return _btFlightTrainInfoLocalService.createBtFlightTrainInfo(btFlightTrainInfoId);
	}

	/**
	* Deletes the bt flight train info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btFlightTrainInfoId the primary key of the bt flight train info
	* @return the bt flight train info that was removed
	* @throws PortalException if a bt flight train info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtFlightTrainInfo deleteBtFlightTrainInfo(
		long btFlightTrainInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _btFlightTrainInfoLocalService.deleteBtFlightTrainInfo(btFlightTrainInfoId);
	}

	/**
	* Deletes the bt flight train info from the database. Also notifies the appropriate model listeners.
	*
	* @param btFlightTrainInfo the bt flight train info
	* @return the bt flight train info that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtFlightTrainInfo deleteBtFlightTrainInfo(
		com.business.trip.model.BtFlightTrainInfo btFlightTrainInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btFlightTrainInfoLocalService.deleteBtFlightTrainInfo(btFlightTrainInfo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _btFlightTrainInfoLocalService.dynamicQuery();
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
		return _btFlightTrainInfoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtFlightTrainInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _btFlightTrainInfoLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtFlightTrainInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _btFlightTrainInfoLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _btFlightTrainInfoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _btFlightTrainInfoLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.business.trip.model.BtFlightTrainInfo fetchBtFlightTrainInfo(
		long btFlightTrainInfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btFlightTrainInfoLocalService.fetchBtFlightTrainInfo(btFlightTrainInfoId);
	}

	/**
	* Returns the bt flight train info with the primary key.
	*
	* @param btFlightTrainInfoId the primary key of the bt flight train info
	* @return the bt flight train info
	* @throws PortalException if a bt flight train info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtFlightTrainInfo getBtFlightTrainInfo(
		long btFlightTrainInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _btFlightTrainInfoLocalService.getBtFlightTrainInfo(btFlightTrainInfoId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _btFlightTrainInfoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the bt flight train infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtFlightTrainInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt flight train infos
	* @param end the upper bound of the range of bt flight train infos (not inclusive)
	* @return the range of bt flight train infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.business.trip.model.BtFlightTrainInfo> getBtFlightTrainInfos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btFlightTrainInfoLocalService.getBtFlightTrainInfos(start, end);
	}

	/**
	* Returns the number of bt flight train infos.
	*
	* @return the number of bt flight train infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBtFlightTrainInfosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btFlightTrainInfoLocalService.getBtFlightTrainInfosCount();
	}

	/**
	* Updates the bt flight train info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param btFlightTrainInfo the bt flight train info
	* @return the bt flight train info that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtFlightTrainInfo updateBtFlightTrainInfo(
		com.business.trip.model.BtFlightTrainInfo btFlightTrainInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btFlightTrainInfoLocalService.updateBtFlightTrainInfo(btFlightTrainInfo);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _btFlightTrainInfoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_btFlightTrainInfoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _btFlightTrainInfoLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public int findCountByB_T(long businessTripPkId, java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btFlightTrainInfoLocalService.findCountByB_T(businessTripPkId,
			tripType);
	}

	@Override
	public java.util.List<com.business.trip.model.BtFlightTrainInfo> findByB_T(
		long businessTripPkId, java.lang.String tripType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btFlightTrainInfoLocalService.findByB_T(businessTripPkId,
			tripType, start, end);
	}

	@Override
	public java.util.List<com.business.trip.model.BtFlightTrainInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btFlightTrainInfoLocalService.findAll();
	}

	@Override
	public void copyBtFlightTrainInfoByB_T(long businessTripPkId,
		long targetBusinessTripPkId, java.lang.String tripType,
		java.lang.String targetTripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		_btFlightTrainInfoLocalService.copyBtFlightTrainInfoByB_T(businessTripPkId,
			targetBusinessTripPkId, tripType, targetTripType);
	}

	@Override
	public void deleteBtFlightTrainInfoByB_T(long businessTripPkId,
		java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		_btFlightTrainInfoLocalService.deleteBtFlightTrainInfoByB_T(businessTripPkId,
			tripType);
	}

	@Override
	public boolean isNeedEVPApprove(long businessTripPkId,
		java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btFlightTrainInfoLocalService.isNeedEVPApprove(businessTripPkId,
			tripType);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BtFlightTrainInfoLocalService getWrappedBtFlightTrainInfoLocalService() {
		return _btFlightTrainInfoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBtFlightTrainInfoLocalService(
		BtFlightTrainInfoLocalService btFlightTrainInfoLocalService) {
		_btFlightTrainInfoLocalService = btFlightTrainInfoLocalService;
	}

	@Override
	public BtFlightTrainInfoLocalService getWrappedService() {
		return _btFlightTrainInfoLocalService;
	}

	@Override
	public void setWrappedService(
		BtFlightTrainInfoLocalService btFlightTrainInfoLocalService) {
		_btFlightTrainInfoLocalService = btFlightTrainInfoLocalService;
	}

	private BtFlightTrainInfoLocalService _btFlightTrainInfoLocalService;
}