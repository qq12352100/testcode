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

package com.e.leave.service.persistence;

import com.e.leave.NoSuchELeaveException;
import com.e.leave.model.ELeave;
import com.e.leave.model.impl.ELeaveImpl;
import com.e.leave.model.impl.ELeaveModelImpl;

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
 * The persistence implementation for the e leave service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EZEYIFE
 * @see ELeavePersistence
 * @see ELeaveUtil
 * @generated
 */
public class ELeavePersistenceImpl extends BasePersistenceImpl<ELeave>
	implements ELeavePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ELeaveUtil} to access the e leave persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ELeaveImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ELeaveModelImpl.ENTITY_CACHE_ENABLED,
			ELeaveModelImpl.FINDER_CACHE_ENABLED, ELeaveImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ELeaveModelImpl.ENTITY_CACHE_ENABLED,
			ELeaveModelImpl.FINDER_CACHE_ENABLED, ELeaveImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ELeaveModelImpl.ENTITY_CACHE_ENABLED,
			ELeaveModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_S_U = new FinderPath(ELeaveModelImpl.ENTITY_CACHE_ENABLED,
			ELeaveModelImpl.FINDER_CACHE_ENABLED, ELeaveImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByS_U",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U = new FinderPath(ELeaveModelImpl.ENTITY_CACHE_ENABLED,
			ELeaveModelImpl.FINDER_CACHE_ENABLED, ELeaveImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_U",
			new String[] { Integer.class.getName(), Long.class.getName() },
			ELeaveModelImpl.STATUS_COLUMN_BITMASK |
			ELeaveModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_S_U = new FinderPath(ELeaveModelImpl.ENTITY_CACHE_ENABLED,
			ELeaveModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_U",
			new String[] { Integer.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e leaves where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @return the matching e leaves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ELeave> findByS_U(int status, long userId)
		throws SystemException {
		return findByS_U(status, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e leaves where status = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.leave.model.impl.ELeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param start the lower bound of the range of e leaves
	 * @param end the upper bound of the range of e leaves (not inclusive)
	 * @return the range of matching e leaves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ELeave> findByS_U(int status, long userId, int start, int end)
		throws SystemException {
		return findByS_U(status, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e leaves where status = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.leave.model.impl.ELeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param start the lower bound of the range of e leaves
	 * @param end the upper bound of the range of e leaves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e leaves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ELeave> findByS_U(int status, long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<ELeave> list = (List<ELeave>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ELeave eLeave : list) {
				if ((status != eLeave.getStatus()) ||
						(userId != eLeave.getUserId())) {
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

			query.append(_SQL_SELECT_ELEAVE_WHERE);

			query.append(_FINDER_COLUMN_S_U_STATUS_2);

			query.append(_FINDER_COLUMN_S_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ELeaveModelImpl.ORDER_BY_JPQL);
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
					list = (List<ELeave>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ELeave>(list);
				}
				else {
					list = (List<ELeave>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first e leave in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e leave
	 * @throws com.e.leave.NoSuchELeaveException if a matching e leave could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ELeave findByS_U_First(int status, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchELeaveException, SystemException {
		ELeave eLeave = fetchByS_U_First(status, userId, orderByComparator);

		if (eLeave != null) {
			return eLeave;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchELeaveException(msg.toString());
	}

	/**
	 * Returns the first e leave in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e leave, or <code>null</code> if a matching e leave could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ELeave fetchByS_U_First(int status, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ELeave> list = findByS_U(status, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e leave in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e leave
	 * @throws com.e.leave.NoSuchELeaveException if a matching e leave could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ELeave findByS_U_Last(int status, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchELeaveException, SystemException {
		ELeave eLeave = fetchByS_U_Last(status, userId, orderByComparator);

		if (eLeave != null) {
			return eLeave;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchELeaveException(msg.toString());
	}

	/**
	 * Returns the last e leave in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e leave, or <code>null</code> if a matching e leave could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ELeave fetchByS_U_Last(int status, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByS_U(status, userId);

		if (count == 0) {
			return null;
		}

		List<ELeave> list = findByS_U(status, userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e leaves before and after the current e leave in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param eLeaveId the primary key of the current e leave
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e leave
	 * @throws com.e.leave.NoSuchELeaveException if a e leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ELeave[] findByS_U_PrevAndNext(long eLeaveId, int status,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchELeaveException, SystemException {
		ELeave eLeave = findByPrimaryKey(eLeaveId);

		Session session = null;

		try {
			session = openSession();

			ELeave[] array = new ELeaveImpl[3];

			array[0] = getByS_U_PrevAndNext(session, eLeave, status, userId,
					orderByComparator, true);

			array[1] = eLeave;

			array[2] = getByS_U_PrevAndNext(session, eLeave, status, userId,
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

	protected ELeave getByS_U_PrevAndNext(Session session, ELeave eLeave,
		int status, long userId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ELEAVE_WHERE);

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
			query.append(ELeaveModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eLeave);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ELeave> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e leaves where status = &#63; and userId = &#63; from the database.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByS_U(int status, long userId) throws SystemException {
		for (ELeave eLeave : findByS_U(status, userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(eLeave);
		}
	}

	/**
	 * Returns the number of e leaves where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @return the number of matching e leaves
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

			query.append(_SQL_COUNT_ELEAVE_WHERE);

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

	private static final String _FINDER_COLUMN_S_U_STATUS_2 = "eLeave.status = ? AND ";
	private static final String _FINDER_COLUMN_S_U_USERID_2 = "eLeave.userId = ?";

	public ELeavePersistenceImpl() {
		setModelClass(ELeave.class);
	}

	/**
	 * Caches the e leave in the entity cache if it is enabled.
	 *
	 * @param eLeave the e leave
	 */
	@Override
	public void cacheResult(ELeave eLeave) {
		EntityCacheUtil.putResult(ELeaveModelImpl.ENTITY_CACHE_ENABLED,
			ELeaveImpl.class, eLeave.getPrimaryKey(), eLeave);

		eLeave.resetOriginalValues();
	}

	/**
	 * Caches the e leaves in the entity cache if it is enabled.
	 *
	 * @param eLeaves the e leaves
	 */
	@Override
	public void cacheResult(List<ELeave> eLeaves) {
		for (ELeave eLeave : eLeaves) {
			if (EntityCacheUtil.getResult(
						ELeaveModelImpl.ENTITY_CACHE_ENABLED, ELeaveImpl.class,
						eLeave.getPrimaryKey()) == null) {
				cacheResult(eLeave);
			}
			else {
				eLeave.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e leaves.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ELeaveImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ELeaveImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e leave.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ELeave eLeave) {
		EntityCacheUtil.removeResult(ELeaveModelImpl.ENTITY_CACHE_ENABLED,
			ELeaveImpl.class, eLeave.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ELeave> eLeaves) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ELeave eLeave : eLeaves) {
			EntityCacheUtil.removeResult(ELeaveModelImpl.ENTITY_CACHE_ENABLED,
				ELeaveImpl.class, eLeave.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e leave with the primary key. Does not add the e leave to the database.
	 *
	 * @param eLeaveId the primary key for the new e leave
	 * @return the new e leave
	 */
	@Override
	public ELeave create(long eLeaveId) {
		ELeave eLeave = new ELeaveImpl();

		eLeave.setNew(true);
		eLeave.setPrimaryKey(eLeaveId);

		return eLeave;
	}

	/**
	 * Removes the e leave with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eLeaveId the primary key of the e leave
	 * @return the e leave that was removed
	 * @throws com.e.leave.NoSuchELeaveException if a e leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ELeave remove(long eLeaveId)
		throws NoSuchELeaveException, SystemException {
		return remove((Serializable)eLeaveId);
	}

	/**
	 * Removes the e leave with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e leave
	 * @return the e leave that was removed
	 * @throws com.e.leave.NoSuchELeaveException if a e leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ELeave remove(Serializable primaryKey)
		throws NoSuchELeaveException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ELeave eLeave = (ELeave)session.get(ELeaveImpl.class, primaryKey);

			if (eLeave == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchELeaveException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(eLeave);
		}
		catch (NoSuchELeaveException nsee) {
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
	protected ELeave removeImpl(ELeave eLeave) throws SystemException {
		eLeave = toUnwrappedModel(eLeave);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eLeave)) {
				eLeave = (ELeave)session.get(ELeaveImpl.class,
						eLeave.getPrimaryKeyObj());
			}

			if (eLeave != null) {
				session.delete(eLeave);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (eLeave != null) {
			clearCache(eLeave);
		}

		return eLeave;
	}

	@Override
	public ELeave updateImpl(com.e.leave.model.ELeave eLeave)
		throws SystemException {
		eLeave = toUnwrappedModel(eLeave);

		boolean isNew = eLeave.isNew();

		ELeaveModelImpl eLeaveModelImpl = (ELeaveModelImpl)eLeave;

		Session session = null;

		try {
			session = openSession();

			if (eLeave.isNew()) {
				session.save(eLeave);

				eLeave.setNew(false);
			}
			else {
				session.merge(eLeave);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ELeaveModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((eLeaveModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eLeaveModelImpl.getOriginalStatus(),
						eLeaveModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U,
					args);

				args = new Object[] {
						eLeaveModelImpl.getStatus(), eLeaveModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U,
					args);
			}
		}

		EntityCacheUtil.putResult(ELeaveModelImpl.ENTITY_CACHE_ENABLED,
			ELeaveImpl.class, eLeave.getPrimaryKey(), eLeave);

		return eLeave;
	}

	protected ELeave toUnwrappedModel(ELeave eLeave) {
		if (eLeave instanceof ELeaveImpl) {
			return eLeave;
		}

		ELeaveImpl eLeaveImpl = new ELeaveImpl();

		eLeaveImpl.setNew(eLeave.isNew());
		eLeaveImpl.setPrimaryKey(eLeave.getPrimaryKey());

		eLeaveImpl.setELeaveId(eLeave.getELeaveId());
		eLeaveImpl.setGroupId(eLeave.getGroupId());
		eLeaveImpl.setUserId(eLeave.getUserId());
		eLeaveImpl.setUserName(eLeave.getUserName());
		eLeaveImpl.setCreateDate(eLeave.getCreateDate());
		eLeaveImpl.setModifiedDate(eLeave.getModifiedDate());
		eLeaveImpl.setCompanyId(eLeave.getCompanyId());
		eLeaveImpl.setTicketNo(eLeave.getTicketNo());
		eLeaveImpl.setStaffName(eLeave.getStaffName());
		eLeaveImpl.setStaffCode(eLeave.getStaffCode());
		eLeaveImpl.setCompany(eLeave.getCompany());
		eLeaveImpl.setDivision(eLeave.getDivision());
		eLeaveImpl.setDepartment(eLeave.getDepartment());
		eLeaveImpl.setCostCenter(eLeave.getCostCenter());
		eLeaveImpl.setOfficePhone(eLeave.getOfficePhone());
		eLeaveImpl.setMobilePhone(eLeave.getMobilePhone());
		eLeaveImpl.setEmail(eLeave.getEmail());
		eLeaveImpl.setPositionType(eLeave.getPositionType());
		eLeaveImpl.setIsApplicantAgent(eLeave.isIsApplicantAgent());
		eLeaveImpl.setIsApproverAgent(eLeave.isIsApproverAgent());
		eLeaveImpl.setProcessType(eLeave.getProcessType());
		eLeaveImpl.setSubProcessType(eLeave.getSubProcessType());
		eLeaveImpl.setSubmittedDate(eLeave.getSubmittedDate());
		eLeaveImpl.setComments(eLeave.getComments());
		eLeaveImpl.setStatus(eLeave.getStatus());
		eLeaveImpl.setStatusByUserId(eLeave.getStatusByUserId());
		eLeaveImpl.setStatusByUserName(eLeave.getStatusByUserName());
		eLeaveImpl.setStatusDate(eLeave.getStatusDate());
		eLeaveImpl.setTotalLeaveEntitlement(eLeave.getTotalLeaveEntitlement());
		eLeaveImpl.setTotalDuration(eLeave.getTotalDuration());
		eLeaveImpl.setRemainingLeaveDaysBefore(eLeave.getRemainingLeaveDaysBefore());
		eLeaveImpl.setRemainingLeaveDaysAfter(eLeave.getRemainingLeaveDaysAfter());

		return eLeaveImpl;
	}

	/**
	 * Returns the e leave with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e leave
	 * @return the e leave
	 * @throws com.e.leave.NoSuchELeaveException if a e leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ELeave findByPrimaryKey(Serializable primaryKey)
		throws NoSuchELeaveException, SystemException {
		ELeave eLeave = fetchByPrimaryKey(primaryKey);

		if (eLeave == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchELeaveException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return eLeave;
	}

	/**
	 * Returns the e leave with the primary key or throws a {@link com.e.leave.NoSuchELeaveException} if it could not be found.
	 *
	 * @param eLeaveId the primary key of the e leave
	 * @return the e leave
	 * @throws com.e.leave.NoSuchELeaveException if a e leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ELeave findByPrimaryKey(long eLeaveId)
		throws NoSuchELeaveException, SystemException {
		return findByPrimaryKey((Serializable)eLeaveId);
	}

	/**
	 * Returns the e leave with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e leave
	 * @return the e leave, or <code>null</code> if a e leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ELeave fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ELeave eLeave = (ELeave)EntityCacheUtil.getResult(ELeaveModelImpl.ENTITY_CACHE_ENABLED,
				ELeaveImpl.class, primaryKey);

		if (eLeave == _nullELeave) {
			return null;
		}

		if (eLeave == null) {
			Session session = null;

			try {
				session = openSession();

				eLeave = (ELeave)session.get(ELeaveImpl.class, primaryKey);

				if (eLeave != null) {
					cacheResult(eLeave);
				}
				else {
					EntityCacheUtil.putResult(ELeaveModelImpl.ENTITY_CACHE_ENABLED,
						ELeaveImpl.class, primaryKey, _nullELeave);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ELeaveModelImpl.ENTITY_CACHE_ENABLED,
					ELeaveImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return eLeave;
	}

	/**
	 * Returns the e leave with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eLeaveId the primary key of the e leave
	 * @return the e leave, or <code>null</code> if a e leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ELeave fetchByPrimaryKey(long eLeaveId) throws SystemException {
		return fetchByPrimaryKey((Serializable)eLeaveId);
	}

	/**
	 * Returns all the e leaves.
	 *
	 * @return the e leaves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ELeave> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e leaves.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.leave.model.impl.ELeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e leaves
	 * @param end the upper bound of the range of e leaves (not inclusive)
	 * @return the range of e leaves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ELeave> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e leaves.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.leave.model.impl.ELeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e leaves
	 * @param end the upper bound of the range of e leaves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e leaves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ELeave> findAll(int start, int end,
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

		List<ELeave> list = (List<ELeave>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ELEAVE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ELEAVE;

				if (pagination) {
					sql = sql.concat(ELeaveModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ELeave>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ELeave>(list);
				}
				else {
					list = (List<ELeave>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the e leaves from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ELeave eLeave : findAll()) {
			remove(eLeave);
		}
	}

	/**
	 * Returns the number of e leaves.
	 *
	 * @return the number of e leaves
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

				Query q = session.createQuery(_SQL_COUNT_ELEAVE);

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
	 * Initializes the e leave persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.e.leave.model.ELeave")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ELeave>> listenersList = new ArrayList<ModelListener<ELeave>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ELeave>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ELeaveImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ELEAVE = "SELECT eLeave FROM ELeave eLeave";
	private static final String _SQL_SELECT_ELEAVE_WHERE = "SELECT eLeave FROM ELeave eLeave WHERE ";
	private static final String _SQL_COUNT_ELEAVE = "SELECT COUNT(eLeave) FROM ELeave eLeave";
	private static final String _SQL_COUNT_ELEAVE_WHERE = "SELECT COUNT(eLeave) FROM ELeave eLeave WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "eLeave.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ELeave exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ELeave exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ELeavePersistenceImpl.class);
	private static ELeave _nullELeave = new ELeaveImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ELeave> toCacheModel() {
				return _nullELeaveCacheModel;
			}
		};

	private static CacheModel<ELeave> _nullELeaveCacheModel = new CacheModel<ELeave>() {
			@Override
			public ELeave toEntityModel() {
				return _nullELeave;
			}
		};
}