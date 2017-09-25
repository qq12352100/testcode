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
 * Provides a wrapper for {@link BtTrainInfoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BtTrainInfoLocalService
 * @generated
 */
public class BtTrainInfoLocalServiceWrapper implements BtTrainInfoLocalService,
	ServiceWrapper<BtTrainInfoLocalService> {
	public BtTrainInfoLocalServiceWrapper(
		BtTrainInfoLocalService btTrainInfoLocalService) {
		_btTrainInfoLocalService = btTrainInfoLocalService;
	}

	/**
	* Adds the bt train info to the database. Also notifies the appropriate model listeners.
	*
	* @param btTrainInfo the bt train info
	* @return the bt train info that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtTrainInfo addBtTrainInfo(
		com.business.trip.model.BtTrainInfo btTrainInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btTrainInfoLocalService.addBtTrainInfo(btTrainInfo);
	}

	/**
	* Creates a new bt train info with the primary key. Does not add the bt train info to the database.
	*
	* @param btTrainInfoId the primary key for the new bt train info
	* @return the new bt train info
	*/
	@Override
	public com.business.trip.model.BtTrainInfo createBtTrainInfo(
		long btTrainInfoId) {
		return _btTrainInfoLocalService.createBtTrainInfo(btTrainInfoId);
	}

	/**
	* Deletes the bt train info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btTrainInfoId the primary key of the bt train info
	* @return the bt train info that was removed
	* @throws PortalException if a bt train info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtTrainInfo deleteBtTrainInfo(
		long btTrainInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _btTrainInfoLocalService.deleteBtTrainInfo(btTrainInfoId);
	}

	/**
	* Deletes the bt train info from the database. Also notifies the appropriate model listeners.
	*
	* @param btTrainInfo the bt train info
	* @return the bt train info that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtTrainInfo deleteBtTrainInfo(
		com.business.trip.model.BtTrainInfo btTrainInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btTrainInfoLocalService.deleteBtTrainInfo(btTrainInfo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _btTrainInfoLocalService.dynamicQuery();
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
		return _btTrainInfoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTrainInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _btTrainInfoLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTrainInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _btTrainInfoLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _btTrainInfoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _btTrainInfoLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.business.trip.model.BtTrainInfo fetchBtTrainInfo(
		long btTrainInfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btTrainInfoLocalService.fetchBtTrainInfo(btTrainInfoId);
	}

	/**
	* Returns the bt train info with the primary key.
	*
	* @param btTrainInfoId the primary key of the bt train info
	* @return the bt train info
	* @throws PortalException if a bt train info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtTrainInfo getBtTrainInfo(
		long btTrainInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _btTrainInfoLocalService.getBtTrainInfo(btTrainInfoId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _btTrainInfoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the bt train infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTrainInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of bt train infos
	* @param end the upper bound of the range of bt train infos (not inclusive)
	* @return the range of bt train infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.business.trip.model.BtTrainInfo> getBtTrainInfos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btTrainInfoLocalService.getBtTrainInfos(start, end);
	}

	/**
	* Returns the number of bt train infos.
	*
	* @return the number of bt train infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getBtTrainInfosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btTrainInfoLocalService.getBtTrainInfosCount();
	}

	/**
	* Updates the bt train info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param btTrainInfo the bt train info
	* @return the bt train info that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.BtTrainInfo updateBtTrainInfo(
		com.business.trip.model.BtTrainInfo btTrainInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btTrainInfoLocalService.updateBtTrainInfo(btTrainInfo);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _btTrainInfoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_btTrainInfoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _btTrainInfoLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public int findCountByB_T(long businessTripPkId, java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btTrainInfoLocalService.findCountByB_T(businessTripPkId,
			tripType);
	}

	@Override
	public java.util.List<com.business.trip.model.BtTrainInfo> findByB_T(
		long businessTripPkId, java.lang.String tripType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btTrainInfoLocalService.findByB_T(businessTripPkId, tripType,
			start, end);
	}

	@Override
	public java.util.List<com.business.trip.model.BtTrainInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _btTrainInfoLocalService.findAll();
	}

	@Override
	public void copyBtTrainInfoByB_T(long businessTripPkId,
		long targetBusinessTripPkId, java.lang.String tripType,
		java.lang.String targetTripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		_btTrainInfoLocalService.copyBtTrainInfoByB_T(businessTripPkId,
			targetBusinessTripPkId, tripType, targetTripType);
	}

	@Override
	public void deleteBtTrainInfoByB_T(long businessTripPkId,
		java.lang.String tripType)
		throws com.liferay.portal.kernel.exception.SystemException {
		_btTrainInfoLocalService.deleteBtTrainInfoByB_T(businessTripPkId,
			tripType);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public BtTrainInfoLocalService getWrappedBtTrainInfoLocalService() {
		return _btTrainInfoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedBtTrainInfoLocalService(
		BtTrainInfoLocalService btTrainInfoLocalService) {
		_btTrainInfoLocalService = btTrainInfoLocalService;
	}

	@Override
	public BtTrainInfoLocalService getWrappedService() {
		return _btTrainInfoLocalService;
	}

	@Override
	public void setWrappedService(
		BtTrainInfoLocalService btTrainInfoLocalService) {
		_btTrainInfoLocalService = btTrainInfoLocalService;
	}

	private BtTrainInfoLocalService _btTrainInfoLocalService;
}