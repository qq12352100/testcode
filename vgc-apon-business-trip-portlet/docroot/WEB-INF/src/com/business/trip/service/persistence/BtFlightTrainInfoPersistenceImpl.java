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

import com.business.trip.NoSuchBtFlightTrainInfoException;
import com.business.trip.model.BtFlightTrainInfo;
import com.business.trip.model.impl.BtFlightTrainInfoImpl;
import com.business.trip.model.impl.BtFlightTrainInfoModelImpl;
import com.business.trip.service.persistence.BtFlightTrainInfoPersistence;

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
 * The persistence implementation for the bt flight train info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtFlightTrainInfoPersistence
 * @see BtFlightTrainInfoUtil
 * @generated
 */
public class BtFlightTrainInfoPersistenceImpl extends BasePersistenceImpl<BtFlightTrainInfo>
	implements BtFlightTrainInfoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BtFlightTrainInfoUtil} to access the bt flight train info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BtFlightTrainInfoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BtFlightTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtFlightTrainInfoModelImpl.FINDER_CACHE_ENABLED,
			BtFlightTrainInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BtFlightTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtFlightTrainInfoModelImpl.FINDER_CACHE_ENABLED,
			BtFlightTrainInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BtFlightTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtFlightTrainInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_T_T = new FinderPath(BtFlightTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtFlightTrainInfoModelImpl.FINDER_CACHE_ENABLED,
			BtFlightTrainInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByT_T",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T = new FinderPath(BtFlightTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtFlightTrainInfoModelImpl.FINDER_CACHE_ENABLED,
			BtFlightTrainInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByT_T",
			new String[] { String.class.getName(), String.class.getName() },
			BtFlightTrainInfoModelImpl.TICKETNO_COLUMN_BITMASK |
			BtFlightTrainInfoModelImpl.TRIPTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_T_T = new FinderPath(BtFlightTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtFlightTrainInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByT_T",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the bt flight train infos where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @return the matching bt flight train infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtFlightTrainInfo> findByT_T(String ticketNo, String tripType)
		throws SystemException {
		return findByT_T(ticketNo, tripType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bt flight train infos where ticketNo = &#63; and tripType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtFlightTrainInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param start the lower bound of the range of bt flight train infos
	 * @param end the upper bound of the range of bt flight train infos (not inclusive)
	 * @return the range of matching bt flight train infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtFlightTrainInfo> findByT_T(String ticketNo, String tripType,
		int start, int end) throws SystemException {
		return findByT_T(ticketNo, tripType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt flight train infos where ticketNo = &#63; and tripType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtFlightTrainInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param start the lower bound of the range of bt flight train infos
	 * @param end the upper bound of the range of bt flight train infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bt flight train infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtFlightTrainInfo> findByT_T(String ticketNo, String tripType,
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

		List<BtFlightTrainInfo> list = (List<BtFlightTrainInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BtFlightTrainInfo btFlightTrainInfo : list) {
				if (!Validator.equals(ticketNo, btFlightTrainInfo.getTicketNo()) ||
						!Validator.equals(tripType,
							btFlightTrainInfo.getTripType())) {
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

			query.append(_SQL_SELECT_BTFLIGHTTRAININFO_WHERE);

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
				query.append(BtFlightTrainInfoModelImpl.ORDER_BY_JPQL);
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
					list = (List<BtFlightTrainInfo>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtFlightTrainInfo>(list);
				}
				else {
					list = (List<BtFlightTrainInfo>)QueryUtil.list(q,
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
	 * Returns the first bt flight train info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt flight train info
	 * @throws com.business.trip.NoSuchBtFlightTrainInfoException if a matching bt flight train info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtFlightTrainInfo findByT_T_First(String ticketNo, String tripType,
		OrderByComparator orderByComparator)
		throws NoSuchBtFlightTrainInfoException, SystemException {
		BtFlightTrainInfo btFlightTrainInfo = fetchByT_T_First(ticketNo,
				tripType, orderByComparator);

		if (btFlightTrainInfo != null) {
			return btFlightTrainInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketNo=");
		msg.append(ticketNo);

		msg.append(", tripType=");
		msg.append(tripType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtFlightTrainInfoException(msg.toString());
	}

	/**
	 * Returns the first bt flight train info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt flight train info, or <code>null</code> if a matching bt flight train info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtFlightTrainInfo fetchByT_T_First(String ticketNo, String tripType,
		OrderByComparator orderByComparator) throws SystemException {
		List<BtFlightTrainInfo> list = findByT_T(ticketNo, tripType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bt flight train info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt flight train info
	 * @throws com.business.trip.NoSuchBtFlightTrainInfoException if a matching bt flight train info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtFlightTrainInfo findByT_T_Last(String ticketNo, String tripType,
		OrderByComparator orderByComparator)
		throws NoSuchBtFlightTrainInfoException, SystemException {
		BtFlightTrainInfo btFlightTrainInfo = fetchByT_T_Last(ticketNo,
				tripType, orderByComparator);

		if (btFlightTrainInfo != null) {
			return btFlightTrainInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketNo=");
		msg.append(ticketNo);

		msg.append(", tripType=");
		msg.append(tripType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtFlightTrainInfoException(msg.toString());
	}

	/**
	 * Returns the last bt flight train info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt flight train info, or <code>null</code> if a matching bt flight train info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtFlightTrainInfo fetchByT_T_Last(String ticketNo, String tripType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByT_T(ticketNo, tripType);

		if (count == 0) {
			return null;
		}

		List<BtFlightTrainInfo> list = findByT_T(ticketNo, tripType, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bt flight train infos before and after the current bt flight train info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param btFlightTrainInfoId the primary key of the current bt flight train info
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bt flight train info
	 * @throws com.business.trip.NoSuchBtFlightTrainInfoException if a bt flight train info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtFlightTrainInfo[] findByT_T_PrevAndNext(long btFlightTrainInfoId,
		String ticketNo, String tripType, OrderByComparator orderByComparator)
		throws NoSuchBtFlightTrainInfoException, SystemException {
		BtFlightTrainInfo btFlightTrainInfo = findByPrimaryKey(btFlightTrainInfoId);

		Session session = null;

		try {
			session = openSession();

			BtFlightTrainInfo[] array = new BtFlightTrainInfoImpl[3];

			array[0] = getByT_T_PrevAndNext(session, btFlightTrainInfo,
					ticketNo, tripType, orderByComparator, true);

			array[1] = btFlightTrainInfo;

			array[2] = getByT_T_PrevAndNext(session, btFlightTrainInfo,
					ticketNo, tripType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BtFlightTrainInfo getByT_T_PrevAndNext(Session session,
		BtFlightTrainInfo btFlightTrainInfo, String ticketNo, String tripType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BTFLIGHTTRAININFO_WHERE);

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
			query.append(BtFlightTrainInfoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(btFlightTrainInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BtFlightTrainInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bt flight train infos where ticketNo = &#63; and tripType = &#63; from the database.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByT_T(String ticketNo, String tripType)
		throws SystemException {
		for (BtFlightTrainInfo btFlightTrainInfo : findByT_T(ticketNo,
				tripType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(btFlightTrainInfo);
		}
	}

	/**
	 * Returns the number of bt flight train infos where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @return the number of matching bt flight train infos
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

			query.append(_SQL_COUNT_BTFLIGHTTRAININFO_WHERE);

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

	private static final String _FINDER_COLUMN_T_T_TICKETNO_1 = "btFlightTrainInfo.ticketNo IS NULL AND ";
	private static final String _FINDER_COLUMN_T_T_TICKETNO_2 = "btFlightTrainInfo.ticketNo = ? AND ";
	private static final String _FINDER_COLUMN_T_T_TICKETNO_3 = "(btFlightTrainInfo.ticketNo IS NULL OR btFlightTrainInfo.ticketNo = '') AND ";
	private static final String _FINDER_COLUMN_T_T_TRIPTYPE_1 = "btFlightTrainInfo.tripType IS NULL";
	private static final String _FINDER_COLUMN_T_T_TRIPTYPE_2 = "btFlightTrainInfo.tripType = ?";
	private static final String _FINDER_COLUMN_T_T_TRIPTYPE_3 = "(btFlightTrainInfo.tripType IS NULL OR btFlightTrainInfo.tripType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_B_T = new FinderPath(BtFlightTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtFlightTrainInfoModelImpl.FINDER_CACHE_ENABLED,
			BtFlightTrainInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByB_T",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_T = new FinderPath(BtFlightTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtFlightTrainInfoModelImpl.FINDER_CACHE_ENABLED,
			BtFlightTrainInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByB_T",
			new String[] { Long.class.getName(), String.class.getName() },
			BtFlightTrainInfoModelImpl.BUSINESSTRIPPKID_COLUMN_BITMASK |
			BtFlightTrainInfoModelImpl.TRIPTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_B_T = new FinderPath(BtFlightTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtFlightTrainInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_T",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the bt flight train infos where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @return the matching bt flight train infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtFlightTrainInfo> findByB_T(long businessTripPkId,
		String tripType) throws SystemException {
		return findByB_T(businessTripPkId, tripType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bt flight train infos where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtFlightTrainInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param start the lower bound of the range of bt flight train infos
	 * @param end the upper bound of the range of bt flight train infos (not inclusive)
	 * @return the range of matching bt flight train infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtFlightTrainInfo> findByB_T(long businessTripPkId,
		String tripType, int start, int end) throws SystemException {
		return findByB_T(businessTripPkId, tripType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt flight train infos where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtFlightTrainInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param start the lower bound of the range of bt flight train infos
	 * @param end the upper bound of the range of bt flight train infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bt flight train infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtFlightTrainInfo> findByB_T(long businessTripPkId,
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

		List<BtFlightTrainInfo> list = (List<BtFlightTrainInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BtFlightTrainInfo btFlightTrainInfo : list) {
				if ((businessTripPkId != btFlightTrainInfo.getBusinessTripPkId()) ||
						!Validator.equals(tripType,
							btFlightTrainInfo.getTripType())) {
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

			query.append(_SQL_SELECT_BTFLIGHTTRAININFO_WHERE);

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
				query.append(BtFlightTrainInfoModelImpl.ORDER_BY_JPQL);
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
					list = (List<BtFlightTrainInfo>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtFlightTrainInfo>(list);
				}
				else {
					list = (List<BtFlightTrainInfo>)QueryUtil.list(q,
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
	 * Returns the first bt flight train info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt flight train info
	 * @throws com.business.trip.NoSuchBtFlightTrainInfoException if a matching bt flight train info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtFlightTrainInfo findByB_T_First(long businessTripPkId,
		String tripType, OrderByComparator orderByComparator)
		throws NoSuchBtFlightTrainInfoException, SystemException {
		BtFlightTrainInfo btFlightTrainInfo = fetchByB_T_First(businessTripPkId,
				tripType, orderByComparator);

		if (btFlightTrainInfo != null) {
			return btFlightTrainInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("businessTripPkId=");
		msg.append(businessTripPkId);

		msg.append(", tripType=");
		msg.append(tripType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtFlightTrainInfoException(msg.toString());
	}

	/**
	 * Returns the first bt flight train info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt flight train info, or <code>null</code> if a matching bt flight train info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtFlightTrainInfo fetchByB_T_First(long businessTripPkId,
		String tripType, OrderByComparator orderByComparator)
		throws SystemException {
		List<BtFlightTrainInfo> list = findByB_T(businessTripPkId, tripType, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bt flight train info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt flight train info
	 * @throws com.business.trip.NoSuchBtFlightTrainInfoException if a matching bt flight train info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtFlightTrainInfo findByB_T_Last(long businessTripPkId,
		String tripType, OrderByComparator orderByComparator)
		throws NoSuchBtFlightTrainInfoException, SystemException {
		BtFlightTrainInfo btFlightTrainInfo = fetchByB_T_Last(businessTripPkId,
				tripType, orderByComparator);

		if (btFlightTrainInfo != null) {
			return btFlightTrainInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("businessTripPkId=");
		msg.append(businessTripPkId);

		msg.append(", tripType=");
		msg.append(tripType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtFlightTrainInfoException(msg.toString());
	}

	/**
	 * Returns the last bt flight train info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt flight train info, or <code>null</code> if a matching bt flight train info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtFlightTrainInfo fetchByB_T_Last(long businessTripPkId,
		String tripType, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByB_T(businessTripPkId, tripType);

		if (count == 0) {
			return null;
		}

		List<BtFlightTrainInfo> list = findByB_T(businessTripPkId, tripType,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bt flight train infos before and after the current bt flight train info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param btFlightTrainInfoId the primary key of the current bt flight train info
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bt flight train info
	 * @throws com.business.trip.NoSuchBtFlightTrainInfoException if a bt flight train info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtFlightTrainInfo[] findByB_T_PrevAndNext(long btFlightTrainInfoId,
		long businessTripPkId, String tripType,
		OrderByComparator orderByComparator)
		throws NoSuchBtFlightTrainInfoException, SystemException {
		BtFlightTrainInfo btFlightTrainInfo = findByPrimaryKey(btFlightTrainInfoId);

		Session session = null;

		try {
			session = openSession();

			BtFlightTrainInfo[] array = new BtFlightTrainInfoImpl[3];

			array[0] = getByB_T_PrevAndNext(session, btFlightTrainInfo,
					businessTripPkId, tripType, orderByComparator, true);

			array[1] = btFlightTrainInfo;

			array[2] = getByB_T_PrevAndNext(session, btFlightTrainInfo,
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

	protected BtFlightTrainInfo getByB_T_PrevAndNext(Session session,
		BtFlightTrainInfo btFlightTrainInfo, long businessTripPkId,
		String tripType, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BTFLIGHTTRAININFO_WHERE);

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
			query.append(BtFlightTrainInfoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(btFlightTrainInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BtFlightTrainInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bt flight train infos where businessTripPkId = &#63; and tripType = &#63; from the database.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByB_T(long businessTripPkId, String tripType)
		throws SystemException {
		for (BtFlightTrainInfo btFlightTrainInfo : findByB_T(businessTripPkId,
				tripType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(btFlightTrainInfo);
		}
	}

	/**
	 * Returns the number of bt flight train infos where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @return the number of matching bt flight train infos
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

			query.append(_SQL_COUNT_BTFLIGHTTRAININFO_WHERE);

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

	private static final String _FINDER_COLUMN_B_T_BUSINESSTRIPPKID_2 = "btFlightTrainInfo.businessTripPkId = ? AND ";
	private static final String _FINDER_COLUMN_B_T_TRIPTYPE_1 = "btFlightTrainInfo.tripType IS NULL";
	private static final String _FINDER_COLUMN_B_T_TRIPTYPE_2 = "btFlightTrainInfo.tripType = ?";
	private static final String _FINDER_COLUMN_B_T_TRIPTYPE_3 = "(btFlightTrainInfo.tripType IS NULL OR btFlightTrainInfo.tripType = '')";

	public BtFlightTrainInfoPersistenceImpl() {
		setModelClass(BtFlightTrainInfo.class);
	}

	/**
	 * Caches the bt flight train info in the entity cache if it is enabled.
	 *
	 * @param btFlightTrainInfo the bt flight train info
	 */
	@Override
	public void cacheResult(BtFlightTrainInfo btFlightTrainInfo) {
		EntityCacheUtil.putResult(BtFlightTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtFlightTrainInfoImpl.class, btFlightTrainInfo.getPrimaryKey(),
			btFlightTrainInfo);

		btFlightTrainInfo.resetOriginalValues();
	}

	/**
	 * Caches the bt flight train infos in the entity cache if it is enabled.
	 *
	 * @param btFlightTrainInfos the bt flight train infos
	 */
	@Override
	public void cacheResult(List<BtFlightTrainInfo> btFlightTrainInfos) {
		for (BtFlightTrainInfo btFlightTrainInfo : btFlightTrainInfos) {
			if (EntityCacheUtil.getResult(
						BtFlightTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
						BtFlightTrainInfoImpl.class,
						btFlightTrainInfo.getPrimaryKey()) == null) {
				cacheResult(btFlightTrainInfo);
			}
			else {
				btFlightTrainInfo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bt flight train infos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BtFlightTrainInfoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BtFlightTrainInfoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bt flight train info.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BtFlightTrainInfo btFlightTrainInfo) {
		EntityCacheUtil.removeResult(BtFlightTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtFlightTrainInfoImpl.class, btFlightTrainInfo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BtFlightTrainInfo> btFlightTrainInfos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BtFlightTrainInfo btFlightTrainInfo : btFlightTrainInfos) {
			EntityCacheUtil.removeResult(BtFlightTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
				BtFlightTrainInfoImpl.class, btFlightTrainInfo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bt flight train info with the primary key. Does not add the bt flight train info to the database.
	 *
	 * @param btFlightTrainInfoId the primary key for the new bt flight train info
	 * @return the new bt flight train info
	 */
	@Override
	public BtFlightTrainInfo create(long btFlightTrainInfoId) {
		BtFlightTrainInfo btFlightTrainInfo = new BtFlightTrainInfoImpl();

		btFlightTrainInfo.setNew(true);
		btFlightTrainInfo.setPrimaryKey(btFlightTrainInfoId);

		return btFlightTrainInfo;
	}

	/**
	 * Removes the bt flight train info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param btFlightTrainInfoId the primary key of the bt flight train info
	 * @return the bt flight train info that was removed
	 * @throws com.business.trip.NoSuchBtFlightTrainInfoException if a bt flight train info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtFlightTrainInfo remove(long btFlightTrainInfoId)
		throws NoSuchBtFlightTrainInfoException, SystemException {
		return remove((Serializable)btFlightTrainInfoId);
	}

	/**
	 * Removes the bt flight train info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bt flight train info
	 * @return the bt flight train info that was removed
	 * @throws com.business.trip.NoSuchBtFlightTrainInfoException if a bt flight train info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtFlightTrainInfo remove(Serializable primaryKey)
		throws NoSuchBtFlightTrainInfoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BtFlightTrainInfo btFlightTrainInfo = (BtFlightTrainInfo)session.get(BtFlightTrainInfoImpl.class,
					primaryKey);

			if (btFlightTrainInfo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBtFlightTrainInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(btFlightTrainInfo);
		}
		catch (NoSuchBtFlightTrainInfoException nsee) {
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
	protected BtFlightTrainInfo removeImpl(BtFlightTrainInfo btFlightTrainInfo)
		throws SystemException {
		btFlightTrainInfo = toUnwrappedModel(btFlightTrainInfo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(btFlightTrainInfo)) {
				btFlightTrainInfo = (BtFlightTrainInfo)session.get(BtFlightTrainInfoImpl.class,
						btFlightTrainInfo.getPrimaryKeyObj());
			}

			if (btFlightTrainInfo != null) {
				session.delete(btFlightTrainInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (btFlightTrainInfo != null) {
			clearCache(btFlightTrainInfo);
		}

		return btFlightTrainInfo;
	}

	@Override
	public BtFlightTrainInfo updateImpl(
		com.business.trip.model.BtFlightTrainInfo btFlightTrainInfo)
		throws SystemException {
		btFlightTrainInfo = toUnwrappedModel(btFlightTrainInfo);

		boolean isNew = btFlightTrainInfo.isNew();

		BtFlightTrainInfoModelImpl btFlightTrainInfoModelImpl = (BtFlightTrainInfoModelImpl)btFlightTrainInfo;

		Session session = null;

		try {
			session = openSession();

			if (btFlightTrainInfo.isNew()) {
				session.save(btFlightTrainInfo);

				btFlightTrainInfo.setNew(false);
			}
			else {
				session.merge(btFlightTrainInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BtFlightTrainInfoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((btFlightTrainInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						btFlightTrainInfoModelImpl.getOriginalTicketNo(),
						btFlightTrainInfoModelImpl.getOriginalTripType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T,
					args);

				args = new Object[] {
						btFlightTrainInfoModelImpl.getTicketNo(),
						btFlightTrainInfoModelImpl.getTripType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T,
					args);
			}

			if ((btFlightTrainInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						btFlightTrainInfoModelImpl.getOriginalBusinessTripPkId(),
						btFlightTrainInfoModelImpl.getOriginalTripType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_B_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_T,
					args);

				args = new Object[] {
						btFlightTrainInfoModelImpl.getBusinessTripPkId(),
						btFlightTrainInfoModelImpl.getTripType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_B_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_T,
					args);
			}
		}

		EntityCacheUtil.putResult(BtFlightTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtFlightTrainInfoImpl.class, btFlightTrainInfo.getPrimaryKey(),
			btFlightTrainInfo);

		return btFlightTrainInfo;
	}

	protected BtFlightTrainInfo toUnwrappedModel(
		BtFlightTrainInfo btFlightTrainInfo) {
		if (btFlightTrainInfo instanceof BtFlightTrainInfoImpl) {
			return btFlightTrainInfo;
		}

		BtFlightTrainInfoImpl btFlightTrainInfoImpl = new BtFlightTrainInfoImpl();

		btFlightTrainInfoImpl.setNew(btFlightTrainInfo.isNew());
		btFlightTrainInfoImpl.setPrimaryKey(btFlightTrainInfo.getPrimaryKey());

		btFlightTrainInfoImpl.setBtFlightTrainInfoId(btFlightTrainInfo.getBtFlightTrainInfoId());
		btFlightTrainInfoImpl.setBusinessTripPkId(btFlightTrainInfo.getBusinessTripPkId());
		btFlightTrainInfoImpl.setTicketNo(btFlightTrainInfo.getTicketNo());
		btFlightTrainInfoImpl.setType(btFlightTrainInfo.getType());
		btFlightTrainInfoImpl.setFromCity(btFlightTrainInfo.getFromCity());
		btFlightTrainInfoImpl.setToCity(btFlightTrainInfo.getToCity());
		btFlightTrainInfoImpl.setDepartureDate(btFlightTrainInfo.getDepartureDate());
		btFlightTrainInfoImpl.setDepartureFlight(btFlightTrainInfo.getDepartureFlight());
		btFlightTrainInfoImpl.setDepartureTime(btFlightTrainInfo.getDepartureTime());
		btFlightTrainInfoImpl.setClassInfo(btFlightTrainInfo.getClassInfo());
		btFlightTrainInfoImpl.setPrice(btFlightTrainInfo.getPrice());
		btFlightTrainInfoImpl.setCurrency(btFlightTrainInfo.getCurrency());
		btFlightTrainInfoImpl.setTripType(btFlightTrainInfo.getTripType());

		return btFlightTrainInfoImpl;
	}

	/**
	 * Returns the bt flight train info with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bt flight train info
	 * @return the bt flight train info
	 * @throws com.business.trip.NoSuchBtFlightTrainInfoException if a bt flight train info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtFlightTrainInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBtFlightTrainInfoException, SystemException {
		BtFlightTrainInfo btFlightTrainInfo = fetchByPrimaryKey(primaryKey);

		if (btFlightTrainInfo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBtFlightTrainInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return btFlightTrainInfo;
	}

	/**
	 * Returns the bt flight train info with the primary key or throws a {@link com.business.trip.NoSuchBtFlightTrainInfoException} if it could not be found.
	 *
	 * @param btFlightTrainInfoId the primary key of the bt flight train info
	 * @return the bt flight train info
	 * @throws com.business.trip.NoSuchBtFlightTrainInfoException if a bt flight train info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtFlightTrainInfo findByPrimaryKey(long btFlightTrainInfoId)
		throws NoSuchBtFlightTrainInfoException, SystemException {
		return findByPrimaryKey((Serializable)btFlightTrainInfoId);
	}

	/**
	 * Returns the bt flight train info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bt flight train info
	 * @return the bt flight train info, or <code>null</code> if a bt flight train info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtFlightTrainInfo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BtFlightTrainInfo btFlightTrainInfo = (BtFlightTrainInfo)EntityCacheUtil.getResult(BtFlightTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
				BtFlightTrainInfoImpl.class, primaryKey);

		if (btFlightTrainInfo == _nullBtFlightTrainInfo) {
			return null;
		}

		if (btFlightTrainInfo == null) {
			Session session = null;

			try {
				session = openSession();

				btFlightTrainInfo = (BtFlightTrainInfo)session.get(BtFlightTrainInfoImpl.class,
						primaryKey);

				if (btFlightTrainInfo != null) {
					cacheResult(btFlightTrainInfo);
				}
				else {
					EntityCacheUtil.putResult(BtFlightTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
						BtFlightTrainInfoImpl.class, primaryKey,
						_nullBtFlightTrainInfo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BtFlightTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
					BtFlightTrainInfoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return btFlightTrainInfo;
	}

	/**
	 * Returns the bt flight train info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param btFlightTrainInfoId the primary key of the bt flight train info
	 * @return the bt flight train info, or <code>null</code> if a bt flight train info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtFlightTrainInfo fetchByPrimaryKey(long btFlightTrainInfoId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)btFlightTrainInfoId);
	}

	/**
	 * Returns all the bt flight train infos.
	 *
	 * @return the bt flight train infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtFlightTrainInfo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bt flight train infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtFlightTrainInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bt flight train infos
	 * @param end the upper bound of the range of bt flight train infos (not inclusive)
	 * @return the range of bt flight train infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtFlightTrainInfo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt flight train infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtFlightTrainInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bt flight train infos
	 * @param end the upper bound of the range of bt flight train infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bt flight train infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtFlightTrainInfo> findAll(int start, int end,
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

		List<BtFlightTrainInfo> list = (List<BtFlightTrainInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BTFLIGHTTRAININFO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BTFLIGHTTRAININFO;

				if (pagination) {
					sql = sql.concat(BtFlightTrainInfoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BtFlightTrainInfo>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtFlightTrainInfo>(list);
				}
				else {
					list = (List<BtFlightTrainInfo>)QueryUtil.list(q,
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
	 * Removes all the bt flight train infos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BtFlightTrainInfo btFlightTrainInfo : findAll()) {
			remove(btFlightTrainInfo);
		}
	}

	/**
	 * Returns the number of bt flight train infos.
	 *
	 * @return the number of bt flight train infos
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

				Query q = session.createQuery(_SQL_COUNT_BTFLIGHTTRAININFO);

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
	 * Initializes the bt flight train info persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.business.trip.model.BtFlightTrainInfo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BtFlightTrainInfo>> listenersList = new ArrayList<ModelListener<BtFlightTrainInfo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BtFlightTrainInfo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BtFlightTrainInfoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BTFLIGHTTRAININFO = "SELECT btFlightTrainInfo FROM BtFlightTrainInfo btFlightTrainInfo";
	private static final String _SQL_SELECT_BTFLIGHTTRAININFO_WHERE = "SELECT btFlightTrainInfo FROM BtFlightTrainInfo btFlightTrainInfo WHERE ";
	private static final String _SQL_COUNT_BTFLIGHTTRAININFO = "SELECT COUNT(btFlightTrainInfo) FROM BtFlightTrainInfo btFlightTrainInfo";
	private static final String _SQL_COUNT_BTFLIGHTTRAININFO_WHERE = "SELECT COUNT(btFlightTrainInfo) FROM BtFlightTrainInfo btFlightTrainInfo WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "btFlightTrainInfo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BtFlightTrainInfo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BtFlightTrainInfo exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BtFlightTrainInfoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type", "currency"
			});
	private static BtFlightTrainInfo _nullBtFlightTrainInfo = new BtFlightTrainInfoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BtFlightTrainInfo> toCacheModel() {
				return _nullBtFlightTrainInfoCacheModel;
			}
		};

	private static CacheModel<BtFlightTrainInfo> _nullBtFlightTrainInfoCacheModel =
		new CacheModel<BtFlightTrainInfo>() {
			@Override
			public BtFlightTrainInfo toEntityModel() {
				return _nullBtFlightTrainInfo;
			}
		};
}