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

package com.business.trip.service.base;

import com.business.trip.model.BtCostList;
import com.business.trip.service.BtCostListLocalService;
import com.business.trip.service.persistence.BtCarRentalInfoPersistence;
import com.business.trip.service.persistence.BtCostListPersistence;
import com.business.trip.service.persistence.BtEntertainmentDetailPersistence;
import com.business.trip.service.persistence.BtExchangeRatePersistence;
import com.business.trip.service.persistence.BtExchangeSAPRatePersistence;
import com.business.trip.service.persistence.BtFlightTrainInfoPersistence;
import com.business.trip.service.persistence.BtHotelInfoPersistence;
import com.business.trip.service.persistence.BtReimbursementSAPInfoPersistence;
import com.business.trip.service.persistence.BtTrainInfoPersistence;
import com.business.trip.service.persistence.BtTravelExpensePersistence;
import com.business.trip.service.persistence.BusinessTripApplicationPersistence;
import com.business.trip.service.persistence.BusinessTripReimbursementPersistence;
import com.business.trip.service.persistence.RateCityPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the bt cost list local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.business.trip.service.impl.BtCostListLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.business.trip.service.impl.BtCostListLocalServiceImpl
 * @see com.business.trip.service.BtCostListLocalServiceUtil
 * @generated
 */
