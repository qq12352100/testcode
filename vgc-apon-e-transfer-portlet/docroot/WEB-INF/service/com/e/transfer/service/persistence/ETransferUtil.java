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

package com.e.transfer.service.persistence;

import com.e.transfer.model.ETransfer;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the e transfer service. This utility wraps {@link ETransferPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EZEYIFE
 * @see ETransferPersistence
 * @see ETransferPersistenceImpl
 * @generated
 */
public class ETransferUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ETransfer eTransfer) {
		getPersistence().clearCache(eTransfer);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ETransfer> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ETransfer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ETransfer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ETransfer update(ETransfer eTransfer)
		throws SystemException {
		return getPersistence().update(eTransfer);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ETransfer update(ETransfer eTransfer,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(eTransfer, serviceContext);
	}

	/**
	* Returns all the e transfers where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the matching e transfers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.transfer.model.ETransfer> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_U(status, userId);
	}

	/**
	* Returns a range of all the e transfers where status = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.transfer.model.impl.ETransferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param userId the user ID
	* @param start the lower bound of the range of e transfers
	* @param end the upper bound of the range of e transfers (not inclusive)
	* @return the range of matching e transfers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.transfer.model.ETransfer> findByS_U(
		int status, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_U(status, userId, start, end);
	}

	/**
	* Returns an ordered range of all the e transfers where status = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.transfer.model.impl.ETransferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param userId the user ID
	* @param start the lower bound of the range of e transfers
	* @param end the upper bound of the range of e transfers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching e transfers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.transfer.model.ETransfer> findByS_U(
		int status, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_U(status, userId, start, end, orderByComparator);
	}

	/**
	* Returns the first e transfer in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e transfer
	* @throws com.e.transfer.NoSuchETransferException if a matching e transfer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.transfer.model.ETransfer findByS_U_First(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.transfer.NoSuchETransferException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_U_First(status, userId, orderByComparator);
	}

	/**
	* Returns the first e transfer in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e transfer, or <code>null</code> if a matching e transfer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.transfer.model.ETransfer fetchByS_U_First(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_U_First(status, userId, orderByComparator);
	}

	/**
	* Returns the last e transfer in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e transfer
	* @throws com.e.transfer.NoSuchETransferException if a matching e transfer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.transfer.model.ETransfer findByS_U_Last(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.transfer.NoSuchETransferException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_U_Last(status, userId, orderByComparator);
	}

	/**
	* Returns the last e transfer in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e transfer, or <code>null</code> if a matching e transfer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.transfer.model.ETransfer fetchByS_U_Last(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_U_Last(status, userId, orderByComparator);
	}

	/**
	* Returns the e transfers before and after the current e transfer in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param eTransferId the primary key of the current e transfer
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next e transfer
	* @throws com.e.transfer.NoSuchETransferException if a e transfer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.transfer.model.ETransfer[] findByS_U_PrevAndNext(
		long eTransferId, int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.transfer.NoSuchETransferException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_U_PrevAndNext(eTransferId, status, userId,
			orderByComparator);
	}

	/**
	* Removes all the e transfers where status = &#63; and userId = &#63; from the database.
	*
	* @param status the status
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByS_U(int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByS_U(status, userId);
	}

	/**
	* Returns the number of e transfers where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the number of matching e transfers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByS_U(int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByS_U(status, userId);
	}

	/**
	* Caches the e transfer in the entity cache if it is enabled.
	*
	* @param eTransfer the e transfer
	*/
	public static void cacheResult(com.e.transfer.model.ETransfer eTransfer) {
		getPersistence().cacheResult(eTransfer);
	}

	/**
	* Caches the e transfers in the entity cache if it is enabled.
	*
	* @param eTransfers the e transfers
	*/
	public static void cacheResult(
		java.util.List<com.e.transfer.model.ETransfer> eTransfers) {
		getPersistence().cacheResult(eTransfers);
	}

	/**
	* Creates a new e transfer with the primary key. Does not add the e transfer to the database.
	*
	* @param eTransferId the primary key for the new e transfer
	* @return the new e transfer
	*/
	public static com.e.transfer.model.ETransfer create(long eTransferId) {
		return getPersistence().create(eTransferId);
	}

	/**
	* Removes the e transfer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eTransferId the primary key of the e transfer
	* @return the e transfer that was removed
	* @throws com.e.transfer.NoSuchETransferException if a e transfer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.transfer.model.ETransfer remove(long eTransferId)
		throws com.e.transfer.NoSuchETransferException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(eTransferId);
	}

	public static com.e.transfer.model.ETransfer updateImpl(
		com.e.transfer.model.ETransfer eTransfer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(eTransfer);
	}

	/**
	* Returns the e transfer with the primary key or throws a {@link com.e.transfer.NoSuchETransferException} if it could not be found.
	*
	* @param eTransferId the primary key of the e transfer
	* @return the e transfer
	* @throws com.e.transfer.NoSuchETransferException if a e transfer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.transfer.model.ETransfer findByPrimaryKey(
		long eTransferId)
		throws com.e.transfer.NoSuchETransferException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(eTransferId);
	}

	/**
	* Returns the e transfer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eTransferId the primary key of the e transfer
	* @return the e transfer, or <code>null</code> if a e transfer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.transfer.model.ETransfer fetchByPrimaryKey(
		long eTransferId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(eTransferId);
	}

	/**
	* Returns all the e transfers.
	*
	* @return the e transfers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.transfer.model.ETransfer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the e transfers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.transfer.model.impl.ETransferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e transfers
	* @param end the upper bound of the range of e transfers (not inclusive)
	* @return the range of e transfers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.transfer.model.ETransfer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the e transfers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.transfer.model.impl.ETransferModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of e transfers
	* @param end the upper bound of the range of e transfers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of e transfers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.transfer.model.ETransfer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the e transfers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of e transfers.
	*
	* @return the number of e transfers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ETransferPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ETransferPersistence)PortletBeanLocatorUtil.locate(com.e.transfer.service.ClpSerializer.getServletContextName(),
					ETransferPersistence.class.getName());

			ReferenceRegistry.registerReference(ETransferUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ETransferPersistence persistence) {
	}

	private static ETransferPersistence _persistence;
}