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
 * Provides the local service interface for BtReimbursementSAPInfo. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see BtReimbursementSAPInfoLocalServiceUtil
 * @see com.business.trip.service.base.BtReimbursementSAPInfoLocalServiceBaseImpl
 * @see com.business.trip.service.impl.BtReimbursementSAPInfoLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface BtReimbursementSAPInfoLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BtReimbursementSAPInfoLocalServiceUtil} to access the bt reimbursement s a p info local service. Add custom service methods to {@link com.business.trip.service.impl.BtReimbursementSAPInfoLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the bt reimbursement s a p info to the database. Also notifies the appropriate model listeners.
	*
	* @param btReimbursementSAPInfo the bt reimbursement s a p info
	* @return the bt reimbursement s a p info that was added
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.business.trip.model.BtReimbursementSAPInfo addBtReimbursementSAPInfo(
		com.business.trip.model.BtReimbursementSAPInfo btReimbursementSAPInfo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new bt reimbursement s a p info with the primary key. Does not add the bt reimbursement s a p info to the database.
	*
	* @param btReimbursementSAPInfoId the primary key for the new bt reimbursement s a p info
	* @return the new bt reimbursement s a p info
	*/
	public com.business.trip.model.BtReimbursementSAPInfo createBtReimbursementSAPInfo(
		long btReimbursementSAPInfoId);

	/**
	* Deletes the bt reimbursement s a p info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param btReimbursementSAPInfoId the primary key of the bt reimbursement s a p info
	* @return the bt reimbursement s a p info that was removed
	* @throws PortalException if a bt reimbursement s a p info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.business.trip.model.BtReimbursementSAPInfo deleteBtReimbursementSAPInfo(
		long btReimbursementSAPInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the bt reimbursement s a p info from the database. Also notifies the appropriate model listeners.
	*
	* @param btReimbursementSAPInfo the bt reimbursement s a p info
	* @return the bt reimbursement s a p info that was removed
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.DELETE)
	public com.business.trip.model.BtReimbursementSAPInfo deleteBtReimbursementSAPInfo(
		com.business.trip.model.BtReimbursementSAPInfo btReimbursementSAPInfo)
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtReimbursementSAPInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public com.business.trip.model.BtReimbursementSAPInfo fetchBtReimbursementSAPInfo(
		long btReimbursementSAPInfoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the bt reimbursement s a p info with the primary key.
	*
	* @param btReimbursementSAPInfoId the primary key of the bt reimbursement s a p info
	* @return the bt reimbursement s a p info
	* @throws PortalException if a bt reimbursement s a p info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.business.trip.model.BtReimbursementSAPInfo getBtReimbursementSAPInfo(
		long btReimbursementSAPInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.business.trip.model.BtReimbursementSAPInfo> getBtReimbursementSAPInfos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of bt reimbursement s a p infos.
	*
	* @return the number of bt reimbursement s a p infos
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getBtReimbursementSAPInfosCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the bt reimbursement s a p info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param btReimbursementSAPInfo the bt reimbursement s a p info
	* @return the bt reimbursement s a p info that was updated
	* @throws SystemException if a system exception occurred
	*/
	@com.liferay.portal.kernel.search.Indexable(type = IndexableType.REINDEX)
	public com.business.trip.model.BtReimbursementSAPInfo updateBtReimbursementSAPInfo(
		com.business.trip.model.BtReimbursementSAPInfo btReimbursementSAPInfo)
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

	public com.business.trip.model.BtReimbursementSAPInfo saveOrUpdateBtReimbursementSAPInfo(
		com.business.trip.model.BtReimbursementSAPInfo btReimbursementSAPInfo)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.business.trip.model.BtReimbursementSAPInfo fetchByB_C(
		java.lang.String currency, long businessTripPkId)
		throws com.liferay.portal.kernel.exception.SystemException;
}