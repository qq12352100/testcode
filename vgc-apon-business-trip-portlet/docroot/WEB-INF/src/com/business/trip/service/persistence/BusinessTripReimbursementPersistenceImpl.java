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

import com.business.trip.NoSuchBusinessTripReimbursementException;
import com.business.trip.model.BusinessTripReimbursement;
import com.business.trip.model.impl.BusinessTripReimbursementImpl;
import com.business.trip.model.impl.BusinessTripReimbursementModelImpl;
import com.business.trip.service.persistence.BusinessTripReimbursementPersistence;

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
 * The persistence implementation for the business trip reimbursement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BusinessTripReimbursementPersistence
 * @see BusinessTripReimbursementUtil
 * @generated
 */
public class BusinessTripReimbursementPersistenceImpl
	extends BasePersistenceImpl<BusinessTripReimbursement>
	implements BusinessTripReimbursementPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BusinessTripReimbursementUtil} to access the business trip reimbursement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BusinessTripReimbursementImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BusinessTripReimbursementModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripReimbursementModelImpl.FINDER_CACHE_ENABLED,
			BusinessTripReimbursementImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BusinessTripReimbursementModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripReimbursementModelImpl.FINDER_CACHE_ENABLED,
			BusinessTripReimbursementImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BusinessTripReimbursementModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripReimbursementModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_S_U = new FinderPath(BusinessTripReimbursementModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripReimbursementModelImpl.FINDER_CACHE_ENABLED,
			BusinessTripReimbursementImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByS_U",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U = new FinderPath(BusinessTripReimbursementModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripReimbursementModelImpl.FINDER_CACHE_ENABLED,
			BusinessTripReimbursementImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_U",
			new String[] { Integer.class.getName(), Long.class.getName() },
			BusinessTripReimbursementModelImpl.STATUS_COLUMN_BITMASK |
			BusinessTripReimbursementModelImpl.USERID_COLUMN_BITMASK |
			BusinessTripReimbursementModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_S_U = new FinderPath(BusinessTripReimbursementModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripReimbursementModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByS_U",
			new String[] { Integer.class.getName(), Long.class.getName() });

	/**
	 * Returns all the business trip reimbursements where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @return the matching business trip reimbursements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessTripReimbursement> findByS_U(int status, long userId)
		throws SystemException {
		return findByS_U(status, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the business trip reimbursements where status = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripReimbursementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param start the lower bound of the range of business trip reimbursements
	 * @param end the upper bound of the range of business trip reimbursements (not inclusive)
	 * @return the range of matching business trip reimbursements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessTripReimbursement> findByS_U(int status, long userId,
		int start, int end) throws SystemException {
		return findByS_U(status, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the business trip reimbursements where status = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripReimbursementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param start the lower bound of the range of business trip reimbursements
	 * @param end the upper bound of the range of business trip reimbursements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching business trip reimbursements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessTripReimbursement> findByS_U(int status, long userId,
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

		List<BusinessTripReimbursement> list = (List<BusinessTripReimbursement>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BusinessTripReimbursement businessTripReimbursement : list) {
				if ((status != businessTripReimbursement.getStatus()) ||
						(userId != businessTripReimbursement.getUserId())) {
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

			query.append(_SQL_SELECT_BUSINESSTRIPREIMBURSEMENT_WHERE);

			query.append(_FINDER_COLUMN_S_U_STATUS_2);

			query.append(_FINDER_COLUMN_S_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BusinessTripReimbursementModelImpl.ORDER_BY_JPQL);
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
					list = (List<BusinessTripReimbursement>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusinessTripReimbursement>(list);
				}
				else {
					list = (List<BusinessTripReimbursement>)QueryUtil.list(q,
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
	 * Returns the first business trip reimbursement in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business trip reimbursement
	 * @throws com.business.trip.NoSuchBusinessTripReimbursementException if a matching business trip reimbursement could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripReimbursement findByS_U_First(int status, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchBusinessTripReimbursementException, SystemException {
		BusinessTripReimbursement businessTripReimbursement = fetchByS_U_First(status,
				userId, orderByComparator);

		if (businessTripReimbursement != null) {
			return businessTripReimbursement;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusinessTripReimbursementException(msg.toString());
	}

	/**
	 * Returns the first business trip reimbursement in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business trip reimbursement, or <code>null</code> if a matching business trip reimbursement could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripReimbursement fetchByS_U_First(int status, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BusinessTripReimbursement> list = findByS_U(status, userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last business trip reimbursement in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business trip reimbursement
	 * @throws com.business.trip.NoSuchBusinessTripReimbursementException if a matching business trip reimbursement could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripReimbursement findByS_U_Last(int status, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchBusinessTripReimbursementException, SystemException {
		BusinessTripReimbursement businessTripReimbursement = fetchByS_U_Last(status,
				userId, orderByComparator);

		if (businessTripReimbursement != null) {
			return businessTripReimbursement;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusinessTripReimbursementException(msg.toString());
	}

	/**
	 * Returns the last business trip reimbursement in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business trip reimbursement, or <code>null</code> if a matching business trip reimbursement could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripReimbursement fetchByS_U_Last(int status, long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByS_U(status, userId);

		if (count == 0) {
			return null;
		}

		List<BusinessTripReimbursement> list = findByS_U(status, userId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the business trip reimbursements before and after the current business trip reimbursement in the ordered set where status = &#63; and userId = &#63;.
	 *
	 * @param businessTripReimbursementId the primary key of the current business trip reimbursement
	 * @param status the status
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next business trip reimbursement
	 * @throws com.business.trip.NoSuchBusinessTripReimbursementException if a business trip reimbursement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripReimbursement[] findByS_U_PrevAndNext(
		long businessTripReimbursementId, int status, long userId,
		OrderByComparator orderByComparator)
		throws NoSuchBusinessTripReimbursementException, SystemException {
		BusinessTripReimbursement businessTripReimbursement = findByPrimaryKey(businessTripReimbursementId);

		Session session = null;

		try {
			session = openSession();

			BusinessTripReimbursement[] array = new BusinessTripReimbursementImpl[3];

			array[0] = getByS_U_PrevAndNext(session, businessTripReimbursement,
					status, userId, orderByComparator, true);

			array[1] = businessTripReimbursement;

			array[2] = getByS_U_PrevAndNext(session, businessTripReimbursement,
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

	protected BusinessTripReimbursement getByS_U_PrevAndNext(Session session,
		BusinessTripReimbursement businessTripReimbursement, int status,
		long userId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BUSINESSTRIPREIMBURSEMENT_WHERE);

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
			query.append(BusinessTripReimbursementModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(businessTripReimbursement);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BusinessTripReimbursement> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the business trip reimbursements where status = &#63; and userId = &#63; from the database.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByS_U(int status, long userId) throws SystemException {
		for (BusinessTripReimbursement businessTripReimbursement : findByS_U(
				status, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(businessTripReimbursement);
		}
	}

	/**
	 * Returns the number of business trip reimbursements where status = &#63; and userId = &#63;.
	 *
	 * @param status the status
	 * @param userId the user ID
	 * @return the number of matching business trip reimbursements
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

			query.append(_SQL_COUNT_BUSINESSTRIPREIMBURSEMENT_WHERE);

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

	private static final String _FINDER_COLUMN_S_U_STATUS_2 = "businessTripReimbursement.status = ? AND ";
	private static final String _FINDER_COLUMN_S_U_USERID_2 = "businessTripReimbursement.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BUSSINESSTIRPTICKETNO =
		new FinderPath(BusinessTripReimbursementModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripReimbursementModelImpl.FINDER_CACHE_ENABLED,
			BusinessTripReimbursementImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByBussinessTirpTicketNo",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSSINESSTIRPTICKETNO =
		new FinderPath(BusinessTripReimbursementModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripReimbursementModelImpl.FINDER_CACHE_ENABLED,
			BusinessTripReimbursementImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByBussinessTirpTicketNo",
			new String[] { String.class.getName() },
			BusinessTripReimbursementModelImpl.BUSSINESSTIRPTICKETNO_COLUMN_BITMASK |
			BusinessTripReimbursementModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BUSSINESSTIRPTICKETNO = new FinderPath(BusinessTripReimbursementModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripReimbursementModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBussinessTirpTicketNo",
			new String[] { String.class.getName() });

	/**
	 * Returns all the business trip reimbursements where bussinessTirpTicketNo = &#63;.
	 *
	 * @param bussinessTirpTicketNo the bussiness tirp ticket no
	 * @return the matching business trip reimbursements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessTripReimbursement> findByBussinessTirpTicketNo(
		String bussinessTirpTicketNo) throws SystemException {
		return findByBussinessTirpTicketNo(bussinessTirpTicketNo,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the business trip reimbursements where bussinessTirpTicketNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripReimbursementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param bussinessTirpTicketNo the bussiness tirp ticket no
	 * @param start the lower bound of the range of business trip reimbursements
	 * @param end the upper bound of the range of business trip reimbursements (not inclusive)
	 * @return the range of matching business trip reimbursements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessTripReimbursement> findByBussinessTirpTicketNo(
		String bussinessTirpTicketNo, int start, int end)
		throws SystemException {
		return findByBussinessTirpTicketNo(bussinessTirpTicketNo, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the business trip reimbursements where bussinessTirpTicketNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripReimbursementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param bussinessTirpTicketNo the bussiness tirp ticket no
	 * @param start the lower bound of the range of business trip reimbursements
	 * @param end the upper bound of the range of business trip reimbursements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching business trip reimbursements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessTripReimbursement> findByBussinessTirpTicketNo(
		String bussinessTirpTicketNo, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSSINESSTIRPTICKETNO;
			finderArgs = new Object[] { bussinessTirpTicketNo };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BUSSINESSTIRPTICKETNO;
			finderArgs = new Object[] {
					bussinessTirpTicketNo,
					
					start, end, orderByComparator
				};
		}

		List<BusinessTripReimbursement> list = (List<BusinessTripReimbursement>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BusinessTripReimbursement businessTripReimbursement : list) {
				if (!Validator.equals(bussinessTirpTicketNo,
							businessTripReimbursement.getBussinessTirpTicketNo())) {
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

			query.append(_SQL_SELECT_BUSINESSTRIPREIMBURSEMENT_WHERE);

			boolean bindBussinessTirpTicketNo = false;

			if (bussinessTirpTicketNo == null) {
				query.append(_FINDER_COLUMN_BUSSINESSTIRPTICKETNO_BUSSINESSTIRPTICKETNO_1);
			}
			else if (bussinessTirpTicketNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BUSSINESSTIRPTICKETNO_BUSSINESSTIRPTICKETNO_3);
			}
			else {
				bindBussinessTirpTicketNo = true;

				query.append(_FINDER_COLUMN_BUSSINESSTIRPTICKETNO_BUSSINESSTIRPTICKETNO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BusinessTripReimbursementModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBussinessTirpTicketNo) {
					qPos.add(bussinessTirpTicketNo);
				}

				if (!pagination) {
					list = (List<BusinessTripReimbursement>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusinessTripReimbursement>(list);
				}
				else {
					list = (List<BusinessTripReimbursement>)QueryUtil.list(q,
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
	 * Returns the first business trip reimbursement in the ordered set where bussinessTirpTicketNo = &#63;.
	 *
	 * @param bussinessTirpTicketNo the bussiness tirp ticket no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business trip reimbursement
	 * @throws com.business.trip.NoSuchBusinessTripReimbursementException if a matching business trip reimbursement could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripReimbursement findByBussinessTirpTicketNo_First(
		String bussinessTirpTicketNo, OrderByComparator orderByComparator)
		throws NoSuchBusinessTripReimbursementException, SystemException {
		BusinessTripReimbursement businessTripReimbursement = fetchByBussinessTirpTicketNo_First(bussinessTirpTicketNo,
				orderByComparator);

		if (businessTripReimbursement != null) {
			return businessTripReimbursement;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bussinessTirpTicketNo=");
		msg.append(bussinessTirpTicketNo);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusinessTripReimbursementException(msg.toString());
	}

	/**
	 * Returns the first business trip reimbursement in the ordered set where bussinessTirpTicketNo = &#63;.
	 *
	 * @param bussinessTirpTicketNo the bussiness tirp ticket no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching business trip reimbursement, or <code>null</code> if a matching business trip reimbursement could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripReimbursement fetchByBussinessTirpTicketNo_First(
		String bussinessTirpTicketNo, OrderByComparator orderByComparator)
		throws SystemException {
		List<BusinessTripReimbursement> list = findByBussinessTirpTicketNo(bussinessTirpTicketNo,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last business trip reimbursement in the ordered set where bussinessTirpTicketNo = &#63;.
	 *
	 * @param bussinessTirpTicketNo the bussiness tirp ticket no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business trip reimbursement
	 * @throws com.business.trip.NoSuchBusinessTripReimbursementException if a matching business trip reimbursement could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripReimbursement findByBussinessTirpTicketNo_Last(
		String bussinessTirpTicketNo, OrderByComparator orderByComparator)
		throws NoSuchBusinessTripReimbursementException, SystemException {
		BusinessTripReimbursement businessTripReimbursement = fetchByBussinessTirpTicketNo_Last(bussinessTirpTicketNo,
				orderByComparator);

		if (businessTripReimbursement != null) {
			return businessTripReimbursement;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bussinessTirpTicketNo=");
		msg.append(bussinessTirpTicketNo);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBusinessTripReimbursementException(msg.toString());
	}

	/**
	 * Returns the last business trip reimbursement in the ordered set where bussinessTirpTicketNo = &#63;.
	 *
	 * @param bussinessTirpTicketNo the bussiness tirp ticket no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching business trip reimbursement, or <code>null</code> if a matching business trip reimbursement could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripReimbursement fetchByBussinessTirpTicketNo_Last(
		String bussinessTirpTicketNo, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByBussinessTirpTicketNo(bussinessTirpTicketNo);

		if (count == 0) {
			return null;
		}

		List<BusinessTripReimbursement> list = findByBussinessTirpTicketNo(bussinessTirpTicketNo,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the business trip reimbursements before and after the current business trip reimbursement in the ordered set where bussinessTirpTicketNo = &#63;.
	 *
	 * @param businessTripReimbursementId the primary key of the current business trip reimbursement
	 * @param bussinessTirpTicketNo the bussiness tirp ticket no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next business trip reimbursement
	 * @throws com.business.trip.NoSuchBusinessTripReimbursementException if a business trip reimbursement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripReimbursement[] findByBussinessTirpTicketNo_PrevAndNext(
		long businessTripReimbursementId, String bussinessTirpTicketNo,
		OrderByComparator orderByComparator)
		throws NoSuchBusinessTripReimbursementException, SystemException {
		BusinessTripReimbursement businessTripReimbursement = findByPrimaryKey(businessTripReimbursementId);

		Session session = null;

		try {
			session = openSession();

			BusinessTripReimbursement[] array = new BusinessTripReimbursementImpl[3];

			array[0] = getByBussinessTirpTicketNo_PrevAndNext(session,
					businessTripReimbursement, bussinessTirpTicketNo,
					orderByComparator, true);

			array[1] = businessTripReimbursement;

			array[2] = getByBussinessTirpTicketNo_PrevAndNext(session,
					businessTripReimbursement, bussinessTirpTicketNo,
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

	protected BusinessTripReimbursement getByBussinessTirpTicketNo_PrevAndNext(
		Session session, BusinessTripReimbursement businessTripReimbursement,
		String bussinessTirpTicketNo, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BUSINESSTRIPREIMBURSEMENT_WHERE);

		boolean bindBussinessTirpTicketNo = false;

		if (bussinessTirpTicketNo == null) {
			query.append(_FINDER_COLUMN_BUSSINESSTIRPTICKETNO_BUSSINESSTIRPTICKETNO_1);
		}
		else if (bussinessTirpTicketNo.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_BUSSINESSTIRPTICKETNO_BUSSINESSTIRPTICKETNO_3);
		}
		else {
			bindBussinessTirpTicketNo = true;

			query.append(_FINDER_COLUMN_BUSSINESSTIRPTICKETNO_BUSSINESSTIRPTICKETNO_2);
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
			query.append(BusinessTripReimbursementModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindBussinessTirpTicketNo) {
			qPos.add(bussinessTirpTicketNo);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(businessTripReimbursement);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BusinessTripReimbursement> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the business trip reimbursements where bussinessTirpTicketNo = &#63; from the database.
	 *
	 * @param bussinessTirpTicketNo the bussiness tirp ticket no
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBussinessTirpTicketNo(String bussinessTirpTicketNo)
		throws SystemException {
		for (BusinessTripReimbursement businessTripReimbursement : findByBussinessTirpTicketNo(
				bussinessTirpTicketNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(businessTripReimbursement);
		}
	}

	/**
	 * Returns the number of business trip reimbursements where bussinessTirpTicketNo = &#63;.
	 *
	 * @param bussinessTirpTicketNo the bussiness tirp ticket no
	 * @return the number of matching business trip reimbursements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBussinessTirpTicketNo(String bussinessTirpTicketNo)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BUSSINESSTIRPTICKETNO;

		Object[] finderArgs = new Object[] { bussinessTirpTicketNo };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BUSINESSTRIPREIMBURSEMENT_WHERE);

			boolean bindBussinessTirpTicketNo = false;

			if (bussinessTirpTicketNo == null) {
				query.append(_FINDER_COLUMN_BUSSINESSTIRPTICKETNO_BUSSINESSTIRPTICKETNO_1);
			}
			else if (bussinessTirpTicketNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BUSSINESSTIRPTICKETNO_BUSSINESSTIRPTICKETNO_3);
			}
			else {
				bindBussinessTirpTicketNo = true;

				query.append(_FINDER_COLUMN_BUSSINESSTIRPTICKETNO_BUSSINESSTIRPTICKETNO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindBussinessTirpTicketNo) {
					qPos.add(bussinessTirpTicketNo);
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

	private static final String _FINDER_COLUMN_BUSSINESSTIRPTICKETNO_BUSSINESSTIRPTICKETNO_1 =
		"businessTripReimbursement.bussinessTirpTicketNo IS NULL";
	private static final String _FINDER_COLUMN_BUSSINESSTIRPTICKETNO_BUSSINESSTIRPTICKETNO_2 =
		"businessTripReimbursement.bussinessTirpTicketNo = ?";
	private static final String _FINDER_COLUMN_BUSSINESSTIRPTICKETNO_BUSSINESSTIRPTICKETNO_3 =
		"(businessTripReimbursement.bussinessTirpTicketNo IS NULL OR businessTripReimbursement.bussinessTirpTicketNo = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_TICKETNO = new FinderPath(BusinessTripReimbursementModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripReimbursementModelImpl.FINDER_CACHE_ENABLED,
			BusinessTripReimbursementImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTicketNo", new String[] { String.class.getName() },
			BusinessTripReimbursementModelImpl.TICKETNO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TICKETNO = new FinderPath(BusinessTripReimbursementModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripReimbursementModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTicketNo", new String[] { String.class.getName() });

	/**
	 * Returns the business trip reimbursement where ticketNo = &#63; or throws a {@link com.business.trip.NoSuchBusinessTripReimbursementException} if it could not be found.
	 *
	 * @param ticketNo the ticket no
	 * @return the matching business trip reimbursement
	 * @throws com.business.trip.NoSuchBusinessTripReimbursementException if a matching business trip reimbursement could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripReimbursement findByTicketNo(String ticketNo)
		throws NoSuchBusinessTripReimbursementException, SystemException {
		BusinessTripReimbursement businessTripReimbursement = fetchByTicketNo(ticketNo);

		if (businessTripReimbursement == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ticketNo=");
			msg.append(ticketNo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBusinessTripReimbursementException(msg.toString());
		}

		return businessTripReimbursement;
	}

	/**
	 * Returns the business trip reimbursement where ticketNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ticketNo the ticket no
	 * @return the matching business trip reimbursement, or <code>null</code> if a matching business trip reimbursement could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripReimbursement fetchByTicketNo(String ticketNo)
		throws SystemException {
		return fetchByTicketNo(ticketNo, true);
	}

	/**
	 * Returns the business trip reimbursement where ticketNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ticketNo the ticket no
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching business trip reimbursement, or <code>null</code> if a matching business trip reimbursement could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripReimbursement fetchByTicketNo(String ticketNo,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { ticketNo };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TICKETNO,
					finderArgs, this);
		}

		if (result instanceof BusinessTripReimbursement) {
			BusinessTripReimbursement businessTripReimbursement = (BusinessTripReimbursement)result;

			if (!Validator.equals(ticketNo,
						businessTripReimbursement.getTicketNo())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_BUSINESSTRIPREIMBURSEMENT_WHERE);

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

				List<BusinessTripReimbursement> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TICKETNO,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BusinessTripReimbursementPersistenceImpl.fetchByTicketNo(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					BusinessTripReimbursement businessTripReimbursement = list.get(0);

					result = businessTripReimbursement;

					cacheResult(businessTripReimbursement);

					if ((businessTripReimbursement.getTicketNo() == null) ||
							!businessTripReimbursement.getTicketNo()
														  .equals(ticketNo)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TICKETNO,
							finderArgs, businessTripReimbursement);
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
			return (BusinessTripReimbursement)result;
		}
	}

	/**
	 * Removes the business trip reimbursement where ticketNo = &#63; from the database.
	 *
	 * @param ticketNo the ticket no
	 * @return the business trip reimbursement that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripReimbursement removeByTicketNo(String ticketNo)
		throws NoSuchBusinessTripReimbursementException, SystemException {
		BusinessTripReimbursement businessTripReimbursement = findByTicketNo(ticketNo);

		return remove(businessTripReimbursement);
	}

	/**
	 * Returns the number of business trip reimbursements where ticketNo = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @return the number of matching business trip reimbursements
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

			query.append(_SQL_COUNT_BUSINESSTRIPREIMBURSEMENT_WHERE);

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

	private static final String _FINDER_COLUMN_TICKETNO_TICKETNO_1 = "businessTripReimbursement.ticketNo IS NULL";
	private static final String _FINDER_COLUMN_TICKETNO_TICKETNO_2 = "businessTripReimbursement.ticketNo = ?";
	private static final String _FINDER_COLUMN_TICKETNO_TICKETNO_3 = "(businessTripReimbursement.ticketNo IS NULL OR businessTripReimbursement.ticketNo = '')";

	public BusinessTripReimbursementPersistenceImpl() {
		setModelClass(BusinessTripReimbursement.class);
	}

	/**
	 * Caches the business trip reimbursement in the entity cache if it is enabled.
	 *
	 * @param businessTripReimbursement the business trip reimbursement
	 */
	@Override
	public void cacheResult(BusinessTripReimbursement businessTripReimbursement) {
		EntityCacheUtil.putResult(BusinessTripReimbursementModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripReimbursementImpl.class,
			businessTripReimbursement.getPrimaryKey(), businessTripReimbursement);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TICKETNO,
			new Object[] { businessTripReimbursement.getTicketNo() },
			businessTripReimbursement);

		businessTripReimbursement.resetOriginalValues();
	}

	/**
	 * Caches the business trip reimbursements in the entity cache if it is enabled.
	 *
	 * @param businessTripReimbursements the business trip reimbursements
	 */
	@Override
	public void cacheResult(
		List<BusinessTripReimbursement> businessTripReimbursements) {
		for (BusinessTripReimbursement businessTripReimbursement : businessTripReimbursements) {
			if (EntityCacheUtil.getResult(
						BusinessTripReimbursementModelImpl.ENTITY_CACHE_ENABLED,
						BusinessTripReimbursementImpl.class,
						businessTripReimbursement.getPrimaryKey()) == null) {
				cacheResult(businessTripReimbursement);
			}
			else {
				businessTripReimbursement.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all business trip reimbursements.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BusinessTripReimbursementImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BusinessTripReimbursementImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the business trip reimbursement.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BusinessTripReimbursement businessTripReimbursement) {
		EntityCacheUtil.removeResult(BusinessTripReimbursementModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripReimbursementImpl.class,
			businessTripReimbursement.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(businessTripReimbursement);
	}

	@Override
	public void clearCache(
		List<BusinessTripReimbursement> businessTripReimbursements) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BusinessTripReimbursement businessTripReimbursement : businessTripReimbursements) {
			EntityCacheUtil.removeResult(BusinessTripReimbursementModelImpl.ENTITY_CACHE_ENABLED,
				BusinessTripReimbursementImpl.class,
				businessTripReimbursement.getPrimaryKey());

			clearUniqueFindersCache(businessTripReimbursement);
		}
	}

	protected void cacheUniqueFindersCache(
		BusinessTripReimbursement businessTripReimbursement) {
		if (businessTripReimbursement.isNew()) {
			Object[] args = new Object[] { businessTripReimbursement.getTicketNo() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TICKETNO, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TICKETNO, args,
				businessTripReimbursement);
		}
		else {
			BusinessTripReimbursementModelImpl businessTripReimbursementModelImpl =
				(BusinessTripReimbursementModelImpl)businessTripReimbursement;

			if ((businessTripReimbursementModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TICKETNO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						businessTripReimbursement.getTicketNo()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TICKETNO, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TICKETNO, args,
					businessTripReimbursement);
			}
		}
	}

	protected void clearUniqueFindersCache(
		BusinessTripReimbursement businessTripReimbursement) {
		BusinessTripReimbursementModelImpl businessTripReimbursementModelImpl = (BusinessTripReimbursementModelImpl)businessTripReimbursement;

		Object[] args = new Object[] { businessTripReimbursement.getTicketNo() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TICKETNO, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TICKETNO, args);

		if ((businessTripReimbursementModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TICKETNO.getColumnBitmask()) != 0) {
			args = new Object[] {
					businessTripReimbursementModelImpl.getOriginalTicketNo()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TICKETNO, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TICKETNO, args);
		}
	}

	/**
	 * Creates a new business trip reimbursement with the primary key. Does not add the business trip reimbursement to the database.
	 *
	 * @param businessTripReimbursementId the primary key for the new business trip reimbursement
	 * @return the new business trip reimbursement
	 */
	@Override
	public BusinessTripReimbursement create(long businessTripReimbursementId) {
		BusinessTripReimbursement businessTripReimbursement = new BusinessTripReimbursementImpl();

		businessTripReimbursement.setNew(true);
		businessTripReimbursement.setPrimaryKey(businessTripReimbursementId);

		return businessTripReimbursement;
	}

	/**
	 * Removes the business trip reimbursement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param businessTripReimbursementId the primary key of the business trip reimbursement
	 * @return the business trip reimbursement that was removed
	 * @throws com.business.trip.NoSuchBusinessTripReimbursementException if a business trip reimbursement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripReimbursement remove(long businessTripReimbursementId)
		throws NoSuchBusinessTripReimbursementException, SystemException {
		return remove((Serializable)businessTripReimbursementId);
	}

	/**
	 * Removes the business trip reimbursement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the business trip reimbursement
	 * @return the business trip reimbursement that was removed
	 * @throws com.business.trip.NoSuchBusinessTripReimbursementException if a business trip reimbursement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripReimbursement remove(Serializable primaryKey)
		throws NoSuchBusinessTripReimbursementException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BusinessTripReimbursement businessTripReimbursement = (BusinessTripReimbursement)session.get(BusinessTripReimbursementImpl.class,
					primaryKey);

			if (businessTripReimbursement == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBusinessTripReimbursementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(businessTripReimbursement);
		}
		catch (NoSuchBusinessTripReimbursementException nsee) {
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
	protected BusinessTripReimbursement removeImpl(
		BusinessTripReimbursement businessTripReimbursement)
		throws SystemException {
		businessTripReimbursement = toUnwrappedModel(businessTripReimbursement);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(businessTripReimbursement)) {
				businessTripReimbursement = (BusinessTripReimbursement)session.get(BusinessTripReimbursementImpl.class,
						businessTripReimbursement.getPrimaryKeyObj());
			}

			if (businessTripReimbursement != null) {
				session.delete(businessTripReimbursement);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (businessTripReimbursement != null) {
			clearCache(businessTripReimbursement);
		}

		return businessTripReimbursement;
	}

	@Override
	public BusinessTripReimbursement updateImpl(
		com.business.trip.model.BusinessTripReimbursement businessTripReimbursement)
		throws SystemException {
		businessTripReimbursement = toUnwrappedModel(businessTripReimbursement);

		boolean isNew = businessTripReimbursement.isNew();

		BusinessTripReimbursementModelImpl businessTripReimbursementModelImpl = (BusinessTripReimbursementModelImpl)businessTripReimbursement;

		Session session = null;

		try {
			session = openSession();

			if (businessTripReimbursement.isNew()) {
				session.save(businessTripReimbursement);

				businessTripReimbursement.setNew(false);
			}
			else {
				session.merge(businessTripReimbursement);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!BusinessTripReimbursementModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((businessTripReimbursementModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						businessTripReimbursementModelImpl.getOriginalStatus(),
						businessTripReimbursementModelImpl.getOriginalUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U,
					args);

				args = new Object[] {
						businessTripReimbursementModelImpl.getStatus(),
						businessTripReimbursementModelImpl.getUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S_U, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_S_U,
					args);
			}

			if ((businessTripReimbursementModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSSINESSTIRPTICKETNO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						businessTripReimbursementModelImpl.getOriginalBussinessTirpTicketNo()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BUSSINESSTIRPTICKETNO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSSINESSTIRPTICKETNO,
					args);

				args = new Object[] {
						businessTripReimbursementModelImpl.getBussinessTirpTicketNo()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BUSSINESSTIRPTICKETNO,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSSINESSTIRPTICKETNO,
					args);
			}
		}

		EntityCacheUtil.putResult(BusinessTripReimbursementModelImpl.ENTITY_CACHE_ENABLED,
			BusinessTripReimbursementImpl.class,
			businessTripReimbursement.getPrimaryKey(), businessTripReimbursement);

		clearUniqueFindersCache(businessTripReimbursement);
		cacheUniqueFindersCache(businessTripReimbursement);

		return businessTripReimbursement;
	}

	protected BusinessTripReimbursement toUnwrappedModel(
		BusinessTripReimbursement businessTripReimbursement) {
		if (businessTripReimbursement instanceof BusinessTripReimbursementImpl) {
			return businessTripReimbursement;
		}

		BusinessTripReimbursementImpl businessTripReimbursementImpl = new BusinessTripReimbursementImpl();

		businessTripReimbursementImpl.setNew(businessTripReimbursement.isNew());
		businessTripReimbursementImpl.setPrimaryKey(businessTripReimbursement.getPrimaryKey());

		businessTripReimbursementImpl.setBusinessTripReimbursementId(businessTripReimbursement.getBusinessTripReimbursementId());
		businessTripReimbursementImpl.setTicketNo(businessTripReimbursement.getTicketNo());
		businessTripReimbursementImpl.setBussinessTirpTicketNo(businessTripReimbursement.getBussinessTirpTicketNo());
		businessTripReimbursementImpl.setProcessType(businessTripReimbursement.getProcessType());
		businessTripReimbursementImpl.setSubType(businessTripReimbursement.getSubType());
		businessTripReimbursementImpl.setPrintName(businessTripReimbursement.getPrintName());
		businessTripReimbursementImpl.setStaffCode(businessTripReimbursement.getStaffCode());
		businessTripReimbursementImpl.setCompanyName(businessTripReimbursement.getCompanyName());
		businessTripReimbursementImpl.setDivision(businessTripReimbursement.getDivision());
		businessTripReimbursementImpl.setDepartment(businessTripReimbursement.getDepartment());
		businessTripReimbursementImpl.setCostCenter(businessTripReimbursement.getCostCenter());
		businessTripReimbursementImpl.setPersonalID(businessTripReimbursement.getPersonalID());
		businessTripReimbursementImpl.setPassportNo(businessTripReimbursement.getPassportNo());
		businessTripReimbursementImpl.setOfficePhone(businessTripReimbursement.getOfficePhone());
		businessTripReimbursementImpl.setMobilePhone(businessTripReimbursement.getMobilePhone());
		businessTripReimbursementImpl.setEmail(businessTripReimbursement.getEmail());
		businessTripReimbursementImpl.setOfficeSite(businessTripReimbursement.getOfficeSite());
		businessTripReimbursementImpl.setApproverId(businessTripReimbursement.getApproverId());
		businessTripReimbursementImpl.setApproverName(businessTripReimbursement.getApproverName());
		businessTripReimbursementImpl.setIsCrossDepartment(businessTripReimbursement.isIsCrossDepartment());
		businessTripReimbursementImpl.setTargetDepartmentId(businessTripReimbursement.getTargetDepartmentId());
		businessTripReimbursementImpl.setTargetDepartmentName(businessTripReimbursement.getTargetDepartmentName());
		businessTripReimbursementImpl.setTargetCostCenter(businessTripReimbursement.getTargetCostCenter());
		businessTripReimbursementImpl.setTargetDepartmentApproverId(businessTripReimbursement.getTargetDepartmentApproverId());
		businessTripReimbursementImpl.setTargetDepartmentApproverName(businessTripReimbursement.getTargetDepartmentApproverName());
		businessTripReimbursementImpl.setTripType(businessTripReimbursement.getTripType());
		businessTripReimbursementImpl.setDepartureDate(businessTripReimbursement.getDepartureDate());
		businessTripReimbursementImpl.setReturnDate(businessTripReimbursement.getReturnDate());
		businessTripReimbursementImpl.setPurposeOfTheTrip(businessTripReimbursement.getPurposeOfTheTrip());
		businessTripReimbursementImpl.setVisitCountriesCities(businessTripReimbursement.getVisitCountriesCities());
		businessTripReimbursementImpl.setAdvancePayment(businessTripReimbursement.getAdvancePayment());
		businessTripReimbursementImpl.setCurrency(businessTripReimbursement.getCurrency());
		businessTripReimbursementImpl.setPaymentMethods(businessTripReimbursement.getPaymentMethods());
		businessTripReimbursementImpl.setTotalCostRmb(businessTripReimbursement.getTotalCostRmb());
		businessTripReimbursementImpl.setTotalCostEur(businessTripReimbursement.getTotalCostEur());
		businessTripReimbursementImpl.setOrgTotalCostRmb(businessTripReimbursement.getOrgTotalCostRmb());
		businessTripReimbursementImpl.setOrgTotalCostEur(businessTripReimbursement.getOrgTotalCostEur());
		businessTripReimbursementImpl.setHotelTotalCostRmb(businessTripReimbursement.getHotelTotalCostRmb());
		businessTripReimbursementImpl.setHotelTotalCostEur(businessTripReimbursement.getHotelTotalCostEur());
		businessTripReimbursementImpl.setCarRentalTotalCostRmb(businessTripReimbursement.getCarRentalTotalCostRmb());
		businessTripReimbursementImpl.setCarRentalTotalCostEur(businessTripReimbursement.getCarRentalTotalCostEur());
		businessTripReimbursementImpl.setFlightCurrency(businessTripReimbursement.getFlightCurrency());
		businessTripReimbursementImpl.setFlightTotal(businessTripReimbursement.getFlightTotal());
		businessTripReimbursementImpl.setFlightAirFare(businessTripReimbursement.getFlightAirFare());
		businessTripReimbursementImpl.setFlightTaxes(businessTripReimbursement.getFlightTaxes());
		businessTripReimbursementImpl.setFlightTransactionFee(businessTripReimbursement.getFlightTransactionFee());
		businessTripReimbursementImpl.setTotalTravelExpenseRmb(businessTripReimbursement.getTotalTravelExpenseRmb());
		businessTripReimbursementImpl.setTotalTravelExpenseEur(businessTripReimbursement.getTotalTravelExpenseEur());
		businessTripReimbursementImpl.setCostListInlandTotalRmb(businessTripReimbursement.getCostListInlandTotalRmb());
		businessTripReimbursementImpl.setCostListForeignTotalEur(businessTripReimbursement.getCostListForeignTotalEur());
		businessTripReimbursementImpl.setCostListForeignTotalRmb(businessTripReimbursement.getCostListForeignTotalRmb());
		businessTripReimbursementImpl.setRemark(businessTripReimbursement.getRemark());
		businessTripReimbursementImpl.setIsPaybyRmb(businessTripReimbursement.isIsPaybyRmb());
		businessTripReimbursementImpl.setStatus(businessTripReimbursement.getStatus());
		businessTripReimbursementImpl.setSapStatus(businessTripReimbursement.getSapStatus());
		businessTripReimbursementImpl.setSapComments(businessTripReimbursement.getSapComments());
		businessTripReimbursementImpl.setSapDocumentId(businessTripReimbursement.getSapDocumentId());
		businessTripReimbursementImpl.setStatusByUserId(businessTripReimbursement.getStatusByUserId());
		businessTripReimbursementImpl.setStatusByUserName(businessTripReimbursement.getStatusByUserName());
		businessTripReimbursementImpl.setStatusDate(businessTripReimbursement.getStatusDate());
		businessTripReimbursementImpl.setIsApplicantAgent(businessTripReimbursement.isIsApplicantAgent());
		businessTripReimbursementImpl.setIsApproverAgent(businessTripReimbursement.isIsApproverAgent());
		businessTripReimbursementImpl.setGroupId(businessTripReimbursement.getGroupId());
		businessTripReimbursementImpl.setUserId(businessTripReimbursement.getUserId());
		businessTripReimbursementImpl.setUserName(businessTripReimbursement.getUserName());
		businessTripReimbursementImpl.setCreateDate(businessTripReimbursement.getCreateDate());
		businessTripReimbursementImpl.setModifiedDate(businessTripReimbursement.getModifiedDate());
		businessTripReimbursementImpl.setSubmittedDate(businessTripReimbursement.getSubmittedDate());
		businessTripReimbursementImpl.setCompanyId(businessTripReimbursement.getCompanyId());

		return businessTripReimbursementImpl;
	}

	/**
	 * Returns the business trip reimbursement with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the business trip reimbursement
	 * @return the business trip reimbursement
	 * @throws com.business.trip.NoSuchBusinessTripReimbursementException if a business trip reimbursement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripReimbursement findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBusinessTripReimbursementException, SystemException {
		BusinessTripReimbursement businessTripReimbursement = fetchByPrimaryKey(primaryKey);

		if (businessTripReimbursement == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBusinessTripReimbursementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return businessTripReimbursement;
	}

	/**
	 * Returns the business trip reimbursement with the primary key or throws a {@link com.business.trip.NoSuchBusinessTripReimbursementException} if it could not be found.
	 *
	 * @param businessTripReimbursementId the primary key of the business trip reimbursement
	 * @return the business trip reimbursement
	 * @throws com.business.trip.NoSuchBusinessTripReimbursementException if a business trip reimbursement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripReimbursement findByPrimaryKey(
		long businessTripReimbursementId)
		throws NoSuchBusinessTripReimbursementException, SystemException {
		return findByPrimaryKey((Serializable)businessTripReimbursementId);
	}

	/**
	 * Returns the business trip reimbursement with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the business trip reimbursement
	 * @return the business trip reimbursement, or <code>null</code> if a business trip reimbursement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripReimbursement fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BusinessTripReimbursement businessTripReimbursement = (BusinessTripReimbursement)EntityCacheUtil.getResult(BusinessTripReimbursementModelImpl.ENTITY_CACHE_ENABLED,
				BusinessTripReimbursementImpl.class, primaryKey);

		if (businessTripReimbursement == _nullBusinessTripReimbursement) {
			return null;
		}

		if (businessTripReimbursement == null) {
			Session session = null;

			try {
				session = openSession();

				businessTripReimbursement = (BusinessTripReimbursement)session.get(BusinessTripReimbursementImpl.class,
						primaryKey);

				if (businessTripReimbursement != null) {
					cacheResult(businessTripReimbursement);
				}
				else {
					EntityCacheUtil.putResult(BusinessTripReimbursementModelImpl.ENTITY_CACHE_ENABLED,
						BusinessTripReimbursementImpl.class, primaryKey,
						_nullBusinessTripReimbursement);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BusinessTripReimbursementModelImpl.ENTITY_CACHE_ENABLED,
					BusinessTripReimbursementImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return businessTripReimbursement;
	}

	/**
	 * Returns the business trip reimbursement with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param businessTripReimbursementId the primary key of the business trip reimbursement
	 * @return the business trip reimbursement, or <code>null</code> if a business trip reimbursement with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BusinessTripReimbursement fetchByPrimaryKey(
		long businessTripReimbursementId) throws SystemException {
		return fetchByPrimaryKey((Serializable)businessTripReimbursementId);
	}

	/**
	 * Returns all the business trip reimbursements.
	 *
	 * @return the business trip reimbursements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessTripReimbursement> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the business trip reimbursements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripReimbursementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of business trip reimbursements
	 * @param end the upper bound of the range of business trip reimbursements (not inclusive)
	 * @return the range of business trip reimbursements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessTripReimbursement> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the business trip reimbursements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BusinessTripReimbursementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of business trip reimbursements
	 * @param end the upper bound of the range of business trip reimbursements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of business trip reimbursements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BusinessTripReimbursement> findAll(int start, int end,
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

		List<BusinessTripReimbursement> list = (List<BusinessTripReimbursement>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BUSINESSTRIPREIMBURSEMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BUSINESSTRIPREIMBURSEMENT;

				if (pagination) {
					sql = sql.concat(BusinessTripReimbursementModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BusinessTripReimbursement>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BusinessTripReimbursement>(list);
				}
				else {
					list = (List<BusinessTripReimbursement>)QueryUtil.list(q,
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
	 * Removes all the business trip reimbursements from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BusinessTripReimbursement businessTripReimbursement : findAll()) {
			remove(businessTripReimbursement);
		}
	}

	/**
	 * Returns the number of business trip reimbursements.
	 *
	 * @return the number of business trip reimbursements
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

				Query q = session.createQuery(_SQL_COUNT_BUSINESSTRIPREIMBURSEMENT);

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
	 * Initializes the business trip reimbursement persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.business.trip.model.BusinessTripReimbursement")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BusinessTripReimbursement>> listenersList = new ArrayList<ModelListener<BusinessTripReimbursement>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BusinessTripReimbursement>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BusinessTripReimbursementImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BUSINESSTRIPREIMBURSEMENT = "SELECT businessTripReimbursement FROM BusinessTripReimbursement businessTripReimbursement";
	private static final String _SQL_SELECT_BUSINESSTRIPREIMBURSEMENT_WHERE = "SELECT businessTripReimbursement FROM BusinessTripReimbursement businessTripReimbursement WHERE ";
	private static final String _SQL_COUNT_BUSINESSTRIPREIMBURSEMENT = "SELECT COUNT(businessTripReimbursement) FROM BusinessTripReimbursement businessTripReimbursement";
	private static final String _SQL_COUNT_BUSINESSTRIPREIMBURSEMENT_WHERE = "SELECT COUNT(businessTripReimbursement) FROM BusinessTripReimbursement businessTripReimbursement WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "businessTripReimbursement.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BusinessTripReimbursement exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BusinessTripReimbursement exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BusinessTripReimbursementPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"currency"
			});
	private static BusinessTripReimbursement _nullBusinessTripReimbursement = new BusinessTripReimbursementImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BusinessTripReimbursement> toCacheModel() {
				return _nullBusinessTripReimbursementCacheModel;
			}
		};

	private static CacheModel<BusinessTripReimbursement> _nullBusinessTripReimbursementCacheModel =
		new CacheModel<BusinessTripReimbursement>() {
			@Override
			public BusinessTripReimbursement toEntityModel() {
				return _nullBusinessTripReimbursement;
			}
		};
}