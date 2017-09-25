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

import com.business.trip.NoSuchBtTravelExpenseException;
import com.business.trip.model.BtTravelExpense;
import com.business.trip.model.impl.BtTravelExpenseImpl;
import com.business.trip.model.impl.BtTravelExpenseModelImpl;

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
 * The persistence implementation for the bt travel expense service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtTravelExpensePersistence
 * @see BtTravelExpenseUtil
 * @generated
 */
public class BtTravelExpensePersistenceImpl extends BasePersistenceImpl<BtTravelExpense>
	implements BtTravelExpensePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BtTravelExpenseUtil} to access the bt travel expense persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BtTravelExpenseImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
			BtTravelExpenseModelImpl.FINDER_CACHE_ENABLED,
			BtTravelExpenseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
			BtTravelExpenseModelImpl.FINDER_CACHE_ENABLED,
			BtTravelExpenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
			BtTravelExpenseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_T_T = new FinderPath(BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
			BtTravelExpenseModelImpl.FINDER_CACHE_ENABLED,
			BtTravelExpenseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByT_T",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T = new FinderPath(BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
			BtTravelExpenseModelImpl.FINDER_CACHE_ENABLED,
			BtTravelExpenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByT_T",
			new String[] { String.class.getName(), String.class.getName() },
			BtTravelExpenseModelImpl.TICKETNO_COLUMN_BITMASK |
			BtTravelExpenseModelImpl.TRIPTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_T_T = new FinderPath(BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
			BtTravelExpenseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByT_T",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the bt travel expenses where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @return the matching bt travel expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTravelExpense> findByT_T(String ticketNo, String tripType)
		throws SystemException {
		return findByT_T(ticketNo, tripType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bt travel expenses where ticketNo = &#63; and tripType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param start the lower bound of the range of bt travel expenses
	 * @param end the upper bound of the range of bt travel expenses (not inclusive)
	 * @return the range of matching bt travel expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTravelExpense> findByT_T(String ticketNo, String tripType,
		int start, int end) throws SystemException {
		return findByT_T(ticketNo, tripType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt travel expenses where ticketNo = &#63; and tripType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param start the lower bound of the range of bt travel expenses
	 * @param end the upper bound of the range of bt travel expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bt travel expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTravelExpense> findByT_T(String ticketNo, String tripType,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T;
			finderArgs = new Object[] { ticketNo, tripType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_T_T;
			finderArgs = new Object[] {
					ticketNo, tripType,
					
					start, end, orderByComparator
				};
		}

		List<BtTravelExpense> list = (List<BtTravelExpense>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BtTravelExpense btTravelExpense : list) {
				if (!Validator.equals(ticketNo, btTravelExpense.getTicketNo()) ||
						!Validator.equals(tripType,
							btTravelExpense.getTripType())) {
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

			query.append(_SQL_SELECT_BTTRAVELEXPENSE_WHERE);

			boolean bindTicketNo = false;

			if (ticketNo == null) {
				query.append(_FINDER_COLUMN_T_T_TICKETNO_1);
			}
			else if (ticketNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_T_T_TICKETNO_3);
			}
			else {
				bindTicketNo = true;

				query.append(_FINDER_COLUMN_T_T_TICKETNO_2);
			}

			boolean bindTripType = false;

			if (tripType == null) {
				query.append(_FINDER_COLUMN_T_T_TRIPTYPE_1);
			}
			else if (tripType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_T_T_TRIPTYPE_3);
			}
			else {
				bindTripType = true;

				query.append(_FINDER_COLUMN_T_T_TRIPTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BtTravelExpenseModelImpl.ORDER_BY_JPQL);
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

				if (bindTripType) {
					qPos.add(tripType);
				}

				if (!pagination) {
					list = (List<BtTravelExpense>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtTravelExpense>(list);
				}
				else {
					list = (List<BtTravelExpense>)QueryUtil.list(q,
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
	 * Returns the first bt travel expense in the ordered set where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt travel expense
	 * @throws com.business.trip.NoSuchBtTravelExpenseException if a matching bt travel expense could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense findByT_T_First(String ticketNo, String tripType,
		OrderByComparator orderByComparator)
		throws NoSuchBtTravelExpenseException, SystemException {
		BtTravelExpense btTravelExpense = fetchByT_T_First(ticketNo, tripType,
				orderByComparator);

		if (btTravelExpense != null) {
			return btTravelExpense;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketNo=");
		msg.append(ticketNo);

		msg.append(", tripType=");
		msg.append(tripType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtTravelExpenseException(msg.toString());
	}

	/**
	 * Returns the first bt travel expense in the ordered set where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt travel expense, or <code>null</code> if a matching bt travel expense could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense fetchByT_T_First(String ticketNo, String tripType,
		OrderByComparator orderByComparator) throws SystemException {
		List<BtTravelExpense> list = findByT_T(ticketNo, tripType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bt travel expense in the ordered set where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt travel expense
	 * @throws com.business.trip.NoSuchBtTravelExpenseException if a matching bt travel expense could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense findByT_T_Last(String ticketNo, String tripType,
		OrderByComparator orderByComparator)
		throws NoSuchBtTravelExpenseException, SystemException {
		BtTravelExpense btTravelExpense = fetchByT_T_Last(ticketNo, tripType,
				orderByComparator);

		if (btTravelExpense != null) {
			return btTravelExpense;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketNo=");
		msg.append(ticketNo);

		msg.append(", tripType=");
		msg.append(tripType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtTravelExpenseException(msg.toString());
	}

	/**
	 * Returns the last bt travel expense in the ordered set where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt travel expense, or <code>null</code> if a matching bt travel expense could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense fetchByT_T_Last(String ticketNo, String tripType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByT_T(ticketNo, tripType);

		if (count == 0) {
			return null;
		}

		List<BtTravelExpense> list = findByT_T(ticketNo, tripType, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bt travel expenses before and after the current bt travel expense in the ordered set where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param btTravelExpenseId the primary key of the current bt travel expense
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bt travel expense
	 * @throws com.business.trip.NoSuchBtTravelExpenseException if a bt travel expense with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense[] findByT_T_PrevAndNext(long btTravelExpenseId,
		String ticketNo, String tripType, OrderByComparator orderByComparator)
		throws NoSuchBtTravelExpenseException, SystemException {
		BtTravelExpense btTravelExpense = findByPrimaryKey(btTravelExpenseId);

		Session session = null;

		try {
			session = openSession();

			BtTravelExpense[] array = new BtTravelExpenseImpl[3];

			array[0] = getByT_T_PrevAndNext(session, btTravelExpense, ticketNo,
					tripType, orderByComparator, true);

			array[1] = btTravelExpense;

			array[2] = getByT_T_PrevAndNext(session, btTravelExpense, ticketNo,
					tripType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BtTravelExpense getByT_T_PrevAndNext(Session session,
		BtTravelExpense btTravelExpense, String ticketNo, String tripType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BTTRAVELEXPENSE_WHERE);

		boolean bindTicketNo = false;

		if (ticketNo == null) {
			query.append(_FINDER_COLUMN_T_T_TICKETNO_1);
		}
		else if (ticketNo.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_T_T_TICKETNO_3);
		}
		else {
			bindTicketNo = true;

			query.append(_FINDER_COLUMN_T_T_TICKETNO_2);
		}

		boolean bindTripType = false;

		if (tripType == null) {
			query.append(_FINDER_COLUMN_T_T_TRIPTYPE_1);
		}
		else if (tripType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_T_T_TRIPTYPE_3);
		}
		else {
			bindTripType = true;

			query.append(_FINDER_COLUMN_T_T_TRIPTYPE_2);
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
			query.append(BtTravelExpenseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTicketNo) {
			qPos.add(ticketNo);
		}

		if (bindTripType) {
			qPos.add(tripType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(btTravelExpense);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BtTravelExpense> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bt travel expenses where ticketNo = &#63; and tripType = &#63; from the database.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByT_T(String ticketNo, String tripType)
		throws SystemException {
		for (BtTravelExpense btTravelExpense : findByT_T(ticketNo, tripType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(btTravelExpense);
		}
	}

	/**
	 * Returns the number of bt travel expenses where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @return the number of matching bt travel expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByT_T(String ticketNo, String tripType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_T_T;

		Object[] finderArgs = new Object[] { ticketNo, tripType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BTTRAVELEXPENSE_WHERE);

			boolean bindTicketNo = false;

			if (ticketNo == null) {
				query.append(_FINDER_COLUMN_T_T_TICKETNO_1);
			}
			else if (ticketNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_T_T_TICKETNO_3);
			}
			else {
				bindTicketNo = true;

				query.append(_FINDER_COLUMN_T_T_TICKETNO_2);
			}

			boolean bindTripType = false;

			if (tripType == null) {
				query.append(_FINDER_COLUMN_T_T_TRIPTYPE_1);
			}
			else if (tripType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_T_T_TRIPTYPE_3);
			}
			else {
				bindTripType = true;

				query.append(_FINDER_COLUMN_T_T_TRIPTYPE_2);
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

				if (bindTripType) {
					qPos.add(tripType);
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

	private static final String _FINDER_COLUMN_T_T_TICKETNO_1 = "btTravelExpense.ticketNo IS NULL AND ";
	private static final String _FINDER_COLUMN_T_T_TICKETNO_2 = "btTravelExpense.ticketNo = ? AND ";
	private static final String _FINDER_COLUMN_T_T_TICKETNO_3 = "(btTravelExpense.ticketNo IS NULL OR btTravelExpense.ticketNo = '') AND ";
	private static final String _FINDER_COLUMN_T_T_TRIPTYPE_1 = "btTravelExpense.tripType IS NULL";
	private static final String _FINDER_COLUMN_T_T_TRIPTYPE_2 = "btTravelExpense.tripType = ?";
	private static final String _FINDER_COLUMN_T_T_TRIPTYPE_3 = "(btTravelExpense.tripType IS NULL OR btTravelExpense.tripType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_B_T = new FinderPath(BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
			BtTravelExpenseModelImpl.FINDER_CACHE_ENABLED,
			BtTravelExpenseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByB_T",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_T = new FinderPath(BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
			BtTravelExpenseModelImpl.FINDER_CACHE_ENABLED,
			BtTravelExpenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByB_T",
			new String[] { Long.class.getName(), String.class.getName() },
			BtTravelExpenseModelImpl.BUSINESSTRIPPKID_COLUMN_BITMASK |
			BtTravelExpenseModelImpl.TRIPTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_B_T = new FinderPath(BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
			BtTravelExpenseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_T",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the bt travel expenses where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @return the matching bt travel expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTravelExpense> findByB_T(long businessTripPkId,
		String tripType) throws SystemException {
		return findByB_T(businessTripPkId, tripType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bt travel expenses where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param start the lower bound of the range of bt travel expenses
	 * @param end the upper bound of the range of bt travel expenses (not inclusive)
	 * @return the range of matching bt travel expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTravelExpense> findByB_T(long businessTripPkId,
		String tripType, int start, int end) throws SystemException {
		return findByB_T(businessTripPkId, tripType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt travel expenses where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param start the lower bound of the range of bt travel expenses
	 * @param end the upper bound of the range of bt travel expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bt travel expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTravelExpense> findByB_T(long businessTripPkId,
		String tripType, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_T;
			finderArgs = new Object[] { businessTripPkId, tripType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_B_T;
			finderArgs = new Object[] {
					businessTripPkId, tripType,
					
					start, end, orderByComparator
				};
		}

		List<BtTravelExpense> list = (List<BtTravelExpense>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BtTravelExpense btTravelExpense : list) {
				if ((businessTripPkId != btTravelExpense.getBusinessTripPkId()) ||
						!Validator.equals(tripType,
							btTravelExpense.getTripType())) {
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

			query.append(_SQL_SELECT_BTTRAVELEXPENSE_WHERE);

			query.append(_FINDER_COLUMN_B_T_BUSINESSTRIPPKID_2);

			boolean bindTripType = false;

			if (tripType == null) {
				query.append(_FINDER_COLUMN_B_T_TRIPTYPE_1);
			}
			else if (tripType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_B_T_TRIPTYPE_3);
			}
			else {
				bindTripType = true;

				query.append(_FINDER_COLUMN_B_T_TRIPTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BtTravelExpenseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(businessTripPkId);

				if (bindTripType) {
					qPos.add(tripType);
				}

				if (!pagination) {
					list = (List<BtTravelExpense>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtTravelExpense>(list);
				}
				else {
					list = (List<BtTravelExpense>)QueryUtil.list(q,
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
	 * Returns the first bt travel expense in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt travel expense
	 * @throws com.business.trip.NoSuchBtTravelExpenseException if a matching bt travel expense could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense findByB_T_First(long businessTripPkId,
		String tripType, OrderByComparator orderByComparator)
		throws NoSuchBtTravelExpenseException, SystemException {
		BtTravelExpense btTravelExpense = fetchByB_T_First(businessTripPkId,
				tripType, orderByComparator);

		if (btTravelExpense != null) {
			return btTravelExpense;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("businessTripPkId=");
		msg.append(businessTripPkId);

		msg.append(", tripType=");
		msg.append(tripType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtTravelExpenseException(msg.toString());
	}

	/**
	 * Returns the first bt travel expense in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt travel expense, or <code>null</code> if a matching bt travel expense could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense fetchByB_T_First(long businessTripPkId,
		String tripType, OrderByComparator orderByComparator)
		throws SystemException {
		List<BtTravelExpense> list = findByB_T(businessTripPkId, tripType, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bt travel expense in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt travel expense
	 * @throws com.business.trip.NoSuchBtTravelExpenseException if a matching bt travel expense could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense findByB_T_Last(long businessTripPkId,
		String tripType, OrderByComparator orderByComparator)
		throws NoSuchBtTravelExpenseException, SystemException {
		BtTravelExpense btTravelExpense = fetchByB_T_Last(businessTripPkId,
				tripType, orderByComparator);

		if (btTravelExpense != null) {
			return btTravelExpense;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("businessTripPkId=");
		msg.append(businessTripPkId);

		msg.append(", tripType=");
		msg.append(tripType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtTravelExpenseException(msg.toString());
	}

	/**
	 * Returns the last bt travel expense in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt travel expense, or <code>null</code> if a matching bt travel expense could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense fetchByB_T_Last(long businessTripPkId,
		String tripType, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByB_T(businessTripPkId, tripType);

		if (count == 0) {
			return null;
		}

		List<BtTravelExpense> list = findByB_T(businessTripPkId, tripType,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bt travel expenses before and after the current bt travel expense in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param btTravelExpenseId the primary key of the current bt travel expense
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bt travel expense
	 * @throws com.business.trip.NoSuchBtTravelExpenseException if a bt travel expense with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense[] findByB_T_PrevAndNext(long btTravelExpenseId,
		long businessTripPkId, String tripType,
		OrderByComparator orderByComparator)
		throws NoSuchBtTravelExpenseException, SystemException {
		BtTravelExpense btTravelExpense = findByPrimaryKey(btTravelExpenseId);

		Session session = null;

		try {
			session = openSession();

			BtTravelExpense[] array = new BtTravelExpenseImpl[3];

			array[0] = getByB_T_PrevAndNext(session, btTravelExpense,
					businessTripPkId, tripType, orderByComparator, true);

			array[1] = btTravelExpense;

			array[2] = getByB_T_PrevAndNext(session, btTravelExpense,
					businessTripPkId, tripType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BtTravelExpense getByB_T_PrevAndNext(Session session,
		BtTravelExpense btTravelExpense, long businessTripPkId,
		String tripType, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BTTRAVELEXPENSE_WHERE);

		query.append(_FINDER_COLUMN_B_T_BUSINESSTRIPPKID_2);

		boolean bindTripType = false;

		if (tripType == null) {
			query.append(_FINDER_COLUMN_B_T_TRIPTYPE_1);
		}
		else if (tripType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_B_T_TRIPTYPE_3);
		}
		else {
			bindTripType = true;

			query.append(_FINDER_COLUMN_B_T_TRIPTYPE_2);
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
			query.append(BtTravelExpenseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(businessTripPkId);

		if (bindTripType) {
			qPos.add(tripType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(btTravelExpense);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BtTravelExpense> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bt travel expenses where businessTripPkId = &#63; and tripType = &#63; from the database.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByB_T(long businessTripPkId, String tripType)
		throws SystemException {
		for (BtTravelExpense btTravelExpense : findByB_T(businessTripPkId,
				tripType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(btTravelExpense);
		}
	}

	/**
	 * Returns the number of bt travel expenses where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @return the number of matching bt travel expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByB_T(long businessTripPkId, String tripType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_B_T;

		Object[] finderArgs = new Object[] { businessTripPkId, tripType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BTTRAVELEXPENSE_WHERE);

			query.append(_FINDER_COLUMN_B_T_BUSINESSTRIPPKID_2);

			boolean bindTripType = false;

			if (tripType == null) {
				query.append(_FINDER_COLUMN_B_T_TRIPTYPE_1);
			}
			else if (tripType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_B_T_TRIPTYPE_3);
			}
			else {
				bindTripType = true;

				query.append(_FINDER_COLUMN_B_T_TRIPTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(businessTripPkId);

				if (bindTripType) {
					qPos.add(tripType);
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

	private static final String _FINDER_COLUMN_B_T_BUSINESSTRIPPKID_2 = "btTravelExpense.businessTripPkId = ? AND ";
	private static final String _FINDER_COLUMN_B_T_TRIPTYPE_1 = "btTravelExpense.tripType IS NULL";
	private static final String _FINDER_COLUMN_B_T_TRIPTYPE_2 = "btTravelExpense.tripType = ?";
	private static final String _FINDER_COLUMN_B_T_TRIPTYPE_3 = "(btTravelExpense.tripType IS NULL OR btTravelExpense.tripType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_B_C = new FinderPath(BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
			BtTravelExpenseModelImpl.FINDER_CACHE_ENABLED,
			BtTravelExpenseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByB_C",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_C = new FinderPath(BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
			BtTravelExpenseModelImpl.FINDER_CACHE_ENABLED,
			BtTravelExpenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByB_C",
			new String[] { Long.class.getName(), String.class.getName() },
			BtTravelExpenseModelImpl.BUSINESSTRIPPKID_COLUMN_BITMASK |
			BtTravelExpenseModelImpl.CURRENCY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_B_C = new FinderPath(BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
			BtTravelExpenseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_C",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the bt travel expenses where businessTripPkId = &#63; and currency = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param currency the currency
	 * @return the matching bt travel expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTravelExpense> findByB_C(long businessTripPkId,
		String currency) throws SystemException {
		return findByB_C(businessTripPkId, currency, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bt travel expenses where businessTripPkId = &#63; and currency = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param currency the currency
	 * @param start the lower bound of the range of bt travel expenses
	 * @param end the upper bound of the range of bt travel expenses (not inclusive)
	 * @return the range of matching bt travel expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTravelExpense> findByB_C(long businessTripPkId,
		String currency, int start, int end) throws SystemException {
		return findByB_C(businessTripPkId, currency, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt travel expenses where businessTripPkId = &#63; and currency = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param currency the currency
	 * @param start the lower bound of the range of bt travel expenses
	 * @param end the upper bound of the range of bt travel expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bt travel expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTravelExpense> findByB_C(long businessTripPkId,
		String currency, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_C;
			finderArgs = new Object[] { businessTripPkId, currency };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_B_C;
			finderArgs = new Object[] {
					businessTripPkId, currency,
					
					start, end, orderByComparator
				};
		}

		List<BtTravelExpense> list = (List<BtTravelExpense>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BtTravelExpense btTravelExpense : list) {
				if ((businessTripPkId != btTravelExpense.getBusinessTripPkId()) ||
						!Validator.equals(currency,
							btTravelExpense.getCurrency())) {
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

			query.append(_SQL_SELECT_BTTRAVELEXPENSE_WHERE);

			query.append(_FINDER_COLUMN_B_C_BUSINESSTRIPPKID_2);

			boolean bindCurrency = false;

			if (currency == null) {
				query.append(_FINDER_COLUMN_B_C_CURRENCY_1);
			}
			else if (currency.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_B_C_CURRENCY_3);
			}
			else {
				bindCurrency = true;

				query.append(_FINDER_COLUMN_B_C_CURRENCY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BtTravelExpenseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(businessTripPkId);

				if (bindCurrency) {
					qPos.add(currency);
				}

				if (!pagination) {
					list = (List<BtTravelExpense>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtTravelExpense>(list);
				}
				else {
					list = (List<BtTravelExpense>)QueryUtil.list(q,
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
	 * Returns the first bt travel expense in the ordered set where businessTripPkId = &#63; and currency = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param currency the currency
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt travel expense
	 * @throws com.business.trip.NoSuchBtTravelExpenseException if a matching bt travel expense could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense findByB_C_First(long businessTripPkId,
		String currency, OrderByComparator orderByComparator)
		throws NoSuchBtTravelExpenseException, SystemException {
		BtTravelExpense btTravelExpense = fetchByB_C_First(businessTripPkId,
				currency, orderByComparator);

		if (btTravelExpense != null) {
			return btTravelExpense;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("businessTripPkId=");
		msg.append(businessTripPkId);

		msg.append(", currency=");
		msg.append(currency);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtTravelExpenseException(msg.toString());
	}

	/**
	 * Returns the first bt travel expense in the ordered set where businessTripPkId = &#63; and currency = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param currency the currency
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt travel expense, or <code>null</code> if a matching bt travel expense could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense fetchByB_C_First(long businessTripPkId,
		String currency, OrderByComparator orderByComparator)
		throws SystemException {
		List<BtTravelExpense> list = findByB_C(businessTripPkId, currency, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bt travel expense in the ordered set where businessTripPkId = &#63; and currency = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param currency the currency
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt travel expense
	 * @throws com.business.trip.NoSuchBtTravelExpenseException if a matching bt travel expense could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense findByB_C_Last(long businessTripPkId,
		String currency, OrderByComparator orderByComparator)
		throws NoSuchBtTravelExpenseException, SystemException {
		BtTravelExpense btTravelExpense = fetchByB_C_Last(businessTripPkId,
				currency, orderByComparator);

		if (btTravelExpense != null) {
			return btTravelExpense;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("businessTripPkId=");
		msg.append(businessTripPkId);

		msg.append(", currency=");
		msg.append(currency);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtTravelExpenseException(msg.toString());
	}

	/**
	 * Returns the last bt travel expense in the ordered set where businessTripPkId = &#63; and currency = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param currency the currency
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt travel expense, or <code>null</code> if a matching bt travel expense could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense fetchByB_C_Last(long businessTripPkId,
		String currency, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByB_C(businessTripPkId, currency);

		if (count == 0) {
			return null;
		}

		List<BtTravelExpense> list = findByB_C(businessTripPkId, currency,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bt travel expenses before and after the current bt travel expense in the ordered set where businessTripPkId = &#63; and currency = &#63;.
	 *
	 * @param btTravelExpenseId the primary key of the current bt travel expense
	 * @param businessTripPkId the business trip pk ID
	 * @param currency the currency
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bt travel expense
	 * @throws com.business.trip.NoSuchBtTravelExpenseException if a bt travel expense with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense[] findByB_C_PrevAndNext(long btTravelExpenseId,
		long businessTripPkId, String currency,
		OrderByComparator orderByComparator)
		throws NoSuchBtTravelExpenseException, SystemException {
		BtTravelExpense btTravelExpense = findByPrimaryKey(btTravelExpenseId);

		Session session = null;

		try {
			session = openSession();

			BtTravelExpense[] array = new BtTravelExpenseImpl[3];

			array[0] = getByB_C_PrevAndNext(session, btTravelExpense,
					businessTripPkId, currency, orderByComparator, true);

			array[1] = btTravelExpense;

			array[2] = getByB_C_PrevAndNext(session, btTravelExpense,
					businessTripPkId, currency, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BtTravelExpense getByB_C_PrevAndNext(Session session,
		BtTravelExpense btTravelExpense, long businessTripPkId,
		String currency, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BTTRAVELEXPENSE_WHERE);

		query.append(_FINDER_COLUMN_B_C_BUSINESSTRIPPKID_2);

		boolean bindCurrency = false;

		if (currency == null) {
			query.append(_FINDER_COLUMN_B_C_CURRENCY_1);
		}
		else if (currency.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_B_C_CURRENCY_3);
		}
		else {
			bindCurrency = true;

			query.append(_FINDER_COLUMN_B_C_CURRENCY_2);
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
			query.append(BtTravelExpenseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(businessTripPkId);

		if (bindCurrency) {
			qPos.add(currency);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(btTravelExpense);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BtTravelExpense> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bt travel expenses where businessTripPkId = &#63; and currency = &#63; from the database.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param currency the currency
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByB_C(long businessTripPkId, String currency)
		throws SystemException {
		for (BtTravelExpense btTravelExpense : findByB_C(businessTripPkId,
				currency, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(btTravelExpense);
		}
	}

	/**
	 * Returns the number of bt travel expenses where businessTripPkId = &#63; and currency = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param currency the currency
	 * @return the number of matching bt travel expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByB_C(long businessTripPkId, String currency)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_B_C;

		Object[] finderArgs = new Object[] { businessTripPkId, currency };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BTTRAVELEXPENSE_WHERE);

			query.append(_FINDER_COLUMN_B_C_BUSINESSTRIPPKID_2);

			boolean bindCurrency = false;

			if (currency == null) {
				query.append(_FINDER_COLUMN_B_C_CURRENCY_1);
			}
			else if (currency.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_B_C_CURRENCY_3);
			}
			else {
				bindCurrency = true;

				query.append(_FINDER_COLUMN_B_C_CURRENCY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(businessTripPkId);

				if (bindCurrency) {
					qPos.add(currency);
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

	private static final String _FINDER_COLUMN_B_C_BUSINESSTRIPPKID_2 = "btTravelExpense.businessTripPkId = ? AND ";
	private static final String _FINDER_COLUMN_B_C_CURRENCY_1 = "btTravelExpense.currency IS NULL";
	private static final String _FINDER_COLUMN_B_C_CURRENCY_2 = "btTravelExpense.currency = ?";
	private static final String _FINDER_COLUMN_B_C_CURRENCY_3 = "(btTravelExpense.currency IS NULL OR btTravelExpense.currency = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TICKETNO = new FinderPath(BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
			BtTravelExpenseModelImpl.FINDER_CACHE_ENABLED,
			BtTravelExpenseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTicketNo",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TICKETNO =
		new FinderPath(BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
			BtTravelExpenseModelImpl.FINDER_CACHE_ENABLED,
			BtTravelExpenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTicketNo",
			new String[] { String.class.getName() },
			BtTravelExpenseModelImpl.TICKETNO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TICKETNO = new FinderPath(BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
			BtTravelExpenseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTicketNo",
			new String[] { String.class.getName() });

	/**
	 * Returns all the bt travel expenses where ticketNo = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @return the matching bt travel expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTravelExpense> findByTicketNo(String ticketNo)
		throws SystemException {
		return findByTicketNo(ticketNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the bt travel expenses where ticketNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketNo the ticket no
	 * @param start the lower bound of the range of bt travel expenses
	 * @param end the upper bound of the range of bt travel expenses (not inclusive)
	 * @return the range of matching bt travel expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTravelExpense> findByTicketNo(String ticketNo, int start,
		int end) throws SystemException {
		return findByTicketNo(ticketNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt travel expenses where ticketNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketNo the ticket no
	 * @param start the lower bound of the range of bt travel expenses
	 * @param end the upper bound of the range of bt travel expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bt travel expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTravelExpense> findByTicketNo(String ticketNo, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TICKETNO;
			finderArgs = new Object[] { ticketNo };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TICKETNO;
			finderArgs = new Object[] { ticketNo, start, end, orderByComparator };
		}

		List<BtTravelExpense> list = (List<BtTravelExpense>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BtTravelExpense btTravelExpense : list) {
				if (!Validator.equals(ticketNo, btTravelExpense.getTicketNo())) {
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

			query.append(_SQL_SELECT_BTTRAVELEXPENSE_WHERE);

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

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BtTravelExpenseModelImpl.ORDER_BY_JPQL);
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

				if (!pagination) {
					list = (List<BtTravelExpense>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtTravelExpense>(list);
				}
				else {
					list = (List<BtTravelExpense>)QueryUtil.list(q,
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
	 * Returns the first bt travel expense in the ordered set where ticketNo = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt travel expense
	 * @throws com.business.trip.NoSuchBtTravelExpenseException if a matching bt travel expense could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense findByTicketNo_First(String ticketNo,
		OrderByComparator orderByComparator)
		throws NoSuchBtTravelExpenseException, SystemException {
		BtTravelExpense btTravelExpense = fetchByTicketNo_First(ticketNo,
				orderByComparator);

		if (btTravelExpense != null) {
			return btTravelExpense;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketNo=");
		msg.append(ticketNo);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtTravelExpenseException(msg.toString());
	}

	/**
	 * Returns the first bt travel expense in the ordered set where ticketNo = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt travel expense, or <code>null</code> if a matching bt travel expense could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense fetchByTicketNo_First(String ticketNo,
		OrderByComparator orderByComparator) throws SystemException {
		List<BtTravelExpense> list = findByTicketNo(ticketNo, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bt travel expense in the ordered set where ticketNo = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt travel expense
	 * @throws com.business.trip.NoSuchBtTravelExpenseException if a matching bt travel expense could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense findByTicketNo_Last(String ticketNo,
		OrderByComparator orderByComparator)
		throws NoSuchBtTravelExpenseException, SystemException {
		BtTravelExpense btTravelExpense = fetchByTicketNo_Last(ticketNo,
				orderByComparator);

		if (btTravelExpense != null) {
			return btTravelExpense;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketNo=");
		msg.append(ticketNo);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtTravelExpenseException(msg.toString());
	}

	/**
	 * Returns the last bt travel expense in the ordered set where ticketNo = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt travel expense, or <code>null</code> if a matching bt travel expense could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense fetchByTicketNo_Last(String ticketNo,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTicketNo(ticketNo);

		if (count == 0) {
			return null;
		}

		List<BtTravelExpense> list = findByTicketNo(ticketNo, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bt travel expenses before and after the current bt travel expense in the ordered set where ticketNo = &#63;.
	 *
	 * @param btTravelExpenseId the primary key of the current bt travel expense
	 * @param ticketNo the ticket no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bt travel expense
	 * @throws com.business.trip.NoSuchBtTravelExpenseException if a bt travel expense with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense[] findByTicketNo_PrevAndNext(
		long btTravelExpenseId, String ticketNo,
		OrderByComparator orderByComparator)
		throws NoSuchBtTravelExpenseException, SystemException {
		BtTravelExpense btTravelExpense = findByPrimaryKey(btTravelExpenseId);

		Session session = null;

		try {
			session = openSession();

			BtTravelExpense[] array = new BtTravelExpenseImpl[3];

			array[0] = getByTicketNo_PrevAndNext(session, btTravelExpense,
					ticketNo, orderByComparator, true);

			array[1] = btTravelExpense;

			array[2] = getByTicketNo_PrevAndNext(session, btTravelExpense,
					ticketNo, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BtTravelExpense getByTicketNo_PrevAndNext(Session session,
		BtTravelExpense btTravelExpense, String ticketNo,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BTTRAVELEXPENSE_WHERE);

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
			query.append(BtTravelExpenseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindTicketNo) {
			qPos.add(ticketNo);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(btTravelExpense);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BtTravelExpense> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bt travel expenses where ticketNo = &#63; from the database.
	 *
	 * @param ticketNo the ticket no
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTicketNo(String ticketNo) throws SystemException {
		for (BtTravelExpense btTravelExpense : findByTicketNo(ticketNo,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(btTravelExpense);
		}
	}

	/**
	 * Returns the number of bt travel expenses where ticketNo = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @return the number of matching bt travel expenses
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

			query.append(_SQL_COUNT_BTTRAVELEXPENSE_WHERE);

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

	private static final String _FINDER_COLUMN_TICKETNO_TICKETNO_1 = "btTravelExpense.ticketNo IS NULL";
	private static final String _FINDER_COLUMN_TICKETNO_TICKETNO_2 = "btTravelExpense.ticketNo = ?";
	private static final String _FINDER_COLUMN_TICKETNO_TICKETNO_3 = "(btTravelExpense.ticketNo IS NULL OR btTravelExpense.ticketNo = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BUSINESSTRIPPKID =
		new FinderPath(BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
			BtTravelExpenseModelImpl.FINDER_CACHE_ENABLED,
			BtTravelExpenseImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByBusinessTripPkId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSINESSTRIPPKID =
		new FinderPath(BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
			BtTravelExpenseModelImpl.FINDER_CACHE_ENABLED,
			BtTravelExpenseImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByBusinessTripPkId", new String[] { Long.class.getName() },
			BtTravelExpenseModelImpl.BUSINESSTRIPPKID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BUSINESSTRIPPKID = new FinderPath(BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
			BtTravelExpenseModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBusinessTripPkId", new String[] { Long.class.getName() });

	/**
	 * Returns all the bt travel expenses where businessTripPkId = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @return the matching bt travel expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTravelExpense> findByBusinessTripPkId(long businessTripPkId)
		throws SystemException {
		return findByBusinessTripPkId(businessTripPkId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bt travel expenses where businessTripPkId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param start the lower bound of the range of bt travel expenses
	 * @param end the upper bound of the range of bt travel expenses (not inclusive)
	 * @return the range of matching bt travel expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTravelExpense> findByBusinessTripPkId(long businessTripPkId,
		int start, int end) throws SystemException {
		return findByBusinessTripPkId(businessTripPkId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt travel expenses where businessTripPkId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param start the lower bound of the range of bt travel expenses
	 * @param end the upper bound of the range of bt travel expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bt travel expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTravelExpense> findByBusinessTripPkId(long businessTripPkId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSINESSTRIPPKID;
			finderArgs = new Object[] { businessTripPkId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BUSINESSTRIPPKID;
			finderArgs = new Object[] {
					businessTripPkId,
					
					start, end, orderByComparator
				};
		}

		List<BtTravelExpense> list = (List<BtTravelExpense>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BtTravelExpense btTravelExpense : list) {
				if ((businessTripPkId != btTravelExpense.getBusinessTripPkId())) {
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

			query.append(_SQL_SELECT_BTTRAVELEXPENSE_WHERE);

			query.append(_FINDER_COLUMN_BUSINESSTRIPPKID_BUSINESSTRIPPKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BtTravelExpenseModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(businessTripPkId);

				if (!pagination) {
					list = (List<BtTravelExpense>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtTravelExpense>(list);
				}
				else {
					list = (List<BtTravelExpense>)QueryUtil.list(q,
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
	 * Returns the first bt travel expense in the ordered set where businessTripPkId = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt travel expense
	 * @throws com.business.trip.NoSuchBtTravelExpenseException if a matching bt travel expense could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense findByBusinessTripPkId_First(long businessTripPkId,
		OrderByComparator orderByComparator)
		throws NoSuchBtTravelExpenseException, SystemException {
		BtTravelExpense btTravelExpense = fetchByBusinessTripPkId_First(businessTripPkId,
				orderByComparator);

		if (btTravelExpense != null) {
			return btTravelExpense;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("businessTripPkId=");
		msg.append(businessTripPkId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtTravelExpenseException(msg.toString());
	}

	/**
	 * Returns the first bt travel expense in the ordered set where businessTripPkId = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt travel expense, or <code>null</code> if a matching bt travel expense could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense fetchByBusinessTripPkId_First(
		long businessTripPkId, OrderByComparator orderByComparator)
		throws SystemException {
		List<BtTravelExpense> list = findByBusinessTripPkId(businessTripPkId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bt travel expense in the ordered set where businessTripPkId = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt travel expense
	 * @throws com.business.trip.NoSuchBtTravelExpenseException if a matching bt travel expense could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense findByBusinessTripPkId_Last(long businessTripPkId,
		OrderByComparator orderByComparator)
		throws NoSuchBtTravelExpenseException, SystemException {
		BtTravelExpense btTravelExpense = fetchByBusinessTripPkId_Last(businessTripPkId,
				orderByComparator);

		if (btTravelExpense != null) {
			return btTravelExpense;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("businessTripPkId=");
		msg.append(businessTripPkId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtTravelExpenseException(msg.toString());
	}

	/**
	 * Returns the last bt travel expense in the ordered set where businessTripPkId = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt travel expense, or <code>null</code> if a matching bt travel expense could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense fetchByBusinessTripPkId_Last(long businessTripPkId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBusinessTripPkId(businessTripPkId);

		if (count == 0) {
			return null;
		}

		List<BtTravelExpense> list = findByBusinessTripPkId(businessTripPkId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bt travel expenses before and after the current bt travel expense in the ordered set where businessTripPkId = &#63;.
	 *
	 * @param btTravelExpenseId the primary key of the current bt travel expense
	 * @param businessTripPkId the business trip pk ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bt travel expense
	 * @throws com.business.trip.NoSuchBtTravelExpenseException if a bt travel expense with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense[] findByBusinessTripPkId_PrevAndNext(
		long btTravelExpenseId, long businessTripPkId,
		OrderByComparator orderByComparator)
		throws NoSuchBtTravelExpenseException, SystemException {
		BtTravelExpense btTravelExpense = findByPrimaryKey(btTravelExpenseId);

		Session session = null;

		try {
			session = openSession();

			BtTravelExpense[] array = new BtTravelExpenseImpl[3];

			array[0] = getByBusinessTripPkId_PrevAndNext(session,
					btTravelExpense, businessTripPkId, orderByComparator, true);

			array[1] = btTravelExpense;

			array[2] = getByBusinessTripPkId_PrevAndNext(session,
					btTravelExpense, businessTripPkId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BtTravelExpense getByBusinessTripPkId_PrevAndNext(
		Session session, BtTravelExpense btTravelExpense,
		long businessTripPkId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BTTRAVELEXPENSE_WHERE);

		query.append(_FINDER_COLUMN_BUSINESSTRIPPKID_BUSINESSTRIPPKID_2);

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
			query.append(BtTravelExpenseModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(businessTripPkId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(btTravelExpense);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BtTravelExpense> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bt travel expenses where businessTripPkId = &#63; from the database.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBusinessTripPkId(long businessTripPkId)
		throws SystemException {
		for (BtTravelExpense btTravelExpense : findByBusinessTripPkId(
				businessTripPkId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(btTravelExpense);
		}
	}

	/**
	 * Returns the number of bt travel expenses where businessTripPkId = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @return the number of matching bt travel expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBusinessTripPkId(long businessTripPkId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BUSINESSTRIPPKID;

		Object[] finderArgs = new Object[] { businessTripPkId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BTTRAVELEXPENSE_WHERE);

			query.append(_FINDER_COLUMN_BUSINESSTRIPPKID_BUSINESSTRIPPKID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(businessTripPkId);

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

	private static final String _FINDER_COLUMN_BUSINESSTRIPPKID_BUSINESSTRIPPKID_2 =
		"btTravelExpense.businessTripPkId = ?";

	public BtTravelExpensePersistenceImpl() {
		setModelClass(BtTravelExpense.class);
	}

	/**
	 * Caches the bt travel expense in the entity cache if it is enabled.
	 *
	 * @param btTravelExpense the bt travel expense
	 */
	@Override
	public void cacheResult(BtTravelExpense btTravelExpense) {
		EntityCacheUtil.putResult(BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
			BtTravelExpenseImpl.class, btTravelExpense.getPrimaryKey(),
			btTravelExpense);

		btTravelExpense.resetOriginalValues();
	}

	/**
	 * Caches the bt travel expenses in the entity cache if it is enabled.
	 *
	 * @param btTravelExpenses the bt travel expenses
	 */
	@Override
	public void cacheResult(List<BtTravelExpense> btTravelExpenses) {
		for (BtTravelExpense btTravelExpense : btTravelExpenses) {
			if (EntityCacheUtil.getResult(
						BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
						BtTravelExpenseImpl.class,
						btTravelExpense.getPrimaryKey()) == null) {
				cacheResult(btTravelExpense);
			}
			else {
				btTravelExpense.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bt travel expenses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BtTravelExpenseImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BtTravelExpenseImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bt travel expense.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BtTravelExpense btTravelExpense) {
		EntityCacheUtil.removeResult(BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
			BtTravelExpenseImpl.class, btTravelExpense.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BtTravelExpense> btTravelExpenses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BtTravelExpense btTravelExpense : btTravelExpenses) {
			EntityCacheUtil.removeResult(BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
				BtTravelExpenseImpl.class, btTravelExpense.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bt travel expense with the primary key. Does not add the bt travel expense to the database.
	 *
	 * @param btTravelExpenseId the primary key for the new bt travel expense
	 * @return the new bt travel expense
	 */
	@Override
	public BtTravelExpense create(long btTravelExpenseId) {
		BtTravelExpense btTravelExpense = new BtTravelExpenseImpl();

		btTravelExpense.setNew(true);
		btTravelExpense.setPrimaryKey(btTravelExpenseId);

		return btTravelExpense;
	}

	/**
	 * Removes the bt travel expense with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param btTravelExpenseId the primary key of the bt travel expense
	 * @return the bt travel expense that was removed
	 * @throws com.business.trip.NoSuchBtTravelExpenseException if a bt travel expense with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense remove(long btTravelExpenseId)
		throws NoSuchBtTravelExpenseException, SystemException {
		return remove((Serializable)btTravelExpenseId);
	}

	/**
	 * Removes the bt travel expense with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bt travel expense
	 * @return the bt travel expense that was removed
	 * @throws com.business.trip.NoSuchBtTravelExpenseException if a bt travel expense with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense remove(Serializable primaryKey)
		throws NoSuchBtTravelExpenseException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BtTravelExpense btTravelExpense = (BtTravelExpense)session.get(BtTravelExpenseImpl.class,
					primaryKey);

			if (btTravelExpense == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBtTravelExpenseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(btTravelExpense);
		}
		catch (NoSuchBtTravelExpenseException nsee) {
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
	protected BtTravelExpense removeImpl(BtTravelExpense btTravelExpense)
		throws SystemException {
		btTravelExpense = toUnwrappedModel(btTravelExpense);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(btTravelExpense)) {
				btTravelExpense = (BtTravelExpense)session.get(BtTravelExpenseImpl.class,
						btTravelExpense.getPrimaryKeyObj());
			}

			if (btTravelExpense != null) {
				session.delete(btTravelExpense);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (btTravelExpense != null) {
			clearCache(btTravelExpense);
		}

		return btTravelExpense;
	}

	@Override
	public BtTravelExpense updateImpl(
		com.business.trip.model.BtTravelExpense btTravelExpense)
		throws SystemException {
		btTravelExpense = toUnwrappedModel(btTravelExpense);

		boolean isNew = btTravelExpense.isNew();

		BtTravelExpenseModelImpl btTravelExpenseModelImpl = (BtTravelExpenseModelImpl)btTravelExpense;

		Session session = null;

		try {
			session = openSession();

			if (btTravelExpense.isNew()) {
				session.save(btTravelExpense);

				btTravelExpense.setNew(false);
			}
			else {
				session.merge(btTravelExpense);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BtTravelExpenseModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((btTravelExpenseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						btTravelExpenseModelImpl.getOriginalTicketNo(),
						btTravelExpenseModelImpl.getOriginalTripType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T,
					args);

				args = new Object[] {
						btTravelExpenseModelImpl.getTicketNo(),
						btTravelExpenseModelImpl.getTripType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T,
					args);
			}

			if ((btTravelExpenseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						btTravelExpenseModelImpl.getOriginalBusinessTripPkId(),
						btTravelExpenseModelImpl.getOriginalTripType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_B_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_T,
					args);

				args = new Object[] {
						btTravelExpenseModelImpl.getBusinessTripPkId(),
						btTravelExpenseModelImpl.getTripType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_B_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_T,
					args);
			}

			if ((btTravelExpenseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						btTravelExpenseModelImpl.getOriginalBusinessTripPkId(),
						btTravelExpenseModelImpl.getOriginalCurrency()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_B_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_C,
					args);

				args = new Object[] {
						btTravelExpenseModelImpl.getBusinessTripPkId(),
						btTravelExpenseModelImpl.getCurrency()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_B_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_C,
					args);
			}

			if ((btTravelExpenseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TICKETNO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						btTravelExpenseModelImpl.getOriginalTicketNo()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TICKETNO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TICKETNO,
					args);

				args = new Object[] { btTravelExpenseModelImpl.getTicketNo() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TICKETNO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TICKETNO,
					args);
			}

			if ((btTravelExpenseModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSINESSTRIPPKID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						btTravelExpenseModelImpl.getOriginalBusinessTripPkId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BUSINESSTRIPPKID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSINESSTRIPPKID,
					args);

				args = new Object[] {
						btTravelExpenseModelImpl.getBusinessTripPkId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BUSINESSTRIPPKID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSINESSTRIPPKID,
					args);
			}
		}

		EntityCacheUtil.putResult(BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
			BtTravelExpenseImpl.class, btTravelExpense.getPrimaryKey(),
			btTravelExpense);

		return btTravelExpense;
	}

	protected BtTravelExpense toUnwrappedModel(BtTravelExpense btTravelExpense) {
		if (btTravelExpense instanceof BtTravelExpenseImpl) {
			return btTravelExpense;
		}

		BtTravelExpenseImpl btTravelExpenseImpl = new BtTravelExpenseImpl();

		btTravelExpenseImpl.setNew(btTravelExpense.isNew());
		btTravelExpenseImpl.setPrimaryKey(btTravelExpense.getPrimaryKey());

		btTravelExpenseImpl.setBtTravelExpenseId(btTravelExpense.getBtTravelExpenseId());
		btTravelExpenseImpl.setBusinessTripPkId(btTravelExpense.getBusinessTripPkId());
		btTravelExpenseImpl.setTicketNo(btTravelExpense.getTicketNo());
		btTravelExpenseImpl.setTravelDate(btTravelExpense.getTravelDate());
		btTravelExpenseImpl.setDeparture(btTravelExpense.getDeparture());
		btTravelExpenseImpl.setArrival(btTravelExpense.getArrival());
		btTravelExpenseImpl.setFromCity(btTravelExpense.getFromCity());
		btTravelExpenseImpl.setToCity(btTravelExpense.getToCity());
		btTravelExpenseImpl.setIsHasBreakfast(btTravelExpense.isIsHasBreakfast());
		btTravelExpenseImpl.setIsHasLunch(btTravelExpense.isIsHasLunch());
		btTravelExpenseImpl.setIsHasDinner(btTravelExpense.isIsHasDinner());
		btTravelExpenseImpl.setCountry(btTravelExpense.getCountry());
		btTravelExpenseImpl.setCity(btTravelExpense.getCity());
		btTravelExpenseImpl.setRateOfDma(btTravelExpense.getRateOfDma());
		btTravelExpenseImpl.setCurrency(btTravelExpense.getCurrency());
		btTravelExpenseImpl.setAllowance(btTravelExpense.getAllowance());
		btTravelExpenseImpl.setComments(btTravelExpense.getComments());
		btTravelExpenseImpl.setTripType(btTravelExpense.getTripType());
		btTravelExpenseImpl.setAllowanceRmb(btTravelExpense.getAllowanceRmb());

		return btTravelExpenseImpl;
	}

	/**
	 * Returns the bt travel expense with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bt travel expense
	 * @return the bt travel expense
	 * @throws com.business.trip.NoSuchBtTravelExpenseException if a bt travel expense with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBtTravelExpenseException, SystemException {
		BtTravelExpense btTravelExpense = fetchByPrimaryKey(primaryKey);

		if (btTravelExpense == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBtTravelExpenseException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return btTravelExpense;
	}

	/**
	 * Returns the bt travel expense with the primary key or throws a {@link com.business.trip.NoSuchBtTravelExpenseException} if it could not be found.
	 *
	 * @param btTravelExpenseId the primary key of the bt travel expense
	 * @return the bt travel expense
	 * @throws com.business.trip.NoSuchBtTravelExpenseException if a bt travel expense with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense findByPrimaryKey(long btTravelExpenseId)
		throws NoSuchBtTravelExpenseException, SystemException {
		return findByPrimaryKey((Serializable)btTravelExpenseId);
	}

	/**
	 * Returns the bt travel expense with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bt travel expense
	 * @return the bt travel expense, or <code>null</code> if a bt travel expense with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BtTravelExpense btTravelExpense = (BtTravelExpense)EntityCacheUtil.getResult(BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
				BtTravelExpenseImpl.class, primaryKey);

		if (btTravelExpense == _nullBtTravelExpense) {
			return null;
		}

		if (btTravelExpense == null) {
			Session session = null;

			try {
				session = openSession();

				btTravelExpense = (BtTravelExpense)session.get(BtTravelExpenseImpl.class,
						primaryKey);

				if (btTravelExpense != null) {
					cacheResult(btTravelExpense);
				}
				else {
					EntityCacheUtil.putResult(BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
						BtTravelExpenseImpl.class, primaryKey,
						_nullBtTravelExpense);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BtTravelExpenseModelImpl.ENTITY_CACHE_ENABLED,
					BtTravelExpenseImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return btTravelExpense;
	}

	/**
	 * Returns the bt travel expense with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param btTravelExpenseId the primary key of the bt travel expense
	 * @return the bt travel expense, or <code>null</code> if a bt travel expense with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTravelExpense fetchByPrimaryKey(long btTravelExpenseId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)btTravelExpenseId);
	}

	/**
	 * Returns all the bt travel expenses.
	 *
	 * @return the bt travel expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTravelExpense> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bt travel expenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bt travel expenses
	 * @param end the upper bound of the range of bt travel expenses (not inclusive)
	 * @return the range of bt travel expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTravelExpense> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt travel expenses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTravelExpenseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bt travel expenses
	 * @param end the upper bound of the range of bt travel expenses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bt travel expenses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTravelExpense> findAll(int start, int end,
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

		List<BtTravelExpense> list = (List<BtTravelExpense>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BTTRAVELEXPENSE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BTTRAVELEXPENSE;

				if (pagination) {
					sql = sql.concat(BtTravelExpenseModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BtTravelExpense>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtTravelExpense>(list);
				}
				else {
					list = (List<BtTravelExpense>)QueryUtil.list(q,
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
	 * Removes all the bt travel expenses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BtTravelExpense btTravelExpense : findAll()) {
			remove(btTravelExpense);
		}
	}

	/**
	 * Returns the number of bt travel expenses.
	 *
	 * @return the number of bt travel expenses
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

				Query q = session.createQuery(_SQL_COUNT_BTTRAVELEXPENSE);

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
	 * Initializes the bt travel expense persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.business.trip.model.BtTravelExpense")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BtTravelExpense>> listenersList = new ArrayList<ModelListener<BtTravelExpense>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BtTravelExpense>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BtTravelExpenseImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BTTRAVELEXPENSE = "SELECT btTravelExpense FROM BtTravelExpense btTravelExpense";
	private static final String _SQL_SELECT_BTTRAVELEXPENSE_WHERE = "SELECT btTravelExpense FROM BtTravelExpense btTravelExpense WHERE ";
	private static final String _SQL_COUNT_BTTRAVELEXPENSE = "SELECT COUNT(btTravelExpense) FROM BtTravelExpense btTravelExpense";
	private static final String _SQL_COUNT_BTTRAVELEXPENSE_WHERE = "SELECT COUNT(btTravelExpense) FROM BtTravelExpense btTravelExpense WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "btTravelExpense.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BtTravelExpense exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BtTravelExpense exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BtTravelExpensePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"currency"
			});
	private static BtTravelExpense _nullBtTravelExpense = new BtTravelExpenseImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BtTravelExpense> toCacheModel() {
				return _nullBtTravelExpenseCacheModel;
			}
		};

	private static CacheModel<BtTravelExpense> _nullBtTravelExpenseCacheModel = new CacheModel<BtTravelExpense>() {
			@Override
			public BtTravelExpense toEntityModel() {
				return _nullBtTravelExpense;
			}
		};
}