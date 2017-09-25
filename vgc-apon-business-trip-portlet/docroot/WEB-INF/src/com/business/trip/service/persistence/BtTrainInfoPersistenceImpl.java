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

import com.business.trip.NoSuchBtTrainInfoException;
import com.business.trip.model.BtTrainInfo;
import com.business.trip.model.impl.BtTrainInfoImpl;
import com.business.trip.model.impl.BtTrainInfoModelImpl;
import com.business.trip.service.persistence.BtTrainInfoPersistence;

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
 * The persistence implementation for the bt train info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtTrainInfoPersistence
 * @see BtTrainInfoUtil
 * @generated
 */
public class BtTrainInfoPersistenceImpl extends BasePersistenceImpl<BtTrainInfo>
	implements BtTrainInfoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BtTrainInfoUtil} to access the bt train info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BtTrainInfoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BtTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtTrainInfoModelImpl.FINDER_CACHE_ENABLED, BtTrainInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BtTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtTrainInfoModelImpl.FINDER_CACHE_ENABLED, BtTrainInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BtTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtTrainInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_T_T = new FinderPath(BtTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtTrainInfoModelImpl.FINDER_CACHE_ENABLED, BtTrainInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByT_T",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T = new FinderPath(BtTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtTrainInfoModelImpl.FINDER_CACHE_ENABLED, BtTrainInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByT_T",
			new String[] { String.class.getName(), String.class.getName() },
			BtTrainInfoModelImpl.TICKETNO_COLUMN_BITMASK |
			BtTrainInfoModelImpl.TRIPTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_T_T = new FinderPath(BtTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtTrainInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByT_T",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the bt train infos where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @return the matching bt train infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTrainInfo> findByT_T(String ticketNo, String tripType)
		throws SystemException {
		return findByT_T(ticketNo, tripType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bt train infos where ticketNo = &#63; and tripType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTrainInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param start the lower bound of the range of bt train infos
	 * @param end the upper bound of the range of bt train infos (not inclusive)
	 * @return the range of matching bt train infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTrainInfo> findByT_T(String ticketNo, String tripType,
		int start, int end) throws SystemException {
		return findByT_T(ticketNo, tripType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt train infos where ticketNo = &#63; and tripType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTrainInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param start the lower bound of the range of bt train infos
	 * @param end the upper bound of the range of bt train infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bt train infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTrainInfo> findByT_T(String ticketNo, String tripType,
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

		List<BtTrainInfo> list = (List<BtTrainInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BtTrainInfo btTrainInfo : list) {
				if (!Validator.equals(ticketNo, btTrainInfo.getTicketNo()) ||
						!Validator.equals(tripType, btTrainInfo.getTripType())) {
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

			query.append(_SQL_SELECT_BTTRAININFO_WHERE);

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
				query.append(BtTrainInfoModelImpl.ORDER_BY_JPQL);
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
					list = (List<BtTrainInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtTrainInfo>(list);
				}
				else {
					list = (List<BtTrainInfo>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first bt train info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt train info
	 * @throws com.business.trip.NoSuchBtTrainInfoException if a matching bt train info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTrainInfo findByT_T_First(String ticketNo, String tripType,
		OrderByComparator orderByComparator)
		throws NoSuchBtTrainInfoException, SystemException {
		BtTrainInfo btTrainInfo = fetchByT_T_First(ticketNo, tripType,
				orderByComparator);

		if (btTrainInfo != null) {
			return btTrainInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketNo=");
		msg.append(ticketNo);

		msg.append(", tripType=");
		msg.append(tripType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtTrainInfoException(msg.toString());
	}

	/**
	 * Returns the first bt train info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt train info, or <code>null</code> if a matching bt train info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTrainInfo fetchByT_T_First(String ticketNo, String tripType,
		OrderByComparator orderByComparator) throws SystemException {
		List<BtTrainInfo> list = findByT_T(ticketNo, tripType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bt train info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt train info
	 * @throws com.business.trip.NoSuchBtTrainInfoException if a matching bt train info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTrainInfo findByT_T_Last(String ticketNo, String tripType,
		OrderByComparator orderByComparator)
		throws NoSuchBtTrainInfoException, SystemException {
		BtTrainInfo btTrainInfo = fetchByT_T_Last(ticketNo, tripType,
				orderByComparator);

		if (btTrainInfo != null) {
			return btTrainInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketNo=");
		msg.append(ticketNo);

		msg.append(", tripType=");
		msg.append(tripType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtTrainInfoException(msg.toString());
	}

	/**
	 * Returns the last bt train info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt train info, or <code>null</code> if a matching bt train info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTrainInfo fetchByT_T_Last(String ticketNo, String tripType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByT_T(ticketNo, tripType);

		if (count == 0) {
			return null;
		}

		List<BtTrainInfo> list = findByT_T(ticketNo, tripType, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bt train infos before and after the current bt train info in the ordered set where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param btTrainInfoId the primary key of the current bt train info
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bt train info
	 * @throws com.business.trip.NoSuchBtTrainInfoException if a bt train info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTrainInfo[] findByT_T_PrevAndNext(long btTrainInfoId,
		String ticketNo, String tripType, OrderByComparator orderByComparator)
		throws NoSuchBtTrainInfoException, SystemException {
		BtTrainInfo btTrainInfo = findByPrimaryKey(btTrainInfoId);

		Session session = null;

		try {
			session = openSession();

			BtTrainInfo[] array = new BtTrainInfoImpl[3];

			array[0] = getByT_T_PrevAndNext(session, btTrainInfo, ticketNo,
					tripType, orderByComparator, true);

			array[1] = btTrainInfo;

			array[2] = getByT_T_PrevAndNext(session, btTrainInfo, ticketNo,
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

	protected BtTrainInfo getByT_T_PrevAndNext(Session session,
		BtTrainInfo btTrainInfo, String ticketNo, String tripType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BTTRAININFO_WHERE);

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
			query.append(BtTrainInfoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(btTrainInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BtTrainInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bt train infos where ticketNo = &#63; and tripType = &#63; from the database.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByT_T(String ticketNo, String tripType)
		throws SystemException {
		for (BtTrainInfo btTrainInfo : findByT_T(ticketNo, tripType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(btTrainInfo);
		}
	}

	/**
	 * Returns the number of bt train infos where ticketNo = &#63; and tripType = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param tripType the trip type
	 * @return the number of matching bt train infos
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

			query.append(_SQL_COUNT_BTTRAININFO_WHERE);

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

	private static final String _FINDER_COLUMN_T_T_TICKETNO_1 = "btTrainInfo.ticketNo IS NULL AND ";
	private static final String _FINDER_COLUMN_T_T_TICKETNO_2 = "btTrainInfo.ticketNo = ? AND ";
	private static final String _FINDER_COLUMN_T_T_TICKETNO_3 = "(btTrainInfo.ticketNo IS NULL OR btTrainInfo.ticketNo = '') AND ";
	private static final String _FINDER_COLUMN_T_T_TRIPTYPE_1 = "btTrainInfo.tripType IS NULL";
	private static final String _FINDER_COLUMN_T_T_TRIPTYPE_2 = "btTrainInfo.tripType = ?";
	private static final String _FINDER_COLUMN_T_T_TRIPTYPE_3 = "(btTrainInfo.tripType IS NULL OR btTrainInfo.tripType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_B_T = new FinderPath(BtTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtTrainInfoModelImpl.FINDER_CACHE_ENABLED, BtTrainInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByB_T",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_T = new FinderPath(BtTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtTrainInfoModelImpl.FINDER_CACHE_ENABLED, BtTrainInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByB_T",
			new String[] { Long.class.getName(), String.class.getName() },
			BtTrainInfoModelImpl.BUSINESSTRIPPKID_COLUMN_BITMASK |
			BtTrainInfoModelImpl.TRIPTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_B_T = new FinderPath(BtTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtTrainInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_T",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the bt train infos where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @return the matching bt train infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTrainInfo> findByB_T(long businessTripPkId, String tripType)
		throws SystemException {
		return findByB_T(businessTripPkId, tripType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bt train infos where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTrainInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param start the lower bound of the range of bt train infos
	 * @param end the upper bound of the range of bt train infos (not inclusive)
	 * @return the range of matching bt train infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTrainInfo> findByB_T(long businessTripPkId, String tripType,
		int start, int end) throws SystemException {
		return findByB_T(businessTripPkId, tripType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt train infos where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTrainInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param start the lower bound of the range of bt train infos
	 * @param end the upper bound of the range of bt train infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bt train infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTrainInfo> findByB_T(long businessTripPkId, String tripType,
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

		List<BtTrainInfo> list = (List<BtTrainInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BtTrainInfo btTrainInfo : list) {
				if ((businessTripPkId != btTrainInfo.getBusinessTripPkId()) ||
						!Validator.equals(tripType, btTrainInfo.getTripType())) {
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

			query.append(_SQL_SELECT_BTTRAININFO_WHERE);

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
				query.append(BtTrainInfoModelImpl.ORDER_BY_JPQL);
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
					list = (List<BtTrainInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtTrainInfo>(list);
				}
				else {
					list = (List<BtTrainInfo>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first bt train info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt train info
	 * @throws com.business.trip.NoSuchBtTrainInfoException if a matching bt train info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTrainInfo findByB_T_First(long businessTripPkId, String tripType,
		OrderByComparator orderByComparator)
		throws NoSuchBtTrainInfoException, SystemException {
		BtTrainInfo btTrainInfo = fetchByB_T_First(businessTripPkId, tripType,
				orderByComparator);

		if (btTrainInfo != null) {
			return btTrainInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("businessTripPkId=");
		msg.append(businessTripPkId);

		msg.append(", tripType=");
		msg.append(tripType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtTrainInfoException(msg.toString());
	}

	/**
	 * Returns the first bt train info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt train info, or <code>null</code> if a matching bt train info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTrainInfo fetchByB_T_First(long businessTripPkId, String tripType,
		OrderByComparator orderByComparator) throws SystemException {
		List<BtTrainInfo> list = findByB_T(businessTripPkId, tripType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bt train info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt train info
	 * @throws com.business.trip.NoSuchBtTrainInfoException if a matching bt train info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTrainInfo findByB_T_Last(long businessTripPkId, String tripType,
		OrderByComparator orderByComparator)
		throws NoSuchBtTrainInfoException, SystemException {
		BtTrainInfo btTrainInfo = fetchByB_T_Last(businessTripPkId, tripType,
				orderByComparator);

		if (btTrainInfo != null) {
			return btTrainInfo;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("businessTripPkId=");
		msg.append(businessTripPkId);

		msg.append(", tripType=");
		msg.append(tripType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtTrainInfoException(msg.toString());
	}

	/**
	 * Returns the last bt train info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt train info, or <code>null</code> if a matching bt train info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTrainInfo fetchByB_T_Last(long businessTripPkId, String tripType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByB_T(businessTripPkId, tripType);

		if (count == 0) {
			return null;
		}

		List<BtTrainInfo> list = findByB_T(businessTripPkId, tripType,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bt train infos before and after the current bt train info in the ordered set where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param btTrainInfoId the primary key of the current bt train info
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bt train info
	 * @throws com.business.trip.NoSuchBtTrainInfoException if a bt train info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTrainInfo[] findByB_T_PrevAndNext(long btTrainInfoId,
		long businessTripPkId, String tripType,
		OrderByComparator orderByComparator)
		throws NoSuchBtTrainInfoException, SystemException {
		BtTrainInfo btTrainInfo = findByPrimaryKey(btTrainInfoId);

		Session session = null;

		try {
			session = openSession();

			BtTrainInfo[] array = new BtTrainInfoImpl[3];

			array[0] = getByB_T_PrevAndNext(session, btTrainInfo,
					businessTripPkId, tripType, orderByComparator, true);

			array[1] = btTrainInfo;

			array[2] = getByB_T_PrevAndNext(session, btTrainInfo,
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

	protected BtTrainInfo getByB_T_PrevAndNext(Session session,
		BtTrainInfo btTrainInfo, long businessTripPkId, String tripType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BTTRAININFO_WHERE);

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
			query.append(BtTrainInfoModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(btTrainInfo);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BtTrainInfo> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bt train infos where businessTripPkId = &#63; and tripType = &#63; from the database.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByB_T(long businessTripPkId, String tripType)
		throws SystemException {
		for (BtTrainInfo btTrainInfo : findByB_T(businessTripPkId, tripType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(btTrainInfo);
		}
	}

	/**
	 * Returns the number of bt train infos where businessTripPkId = &#63; and tripType = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param tripType the trip type
	 * @return the number of matching bt train infos
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

			query.append(_SQL_COUNT_BTTRAININFO_WHERE);

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

	private static final String _FINDER_COLUMN_B_T_BUSINESSTRIPPKID_2 = "btTrainInfo.businessTripPkId = ? AND ";
	private static final String _FINDER_COLUMN_B_T_TRIPTYPE_1 = "btTrainInfo.tripType IS NULL";
	private static final String _FINDER_COLUMN_B_T_TRIPTYPE_2 = "btTrainInfo.tripType = ?";
	private static final String _FINDER_COLUMN_B_T_TRIPTYPE_3 = "(btTrainInfo.tripType IS NULL OR btTrainInfo.tripType = '')";

	public BtTrainInfoPersistenceImpl() {
		setModelClass(BtTrainInfo.class);
	}

	/**
	 * Caches the bt train info in the entity cache if it is enabled.
	 *
	 * @param btTrainInfo the bt train info
	 */
	@Override
	public void cacheResult(BtTrainInfo btTrainInfo) {
		EntityCacheUtil.putResult(BtTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtTrainInfoImpl.class, btTrainInfo.getPrimaryKey(), btTrainInfo);

		btTrainInfo.resetOriginalValues();
	}

	/**
	 * Caches the bt train infos in the entity cache if it is enabled.
	 *
	 * @param btTrainInfos the bt train infos
	 */
	@Override
	public void cacheResult(List<BtTrainInfo> btTrainInfos) {
		for (BtTrainInfo btTrainInfo : btTrainInfos) {
			if (EntityCacheUtil.getResult(
						BtTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
						BtTrainInfoImpl.class, btTrainInfo.getPrimaryKey()) == null) {
				cacheResult(btTrainInfo);
			}
			else {
				btTrainInfo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bt train infos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BtTrainInfoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BtTrainInfoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bt train info.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BtTrainInfo btTrainInfo) {
		EntityCacheUtil.removeResult(BtTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtTrainInfoImpl.class, btTrainInfo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BtTrainInfo> btTrainInfos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BtTrainInfo btTrainInfo : btTrainInfos) {
			EntityCacheUtil.removeResult(BtTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
				BtTrainInfoImpl.class, btTrainInfo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bt train info with the primary key. Does not add the bt train info to the database.
	 *
	 * @param btTrainInfoId the primary key for the new bt train info
	 * @return the new bt train info
	 */
	@Override
	public BtTrainInfo create(long btTrainInfoId) {
		BtTrainInfo btTrainInfo = new BtTrainInfoImpl();

		btTrainInfo.setNew(true);
		btTrainInfo.setPrimaryKey(btTrainInfoId);

		return btTrainInfo;
	}

	/**
	 * Removes the bt train info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param btTrainInfoId the primary key of the bt train info
	 * @return the bt train info that was removed
	 * @throws com.business.trip.NoSuchBtTrainInfoException if a bt train info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTrainInfo remove(long btTrainInfoId)
		throws NoSuchBtTrainInfoException, SystemException {
		return remove((Serializable)btTrainInfoId);
	}

	/**
	 * Removes the bt train info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bt train info
	 * @return the bt train info that was removed
	 * @throws com.business.trip.NoSuchBtTrainInfoException if a bt train info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTrainInfo remove(Serializable primaryKey)
		throws NoSuchBtTrainInfoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BtTrainInfo btTrainInfo = (BtTrainInfo)session.get(BtTrainInfoImpl.class,
					primaryKey);

			if (btTrainInfo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBtTrainInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(btTrainInfo);
		}
		catch (NoSuchBtTrainInfoException nsee) {
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
	protected BtTrainInfo removeImpl(BtTrainInfo btTrainInfo)
		throws SystemException {
		btTrainInfo = toUnwrappedModel(btTrainInfo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(btTrainInfo)) {
				btTrainInfo = (BtTrainInfo)session.get(BtTrainInfoImpl.class,
						btTrainInfo.getPrimaryKeyObj());
			}

			if (btTrainInfo != null) {
				session.delete(btTrainInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (btTrainInfo != null) {
			clearCache(btTrainInfo);
		}

		return btTrainInfo;
	}

	@Override
	public BtTrainInfo updateImpl(
		com.business.trip.model.BtTrainInfo btTrainInfo)
		throws SystemException {
		btTrainInfo = toUnwrappedModel(btTrainInfo);

		boolean isNew = btTrainInfo.isNew();

		BtTrainInfoModelImpl btTrainInfoModelImpl = (BtTrainInfoModelImpl)btTrainInfo;

		Session session = null;

		try {
			session = openSession();

			if (btTrainInfo.isNew()) {
				session.save(btTrainInfo);

				btTrainInfo.setNew(false);
			}
			else {
				session.merge(btTrainInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BtTrainInfoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((btTrainInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						btTrainInfoModelImpl.getOriginalTicketNo(),
						btTrainInfoModelImpl.getOriginalTripType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T,
					args);

				args = new Object[] {
						btTrainInfoModelImpl.getTicketNo(),
						btTrainInfoModelImpl.getTripType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_T_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_T_T,
					args);
			}

			if ((btTrainInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_T.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						btTrainInfoModelImpl.getOriginalBusinessTripPkId(),
						btTrainInfoModelImpl.getOriginalTripType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_B_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_T,
					args);

				args = new Object[] {
						btTrainInfoModelImpl.getBusinessTripPkId(),
						btTrainInfoModelImpl.getTripType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_B_T, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_T,
					args);
			}
		}

		EntityCacheUtil.putResult(BtTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtTrainInfoImpl.class, btTrainInfo.getPrimaryKey(), btTrainInfo);

		return btTrainInfo;
	}

	protected BtTrainInfo toUnwrappedModel(BtTrainInfo btTrainInfo) {
		if (btTrainInfo instanceof BtTrainInfoImpl) {
			return btTrainInfo;
		}

		BtTrainInfoImpl btTrainInfoImpl = new BtTrainInfoImpl();

		btTrainInfoImpl.setNew(btTrainInfo.isNew());
		btTrainInfoImpl.setPrimaryKey(btTrainInfo.getPrimaryKey());

		btTrainInfoImpl.setBtTrainInfoId(btTrainInfo.getBtTrainInfoId());
		btTrainInfoImpl.setBusinessTripPkId(btTrainInfo.getBusinessTripPkId());
		btTrainInfoImpl.setTicketNo(btTrainInfo.getTicketNo());
		btTrainInfoImpl.setFromCity(btTrainInfo.getFromCity());
		btTrainInfoImpl.setToCity(btTrainInfo.getToCity());
		btTrainInfoImpl.setDepartureDate(btTrainInfo.getDepartureDate());
		btTrainInfoImpl.setDepartureTrain(btTrainInfo.getDepartureTrain());
		btTrainInfoImpl.setClassInfo(btTrainInfo.getClassInfo());
		btTrainInfoImpl.setPrice(btTrainInfo.getPrice());
		btTrainInfoImpl.setCurrency(btTrainInfo.getCurrency());
		btTrainInfoImpl.setTripType(btTrainInfo.getTripType());

		return btTrainInfoImpl;
	}

	/**
	 * Returns the bt train info with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bt train info
	 * @return the bt train info
	 * @throws com.business.trip.NoSuchBtTrainInfoException if a bt train info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTrainInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBtTrainInfoException, SystemException {
		BtTrainInfo btTrainInfo = fetchByPrimaryKey(primaryKey);

		if (btTrainInfo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBtTrainInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return btTrainInfo;
	}

	/**
	 * Returns the bt train info with the primary key or throws a {@link com.business.trip.NoSuchBtTrainInfoException} if it could not be found.
	 *
	 * @param btTrainInfoId the primary key of the bt train info
	 * @return the bt train info
	 * @throws com.business.trip.NoSuchBtTrainInfoException if a bt train info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTrainInfo findByPrimaryKey(long btTrainInfoId)
		throws NoSuchBtTrainInfoException, SystemException {
		return findByPrimaryKey((Serializable)btTrainInfoId);
	}

	/**
	 * Returns the bt train info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bt train info
	 * @return the bt train info, or <code>null</code> if a bt train info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTrainInfo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BtTrainInfo btTrainInfo = (BtTrainInfo)EntityCacheUtil.getResult(BtTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
				BtTrainInfoImpl.class, primaryKey);

		if (btTrainInfo == _nullBtTrainInfo) {
			return null;
		}

		if (btTrainInfo == null) {
			Session session = null;

			try {
				session = openSession();

				btTrainInfo = (BtTrainInfo)session.get(BtTrainInfoImpl.class,
						primaryKey);

				if (btTrainInfo != null) {
					cacheResult(btTrainInfo);
				}
				else {
					EntityCacheUtil.putResult(BtTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
						BtTrainInfoImpl.class, primaryKey, _nullBtTrainInfo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BtTrainInfoModelImpl.ENTITY_CACHE_ENABLED,
					BtTrainInfoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return btTrainInfo;
	}

	/**
	 * Returns the bt train info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param btTrainInfoId the primary key of the bt train info
	 * @return the bt train info, or <code>null</code> if a bt train info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtTrainInfo fetchByPrimaryKey(long btTrainInfoId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)btTrainInfoId);
	}

	/**
	 * Returns all the bt train infos.
	 *
	 * @return the bt train infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTrainInfo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bt train infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTrainInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bt train infos
	 * @param end the upper bound of the range of bt train infos (not inclusive)
	 * @return the range of bt train infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTrainInfo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt train infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtTrainInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bt train infos
	 * @param end the upper bound of the range of bt train infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bt train infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtTrainInfo> findAll(int start, int end,
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

		List<BtTrainInfo> list = (List<BtTrainInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BTTRAININFO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BTTRAININFO;

				if (pagination) {
					sql = sql.concat(BtTrainInfoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BtTrainInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtTrainInfo>(list);
				}
				else {
					list = (List<BtTrainInfo>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the bt train infos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BtTrainInfo btTrainInfo : findAll()) {
			remove(btTrainInfo);
		}
	}

	/**
	 * Returns the number of bt train infos.
	 *
	 * @return the number of bt train infos
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

				Query q = session.createQuery(_SQL_COUNT_BTTRAININFO);

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
	 * Initializes the bt train info persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.business.trip.model.BtTrainInfo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BtTrainInfo>> listenersList = new ArrayList<ModelListener<BtTrainInfo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BtTrainInfo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BtTrainInfoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BTTRAININFO = "SELECT btTrainInfo FROM BtTrainInfo btTrainInfo";
	private static final String _SQL_SELECT_BTTRAININFO_WHERE = "SELECT btTrainInfo FROM BtTrainInfo btTrainInfo WHERE ";
	private static final String _SQL_COUNT_BTTRAININFO = "SELECT COUNT(btTrainInfo) FROM BtTrainInfo btTrainInfo";
	private static final String _SQL_COUNT_BTTRAININFO_WHERE = "SELECT COUNT(btTrainInfo) FROM BtTrainInfo btTrainInfo WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "btTrainInfo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BtTrainInfo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BtTrainInfo exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BtTrainInfoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"currency"
			});
	private static BtTrainInfo _nullBtTrainInfo = new BtTrainInfoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BtTrainInfo> toCacheModel() {
				return _nullBtTrainInfoCacheModel;
			}
		};

	private static CacheModel<BtTrainInfo> _nullBtTrainInfoCacheModel = new CacheModel<BtTrainInfo>() {
			@Override
			public BtTrainInfo toEntityModel() {
				return _nullBtTrainInfo;
			}
		};
}