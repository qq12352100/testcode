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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the e transfer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EZEYIFE
 * @see ETransferPersistenceImpl
 * @see ETransferUtil
 * @generated
 */
public interface ETransferPersistence extends BasePersistence<ETransfer> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ETransferUtil} to access the e transfer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the e transfers where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the matching e transfers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.e.transfer.model.ETransfer> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.e.transfer.model.ETransfer> findByS_U(
		int status, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.e.transfer.model.ETransfer> findByS_U(
		int status, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.e.transfer.model.ETransfer findByS_U_First(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.transfer.NoSuchETransferException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first e transfer in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching e transfer, or <code>null</code> if a matching e transfer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.transfer.model.ETransfer fetchByS_U_First(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.e.transfer.model.ETransfer findByS_U_Last(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.transfer.NoSuchETransferException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last e transfer in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching e transfer, or <code>null</code> if a matching e transfer could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.transfer.model.ETransfer fetchByS_U_Last(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.e.transfer.model.ETransfer[] findByS_U_PrevAndNext(
		long eTransferId, int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.e.transfer.NoSuchETransferException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e transfers where status = &#63; and userId = &#63; from the database.
	*
	* @param status the status
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByS_U(int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e transfers where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the number of matching e transfers
	* @throws SystemException if a system exception occurred
	*/
	public int countByS_U(int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the e transfer in the entity cache if it is enabled.
	*
	* @param eTransfer the e transfer
	*/
	public void cacheResult(com.e.transfer.model.ETransfer eTransfer);

	/**
	* Caches the e transfers in the entity cache if it is enabled.
	*
	* @param eTransfers the e transfers
	*/
	public void cacheResult(
		java.util.List<com.e.transfer.model.ETransfer> eTransfers);

	/**
	* Creates a new e transfer with the primary key. Does not add the e transfer to the database.
	*
	* @param eTransferId the primary key for the new e transfer
	* @return the new e transfer
	*/
	public com.e.transfer.model.ETransfer create(long eTransferId);

	/**
	* Removes the e transfer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eTransferId the primary key of the e transfer
	* @return the e transfer that was removed
	* @throws com.e.transfer.NoSuchETransferException if a e transfer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.transfer.model.ETransfer remove(long eTransferId)
		throws com.e.transfer.NoSuchETransferException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.e.transfer.model.ETransfer updateImpl(
		com.e.transfer.model.ETransfer eTransfer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e transfer with the primary key or throws a {@link com.e.transfer.NoSuchETransferException} if it could not be found.
	*
	* @param eTransferId the primary key of the e transfer
	* @return the e transfer
	* @throws com.e.transfer.NoSuchETransferException if a e transfer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.transfer.model.ETransfer findByPrimaryKey(long eTransferId)
		throws com.e.transfer.NoSuchETransferException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the e transfer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eTransferId the primary key of the e transfer
	* @return the e transfer, or <code>null</code> if a e transfer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.e.transfer.model.ETransfer fetchByPrimaryKey(long eTransferId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the e transfers.
	*
	* @return the e transfers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.e.transfer.model.ETransfer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.e.transfer.model.ETransfer> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.e.transfer.model.ETransfer> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the e transfers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of e transfers.
	*
	* @return the number of e transfers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}