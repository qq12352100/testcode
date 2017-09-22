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

import com.company.car.NoSuchSecondCompanyCarException;
import com.company.car.model.SecondCompanyCar;
import com.company.car.model.impl.SecondCompanyCarImpl;
import com.company.car.model.impl.SecondCompanyCarModelImpl;

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
 * The persistence implementation for the second company car service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SecondCompanyCarPersistence
 * @see SecondCompanyCarUtil
 * @generated
 */
public class SecondCompanyCarPersistenceImpl extends BasePersistenceImpl<SecondCompanyCar>
	implements SecondCompanyCarPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SecondCompanyCarUtil} to access the second company car persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SecondCompanyCarImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SecondCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
			SecondCompanyCarModelImpl.FINDER_CACHE_ENABLED,
			SecondCompanyCarImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SecondCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
			SecondCompanyCarModelImpl.FINDER_CACHE_ENABLED,
			SecondCompanyCarImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SecondCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
			SecondCompanyCarModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_S_U = new FinderPath(SecondCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
			SecondCompanyCarModelImpl.FINDER_CACHE_ENABLED,
			SecondCompanyCarImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByS_U",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U = new FinderPath(SecondCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
			SecondCompanyCarModelImpl.FINDER_CACHE_ENABLED,
			SecondCompanyCarImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_U",
			new String[] { Integer.class.getName(), Long.class.getName() },
			SecondCompanyCarModelImpl.STATUS_COLUMN_BITMASK |
			SecondCompanyCarModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_S_U = new FinderPath(SecondCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
			SecondCompanyCarModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_U",
			new String[] { Integer.class.getName(), Long.class.getName() });

	/**
	 * Returns all the second company cars where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @return the matching second company cars
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SecondCompanyCar> findByS_U(int status, long userId)
		throws SystemException {
		return findByS_U(status, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the second company cars where status = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.SecondCompanyCarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param start the lower bound of the range of second company cars
	 * @param end the upper bound of the range of second company cars (not inclusive)
	 * @return the range of matching second company cars
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SecondCompanyCar> findByS_U(int status, long userId, int start,
		int end) throws SystemException {
		return findByS_U(status, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the second company cars where status = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.SecondCompanyCarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param start the lower bound of the range of second company cars
	 * @param end the upper bound of the range of second company cars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching second company cars
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SecondCompanyCar> findByS_U(int status, long userId, int start,
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

		List<SecondCompanyCar> list = (List<SecondCompanyCar>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SecondCompanyCar secondCompanyCar : list) {
				if ((status != secondCompanyCar.getStatus()) ||
						(userId != secondCompanyCar.getUserId())) {
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

			query.append(_SQL_SELECT_SECONDCOMPANYCAR_WHERE);

			query.append(_FINDER_COLUMN_S_U_STATUS_2);

			query.append(_FINDER_COLUMN_S_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SecondCompanyCarModelImpl.ORDER_BY_JPQL);
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
					list = (List<SecondCompanyCar>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SecondCompanyCar>(list);
				}
				else {
					list = (List<SecondCompanyCar>)QueryUtil.list(q,
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
	 * Returns the first second company car in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching second company car
	 * @throws com.company.car.NoSuchSecondCompanyCarException if a matching second company car could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SecondCompanyCar findByS_U_First(int status, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSecondCompanyCarException, SystemException {
		SecondCompanyCar secondCompanyCar = fetchByS_U_First(status, userId,
				orderByComparator);

		if (secondCompanyCar != null) {
			return secondCompanyCar;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSecondCompanyCarException(msg.toString());
	}

	/**
	 * Returns the first second company car in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching second company car, or <code>null</code> if a matching second company car could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SecondCompanyCar fetchByS_U_First(int status, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<SecondCompanyCar> list = findByS_U(status, userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last second company car in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching second company car
	 * @throws com.company.car.NoSuchSecondCompanyCarException if a matching second company car could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SecondCompanyCar findByS_U_Last(int status, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchSecondCompanyCarException, SystemException {
		SecondCompanyCar secondCompanyCar = fetchByS_U_Last(status, userId,
				orderByComparator);

		if (secondCompanyCar != null) {
			return secondCompanyCar;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSecondCompanyCarException(msg.toString());
	}

	/**
	 * Returns the last second company car in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching second company car, or <code>null</code> if a matching second company car could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SecondCompanyCar fetchByS_U_Last(int status, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByS_U(status, userId);

		if (count == 0) {
			return null;
		}

		List<SecondCompanyCar> list = findByS_U(status, userId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the second company cars before and after the current second company car in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param secondCompanyCarId the primary key of the current second company car
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next second company car
	 * @throws com.company.car.NoSuchSecondCompanyCarException if a second company car with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SecondCompanyCar[] findByS_U_PrevAndNext(long secondCompanyCarId,
		int status, long userId, OrderByComparator orderByComparator)
		throws NoSuchSecondCompanyCarException, SystemException {
		SecondCompanyCar secondCompanyCar = findByPrimaryKey(secondCompanyCarId);

		Session session = null;

		try {
			session = openSession();

			SecondCompanyCar[] array = new SecondCompanyCarImpl[3];

			array[0] = getByS_U_PrevAndNext(session, secondCompanyCar, status,
					userId, orderByComparator, true);

			array[1] = secondCompanyCar;

			array[2] = getByS_U_PrevAndNext(session, secondCompanyCar, status,
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

	protected SecondCompanyCar getByS_U_PrevAndNext(Session session,
		SecondCompanyCar secondCompanyCar, int status, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SECONDCOMPANYCAR_WHERE);

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
			query.append(SecondCompanyCarModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(secondCompanyCar);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SecondCompanyCar> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the second company cars where status = &#63; and userId = &#63; from the database.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByS_U(int status, long userId) throws SystemException {
		for (SecondCompanyCar secondCompanyCar : findByS_U(status, userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(secondCompanyCar);
		}
	}

	/**
	 * Returns the number of second company cars where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @return the number of matching second company cars
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

			query.append(_SQL_COUNT_SECONDCOMPANYCAR_WHERE);

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

	private static final String _FINDER_COLUMN_S_U_STATUS_2 = "secondCompanyCar.status = ? AND ";
	private static final String _FINDER_COLUMN_S_U_USERID_2 = "secondCompanyCar.userId = ?";

	public SecondCompanyCarPersistenceImpl() {
		setModelClass(SecondCompanyCar.class);
	}

	/**
	 * Caches the second company car in the entity cache if it is enabled.
	 *
	 * @param secondCompanyCar the second company car
	 */
	@Override
	public void cacheResult(SecondCompanyCar secondCompanyCar) {
		EntityCacheUtil.putResult(SecondCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
			SecondCompanyCarImpl.class, secondCompanyCar.getPrimaryKey(),
			secondCompanyCar);

		secondCompanyCar.resetOriginalValues();
	}

	/**
	 * Caches the second company cars in the entity cache if it is enabled.
	 *
	 * @param secondCompanyCars the second company cars
	 */
	@Override
	public void cacheResult(List<SecondCompanyCar> secondCompanyCars) {
		for (SecondCompanyCar secondCompanyCar : secondCompanyCars) {
			if (EntityCacheUtil.getResult(
						SecondCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
						SecondCompanyCarImpl.class,
						secondCompanyCar.getPrimaryKey()) == null) {
				cacheResult(secondCompanyCar);
			}
			else {
				secondCompanyCar.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all second company cars.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SecondCompanyCarImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SecondCompanyCarImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the second company car.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SecondCompanyCar secondCompanyCar) {
		EntityCacheUtil.removeResult(SecondCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
			SecondCompanyCarImpl.class, secondCompanyCar.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SecondCompanyCar> secondCompanyCars) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SecondCompanyCar secondCompanyCar : secondCompanyCars) {
			EntityCacheUtil.removeResult(SecondCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
				SecondCompanyCarImpl.class, secondCompanyCar.getPrimaryKey());
		}
	}

	/**
	 * Creates a new second company car with the primary key. Does not add the second company car to the database.
	 *
	 * @param secondCompanyCarId the primary key for the new second company car
	 * @return the new second company car
	 */
	@Override
	public SecondCompanyCar create(long secondCompanyCarId) {
		SecondCompanyCar secondCompanyCar = new SecondCompanyCarImpl();

		secondCompanyCar.setNew(true);
		secondCompanyCar.setPrimaryKey(secondCompanyCarId);

		return secondCompanyCar;
	}

	/**
	 * Removes the second company car with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param secondCompanyCarId the primary key of the second company car
	 * @return the second company car that was removed
	 * @throws com.company.car.NoSuchSecondCompanyCarException if a second company car with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SecondCompanyCar remove(long secondCompanyCarId)
		throws NoSuchSecondCompanyCarException, SystemException {
		return remove((Serializable)secondCompanyCarId);
	}

	/**
	 * Removes the second company car with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the second company car
	 * @return the second company car that was removed
	 * @throws com.company.car.NoSuchSecondCompanyCarException if a second company car with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SecondCompanyCar remove(Serializable primaryKey)
		throws NoSuchSecondCompanyCarException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SecondCompanyCar secondCompanyCar = (SecondCompanyCar)session.get(SecondCompanyCarImpl.class,
					primaryKey);

			if (secondCompanyCar == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSecondCompanyCarException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(secondCompanyCar);
		}
		catch (NoSuchSecondCompanyCarException nsee) {
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
	protected SecondCompanyCar removeImpl(SecondCompanyCar secondCompanyCar)
		throws SystemException {
		secondCompanyCar = toUnwrappedModel(secondCompanyCar);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(secondCompanyCar)) {
				secondCompanyCar = (SecondCompanyCar)session.get(SecondCompanyCarImpl.class,
						secondCompanyCar.getPrimaryKeyObj());
			}

			if (secondCompanyCar != null) {
				session.delete(secondCompanyCar);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (secondCompanyCar != null) {
			clearCache(secondCompanyCar);
		}

		return secondCompanyCar;
	}

	@Override
	public SecondCompanyCar updateImpl(
		com.company.car.model.SecondCompanyCar secondCompanyCar)
		throws SystemException {
		secondCompanyCar = toUnwrappedModel(secondCompanyCar);

		boolean isNew = secondCompanyCar.isNew();

		SecondCompanyCarModelImpl secondCompanyCarModelImpl = (SecondCompanyCarModelImpl)secondCompanyCar;

		Session session = null;

		try {
			session = openSession();

			if (secondCompanyCar.isNew()) {
				session.save(secondCompanyCar);

				secondCompanyCar.setNew(false);
			}
			else {
				session.merge(secondCompanyCar);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SecondCompanyCarModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((secondCompanyCarModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						secondCompanyCarModelImpl.getOriginalStatus(),
						secondCompanyCarModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U,
					args);

				args = new Object[] {
						secondCompanyCarModelImpl.getStatus(),
						secondCompanyCarModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U,
					args);
			}
		}

		EntityCacheUtil.putResult(SecondCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
			SecondCompanyCarImpl.class, secondCompanyCar.getPrimaryKey(),
			secondCompanyCar);

		return secondCompanyCar;
	}

	protected SecondCompanyCar toUnwrappedModel(
		SecondCompanyCar secondCompanyCar) {
		if (secondCompanyCar instanceof SecondCompanyCarImpl) {
			return secondCompanyCar;
		}

		SecondCompanyCarImpl secondCompanyCarImpl = new SecondCompanyCarImpl();

		secondCompanyCarImpl.setNew(secondCompanyCar.isNew());
		secondCompanyCarImpl.setPrimaryKey(secondCompanyCar.getPrimaryKey());

		secondCompanyCarImpl.setSecondCompanyCarId(secondCompanyCar.getSecondCompanyCarId());
		secondCompanyCarImpl.setTicketNo(secondCompanyCar.getTicketNo());
		secondCompanyCarImpl.setGroupId(secondCompanyCar.getGroupId());
		secondCompanyCarImpl.setUserId(secondCompanyCar.getUserId());
		secondCompanyCarImpl.setUserName(secondCompanyCar.getUserName());
		secondCompanyCarImpl.setCreateDate(secondCompanyCar.getCreateDate());
		secondCompanyCarImpl.setModifiedDate(secondCompanyCar.getModifiedDate());
		secondCompanyCarImpl.setSubmittedDate(secondCompanyCar.getSubmittedDate());
		secondCompanyCarImpl.setCompanyId(secondCompanyCar.getCompanyId());
		secondCompanyCarImpl.setName(secondCompanyCar.getName());
		secondCompanyCarImpl.setStaffCode(secondCompanyCar.getStaffCode());
		secondCompanyCarImpl.setDivision(secondCompanyCar.getDivision());
		secondCompanyCarImpl.setDepartment(secondCompanyCar.getDepartment());
		secondCompanyCarImpl.setStatus(secondCompanyCar.getStatus());
		secondCompanyCarImpl.setStatusByUserId(secondCompanyCar.getStatusByUserId());
		secondCompanyCarImpl.setStatusByUserName(secondCompanyCar.getStatusByUserName());
		secondCompanyCarImpl.setCompanyName(secondCompanyCar.getCompanyName());
		secondCompanyCarImpl.setStatusDate(secondCompanyCar.getStatusDate());
		secondCompanyCarImpl.setContactNo(secondCompanyCar.getContactNo());
		secondCompanyCarImpl.setWorkingLocation(secondCompanyCar.getWorkingLocation());
		secondCompanyCarImpl.setOfficeSite(secondCompanyCar.getOfficeSite());
		secondCompanyCarImpl.setCurrentCarModel(secondCompanyCar.getCurrentCarModel());
		secondCompanyCarImpl.setCurrentCarColor(secondCompanyCar.getCurrentCarColor());
		secondCompanyCarImpl.setCurrentPlateNumber(secondCompanyCar.getCurrentPlateNumber());
		secondCompanyCarImpl.setAcquiringDate(secondCompanyCar.getAcquiringDate());
		secondCompanyCarImpl.setExpectedCarModel(secondCompanyCar.getExpectedCarModel());
		secondCompanyCarImpl.setExpectedCarColor(secondCompanyCar.getExpectedCarColor());
		secondCompanyCarImpl.setExpectedLastPlateNumber(secondCompanyCar.getExpectedLastPlateNumber());
		secondCompanyCarImpl.setPositionCostCenterId(secondCompanyCar.getPositionCostCenterId());
		secondCompanyCarImpl.setEmployeeGroupId(secondCompanyCar.getEmployeeGroupId());
		secondCompanyCarImpl.setContractEndDate(secondCompanyCar.getContractEndDate());
		secondCompanyCarImpl.setMobilePhone(secondCompanyCar.getMobilePhone());
		secondCompanyCarImpl.setOfficePhone(secondCompanyCar.getOfficePhone());
		secondCompanyCarImpl.setEmail(secondCompanyCar.getEmail());
		secondCompanyCarImpl.setIsApplicantAgent(secondCompanyCar.isIsApplicantAgent());
		secondCompanyCarImpl.setIsApproverAgent(secondCompanyCar.isIsApproverAgent());
		secondCompanyCarImpl.setDrivingLicenseInformation(secondCompanyCar.getDrivingLicenseInformation());
		secondCompanyCarImpl.setEstimatedObtainingDate(secondCompanyCar.getEstimatedObtainingDate());
		secondCompanyCarImpl.setComments(secondCompanyCar.getComments());
		secondCompanyCarImpl.setProcessType(secondCompanyCar.getProcessType());
		secondCompanyCarImpl.setSubType(secondCompanyCar.getSubType());

		return secondCompanyCarImpl;
	}

	/**
	 * Returns the second company car with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the second company car
	 * @return the second company car
	 * @throws com.company.car.NoSuchSecondCompanyCarException if a second company car with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SecondCompanyCar findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSecondCompanyCarException, SystemException {
		SecondCompanyCar secondCompanyCar = fetchByPrimaryKey(primaryKey);

		if (secondCompanyCar == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSecondCompanyCarException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return secondCompanyCar;
	}

	/**
	 * Returns the second company car with the primary key or throws a {@link com.company.car.NoSuchSecondCompanyCarException} if it could not be found.
	 *
	 * @param secondCompanyCarId the primary key of the second company car
	 * @return the second company car
	 * @throws com.company.car.NoSuchSecondCompanyCarException if a second company car with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SecondCompanyCar findByPrimaryKey(long secondCompanyCarId)
		throws NoSuchSecondCompanyCarException, SystemException {
		return findByPrimaryKey((Serializable)secondCompanyCarId);
	}

	/**
	 * Returns the second company car with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the second company car
	 * @return the second company car, or <code>null</code> if a second company car with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SecondCompanyCar fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		SecondCompanyCar secondCompanyCar = (SecondCompanyCar)EntityCacheUtil.getResult(SecondCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
				SecondCompanyCarImpl.class, primaryKey);

		if (secondCompanyCar == _nullSecondCompanyCar) {
			return null;
		}

		if (secondCompanyCar == null) {
			Session session = null;

			try {
				session = openSession();

				secondCompanyCar = (SecondCompanyCar)session.get(SecondCompanyCarImpl.class,
						primaryKey);

				if (secondCompanyCar != null) {
					cacheResult(secondCompanyCar);
				}
				else {
					EntityCacheUtil.putResult(SecondCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
						SecondCompanyCarImpl.class, primaryKey,
						_nullSecondCompanyCar);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SecondCompanyCarModelImpl.ENTITY_CACHE_ENABLED,
					SecondCompanyCarImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return secondCompanyCar;
	}

	/**
	 * Returns the second company car with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param secondCompanyCarId the primary key of the second company car
	 * @return the second company car, or <code>null</code> if a second company car with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SecondCompanyCar fetchByPrimaryKey(long secondCompanyCarId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)secondCompanyCarId);
	}

	/**
	 * Returns all the second company cars.
	 *
	 * @return the second company cars
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SecondCompanyCar> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the second company cars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.SecondCompanyCarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of second company cars
	 * @param end the upper bound of the range of second company cars (not inclusive)
	 * @return the range of second company cars
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SecondCompanyCar> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the second company cars.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.SecondCompanyCarModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of second company cars
	 * @param end the upper bound of the range of second company cars (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of second company cars
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SecondCompanyCar> findAll(int start, int end,
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

		List<SecondCompanyCar> list = (List<SecondCompanyCar>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SECONDCOMPANYCAR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SECONDCOMPANYCAR;

				if (pagination) {
					sql = sql.concat(SecondCompanyCarModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SecondCompanyCar>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<SecondCompanyCar>(list);
				}
				else {
					list = (List<SecondCompanyCar>)QueryUtil.list(q,
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
	 * Removes all the second company cars from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (SecondCompanyCar secondCompanyCar : findAll()) {
			remove(secondCompanyCar);
		}
	}

	/**
	 * Returns the number of second company cars.
	 *
	 * @return the number of second company cars
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

				Query q = session.createQuery(_SQL_COUNT_SECONDCOMPANYCAR);

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
	 * Initializes the second company car persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.company.car.model.SecondCompanyCar")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SecondCompanyCar>> listenersList = new ArrayList<ModelListener<SecondCompanyCar>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<SecondCompanyCar>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SecondCompanyCarImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SECONDCOMPANYCAR = "SELECT secondCompanyCar FROM SecondCompanyCar secondCompanyCar";
	private static final String _SQL_SELECT_SECONDCOMPANYCAR_WHERE = "SELECT secondCompanyCar FROM SecondCompanyCar secondCompanyCar WHERE ";
	private static final String _SQL_COUNT_SECONDCOMPANYCAR = "SELECT COUNT(secondCompanyCar) FROM SecondCompanyCar secondCompanyCar";
	private static final String _SQL_COUNT_SECONDCOMPANYCAR_WHERE = "SELECT COUNT(secondCompanyCar) FROM SecondCompanyCar secondCompanyCar WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "secondCompanyCar.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SecondCompanyCar exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SecondCompanyCar exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SecondCompanyCarPersistenceImpl.class);
	private static SecondCompanyCar _nullSecondCompanyCar = new SecondCompanyCarImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SecondCompanyCar> toCacheModel() {
				return _nullSecondCompanyCarCacheModel;
			}
		};

	private static CacheModel<SecondCompanyCar> _nullSecondCompanyCarCacheModel = new CacheModel<SecondCompanyCar>() {
			@Override
			public SecondCompanyCar toEntityModel() {
				return _nullSecondCompanyCar;
			}
		};
}