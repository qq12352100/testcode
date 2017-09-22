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

package com.seatoffice.service.persistence;

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

import com.seatoffice.NoSuchSeatOfficeException;

import com.seatoffice.model.SeatOffice;
import com.seatoffice.model.impl.SeatOfficeImpl;
import com.seatoffice.model.impl.SeatOfficeModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the seat office service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alice.zou
 * @see SeatOfficePersistence
 * @see SeatOfficeUtil
 * @generated
 */
public class SeatOfficePersistenceImpl extends BasePersistenceImpl<SeatOffice>
	implements SeatOfficePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SeatOfficeUtil} to access the seat office persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SeatOfficeImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SeatOfficeModelImpl.ENTITY_CACHE_ENABLED,
			SeatOfficeModelImpl.FINDER_CACHE_ENABLED, SeatOfficeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SeatOfficeModelImpl.ENTITY_CACHE_ENABLED,
			SeatOfficeModelImpl.FINDER_CACHE_ENABLED, SeatOfficeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SeatOfficeModelImpl.ENTITY_CACHE_ENABLED,
			SeatOfficeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_S_U = new FinderPath(SeatOfficeModelImpl.ENTITY_CACHE_ENABLED,
			SeatOfficeModelImpl.FINDER_CACHE_ENABLED, SeatOfficeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByS_U",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U = new FinderPath(SeatOfficeModelImpl.ENTITY_CACHE_ENABLED,
			SeatOfficeModelImpl.FINDER_CACHE_ENABLED, SeatOfficeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_U",
			new String[] { Integer.class.getName(), Long.class.getName() },
			SeatOfficeModelImpl.STATUS_COLUMN_BITMASK |
			SeatOfficeModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_S_U = new FinderPath(SeatOfficeModelImpl.ENTITY_CACHE_ENABLED,
			SeatOfficeModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_U",
			new String[] { Integer.class.getName(), Long.class.getName() });

	/**
	 * Returns all the seat offices where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @return the matching seat offices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SeatOffice> findByS_U(int status, long userId)
		throws SystemException {
		return findByS_U(status, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the seat offices where status = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.seatoffice.model.impl.SeatOfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param start the lower bound of the range of seat offices
	 * @param end the upper bound of the range of seat offices (not inclusive)
	 * @return the range of matching seat offices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SeatOffice> findByS_U(int status, long userId, int start,
		int end) throws SystemException {
		return findByS_U(status, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the seat offices where status = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.seatoffice.model.impl.SeatOfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param start the lower bound of the range of seat offices
	 * @param end the upper bound of the range of seat offices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching seat offices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SeatOffice> findByS_U(int status, long userId, int start,
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

		List<SeatOffice> list = (List<SeatOffice>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SeatOffice seatOffice : list) {
				if ((status != seatOffice.getStatus()) ||
						(userId != seatOffice.getUserId())) {
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

			query.append(_SQL_SELECT_SEATOFFICE_WHERE);

			query.append(_FINDER_COLUMN_S_U_STATUS_2);

			query.append(_FINDER_COLUMN_S_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SeatOfficeModelImpl.ORDER_BY_JPQL);
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
					list = (List<SeatOffice>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SeatOffice>(list);
				}
				else {
					list = (List<SeatOffice>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first seat office in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching seat office
	 * @throws com.seatoffice.NoSuchSeatOfficeException if a matching seat office could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatOffice findByS_U_First(int status, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSeatOfficeException, SystemException {
		SeatOffice seatOffice = fetchByS_U_First(status, userId,
				orderByComparator);

		if (seatOffice != null) {
			return seatOffice;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSeatOfficeException(msg.toString());
	}

	/**
	 * Returns the first seat office in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching seat office, or <code>null</code> if a matching seat office could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatOffice fetchByS_U_First(int status, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SeatOffice> list = findByS_U(status, userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last seat office in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching seat office
	 * @throws com.seatoffice.NoSuchSeatOfficeException if a matching seat office could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatOffice findByS_U_Last(int status, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSeatOfficeException, SystemException {
		SeatOffice seatOffice = fetchByS_U_Last(status, userId,
				orderByComparator);

		if (seatOffice != null) {
			return seatOffice;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSeatOfficeException(msg.toString());
	}

	/**
	 * Returns the last seat office in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching seat office, or <code>null</code> if a matching seat office could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatOffice fetchByS_U_Last(int status, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByS_U(status, userId);

		if (count == 0) {
			return null;
		}

		List<SeatOffice> list = findByS_U(status, userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the seat offices before and after the current seat office in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param seatId the primary key of the current seat office
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next seat office
	 * @throws com.seatoffice.NoSuchSeatOfficeException if a seat office with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatOffice[] findByS_U_PrevAndNext(long seatId, int status,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchSeatOfficeException, SystemException {
		SeatOffice seatOffice = findByPrimaryKey(seatId);

		Session session = null;

		try {
			session = openSession();

			SeatOffice[] array = new SeatOfficeImpl[3];

			array[0] = getByS_U_PrevAndNext(session, seatOffice, status,
					userId, orderByComparator, true);

			array[1] = seatOffice;

			array[2] = getByS_U_PrevAndNext(session, seatOffice, status,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SeatOffice getByS_U_PrevAndNext(Session session,
		SeatOffice seatOffice, int status, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SEATOFFICE_WHERE);

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
			query.append(SeatOfficeModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(seatOffice);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SeatOffice> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the seat offices where status = &#63; and userId = &#63; from the database.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByS_U(int status, long userId) throws SystemException {
		for (SeatOffice seatOffice : findByS_U(status, userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(seatOffice);
		}
	}

	/**
	 * Returns the number of seat offices where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @return the number of matching seat offices
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

			query.append(_SQL_COUNT_SEATOFFICE_WHERE);

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

	private static final String _FINDER_COLUMN_S_U_STATUS_2 = "seatOffice.status = ? AND ";
	private static final String _FINDER_COLUMN_S_U_USERID_2 = "seatOffice.userId = ?";

	public SeatOfficePersistenceImpl() {
		setModelClass(SeatOffice.class);
	}

	/**
	 * Caches the seat office in the entity cache if it is enabled.
	 *
	 * @param seatOffice the seat office
	 */
	@Override
	public void cacheResult(SeatOffice seatOffice) {
		EntityCacheUtil.putResult(SeatOfficeModelImpl.ENTITY_CACHE_ENABLED,
			SeatOfficeImpl.class, seatOffice.getPrimaryKey(), seatOffice);

		seatOffice.resetOriginalValues();
	}

	/**
	 * Caches the seat offices in the entity cache if it is enabled.
	 *
	 * @param seatOffices the seat offices
	 */
	@Override
	public void cacheResult(List<SeatOffice> seatOffices) {
		for (SeatOffice seatOffice : seatOffices) {
			if (EntityCacheUtil.getResult(
						SeatOfficeModelImpl.ENTITY_CACHE_ENABLED,
						SeatOfficeImpl.class, seatOffice.getPrimaryKey()) == null) {
				cacheResult(seatOffice);
			}
			else {
				seatOffice.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all seat offices.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SeatOfficeImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SeatOfficeImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the seat office.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SeatOffice seatOffice) {
		EntityCacheUtil.removeResult(SeatOfficeModelImpl.ENTITY_CACHE_ENABLED,
			SeatOfficeImpl.class, seatOffice.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SeatOffice> seatOffices) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SeatOffice seatOffice : seatOffices) {
			EntityCacheUtil.removeResult(SeatOfficeModelImpl.ENTITY_CACHE_ENABLED,
				SeatOfficeImpl.class, seatOffice.getPrimaryKey());
		}
	}

	/**
	 * Creates a new seat office with the primary key. Does not add the seat office to the database.
	 *
	 * @param seatId the primary key for the new seat office
	 * @return the new seat office
	 */
	@Override
	public SeatOffice create(long seatId) {
		SeatOffice seatOffice = new SeatOfficeImpl();

		seatOffice.setNew(true);
		seatOffice.setPrimaryKey(seatId);

		return seatOffice;
	}

	/**
	 * Removes the seat office with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param seatId the primary key of the seat office
	 * @return the seat office that was removed
	 * @throws com.seatoffice.NoSuchSeatOfficeException if a seat office with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatOffice remove(long seatId)
		throws NoSuchSeatOfficeException, SystemException {
		return remove((Serializable)seatId);
	}

	/**
	 * Removes the seat office with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the seat office
	 * @return the seat office that was removed
	 * @throws com.seatoffice.NoSuchSeatOfficeException if a seat office with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatOffice remove(Serializable primaryKey)
		throws NoSuchSeatOfficeException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SeatOffice seatOffice = (SeatOffice)session.get(SeatOfficeImpl.class,
					primaryKey);

			if (seatOffice == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSeatOfficeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(seatOffice);
		}
		catch (NoSuchSeatOfficeException nsee) {
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
	protected SeatOffice removeImpl(SeatOffice seatOffice)
		throws SystemException {
		seatOffice = toUnwrappedModel(seatOffice);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(seatOffice)) {
				seatOffice = (SeatOffice)session.get(SeatOfficeImpl.class,
						seatOffice.getPrimaryKeyObj());
			}

			if (seatOffice != null) {
				session.delete(seatOffice);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (seatOffice != null) {
			clearCache(seatOffice);
		}

		return seatOffice;
	}

	@Override
	public SeatOffice updateImpl(com.seatoffice.model.SeatOffice seatOffice)
		throws SystemException {
		seatOffice = toUnwrappedModel(seatOffice);

		boolean isNew = seatOffice.isNew();

		SeatOfficeModelImpl seatOfficeModelImpl = (SeatOfficeModelImpl)seatOffice;

		Session session = null;

		try {
			session = openSession();

			if (seatOffice.isNew()) {
				session.save(seatOffice);

				seatOffice.setNew(false);
			}
			else {
				session.merge(seatOffice);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SeatOfficeModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((seatOfficeModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						seatOfficeModelImpl.getOriginalStatus(),
						seatOfficeModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U,
					args);

				args = new Object[] {
						seatOfficeModelImpl.getStatus(),
						seatOfficeModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U,
					args);
			}
		}

		EntityCacheUtil.putResult(SeatOfficeModelImpl.ENTITY_CACHE_ENABLED,
			SeatOfficeImpl.class, seatOffice.getPrimaryKey(), seatOffice);

		return seatOffice;
	}

	protected SeatOffice toUnwrappedModel(SeatOffice seatOffice) {
		if (seatOffice instanceof SeatOfficeImpl) {
			return seatOffice;
		}

		SeatOfficeImpl seatOfficeImpl = new SeatOfficeImpl();

		seatOfficeImpl.setNew(seatOffice.isNew());
		seatOfficeImpl.setPrimaryKey(seatOffice.getPrimaryKey());

		seatOfficeImpl.setSeatId(seatOffice.getSeatId());
		seatOfficeImpl.setGroupId(seatOffice.getGroupId());
		seatOfficeImpl.setUserId(seatOffice.getUserId());
		seatOfficeImpl.setUserName(seatOffice.getUserName());
		seatOfficeImpl.setCreateDate(seatOffice.getCreateDate());
		seatOfficeImpl.setModifiedDate(seatOffice.getModifiedDate());
		seatOfficeImpl.setCompanyId(seatOffice.getCompanyId());
		seatOfficeImpl.setTicketNo(seatOffice.getTicketNo());
		seatOfficeImpl.setStaffName(seatOffice.getStaffName());
		seatOfficeImpl.setStaffCode(seatOffice.getStaffCode());
		seatOfficeImpl.setCompanyName(seatOffice.getCompanyName());
		seatOfficeImpl.setDivision(seatOffice.getDivision());
		seatOfficeImpl.setDepartment(seatOffice.getDepartment());
		seatOfficeImpl.setCostCenter(seatOffice.getCostCenter());
		seatOfficeImpl.setOfficePhone(seatOffice.getOfficePhone());
		seatOfficeImpl.setMobilePhone(seatOffice.getMobilePhone());
		seatOfficeImpl.setOfficeSite(seatOffice.getOfficeSite());
		seatOfficeImpl.setCurrentCategory(seatOffice.getCurrentCategory());
		seatOfficeImpl.setCurrentSeatNo(seatOffice.getCurrentSeatNo());
		seatOfficeImpl.setMovingDate(seatOffice.getMovingDate());
		seatOfficeImpl.setExpectedSeatNo(seatOffice.getExpectedSeatNo());
		seatOfficeImpl.setReasonForChange(seatOffice.getReasonForChange());
		seatOfficeImpl.setOfficeKey(seatOffice.isOfficeKey());
		seatOfficeImpl.setPlant(seatOffice.isPlant());
		seatOfficeImpl.setTelephoneAndExtNo(seatOffice.isTelephoneAndExtNo());
		seatOfficeImpl.setNamePlate(seatOffice.isNamePlate());
		seatOfficeImpl.setCabinet(seatOffice.isCabinet());
		seatOfficeImpl.setIsOnBehalfOf(seatOffice.isIsOnBehalfOf());
		seatOfficeImpl.setNowCategory(seatOffice.getNowCategory());
		seatOfficeImpl.setNewSeatNo(seatOffice.getNewSeatNo());
		seatOfficeImpl.setWorkspaceId(seatOffice.getWorkspaceId());
		seatOfficeImpl.setSeatStatus(seatOffice.getSeatStatus());
		seatOfficeImpl.setSg(seatOffice.getSg());
		seatOfficeImpl.setLeadingMark(seatOffice.getLeadingMark());
		seatOfficeImpl.setPositionFlag(seatOffice.getPositionFlag());
		seatOfficeImpl.setIsApplicantAgent(seatOffice.isIsApplicantAgent());
		seatOfficeImpl.setIsApproverAgent(seatOffice.isIsApproverAgent());
		seatOfficeImpl.setCandidateName(seatOffice.getCandidateName());
		seatOfficeImpl.setDesiredStartingDate(seatOffice.getDesiredStartingDate());
		seatOfficeImpl.setComments(seatOffice.getComments());
		seatOfficeImpl.setContractType(seatOffice.getContractType());
		seatOfficeImpl.setProcessType(seatOffice.getProcessType());
		seatOfficeImpl.setSubProcessType(seatOffice.getSubProcessType());
		seatOfficeImpl.setStatus(seatOffice.getStatus());
		seatOfficeImpl.setStatusByUserId(seatOffice.getStatusByUserId());
		seatOfficeImpl.setStatusByUserName(seatOffice.getStatusByUserName());
		seatOfficeImpl.setStatusDate(seatOffice.getStatusDate());

		return seatOfficeImpl;
	}

	/**
	 * Returns the seat office with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the seat office
	 * @return the seat office
	 * @throws com.seatoffice.NoSuchSeatOfficeException if a seat office with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatOffice findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSeatOfficeException, SystemException {
		SeatOffice seatOffice = fetchByPrimaryKey(primaryKey);

		if (seatOffice == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSeatOfficeException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return seatOffice;
	}

	/**
	 * Returns the seat office with the primary key or throws a {@link com.seatoffice.NoSuchSeatOfficeException} if it could not be found.
	 *
	 * @param seatId the primary key of the seat office
	 * @return the seat office
	 * @throws com.seatoffice.NoSuchSeatOfficeException if a seat office with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatOffice findByPrimaryKey(long seatId)
		throws NoSuchSeatOfficeException, SystemException {
		return findByPrimaryKey((Serializable)seatId);
	}

	/**
	 * Returns the seat office with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the seat office
	 * @return the seat office, or <code>null</code> if a seat office with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatOffice fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SeatOffice seatOffice = (SeatOffice)EntityCacheUtil.getResult(SeatOfficeModelImpl.ENTITY_CACHE_ENABLED,
				SeatOfficeImpl.class, primaryKey);

		if (seatOffice == _nullSeatOffice) {
			return null;
		}

		if (seatOffice == null) {
			Session session = null;

			try {
				session = openSession();

				seatOffice = (SeatOffice)session.get(SeatOfficeImpl.class,
						primaryKey);

				if (seatOffice != null) {
					cacheResult(seatOffice);
				}
				else {
					EntityCacheUtil.putResult(SeatOfficeModelImpl.ENTITY_CACHE_ENABLED,
						SeatOfficeImpl.class, primaryKey, _nullSeatOffice);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SeatOfficeModelImpl.ENTITY_CACHE_ENABLED,
					SeatOfficeImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return seatOffice;
	}

	/**
	 * Returns the seat office with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param seatId the primary key of the seat office
	 * @return the seat office, or <code>null</code> if a seat office with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatOffice fetchByPrimaryKey(long seatId) throws SystemException {
		return fetchByPrimaryKey((Serializable)seatId);
	}

	/**
	 * Returns all the seat offices.
	 *
	 * @return the seat offices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SeatOffice> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the seat offices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.seatoffice.model.impl.SeatOfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of seat offices
	 * @param end the upper bound of the range of seat offices (not inclusive)
	 * @return the range of seat offices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SeatOffice> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the seat offices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.seatoffice.model.impl.SeatOfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of seat offices
	 * @param end the upper bound of the range of seat offices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of seat offices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SeatOffice> findAll(int start, int end,
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

		List<SeatOffice> list = (List<SeatOffice>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SEATOFFICE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SEATOFFICE;

				if (pagination) {
					sql = sql.concat(SeatOfficeModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SeatOffice>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SeatOffice>(list);
				}
				else {
					list = (List<SeatOffice>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the seat offices from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SeatOffice seatOffice : findAll()) {
			remove(seatOffice);
		}
	}

	/**
	 * Returns the number of seat offices.
	 *
	 * @return the number of seat offices
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

				Query q = session.createQuery(_SQL_COUNT_SEATOFFICE);

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
	 * Initializes the seat office persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.seatoffice.model.SeatOffice")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SeatOffice>> listenersList = new ArrayList<ModelListener<SeatOffice>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SeatOffice>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SeatOfficeImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SEATOFFICE = "SELECT seatOffice FROM SeatOffice seatOffice";
	private static final String _SQL_SELECT_SEATOFFICE_WHERE = "SELECT seatOffice FROM SeatOffice seatOffice WHERE ";
	private static final String _SQL_COUNT_SEATOFFICE = "SELECT COUNT(seatOffice) FROM SeatOffice seatOffice";
	private static final String _SQL_COUNT_SEATOFFICE_WHERE = "SELECT COUNT(seatOffice) FROM SeatOffice seatOffice WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "seatOffice.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SeatOffice exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SeatOffice exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SeatOfficePersistenceImpl.class);
	private static SeatOffice _nullSeatOffice = new SeatOfficeImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SeatOffice> toCacheModel() {
				return _nullSeatOfficeCacheModel;
			}
		};

	private static CacheModel<SeatOffice> _nullSeatOfficeCacheModel = new CacheModel<SeatOffice>() {
			@Override
			public SeatOffice toEntityModel() {
				return _nullSeatOffice;
			}
		};
}