public abstract class BtCostListLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements BtCostListLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.business.trip.service.BtCostListLocalServiceUtil} to access the bt cost list local service.
	 */

	/**
	 * Adds the bt cost list to the database. Also notifies the appropriate model listeners.
	 *
	 * @param btCostList the bt cost list
	 * @return the bt cost list that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public BtCostList addBtCostList(BtCostList btCostList)
		throws SystemException {
		btCostList.setNew(true);

		return btCostListPersistence.update(btCostList);
	}

	/**
	 * Creates a new bt cost list with the primary key. Does not add the bt cost list to the database.
	 *
	 * @param btCostListId the primary key for the new bt cost list
	 * @return the new bt cost list
	 */
	@Override
	public BtCostList createBtCostList(long btCostListId) {
		return btCostListPersistence.create(btCostListId);
	}

	/**
	 * Deletes the bt cost list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param btCostListId the primary key of the bt cost list
	 * @return the bt cost list that was removed
	 * @throws PortalException if a bt cost list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public BtCostList deleteBtCostList(long btCostListId)
		throws PortalException, SystemException {
		return btCostListPersistence.remove(btCostListId);
	}

	/**
	 * Deletes the bt cost list from the database. Also notifies the appropriate model listeners.
	 *
	 * @param btCostList the bt cost list
	 * @return the bt cost list that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public BtCostList deleteBtCostList(BtCostList btCostList)
		throws SystemException {
		return btCostListPersistence.remove(btCostList);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(BtCostList.class,
			clazz.getClassLoader());
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
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return btCostListPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCostListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return btCostListPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCostListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return btCostListPersistence.findWithDynamicQuery(dynamicQuery, start,
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return btCostListPersistence.countWithDynamicQuery(dynamicQuery);
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return btCostListPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public BtCostList fetchBtCostList(long btCostListId)
		throws SystemException {
		return btCostListPersistence.fetchByPrimaryKey(btCostListId);
	}

	/**
	 * Returns the bt cost list with the primary key.
	 *
	 * @param btCostListId the primary key of the bt cost list
	 * @return the bt cost list
	 * @throws PortalException if a bt cost list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCostList getBtCostList(long btCostListId)
		throws PortalException, SystemException {
		return btCostListPersistence.findByPrimaryKey(btCostListId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return btCostListPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the bt cost lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCostListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bt cost lists
	 * @param end the upper bound of the range of bt cost lists (not inclusive)
	 * @return the range of bt cost lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtCostList> getBtCostLists(int start, int end)
		throws SystemException {
		return btCostListPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of bt cost lists.
	 *
	 * @return the number of bt cost lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getBtCostListsCount() throws SystemException {
		return btCostListPersistence.countAll();
	}

	/**
	 * Updates the bt cost list in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param btCostList the bt cost list
	 * @return the bt cost list that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public BtCostList updateBtCostList(BtCostList btCostList)
		throws SystemException {
		return btCostListPersistence.update(btCostList);
	}

	/**
	 * Returns the bt car rental info local service.
	 *
	 * @return the bt car rental info local service
	 */
	public com.business.trip.service.BtCarRentalInfoLocalService getBtCarRentalInfoLocalService() {
		return btCarRentalInfoLocalService;
	}

	/**
	 * Sets the bt car rental info local service.
	 *
	 * @param btCarRentalInfoLocalService the bt car rental info local service
	 */
	public void setBtCarRentalInfoLocalService(
		com.business.trip.service.BtCarRentalInfoLocalService btCarRentalInfoLocalService) {
		this.btCarRentalInfoLocalService = btCarRentalInfoLocalService;
	}

	/**
	 * Returns the bt car rental info persistence.
	 *
	 * @return the bt car rental info persistence
	 */
	public BtCarRentalInfoPersistence getBtCarRentalInfoPersistence() {
		return btCarRentalInfoPersistence;
	}

	/**
	 * Sets the bt car rental info persistence.
	 *
	 * @param btCarRentalInfoPersistence the bt car rental info persistence
	 */
	public void setBtCarRentalInfoPersistence(
		BtCarRentalInfoPersistence btCarRentalInfoPersistence) {
		this.btCarRentalInfoPersistence = btCarRentalInfoPersistence;
	}

	/**
	 * Returns the bt cost list local service.
	 *
	 * @return the bt cost list local service
	 */
	public com.business.trip.service.BtCostListLocalService getBtCostListLocalService() {
		return btCostListLocalService;
	}

	/**
	 * Sets the bt cost list local service.
	 *
	 * @param btCostListLocalService the bt cost list local service
	 */
	public void setBtCostListLocalService(
		com.business.trip.service.BtCostListLocalService btCostListLocalService) {
		this.btCostListLocalService = btCostListLocalService;
	}

	/**
	 * Returns the bt cost list persistence.
	 *
	 * @return the bt cost list persistence
	 */
	public BtCostListPersistence getBtCostListPersistence() {
		return btCostListPersistence;
	}

	/**
	 * Sets the bt cost list persistence.
	 *
	 * @param btCostListPersistence the bt cost list persistence
	 */
	public void setBtCostListPersistence(
		BtCostListPersistence btCostListPersistence) {
		this.btCostListPersistence = btCostListPersistence;
	}

	/**
	 * Returns the bt entertainment detail local service.
	 *
	 * @return the bt entertainment detail local service
	 */
	public com.business.trip.service.BtEntertainmentDetailLocalService getBtEntertainmentDetailLocalService() {
		return btEntertainmentDetailLocalService;
	}

	/**
	 * Sets the bt entertainment detail local service.
	 *
	 * @param btEntertainmentDetailLocalService the bt entertainment detail local service
	 */
	public void setBtEntertainmentDetailLocalService(
		com.business.trip.service.BtEntertainmentDetailLocalService btEntertainmentDetailLocalService) {
		this.btEntertainmentDetailLocalService = btEntertainmentDetailLocalService;
	}

	/**
	 * Returns the bt entertainment detail persistence.
	 *
	 * @return the bt entertainment detail persistence
	 */
	public BtEntertainmentDetailPersistence getBtEntertainmentDetailPersistence() {
		return btEntertainmentDetailPersistence;
	}

	/**
	 * Sets the bt entertainment detail persistence.
	 *
	 * @param btEntertainmentDetailPersistence the bt entertainment detail persistence
	 */
	public void setBtEntertainmentDetailPersistence(
		BtEntertainmentDetailPersistence btEntertainmentDetailPersistence) {
		this.btEntertainmentDetailPersistence = btEntertainmentDetailPersistence;
	}

	/**
	 * Returns the bt exchange rate local service.
	 *
	 * @return the bt exchange rate local service
	 */
	public com.business.trip.service.BtExchangeRateLocalService getBtExchangeRateLocalService() {
		return btExchangeRateLocalService;
	}

	/**
	 * Sets the bt exchange rate local service.
	 *
	 * @param btExchangeRateLocalService the bt exchange rate local service
	 */
	public void setBtExchangeRateLocalService(
		com.business.trip.service.BtExchangeRateLocalService btExchangeRateLocalService) {
		this.btExchangeRateLocalService = btExchangeRateLocalService;
	}

	/**
	 * Returns the bt exchange rate persistence.
	 *
	 * @return the bt exchange rate persistence
	 */
	public BtExchangeRatePersistence getBtExchangeRatePersistence() {
		return btExchangeRatePersistence;
	}

	/**
	 * Sets the bt exchange rate persistence.
	 *
	 * @param btExchangeRatePersistence the bt exchange rate persistence
	 */
	public void setBtExchangeRatePersistence(
		BtExchangeRatePersistence btExchangeRatePersistence) {
		this.btExchangeRatePersistence = btExchangeRatePersistence;
	}

	/**
	 * Returns the bt exchange s a p rate local service.
	 *
	 * @return the bt exchange s a p rate local service
	 */
	public com.business.trip.service.BtExchangeSAPRateLocalService getBtExchangeSAPRateLocalService() {
		return btExchangeSAPRateLocalService;
	}

	/**
	 * Sets the bt exchange s a p rate local service.
	 *
	 * @param btExchangeSAPRateLocalService the bt exchange s a p rate local service
	 */
	public void setBtExchangeSAPRateLocalService(
		com.business.trip.service.BtExchangeSAPRateLocalService btExchangeSAPRateLocalService) {
		this.btExchangeSAPRateLocalService = btExchangeSAPRateLocalService;
	}

	/**
	 * Returns the bt exchange s a p rate persistence.
	 *
	 * @return the bt exchange s a p rate persistence
	 */
	public BtExchangeSAPRatePersistence getBtExchangeSAPRatePersistence() {
		return btExchangeSAPRatePersistence;
	}

	/**
	 * Sets the bt exchange s a p rate persistence.
	 *
	 * @param btExchangeSAPRatePersistence the bt exchange s a p rate persistence
	 */
	public void setBtExchangeSAPRatePersistence(
		BtExchangeSAPRatePersistence btExchangeSAPRatePersistence) {
		this.btExchangeSAPRatePersistence = btExchangeSAPRatePersistence;
	}

	/**
	 * Returns the bt flight train info local service.
	 *
	 * @return the bt flight train info local service
	 */
	public com.business.trip.service.BtFlightTrainInfoLocalService getBtFlightTrainInfoLocalService() {
		return btFlightTrainInfoLocalService;
	}

	/**
	 * Sets the bt flight train info local service.
	 *
	 * @param btFlightTrainInfoLocalService the bt flight train info local service
	 */
	public void setBtFlightTrainInfoLocalService(
		com.business.trip.service.BtFlightTrainInfoLocalService btFlightTrainInfoLocalService) {
		this.btFlightTrainInfoLocalService = btFlightTrainInfoLocalService;
	}

	/**
	 * Returns the bt flight train info persistence.
	 *
	 * @return the bt flight train info persistence
	 */
	public BtFlightTrainInfoPersistence getBtFlightTrainInfoPersistence() {
		return btFlightTrainInfoPersistence;
	}

	/**
	 * Sets the bt flight train info persistence.
	 *
	 * @param btFlightTrainInfoPersistence the bt flight train info persistence
	 */
	public void setBtFlightTrainInfoPersistence(
		BtFlightTrainInfoPersistence btFlightTrainInfoPersistence) {
		this.btFlightTrainInfoPersistence = btFlightTrainInfoPersistence;
	}

	/**
	 * Returns the bt hotel info local service.
	 *
	 * @return the bt hotel info local service
	 */
	public com.business.trip.service.BtHotelInfoLocalService getBtHotelInfoLocalService() {
		return btHotelInfoLocalService;
	}

	/**
	 * Sets the bt hotel info local service.
	 *
	 * @param btHotelInfoLocalService the bt hotel info local service
	 */
	public void setBtHotelInfoLocalService(
		com.business.trip.service.BtHotelInfoLocalService btHotelInfoLocalService) {
		this.btHotelInfoLocalService = btHotelInfoLocalService;
	}

	/**
	 * Returns the bt hotel info persistence.
	 *
	 * @return the bt hotel info persistence
	 */
	public BtHotelInfoPersistence getBtHotelInfoPersistence() {
		return btHotelInfoPersistence;
	}

	/**
	 * Sets the bt hotel info persistence.
	 *
	 * @param btHotelInfoPersistence the bt hotel info persistence
	 */
	public void setBtHotelInfoPersistence(
		BtHotelInfoPersistence btHotelInfoPersistence) {
		this.btHotelInfoPersistence = btHotelInfoPersistence;
	}

	/**
	 * Returns the bt reimbursement s a p info local service.
	 *
	 * @return the bt reimbursement s a p info local service
	 */
	public com.business.trip.service.BtReimbursementSAPInfoLocalService getBtReimbursementSAPInfoLocalService() {
		return btReimbursementSAPInfoLocalService;
	}

	/**
	 * Sets the bt reimbursement s a p info local service.
	 *
	 * @param btReimbursementSAPInfoLocalService the bt reimbursement s a p info local service
	 */
	public void setBtReimbursementSAPInfoLocalService(
		com.business.trip.service.BtReimbursementSAPInfoLocalService btReimbursementSAPInfoLocalService) {
		this.btReimbursementSAPInfoLocalService = btReimbursementSAPInfoLocalService;
	}

	/**
	 * Returns the bt reimbursement s a p info persistence.
	 *
	 * @return the bt reimbursement s a p info persistence
	 */
	public BtReimbursementSAPInfoPersistence getBtReimbursementSAPInfoPersistence() {
		return btReimbursementSAPInfoPersistence;
	}

	/**
	 * Sets the bt reimbursement s a p info persistence.
	 *
	 * @param btReimbursementSAPInfoPersistence the bt reimbursement s a p info persistence
	 */
	public void setBtReimbursementSAPInfoPersistence(
		BtReimbursementSAPInfoPersistence btReimbursementSAPInfoPersistence) {
		this.btReimbursementSAPInfoPersistence = btReimbursementSAPInfoPersistence;
	}

	/**
	 * Returns the bt train info local service.
	 *
	 * @return the bt train info local service
	 */
	public com.business.trip.service.BtTrainInfoLocalService getBtTrainInfoLocalService() {
		return btTrainInfoLocalService;
	}

	/**
	 * Sets the bt train info local service.
	 *
	 * @param btTrainInfoLocalService the bt train info local service
	 */
	public void setBtTrainInfoLocalService(
		com.business.trip.service.BtTrainInfoLocalService btTrainInfoLocalService) {
		this.btTrainInfoLocalService = btTrainInfoLocalService;
	}

	/**
	 * Returns the bt train info persistence.
	 *
	 * @return the bt train info persistence
	 */
	public BtTrainInfoPersistence getBtTrainInfoPersistence() {
		return btTrainInfoPersistence;
	}

	/**
	 * Sets the bt train info persistence.
	 *
	 * @param btTrainInfoPersistence the bt train info persistence
	 */
	public void setBtTrainInfoPersistence(
		BtTrainInfoPersistence btTrainInfoPersistence) {
		this.btTrainInfoPersistence = btTrainInfoPersistence;
	}

	/**
	 * Returns the bt travel expense local service.
	 *
	 * @return the bt travel expense local service
	 */
	public com.business.trip.service.BtTravelExpenseLocalService getBtTravelExpenseLocalService() {
		return btTravelExpenseLocalService;
	}

	/**
	 * Sets the bt travel expense local service.
	 *
	 * @param btTravelExpenseLocalService the bt travel expense local service
	 */
	public void setBtTravelExpenseLocalService(
		com.business.trip.service.BtTravelExpenseLocalService btTravelExpenseLocalService) {
		this.btTravelExpenseLocalService = btTravelExpenseLocalService;
	}

	/**
	 * Returns the bt travel expense persistence.
	 *
	 * @return the bt travel expense persistence
	 */
	public BtTravelExpensePersistence getBtTravelExpensePersistence() {
		return btTravelExpensePersistence;
	}

	/**
	 * Sets the bt travel expense persistence.
	 *
	 * @param btTravelExpensePersistence the bt travel expense persistence
	 */
	public void setBtTravelExpensePersistence(
		BtTravelExpensePersistence btTravelExpensePersistence) {
		this.btTravelExpensePersistence = btTravelExpensePersistence;
	}

	/**
	 * Returns the business trip application local service.
	 *
	 * @return the business trip application local service
	 */
	public com.business.trip.service.BusinessTripApplicationLocalService getBusinessTripApplicationLocalService() {
		return businessTripApplicationLocalService;
	}

	/**
	 * Sets the business trip application local service.
	 *
	 * @param businessTripApplicationLocalService the business trip application local service
	 */
	public void setBusinessTripApplicationLocalService(
		com.business.trip.service.BusinessTripApplicationLocalService businessTripApplicationLocalService) {
		this.businessTripApplicationLocalService = businessTripApplicationLocalService;
	}

	/**
	 * Returns the business trip application persistence.
	 *
	 * @return the business trip application persistence
	 */
	public BusinessTripApplicationPersistence getBusinessTripApplicationPersistence() {
		return businessTripApplicationPersistence;
	}

	/**
	 * Sets the business trip application persistence.
	 *
	 * @param businessTripApplicationPersistence the business trip application persistence
	 */
	public void setBusinessTripApplicationPersistence(
		BusinessTripApplicationPersistence businessTripApplicationPersistence) {
		this.businessTripApplicationPersistence = businessTripApplicationPersistence;
	}

	/**
	 * Returns the business trip reimbursement local service.
	 *
	 * @return the business trip reimbursement local service
	 */
	public com.business.trip.service.BusinessTripReimbursementLocalService getBusinessTripReimbursementLocalService() {
		return businessTripReimbursementLocalService;
	}

	/**
	 * Sets the business trip reimbursement local service.
	 *
	 * @param businessTripReimbursementLocalService the business trip reimbursement local service
	 */
	public void setBusinessTripReimbursementLocalService(
		com.business.trip.service.BusinessTripReimbursementLocalService businessTripReimbursementLocalService) {
		this.businessTripReimbursementLocalService = businessTripReimbursementLocalService;
	}

	/**
	 * Returns the business trip reimbursement persistence.
	 *
	 * @return the business trip reimbursement persistence
	 */
	public BusinessTripReimbursementPersistence getBusinessTripReimbursementPersistence() {
		return businessTripReimbursementPersistence;
	}

	/**
	 * Sets the business trip reimbursement persistence.
	 *
	 * @param businessTripReimbursementPersistence the business trip reimbursement persistence
	 */
	public void setBusinessTripReimbursementPersistence(
		BusinessTripReimbursementPersistence businessTripReimbursementPersistence) {
		this.businessTripReimbursementPersistence = businessTripReimbursementPersistence;
	}

	/**
	 * Returns the rate city local service.
	 *
	 * @return the rate city local service
	 */
	public com.business.trip.service.RateCityLocalService getRateCityLocalService() {
		return rateCityLocalService;
	}

	/**
	 * Sets the rate city local service.
	 *
	 * @param rateCityLocalService the rate city local service
	 */
	public void setRateCityLocalService(
		com.business.trip.service.RateCityLocalService rateCityLocalService) {
		this.rateCityLocalService = rateCityLocalService;
	}

	/**
	 * Returns the rate city persistence.
	 *
	 * @return the rate city persistence
	 */
	public RateCityPersistence getRateCityPersistence() {
		return rateCityPersistence;
	}

	/**
	 * Sets the rate city persistence.
	 *
	 * @param rateCityPersistence the rate city persistence
	 */
	public void setRateCityPersistence(RateCityPersistence rateCityPersistence) {
		this.rateCityPersistence = rateCityPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.business.trip.model.BtCostList",
			btCostListLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.business.trip.model.BtCostList");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return BtCostList.class;
	}

	protected String getModelClassName() {
		return BtCostList.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = btCostListPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.business.trip.service.BtCarRentalInfoLocalService.class)
	protected com.business.trip.service.BtCarRentalInfoLocalService btCarRentalInfoLocalService;
	@BeanReference(type = BtCarRentalInfoPersistence.class)
	protected BtCarRentalInfoPersistence btCarRentalInfoPersistence;
	@BeanReference(type = com.business.trip.service.BtCostListLocalService.class)
	protected com.business.trip.service.BtCostListLocalService btCostListLocalService;
	@BeanReference(type = BtCostListPersistence.class)
	protected BtCostListPersistence btCostListPersistence;
	@BeanReference(type = com.business.trip.service.BtEntertainmentDetailLocalService.class)
	protected com.business.trip.service.BtEntertainmentDetailLocalService btEntertainmentDetailLocalService;
	@BeanReference(type = BtEntertainmentDetailPersistence.class)
	protected BtEntertainmentDetailPersistence btEntertainmentDetailPersistence;
	@BeanReference(type = com.business.trip.service.BtExchangeRateLocalService.class)
	protected com.business.trip.service.BtExchangeRateLocalService btExchangeRateLocalService;
	@BeanReference(type = BtExchangeRatePersistence.class)
	protected BtExchangeRatePersistence btExchangeRatePersistence;
	@BeanReference(type = com.business.trip.service.BtExchangeSAPRateLocalService.class)
	protected com.business.trip.service.BtExchangeSAPRateLocalService btExchangeSAPRateLocalService;
	@BeanReference(type = BtExchangeSAPRatePersistence.class)
	protected BtExchangeSAPRatePersistence btExchangeSAPRatePersistence;
	@BeanReference(type = com.business.trip.service.BtFlightTrainInfoLocalService.class)
	protected com.business.trip.service.BtFlightTrainInfoLocalService btFlightTrainInfoLocalService;
	@BeanReference(type = BtFlightTrainInfoPersistence.class)
	protected BtFlightTrainInfoPersistence btFlightTrainInfoPersistence;
	@BeanReference(type = com.business.trip.service.BtHotelInfoLocalService.class)
	protected com.business.trip.service.BtHotelInfoLocalService btHotelInfoLocalService;
	@BeanReference(type = BtHotelInfoPersistence.class)
	protected BtHotelInfoPersistence btHotelInfoPersistence;
	@BeanReference(type = com.business.trip.service.BtReimbursementSAPInfoLocalService.class)
	protected com.business.trip.service.BtReimbursementSAPInfoLocalService btReimbursementSAPInfoLocalService;
	@BeanReference(type = BtReimbursementSAPInfoPersistence.class)
	protected BtReimbursementSAPInfoPersistence btReimbursementSAPInfoPersistence;
	@BeanReference(type = com.business.trip.service.BtTrainInfoLocalService.class)
	protected com.business.trip.service.BtTrainInfoLocalService btTrainInfoLocalService;
	@BeanReference(type = BtTrainInfoPersistence.class)
	protected BtTrainInfoPersistence btTrainInfoPersistence;
	@BeanReference(type = com.business.trip.service.BtTravelExpenseLocalService.class)
	protected com.business.trip.service.BtTravelExpenseLocalService btTravelExpenseLocalService;
	@BeanReference(type = BtTravelExpensePersistence.class)
	protected BtTravelExpensePersistence btTravelExpensePersistence;
	@BeanReference(type = com.business.trip.service.BusinessTripApplicationLocalService.class)
	protected com.business.trip.service.BusinessTripApplicationLocalService businessTripApplicationLocalService;
	@BeanReference(type = BusinessTripApplicationPersistence.class)
	protected BusinessTripApplicationPersistence businessTripApplicationPersistence;
	@BeanReference(type = com.business.trip.service.BusinessTripReimbursementLocalService.class)
	protected com.business.trip.service.BusinessTripReimbursementLocalService businessTripReimbursementLocalService;
	@BeanReference(type = BusinessTripReimbursementPersistence.class)
	protected BusinessTripReimbursementPersistence businessTripReimbursementPersistence;
	@BeanReference(type = com.business.trip.service.RateCityLocalService.class)
	protected com.business.trip.service.RateCityLocalService rateCityLocalService;
	@BeanReference(type = RateCityPersistence.class)
	protected RateCityPersistence rateCityPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private BtCostListLocalServiceClpInvoker _clpInvoker = new BtCostListLocalServiceClpInvoker();
}