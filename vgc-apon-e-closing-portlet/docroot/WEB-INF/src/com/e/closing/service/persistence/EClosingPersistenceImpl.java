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

package com.e.closing.service.persistence;

import com.e.closing.NoSuchEClosingException;
import com.e.closing.model.EClosing;
import com.e.closing.model.impl.EClosingImpl;
import com.e.closing.model.impl.EClosingModelImpl;

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
 * The persistence implementation for the e closing service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author t.a.jiang
 * @see EClosingPersistence
 * @see EClosingUtil
 * @generated
 */
public class EClosingPersistenceImpl extends BasePersistenceImpl<EClosing>
	implements EClosingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EClosingUtil} to access the e closing persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EClosingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EClosingModelImpl.ENTITY_CACHE_ENABLED,
			EClosingModelImpl.FINDER_CACHE_ENABLED, EClosingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EClosingModelImpl.ENTITY_CACHE_ENABLED,
			EClosingModelImpl.FINDER_CACHE_ENABLED, EClosingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EClosingModelImpl.ENTITY_CACHE_ENABLED,
			EClosingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_S_U = new FinderPath(EClosingModelImpl.ENTITY_CACHE_ENABLED,
			EClosingModelImpl.FINDER_CACHE_ENABLED, EClosingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByS_U",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U = new FinderPath(EClosingModelImpl.ENTITY_CACHE_ENABLED,
			EClosingModelImpl.FINDER_CACHE_ENABLED, EClosingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_U",
			new String[] { Integer.class.getName(), Long.class.getName() },
			EClosingModelImpl.STATUS_COLUMN_BITMASK |
			EClosingModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_S_U = new FinderPath(EClosingModelImpl.ENTITY_CACHE_ENABLED,
			EClosingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_U",
			new String[] { Integer.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e closings where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @return the matching e closings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EClosing> findByS_U(int status, long userId)
		throws SystemException {
		return findByS_U(status, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e closings where status = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.closing.model.impl.EClosingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param start the lower bound of the range of e closings
	 * @param end the upper bound of the range of e closings (not inclusive)
	 * @return the range of matching e closings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EClosing> findByS_U(int status, long userId, int start, int end)
		throws SystemException {
		return findByS_U(status, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e closings where status = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.closing.model.impl.EClosingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param start the lower bound of the range of e closings
	 * @param end the upper bound of the range of e closings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e closings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EClosing> findByS_U(int status, long userId, int start,
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

		List<EClosing> list = (List<EClosing>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EClosing eClosing : list) {
				if ((status != eClosing.getStatus()) ||
						(userId != eClosing.getUserId())) {
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

			query.append(_SQL_SELECT_ECLOSING_WHERE);

			query.append(_FINDER_COLUMN_S_U_STATUS_2);

			query.append(_FINDER_COLUMN_S_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EClosingModelImpl.ORDER_BY_JPQL);
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
					list = (List<EClosing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EClosing>(list);
				}
				else {
					list = (List<EClosing>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e closing in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e closing
	 * @throws com.e.closing.NoSuchEClosingException if a matching e closing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EClosing findByS_U_First(int status, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchEClosingException, SystemException {
		EClosing eClosing = fetchByS_U_First(status, userId, orderByComparator);

		if (eClosing != null) {
			return eClosing;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEClosingException(msg.toString());
	}

	/**
	 * Returns the first e closing in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e closing, or <code>null</code> if a matching e closing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EClosing fetchByS_U_First(int status, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EClosing> list = findByS_U(status, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e closing in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e closing
	 * @throws com.e.closing.NoSuchEClosingException if a matching e closing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EClosing findByS_U_Last(int status, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchEClosingException, SystemException {
		EClosing eClosing = fetchByS_U_Last(status, userId, orderByComparator);

		if (eClosing != null) {
			return eClosing;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEClosingException(msg.toString());
	}

	/**
	 * Returns the last e closing in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e closing, or <code>null</code> if a matching e closing could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EClosing fetchByS_U_Last(int status, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByS_U(status, userId);

		if (count == 0) {
			return null;
		}

		List<EClosing> list = findByS_U(status, userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e closings before and after the current e closing in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param eclosingId the primary key of the current e closing
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e closing
	 * @throws com.e.closing.NoSuchEClosingException if a e closing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EClosing[] findByS_U_PrevAndNext(long eclosingId, int status,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchEClosingException, SystemException {
		EClosing eClosing = findByPrimaryKey(eclosingId);

		Session session = null;

		try {
			session = openSession();

			EClosing[] array = new EClosingImpl[3];

			array[0] = getByS_U_PrevAndNext(session, eClosing, status, userId,
					orderByComparator, true);

			array[1] = eClosing;

			array[2] = getByS_U_PrevAndNext(session, eClosing, status, userId,
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

	protected EClosing getByS_U_PrevAndNext(Session session, EClosing eClosing,
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

		query.append(_SQL_SELECT_ECLOSING_WHERE);

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
			query.append(EClosingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eClosing);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EClosing> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e closings where status = &#63; and userId = &#63; from the database.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByS_U(int status, long userId) throws SystemException {
		for (EClosing eClosing : findByS_U(status, userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(eClosing);
		}
	}

	/**
	 * Returns the number of e closings where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @return the number of matching e closings
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

			query.append(_SQL_COUNT_ECLOSING_WHERE);

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

	private static final String _FINDER_COLUMN_S_U_STATUS_2 = "eClosing.status = ? AND ";
	private static final String _FINDER_COLUMN_S_U_USERID_2 = "eClosing.userId = ?";

	public EClosingPersistenceImpl() {
		setModelClass(EClosing.class);
	}

	/**
	 * Caches the e closing in the entity cache if it is enabled.
	 *
	 * @param eClosing the e closing
	 */
	@Override
	public void cacheResult(EClosing eClosing) {
		EntityCacheUtil.putResult(EClosingModelImpl.ENTITY_CACHE_ENABLED,
			EClosingImpl.class, eClosing.getPrimaryKey(), eClosing);

		eClosing.resetOriginalValues();
	}

	/**
	 * Caches the e closings in the entity cache if it is enabled.
	 *
	 * @param eClosings the e closings
	 */
	@Override
	public void cacheResult(List<EClosing> eClosings) {
		for (EClosing eClosing : eClosings) {
			if (EntityCacheUtil.getResult(
						EClosingModelImpl.ENTITY_CACHE_ENABLED,
						EClosingImpl.class, eClosing.getPrimaryKey()) == null) {
				cacheResult(eClosing);
			}
			else {
				eClosing.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e closings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EClosingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EClosingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e closing.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EClosing eClosing) {
		EntityCacheUtil.removeResult(EClosingModelImpl.ENTITY_CACHE_ENABLED,
			EClosingImpl.class, eClosing.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EClosing> eClosings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EClosing eClosing : eClosings) {
			EntityCacheUtil.removeResult(EClosingModelImpl.ENTITY_CACHE_ENABLED,
				EClosingImpl.class, eClosing.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e closing with the primary key. Does not add the e closing to the database.
	 *
	 * @param eclosingId the primary key for the new e closing
	 * @return the new e closing
	 */
	@Override
	public EClosing create(long eclosingId) {
		EClosing eClosing = new EClosingImpl();

		eClosing.setNew(true);
		eClosing.setPrimaryKey(eclosingId);

		return eClosing;
	}

	/**
	 * Removes the e closing with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eclosingId the primary key of the e closing
	 * @return the e closing that was removed
	 * @throws com.e.closing.NoSuchEClosingException if a e closing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EClosing remove(long eclosingId)
		throws NoSuchEClosingException, SystemException {
		return remove((Serializable)eclosingId);
	}

	/**
	 * Removes the e closing with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e closing
	 * @return the e closing that was removed
	 * @throws com.e.closing.NoSuchEClosingException if a e closing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EClosing remove(Serializable primaryKey)
		throws NoSuchEClosingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EClosing eClosing = (EClosing)session.get(EClosingImpl.class,
					primaryKey);

			if (eClosing == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEClosingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(eClosing);
		}
		catch (NoSuchEClosingException nsee) {
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
	protected EClosing removeImpl(EClosing eClosing) throws SystemException {
		eClosing = toUnwrappedModel(eClosing);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eClosing)) {
				eClosing = (EClosing)session.get(EClosingImpl.class,
						eClosing.getPrimaryKeyObj());
			}

			if (eClosing != null) {
				session.delete(eClosing);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (eClosing != null) {
			clearCache(eClosing);
		}

		return eClosing;
	}

	@Override
	public EClosing updateImpl(com.e.closing.model.EClosing eClosing)
		throws SystemException {
		eClosing = toUnwrappedModel(eClosing);

		boolean isNew = eClosing.isNew();

		EClosingModelImpl eClosingModelImpl = (EClosingModelImpl)eClosing;

		Session session = null;

		try {
			session = openSession();

			if (eClosing.isNew()) {
				session.save(eClosing);

				eClosing.setNew(false);
			}
			else {
				session.merge(eClosing);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EClosingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((eClosingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eClosingModelImpl.getOriginalStatus(),
						eClosingModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U,
					args);

				args = new Object[] {
						eClosingModelImpl.getStatus(),
						eClosingModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U,
					args);
			}
		}

		EntityCacheUtil.putResult(EClosingModelImpl.ENTITY_CACHE_ENABLED,
			EClosingImpl.class, eClosing.getPrimaryKey(), eClosing);

		return eClosing;
	}

	protected EClosing toUnwrappedModel(EClosing eClosing) {
		if (eClosing instanceof EClosingImpl) {
			return eClosing;
		}

		EClosingImpl eClosingImpl = new EClosingImpl();

		eClosingImpl.setNew(eClosing.isNew());
		eClosingImpl.setPrimaryKey(eClosing.getPrimaryKey());

		eClosingImpl.setEclosingId(eClosing.getEclosingId());
		eClosingImpl.setGroupId(eClosing.getGroupId());
		eClosingImpl.setCompanyId(eClosing.getCompanyId());
		eClosingImpl.setUserId(eClosing.getUserId());
		eClosingImpl.setUserName(eClosing.getUserName());
		eClosingImpl.setCreateDate(eClosing.getCreateDate());
		eClosingImpl.setModifiedDate(eClosing.getModifiedDate());
		eClosingImpl.setTicketNo(eClosing.getTicketNo());
		eClosingImpl.setStaffCode(eClosing.getStaffCode());
		eClosingImpl.setStaffName(eClosing.getStaffName());
		eClosingImpl.setCompany(eClosing.getCompany());
		eClosingImpl.setDivision(eClosing.getDivision());
		eClosingImpl.setDepartment(eClosing.getDepartment());
		eClosingImpl.setCostCenter(eClosing.getCostCenter());
		eClosingImpl.setFunctionName(eClosing.getFunctionName());
		eClosingImpl.setPositionCode(eClosing.getPositionCode());
		eClosingImpl.setEmployeeGroupId(eClosing.getEmployeeGroupId());
		eClosingImpl.setEmployeeGroupName(eClosing.getEmployeeGroupName());
		eClosingImpl.setPrivateEmailAddress(eClosing.getPrivateEmailAddress());
		eClosingImpl.setStartingDate(eClosing.getStartingDate());
		eClosingImpl.setLastWorkingDay(eClosing.getLastWorkingDay());
		eClosingImpl.setFinishContractDate(eClosing.getFinishContractDate());
		eClosingImpl.setSeatOfficeNumber(eClosing.getSeatOfficeNumber());
		eClosingImpl.setPermanentAddress(eClosing.getPermanentAddress());
		eClosingImpl.setDmOption1(eClosing.isDmOption1());
		eClosingImpl.setDmOption2(eClosing.isDmOption2());
		eClosingImpl.setDmStatus(eClosing.getDmStatus());
		eClosingImpl.setDmComments(eClosing.getDmComments());
		eClosingImpl.setAdOption1(eClosing.isAdOption1());
		eClosingImpl.setAdOption2(eClosing.isAdOption2());
		eClosingImpl.setAdOption3(eClosing.isAdOption3());
		eClosingImpl.setAdOption4(eClosing.isAdOption4());
		eClosingImpl.setAdFinanceFee(eClosing.getAdFinanceFee());
		eClosingImpl.setAdStatus(eClosing.getAdStatus());
		eClosingImpl.setAdComments(eClosing.getAdComments());
		eClosingImpl.setFsOption1(eClosing.isFsOption1());
		eClosingImpl.setFsStatus(eClosing.getFsStatus());
		eClosingImpl.setFsComments(eClosing.getFsComments());
		eClosingImpl.setFlcOption1(eClosing.isFlcOption1());
		eClosingImpl.setFlcOption2(eClosing.isFlcOption2());
		eClosingImpl.setFlcStatus(eClosing.getFlcStatus());
		eClosingImpl.setFlcComments(eClosing.getFlcComments());
		eClosingImpl.setSecurityOption1(eClosing.isSecurityOption1());
		eClosingImpl.setSecurityFinanceFee(eClosing.getSecurityFinanceFee());
		eClosingImpl.setSecurityStatus(eClosing.getSecurityStatus());
		eClosingImpl.setSecurityComments(eClosing.getSecurityComments());
		eClosingImpl.setIdOption1(eClosing.isIdOption1());
		eClosingImpl.setIdOption2(eClosing.isIdOption2());
		eClosingImpl.setIdOption3(eClosing.isIdOption3());
		eClosingImpl.setIdOption4(eClosing.isIdOption4());
		eClosingImpl.setIdOption5(eClosing.isIdOption5());
		eClosingImpl.setIdOption6(eClosing.isIdOption6());
		eClosingImpl.setIdOption7(eClosing.isIdOption7());
		eClosingImpl.setIdOption8(eClosing.isIdOption8());
		eClosingImpl.setIdOption9(eClosing.isIdOption9());
		eClosingImpl.setIdHrFee(eClosing.getIdHrFee());
		eClosingImpl.setIdFinanceFee(eClosing.getIdFinanceFee());
		eClosingImpl.setIdStatus(eClosing.getIdStatus());
		eClosingImpl.setIdComments(eClosing.getIdComments());
		eClosingImpl.setHtdOption1(eClosing.isHtdOption1());
		eClosingImpl.setHtdHrFee(eClosing.getHtdHrFee());
		eClosingImpl.setHtdFinanceFee(eClosing.getHtdFinanceFee());
		eClosingImpl.setHtdStatus(eClosing.getHtdStatus());
		eClosingImpl.setHtdComments(eClosing.getHtdComments());
		eClosingImpl.setHdOption1(eClosing.isHdOption1());
		eClosingImpl.setHdOption2(eClosing.isHdOption2());
		eClosingImpl.setHdOption2Text(eClosing.getHdOption2Text());
		eClosingImpl.setHdOption3(eClosing.isHdOption3());
		eClosingImpl.setHdOption3Money(eClosing.getHdOption3Money());
		eClosingImpl.setHdOption4(eClosing.isHdOption4());
		eClosingImpl.setHdOption4Money(eClosing.getHdOption4Money());
		eClosingImpl.setHdStatus(eClosing.getHdStatus());
		eClosingImpl.setHdComments(eClosing.getHdComments());
		eClosingImpl.setHdleaveText(eClosing.getHdleaveText());
		eClosingImpl.setFdOption1(eClosing.isFdOption1());
		eClosingImpl.setFdOption2(eClosing.isFdOption2());
		eClosingImpl.setFdOption3(eClosing.isFdOption3());
		eClosingImpl.setFdOption4(eClosing.isFdOption4());
		eClosingImpl.setFdOption4Text(eClosing.getFdOption4Text());
		eClosingImpl.setFdStatus(eClosing.getFdStatus());
		eClosingImpl.setFdComments(eClosing.getFdComments());
		eClosingImpl.setApplicantAgent(eClosing.isApplicantAgent());
		eClosingImpl.setApproverAgent(eClosing.isApproverAgent());
		eClosingImpl.setProcessType(eClosing.getProcessType());
		eClosingImpl.setSubProcessType(eClosing.getSubProcessType());
		eClosingImpl.setStatus(eClosing.getStatus());
		eClosingImpl.setStatusByUserId(eClosing.getStatusByUserId());
		eClosingImpl.setStatusByUserName(eClosing.getStatusByUserName());
		eClosingImpl.setStatusDate(eClosing.getStatusDate());

		return eClosingImpl;
	}

	/**
	 * Returns the e closing with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e closing
	 * @return the e closing
	 * @throws com.e.closing.NoSuchEClosingException if a e closing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EClosing findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEClosingException, SystemException {
		EClosing eClosing = fetchByPrimaryKey(primaryKey);

		if (eClosing == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEClosingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return eClosing;
	}

	/**
	 * Returns the e closing with the primary key or throws a {@link com.e.closing.NoSuchEClosingException} if it could not be found.
	 *
	 * @param eclosingId the primary key of the e closing
	 * @return the e closing
	 * @throws com.e.closing.NoSuchEClosingException if a e closing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EClosing findByPrimaryKey(long eclosingId)
		throws NoSuchEClosingException, SystemException {
		return findByPrimaryKey((Serializable)eclosingId);
	}

	/**
	 * Returns the e closing with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e closing
	 * @return the e closing, or <code>null</code> if a e closing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EClosing fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EClosing eClosing = (EClosing)EntityCacheUtil.getResult(EClosingModelImpl.ENTITY_CACHE_ENABLED,
				EClosingImpl.class, primaryKey);

		if (eClosing == _nullEClosing) {
			return null;
		}

		if (eClosing == null) {
			Session session = null;

			try {
				session = openSession();

				eClosing = (EClosing)session.get(EClosingImpl.class, primaryKey);

				if (eClosing != null) {
					cacheResult(eClosing);
				}
				else {
					EntityCacheUtil.putResult(EClosingModelImpl.ENTITY_CACHE_ENABLED,
						EClosingImpl.class, primaryKey, _nullEClosing);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EClosingModelImpl.ENTITY_CACHE_ENABLED,
					EClosingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return eClosing;
	}

	/**
	 * Returns the e closing with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eclosingId the primary key of the e closing
	 * @return the e closing, or <code>null</code> if a e closing with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EClosing fetchByPrimaryKey(long eclosingId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)eclosingId);
	}

	/**
	 * Returns all the e closings.
	 *
	 * @return the e closings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EClosing> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e closings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.closing.model.impl.EClosingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e closings
	 * @param end the upper bound of the range of e closings (not inclusive)
	 * @return the range of e closings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EClosing> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e closings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.closing.model.impl.EClosingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e closings
	 * @param end the upper bound of the range of e closings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e closings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EClosing> findAll(int start, int end,
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

		List<EClosing> list = (List<EClosing>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ECLOSING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ECLOSING;

				if (pagination) {
					sql = sql.concat(EClosingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EClosing>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EClosing>(list);
				}
				else {
					list = (List<EClosing>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e closings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EClosing eClosing : findAll()) {
			remove(eClosing);
		}
	}

	/**
	 * Returns the number of e closings.
	 *
	 * @return the number of e closings
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

				Query q = session.createQuery(_SQL_COUNT_ECLOSING);

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
	 * Initializes the e closing persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.e.closing.model.EClosing")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EClosing>> listenersList = new ArrayList<ModelListener<EClosing>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EClosing>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EClosingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ECLOSING = "SELECT eClosing FROM EClosing eClosing";
	private static final String _SQL_SELECT_ECLOSING_WHERE = "SELECT eClosing FROM EClosing eClosing WHERE ";
	private static final String _SQL_COUNT_ECLOSING = "SELECT COUNT(eClosing) FROM EClosing eClosing";
	private static final String _SQL_COUNT_ECLOSING_WHERE = "SELECT COUNT(eClosing) FROM EClosing eClosing WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "eClosing.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EClosing exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EClosing exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EClosingPersistenceImpl.class);
	private static EClosing _nullEClosing = new EClosingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EClosing> toCacheModel() {
				return _nullEClosingCacheModel;
			}
		};

	private static CacheModel<EClosing> _nullEClosingCacheModel = new CacheModel<EClosing>() {
			@Override
			public EClosing toEntityModel() {
				return _nullEClosing;
			}
		};
}