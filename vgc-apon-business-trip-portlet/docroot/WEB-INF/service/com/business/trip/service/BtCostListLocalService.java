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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for BtCostList. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see BtCostListLocalServiceUtil
 * @see com.business.trip.service.base.BtCostListLocalServiceBaseImpl
 * @see com.business.trip.service.impl.BtCostListLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface BtCostListLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BtCostListLocalServiceUtil} to access the bt cost list local service. Add custom service methods to {@link com.business.trip.service.impl.BtCostListLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the bt cost list to the database. Also notifies the appropriate model listeners.
	*
	* @param btCostList the bt cost list
	* @return the bt cost list that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.business.trip.model.BtCostList addBtCostList(
		com.business.trip.model.BtCostList btCostList)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new bt cost list with the primary key. Does not add the bt cost list to the database.
	*
	* @param btCostListId the primary key for the new bt cost list
	* @return the new bt cost list
	*/
	public com.business.trip.model.BtCostList createBtCostList(
		long btCostListId);

	/**
	* Deletes the bt cost list with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btCostListId the primary key of the bt cost list
	* @return the bt cost list that was removed
	* @throws PortalException if a bt cost list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.business.trip.model.BtCostList deleteBtCostList(
		long btCostListId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the bt cost list from the database. Also notifies the appropriate model listeners.
	*
	* @param btCostList the bt cost list
	* @return the bt cost list that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.business.trip.model.BtCostList deleteBtCostList(
		com.business.trip.model.BtCostList btCostList)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.business.trip.model.BtCostList fetchBtCostList(long btCostListId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt cost list with the primary key.
	*
	* @param btCostListId the primary key of the bt cost list
	* @return the bt cost list
	* @throws PortalException if a bt cost list with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.business.trip.model.BtCostList getBtCostList(long btCostListId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.business.trip.model.BtCostList> getBtCostLists(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bt cost lists.
	*
	* @return the number of bt cost lists
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getBtCostListsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the bt cost list in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param btCostList the bt cost list
	* @return the bt cost list that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.business.trip.model.BtCostList updateBtCostList(
		com.business.trip.model.BtCostList btCostList)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public int findCountByBusinessTripPkId(long businessTripPkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.business.trip.model.BtCostList> findByBusinessTripPkId(
		long businessTripPkId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.business.trip.model.BtCostList> findByB_C(
		long businessTripPkId, java.lang.String paymentCurrency)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.lang.Double findSumByCurrency(long businessTripPkId,
		java.lang.String paymentCurrency, java.util.List<java.lang.String> items)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.lang.Double findSumEntertainmentByCurrency(
		long businessTripPkId, java.lang.String paymentCurrency,
		java.util.List<java.lang.String> items)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.lang.Double findSumInvoiceAmountByCurrency(
		long businessTripPkId, java.lang.String paymentCurrency)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.lang.Double findEURPayByRMBByCurrency(long businessTripPkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.lang.Double findSumNetAmountRmbByCurrency(
		long businessTripPkId, java.lang.String paymentCurrency,
		java.util.List<java.lang.String> items)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.lang.Double findSumTaxByCurrency(long businessTripPkId,
		java.lang.String paymentCurrency, java.util.List<java.lang.String> items)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isEntertainmentCondition(long businessTripPkId, int type)
		throws com.liferay.portal.kernel.exception.SystemException;

	public double addCalculate(double oldTotal, java.lang.String totalCurrency,
		double amount, java.lang.String currency)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* To corrected the history data  cost list netAmountRMB value
	*
	* @param businessTripReimbursementId
	* @throws SystemException
	*/
	public void correctAmountRmbCostListOfHistoryData(
		long businessTripReimbursementId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Delete all cost list by bussiness trip pk id
	*
	* @param businessTripReimbursementId
	* @throws SystemException
	*/
	public void deleteCostListByBRPKId(long businessTripReimbursementId)
		throws com.liferay.portal.kernel.exception.SystemException;
}