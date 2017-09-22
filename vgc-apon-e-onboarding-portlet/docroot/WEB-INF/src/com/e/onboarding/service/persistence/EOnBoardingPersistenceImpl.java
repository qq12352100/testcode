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

package com.e.onboarding.service.persistence;

import com.e.onboarding.NoSuchEOnBoardingException;
import com.e.onboarding.model.EOnBoarding;
import com.e.onboarding.model.impl.EOnBoardingImpl;
import com.e.onboarding.model.impl.EOnBoardingModelImpl;

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
 * The persistence implementation for the e on boarding service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sanguine
 * @see EOnBoardingPersistence
 * @see EOnBoardingUtil
 * @generated
 */
public class EOnBoardingPersistenceImpl extends BasePersistenceImpl<EOnBoarding>
	implements EOnBoardingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EOnBoardingUtil} to access the e on boarding persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EOnBoardingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EOnBoardingModelImpl.ENTITY_CACHE_ENABLED,
			EOnBoardingModelImpl.FINDER_CACHE_ENABLED, EOnBoardingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EOnBoardingModelImpl.ENTITY_CACHE_ENABLED,
			EOnBoardingModelImpl.FINDER_CACHE_ENABLED, EOnBoardingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EOnBoardingModelImpl.ENTITY_CACHE_ENABLED,
			EOnBoardingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_S_U = new FinderPath(EOnBoardingModelImpl.ENTITY_CACHE_ENABLED,
			EOnBoardingModelImpl.FINDER_CACHE_ENABLED, EOnBoardingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByS_U",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U = new FinderPath(EOnBoardingModelImpl.ENTITY_CACHE_ENABLED,
			EOnBoardingModelImpl.FINDER_CACHE_ENABLED, EOnBoardingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_U",
			new String[] { Integer.class.getName(), Long.class.getName() },
			EOnBoardingModelImpl.STATUS_COLUMN_BITMASK |
			EOnBoardingModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_S_U = new FinderPath(EOnBoardingModelImpl.ENTITY_CACHE_ENABLED,
			EOnBoardingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_U",
			new String[] { Integer.class.getName(), Long.class.getName() });

	/**
	 * Returns all the e on boardings where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @return the matching e on boardings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EOnBoarding> findByS_U(int status, long userId)
		throws SystemException {
		return findByS_U(status, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the e on boardings where status = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.onboarding.model.impl.EOnBoardingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param start the lower bound of the range of e on boardings
	 * @param end the upper bound of the range of e on boardings (not inclusive)
	 * @return the range of matching e on boardings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EOnBoarding> findByS_U(int status, long userId, int start,
		int end) throws SystemException {
		return findByS_U(status, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the e on boardings where status = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.onboarding.model.impl.EOnBoardingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param start the lower bound of the range of e on boardings
	 * @param end the upper bound of the range of e on boardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching e on boardings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EOnBoarding> findByS_U(int status, long userId, int start,
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

		List<EOnBoarding> list = (List<EOnBoarding>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EOnBoarding eOnBoarding : list) {
				if ((status != eOnBoarding.getStatus()) ||
						(userId != eOnBoarding.getUserId())) {
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

			query.append(_SQL_SELECT_EONBOARDING_WHERE);

			query.append(_FINDER_COLUMN_S_U_STATUS_2);

			query.append(_FINDER_COLUMN_S_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EOnBoardingModelImpl.ORDER_BY_JPQL);
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
					list = (List<EOnBoarding>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EOnBoarding>(list);
				}
				else {
					list = (List<EOnBoarding>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first e on boarding in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e on boarding
	 * @throws com.e.onboarding.NoSuchEOnBoardingException if a matching e on boarding could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EOnBoarding findByS_U_First(int status, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchEOnBoardingException, SystemException {
		EOnBoarding eOnBoarding = fetchByS_U_First(status, userId,
				orderByComparator);

		if (eOnBoarding != null) {
			return eOnBoarding;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEOnBoardingException(msg.toString());
	}

	/**
	 * Returns the first e on boarding in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching e on boarding, or <code>null</code> if a matching e on boarding could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EOnBoarding fetchByS_U_First(int status, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EOnBoarding> list = findByS_U(status, userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last e on boarding in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e on boarding
	 * @throws com.e.onboarding.NoSuchEOnBoardingException if a matching e on boarding could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EOnBoarding findByS_U_Last(int status, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchEOnBoardingException, SystemException {
		EOnBoarding eOnBoarding = fetchByS_U_Last(status, userId,
				orderByComparator);

		if (eOnBoarding != null) {
			return eOnBoarding;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEOnBoardingException(msg.toString());
	}

	/**
	 * Returns the last e on boarding in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching e on boarding, or <code>null</code> if a matching e on boarding could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EOnBoarding fetchByS_U_Last(int status, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByS_U(status, userId);

		if (count == 0) {
			return null;
		}

		List<EOnBoarding> list = findByS_U(status, userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the e on boardings before and after the current e on boarding in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param eOnBoardingId the primary key of the current e on boarding
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next e on boarding
	 * @throws com.e.onboarding.NoSuchEOnBoardingException if a e on boarding with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EOnBoarding[] findByS_U_PrevAndNext(long eOnBoardingId, int status,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchEOnBoardingException, SystemException {
		EOnBoarding eOnBoarding = findByPrimaryKey(eOnBoardingId);

		Session session = null;

		try {
			session = openSession();

			EOnBoarding[] array = new EOnBoardingImpl[3];

			array[0] = getByS_U_PrevAndNext(session, eOnBoarding, status,
					userId, orderByComparator, true);

			array[1] = eOnBoarding;

			array[2] = getByS_U_PrevAndNext(session, eOnBoarding, status,
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

	protected EOnBoarding getByS_U_PrevAndNext(Session session,
		EOnBoarding eOnBoarding, int status, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EONBOARDING_WHERE);

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
			query.append(EOnBoardingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(eOnBoarding);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EOnBoarding> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the e on boardings where status = &#63; and userId = &#63; from the database.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByS_U(int status, long userId) throws SystemException {
		for (EOnBoarding eOnBoarding : findByS_U(status, userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(eOnBoarding);
		}
	}

	/**
	 * Returns the number of e on boardings where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @return the number of matching e on boardings
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

			query.append(_SQL_COUNT_EONBOARDING_WHERE);

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

	private static final String _FINDER_COLUMN_S_U_STATUS_2 = "eOnBoarding.status = ? AND ";
	private static final String _FINDER_COLUMN_S_U_USERID_2 = "eOnBoarding.userId = ?";

	public EOnBoardingPersistenceImpl() {
		setModelClass(EOnBoarding.class);
	}

	/**
	 * Caches the e on boarding in the entity cache if it is enabled.
	 *
	 * @param eOnBoarding the e on boarding
	 */
	@Override
	public void cacheResult(EOnBoarding eOnBoarding) {
		EntityCacheUtil.putResult(EOnBoardingModelImpl.ENTITY_CACHE_ENABLED,
			EOnBoardingImpl.class, eOnBoarding.getPrimaryKey(), eOnBoarding);

		eOnBoarding.resetOriginalValues();
	}

	/**
	 * Caches the e on boardings in the entity cache if it is enabled.
	 *
	 * @param eOnBoardings the e on boardings
	 */
	@Override
	public void cacheResult(List<EOnBoarding> eOnBoardings) {
		for (EOnBoarding eOnBoarding : eOnBoardings) {
			if (EntityCacheUtil.getResult(
						EOnBoardingModelImpl.ENTITY_CACHE_ENABLED,
						EOnBoardingImpl.class, eOnBoarding.getPrimaryKey()) == null) {
				cacheResult(eOnBoarding);
			}
			else {
				eOnBoarding.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e on boardings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EOnBoardingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EOnBoardingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e on boarding.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EOnBoarding eOnBoarding) {
		EntityCacheUtil.removeResult(EOnBoardingModelImpl.ENTITY_CACHE_ENABLED,
			EOnBoardingImpl.class, eOnBoarding.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EOnBoarding> eOnBoardings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EOnBoarding eOnBoarding : eOnBoardings) {
			EntityCacheUtil.removeResult(EOnBoardingModelImpl.ENTITY_CACHE_ENABLED,
				EOnBoardingImpl.class, eOnBoarding.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e on boarding with the primary key. Does not add the e on boarding to the database.
	 *
	 * @param eOnBoardingId the primary key for the new e on boarding
	 * @return the new e on boarding
	 */
	@Override
	public EOnBoarding create(long eOnBoardingId) {
		EOnBoarding eOnBoarding = new EOnBoardingImpl();

		eOnBoarding.setNew(true);
		eOnBoarding.setPrimaryKey(eOnBoardingId);

		return eOnBoarding;
	}

	/**
	 * Removes the e on boarding with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eOnBoardingId the primary key of the e on boarding
	 * @return the e on boarding that was removed
	 * @throws com.e.onboarding.NoSuchEOnBoardingException if a e on boarding with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EOnBoarding remove(long eOnBoardingId)
		throws NoSuchEOnBoardingException, SystemException {
		return remove((Serializable)eOnBoardingId);
	}

	/**
	 * Removes the e on boarding with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e on boarding
	 * @return the e on boarding that was removed
	 * @throws com.e.onboarding.NoSuchEOnBoardingException if a e on boarding with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EOnBoarding remove(Serializable primaryKey)
		throws NoSuchEOnBoardingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EOnBoarding eOnBoarding = (EOnBoarding)session.get(EOnBoardingImpl.class,
					primaryKey);

			if (eOnBoarding == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEOnBoardingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(eOnBoarding);
		}
		catch (NoSuchEOnBoardingException nsee) {
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
	protected EOnBoarding removeImpl(EOnBoarding eOnBoarding)
		throws SystemException {
		eOnBoarding = toUnwrappedModel(eOnBoarding);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eOnBoarding)) {
				eOnBoarding = (EOnBoarding)session.get(EOnBoardingImpl.class,
						eOnBoarding.getPrimaryKeyObj());
			}

			if (eOnBoarding != null) {
				session.delete(eOnBoarding);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (eOnBoarding != null) {
			clearCache(eOnBoarding);
		}

		return eOnBoarding;
	}

	@Override
	public EOnBoarding updateImpl(
		com.e.onboarding.model.EOnBoarding eOnBoarding)
		throws SystemException {
		eOnBoarding = toUnwrappedModel(eOnBoarding);

		boolean isNew = eOnBoarding.isNew();

		EOnBoardingModelImpl eOnBoardingModelImpl = (EOnBoardingModelImpl)eOnBoarding;

		Session session = null;

		try {
			session = openSession();

			if (eOnBoarding.isNew()) {
				session.save(eOnBoarding);

				eOnBoarding.setNew(false);
			}
			else {
				session.merge(eOnBoarding);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EOnBoardingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((eOnBoardingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eOnBoardingModelImpl.getOriginalStatus(),
						eOnBoardingModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U,
					args);

				args = new Object[] {
						eOnBoardingModelImpl.getStatus(),
						eOnBoardingModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U,
					args);
			}
		}

		EntityCacheUtil.putResult(EOnBoardingModelImpl.ENTITY_CACHE_ENABLED,
			EOnBoardingImpl.class, eOnBoarding.getPrimaryKey(), eOnBoarding);

		return eOnBoarding;
	}

	protected EOnBoarding toUnwrappedModel(EOnBoarding eOnBoarding) {
		if (eOnBoarding instanceof EOnBoardingImpl) {
			return eOnBoarding;
		}

		EOnBoardingImpl eOnBoardingImpl = new EOnBoardingImpl();

		eOnBoardingImpl.setNew(eOnBoarding.isNew());
		eOnBoardingImpl.setPrimaryKey(eOnBoarding.getPrimaryKey());

		eOnBoardingImpl.setEOnBoardingId(eOnBoarding.getEOnBoardingId());
		eOnBoardingImpl.setTicketNo(eOnBoarding.getTicketNo());
		eOnBoardingImpl.setProcessType(eOnBoarding.getProcessType());
		eOnBoardingImpl.setSubType(eOnBoarding.getSubType());
		eOnBoardingImpl.setGroupId(eOnBoarding.getGroupId());
		eOnBoardingImpl.setCompanyId(eOnBoarding.getCompanyId());
		eOnBoardingImpl.setUserId(eOnBoarding.getUserId());
		eOnBoardingImpl.setUserName(eOnBoarding.getUserName());
		eOnBoardingImpl.setCreateDate(eOnBoarding.getCreateDate());
		eOnBoardingImpl.setModifiedDate(eOnBoarding.getModifiedDate());
		eOnBoardingImpl.setSubmittedDate(eOnBoarding.getSubmittedDate());
		eOnBoardingImpl.setModifiedUserId(eOnBoarding.getModifiedUserId());
		eOnBoardingImpl.setModifiedUserName(eOnBoarding.getModifiedUserName());
		eOnBoardingImpl.setStatus(eOnBoarding.getStatus());
		eOnBoardingImpl.setStatusByUserId(eOnBoarding.getStatusByUserId());
		eOnBoardingImpl.setStatusByUserName(eOnBoarding.getStatusByUserName());
		eOnBoardingImpl.setStatusDate(eOnBoarding.getStatusDate());
		eOnBoardingImpl.setStaffCode(eOnBoarding.getStaffCode());
		eOnBoardingImpl.setLastName(eOnBoarding.getLastName());
		eOnBoardingImpl.setFirstName(eOnBoarding.getFirstName());
		eOnBoardingImpl.setName(eOnBoarding.getName());
		eOnBoardingImpl.setGender(eOnBoarding.getGender());
		eOnBoardingImpl.setBirthday(eOnBoarding.getBirthday());
		eOnBoardingImpl.setPhotoPath(eOnBoarding.getPhotoPath());
		eOnBoardingImpl.setContractType(eOnBoarding.getContractType());
		eOnBoardingImpl.setWorkLocation(eOnBoarding.getWorkLocation());
		eOnBoardingImpl.setDivision(eOnBoarding.getDivision());
		eOnBoardingImpl.setOfficeSite(eOnBoarding.getOfficeSite());
		eOnBoardingImpl.setDepartment(eOnBoarding.getDepartment());
		eOnBoardingImpl.setStartingDate(eOnBoarding.getStartingDate());
		eOnBoardingImpl.setPositionCode(eOnBoarding.getPositionCode());
		eOnBoardingImpl.setServiceLength(eOnBoarding.getServiceLength());
		eOnBoardingImpl.setFunctionName(eOnBoarding.getFunctionName());
		eOnBoardingImpl.setReportTo(eOnBoarding.getReportTo());
		eOnBoardingImpl.setReportToStaffName(eOnBoarding.getReportToStaffName());
		eOnBoardingImpl.setTitle(eOnBoarding.getTitle());
		eOnBoardingImpl.setCostCenter(eOnBoarding.getCostCenter());
		eOnBoardingImpl.setItRelatedHardware(eOnBoarding.isItRelatedHardware());
		eOnBoardingImpl.setCompanyCar(eOnBoarding.isCompanyCar());
		eOnBoardingImpl.setReplacement(eOnBoarding.isReplacement());
		eOnBoardingImpl.setNameOfReplacedPerson(eOnBoarding.getNameOfReplacedPerson());
		eOnBoardingImpl.setContactInfo(eOnBoarding.getContactInfo());
		eOnBoardingImpl.setComments(eOnBoarding.getComments());
		eOnBoardingImpl.setIsApplicantAgent(eOnBoarding.isIsApplicantAgent());
		eOnBoardingImpl.setIsApproverAgent(eOnBoarding.isIsApproverAgent());
		eOnBoardingImpl.setAdminEntitlement(eOnBoarding.getAdminEntitlement());
		eOnBoardingImpl.setAdminSeatNo(eOnBoarding.getAdminSeatNo());
		eOnBoardingImpl.setAdminTasks(eOnBoarding.getAdminTasks());
		eOnBoardingImpl.setAdminStatus(eOnBoarding.getAdminStatus());
		eOnBoardingImpl.setAdminComments(eOnBoarding.getAdminComments());
		eOnBoardingImpl.setSecurityTasks(eOnBoarding.getSecurityTasks());
		eOnBoardingImpl.setSecurityStatus(eOnBoarding.getSecurityStatus());
		eOnBoardingImpl.setSecurityComments(eOnBoarding.getSecurityComments());
		eOnBoardingImpl.setItpTasks(eOnBoarding.getItpTasks());
		eOnBoardingImpl.setItpStatus(eOnBoarding.getItpStatus());
		eOnBoardingImpl.setIptComments(eOnBoarding.getIptComments());
		eOnBoardingImpl.setFinanceTasks(eOnBoarding.getFinanceTasks());
		eOnBoardingImpl.setFinanceStatus(eOnBoarding.getFinanceStatus());
		eOnBoardingImpl.setFinanceComments(eOnBoarding.getFinanceComments());

		return eOnBoardingImpl;
	}

	/**
	 * Returns the e on boarding with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e on boarding
	 * @return the e on boarding
	 * @throws com.e.onboarding.NoSuchEOnBoardingException if a e on boarding with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EOnBoarding findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEOnBoardingException, SystemException {
		EOnBoarding eOnBoarding = fetchByPrimaryKey(primaryKey);

		if (eOnBoarding == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEOnBoardingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return eOnBoarding;
	}

	/**
	 * Returns the e on boarding with the primary key or throws a {@link com.e.onboarding.NoSuchEOnBoardingException} if it could not be found.
	 *
	 * @param eOnBoardingId the primary key of the e on boarding
	 * @return the e on boarding
	 * @throws com.e.onboarding.NoSuchEOnBoardingException if a e on boarding with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EOnBoarding findByPrimaryKey(long eOnBoardingId)
		throws NoSuchEOnBoardingException, SystemException {
		return findByPrimaryKey((Serializable)eOnBoardingId);
	}

	/**
	 * Returns the e on boarding with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e on boarding
	 * @return the e on boarding, or <code>null</code> if a e on boarding with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EOnBoarding fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EOnBoarding eOnBoarding = (EOnBoarding)EntityCacheUtil.getResult(EOnBoardingModelImpl.ENTITY_CACHE_ENABLED,
				EOnBoardingImpl.class, primaryKey);

		if (eOnBoarding == _nullEOnBoarding) {
			return null;
		}

		if (eOnBoarding == null) {
			Session session = null;

			try {
				session = openSession();

				eOnBoarding = (EOnBoarding)session.get(EOnBoardingImpl.class,
						primaryKey);

				if (eOnBoarding != null) {
					cacheResult(eOnBoarding);
				}
				else {
					EntityCacheUtil.putResult(EOnBoardingModelImpl.ENTITY_CACHE_ENABLED,
						EOnBoardingImpl.class, primaryKey, _nullEOnBoarding);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EOnBoardingModelImpl.ENTITY_CACHE_ENABLED,
					EOnBoardingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return eOnBoarding;
	}

	/**
	 * Returns the e on boarding with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eOnBoardingId the primary key of the e on boarding
	 * @return the e on boarding, or <code>null</code> if a e on boarding with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EOnBoarding fetchByPrimaryKey(long eOnBoardingId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)eOnBoardingId);
	}

	/**
	 * Returns all the e on boardings.
	 *
	 * @return the e on boardings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EOnBoarding> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e on boardings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.onboarding.model.impl.EOnBoardingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e on boardings
	 * @param end the upper bound of the range of e on boardings (not inclusive)
	 * @return the range of e on boardings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EOnBoarding> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e on boardings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.onboarding.model.impl.EOnBoardingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e on boardings
	 * @param end the upper bound of the range of e on boardings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e on boardings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EOnBoarding> findAll(int start, int end,
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

		List<EOnBoarding> list = (List<EOnBoarding>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EONBOARDING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EONBOARDING;

				if (pagination) {
					sql = sql.concat(EOnBoardingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EOnBoarding>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EOnBoarding>(list);
				}
				else {
					list = (List<EOnBoarding>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e on boardings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EOnBoarding eOnBoarding : findAll()) {
			remove(eOnBoarding);
		}
	}

	/**
	 * Returns the number of e on boardings.
	 *
	 * @return the number of e on boardings
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

				Query q = session.createQuery(_SQL_COUNT_EONBOARDING);

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
	 * Initializes the e on boarding persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.e.onboarding.model.EOnBoarding")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EOnBoarding>> listenersList = new ArrayList<ModelListener<EOnBoarding>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EOnBoarding>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EOnBoardingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EONBOARDING = "SELECT eOnBoarding FROM EOnBoarding eOnBoarding";
	private static final String _SQL_SELECT_EONBOARDING_WHERE = "SELECT eOnBoarding FROM EOnBoarding eOnBoarding WHERE ";
	private static final String _SQL_COUNT_EONBOARDING = "SELECT COUNT(eOnBoarding) FROM EOnBoarding eOnBoarding";
	private static final String _SQL_COUNT_EONBOARDING_WHERE = "SELECT COUNT(eOnBoarding) FROM EOnBoarding eOnBoarding WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "eOnBoarding.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EOnBoarding exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EOnBoarding exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EOnBoardingPersistenceImpl.class);
	private static EOnBoarding _nullEOnBoarding = new EOnBoardingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EOnBoarding> toCacheModel() {
				return _nullEOnBoardingCacheModel;
			}
		};

	private static CacheModel<EOnBoarding> _nullEOnBoardingCacheModel = new CacheModel<EOnBoarding>() {
			@Override
			public EOnBoarding toEntityModel() {
				return _nullEOnBoarding;
			}
		};
}