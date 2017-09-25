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

import com.business.trip.NoSuchBtHotelInfoException;
import com.business.trip.model.BtHotelInfo;
import com.business.trip.model.impl.BtHotelInfoImpl;
import com.business.trip.model.impl.BtHotelInfoModelImpl;
import com.business.trip.service.persistence.BtHotelInfoPersistence;

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
 * The persistence implementation for the bt hotel info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtHotelInfoPersistence
 * @see BtHotelInfoUtil
 * @generated
 */
public class BtHotelInfoPersistenceImpl extends BasePersistenceImpl<BtHotelInfo>
	implements BtHotelInfoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BtHotelInfoUtil} to access the bt hotel info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BtHotelInfoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BtHotelInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtHotelInfoModelImpl.FINDER_CACHE_ENABLED, BtHotelInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BtHotelInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtHotelInfoModelImpl.FINDER_CACHE_ENABLED, BtHotelInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BtHotelInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtHotelInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_T_T = new FinderPath(BtHotelInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtHotelInfoModelImpl.FINDER_CACHE_ENABLED, BtHotelInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByT_T",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T = new FinderPath(BtHotelInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtHotelInfoModelImpl.FINDER_CACHE_ENABLED, BtHotelInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByT_T",
			new String[] { String.class.getName(), String.class.getName() },
			BtHotelInfoModelImpl.TICKETNO_COLUMN_BITMASK |
			BtHotelInfoModelImpl.TRIPTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_T_T = new FinderPath(BtHotelInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtHotelInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByT_T",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the bt hotel infos where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @return the matching bt hotel infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtHotelInfo> findByT_T(String ticketNo, String tripType)
		throws SystemException {
		return findByT_T(ticketNo, tripType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bt hotel infos where ticketNo = &#63; and tripType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtHotelInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param start the lower bound of the range of bt hotel infos
	 * @param end the upper bound of the range of bt hotel infos (not inclusive)
	 * @return the range of matching bt hotel infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtHotelInfo> findByT_T(String ticketNo, String tripType,
		int start, int end) throws SystemException {
		return findByT_T(ticketNo, tripType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt hotel infos where ticketNo = &#63; and tripType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtHotelInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param start the lower bound of the range of bt hotel infos
	 * @param end the upper bound of the range of bt hotel infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bt hotel infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtHotelInfo> findByT_T(String ticketNo, String tripType,
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

		List<BtHotelInfo> list = (List<BtHotelInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BtHotelInfo btHotelInfo : list) {
				if (!Validator.equals(ticketNo, btHotelInfo.getTicketNo()) ||
						!Validator.equals(tripType, btHotelInfo.getTripType())) {
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

			query.append(_SQL_SELECT_BTHOTELINFO_WHERE);

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
				query.append(BtHotelInfoModelImpl.ORDER_BY_JPQL);
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
					list = (List<BtHotelInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtHotelInfo>(list);
				}
				else {
					list = (List<BtHotelInfo>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first bt hotel info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt hotel info
	 * @throws com.business.trip.NoSuchBtHotelInfoException if a matching bt hotel info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtHotelInfo findByT_T_First(String ticketNo, String tripType,
		OrderByComparator orderByComparator)
		throws NoSuchBtHotelInfoException, SystemException {
		BtHotelInfo btHotelInfo = fetchByT_T_First(ticketNo, tripType,
				orderByComparator);

		if (btHotelInfo != null) {
			return btHotelInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketNo=");
		msg.append(ticketNo);

		msg.append(", tripType=");
		msg.append(tripType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtHotelInfoException(msg.toString());
	}

	/**
	 * Returns the first bt hotel info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt hotel info, or <code>null</code> if a matching bt hotel info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtHotelInfo fetchByT_T_First(String ticketNo, String tripType,
		OrderByComparator orderByComparator) throws SystemException {
		List<BtHotelInfo> list = findByT_T(ticketNo, tripType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bt hotel info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt hotel info
	 * @throws com.business.trip.NoSuchBtHotelInfoException if a matching bt hotel info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtHotelInfo findByT_T_Last(String ticketNo, String tripType,
		OrderByComparator orderByComparator)
		throws NoSuchBtHotelInfoException, SystemException {
		BtHotelInfo btHotelInfo = fetchByT_T_Last(ticketNo, tripType,
				orderByComparator);

		if (btHotelInfo != null) {
			return btHotelInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketNo=");
		msg.append(ticketNo);

		msg.append(", tripType=");
		msg.append(tripType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtHotelInfoException(msg.toString());
	}

	/**
	 * Returns the last bt hotel info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt hotel info, or <code>null</code> if a matching bt hotel info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtHotelInfo fetchByT_T_Last(String ticketNo, String tripType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByT_T(ticketNo, tripType);

		if (count == 0) {
			return null;
		}

		List<BtHotelInfo> list = findByT_T(ticketNo, tripType, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bt hotel infos before and after the current bt hotel info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param btHotelInfoId the primary key of the current bt hotel info
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bt hotel info
	 * @throws com.business.trip.NoSuchBtHotelInfoException if a bt hotel info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtHotelInfo[] findByT_T_PrevAndNext(long btHotelInfoId,
		String ticketNo, String tripType, OrderByComparator orderByComparator)
		throws NoSuchBtHotelInfoException, SystemException {
		BtHotelInfo btHotelInfo = findByPrimaryKey(btHotelInfoId);

		Session session = null;

		try {
			session = openSession();

			BtHotelInfo[] array = new BtHotelInfoImpl[3];

			array[0] = getByT_T_PrevAndNext(session, btHotelInfo, ticketNo,
					tripType, orderByComparator, true);

			array[1] = btHotelInfo;

			array[2] = getByT_T_PrevAndNext(session, btHotelInfo, ticketNo,
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

	protected BtHotelInfo getByT_T_PrevAndNext(Session session,
		BtHotelInfo btHotelInfo, String ticketNo, String tripType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BTHOTELINFO_WHERE);

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
			query.append(BtHotelInfoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(btHotelInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BtHotelInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bt hotel infos where ticketNo = &#63; and tripType = &#63; from the database.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByT_T(String ticketNo, String tripType)
		throws SystemException {
		for (BtHotelInfo btHotelInfo : findByT_T(ticketNo, tripType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(btHotelInfo);
		}
	}

	/**
	 * Returns the number of bt hotel infos where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @return the number of matching bt hotel infos
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

			query.append(_SQL_COUNT_BTHOTELINFO_WHERE);

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

	private static final String _FINDER_COLUMN_T_T_TICKETNO_1 = "btHotelInfo.ticketNo IS NULL AND ";
	private static final String _FINDER_COLUMN_T_T_TICKETNO_2 = "btHotelInfo.ticketNo = ? AND ";
	private static final String _FINDER_COLUMN_T_T_TICKETNO_3 = "(btHotelInfo.ticketNo IS NULL OR btHotelInfo.ticketNo = '') AND ";
	private static final String _FINDER_COLUMN_T_T_TRIPTYPE_1 = "btHotelInfo.tripType IS NULL";
	private static final String _FINDER_COLUMN_T_T_TRIPTYPE_2 = "btHotelInfo.tripType = ?";
	private static final String _FINDER_COLUMN_T_T_TRIPTYPE_3 = "(btHotelInfo.tripType IS NULL OR btHotelInfo.tripType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_B_T = new FinderPath(BtHotelInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtHotelInfoModelImpl.FINDER_CACHE_ENABLED, BtHotelInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByB_T",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_T = new FinderPath(BtHotelInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtHotelInfoModelImpl.FINDER_CACHE_ENABLED, BtHotelInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByB_T",
			new String[] { Long.class.getName(), String.class.getName() },
			BtHotelInfoModelImpl.BUSINESSTRIPPKID_COLUMN_BITMASK |
			BtHotelInfoModelImpl.TRIPTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_B_T = new FinderPath(BtHotelInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtHotelInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_T",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the bt hotel infos where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @return the matching bt hotel infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtHotelInfo> findByB_T(long businessTripPkId, String tripType)
		throws SystemException {
		return findByB_T(businessTripPkId, tripType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bt hotel infos where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtHotelInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param start the lower bound of the range of bt hotel infos
	 * @param end the upper bound of the range of bt hotel infos (not inclusive)
	 * @return the range of matching bt hotel infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtHotelInfo> findByB_T(long businessTripPkId, String tripType,
		int start, int end) throws SystemException {
		return findByB_T(businessTripPkId, tripType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt hotel infos where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtHotelInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param start the lower bound of the range of bt hotel infos
	 * @param end the upper bound of the range of bt hotel infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bt hotel infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtHotelInfo> findByB_T(long businessTripPkId, String tripType,
		int start, int end, OrderByComparator orderByComparator)
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

		List<BtHotelInfo> list = (List<BtHotelInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BtHotelInfo btHotelInfo : list) {
				if ((businessTripPkId != btHotelInfo.getBusinessTripPkId()) ||
						!Validator.equals(tripType, btHotelInfo.getTripType())) {
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

			query.append(_SQL_SELECT_BTHOTELINFO_WHERE);

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
				query.append(BtHotelInfoModelImpl.ORDER_BY_JPQL);
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
					list = (List<BtHotelInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtHotelInfo>(list);
				}
				else {
					list = (List<BtHotelInfo>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first bt hotel info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt hotel info
	 * @throws com.business.trip.NoSuchBtHotelInfoException if a matching bt hotel info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtHotelInfo findByB_T_First(long businessTripPkId, String tripType,
		OrderByComparator orderByComparator)
		throws NoSuchBtHotelInfoException, SystemException {
		BtHotelInfo btHotelInfo = fetchByB_T_First(businessTripPkId, tripType,
				orderByComparator);

		if (btHotelInfo != null) {
			return btHotelInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("businessTripPkId=");
		msg.append(businessTripPkId);

		msg.append(", tripType=");
		msg.append(tripType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtHotelInfoException(msg.toString());
	}

	/**
	 * Returns the first bt hotel info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt hotel info, or <code>null</code> if a matching bt hotel info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtHotelInfo fetchByB_T_First(long businessTripPkId, String tripType,
		OrderByComparator orderByComparator) throws SystemException {
		List<BtHotelInfo> list = findByB_T(businessTripPkId, tripType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bt hotel info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt hotel info
	 * @throws com.business.trip.NoSuchBtHotelInfoException if a matching bt hotel info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtHotelInfo findByB_T_Last(long businessTripPkId, String tripType,
		OrderByComparator orderByComparator)
		throws NoSuchBtHotelInfoException, SystemException {
		BtHotelInfo btHotelInfo = fetchByB_T_Last(businessTripPkId, tripType,
				orderByComparator);

		if (btHotelInfo != null) {
			return btHotelInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("businessTripPkId=");
		msg.append(businessTripPkId);

		msg.append(", tripType=");
		msg.append(tripType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtHotelInfoException(msg.toString());
	}

	/**
	 * Returns the last bt hotel info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt hotel info, or <code>null</code> if a matching bt hotel info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtHotelInfo fetchByB_T_Last(long businessTripPkId, String tripType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByB_T(businessTripPkId, tripType);

		if (count == 0) {
			return null;
		}

		List<BtHotelInfo> list = findByB_T(businessTripPkId, tripType,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bt hotel infos before and after the current bt hotel info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param btHotelInfoId the primary key of the current bt hotel info
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bt hotel info
	 * @throws com.business.trip.NoSuchBtHotelInfoException if a bt hotel info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtHotelInfo[] findByB_T_PrevAndNext(long btHotelInfoId,
		long businessTripPkId, String tripType,
		OrderByComparator orderByComparator)
		throws NoSuchBtHotelInfoException, SystemException {
		BtHotelInfo btHotelInfo = findByPrimaryKey(btHotelInfoId);

		Session session = null;

		try {
			session = openSession();

			BtHotelInfo[] array = new BtHotelInfoImpl[3];

			array[0] = getByB_T_PrevAndNext(session, btHotelInfo,
					businessTripPkId, tripType, orderByComparator, true);

			array[1] = btHotelInfo;

			array[2] = getByB_T_PrevAndNext(session, btHotelInfo,
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

	protected BtHotelInfo getByB_T_PrevAndNext(Session session,
		BtHotelInfo btHotelInfo, long businessTripPkId, String tripType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BTHOTELINFO_WHERE);

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
			query.append(BtHotelInfoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(btHotelInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BtHotelInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bt hotel infos where businessTripPkId = &#63; and tripType = &#63; from the database.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByB_T(long businessTripPkId, String tripType)
		throws SystemException {
		for (BtHotelInfo btHotelInfo : findByB_T(businessTripPkId, tripType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(btHotelInfo);
		}
	}

	/**
	 * Returns the number of bt hotel infos where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @return the number of matching bt hotel infos
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

			query.append(_SQL_COUNT_BTHOTELINFO_WHERE);

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

	private static final String _FINDER_COLUMN_B_T_BUSINESSTRIPPKID_2 = "btHotelInfo.businessTripPkId = ? AND ";
	private static final String _FINDER_COLUMN_B_T_TRIPTYPE_1 = "btHotelInfo.tripType IS NULL";
	private static final String _FINDER_COLUMN_B_T_TRIPTYPE_2 = "btHotelInfo.tripType = ?";
	private static final String _FINDER_COLUMN_B_T_TRIPTYPE_3 = "(btHotelInfo.tripType IS NULL OR btHotelInfo.tripType = '')";

	public BtHotelInfoPersistenceImpl() {
		setModelClass(BtHotelInfo.class);
	}

	/**
	 * Caches the bt hotel info in the entity cache if it is enabled.
	 *
	 * @param btHotelInfo the bt hotel info
	 */
	@Override
	public void cacheResult(BtHotelInfo btHotelInfo) {
		EntityCacheUtil.putResult(BtHotelInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtHotelInfoImpl.class, btHotelInfo.getPrimaryKey(), btHotelInfo);

		btHotelInfo.resetOriginalValues();
	}

	/**
	 * Caches the bt hotel infos in the entity cache if it is enabled.
	 *
	 * @param btHotelInfos the bt hotel infos
	 */
	@Override
	public void cacheResult(List<BtHotelInfo> btHotelInfos) {
		for (BtHotelInfo btHotelInfo : btHotelInfos) {
			if (EntityCacheUtil.getResult(
						BtHotelInfoModelImpl.ENTITY_CACHE_ENABLED,
						BtHotelInfoImpl.class, btHotelInfo.getPrimaryKey()) == null) {
				cacheResult(btHotelInfo);
			}
			else {
				btHotelInfo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bt hotel infos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BtHotelInfoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BtHotelInfoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bt hotel info.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BtHotelInfo btHotelInfo) {
		EntityCacheUtil.removeResult(BtHotelInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtHotelInfoImpl.class, btHotelInfo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BtHotelInfo> btHotelInfos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BtHotelInfo btHotelInfo : btHotelInfos) {
			EntityCacheUtil.removeResult(BtHotelInfoModelImpl.ENTITY_CACHE_ENABLED,
				BtHotelInfoImpl.class, btHotelInfo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bt hotel info with the primary key. Does not add the bt hotel info to the database.
	 *
	 * @param btHotelInfoId the primary key for the new bt hotel info
	 * @return the new bt hotel info
	 */
	@Override
	public BtHotelInfo create(long btHotelInfoId) {
		BtHotelInfo btHotelInfo = new BtHotelInfoImpl();

		btHotelInfo.setNew(true);
		btHotelInfo.setPrimaryKey(btHotelInfoId);

		return btHotelInfo;
	}

	/**
	 * Removes the bt hotel info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param btHotelInfoId the primary key of the bt hotel info
	 * @return the bt hotel info that was removed
	 * @throws com.business.trip.NoSuchBtHotelInfoException if a bt hotel info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtHotelInfo remove(long btHotelInfoId)
		throws NoSuchBtHotelInfoException, SystemException {
		return remove((Serializable)btHotelInfoId);
	}

	/**
	 * Removes the bt hotel info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bt hotel info
	 * @return the bt hotel info that was removed
	 * @throws com.business.trip.NoSuchBtHotelInfoException if a bt hotel info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtHotelInfo remove(Serializable primaryKey)
		throws NoSuchBtHotelInfoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BtHotelInfo btHotelInfo = (BtHotelInfo)session.get(BtHotelInfoImpl.class,
					primaryKey);

			if (btHotelInfo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBtHotelInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(btHotelInfo);
		}
		catch (NoSuchBtHotelInfoException nsee) {
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
	protected BtHotelInfo removeImpl(BtHotelInfo btHotelInfo)
		throws SystemException {
		btHotelInfo = toUnwrappedModel(btHotelInfo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(btHotelInfo)) {
				btHotelInfo = (BtHotelInfo)session.get(BtHotelInfoImpl.class,
						btHotelInfo.getPrimaryKeyObj());
			}

			if (btHotelInfo != null) {
				session.delete(btHotelInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (btHotelInfo != null) {
			clearCache(btHotelInfo);
		}

		return btHotelInfo;
	}

	@Override
	public BtHotelInfo updateImpl(
		com.business.trip.model.BtHotelInfo btHotelInfo)
		throws SystemException {
		btHotelInfo = toUnwrappedModel(btHotelInfo);

		boolean isNew = btHotelInfo.isNew();

		BtHotelInfoModelImpl btHotelInfoModelImpl = (BtHotelInfoModelImpl)btHotelInfo;

		Session session = null;

		try {
			session = openSession();

			if (btHotelInfo.isNew()) {
				session.save(btHotelInfo);

				btHotelInfo.setNew(false);
			}
			else {
				session.merge(btHotelInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BtHotelInfoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((btHotelInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						btHotelInfoModelImpl.getOriginalTicketNo(),
						btHotelInfoModelImpl.getOriginalTripType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T,
					args);

				args = new Object[] {
						btHotelInfoModelImpl.getTicketNo(),
						btHotelInfoModelImpl.getTripType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T,
					args);
			}

			if ((btHotelInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						btHotelInfoModelImpl.getOriginalBusinessTripPkId(),
						btHotelInfoModelImpl.getOriginalTripType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_B_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_T,
					args);

				args = new Object[] {
						btHotelInfoModelImpl.getBusinessTripPkId(),
						btHotelInfoModelImpl.getTripType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_B_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_T,
					args);
			}
		}

		EntityCacheUtil.putResult(BtHotelInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtHotelInfoImpl.class, btHotelInfo.getPrimaryKey(), btHotelInfo);

		return btHotelInfo;
	}

	protected BtHotelInfo toUnwrappedModel(BtHotelInfo btHotelInfo) {
		if (btHotelInfo instanceof BtHotelInfoImpl) {
			return btHotelInfo;
		}

		BtHotelInfoImpl btHotelInfoImpl = new BtHotelInfoImpl();

		btHotelInfoImpl.setNew(btHotelInfo.isNew());
		btHotelInfoImpl.setPrimaryKey(btHotelInfo.getPrimaryKey());

		btHotelInfoImpl.setBtHotelInfoId(btHotelInfo.getBtHotelInfoId());
		btHotelInfoImpl.setBusinessTripPkId(btHotelInfo.getBusinessTripPkId());
		btHotelInfoImpl.setTicketNo(btHotelInfo.getTicketNo());
		btHotelInfoImpl.setCity(btHotelInfo.getCity());
		btHotelInfoImpl.setCityType(btHotelInfo.getCityType());
		btHotelInfoImpl.setHotel(btHotelInfo.getHotel());
		btHotelInfoImpl.setCheckIn(btHotelInfo.getCheckIn());
		btHotelInfoImpl.setCheckOut(btHotelInfo.getCheckOut());
		btHotelInfoImpl.setRoomCategory(btHotelInfo.getRoomCategory());
		btHotelInfoImpl.setPrice(btHotelInfo.getPrice());
		btHotelInfoImpl.setCurrency(btHotelInfo.getCurrency());
		btHotelInfoImpl.setOtherReasonInfo(btHotelInfo.getOtherReasonInfo());
		btHotelInfoImpl.setIsNotBookedFromTA(btHotelInfo.isIsNotBookedFromTA());
		btHotelInfoImpl.setIsOverBudget(btHotelInfo.getIsOverBudget());
		btHotelInfoImpl.setOthersSpecify(btHotelInfo.getOthersSpecify());
		btHotelInfoImpl.setTripType(btHotelInfo.getTripType());

		return btHotelInfoImpl;
	}

	/**
	 * Returns the bt hotel info with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bt hotel info
	 * @return the bt hotel info
	 * @throws com.business.trip.NoSuchBtHotelInfoException if a bt hotel info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtHotelInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBtHotelInfoException, SystemException {
		BtHotelInfo btHotelInfo = fetchByPrimaryKey(primaryKey);

		if (btHotelInfo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBtHotelInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return btHotelInfo;
	}

	/**
	 * Returns the bt hotel info with the primary key or throws a {@link com.business.trip.NoSuchBtHotelInfoException} if it could not be found.
	 *
	 * @param btHotelInfoId the primary key of the bt hotel info
	 * @return the bt hotel info
	 * @throws com.business.trip.NoSuchBtHotelInfoException if a bt hotel info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtHotelInfo findByPrimaryKey(long btHotelInfoId)
		throws NoSuchBtHotelInfoException, SystemException {
		return findByPrimaryKey((Serializable)btHotelInfoId);
	}

	/**
	 * Returns the bt hotel info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bt hotel info
	 * @return the bt hotel info, or <code>null</code> if a bt hotel info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtHotelInfo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BtHotelInfo btHotelInfo = (BtHotelInfo)EntityCacheUtil.getResult(BtHotelInfoModelImpl.ENTITY_CACHE_ENABLED,
				BtHotelInfoImpl.class, primaryKey);

		if (btHotelInfo == _nullBtHotelInfo) {
			return null;
		}

		if (btHotelInfo == null) {
			Session session = null;

			try {
				session = openSession();

				btHotelInfo = (BtHotelInfo)session.get(BtHotelInfoImpl.class,
						primaryKey);

				if (btHotelInfo != null) {
					cacheResult(btHotelInfo);
				}
				else {
					EntityCacheUtil.putResult(BtHotelInfoModelImpl.ENTITY_CACHE_ENABLED,
						BtHotelInfoImpl.class, primaryKey, _nullBtHotelInfo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BtHotelInfoModelImpl.ENTITY_CACHE_ENABLED,
					BtHotelInfoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return btHotelInfo;
	}

	/**
	 * Returns the bt hotel info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param btHotelInfoId the primary key of the bt hotel info
	 * @return the bt hotel info, or <code>null</code> if a bt hotel info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtHotelInfo fetchByPrimaryKey(long btHotelInfoId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)btHotelInfoId);
	}

	/**
	 * Returns all the bt hotel infos.
	 *
	 * @return the bt hotel infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtHotelInfo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bt hotel infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtHotelInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bt hotel infos
	 * @param end the upper bound of the range of bt hotel infos (not inclusive)
	 * @return the range of bt hotel infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtHotelInfo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt hotel infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtHotelInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bt hotel infos
	 * @param end the upper bound of the range of bt hotel infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bt hotel infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtHotelInfo> findAll(int start, int end,
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

		List<BtHotelInfo> list = (List<BtHotelInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BTHOTELINFO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BTHOTELINFO;

				if (pagination) {
					sql = sql.concat(BtHotelInfoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BtHotelInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtHotelInfo>(list);
				}
				else {
					list = (List<BtHotelInfo>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the bt hotel infos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BtHotelInfo btHotelInfo : findAll()) {
			remove(btHotelInfo);
		}
	}

	/**
	 * Returns the number of bt hotel infos.
	 *
	 * @return the number of bt hotel infos
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

				Query q = session.createQuery(_SQL_COUNT_BTHOTELINFO);

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
	 * Initializes the bt hotel info persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.business.trip.model.BtHotelInfo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BtHotelInfo>> listenersList = new ArrayList<ModelListener<BtHotelInfo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BtHotelInfo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BtHotelInfoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BTHOTELINFO = "SELECT btHotelInfo FROM BtHotelInfo btHotelInfo";
	private static final String _SQL_SELECT_BTHOTELINFO_WHERE = "SELECT btHotelInfo FROM BtHotelInfo btHotelInfo WHERE ";
	private static final String _SQL_COUNT_BTHOTELINFO = "SELECT COUNT(btHotelInfo) FROM BtHotelInfo btHotelInfo";
	private static final String _SQL_COUNT_BTHOTELINFO_WHERE = "SELECT COUNT(btHotelInfo) FROM BtHotelInfo btHotelInfo WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "btHotelInfo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BtHotelInfo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BtHotelInfo exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BtHotelInfoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"currency"
			});
	private static BtHotelInfo _nullBtHotelInfo = new BtHotelInfoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BtHotelInfo> toCacheModel() {
				return _nullBtHotelInfoCacheModel;
			}
		};

	private static CacheModel<BtHotelInfo> _nullBtHotelInfoCacheModel = new CacheModel<BtHotelInfo>() {
			@Override
			public BtHotelInfo toEntityModel() {
				return _nullBtHotelInfo;
			}
		};
}