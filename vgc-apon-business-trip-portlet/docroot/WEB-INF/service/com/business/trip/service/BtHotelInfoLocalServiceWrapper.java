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
 * Provides a wrapper for {@link BtHotelInfoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BtHotelInfoLocalService
 * @generated
 */
public class BtHotelInfoLocalServiceWrapper implements BtHotelInfoLocalService,
	ServiceWrapper<BtHotelInfoLocalService> {
	public BtHotelInfoLocalServiceWrapper(
		BtHotelInfoLocalService btHotelInfoLocalService) {
		_btHotelInfoLocalService = btHotelInfoLocalService;
	}

	/**
	* Adds the bt hotel info to the database. Also notifies the appropriate model listeners.
	*
	* @param btHotelInfo the bt hotel info
	* @return the bt hotel info that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtHotelInfo addBtHotelInfo(
		com.business.trip.model.BtHotelInfo btHotelInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btHotelInfoLocalService.addBtHotelInfo(btHotelInfo);
	}

	/**
	* Creates a new bt hotel info with the primary key. Does not add the bt hotel info to the database.
	*
	* @param btHotelInfoId the primary key for the new bt hotel info
	* @return the new bt hotel info
	*/
	@Override
	public com.business.trip.model.BtHotelInfo createBtHotelInfo(
		long btHotelInfoId) {
		return _btHotelInfoLocalService.createBtHotelInfo(btHotelInfoId);
	}

	/**
	* Deletes the bt hotel info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btHotelInfoId the primary key of the bt hotel info
	* @return the bt hotel info that was removed
	* @throws PortalException if a bt hotel info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtHotelInfo deleteBtHotelInfo(
		long btHotelInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _btHotelInfoLocalService.deleteBtHotelInfo(btHotelInfoId);
	}

	/**
	* Deletes the bt hotel info from the database. Also notifies the appropriate model listeners.
	*
	* @param btHotelInfo the bt hotel info
	* @return the bt hotel info that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtHotelInfo deleteBtHotelInfo(
		com.business.trip.model.BtHotelInfo btHotelInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btHotelInfoLocalService.deleteBtHotelInfo(btHotelInfo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _btHotelInfoLocalService.dynamicQuery();
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
		return _btHotelInfoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtHotelInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _btHotelInfoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtHotelInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _btHotelInfoLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _btHotelInfoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _btHotelInfoLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.business.trip.model.BtHotelInfo fetchBtHotelInfo(
		long btHotelInfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btHotelInfoLocalService.fetchBtHotelInfo(btHotelInfoId);
	}

	/**
	* Returns the bt hotel info with the primary key.
	*
	* @param btHotelInfoId the primary key of the bt hotel info
	* @return the bt hotel info
	* @throws PortalException if a bt hotel info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtHotelInfo getBtHotelInfo(
		long btHotelInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _btHotelInfoLocalService.getBtHotelInfo(btHotelInfoId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _btHotelInfoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the bt hotel infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtHotelInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt hotel infos
	* @param end the upper bound of the range of bt hotel infos (not inclusive)
	* @return the range of bt hotel infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.business.trip.model.BtHotelInfo> getBtHotelInfos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btHotelInfoLocalService.getBtHotelInfos(start, end);
	}

	/**
	* Returns the number of bt hotel infos.
	*
	* @return the number of bt hotel infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBtHotelInfosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btHotelInfoLocalService.getBtHotelInfosCount();
	}

	/**
	* Updates the bt hotel info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param btHotelInfo the bt hotel info
	* @return the bt hotel info that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtHotelInfo updateBtHotelInfo(
		com.business.trip.model.BtHotelInfo btHotelInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btHotelInfoLocalService.updateBtHotelInfo(btHotelInfo);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _btHotelInfoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_btHotelInfoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _btHotelInfoLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public int findCountByB_T(long businessTripPkId, java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btHotelInfoLocalService.findCountByB_T(businessTripPkId,
			tripType);
	}

	@Override
	public java.util.List<com.business.trip.model.BtHotelInfo> findByB_T(
		long businessTripPkId, java.lang.String tripType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btHotelInfoLocalService.findByB_T(businessTripPkId, tripType,
			start, end);
	}

	@Override
	public java.util.List<com.business.trip.model.BtHotelInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btHotelInfoLocalService.findAll();
	}

	@Override
	public boolean isNeedEVPApprove(long businessTripPkId,
		java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btHotelInfoLocalService.isNeedEVPApprove(businessTripPkId,
			tripType);
	}

	@Override
	public void copyBtHotelInfoByB_T(long businessTripPkId,
		long targetBusinessTripPkId, java.lang.String tripType,
		java.lang.String targetTripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		_btHotelInfoLocalService.copyBtHotelInfoByB_T(businessTripPkId,
			targetBusinessTripPkId, tripType, targetTripType);
	}

	@Override
	public void deleteBtHotelInfoByB_T(long businessTripPkId,
		java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		_btHotelInfoLocalService.deleteBtHotelInfoByB_T(businessTripPkId,
			tripType);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BtHotelInfoLocalService getWrappedBtHotelInfoLocalService() {
		return _btHotelInfoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBtHotelInfoLocalService(
		BtHotelInfoLocalService btHotelInfoLocalService) {
		_btHotelInfoLocalService = btHotelInfoLocalService;
	}

	@Override
	public BtHotelInfoLocalService getWrappedService() {
		return _btHotelInfoLocalService;
	}

	@Override
	public void setWrappedService(
		BtHotelInfoLocalService btHotelInfoLocalService) {
		_btHotelInfoLocalService = btHotelInfoLocalService;
	}

	private BtHotelInfoLocalService _btHotelInfoLocalService;
}