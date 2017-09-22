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

import com.e.onboarding.NoSuchDistributionException;
import com.e.onboarding.model.Distribution;
import com.e.onboarding.model.impl.DistributionImpl;
import com.e.onboarding.model.impl.DistributionModelImpl;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the distribution service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sanguine
 * @see DistributionPersistence
 * @see DistributionUtil
 * @generated
 */
public class DistributionPersistenceImpl extends BasePersistenceImpl<Distribution>
	implements DistributionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DistributionUtil} to access the distribution persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DistributionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionModelImpl.FINDER_CACHE_ENABLED, DistributionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionModelImpl.FINDER_CACHE_ENABLED, DistributionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE = new FinderPath(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionModelImpl.FINDER_CACHE_ENABLED, DistributionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE = new FinderPath(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionModelImpl.FINDER_CACHE_ENABLED, DistributionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] { String.class.getName() },
			DistributionModelImpl.TYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPE = new FinderPath(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the distributions where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> findByType(String type) throws SystemException {
		return findByType(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the distributions where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.onboarding.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of distributions
	 * @param end the upper bound of the range of distributions (not inclusive)
	 * @return the range of matching distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> findByType(String type, int start, int end)
		throws SystemException {
		return findByType(type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the distributions where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.onboarding.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of distributions
	 * @param end the upper bound of the range of distributions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> findByType(String type, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { type };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { type, start, end, orderByComparator };
		}

		List<Distribution> list = (List<Distribution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Distribution distribution : list) {
				if (!Validator.equals(type, distribution.getType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_DISTRIBUTION_WHERE);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DistributionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindType) {
					qPos.add(type);
				}

				if (!pagination) {
					list = (List<Distribution>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Distribution>(list);
				}
				else {
					list = (List<Distribution>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first distribution in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching distribution
	 * @throws com.e.onboarding.NoSuchDistributionException if a matching distribution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution findByType_First(String type,
		OrderByComparator orderByComparator)
		throws NoSuchDistributionException, SystemException {
		Distribution distribution = fetchByType_First(type, orderByComparator);

		if (distribution != null) {
			return distribution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDistributionException(msg.toString());
	}

	/**
	 * Returns the first distribution in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching distribution, or <code>null</code> if a matching distribution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution fetchByType_First(String type,
		OrderByComparator orderByComparator) throws SystemException {
		List<Distribution> list = findByType(type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last distribution in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching distribution
	 * @throws com.e.onboarding.NoSuchDistributionException if a matching distribution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution findByType_Last(String type,
		OrderByComparator orderByComparator)
		throws NoSuchDistributionException, SystemException {
		Distribution distribution = fetchByType_Last(type, orderByComparator);

		if (distribution != null) {
			return distribution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDistributionException(msg.toString());
	}

	/**
	 * Returns the last distribution in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching distribution, or <code>null</code> if a matching distribution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution fetchByType_Last(String type,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByType(type);

		if (count == 0) {
			return null;
		}

		List<Distribution> list = findByType(type, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the distributions before and after the current distribution in the ordered set where type = &#63;.
	 *
	 * @param distributionId the primary key of the current distribution
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next distribution
	 * @throws com.e.onboarding.NoSuchDistributionException if a distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution[] findByType_PrevAndNext(long distributionId,
		String type, OrderByComparator orderByComparator)
		throws NoSuchDistributionException, SystemException {
		Distribution distribution = findByPrimaryKey(distributionId);

		Session session = null;

		try {
			session = openSession();

			Distribution[] array = new DistributionImpl[3];

			array[0] = getByType_PrevAndNext(session, distribution, type,
					orderByComparator, true);

			array[1] = distribution;

			array[2] = getByType_PrevAndNext(session, distribution, type,
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

	protected Distribution getByType_PrevAndNext(Session session,
		Distribution distribution, String type,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DISTRIBUTION_WHERE);

		boolean bindType = false;

		if (type == null) {
			query.append(_FINDER_COLUMN_TYPE_TYPE_1);
		}
		else if (type.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TYPE_TYPE_3);
		}
		else {
			bindType = true;

			query.append(_FINDER_COLUMN_TYPE_TYPE_2);
		}

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
			query.append(DistributionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindType) {
			qPos.add(type);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(distribution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Distribution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the distributions where type = &#63; from the database.
	 *
	 * @param type the type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByType(String type) throws SystemException {
		for (Distribution distribution : findByType(type, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(distribution);
		}
	}

	/**
	 * Returns the number of distributions where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByType(String type) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPE;

		Object[] finderArgs = new Object[] { type };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DISTRIBUTION_WHERE);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindType) {
					qPos.add(type);
				}

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

	private static final String _FINDER_COLUMN_TYPE_TYPE_1 = "distribution.type IS NULL";
	private static final String _FINDER_COLUMN_TYPE_TYPE_2 = "distribution.type = ?";
	private static final String _FINDER_COLUMN_TYPE_TYPE_3 = "(distribution.type IS NULL OR distribution.type = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_EMAILADDRESS = new FinderPath(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionModelImpl.FINDER_CACHE_ENABLED, DistributionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByemailAddress",
			new String[] { String.class.getName() },
			DistributionModelImpl.EMAILADDRESS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILADDRESS = new FinderPath(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemailAddress",
			new String[] { String.class.getName() });

	/**
	 * Returns the distribution where emailAddress = &#63; or throws a {@link com.e.onboarding.NoSuchDistributionException} if it could not be found.
	 *
	 * @param emailAddress the email address
	 * @return the matching distribution
	 * @throws com.e.onboarding.NoSuchDistributionException if a matching distribution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution findByemailAddress(String emailAddress)
		throws NoSuchDistributionException, SystemException {
		Distribution distribution = fetchByemailAddress(emailAddress);

		if (distribution == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("emailAddress=");
			msg.append(emailAddress);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDistributionException(msg.toString());
		}

		return distribution;
	}

	/**
	 * Returns the distribution where emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param emailAddress the email address
	 * @return the matching distribution, or <code>null</code> if a matching distribution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution fetchByemailAddress(String emailAddress)
		throws SystemException {
		return fetchByemailAddress(emailAddress, true);
	}

	/**
	 * Returns the distribution where emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param emailAddress the email address
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching distribution, or <code>null</code> if a matching distribution could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution fetchByemailAddress(String emailAddress,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { emailAddress };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMAILADDRESS,
					finderArgs, this);
		}

		if (result instanceof Distribution) {
			Distribution distribution = (Distribution)result;

			if (!Validator.equals(emailAddress, distribution.getEmailAddress())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DISTRIBUTION_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmailAddress) {
					qPos.add(emailAddress);
				}

				List<Distribution> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DistributionPersistenceImpl.fetchByemailAddress(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Distribution distribution = list.get(0);

					result = distribution;

					cacheResult(distribution);

					if ((distribution.getEmailAddress() == null) ||
							!distribution.getEmailAddress().equals(emailAddress)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS,
							finderArgs, distribution);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILADDRESS,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Distribution)result;
		}
	}

	/**
	 * Removes the distribution where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 * @return the distribution that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution removeByemailAddress(String emailAddress)
		throws NoSuchDistributionException, SystemException {
		Distribution distribution = findByemailAddress(emailAddress);

		return remove(distribution);
	}

	/**
	 * Returns the number of distributions where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByemailAddress(String emailAddress)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAILADDRESS;

		Object[] finderArgs = new Object[] { emailAddress };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DISTRIBUTION_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmailAddress) {
					qPos.add(emailAddress);
				}

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

	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_1 = "distribution.emailAddress IS NULL";
	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2 = "distribution.emailAddress = ?";
	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3 = "(distribution.emailAddress IS NULL OR distribution.emailAddress = '')";

	public DistributionPersistenceImpl() {
		setModelClass(Distribution.class);
	}

	/**
	 * Caches the distribution in the entity cache if it is enabled.
	 *
	 * @param distribution the distribution
	 */
	@Override
	public void cacheResult(Distribution distribution) {
		EntityCacheUtil.putResult(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionImpl.class, distribution.getPrimaryKey(), distribution);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS,
			new Object[] { distribution.getEmailAddress() }, distribution);

		distribution.resetOriginalValues();
	}

	/**
	 * Caches the distributions in the entity cache if it is enabled.
	 *
	 * @param distributions the distributions
	 */
	@Override
	public void cacheResult(List<Distribution> distributions) {
		for (Distribution distribution : distributions) {
			if (EntityCacheUtil.getResult(
						DistributionModelImpl.ENTITY_CACHE_ENABLED,
						DistributionImpl.class, distribution.getPrimaryKey()) == null) {
				cacheResult(distribution);
			}
			else {
				distribution.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all distributions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DistributionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DistributionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the distribution.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Distribution distribution) {
		EntityCacheUtil.removeResult(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionImpl.class, distribution.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(distribution);
	}

	@Override
	public void clearCache(List<Distribution> distributions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Distribution distribution : distributions) {
			EntityCacheUtil.removeResult(DistributionModelImpl.ENTITY_CACHE_ENABLED,
				DistributionImpl.class, distribution.getPrimaryKey());

			clearUniqueFindersCache(distribution);
		}
	}

	protected void cacheUniqueFindersCache(Distribution distribution) {
		if (distribution.isNew()) {
			Object[] args = new Object[] { distribution.getEmailAddress() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILADDRESS, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS, args,
				distribution);
		}
		else {
			DistributionModelImpl distributionModelImpl = (DistributionModelImpl)distribution;

			if ((distributionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMAILADDRESS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { distribution.getEmailAddress() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILADDRESS,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS,
					args, distribution);
			}
		}
	}

	protected void clearUniqueFindersCache(Distribution distribution) {
		DistributionModelImpl distributionModelImpl = (DistributionModelImpl)distribution;

		Object[] args = new Object[] { distribution.getEmailAddress() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESS, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILADDRESS, args);

		if ((distributionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMAILADDRESS.getColumnBitmask()) != 0) {
			args = new Object[] { distributionModelImpl.getOriginalEmailAddress() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESS, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILADDRESS, args);
		}
	}

	/**
	 * Creates a new distribution with the primary key. Does not add the distribution to the database.
	 *
	 * @param distributionId the primary key for the new distribution
	 * @return the new distribution
	 */
	@Override
	public Distribution create(long distributionId) {
		Distribution distribution = new DistributionImpl();

		distribution.setNew(true);
		distribution.setPrimaryKey(distributionId);

		return distribution;
	}

	/**
	 * Removes the distribution with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param distributionId the primary key of the distribution
	 * @return the distribution that was removed
	 * @throws com.e.onboarding.NoSuchDistributionException if a distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution remove(long distributionId)
		throws NoSuchDistributionException, SystemException {
		return remove((Serializable)distributionId);
	}

	/**
	 * Removes the distribution with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the distribution
	 * @return the distribution that was removed
	 * @throws com.e.onboarding.NoSuchDistributionException if a distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution remove(Serializable primaryKey)
		throws NoSuchDistributionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Distribution distribution = (Distribution)session.get(DistributionImpl.class,
					primaryKey);

			if (distribution == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDistributionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(distribution);
		}
		catch (NoSuchDistributionException nsee) {
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
	protected Distribution removeImpl(Distribution distribution)
		throws SystemException {
		distribution = toUnwrappedModel(distribution);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(distribution)) {
				distribution = (Distribution)session.get(DistributionImpl.class,
						distribution.getPrimaryKeyObj());
			}

			if (distribution != null) {
				session.delete(distribution);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (distribution != null) {
			clearCache(distribution);
		}

		return distribution;
	}

	@Override
	public Distribution updateImpl(
		com.e.onboarding.model.Distribution distribution)
		throws SystemException {
		distribution = toUnwrappedModel(distribution);

		boolean isNew = distribution.isNew();

		DistributionModelImpl distributionModelImpl = (DistributionModelImpl)distribution;

		Session session = null;

		try {
			session = openSession();

			if (distribution.isNew()) {
				session.save(distribution);

				distribution.setNew(false);
			}
			else {
				session.merge(distribution);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DistributionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((distributionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						distributionModelImpl.getOriginalType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);

				args = new Object[] { distributionModelImpl.getType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(DistributionModelImpl.ENTITY_CACHE_ENABLED,
			DistributionImpl.class, distribution.getPrimaryKey(), distribution);

		clearUniqueFindersCache(distribution);
		cacheUniqueFindersCache(distribution);

		return distribution;
	}

	protected Distribution toUnwrappedModel(Distribution distribution) {
		if (distribution instanceof DistributionImpl) {
			return distribution;
		}

		DistributionImpl distributionImpl = new DistributionImpl();

		distributionImpl.setNew(distribution.isNew());
		distributionImpl.setPrimaryKey(distribution.getPrimaryKey());

		distributionImpl.setDistributionId(distribution.getDistributionId());
		distributionImpl.setGroupId(distribution.getGroupId());
		distributionImpl.setCompanyId(distribution.getCompanyId());
		distributionImpl.setUserId(distribution.getUserId());
		distributionImpl.setUserName(distribution.getUserName());
		distributionImpl.setCreateDate(distribution.getCreateDate());
		distributionImpl.setModifiedDate(distribution.getModifiedDate());
		distributionImpl.setEmailAddress(distribution.getEmailAddress());
		distributionImpl.setName(distribution.getName());
		distributionImpl.setComments(distribution.getComments());
		distributionImpl.setType(distribution.getType());

		return distributionImpl;
	}

	/**
	 * Returns the distribution with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the distribution
	 * @return the distribution
	 * @throws com.e.onboarding.NoSuchDistributionException if a distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDistributionException, SystemException {
		Distribution distribution = fetchByPrimaryKey(primaryKey);

		if (distribution == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDistributionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return distribution;
	}

	/**
	 * Returns the distribution with the primary key or throws a {@link com.e.onboarding.NoSuchDistributionException} if it could not be found.
	 *
	 * @param distributionId the primary key of the distribution
	 * @return the distribution
	 * @throws com.e.onboarding.NoSuchDistributionException if a distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution findByPrimaryKey(long distributionId)
		throws NoSuchDistributionException, SystemException {
		return findByPrimaryKey((Serializable)distributionId);
	}

	/**
	 * Returns the distribution with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the distribution
	 * @return the distribution, or <code>null</code> if a distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Distribution distribution = (Distribution)EntityCacheUtil.getResult(DistributionModelImpl.ENTITY_CACHE_ENABLED,
				DistributionImpl.class, primaryKey);

		if (distribution == _nullDistribution) {
			return null;
		}

		if (distribution == null) {
			Session session = null;

			try {
				session = openSession();

				distribution = (Distribution)session.get(DistributionImpl.class,
						primaryKey);

				if (distribution != null) {
					cacheResult(distribution);
				}
				else {
					EntityCacheUtil.putResult(DistributionModelImpl.ENTITY_CACHE_ENABLED,
						DistributionImpl.class, primaryKey, _nullDistribution);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DistributionModelImpl.ENTITY_CACHE_ENABLED,
					DistributionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return distribution;
	}

	/**
	 * Returns the distribution with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param distributionId the primary key of the distribution
	 * @return the distribution, or <code>null</code> if a distribution with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Distribution fetchByPrimaryKey(long distributionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)distributionId);
	}

	/**
	 * Returns all the distributions.
	 *
	 * @return the distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the distributions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.onboarding.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of distributions
	 * @param end the upper bound of the range of distributions (not inclusive)
	 * @return the range of distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the distributions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.onboarding.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of distributions
	 * @param end the upper bound of the range of distributions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of distributions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Distribution> findAll(int start, int end,
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

		List<Distribution> list = (List<Distribution>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DISTRIBUTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DISTRIBUTION;

				if (pagination) {
					sql = sql.concat(DistributionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Distribution>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Distribution>(list);
				}
				else {
					list = (List<Distribution>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the distributions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Distribution distribution : findAll()) {
			remove(distribution);
		}
	}

	/**
	 * Returns the number of distributions.
	 *
	 * @return the number of distributions
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

				Query q = session.createQuery(_SQL_COUNT_DISTRIBUTION);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the distribution persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.e.onboarding.model.Distribution")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Distribution>> listenersList = new ArrayList<ModelListener<Distribution>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Distribution>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DistributionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DISTRIBUTION = "SELECT distribution FROM Distribution distribution";
	private static final String _SQL_SELECT_DISTRIBUTION_WHERE = "SELECT distribution FROM Distribution distribution WHERE ";
	private static final String _SQL_COUNT_DISTRIBUTION = "SELECT COUNT(distribution) FROM Distribution distribution";
	private static final String _SQL_COUNT_DISTRIBUTION_WHERE = "SELECT COUNT(distribution) FROM Distribution distribution WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "distribution.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Distribution exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Distribution exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DistributionPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
	private static Distribution _nullDistribution = new DistributionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Distribution> toCacheModel() {
				return _nullDistributionCacheModel;
			}
		};

	private static CacheModel<Distribution> _nullDistributionCacheModel = new CacheModel<Distribution>() {
			@Override
			public Distribution toEntityModel() {
				return _nullDistribution;
			}
		};
}