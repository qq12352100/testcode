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

import com.business.trip.NoSuchBtCarRentalInfoException;
import com.business.trip.model.BtCarRentalInfo;
import com.business.trip.model.impl.BtCarRentalInfoImpl;
import com.business.trip.model.impl.BtCarRentalInfoModelImpl;

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
 * The persistence implementation for the bt car rental info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtCarRentalInfoPersistence
 * @see BtCarRentalInfoUtil
 * @generated
 */
public class BtCarRentalInfoPersistenceImpl extends BasePersistenceImpl<BtCarRentalInfo>
	implements BtCarRentalInfoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BtCarRentalInfoUtil} to access the bt car rental info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BtCarRentalInfoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BtCarRentalInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtCarRentalInfoModelImpl.FINDER_CACHE_ENABLED,
			BtCarRentalInfoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BtCarRentalInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtCarRentalInfoModelImpl.FINDER_CACHE_ENABLED,
			BtCarRentalInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BtCarRentalInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtCarRentalInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_T_T = new FinderPath(BtCarRentalInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtCarRentalInfoModelImpl.FINDER_CACHE_ENABLED,
			BtCarRentalInfoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByT_T",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T = new FinderPath(BtCarRentalInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtCarRentalInfoModelImpl.FINDER_CACHE_ENABLED,
			BtCarRentalInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByT_T",
			new String[] { String.class.getName(), String.class.getName() },
			BtCarRentalInfoModelImpl.TICKETNO_COLUMN_BITMASK |
			BtCarRentalInfoModelImpl.TRIPTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_T_T = new FinderPath(BtCarRentalInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtCarRentalInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByT_T",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the bt car rental infos where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @return the matching bt car rental infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtCarRentalInfo> findByT_T(String ticketNo, String tripType)
		throws SystemException {
		return findByT_T(ticketNo, tripType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bt car rental infos where ticketNo = &#63; and tripType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCarRentalInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param start the lower bound of the range of bt car rental infos
	 * @param end the upper bound of the range of bt car rental infos (not inclusive)
	 * @return the range of matching bt car rental infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtCarRentalInfo> findByT_T(String ticketNo, String tripType,
		int start, int end) throws SystemException {
		return findByT_T(ticketNo, tripType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt car rental infos where ticketNo = &#63; and tripType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCarRentalInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param start the lower bound of the range of bt car rental infos
	 * @param end the upper bound of the range of bt car rental infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bt car rental infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtCarRentalInfo> findByT_T(String ticketNo, String tripType,
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

		List<BtCarRentalInfo> list = (List<BtCarRentalInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BtCarRentalInfo btCarRentalInfo : list) {
				if (!Validator.equals(ticketNo, btCarRentalInfo.getTicketNo()) ||
						!Validator.equals(tripType,
							btCarRentalInfo.getTripType())) {
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

			query.append(_SQL_SELECT_BTCARRENTALINFO_WHERE);

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
				query.append(BtCarRentalInfoModelImpl.ORDER_BY_JPQL);
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
					list = (List<BtCarRentalInfo>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtCarRentalInfo>(list);
				}
				else {
					list = (List<BtCarRentalInfo>)QueryUtil.list(q,
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
	 * Returns the first bt car rental info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt car rental info
	 * @throws com.business.trip.NoSuchBtCarRentalInfoException if a matching bt car rental info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCarRentalInfo findByT_T_First(String ticketNo, String tripType,
		OrderByComparator orderByComparator)
		throws NoSuchBtCarRentalInfoException, SystemException {
		BtCarRentalInfo btCarRentalInfo = fetchByT_T_First(ticketNo, tripType,
				orderByComparator);

		if (btCarRentalInfo != null) {
			return btCarRentalInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketNo=");
		msg.append(ticketNo);

		msg.append(", tripType=");
		msg.append(tripType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtCarRentalInfoException(msg.toString());
	}

	/**
	 * Returns the first bt car rental info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt car rental info, or <code>null</code> if a matching bt car rental info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCarRentalInfo fetchByT_T_First(String ticketNo, String tripType,
		OrderByComparator orderByComparator) throws SystemException {
		List<BtCarRentalInfo> list = findByT_T(ticketNo, tripType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bt car rental info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt car rental info
	 * @throws com.business.trip.NoSuchBtCarRentalInfoException if a matching bt car rental info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCarRentalInfo findByT_T_Last(String ticketNo, String tripType,
		OrderByComparator orderByComparator)
		throws NoSuchBtCarRentalInfoException, SystemException {
		BtCarRentalInfo btCarRentalInfo = fetchByT_T_Last(ticketNo, tripType,
				orderByComparator);

		if (btCarRentalInfo != null) {
			return btCarRentalInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketNo=");
		msg.append(ticketNo);

		msg.append(", tripType=");
		msg.append(tripType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtCarRentalInfoException(msg.toString());
	}

	/**
	 * Returns the last bt car rental info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt car rental info, or <code>null</code> if a matching bt car rental info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCarRentalInfo fetchByT_T_Last(String ticketNo, String tripType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByT_T(ticketNo, tripType);

		if (count == 0) {
			return null;
		}

		List<BtCarRentalInfo> list = findByT_T(ticketNo, tripType, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bt car rental infos before and after the current bt car rental info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param btCarRentalInfoId the primary key of the current bt car rental info
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bt car rental info
	 * @throws com.business.trip.NoSuchBtCarRentalInfoException if a bt car rental info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCarRentalInfo[] findByT_T_PrevAndNext(long btCarRentalInfoId,
		String ticketNo, String tripType, OrderByComparator orderByComparator)
		throws NoSuchBtCarRentalInfoException, SystemException {
		BtCarRentalInfo btCarRentalInfo = findByPrimaryKey(btCarRentalInfoId);

		Session session = null;

		try {
			session = openSession();

			BtCarRentalInfo[] array = new BtCarRentalInfoImpl[3];

			array[0] = getByT_T_PrevAndNext(session, btCarRentalInfo, ticketNo,
					tripType, orderByComparator, true);

			array[1] = btCarRentalInfo;

			array[2] = getByT_T_PrevAndNext(session, btCarRentalInfo, ticketNo,
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

	protected BtCarRentalInfo getByT_T_PrevAndNext(Session session,
		BtCarRentalInfo btCarRentalInfo, String ticketNo, String tripType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BTCARRENTALINFO_WHERE);

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
			query.append(BtCarRentalInfoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(btCarRentalInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BtCarRentalInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bt car rental infos where ticketNo = &#63; and tripType = &#63; from the database.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByT_T(String ticketNo, String tripType)
		throws SystemException {
		for (BtCarRentalInfo btCarRentalInfo : findByT_T(ticketNo, tripType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(btCarRentalInfo);
		}
	}

	/**
	 * Returns the number of bt car rental infos where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @return the number of matching bt car rental infos
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

			query.append(_SQL_COUNT_BTCARRENTALINFO_WHERE);

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

	private static final String _FINDER_COLUMN_T_T_TICKETNO_1 = "btCarRentalInfo.ticketNo IS NULL AND ";
	private static final String _FINDER_COLUMN_T_T_TICKETNO_2 = "btCarRentalInfo.ticketNo = ? AND ";
	private static final String _FINDER_COLUMN_T_T_TICKETNO_3 = "(btCarRentalInfo.ticketNo IS NULL OR btCarRentalInfo.ticketNo = '') AND ";
	private static final String _FINDER_COLUMN_T_T_TRIPTYPE_1 = "btCarRentalInfo.tripType IS NULL";
	private static final String _FINDER_COLUMN_T_T_TRIPTYPE_2 = "btCarRentalInfo.tripType = ?";
	private static final String _FINDER_COLUMN_T_T_TRIPTYPE_3 = "(btCarRentalInfo.tripType IS NULL OR btCarRentalInfo.tripType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_B_T = new FinderPath(BtCarRentalInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtCarRentalInfoModelImpl.FINDER_CACHE_ENABLED,
			BtCarRentalInfoImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByB_T",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_T = new FinderPath(BtCarRentalInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtCarRentalInfoModelImpl.FINDER_CACHE_ENABLED,
			BtCarRentalInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByB_T",
			new String[] { Long.class.getName(), String.class.getName() },
			BtCarRentalInfoModelImpl.BUSINESSTRIPPKID_COLUMN_BITMASK |
			BtCarRentalInfoModelImpl.TRIPTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_B_T = new FinderPath(BtCarRentalInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtCarRentalInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_T",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the bt car rental infos where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @return the matching bt car rental infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtCarRentalInfo> findByB_T(long businessTripPkId,
		String tripType) throws SystemException {
		return findByB_T(businessTripPkId, tripType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bt car rental infos where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCarRentalInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param start the lower bound of the range of bt car rental infos
	 * @param end the upper bound of the range of bt car rental infos (not inclusive)
	 * @return the range of matching bt car rental infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtCarRentalInfo> findByB_T(long businessTripPkId,
		String tripType, int start, int end) throws SystemException {
		return findByB_T(businessTripPkId, tripType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt car rental infos where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCarRentalInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param start the lower bound of the range of bt car rental infos
	 * @param end the upper bound of the range of bt car rental infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bt car rental infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtCarRentalInfo> findByB_T(long businessTripPkId,
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

		List<BtCarRentalInfo> list = (List<BtCarRentalInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BtCarRentalInfo btCarRentalInfo : list) {
				if ((businessTripPkId != btCarRentalInfo.getBusinessTripPkId()) ||
						!Validator.equals(tripType,
							btCarRentalInfo.getTripType())) {
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

			query.append(_SQL_SELECT_BTCARRENTALINFO_WHERE);

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
				query.append(BtCarRentalInfoModelImpl.ORDER_BY_JPQL);
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
					list = (List<BtCarRentalInfo>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtCarRentalInfo>(list);
				}
				else {
					list = (List<BtCarRentalInfo>)QueryUtil.list(q,
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
	 * Returns the first bt car rental info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt car rental info
	 * @throws com.business.trip.NoSuchBtCarRentalInfoException if a matching bt car rental info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCarRentalInfo findByB_T_First(long businessTripPkId,
		String tripType, OrderByComparator orderByComparator)
		throws NoSuchBtCarRentalInfoException, SystemException {
		BtCarRentalInfo btCarRentalInfo = fetchByB_T_First(businessTripPkId,
				tripType, orderByComparator);

		if (btCarRentalInfo != null) {
			return btCarRentalInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("businessTripPkId=");
		msg.append(businessTripPkId);

		msg.append(", tripType=");
		msg.append(tripType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtCarRentalInfoException(msg.toString());
	}

	/**
	 * Returns the first bt car rental info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt car rental info, or <code>null</code> if a matching bt car rental info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCarRentalInfo fetchByB_T_First(long businessTripPkId,
		String tripType, OrderByComparator orderByComparator)
		throws SystemException {
		List<BtCarRentalInfo> list = findByB_T(businessTripPkId, tripType, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bt car rental info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt car rental info
	 * @throws com.business.trip.NoSuchBtCarRentalInfoException if a matching bt car rental info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCarRentalInfo findByB_T_Last(long businessTripPkId,
		String tripType, OrderByComparator orderByComparator)
		throws NoSuchBtCarRentalInfoException, SystemException {
		BtCarRentalInfo btCarRentalInfo = fetchByB_T_Last(businessTripPkId,
				tripType, orderByComparator);

		if (btCarRentalInfo != null) {
			return btCarRentalInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("businessTripPkId=");
		msg.append(businessTripPkId);

		msg.append(", tripType=");
		msg.append(tripType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtCarRentalInfoException(msg.toString());
	}

	/**
	 * Returns the last bt car rental info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt car rental info, or <code>null</code> if a matching bt car rental info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCarRentalInfo fetchByB_T_Last(long businessTripPkId,
		String tripType, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByB_T(businessTripPkId, tripType);

		if (count == 0) {
			return null;
		}

		List<BtCarRentalInfo> list = findByB_T(businessTripPkId, tripType,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bt car rental infos before and after the current bt car rental info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param btCarRentalInfoId the primary key of the current bt car rental info
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bt car rental info
	 * @throws com.business.trip.NoSuchBtCarRentalInfoException if a bt car rental info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCarRentalInfo[] findByB_T_PrevAndNext(long btCarRentalInfoId,
		long businessTripPkId, String tripType,
		OrderByComparator orderByComparator)
		throws NoSuchBtCarRentalInfoException, SystemException {
		BtCarRentalInfo btCarRentalInfo = findByPrimaryKey(btCarRentalInfoId);

		Session session = null;

		try {
			session = openSession();

			BtCarRentalInfo[] array = new BtCarRentalInfoImpl[3];

			array[0] = getByB_T_PrevAndNext(session, btCarRentalInfo,
					businessTripPkId, tripType, orderByComparator, true);

			array[1] = btCarRentalInfo;

			array[2] = getByB_T_PrevAndNext(session, btCarRentalInfo,
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

	protected BtCarRentalInfo getByB_T_PrevAndNext(Session session,
		BtCarRentalInfo btCarRentalInfo, long businessTripPkId,
		String tripType, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BTCARRENTALINFO_WHERE);

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
			query.append(BtCarRentalInfoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(btCarRentalInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BtCarRentalInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bt car rental infos where businessTripPkId = &#63; and tripType = &#63; from the database.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByB_T(long businessTripPkId, String tripType)
		throws SystemException {
		for (BtCarRentalInfo btCarRentalInfo : findByB_T(businessTripPkId,
				tripType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(btCarRentalInfo);
		}
	}

	/**
	 * Returns the number of bt car rental infos where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @return the number of matching bt car rental infos
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

			query.append(_SQL_COUNT_BTCARRENTALINFO_WHERE);

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

	private static final String _FINDER_COLUMN_B_T_BUSINESSTRIPPKID_2 = "btCarRentalInfo.businessTripPkId = ? AND ";
	private static final String _FINDER_COLUMN_B_T_TRIPTYPE_1 = "btCarRentalInfo.tripType IS NULL";
	private static final String _FINDER_COLUMN_B_T_TRIPTYPE_2 = "btCarRentalInfo.tripType = ?";
	private static final String _FINDER_COLUMN_B_T_TRIPTYPE_3 = "(btCarRentalInfo.tripType IS NULL OR btCarRentalInfo.tripType = '')";

	public BtCarRentalInfoPersistenceImpl() {
		setModelClass(BtCarRentalInfo.class);
	}

	/**
	 * Caches the bt car rental info in the entity cache if it is enabled.
	 *
	 * @param btCarRentalInfo the bt car rental info
	 */
	@Override
	public void cacheResult(BtCarRentalInfo btCarRentalInfo) {
		EntityCacheUtil.putResult(BtCarRentalInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtCarRentalInfoImpl.class, btCarRentalInfo.getPrimaryKey(),
			btCarRentalInfo);

		btCarRentalInfo.resetOriginalValues();
	}

	/**
	 * Caches the bt car rental infos in the entity cache if it is enabled.
	 *
	 * @param btCarRentalInfos the bt car rental infos
	 */
	@Override
	public void cacheResult(List<BtCarRentalInfo> btCarRentalInfos) {
		for (BtCarRentalInfo btCarRentalInfo : btCarRentalInfos) {
			if (EntityCacheUtil.getResult(
						BtCarRentalInfoModelImpl.ENTITY_CACHE_ENABLED,
						BtCarRentalInfoImpl.class,
						btCarRentalInfo.getPrimaryKey()) == null) {
				cacheResult(btCarRentalInfo);
			}
			else {
				btCarRentalInfo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bt car rental infos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BtCarRentalInfoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BtCarRentalInfoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bt car rental info.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BtCarRentalInfo btCarRentalInfo) {
		EntityCacheUtil.removeResult(BtCarRentalInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtCarRentalInfoImpl.class, btCarRentalInfo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BtCarRentalInfo> btCarRentalInfos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BtCarRentalInfo btCarRentalInfo : btCarRentalInfos) {
			EntityCacheUtil.removeResult(BtCarRentalInfoModelImpl.ENTITY_CACHE_ENABLED,
				BtCarRentalInfoImpl.class, btCarRentalInfo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bt car rental info with the primary key. Does not add the bt car rental info to the database.
	 *
	 * @param btCarRentalInfoId the primary key for the new bt car rental info
	 * @return the new bt car rental info
	 */
	@Override
	public BtCarRentalInfo create(long btCarRentalInfoId) {
		BtCarRentalInfo btCarRentalInfo = new BtCarRentalInfoImpl();

		btCarRentalInfo.setNew(true);
		btCarRentalInfo.setPrimaryKey(btCarRentalInfoId);

		return btCarRentalInfo;
	}

	/**
	 * Removes the bt car rental info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param btCarRentalInfoId the primary key of the bt car rental info
	 * @return the bt car rental info that was removed
	 * @throws com.business.trip.NoSuchBtCarRentalInfoException if a bt car rental info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCarRentalInfo remove(long btCarRentalInfoId)
		throws NoSuchBtCarRentalInfoException, SystemException {
		return remove((Serializable)btCarRentalInfoId);
	}

	/**
	 * Removes the bt car rental info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bt car rental info
	 * @return the bt car rental info that was removed
	 * @throws com.business.trip.NoSuchBtCarRentalInfoException if a bt car rental info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCarRentalInfo remove(Serializable primaryKey)
		throws NoSuchBtCarRentalInfoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BtCarRentalInfo btCarRentalInfo = (BtCarRentalInfo)session.get(BtCarRentalInfoImpl.class,
					primaryKey);

			if (btCarRentalInfo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBtCarRentalInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(btCarRentalInfo);
		}
		catch (NoSuchBtCarRentalInfoException nsee) {
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
	protected BtCarRentalInfo removeImpl(BtCarRentalInfo btCarRentalInfo)
		throws SystemException {
		btCarRentalInfo = toUnwrappedModel(btCarRentalInfo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(btCarRentalInfo)) {
				btCarRentalInfo = (BtCarRentalInfo)session.get(BtCarRentalInfoImpl.class,
						btCarRentalInfo.getPrimaryKeyObj());
			}

			if (btCarRentalInfo != null) {
				session.delete(btCarRentalInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (btCarRentalInfo != null) {
			clearCache(btCarRentalInfo);
		}

		return btCarRentalInfo;
	}

	@Override
	public BtCarRentalInfo updateImpl(
		com.business.trip.model.BtCarRentalInfo btCarRentalInfo)
		throws SystemException {
		btCarRentalInfo = toUnwrappedModel(btCarRentalInfo);

		boolean isNew = btCarRentalInfo.isNew();

		BtCarRentalInfoModelImpl btCarRentalInfoModelImpl = (BtCarRentalInfoModelImpl)btCarRentalInfo;

		Session session = null;

		try {
			session = openSession();

			if (btCarRentalInfo.isNew()) {
				session.save(btCarRentalInfo);

				btCarRentalInfo.setNew(false);
			}
			else {
				session.merge(btCarRentalInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BtCarRentalInfoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((btCarRentalInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						btCarRentalInfoModelImpl.getOriginalTicketNo(),
						btCarRentalInfoModelImpl.getOriginalTripType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T,
					args);

				args = new Object[] {
						btCarRentalInfoModelImpl.getTicketNo(),
						btCarRentalInfoModelImpl.getTripType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T,
					args);
			}

			if ((btCarRentalInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						btCarRentalInfoModelImpl.getOriginalBusinessTripPkId(),
						btCarRentalInfoModelImpl.getOriginalTripType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_B_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_T,
					args);

				args = new Object[] {
						btCarRentalInfoModelImpl.getBusinessTripPkId(),
						btCarRentalInfoModelImpl.getTripType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_B_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_T,
					args);
			}
		}

		EntityCacheUtil.putResult(BtCarRentalInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtCarRentalInfoImpl.class, btCarRentalInfo.getPrimaryKey(),
			btCarRentalInfo);

		return btCarRentalInfo;
	}

	protected BtCarRentalInfo toUnwrappedModel(BtCarRentalInfo btCarRentalInfo) {
		if (btCarRentalInfo instanceof BtCarRentalInfoImpl) {
			return btCarRentalInfo;
		}

		BtCarRentalInfoImpl btCarRentalInfoImpl = new BtCarRentalInfoImpl();

		btCarRentalInfoImpl.setNew(btCarRentalInfo.isNew());
		btCarRentalInfoImpl.setPrimaryKey(btCarRentalInfo.getPrimaryKey());

		btCarRentalInfoImpl.setBtCarRentalInfoId(btCarRentalInfo.getBtCarRentalInfoId());
		btCarRentalInfoImpl.setBusinessTripPkId(btCarRentalInfo.getBusinessTripPkId());
		btCarRentalInfoImpl.setTicketNo(btCarRentalInfo.getTicketNo());
		btCarRentalInfoImpl.setPickupLocation(btCarRentalInfo.getPickupLocation());
		btCarRentalInfoImpl.setPickupDate(btCarRentalInfo.getPickupDate());
		btCarRentalInfoImpl.setDropoffLocation(btCarRentalInfo.getDropoffLocation());
		btCarRentalInfoImpl.setDropoffDate(btCarRentalInfo.getDropoffDate());
		btCarRentalInfoImpl.setCarType(btCarRentalInfo.getCarType());
		btCarRentalInfoImpl.setTypeOfRental(btCarRentalInfo.getTypeOfRental());
		btCarRentalInfoImpl.setPrice(btCarRentalInfo.getPrice());
		btCarRentalInfoImpl.setCurrency(btCarRentalInfo.getCurrency());
		btCarRentalInfoImpl.setTripType(btCarRentalInfo.getTripType());

		return btCarRentalInfoImpl;
	}

	/**
	 * Returns the bt car rental info with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bt car rental info
	 * @return the bt car rental info
	 * @throws com.business.trip.NoSuchBtCarRentalInfoException if a bt car rental info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCarRentalInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBtCarRentalInfoException, SystemException {
		BtCarRentalInfo btCarRentalInfo = fetchByPrimaryKey(primaryKey);

		if (btCarRentalInfo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBtCarRentalInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return btCarRentalInfo;
	}

	/**
	 * Returns the bt car rental info with the primary key or throws a {@link com.business.trip.NoSuchBtCarRentalInfoException} if it could not be found.
	 *
	 * @param btCarRentalInfoId the primary key of the bt car rental info
	 * @return the bt car rental info
	 * @throws com.business.trip.NoSuchBtCarRentalInfoException if a bt car rental info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCarRentalInfo findByPrimaryKey(long btCarRentalInfoId)
		throws NoSuchBtCarRentalInfoException, SystemException {
		return findByPrimaryKey((Serializable)btCarRentalInfoId);
	}

	/**
	 * Returns the bt car rental info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bt car rental info
	 * @return the bt car rental info, or <code>null</code> if a bt car rental info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCarRentalInfo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BtCarRentalInfo btCarRentalInfo = (BtCarRentalInfo)EntityCacheUtil.getResult(BtCarRentalInfoModelImpl.ENTITY_CACHE_ENABLED,
				BtCarRentalInfoImpl.class, primaryKey);

		if (btCarRentalInfo == _nullBtCarRentalInfo) {
			return null;
		}

		if (btCarRentalInfo == null) {
			Session session = null;

			try {
				session = openSession();

				btCarRentalInfo = (BtCarRentalInfo)session.get(BtCarRentalInfoImpl.class,
						primaryKey);

				if (btCarRentalInfo != null) {
					cacheResult(btCarRentalInfo);
				}
				else {
					EntityCacheUtil.putResult(BtCarRentalInfoModelImpl.ENTITY_CACHE_ENABLED,
						BtCarRentalInfoImpl.class, primaryKey,
						_nullBtCarRentalInfo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BtCarRentalInfoModelImpl.ENTITY_CACHE_ENABLED,
					BtCarRentalInfoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return btCarRentalInfo;
	}

	/**
	 * Returns the bt car rental info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param btCarRentalInfoId the primary key of the bt car rental info
	 * @return the bt car rental info, or <code>null</code> if a bt car rental info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCarRentalInfo fetchByPrimaryKey(long btCarRentalInfoId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)btCarRentalInfoId);
	}

	/**
	 * Returns all the bt car rental infos.
	 *
	 * @return the bt car rental infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtCarRentalInfo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bt car rental infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCarRentalInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bt car rental infos
	 * @param end the upper bound of the range of bt car rental infos (not inclusive)
	 * @return the range of bt car rental infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtCarRentalInfo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt car rental infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCarRentalInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bt car rental infos
	 * @param end the upper bound of the range of bt car rental infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bt car rental infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtCarRentalInfo> findAll(int start, int end,
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

		List<BtCarRentalInfo> list = (List<BtCarRentalInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BTCARRENTALINFO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BTCARRENTALINFO;

				if (pagination) {
					sql = sql.concat(BtCarRentalInfoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BtCarRentalInfo>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtCarRentalInfo>(list);
				}
				else {
					list = (List<BtCarRentalInfo>)QueryUtil.list(q,
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
	 * Removes all the bt car rental infos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BtCarRentalInfo btCarRentalInfo : findAll()) {
			remove(btCarRentalInfo);
		}
	}

	/**
	 * Returns the number of bt car rental infos.
	 *
	 * @return the number of bt car rental infos
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

				Query q = session.createQuery(_SQL_COUNT_BTCARRENTALINFO);

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
	 * Initializes the bt car rental info persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.business.trip.model.BtCarRentalInfo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BtCarRentalInfo>> listenersList = new ArrayList<ModelListener<BtCarRentalInfo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BtCarRentalInfo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BtCarRentalInfoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BTCARRENTALINFO = "SELECT btCarRentalInfo FROM BtCarRentalInfo btCarRentalInfo";
	private static final String _SQL_SELECT_BTCARRENTALINFO_WHERE = "SELECT btCarRentalInfo FROM BtCarRentalInfo btCarRentalInfo WHERE ";
	private static final String _SQL_COUNT_BTCARRENTALINFO = "SELECT COUNT(btCarRentalInfo) FROM BtCarRentalInfo btCarRentalInfo";
	private static final String _SQL_COUNT_BTCARRENTALINFO_WHERE = "SELECT COUNT(btCarRentalInfo) FROM BtCarRentalInfo btCarRentalInfo WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "btCarRentalInfo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BtCarRentalInfo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BtCarRentalInfo exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BtCarRentalInfoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"currency"
			});
	private static BtCarRentalInfo _nullBtCarRentalInfo = new BtCarRentalInfoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BtCarRentalInfo> toCacheModel() {
				return _nullBtCarRentalInfoCacheModel;
			}
		};

	private static CacheModel<BtCarRentalInfo> _nullBtCarRentalInfoCacheModel = new CacheModel<BtCarRentalInfo>() {
			@Override
			public BtCarRentalInfo toEntityModel() {
				return _nullBtCarRentalInfo;
			}
		};
}