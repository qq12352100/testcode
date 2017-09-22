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

package com.company.car.service.persistence;

import com.company.car.NoSuchFirstCompanyCarException;
import com.company.car.model.FirstCompanyCar;
import com.company.car.model.impl.FirstCompanyCarImpl;
import com.company.car.model.impl.FirstCompanyCarModelImpl;

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
 * The persistence implementation for the first company car service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FirstCompanyCarPersistence
 * @see FirstCompanyCarUtil
 * @generated
 */
public class FirstCompanyCarPersistenceImpl extends BasePersistenceImpl<FirstCompanyCar>
	implements FirstCompanyCarPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link FirstCompanyCarUtil} to access the first company car persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = FirstCompanyCarImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(FirstCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
			FirstCompanyCarModelImpl.FINDER_CACHE_ENABLED,
			FirstCompanyCarImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(FirstCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
			FirstCompanyCarModelImpl.FINDER_CACHE_ENABLED,
			FirstCompanyCarImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(FirstCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
			FirstCompanyCarModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_S_U = new FinderPath(FirstCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
			FirstCompanyCarModelImpl.FINDER_CACHE_ENABLED,
			FirstCompanyCarImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByS_U",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U = new FinderPath(FirstCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
			FirstCompanyCarModelImpl.FINDER_CACHE_ENABLED,
			FirstCompanyCarImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_U",
			new String[] { Integer.class.getName(), Long.class.getName() },
			FirstCompanyCarModelImpl.STATUS_COLUMN_BITMASK |
			FirstCompanyCarModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_S_U = new FinderPath(FirstCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
			FirstCompanyCarModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_U",
			new String[] { Integer.class.getName(), Long.class.getName() });

	/**
	 * Returns all the first company cars where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @return the matching first company cars
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FirstCompanyCar> findByS_U(int status, long userId)
		throws SystemException {
		return findByS_U(status, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the first company cars where status = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.FirstCompanyCarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param start the lower bound of the range of first company cars
	 * @param end the upper bound of the range of first company cars (not inclusive)
	 * @return the range of matching first company cars
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FirstCompanyCar> findByS_U(int status, long userId, int start,
		int end) throws SystemException {
		return findByS_U(status, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the first company cars where status = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.FirstCompanyCarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param start the lower bound of the range of first company cars
	 * @param end the upper bound of the range of first company cars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching first company cars
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FirstCompanyCar> findByS_U(int status, long userId, int start,
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

		List<FirstCompanyCar> list = (List<FirstCompanyCar>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (FirstCompanyCar firstCompanyCar : list) {
				if ((status != firstCompanyCar.getStatus()) ||
						(userId != firstCompanyCar.getUserId())) {
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

			query.append(_SQL_SELECT_FIRSTCOMPANYCAR_WHERE);

			query.append(_FINDER_COLUMN_S_U_STATUS_2);

			query.append(_FINDER_COLUMN_S_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(FirstCompanyCarModelImpl.ORDER_BY_JPQL);
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
					list = (List<FirstCompanyCar>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FirstCompanyCar>(list);
				}
				else {
					list = (List<FirstCompanyCar>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first first company car in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching first company car
	 * @throws com.company.car.NoSuchFirstCompanyCarException if a matching first company car could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FirstCompanyCar findByS_U_First(int status, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchFirstCompanyCarException, SystemException {
		FirstCompanyCar firstCompanyCar = fetchByS_U_First(status, userId,
				orderByComparator);

		if (firstCompanyCar != null) {
			return firstCompanyCar;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFirstCompanyCarException(msg.toString());
	}

	/**
	 * Returns the first first company car in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching first company car, or <code>null</code> if a matching first company car could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FirstCompanyCar fetchByS_U_First(int status, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<FirstCompanyCar> list = findByS_U(status, userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last first company car in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching first company car
	 * @throws com.company.car.NoSuchFirstCompanyCarException if a matching first company car could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FirstCompanyCar findByS_U_Last(int status, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchFirstCompanyCarException, SystemException {
		FirstCompanyCar firstCompanyCar = fetchByS_U_Last(status, userId,
				orderByComparator);

		if (firstCompanyCar != null) {
			return firstCompanyCar;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchFirstCompanyCarException(msg.toString());
	}

	/**
	 * Returns the last first company car in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching first company car, or <code>null</code> if a matching first company car could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FirstCompanyCar fetchByS_U_Last(int status, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByS_U(status, userId);

		if (count == 0) {
			return null;
		}

		List<FirstCompanyCar> list = findByS_U(status, userId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the first company cars before and after the current first company car in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param firstCompanyCarId the primary key of the current first company car
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next first company car
	 * @throws com.company.car.NoSuchFirstCompanyCarException if a first company car with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FirstCompanyCar[] findByS_U_PrevAndNext(long firstCompanyCarId,
		int status, long userId, OrderByComparator orderByComparator)
		throws NoSuchFirstCompanyCarException, SystemException {
		FirstCompanyCar firstCompanyCar = findByPrimaryKey(firstCompanyCarId);

		Session session = null;

		try {
			session = openSession();

			FirstCompanyCar[] array = new FirstCompanyCarImpl[3];

			array[0] = getByS_U_PrevAndNext(session, firstCompanyCar, status,
					userId, orderByComparator, true);

			array[1] = firstCompanyCar;

			array[2] = getByS_U_PrevAndNext(session, firstCompanyCar, status,
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

	protected FirstCompanyCar getByS_U_PrevAndNext(Session session,
		FirstCompanyCar firstCompanyCar, int status, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_FIRSTCOMPANYCAR_WHERE);

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
			query.append(FirstCompanyCarModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(firstCompanyCar);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<FirstCompanyCar> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the first company cars where status = &#63; and userId = &#63; from the database.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByS_U(int status, long userId) throws SystemException {
		for (FirstCompanyCar firstCompanyCar : findByS_U(status, userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(firstCompanyCar);
		}
	}

	/**
	 * Returns the number of first company cars where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @return the number of matching first company cars
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

			query.append(_SQL_COUNT_FIRSTCOMPANYCAR_WHERE);

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

	private static final String _FINDER_COLUMN_S_U_STATUS_2 = "firstCompanyCar.status = ? AND ";
	private static final String _FINDER_COLUMN_S_U_USERID_2 = "firstCompanyCar.userId = ?";

	public FirstCompanyCarPersistenceImpl() {
		setModelClass(FirstCompanyCar.class);
	}

	/**
	 * Caches the first company car in the entity cache if it is enabled.
	 *
	 * @param firstCompanyCar the first company car
	 */
	@Override
	public void cacheResult(FirstCompanyCar firstCompanyCar) {
		EntityCacheUtil.putResult(FirstCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
			FirstCompanyCarImpl.class, firstCompanyCar.getPrimaryKey(),
			firstCompanyCar);

		firstCompanyCar.resetOriginalValues();
	}

	/**
	 * Caches the first company cars in the entity cache if it is enabled.
	 *
	 * @param firstCompanyCars the first company cars
	 */
	@Override
	public void cacheResult(List<FirstCompanyCar> firstCompanyCars) {
		for (FirstCompanyCar firstCompanyCar : firstCompanyCars) {
			if (EntityCacheUtil.getResult(
						FirstCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
						FirstCompanyCarImpl.class,
						firstCompanyCar.getPrimaryKey()) == null) {
				cacheResult(firstCompanyCar);
			}
			else {
				firstCompanyCar.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all first company cars.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(FirstCompanyCarImpl.class.getName());
		}

		EntityCacheUtil.clearCache(FirstCompanyCarImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the first company car.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FirstCompanyCar firstCompanyCar) {
		EntityCacheUtil.removeResult(FirstCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
			FirstCompanyCarImpl.class, firstCompanyCar.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<FirstCompanyCar> firstCompanyCars) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (FirstCompanyCar firstCompanyCar : firstCompanyCars) {
			EntityCacheUtil.removeResult(FirstCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
				FirstCompanyCarImpl.class, firstCompanyCar.getPrimaryKey());
		}
	}

	/**
	 * Creates a new first company car with the primary key. Does not add the first company car to the database.
	 *
	 * @param firstCompanyCarId the primary key for the new first company car
	 * @return the new first company car
	 */
	@Override
	public FirstCompanyCar create(long firstCompanyCarId) {
		FirstCompanyCar firstCompanyCar = new FirstCompanyCarImpl();

		firstCompanyCar.setNew(true);
		firstCompanyCar.setPrimaryKey(firstCompanyCarId);

		return firstCompanyCar;
	}

	/**
	 * Removes the first company car with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param firstCompanyCarId the primary key of the first company car
	 * @return the first company car that was removed
	 * @throws com.company.car.NoSuchFirstCompanyCarException if a first company car with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FirstCompanyCar remove(long firstCompanyCarId)
		throws NoSuchFirstCompanyCarException, SystemException {
		return remove((Serializable)firstCompanyCarId);
	}

	/**
	 * Removes the first company car with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the first company car
	 * @return the first company car that was removed
	 * @throws com.company.car.NoSuchFirstCompanyCarException if a first company car with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FirstCompanyCar remove(Serializable primaryKey)
		throws NoSuchFirstCompanyCarException, SystemException {
		Session session = null;

		try {
			session = openSession();

			FirstCompanyCar firstCompanyCar = (FirstCompanyCar)session.get(FirstCompanyCarImpl.class,
					primaryKey);

			if (firstCompanyCar == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFirstCompanyCarException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(firstCompanyCar);
		}
		catch (NoSuchFirstCompanyCarException nsee) {
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
	protected FirstCompanyCar removeImpl(FirstCompanyCar firstCompanyCar)
		throws SystemException {
		firstCompanyCar = toUnwrappedModel(firstCompanyCar);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(firstCompanyCar)) {
				firstCompanyCar = (FirstCompanyCar)session.get(FirstCompanyCarImpl.class,
						firstCompanyCar.getPrimaryKeyObj());
			}

			if (firstCompanyCar != null) {
				session.delete(firstCompanyCar);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (firstCompanyCar != null) {
			clearCache(firstCompanyCar);
		}

		return firstCompanyCar;
	}

	@Override
	public FirstCompanyCar updateImpl(
		com.company.car.model.FirstCompanyCar firstCompanyCar)
		throws SystemException {
		firstCompanyCar = toUnwrappedModel(firstCompanyCar);

		boolean isNew = firstCompanyCar.isNew();

		FirstCompanyCarModelImpl firstCompanyCarModelImpl = (FirstCompanyCarModelImpl)firstCompanyCar;

		Session session = null;

		try {
			session = openSession();

			if (firstCompanyCar.isNew()) {
				session.save(firstCompanyCar);

				firstCompanyCar.setNew(false);
			}
			else {
				session.merge(firstCompanyCar);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !FirstCompanyCarModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((firstCompanyCarModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						firstCompanyCarModelImpl.getOriginalStatus(),
						firstCompanyCarModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U,
					args);

				args = new Object[] {
						firstCompanyCarModelImpl.getStatus(),
						firstCompanyCarModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U,
					args);
			}
		}

		EntityCacheUtil.putResult(FirstCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
			FirstCompanyCarImpl.class, firstCompanyCar.getPrimaryKey(),
			firstCompanyCar);

		return firstCompanyCar;
	}

	protected FirstCompanyCar toUnwrappedModel(FirstCompanyCar firstCompanyCar) {
		if (firstCompanyCar instanceof FirstCompanyCarImpl) {
			return firstCompanyCar;
		}

		FirstCompanyCarImpl firstCompanyCarImpl = new FirstCompanyCarImpl();

		firstCompanyCarImpl.setNew(firstCompanyCar.isNew());
		firstCompanyCarImpl.setPrimaryKey(firstCompanyCar.getPrimaryKey());

		firstCompanyCarImpl.setFirstCompanyCarId(firstCompanyCar.getFirstCompanyCarId());
		firstCompanyCarImpl.setTicketNo(firstCompanyCar.getTicketNo());
		firstCompanyCarImpl.setGroupId(firstCompanyCar.getGroupId());
		firstCompanyCarImpl.setUserId(firstCompanyCar.getUserId());
		firstCompanyCarImpl.setUserName(firstCompanyCar.getUserName());
		firstCompanyCarImpl.setCreateDate(firstCompanyCar.getCreateDate());
		firstCompanyCarImpl.setModifiedDate(firstCompanyCar.getModifiedDate());
		firstCompanyCarImpl.setSubmittedDate(firstCompanyCar.getSubmittedDate());
		firstCompanyCarImpl.setCompanyId(firstCompanyCar.getCompanyId());
		firstCompanyCarImpl.setName(firstCompanyCar.getName());
		firstCompanyCarImpl.setStaffCode(firstCompanyCar.getStaffCode());
		firstCompanyCarImpl.setDivision(firstCompanyCar.getDivision());
		firstCompanyCarImpl.setDepartment(firstCompanyCar.getDepartment());
		firstCompanyCarImpl.setStatus(firstCompanyCar.getStatus());
		firstCompanyCarImpl.setStatusByUserId(firstCompanyCar.getStatusByUserId());
		firstCompanyCarImpl.setStatusByUserName(firstCompanyCar.getStatusByUserName());
		firstCompanyCarImpl.setCompanyName(firstCompanyCar.getCompanyName());
		firstCompanyCarImpl.setStatusDate(firstCompanyCar.getStatusDate());
		firstCompanyCarImpl.setContactNo(firstCompanyCar.getContactNo());
		firstCompanyCarImpl.setWorkingLocation(firstCompanyCar.getWorkingLocation());
		firstCompanyCarImpl.setOfficeSite(firstCompanyCar.getOfficeSite());
		firstCompanyCarImpl.setCurrentCarModel(firstCompanyCar.getCurrentCarModel());
		firstCompanyCarImpl.setCurrentCarColor(firstCompanyCar.getCurrentCarColor());
		firstCompanyCarImpl.setCurrentPlateNumber(firstCompanyCar.getCurrentPlateNumber());
		firstCompanyCarImpl.setAcquiringDate(firstCompanyCar.getAcquiringDate());
		firstCompanyCarImpl.setExpectedCarModel(firstCompanyCar.getExpectedCarModel());
		firstCompanyCarImpl.setExpectedCarColor(firstCompanyCar.getExpectedCarColor());
		firstCompanyCarImpl.setExpectedLastPlateNumber(firstCompanyCar.getExpectedLastPlateNumber());
		firstCompanyCarImpl.setPositionCostCenterId(firstCompanyCar.getPositionCostCenterId());
		firstCompanyCarImpl.setEmployeeGroupId(firstCompanyCar.getEmployeeGroupId());
		firstCompanyCarImpl.setContractEndDate(firstCompanyCar.getContractEndDate());
		firstCompanyCarImpl.setMobilePhone(firstCompanyCar.getMobilePhone());
		firstCompanyCarImpl.setOfficePhone(firstCompanyCar.getOfficePhone());
		firstCompanyCarImpl.setEmail(firstCompanyCar.getEmail());
		firstCompanyCarImpl.setIsApplicantAgent(firstCompanyCar.isIsApplicantAgent());
		firstCompanyCarImpl.setIsApproverAgent(firstCompanyCar.isIsApproverAgent());
		firstCompanyCarImpl.setDrivingLicenseInformation(firstCompanyCar.getDrivingLicenseInformation());
		firstCompanyCarImpl.setEstimatedObtainingDate(firstCompanyCar.getEstimatedObtainingDate());
		firstCompanyCarImpl.setComments(firstCompanyCar.getComments());
		firstCompanyCarImpl.setChildrenNumber(firstCompanyCar.getChildrenNumber());
		firstCompanyCarImpl.setProcessType(firstCompanyCar.getProcessType());
		firstCompanyCarImpl.setSubType(firstCompanyCar.getSubType());

		return firstCompanyCarImpl;
	}

	/**
	 * Returns the first company car with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the first company car
	 * @return the first company car
	 * @throws com.company.car.NoSuchFirstCompanyCarException if a first company car with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FirstCompanyCar findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFirstCompanyCarException, SystemException {
		FirstCompanyCar firstCompanyCar = fetchByPrimaryKey(primaryKey);

		if (firstCompanyCar == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFirstCompanyCarException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return firstCompanyCar;
	}

	/**
	 * Returns the first company car with the primary key or throws a {@link com.company.car.NoSuchFirstCompanyCarException} if it could not be found.
	 *
	 * @param firstCompanyCarId the primary key of the first company car
	 * @return the first company car
	 * @throws com.company.car.NoSuchFirstCompanyCarException if a first company car with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FirstCompanyCar findByPrimaryKey(long firstCompanyCarId)
		throws NoSuchFirstCompanyCarException, SystemException {
		return findByPrimaryKey((Serializable)firstCompanyCarId);
	}

	/**
	 * Returns the first company car with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the first company car
	 * @return the first company car, or <code>null</code> if a first company car with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FirstCompanyCar fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		FirstCompanyCar firstCompanyCar = (FirstCompanyCar)EntityCacheUtil.getResult(FirstCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
				FirstCompanyCarImpl.class, primaryKey);

		if (firstCompanyCar == _nullFirstCompanyCar) {
			return null;
		}

		if (firstCompanyCar == null) {
			Session session = null;

			try {
				session = openSession();

				firstCompanyCar = (FirstCompanyCar)session.get(FirstCompanyCarImpl.class,
						primaryKey);

				if (firstCompanyCar != null) {
					cacheResult(firstCompanyCar);
				}
				else {
					EntityCacheUtil.putResult(FirstCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
						FirstCompanyCarImpl.class, primaryKey,
						_nullFirstCompanyCar);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(FirstCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
					FirstCompanyCarImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return firstCompanyCar;
	}

	/**
	 * Returns the first company car with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param firstCompanyCarId the primary key of the first company car
	 * @return the first company car, or <code>null</code> if a first company car with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public FirstCompanyCar fetchByPrimaryKey(long firstCompanyCarId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)firstCompanyCarId);
	}

	/**
	 * Returns all the first company cars.
	 *
	 * @return the first company cars
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FirstCompanyCar> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the first company cars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.FirstCompanyCarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of first company cars
	 * @param end the upper bound of the range of first company cars (not inclusive)
	 * @return the range of first company cars
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FirstCompanyCar> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the first company cars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.FirstCompanyCarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of first company cars
	 * @param end the upper bound of the range of first company cars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of first company cars
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<FirstCompanyCar> findAll(int start, int end,
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

		List<FirstCompanyCar> list = (List<FirstCompanyCar>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_FIRSTCOMPANYCAR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_FIRSTCOMPANYCAR;

				if (pagination) {
					sql = sql.concat(FirstCompanyCarModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<FirstCompanyCar>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<FirstCompanyCar>(list);
				}
				else {
					list = (List<FirstCompanyCar>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the first company cars from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (FirstCompanyCar firstCompanyCar : findAll()) {
			remove(firstCompanyCar);
		}
	}

	/**
	 * Returns the number of first company cars.
	 *
	 * @return the number of first company cars
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

				Query q = session.createQuery(_SQL_COUNT_FIRSTCOMPANYCAR);

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
	 * Initializes the first company car persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.company.car.model.FirstCompanyCar")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<FirstCompanyCar>> listenersList = new ArrayList<ModelListener<FirstCompanyCar>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<FirstCompanyCar>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(FirstCompanyCarImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_FIRSTCOMPANYCAR = "SELECT firstCompanyCar FROM FirstCompanyCar firstCompanyCar";
	private static final String _SQL_SELECT_FIRSTCOMPANYCAR_WHERE = "SELECT firstCompanyCar FROM FirstCompanyCar firstCompanyCar WHERE ";
	private static final String _SQL_COUNT_FIRSTCOMPANYCAR = "SELECT COUNT(firstCompanyCar) FROM FirstCompanyCar firstCompanyCar";
	private static final String _SQL_COUNT_FIRSTCOMPANYCAR_WHERE = "SELECT COUNT(firstCompanyCar) FROM FirstCompanyCar firstCompanyCar WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "firstCompanyCar.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No FirstCompanyCar exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No FirstCompanyCar exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(FirstCompanyCarPersistenceImpl.class);
	private static FirstCompanyCar _nullFirstCompanyCar = new FirstCompanyCarImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<FirstCompanyCar> toCacheModel() {
				return _nullFirstCompanyCarCacheModel;
			}
		};

	private static CacheModel<FirstCompanyCar> _nullFirstCompanyCarCacheModel = new CacheModel<FirstCompanyCar>() {
			@Override
			public FirstCompanyCar toEntityModel() {
				return _nullFirstCompanyCar;
			}
		};
}