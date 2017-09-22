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

import com.e.transfer.NoSuchETransferException;
import com.e.transfer.model.ETransfer;
import com.e.transfer.model.impl.ETransferImpl;
import com.e.transfer.model.impl.ETransferModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the e transfer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EZEYIFE
 * @see ETransferPersistence
 * @see ETransferUtil
 * @generated
 */
public class ETransferPersistenceImpl extends BasePersistenceImpl<ETransfer>
	implements ETransferPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ETransferUtil} to access the e transfer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ETransferImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ETransferModelImpl.ENTITY_CACHE_ENABLED,
			ETransferModelImpl.FINDER_CACHE_ENABLED, ETransferImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ETransferModelImpl.ENTITY_CACHE_ENABLED,
			ETransferModelImpl.FINDER_CACHE_ENABLED, ETransferImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ETransferModelImpl.ENTITY_CACHE_ENABLED,
			ETransferModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_S_U = new FinderPath(ETransferModelImpl.ENTITY_CACHE_ENABLED,
			ETransferModelImpl.FINDER_CACHE_ENABLED, ETransferImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByS_U",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U = new FinderPath(ETransferModelImpl.ENTITY_CACHE_ENABLED,
			ETransferModelImpl.FINDER_CACHE_ENABLED, ETransferImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_U",
			new String[] { Integer.class.getName(), Long.class.getName() },
			ETransferModelImpl.STATUS_COLUMN_BITMASK |
			ETransferModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_S_U = new FinderPath(ETransferModelImpl.ENTITY_CACHE_ENABLED,
			ETransferModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_U",
			new String[] { Integer.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e transfers where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @return the matching e transfers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ETransfer> findByS_U(int status, long userId)
		throws SystemException {
		return findByS_U(status, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<ETransfer> findByS_U(int status, long userId, int start, int end)
		throws SystemException {
		return findByS_U(status, userId, start, end, null);
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
	@Override
	public List<ETransfer> findByS_U(int status, long userId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U;
			finderArgs = new Object[] { status, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_S_U;
			finderArgs = new Object[] {
					status, userId,
					
					start, end, orderByComparator
				};
		}

		List<ETransfer> list = (List<ETransfer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ETransfer eTransfer : list) {
				if ((status != eTransfer.getStatus()) ||
						(userId != eTransfer.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ETRANSFER_WHERE);

			query.append(_FINDER_COLUMN_S_U_STATUS_2);

			query.append(_FINDER_COLUMN_S_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ETransferModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				qPos.add(userId);

				if (!pagination) {
					list = (List<ETransfer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ETransfer>(list);
				}
				else {
					list = (List<ETransfer>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public ETransfer findByS_U_First(int status, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchETransferException, SystemException {
		ETransfer eTransfer = fetchByS_U_First(status, userId, orderByComparator);

		if (eTransfer != null) {
			return eTransfer;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchETransferException(msg.toString());
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
	@Override
	public ETransfer fetchByS_U_First(int status, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ETransfer> list = findByS_U(status, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ETransfer findByS_U_Last(int status, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchETransferException, SystemException {
		ETransfer eTransfer = fetchByS_U_Last(status, userId, orderByComparator);

		if (eTransfer != null) {
			return eTransfer;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchETransferException(msg.toString());
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
	@Override
	public ETransfer fetchByS_U_Last(int status, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByS_U(status, userId);

		if (count == 0) {
			return null;
		}

		List<ETransfer> list = findByS_U(status, userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ETransfer[] findByS_U_PrevAndNext(long eTransferId, int status,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchETransferException, SystemException {
		ETransfer eTransfer = findByPrimaryKey(eTransferId);

		Session session = null;

		try {
			session = openSession();

			ETransfer[] array = new ETransferImpl[3];

			array[0] = getByS_U_PrevAndNext(session, eTransfer, status, userId,
					orderByComparator, true);

			array[1] = eTransfer;

			array[2] = getByS_U_PrevAndNext(session, eTransfer, status, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ETransfer getByS_U_PrevAndNext(Session session,
		ETransfer eTransfer, int status, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ETRANSFER_WHERE);

		query.append(_FINDER_COLUMN_S_U_STATUS_2);

		query.append(_FINDER_COLUMN_S_U_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ETransferModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eTransfer);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ETransfer> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e transfers where status = &#63; and userId = &#63; from the database.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByS_U(int status, long userId) throws SystemException {
		for (ETransfer eTransfer : findByS_U(status, userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(eTransfer);
		}
	}

	/**
	 * Returns the number of e transfers where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @return the number of matching e transfers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByS_U(int status, long userId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_S_U;

		Object[] finderArgs = new Object[] { status, userId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ETRANSFER_WHERE);

			query.append(_FINDER_COLUMN_S_U_STATUS_2);

			query.append(_FINDER_COLUMN_S_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_S_U_STATUS_2 = "eTransfer.status = ? AND ";
	private static final String _FINDER_COLUMN_S_U_USERID_2 = "eTransfer.userId = ?";

	public ETransferPersistenceImpl() {
		setModelClass(ETransfer.class);
	}

	/**
	 * Caches the e transfer in the entity cache if it is enabled.
	 *
	 * @param eTransfer the e transfer
	 */
	@Override
	public void cacheResult(ETransfer eTransfer) {
		EntityCacheUtil.putResult(ETransferModelImpl.ENTITY_CACHE_ENABLED,
			ETransferImpl.class, eTransfer.getPrimaryKey(), eTransfer);

		eTransfer.resetOriginalValues();
	}

	/**
	 * Caches the e transfers in the entity cache if it is enabled.
	 *
	 * @param eTransfers the e transfers
	 */
	@Override
	public void cacheResult(List<ETransfer> eTransfers) {
		for (ETransfer eTransfer : eTransfers) {
			if (EntityCacheUtil.getResult(
						ETransferModelImpl.ENTITY_CACHE_ENABLED,
						ETransferImpl.class, eTransfer.getPrimaryKey()) == null) {
				cacheResult(eTransfer);
			}
			else {
				eTransfer.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e transfers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ETransferImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ETransferImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e transfer.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ETransfer eTransfer) {
		EntityCacheUtil.removeResult(ETransferModelImpl.ENTITY_CACHE_ENABLED,
			ETransferImpl.class, eTransfer.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ETransfer> eTransfers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ETransfer eTransfer : eTransfers) {
			EntityCacheUtil.removeResult(ETransferModelImpl.ENTITY_CACHE_ENABLED,
				ETransferImpl.class, eTransfer.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e transfer with the primary key. Does not add the e transfer to the database.
	 *
	 * @param eTransferId the primary key for the new e transfer
	 * @return the new e transfer
	 */
	@Override
	public ETransfer create(long eTransferId) {
		ETransfer eTransfer = new ETransferImpl();

		eTransfer.setNew(true);
		eTransfer.setPrimaryKey(eTransferId);

		return eTransfer;
	}

	/**
	 * Removes the e transfer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eTransferId the primary key of the e transfer
	 * @return the e transfer that was removed
	 * @throws com.e.transfer.NoSuchETransferException if a e transfer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ETransfer remove(long eTransferId)
		throws NoSuchETransferException, SystemException {
		return remove((Serializable)eTransferId);
	}

	/**
	 * Removes the e transfer with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e transfer
	 * @return the e transfer that was removed
	 * @throws com.e.transfer.NoSuchETransferException if a e transfer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ETransfer remove(Serializable primaryKey)
		throws NoSuchETransferException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ETransfer eTransfer = (ETransfer)session.get(ETransferImpl.class,
					primaryKey);

			if (eTransfer == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchETransferException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(eTransfer);
		}
		catch (NoSuchETransferException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ETransfer removeImpl(ETransfer eTransfer)
		throws SystemException {
		eTransfer = toUnwrappedModel(eTransfer);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eTransfer)) {
				eTransfer = (ETransfer)session.get(ETransferImpl.class,
						eTransfer.getPrimaryKeyObj());
			}

			if (eTransfer != null) {
				session.delete(eTransfer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (eTransfer != null) {
			clearCache(eTransfer);
		}

		return eTransfer;
	}

	@Override
	public ETransfer updateImpl(com.e.transfer.model.ETransfer eTransfer)
		throws SystemException {
		eTransfer = toUnwrappedModel(eTransfer);

		boolean isNew = eTransfer.isNew();

		ETransferModelImpl eTransferModelImpl = (ETransferModelImpl)eTransfer;

		Session session = null;

		try {
			session = openSession();

			if (eTransfer.isNew()) {
				session.save(eTransfer);

				eTransfer.setNew(false);
			}
			else {
				session.merge(eTransfer);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ETransferModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((eTransferModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eTransferModelImpl.getOriginalStatus(),
						eTransferModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U,
					args);

				args = new Object[] {
						eTransferModelImpl.getStatus(),
						eTransferModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U,
					args);
			}
		}

		EntityCacheUtil.putResult(ETransferModelImpl.ENTITY_CACHE_ENABLED,
			ETransferImpl.class, eTransfer.getPrimaryKey(), eTransfer);

		return eTransfer;
	}

	protected ETransfer toUnwrappedModel(ETransfer eTransfer) {
		if (eTransfer instanceof ETransferImpl) {
			return eTransfer;
		}

		ETransferImpl eTransferImpl = new ETransferImpl();

		eTransferImpl.setNew(eTransfer.isNew());
		eTransferImpl.setPrimaryKey(eTransfer.getPrimaryKey());

		eTransferImpl.setETransferId(eTransfer.getETransferId());
		eTransferImpl.setGroupId(eTransfer.getGroupId());
		eTransferImpl.setUserId(eTransfer.getUserId());
		eTransferImpl.setUserName(eTransfer.getUserName());
		eTransferImpl.setCreateDate(eTransfer.getCreateDate());
		eTransferImpl.setModifiedDate(eTransfer.getModifiedDate());
		eTransferImpl.setCompanyId(eTransfer.getCompanyId());
		eTransferImpl.setTicketNo(eTransfer.getTicketNo());
		eTransferImpl.setStaffName(eTransfer.getStaffName());
		eTransferImpl.setCurrentStaffCode(eTransfer.getCurrentStaffCode());
		eTransferImpl.setContractType(eTransfer.getContractType());
		eTransferImpl.setNewStaffCode(eTransfer.getNewStaffCode());
		eTransferImpl.setPassedLL(eTransfer.getPassedLL());
		eTransferImpl.setAttendedSLT(eTransfer.getAttendedSLT());
		eTransferImpl.setCurrentCompany(eTransfer.getCurrentCompany());
		eTransferImpl.setCurrentDivision(eTransfer.getCurrentDivision());
		eTransferImpl.setCurrentDepartment(eTransfer.getCurrentDepartment());
		eTransferImpl.setCurrentFunctionName(eTransfer.getCurrentFunctionName());
		eTransferImpl.setCurrentCostCenter(eTransfer.getCurrentCostCenter());
		eTransferImpl.setCurrentReportingTo(eTransfer.getCurrentReportingTo());
		eTransferImpl.setOtherAgreementIfAny(eTransfer.getOtherAgreementIfAny());
		eTransferImpl.setCurrentOfficeSite(eTransfer.getCurrentOfficeSite());
		eTransferImpl.setCurrentPositionCode(eTransfer.getCurrentPositionCode());
		eTransferImpl.setReceivingStaffCode(eTransfer.getReceivingStaffCode());
		eTransferImpl.setReceivingCompany(eTransfer.getReceivingCompany());
		eTransferImpl.setReceivingDivision(eTransfer.getReceivingDivision());
		eTransferImpl.setReceivingDepartment(eTransfer.getReceivingDepartment());
		eTransferImpl.setNewFunctionName(eTransfer.getNewFunctionName());
		eTransferImpl.setNewCostCenter(eTransfer.getNewCostCenter());
		eTransferImpl.setNewReportingTo(eTransfer.getNewReportingTo());
		eTransferImpl.setEffectiveDate(eTransfer.getEffectiveDate());
		eTransferImpl.setNewOfficeSite(eTransfer.getNewOfficeSite());
		eTransferImpl.setSapPositionCode(eTransfer.getSapPositionCode());
		eTransferImpl.setReplacement(eTransfer.getReplacement());
		eTransferImpl.setFunctionGrade(eTransfer.getFunctionGrade());
		eTransferImpl.setBudgetTypeOfPosition(eTransfer.getBudgetTypeOfPosition());
		eTransferImpl.setChinaSixty(eTransfer.getChinaSixty());
		eTransferImpl.setTargetPDSupervisor(eTransfer.getTargetPDSupervisor());
		eTransferImpl.setProcessType(eTransfer.getProcessType());
		eTransferImpl.setSubProcessType(eTransfer.getSubProcessType());
		eTransferImpl.setSubmittedDate(eTransfer.getSubmittedDate());
		eTransferImpl.setComments(eTransfer.getComments());
		eTransferImpl.setStatus(eTransfer.getStatus());
		eTransferImpl.setStatusByUserId(eTransfer.getStatusByUserId());
		eTransferImpl.setStatusByUserName(eTransfer.getStatusByUserName());
		eTransferImpl.setStatusDate(eTransfer.getStatusDate());

		return eTransferImpl;
	}

	/**
	 * Returns the e transfer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e transfer
	 * @return the e transfer
	 * @throws com.e.transfer.NoSuchETransferException if a e transfer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ETransfer findByPrimaryKey(Serializable primaryKey)
		throws NoSuchETransferException, SystemException {
		ETransfer eTransfer = fetchByPrimaryKey(primaryKey);

		if (eTransfer == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchETransferException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return eTransfer;
	}

	/**
	 * Returns the e transfer with the primary key or throws a {@link com.e.transfer.NoSuchETransferException} if it could not be found.
	 *
	 * @param eTransferId the primary key of the e transfer
	 * @return the e transfer
	 * @throws com.e.transfer.NoSuchETransferException if a e transfer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ETransfer findByPrimaryKey(long eTransferId)
		throws NoSuchETransferException, SystemException {
		return findByPrimaryKey((Serializable)eTransferId);
	}

	/**
	 * Returns the e transfer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e transfer
	 * @return the e transfer, or <code>null</code> if a e transfer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ETransfer fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ETransfer eTransfer = (ETransfer)EntityCacheUtil.getResult(ETransferModelImpl.ENTITY_CACHE_ENABLED,
				ETransferImpl.class, primaryKey);

		if (eTransfer == _nullETransfer) {
			return null;
		}

		if (eTransfer == null) {
			Session session = null;

			try {
				session = openSession();

				eTransfer = (ETransfer)session.get(ETransferImpl.class,
						primaryKey);

				if (eTransfer != null) {
					cacheResult(eTransfer);
				}
				else {
					EntityCacheUtil.putResult(ETransferModelImpl.ENTITY_CACHE_ENABLED,
						ETransferImpl.class, primaryKey, _nullETransfer);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ETransferModelImpl.ENTITY_CACHE_ENABLED,
					ETransferImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return eTransfer;
	}

	/**
	 * Returns the e transfer with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eTransferId the primary key of the e transfer
	 * @return the e transfer, or <code>null</code> if a e transfer with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ETransfer fetchByPrimaryKey(long eTransferId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)eTransferId);
	}

	/**
	 * Returns all the e transfers.
	 *
	 * @return the e transfers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ETransfer> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ETransfer> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<ETransfer> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<ETransfer> list = (List<ETransfer>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ETRANSFER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ETRANSFER;

				if (pagination) {
					sql = sql.concat(ETransferModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ETransfer>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ETransfer>(list);
				}
				else {
					list = (List<ETransfer>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the e transfers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ETransfer eTransfer : findAll()) {
			remove(eTransfer);
		}
	}

	/**
	 * Returns the number of e transfers.
	 *
	 * @return the number of e transfers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ETRANSFER);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the e transfer persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.e.transfer.model.ETransfer")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ETransfer>> listenersList = new ArrayList<ModelListener<ETransfer>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ETransfer>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ETransferImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ETRANSFER = "SELECT eTransfer FROM ETransfer eTransfer";
	private static final String _SQL_SELECT_ETRANSFER_WHERE = "SELECT eTransfer FROM ETransfer eTransfer WHERE ";
	private static final String _SQL_COUNT_ETRANSFER = "SELECT COUNT(eTransfer) FROM ETransfer eTransfer";
	private static final String _SQL_COUNT_ETRANSFER_WHERE = "SELECT COUNT(eTransfer) FROM ETransfer eTransfer WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "eTransfer.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ETransfer exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ETransfer exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ETransferPersistenceImpl.class);
	private static ETransfer _nullETransfer = new ETransferImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ETransfer> toCacheModel() {
				return _nullETransferCacheModel;
			}
		};

	private static CacheModel<ETransfer> _nullETransferCacheModel = new CacheModel<ETransfer>() {
			@Override
			public ETransfer toEntityModel() {
				return _nullETransfer;
			}
		};
}