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
 * Provides a wrapper for {@link RateCityLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RateCityLocalService
 * @generated
 */
public class RateCityLocalServiceWrapper implements RateCityLocalService,
	ServiceWrapper<RateCityLocalService> {
	public RateCityLocalServiceWrapper(
		RateCityLocalService rateCityLocalService) {
		_rateCityLocalService = rateCityLocalService;
	}

	/**
	* Adds the rate city to the database. Also notifies the appropriate model listeners.
	*
	* @param rateCity the rate city
	* @return the rate city that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.RateCity addRateCity(
		com.business.trip.model.RateCity rateCity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rateCityLocalService.addRateCity(rateCity);
	}

	/**
	* Creates a new rate city with the primary key. Does not add the rate city to the database.
	*
	* @param ratecityId the primary key for the new rate city
	* @return the new rate city
	*/
	@Override
	public com.business.trip.model.RateCity createRateCity(long ratecityId) {
		return _rateCityLocalService.createRateCity(ratecityId);
	}

	/**
	* Deletes the rate city with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ratecityId the primary key of the rate city
	* @return the rate city that was removed
	* @throws PortalException if a rate city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.RateCity deleteRateCity(long ratecityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rateCityLocalService.deleteRateCity(ratecityId);
	}

	/**
	* Deletes the rate city from the database. Also notifies the appropriate model listeners.
	*
	* @param rateCity the rate city
	* @return the rate city that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.RateCity deleteRateCity(
		com.business.trip.model.RateCity rateCity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rateCityLocalService.deleteRateCity(rateCity);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _rateCityLocalService.dynamicQuery();
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
		return _rateCityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.RateCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _rateCityLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.RateCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _rateCityLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _rateCityLocalService.dynamicQueryCount(dynamicQuery);
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
		return _rateCityLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.business.trip.model.RateCity fetchRateCity(long ratecityId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rateCityLocalService.fetchRateCity(ratecityId);
	}

	/**
	* Returns the rate city with the primary key.
	*
	* @param ratecityId the primary key of the rate city
	* @return the rate city
	* @throws PortalException if a rate city with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.RateCity getRateCity(long ratecityId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rateCityLocalService.getRateCity(ratecityId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _rateCityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the rate cities.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.RateCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rate cities
	* @param end the upper bound of the range of rate cities (not inclusive)
	* @return the range of rate cities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.business.trip.model.RateCity> getRateCities(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rateCityLocalService.getRateCities(start, end);
	}

	/**
	* Returns the number of rate cities.
	*
	* @return the number of rate cities
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getRateCitiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rateCityLocalService.getRateCitiesCount();
	}

	/**
	* Updates the rate city in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param rateCity the rate city
	* @return the rate city that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.business.trip.model.RateCity updateRateCity(
		com.business.trip.model.RateCity rateCity)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rateCityLocalService.updateRateCity(rateCity);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _rateCityLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_rateCityLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _rateCityLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RateCityLocalService getWrappedRateCityLocalService() {
		return _rateCityLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRateCityLocalService(
		RateCityLocalService rateCityLocalService) {
		_rateCityLocalService = rateCityLocalService;
	}

	@Override
	public RateCityLocalService getWrappedService() {
		return _rateCityLocalService;
	}

	@Override
	public void setWrappedService(RateCityLocalService rateCityLocalService) {
		_rateCityLocalService = rateCityLocalService;
	}

	private RateCityLocalService _rateCityLocalService;
}