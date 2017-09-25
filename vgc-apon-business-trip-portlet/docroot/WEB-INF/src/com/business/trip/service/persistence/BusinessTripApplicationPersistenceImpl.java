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

package com.business.trip.service.persistence;

import com.business.trip.NoSuchBusinessTripApplicationException;
import com.business.trip.model.BusinessTripApplication;
import com.business.trip.model.impl.BusinessTripApplicationImpl;
import com.business.trip.model.impl.BusinessTripApplicationModelImpl;
import com.business.trip.service.persistence.BusinessTripApplicationPersistence;

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
 * The persistence implementation for the business trip application service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BusinessTripApplicationPersistence
 * @see BusinessTripApplicationUtil
 * @generated
 */
public class BusinessTripApplicationPersistenceImpl extends BasePersistenceImpl<BusinessTripApplication>
	implements BusinessTripApplicationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BusinessTripApplicationUtil} to access the business trip application persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BusinessTripApplicationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BusinessTripApplicationModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripApplicationModelImpl.FINDER_CACHE_ENABLED,
			BusinessTripApplicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BusinessTripApplicationModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripApplicationModelImpl.FINDER_CACHE_ENABLED,
			BusinessTripApplicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BusinessTripApplicationModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripApplicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_S_U = new FinderPath(BusinessTripApplicationModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripApplicationModelImpl.FINDER_CACHE_ENABLED,
			BusinessTripApplicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByS_U",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U = new FinderPath(BusinessTripApplicationModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripApplicationModelImpl.FINDER_CACHE_ENABLED,
			BusinessTripApplicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_U",
			new String[] { Integer.class.getName(), Long.class.getName() },
			BusinessTripApplicationModelImpl.STATUS_COLUMN_BITMASK |
			BusinessTripApplicationModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_S_U = new FinderPath(BusinessTripApplicationModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripApplicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_U",
			new String[] { Integer.class.getName(), Long.class.getName() });

	/**
	 * Returns all the business trip applications where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @return the matching business trip applications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessTripApplication> findByS_U(int status, long userId)
		throws SystemException {
		return findByS_U(status, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the business trip applications where status = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param start the lower bound of the range of business trip applications
	 * @param end the upper bound of the range of business trip applications (not inclusive)
	 * @return the range of matching business trip applications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessTripApplication> findByS_U(int status, long userId,
		int start, int end) throws SystemException {
		return findByS_U(status, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the business trip applications where status = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param start the lower bound of the range of business trip applications
	 * @param end the upper bound of the range of business trip applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching business trip applications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessTripApplication> findByS_U(int status, long userId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<BusinessTripApplication> list = (List<BusinessTripApplication>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BusinessTripApplication businessTripApplication : list) {
				if ((status != businessTripApplication.getStatus()) ||
						(userId != businessTripApplication.getUserId())) {
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

			query.append(_SQL_SELECT_BUSINESSTRIPAPPLICATION_WHERE);

			query.append(_FINDER_COLUMN_S_U_STATUS_2);

			query.append(_FINDER_COLUMN_S_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BusinessTripApplicationModelImpl.ORDER_BY_JPQL);
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
					list = (List<BusinessTripApplication>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusinessTripApplication>(list);
				}
				else {
					list = (List<BusinessTripApplication>)QueryUtil.list(q,
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
	 * Returns the first business trip application in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business trip application
	 * @throws com.business.trip.NoSuchBusinessTripApplicationException if a matching business trip application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripApplication findByS_U_First(int status, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchBusinessTripApplicationException, SystemException {
		BusinessTripApplication businessTripApplication = fetchByS_U_First(status,
				userId, orderByComparator);

		if (businessTripApplication != null) {
			return businessTripApplication;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusinessTripApplicationException(msg.toString());
	}

	/**
	 * Returns the first business trip application in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business trip application, or <code>null</code> if a matching business trip application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripApplication fetchByS_U_First(int status, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BusinessTripApplication> list = findByS_U(status, userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last business trip application in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business trip application
	 * @throws com.business.trip.NoSuchBusinessTripApplicationException if a matching business trip application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripApplication findByS_U_Last(int status, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchBusinessTripApplicationException, SystemException {
		BusinessTripApplication businessTripApplication = fetchByS_U_Last(status,
				userId, orderByComparator);

		if (businessTripApplication != null) {
			return businessTripApplication;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusinessTripApplicationException(msg.toString());
	}

	/**
	 * Returns the last business trip application in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business trip application, or <code>null</code> if a matching business trip application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripApplication fetchByS_U_Last(int status, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByS_U(status, userId);

		if (count == 0) {
			return null;
		}

		List<BusinessTripApplication> list = findByS_U(status, userId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the business trip applications before and after the current business trip application in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param businessTripApplicationId the primary key of the current business trip application
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next business trip application
	 * @throws com.business.trip.NoSuchBusinessTripApplicationException if a business trip application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripApplication[] findByS_U_PrevAndNext(
		long businessTripApplicationId, int status, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchBusinessTripApplicationException, SystemException {
		BusinessTripApplication businessTripApplication = findByPrimaryKey(businessTripApplicationId);

		Session session = null;

		try {
			session = openSession();

			BusinessTripApplication[] array = new BusinessTripApplicationImpl[3];

			array[0] = getByS_U_PrevAndNext(session, businessTripApplication,
					status, userId, orderByComparator, true);

			array[1] = businessTripApplication;

			array[2] = getByS_U_PrevAndNext(session, businessTripApplication,
					status, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BusinessTripApplication getByS_U_PrevAndNext(Session session,
		BusinessTripApplication businessTripApplication, int status,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BUSINESSTRIPAPPLICATION_WHERE);

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
			query.append(BusinessTripApplicationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(businessTripApplication);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BusinessTripApplication> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the business trip applications where status = &#63; and userId = &#63; from the database.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByS_U(int status, long userId) throws SystemException {
		for (BusinessTripApplication businessTripApplication : findByS_U(
				status, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(businessTripApplication);
		}
	}

	/**
	 * Returns the number of business trip applications where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @return the number of matching business trip applications
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

			query.append(_SQL_COUNT_BUSINESSTRIPAPPLICATION_WHERE);

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

	private static final String _FINDER_COLUMN_S_U_STATUS_2 = "businessTripApplication.status = ? AND ";
	private static final String _FINDER_COLUMN_S_U_USERID_2 = "businessTripApplication.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(BusinessTripApplicationModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripApplicationModelImpl.FINDER_CACHE_ENABLED,
			BusinessTripApplicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(BusinessTripApplicationModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripApplicationModelImpl.FINDER_CACHE_ENABLED,
			BusinessTripApplicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { Integer.class.getName() },
			BusinessTripApplicationModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(BusinessTripApplicationModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripApplicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the business trip applications where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching business trip applications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessTripApplication> findByStatus(int status)
		throws SystemException {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the business trip applications where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of business trip applications
	 * @param end the upper bound of the range of business trip applications (not inclusive)
	 * @return the range of matching business trip applications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessTripApplication> findByStatus(int status, int start,
		int end) throws SystemException {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the business trip applications where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of business trip applications
	 * @param end the upper bound of the range of business trip applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching business trip applications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessTripApplication> findByStatus(int status, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<BusinessTripApplication> list = (List<BusinessTripApplication>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BusinessTripApplication businessTripApplication : list) {
				if ((status != businessTripApplication.getStatus())) {
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

			query.append(_SQL_SELECT_BUSINESSTRIPAPPLICATION_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BusinessTripApplicationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<BusinessTripApplication>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusinessTripApplication>(list);
				}
				else {
					list = (List<BusinessTripApplication>)QueryUtil.list(q,
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
	 * Returns the first business trip application in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business trip application
	 * @throws com.business.trip.NoSuchBusinessTripApplicationException if a matching business trip application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripApplication findByStatus_First(int status,
		OrderByComparator orderByComparator)
		throws NoSuchBusinessTripApplicationException, SystemException {
		BusinessTripApplication businessTripApplication = fetchByStatus_First(status,
				orderByComparator);

		if (businessTripApplication != null) {
			return businessTripApplication;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusinessTripApplicationException(msg.toString());
	}

	/**
	 * Returns the first business trip application in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business trip application, or <code>null</code> if a matching business trip application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripApplication fetchByStatus_First(int status,
		OrderByComparator orderByComparator) throws SystemException {
		List<BusinessTripApplication> list = findByStatus(status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last business trip application in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business trip application
	 * @throws com.business.trip.NoSuchBusinessTripApplicationException if a matching business trip application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripApplication findByStatus_Last(int status,
		OrderByComparator orderByComparator)
		throws NoSuchBusinessTripApplicationException, SystemException {
		BusinessTripApplication businessTripApplication = fetchByStatus_Last(status,
				orderByComparator);

		if (businessTripApplication != null) {
			return businessTripApplication;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusinessTripApplicationException(msg.toString());
	}

	/**
	 * Returns the last business trip application in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business trip application, or <code>null</code> if a matching business trip application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripApplication fetchByStatus_Last(int status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<BusinessTripApplication> list = findByStatus(status, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the business trip applications before and after the current business trip application in the ordered set where status = &#63;.
	 *
	 * @param businessTripApplicationId the primary key of the current business trip application
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next business trip application
	 * @throws com.business.trip.NoSuchBusinessTripApplicationException if a business trip application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripApplication[] findByStatus_PrevAndNext(
		long businessTripApplicationId, int status,
		OrderByComparator orderByComparator)
		throws NoSuchBusinessTripApplicationException, SystemException {
		BusinessTripApplication businessTripApplication = findByPrimaryKey(businessTripApplicationId);

		Session session = null;

		try {
			session = openSession();

			BusinessTripApplication[] array = new BusinessTripApplicationImpl[3];

			array[0] = getByStatus_PrevAndNext(session,
					businessTripApplication, status, orderByComparator, true);

			array[1] = businessTripApplication;

			array[2] = getByStatus_PrevAndNext(session,
					businessTripApplication, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BusinessTripApplication getByStatus_PrevAndNext(Session session,
		BusinessTripApplication businessTripApplication, int status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BUSINESSTRIPAPPLICATION_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(BusinessTripApplicationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(businessTripApplication);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BusinessTripApplication> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the business trip applications where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStatus(int status) throws SystemException {
		for (BusinessTripApplication businessTripApplication : findByStatus(
				status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(businessTripApplication);
		}
	}

	/**
	 * Returns the number of business trip applications where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching business trip applications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatus(int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BUSINESSTRIPAPPLICATION_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "businessTripApplication.status = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_TICKETNO = new FinderPath(BusinessTripApplicationModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripApplicationModelImpl.FINDER_CACHE_ENABLED,
			BusinessTripApplicationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTicketNo", new String[] { String.class.getName() },
			BusinessTripApplicationModelImpl.TICKETNO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TICKETNO = new FinderPath(BusinessTripApplicationModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripApplicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTicketNo",
			new String[] { String.class.getName() });

	/**
	 * Returns the business trip application where ticketNo = &#63; or throws a {@link com.business.trip.NoSuchBusinessTripApplicationException} if it could not be found.
	 *
	 * @param ticketNo the ticket no
	 * @return the matching business trip application
	 * @throws com.business.trip.NoSuchBusinessTripApplicationException if a matching business trip application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripApplication findByTicketNo(String ticketNo)
		throws NoSuchBusinessTripApplicationException, SystemException {
		BusinessTripApplication businessTripApplication = fetchByTicketNo(ticketNo);

		if (businessTripApplication == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ticketNo=");
			msg.append(ticketNo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBusinessTripApplicationException(msg.toString());
		}

		return businessTripApplication;
	}

	/**
	 * Returns the business trip application where ticketNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ticketNo the ticket no
	 * @return the matching business trip application, or <code>null</code> if a matching business trip application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripApplication fetchByTicketNo(String ticketNo)
		throws SystemException {
		return fetchByTicketNo(ticketNo, true);
	}

	/**
	 * Returns the business trip application where ticketNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ticketNo the ticket no
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching business trip application, or <code>null</code> if a matching business trip application could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripApplication fetchByTicketNo(String ticketNo,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { ticketNo };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TICKETNO,
					finderArgs, this);
		}

		if (result instanceof BusinessTripApplication) {
			BusinessTripApplication businessTripApplication = (BusinessTripApplication)result;

			if (!Validator.equals(ticketNo,
						businessTripApplication.getTicketNo())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_BUSINESSTRIPAPPLICATION_WHERE);

			boolean bindTicketNo = false;

			if (ticketNo == null) {
				query.append(_FINDER_COLUMN_TICKETNO_TICKETNO_1);
			}
			else if (ticketNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TICKETNO_TICKETNO_3);
			}
			else {
				bindTicketNo = true;

				query.append(_FINDER_COLUMN_TICKETNO_TICKETNO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTicketNo) {
					qPos.add(ticketNo);
				}

				List<BusinessTripApplication> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TICKETNO,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BusinessTripApplicationPersistenceImpl.fetchByTicketNo(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					BusinessTripApplication businessTripApplication = list.get(0);

					result = businessTripApplication;

					cacheResult(businessTripApplication);

					if ((businessTripApplication.getTicketNo() == null) ||
							!businessTripApplication.getTicketNo()
														.equals(ticketNo)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TICKETNO,
							finderArgs, businessTripApplication);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TICKETNO,
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
			return (BusinessTripApplication)result;
		}
	}

	/**
	 * Removes the business trip application where ticketNo = &#63; from the database.
	 *
	 * @param ticketNo the ticket no
	 * @return the business trip application that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripApplication removeByTicketNo(String ticketNo)
		throws NoSuchBusinessTripApplicationException, SystemException {
		BusinessTripApplication businessTripApplication = findByTicketNo(ticketNo);

		return remove(businessTripApplication);
	}

	/**
	 * Returns the number of business trip applications where ticketNo = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @return the number of matching business trip applications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTicketNo(String ticketNo) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TICKETNO;

		Object[] finderArgs = new Object[] { ticketNo };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BUSINESSTRIPAPPLICATION_WHERE);

			boolean bindTicketNo = false;

			if (ticketNo == null) {
				query.append(_FINDER_COLUMN_TICKETNO_TICKETNO_1);
			}
			else if (ticketNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TICKETNO_TICKETNO_3);
			}
			else {
				bindTicketNo = true;

				query.append(_FINDER_COLUMN_TICKETNO_TICKETNO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindTicketNo) {
					qPos.add(ticketNo);
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

	private static final String _FINDER_COLUMN_TICKETNO_TICKETNO_1 = "businessTripApplication.ticketNo IS NULL";
	private static final String _FINDER_COLUMN_TICKETNO_TICKETNO_2 = "businessTripApplication.ticketNo = ?";
	private static final String _FINDER_COLUMN_TICKETNO_TICKETNO_3 = "(businessTripApplication.ticketNo IS NULL OR businessTripApplication.ticketNo = '')";

	public BusinessTripApplicationPersistenceImpl() {
		setModelClass(BusinessTripApplication.class);
	}

	/**
	 * Caches the business trip application in the entity cache if it is enabled.
	 *
	 * @param businessTripApplication the business trip application
	 */
	@Override
	public void cacheResult(BusinessTripApplication businessTripApplication) {
		EntityCacheUtil.putResult(BusinessTripApplicationModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripApplicationImpl.class,
			businessTripApplication.getPrimaryKey(), businessTripApplication);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TICKETNO,
			new Object[] { businessTripApplication.getTicketNo() },
			businessTripApplication);

		businessTripApplication.resetOriginalValues();
	}

	/**
	 * Caches the business trip applications in the entity cache if it is enabled.
	 *
	 * @param businessTripApplications the business trip applications
	 */
	@Override
	public void cacheResult(
		List<BusinessTripApplication> businessTripApplications) {
		for (BusinessTripApplication businessTripApplication : businessTripApplications) {
			if (EntityCacheUtil.getResult(
						BusinessTripApplicationModelImpl.ENTITY_CACHE_ENABLED,
						BusinessTripApplicationImpl.class,
						businessTripApplication.getPrimaryKey()) == null) {
				cacheResult(businessTripApplication);
			}
			else {
				businessTripApplication.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all business trip applications.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BusinessTripApplicationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BusinessTripApplicationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the business trip application.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BusinessTripApplication businessTripApplication) {
		EntityCacheUtil.removeResult(BusinessTripApplicationModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripApplicationImpl.class,
			businessTripApplication.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(businessTripApplication);
	}

	@Override
	public void clearCache(
		List<BusinessTripApplication> businessTripApplications) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BusinessTripApplication businessTripApplication : businessTripApplications) {
			EntityCacheUtil.removeResult(BusinessTripApplicationModelImpl.ENTITY_CACHE_ENABLED,
				BusinessTripApplicationImpl.class,
				businessTripApplication.getPrimaryKey());

			clearUniqueFindersCache(businessTripApplication);
		}
	}

	protected void cacheUniqueFindersCache(
		BusinessTripApplication businessTripApplication) {
		if (businessTripApplication.isNew()) {
			Object[] args = new Object[] { businessTripApplication.getTicketNo() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TICKETNO, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TICKETNO, args,
				businessTripApplication);
		}
		else {
			BusinessTripApplicationModelImpl businessTripApplicationModelImpl = (BusinessTripApplicationModelImpl)businessTripApplication;

			if ((businessTripApplicationModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TICKETNO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						businessTripApplication.getTicketNo()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TICKETNO, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TICKETNO, args,
					businessTripApplication);
			}
		}
	}

	protected void clearUniqueFindersCache(
		BusinessTripApplication businessTripApplication) {
		BusinessTripApplicationModelImpl businessTripApplicationModelImpl = (BusinessTripApplicationModelImpl)businessTripApplication;

		Object[] args = new Object[] { businessTripApplication.getTicketNo() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TICKETNO, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TICKETNO, args);

		if ((businessTripApplicationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TICKETNO.getColumnBitmask()) != 0) {
			args = new Object[] {
					businessTripApplicationModelImpl.getOriginalTicketNo()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TICKETNO, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TICKETNO, args);
		}
	}

	/**
	 * Creates a new business trip application with the primary key. Does not add the business trip application to the database.
	 *
	 * @param businessTripApplicationId the primary key for the new business trip application
	 * @return the new business trip application
	 */
	@Override
	public BusinessTripApplication create(long businessTripApplicationId) {
		BusinessTripApplication businessTripApplication = new BusinessTripApplicationImpl();

		businessTripApplication.setNew(true);
		businessTripApplication.setPrimaryKey(businessTripApplicationId);

		return businessTripApplication;
	}

	/**
	 * Removes the business trip application with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param businessTripApplicationId the primary key of the business trip application
	 * @return the business trip application that was removed
	 * @throws com.business.trip.NoSuchBusinessTripApplicationException if a business trip application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripApplication remove(long businessTripApplicationId)
		throws NoSuchBusinessTripApplicationException, SystemException {
		return remove((Serializable)businessTripApplicationId);
	}

	/**
	 * Removes the business trip application with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the business trip application
	 * @return the business trip application that was removed
	 * @throws com.business.trip.NoSuchBusinessTripApplicationException if a business trip application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripApplication remove(Serializable primaryKey)
		throws NoSuchBusinessTripApplicationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BusinessTripApplication businessTripApplication = (BusinessTripApplication)session.get(BusinessTripApplicationImpl.class,
					primaryKey);

			if (businessTripApplication == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBusinessTripApplicationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(businessTripApplication);
		}
		catch (NoSuchBusinessTripApplicationException nsee) {
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
	protected BusinessTripApplication removeImpl(
		BusinessTripApplication businessTripApplication)
		throws SystemException {
		businessTripApplication = toUnwrappedModel(businessTripApplication);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(businessTripApplication)) {
				businessTripApplication = (BusinessTripApplication)session.get(BusinessTripApplicationImpl.class,
						businessTripApplication.getPrimaryKeyObj());
			}

			if (businessTripApplication != null) {
				session.delete(businessTripApplication);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (businessTripApplication != null) {
			clearCache(businessTripApplication);
		}

		return businessTripApplication;
	}

	@Override
	public BusinessTripApplication updateImpl(
		com.business.trip.model.BusinessTripApplication businessTripApplication)
		throws SystemException {
		businessTripApplication = toUnwrappedModel(businessTripApplication);

		boolean isNew = businessTripApplication.isNew();

		BusinessTripApplicationModelImpl businessTripApplicationModelImpl = (BusinessTripApplicationModelImpl)businessTripApplication;

		Session session = null;

		try {
			session = openSession();

			if (businessTripApplication.isNew()) {
				session.save(businessTripApplication);

				businessTripApplication.setNew(false);
			}
			else {
				session.merge(businessTripApplication);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BusinessTripApplicationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((businessTripApplicationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						businessTripApplicationModelImpl.getOriginalStatus(),
						businessTripApplicationModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U,
					args);

				args = new Object[] {
						businessTripApplicationModelImpl.getStatus(),
						businessTripApplicationModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U,
					args);
			}

			if ((businessTripApplicationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						businessTripApplicationModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { businessTripApplicationModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(BusinessTripApplicationModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripApplicationImpl.class,
			businessTripApplication.getPrimaryKey(), businessTripApplication);

		clearUniqueFindersCache(businessTripApplication);
		cacheUniqueFindersCache(businessTripApplication);

		return businessTripApplication;
	}

	protected BusinessTripApplication toUnwrappedModel(
		BusinessTripApplication businessTripApplication) {
		if (businessTripApplication instanceof BusinessTripApplicationImpl) {
			return businessTripApplication;
		}

		BusinessTripApplicationImpl businessTripApplicationImpl = new BusinessTripApplicationImpl();

		businessTripApplicationImpl.setNew(businessTripApplication.isNew());
		businessTripApplicationImpl.setPrimaryKey(businessTripApplication.getPrimaryKey());

		businessTripApplicationImpl.setBusinessTripApplicationId(businessTripApplication.getBusinessTripApplicationId());
		businessTripApplicationImpl.setTicketNo(businessTripApplication.getTicketNo());
		businessTripApplicationImpl.setProcessType(businessTripApplication.getProcessType());
		businessTripApplicationImpl.setSubType(businessTripApplication.getSubType());
		businessTripApplicationImpl.setPrintName(businessTripApplication.getPrintName());
		businessTripApplicationImpl.setStaffCode(businessTripApplication.getStaffCode());
		businessTripApplicationImpl.setCompanyName(businessTripApplication.getCompanyName());
		businessTripApplicationImpl.setDivision(businessTripApplication.getDivision());
		businessTripApplicationImpl.setDepartment(businessTripApplication.getDepartment());
		businessTripApplicationImpl.setCostCenter(businessTripApplication.getCostCenter());
		businessTripApplicationImpl.setPersonalID(businessTripApplication.getPersonalID());
		businessTripApplicationImpl.setPassportNo(businessTripApplication.getPassportNo());
		businessTripApplicationImpl.setOfficePhone(businessTripApplication.getOfficePhone());
		businessTripApplicationImpl.setMobilePhone(businessTripApplication.getMobilePhone());
		businessTripApplicationImpl.setEmail(businessTripApplication.getEmail());
		businessTripApplicationImpl.setOfficeSite(businessTripApplication.getOfficeSite());
		businessTripApplicationImpl.setApproverId(businessTripApplication.getApproverId());
		businessTripApplicationImpl.setApproverName(businessTripApplication.getApproverName());
		businessTripApplicationImpl.setEvpId(businessTripApplication.getEvpId());
		businessTripApplicationImpl.setEvpName(businessTripApplication.getEvpName());
		businessTripApplicationImpl.setIsCrossDepartment(businessTripApplication.isIsCrossDepartment());
		businessTripApplicationImpl.setTargetDepartmentId(businessTripApplication.getTargetDepartmentId());
		businessTripApplicationImpl.setTargetDepartmentName(businessTripApplication.getTargetDepartmentName());
		businessTripApplicationImpl.setTargetCostCenter(businessTripApplication.getTargetCostCenter());
		businessTripApplicationImpl.setTargetDepartmentApproverId(businessTripApplication.getTargetDepartmentApproverId());
		businessTripApplicationImpl.setTargetDepartmentApproverName(businessTripApplication.getTargetDepartmentApproverName());
		businessTripApplicationImpl.setTripType(businessTripApplication.getTripType());
		businessTripApplicationImpl.setDepartureDate(businessTripApplication.getDepartureDate());
		businessTripApplicationImpl.setReturnDate(businessTripApplication.getReturnDate());
		businessTripApplicationImpl.setPurposeOfTheTrip(businessTripApplication.getPurposeOfTheTrip());
		businessTripApplicationImpl.setVisitCountriesCities(businessTripApplication.getVisitCountriesCities());
		businessTripApplicationImpl.setAdvancePayment(businessTripApplication.getAdvancePayment());
		businessTripApplicationImpl.setCurrency(businessTripApplication.getCurrency());
		businessTripApplicationImpl.setPaymentMethods(businessTripApplication.getPaymentMethods());
		businessTripApplicationImpl.setTotalCostRmb(businessTripApplication.getTotalCostRmb());
		businessTripApplicationImpl.setTotalCostEur(businessTripApplication.getTotalCostEur());
		businessTripApplicationImpl.setHotelTotalCostRmb(businessTripApplication.getHotelTotalCostRmb());
		businessTripApplicationImpl.setHotelTotalCostEur(businessTripApplication.getHotelTotalCostEur());
		businessTripApplicationImpl.setCarRentalTotalCostRmb(businessTripApplication.getCarRentalTotalCostRmb());
		businessTripApplicationImpl.setCarRentalTotalCostEur(businessTripApplication.getCarRentalTotalCostEur());
		businessTripApplicationImpl.setRemark(businessTripApplication.getRemark());
		businessTripApplicationImpl.setOtherEmails(businessTripApplication.getOtherEmails());
		businessTripApplicationImpl.setStatus(businessTripApplication.getStatus());
		businessTripApplicationImpl.setSapStatus(businessTripApplication.getSapStatus());
		businessTripApplicationImpl.setSapComments(businessTripApplication.getSapComments());
		businessTripApplicationImpl.setSapDocumentId(businessTripApplication.getSapDocumentId());
		businessTripApplicationImpl.setSapCertificateNo(businessTripApplication.getSapCertificateNo());
		businessTripApplicationImpl.setSapCompany(businessTripApplication.getSapCompany());
		businessTripApplicationImpl.setSapYear(businessTripApplication.getSapYear());
		businessTripApplicationImpl.setStatusByUserId(businessTripApplication.getStatusByUserId());
		businessTripApplicationImpl.setStatusByUserName(businessTripApplication.getStatusByUserName());
		businessTripApplicationImpl.setStatusDate(businessTripApplication.getStatusDate());
		businessTripApplicationImpl.setIsApplicantAgent(businessTripApplication.isIsApplicantAgent());
		businessTripApplicationImpl.setIsApproverAgent(businessTripApplication.isIsApproverAgent());
		businessTripApplicationImpl.setGroupId(businessTripApplication.getGroupId());
		businessTripApplicationImpl.setUserId(businessTripApplication.getUserId());
		businessTripApplicationImpl.setUserName(businessTripApplication.getUserName());
		businessTripApplicationImpl.setCreateDate(businessTripApplication.getCreateDate());
		businessTripApplicationImpl.setModifiedDate(businessTripApplication.getModifiedDate());
		businessTripApplicationImpl.setSubmittedDate(businessTripApplication.getSubmittedDate());
		businessTripApplicationImpl.setCompanyId(businessTripApplication.getCompanyId());

		return businessTripApplicationImpl;
	}

	/**
	 * Returns the business trip application with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the business trip application
	 * @return the business trip application
	 * @throws com.business.trip.NoSuchBusinessTripApplicationException if a business trip application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripApplication findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBusinessTripApplicationException, SystemException {
		BusinessTripApplication businessTripApplication = fetchByPrimaryKey(primaryKey);

		if (businessTripApplication == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBusinessTripApplicationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return businessTripApplication;
	}

	/**
	 * Returns the business trip application with the primary key or throws a {@link com.business.trip.NoSuchBusinessTripApplicationException} if it could not be found.
	 *
	 * @param businessTripApplicationId the primary key of the business trip application
	 * @return the business trip application
	 * @throws com.business.trip.NoSuchBusinessTripApplicationException if a business trip application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripApplication findByPrimaryKey(
		long businessTripApplicationId)
		throws NoSuchBusinessTripApplicationException, SystemException {
		return findByPrimaryKey((Serializable)businessTripApplicationId);
	}

	/**
	 * Returns the business trip application with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the business trip application
	 * @return the business trip application, or <code>null</code> if a business trip application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripApplication fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BusinessTripApplication businessTripApplication = (BusinessTripApplication)EntityCacheUtil.getResult(BusinessTripApplicationModelImpl.ENTITY_CACHE_ENABLED,
				BusinessTripApplicationImpl.class, primaryKey);

		if (businessTripApplication == _nullBusinessTripApplication) {
			return null;
		}

		if (businessTripApplication == null) {
			Session session = null;

			try {
				session = openSession();

				businessTripApplication = (BusinessTripApplication)session.get(BusinessTripApplicationImpl.class,
						primaryKey);

				if (businessTripApplication != null) {
					cacheResult(businessTripApplication);
				}
				else {
					EntityCacheUtil.putResult(BusinessTripApplicationModelImpl.ENTITY_CACHE_ENABLED,
						BusinessTripApplicationImpl.class, primaryKey,
						_nullBusinessTripApplication);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BusinessTripApplicationModelImpl.ENTITY_CACHE_ENABLED,
					BusinessTripApplicationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return businessTripApplication;
	}

	/**
	 * Returns the business trip application with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param businessTripApplicationId the primary key of the business trip application
	 * @return the business trip application, or <code>null</code> if a business trip application with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripApplication fetchByPrimaryKey(
		long businessTripApplicationId) throws SystemException {
		return fetchByPrimaryKey((Serializable)businessTripApplicationId);
	}

	/**
	 * Returns all the business trip applications.
	 *
	 * @return the business trip applications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessTripApplication> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the business trip applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of business trip applications
	 * @param end the upper bound of the range of business trip applications (not inclusive)
	 * @return the range of business trip applications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessTripApplication> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the business trip applications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripApplicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of business trip applications
	 * @param end the upper bound of the range of business trip applications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of business trip applications
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessTripApplication> findAll(int start, int end,
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

		List<BusinessTripApplication> list = (List<BusinessTripApplication>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BUSINESSTRIPAPPLICATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BUSINESSTRIPAPPLICATION;

				if (pagination) {
					sql = sql.concat(BusinessTripApplicationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BusinessTripApplication>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusinessTripApplication>(list);
				}
				else {
					list = (List<BusinessTripApplication>)QueryUtil.list(q,
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
	 * Removes all the business trip applications from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BusinessTripApplication businessTripApplication : findAll()) {
			remove(businessTripApplication);
		}
	}

	/**
	 * Returns the number of business trip applications.
	 *
	 * @return the number of business trip applications
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

				Query q = session.createQuery(_SQL_COUNT_BUSINESSTRIPAPPLICATION);

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
	 * Initializes the business trip application persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.business.trip.model.BusinessTripApplication")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BusinessTripApplication>> listenersList = new ArrayList<ModelListener<BusinessTripApplication>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BusinessTripApplication>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BusinessTripApplicationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BUSINESSTRIPAPPLICATION = "SELECT businessTripApplication FROM BusinessTripApplication businessTripApplication";
	private static final String _SQL_SELECT_BUSINESSTRIPAPPLICATION_WHERE = "SELECT businessTripApplication FROM BusinessTripApplication businessTripApplication WHERE ";
	private static final String _SQL_COUNT_BUSINESSTRIPAPPLICATION = "SELECT COUNT(businessTripApplication) FROM BusinessTripApplication businessTripApplication";
	private static final String _SQL_COUNT_BUSINESSTRIPAPPLICATION_WHERE = "SELECT COUNT(businessTripApplication) FROM BusinessTripApplication businessTripApplication WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "businessTripApplication.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BusinessTripApplication exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BusinessTripApplication exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BusinessTripApplicationPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"currency"
			});
	private static BusinessTripApplication _nullBusinessTripApplication = new BusinessTripApplicationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BusinessTripApplication> toCacheModel() {
				return _nullBusinessTripApplicationCacheModel;
			}
		};

	private static CacheModel<BusinessTripApplication> _nullBusinessTripApplicationCacheModel =
		new CacheModel<BusinessTripApplication>() {
			@Override
			public BusinessTripApplication toEntityModel() {
				return _nullBusinessTripApplication;
			}
		};
}