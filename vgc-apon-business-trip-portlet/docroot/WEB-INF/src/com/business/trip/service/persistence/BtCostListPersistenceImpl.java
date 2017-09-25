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

import com.business.trip.NoSuchBtCostListException;
import com.business.trip.model.BtCostList;
import com.business.trip.model.impl.BtCostListImpl;
import com.business.trip.model.impl.BtCostListModelImpl;
import com.business.trip.service.persistence.BtCostListPersistence;

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
 * The persistence implementation for the bt cost list service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtCostListPersistence
 * @see BtCostListUtil
 * @generated
 */
public class BtCostListPersistenceImpl extends BasePersistenceImpl<BtCostList>
	implements BtCostListPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BtCostListUtil} to access the bt cost list persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BtCostListImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BtCostListModelImpl.ENTITY_CACHE_ENABLED,
			BtCostListModelImpl.FINDER_CACHE_ENABLED, BtCostListImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BtCostListModelImpl.ENTITY_CACHE_ENABLED,
			BtCostListModelImpl.FINDER_CACHE_ENABLED, BtCostListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BtCostListModelImpl.ENTITY_CACHE_ENABLED,
			BtCostListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TICKETNO = new FinderPath(BtCostListModelImpl.ENTITY_CACHE_ENABLED,
			BtCostListModelImpl.FINDER_CACHE_ENABLED, BtCostListImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTicketNo",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TICKETNO =
		new FinderPath(BtCostListModelImpl.ENTITY_CACHE_ENABLED,
			BtCostListModelImpl.FINDER_CACHE_ENABLED, BtCostListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTicketNo",
			new String[] { String.class.getName() },
			BtCostListModelImpl.TICKETNO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TICKETNO = new FinderPath(BtCostListModelImpl.ENTITY_CACHE_ENABLED,
			BtCostListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTicketNo",
			new String[] { String.class.getName() });

	/**
	 * Returns all the bt cost lists where ticketNo = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @return the matching bt cost lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtCostList> findByTicketNo(String ticketNo)
		throws SystemException {
		return findByTicketNo(ticketNo, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the bt cost lists where ticketNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCostListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketNo the ticket no
	 * @param start the lower bound of the range of bt cost lists
	 * @param end the upper bound of the range of bt cost lists (not inclusive)
	 * @return the range of matching bt cost lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtCostList> findByTicketNo(String ticketNo, int start, int end)
		throws SystemException {
		return findByTicketNo(ticketNo, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt cost lists where ticketNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCostListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketNo the ticket no
	 * @param start the lower bound of the range of bt cost lists
	 * @param end the upper bound of the range of bt cost lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bt cost lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtCostList> findByTicketNo(String ticketNo, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<BtCostList> list = (List<BtCostList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BtCostList btCostList : list) {
				if (!Validator.equals(ticketNo, btCostList.getTicketNo())) {
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

			query.append(_SQL_SELECT_BTCOSTLIST_WHERE);

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
				query.append(BtCostListModelImpl.ORDER_BY_JPQL);
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
					list = (List<BtCostList>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtCostList>(list);
				}
				else {
					list = (List<BtCostList>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first bt cost list in the ordered set where ticketNo = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt cost list
	 * @throws com.business.trip.NoSuchBtCostListException if a matching bt cost list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCostList findByTicketNo_First(String ticketNo,
		OrderByComparator orderByComparator)
		throws NoSuchBtCostListException, SystemException {
		BtCostList btCostList = fetchByTicketNo_First(ticketNo,
				orderByComparator);

		if (btCostList != null) {
			return btCostList;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketNo=");
		msg.append(ticketNo);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtCostListException(msg.toString());
	}

	/**
	 * Returns the first bt cost list in the ordered set where ticketNo = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt cost list, or <code>null</code> if a matching bt cost list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCostList fetchByTicketNo_First(String ticketNo,
		OrderByComparator orderByComparator) throws SystemException {
		List<BtCostList> list = findByTicketNo(ticketNo, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bt cost list in the ordered set where ticketNo = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt cost list
	 * @throws com.business.trip.NoSuchBtCostListException if a matching bt cost list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCostList findByTicketNo_Last(String ticketNo,
		OrderByComparator orderByComparator)
		throws NoSuchBtCostListException, SystemException {
		BtCostList btCostList = fetchByTicketNo_Last(ticketNo, orderByComparator);

		if (btCostList != null) {
			return btCostList;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketNo=");
		msg.append(ticketNo);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtCostListException(msg.toString());
	}

	/**
	 * Returns the last bt cost list in the ordered set where ticketNo = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt cost list, or <code>null</code> if a matching bt cost list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCostList fetchByTicketNo_Last(String ticketNo,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTicketNo(ticketNo);

		if (count == 0) {
			return null;
		}

		List<BtCostList> list = findByTicketNo(ticketNo, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bt cost lists before and after the current bt cost list in the ordered set where ticketNo = &#63;.
	 *
	 * @param btCostListId the primary key of the current bt cost list
	 * @param ticketNo the ticket no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bt cost list
	 * @throws com.business.trip.NoSuchBtCostListException if a bt cost list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCostList[] findByTicketNo_PrevAndNext(long btCostListId,
		String ticketNo, OrderByComparator orderByComparator)
		throws NoSuchBtCostListException, SystemException {
		BtCostList btCostList = findByPrimaryKey(btCostListId);

		Session session = null;

		try {
			session = openSession();

			BtCostList[] array = new BtCostListImpl[3];

			array[0] = getByTicketNo_PrevAndNext(session, btCostList, ticketNo,
					orderByComparator, true);

			array[1] = btCostList;

			array[2] = getByTicketNo_PrevAndNext(session, btCostList, ticketNo,
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

	protected BtCostList getByTicketNo_PrevAndNext(Session session,
		BtCostList btCostList, String ticketNo,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BTCOSTLIST_WHERE);

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
			query.append(BtCostListModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(btCostList);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BtCostList> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bt cost lists where ticketNo = &#63; from the database.
	 *
	 * @param ticketNo the ticket no
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTicketNo(String ticketNo) throws SystemException {
		for (BtCostList btCostList : findByTicketNo(ticketNo,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(btCostList);
		}
	}

	/**
	 * Returns the number of bt cost lists where ticketNo = &#63;.
	 *
	 * @param ticketNo the ticket no
	 * @return the number of matching bt cost lists
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

			query.append(_SQL_COUNT_BTCOSTLIST_WHERE);

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

	private static final String _FINDER_COLUMN_TICKETNO_TICKETNO_1 = "btCostList.ticketNo IS NULL";
	private static final String _FINDER_COLUMN_TICKETNO_TICKETNO_2 = "btCostList.ticketNo = ?";
	private static final String _FINDER_COLUMN_TICKETNO_TICKETNO_3 = "(btCostList.ticketNo IS NULL OR btCostList.ticketNo = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BUSINESSTRIPPKID =
		new FinderPath(BtCostListModelImpl.ENTITY_CACHE_ENABLED,
			BtCostListModelImpl.FINDER_CACHE_ENABLED, BtCostListImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBusinessTripPkId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSINESSTRIPPKID =
		new FinderPath(BtCostListModelImpl.ENTITY_CACHE_ENABLED,
			BtCostListModelImpl.FINDER_CACHE_ENABLED, BtCostListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByBusinessTripPkId", new String[] { Long.class.getName() },
			BtCostListModelImpl.BUSINESSTRIPPKID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BUSINESSTRIPPKID = new FinderPath(BtCostListModelImpl.ENTITY_CACHE_ENABLED,
			BtCostListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBusinessTripPkId", new String[] { Long.class.getName() });

	/**
	 * Returns all the bt cost lists where businessTripPkId = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @return the matching bt cost lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtCostList> findByBusinessTripPkId(long businessTripPkId)
		throws SystemException {
		return findByBusinessTripPkId(businessTripPkId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bt cost lists where businessTripPkId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCostListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param start the lower bound of the range of bt cost lists
	 * @param end the upper bound of the range of bt cost lists (not inclusive)
	 * @return the range of matching bt cost lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtCostList> findByBusinessTripPkId(long businessTripPkId,
		int start, int end) throws SystemException {
		return findByBusinessTripPkId(businessTripPkId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt cost lists where businessTripPkId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCostListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param start the lower bound of the range of bt cost lists
	 * @param end the upper bound of the range of bt cost lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bt cost lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtCostList> findByBusinessTripPkId(long businessTripPkId,
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

		List<BtCostList> list = (List<BtCostList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BtCostList btCostList : list) {
				if ((businessTripPkId != btCostList.getBusinessTripPkId())) {
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

			query.append(_SQL_SELECT_BTCOSTLIST_WHERE);

			query.append(_FINDER_COLUMN_BUSINESSTRIPPKID_BUSINESSTRIPPKID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BtCostListModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(businessTripPkId);

				if (!pagination) {
					list = (List<BtCostList>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtCostList>(list);
				}
				else {
					list = (List<BtCostList>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first bt cost list in the ordered set where businessTripPkId = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt cost list
	 * @throws com.business.trip.NoSuchBtCostListException if a matching bt cost list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCostList findByBusinessTripPkId_First(long businessTripPkId,
		OrderByComparator orderByComparator)
		throws NoSuchBtCostListException, SystemException {
		BtCostList btCostList = fetchByBusinessTripPkId_First(businessTripPkId,
				orderByComparator);

		if (btCostList != null) {
			return btCostList;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("businessTripPkId=");
		msg.append(businessTripPkId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtCostListException(msg.toString());
	}

	/**
	 * Returns the first bt cost list in the ordered set where businessTripPkId = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt cost list, or <code>null</code> if a matching bt cost list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCostList fetchByBusinessTripPkId_First(long businessTripPkId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BtCostList> list = findByBusinessTripPkId(businessTripPkId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bt cost list in the ordered set where businessTripPkId = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt cost list
	 * @throws com.business.trip.NoSuchBtCostListException if a matching bt cost list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCostList findByBusinessTripPkId_Last(long businessTripPkId,
		OrderByComparator orderByComparator)
		throws NoSuchBtCostListException, SystemException {
		BtCostList btCostList = fetchByBusinessTripPkId_Last(businessTripPkId,
				orderByComparator);

		if (btCostList != null) {
			return btCostList;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("businessTripPkId=");
		msg.append(businessTripPkId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtCostListException(msg.toString());
	}

	/**
	 * Returns the last bt cost list in the ordered set where businessTripPkId = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt cost list, or <code>null</code> if a matching bt cost list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCostList fetchByBusinessTripPkId_Last(long businessTripPkId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBusinessTripPkId(businessTripPkId);

		if (count == 0) {
			return null;
		}

		List<BtCostList> list = findByBusinessTripPkId(businessTripPkId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bt cost lists before and after the current bt cost list in the ordered set where businessTripPkId = &#63;.
	 *
	 * @param btCostListId the primary key of the current bt cost list
	 * @param businessTripPkId the business trip pk ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bt cost list
	 * @throws com.business.trip.NoSuchBtCostListException if a bt cost list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCostList[] findByBusinessTripPkId_PrevAndNext(long btCostListId,
		long businessTripPkId, OrderByComparator orderByComparator)
		throws NoSuchBtCostListException, SystemException {
		BtCostList btCostList = findByPrimaryKey(btCostListId);

		Session session = null;

		try {
			session = openSession();

			BtCostList[] array = new BtCostListImpl[3];

			array[0] = getByBusinessTripPkId_PrevAndNext(session, btCostList,
					businessTripPkId, orderByComparator, true);

			array[1] = btCostList;

			array[2] = getByBusinessTripPkId_PrevAndNext(session, btCostList,
					businessTripPkId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BtCostList getByBusinessTripPkId_PrevAndNext(Session session,
		BtCostList btCostList, long businessTripPkId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BTCOSTLIST_WHERE);

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
			query.append(BtCostListModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(businessTripPkId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(btCostList);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BtCostList> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bt cost lists where businessTripPkId = &#63; from the database.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBusinessTripPkId(long businessTripPkId)
		throws SystemException {
		for (BtCostList btCostList : findByBusinessTripPkId(businessTripPkId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(btCostList);
		}
	}

	/**
	 * Returns the number of bt cost lists where businessTripPkId = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @return the number of matching bt cost lists
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

			query.append(_SQL_COUNT_BTCOSTLIST_WHERE);

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
		"btCostList.businessTripPkId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_B_C = new FinderPath(BtCostListModelImpl.ENTITY_CACHE_ENABLED,
			BtCostListModelImpl.FINDER_CACHE_ENABLED, BtCostListImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByB_C",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_C = new FinderPath(BtCostListModelImpl.ENTITY_CACHE_ENABLED,
			BtCostListModelImpl.FINDER_CACHE_ENABLED, BtCostListImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByB_C",
			new String[] { Long.class.getName(), String.class.getName() },
			BtCostListModelImpl.BUSINESSTRIPPKID_COLUMN_BITMASK |
			BtCostListModelImpl.PAYMENTCURRENCY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_B_C = new FinderPath(BtCostListModelImpl.ENTITY_CACHE_ENABLED,
			BtCostListModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_C",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the bt cost lists where businessTripPkId = &#63; and paymentCurrency = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param paymentCurrency the payment currency
	 * @return the matching bt cost lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtCostList> findByB_C(long businessTripPkId,
		String paymentCurrency) throws SystemException {
		return findByB_C(businessTripPkId, paymentCurrency, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bt cost lists where businessTripPkId = &#63; and paymentCurrency = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCostListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param paymentCurrency the payment currency
	 * @param start the lower bound of the range of bt cost lists
	 * @param end the upper bound of the range of bt cost lists (not inclusive)
	 * @return the range of matching bt cost lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtCostList> findByB_C(long businessTripPkId,
		String paymentCurrency, int start, int end) throws SystemException {
		return findByB_C(businessTripPkId, paymentCurrency, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt cost lists where businessTripPkId = &#63; and paymentCurrency = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCostListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param paymentCurrency the payment currency
	 * @param start the lower bound of the range of bt cost lists
	 * @param end the upper bound of the range of bt cost lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bt cost lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtCostList> findByB_C(long businessTripPkId,
		String paymentCurrency, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_C;
			finderArgs = new Object[] { businessTripPkId, paymentCurrency };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_B_C;
			finderArgs = new Object[] {
					businessTripPkId, paymentCurrency,
					
					start, end, orderByComparator
				};
		}

		List<BtCostList> list = (List<BtCostList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BtCostList btCostList : list) {
				if ((businessTripPkId != btCostList.getBusinessTripPkId()) ||
						!Validator.equals(paymentCurrency,
							btCostList.getPaymentCurrency())) {
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

			query.append(_SQL_SELECT_BTCOSTLIST_WHERE);

			query.append(_FINDER_COLUMN_B_C_BUSINESSTRIPPKID_2);

			boolean bindPaymentCurrency = false;

			if (paymentCurrency == null) {
				query.append(_FINDER_COLUMN_B_C_PAYMENTCURRENCY_1);
			}
			else if (paymentCurrency.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_B_C_PAYMENTCURRENCY_3);
			}
			else {
				bindPaymentCurrency = true;

				query.append(_FINDER_COLUMN_B_C_PAYMENTCURRENCY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BtCostListModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(businessTripPkId);

				if (bindPaymentCurrency) {
					qPos.add(paymentCurrency);
				}

				if (!pagination) {
					list = (List<BtCostList>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtCostList>(list);
				}
				else {
					list = (List<BtCostList>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first bt cost list in the ordered set where businessTripPkId = &#63; and paymentCurrency = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param paymentCurrency the payment currency
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt cost list
	 * @throws com.business.trip.NoSuchBtCostListException if a matching bt cost list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCostList findByB_C_First(long businessTripPkId,
		String paymentCurrency, OrderByComparator orderByComparator)
		throws NoSuchBtCostListException, SystemException {
		BtCostList btCostList = fetchByB_C_First(businessTripPkId,
				paymentCurrency, orderByComparator);

		if (btCostList != null) {
			return btCostList;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("businessTripPkId=");
		msg.append(businessTripPkId);

		msg.append(", paymentCurrency=");
		msg.append(paymentCurrency);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtCostListException(msg.toString());
	}

	/**
	 * Returns the first bt cost list in the ordered set where businessTripPkId = &#63; and paymentCurrency = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param paymentCurrency the payment currency
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt cost list, or <code>null</code> if a matching bt cost list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCostList fetchByB_C_First(long businessTripPkId,
		String paymentCurrency, OrderByComparator orderByComparator)
		throws SystemException {
		List<BtCostList> list = findByB_C(businessTripPkId, paymentCurrency, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bt cost list in the ordered set where businessTripPkId = &#63; and paymentCurrency = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param paymentCurrency the payment currency
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt cost list
	 * @throws com.business.trip.NoSuchBtCostListException if a matching bt cost list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCostList findByB_C_Last(long businessTripPkId,
		String paymentCurrency, OrderByComparator orderByComparator)
		throws NoSuchBtCostListException, SystemException {
		BtCostList btCostList = fetchByB_C_Last(businessTripPkId,
				paymentCurrency, orderByComparator);

		if (btCostList != null) {
			return btCostList;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("businessTripPkId=");
		msg.append(businessTripPkId);

		msg.append(", paymentCurrency=");
		msg.append(paymentCurrency);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtCostListException(msg.toString());
	}

	/**
	 * Returns the last bt cost list in the ordered set where businessTripPkId = &#63; and paymentCurrency = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param paymentCurrency the payment currency
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt cost list, or <code>null</code> if a matching bt cost list could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCostList fetchByB_C_Last(long businessTripPkId,
		String paymentCurrency, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByB_C(businessTripPkId, paymentCurrency);

		if (count == 0) {
			return null;
		}

		List<BtCostList> list = findByB_C(businessTripPkId, paymentCurrency,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bt cost lists before and after the current bt cost list in the ordered set where businessTripPkId = &#63; and paymentCurrency = &#63;.
	 *
	 * @param btCostListId the primary key of the current bt cost list
	 * @param businessTripPkId the business trip pk ID
	 * @param paymentCurrency the payment currency
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bt cost list
	 * @throws com.business.trip.NoSuchBtCostListException if a bt cost list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCostList[] findByB_C_PrevAndNext(long btCostListId,
		long businessTripPkId, String paymentCurrency,
		OrderByComparator orderByComparator)
		throws NoSuchBtCostListException, SystemException {
		BtCostList btCostList = findByPrimaryKey(btCostListId);

		Session session = null;

		try {
			session = openSession();

			BtCostList[] array = new BtCostListImpl[3];

			array[0] = getByB_C_PrevAndNext(session, btCostList,
					businessTripPkId, paymentCurrency, orderByComparator, true);

			array[1] = btCostList;

			array[2] = getByB_C_PrevAndNext(session, btCostList,
					businessTripPkId, paymentCurrency, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BtCostList getByB_C_PrevAndNext(Session session,
		BtCostList btCostList, long businessTripPkId, String paymentCurrency,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BTCOSTLIST_WHERE);

		query.append(_FINDER_COLUMN_B_C_BUSINESSTRIPPKID_2);

		boolean bindPaymentCurrency = false;

		if (paymentCurrency == null) {
			query.append(_FINDER_COLUMN_B_C_PAYMENTCURRENCY_1);
		}
		else if (paymentCurrency.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_B_C_PAYMENTCURRENCY_3);
		}
		else {
			bindPaymentCurrency = true;

			query.append(_FINDER_COLUMN_B_C_PAYMENTCURRENCY_2);
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
			query.append(BtCostListModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(businessTripPkId);

		if (bindPaymentCurrency) {
			qPos.add(paymentCurrency);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(btCostList);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BtCostList> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bt cost lists where businessTripPkId = &#63; and paymentCurrency = &#63; from the database.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param paymentCurrency the payment currency
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByB_C(long businessTripPkId, String paymentCurrency)
		throws SystemException {
		for (BtCostList btCostList : findByB_C(businessTripPkId,
				paymentCurrency, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(btCostList);
		}
	}

	/**
	 * Returns the number of bt cost lists where businessTripPkId = &#63; and paymentCurrency = &#63;.
	 *
	 * @param businessTripPkId the business trip pk ID
	 * @param paymentCurrency the payment currency
	 * @return the number of matching bt cost lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByB_C(long businessTripPkId, String paymentCurrency)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_B_C;

		Object[] finderArgs = new Object[] { businessTripPkId, paymentCurrency };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BTCOSTLIST_WHERE);

			query.append(_FINDER_COLUMN_B_C_BUSINESSTRIPPKID_2);

			boolean bindPaymentCurrency = false;

			if (paymentCurrency == null) {
				query.append(_FINDER_COLUMN_B_C_PAYMENTCURRENCY_1);
			}
			else if (paymentCurrency.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_B_C_PAYMENTCURRENCY_3);
			}
			else {
				bindPaymentCurrency = true;

				query.append(_FINDER_COLUMN_B_C_PAYMENTCURRENCY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(businessTripPkId);

				if (bindPaymentCurrency) {
					qPos.add(paymentCurrency);
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

	private static final String _FINDER_COLUMN_B_C_BUSINESSTRIPPKID_2 = "btCostList.businessTripPkId = ? AND ";
	private static final String _FINDER_COLUMN_B_C_PAYMENTCURRENCY_1 = "btCostList.paymentCurrency IS NULL";
	private static final String _FINDER_COLUMN_B_C_PAYMENTCURRENCY_2 = "btCostList.paymentCurrency = ?";
	private static final String _FINDER_COLUMN_B_C_PAYMENTCURRENCY_3 = "(btCostList.paymentCurrency IS NULL OR btCostList.paymentCurrency = '')";

	public BtCostListPersistenceImpl() {
		setModelClass(BtCostList.class);
	}

	/**
	 * Caches the bt cost list in the entity cache if it is enabled.
	 *
	 * @param btCostList the bt cost list
	 */
	@Override
	public void cacheResult(BtCostList btCostList) {
		EntityCacheUtil.putResult(BtCostListModelImpl.ENTITY_CACHE_ENABLED,
			BtCostListImpl.class, btCostList.getPrimaryKey(), btCostList);

		btCostList.resetOriginalValues();
	}

	/**
	 * Caches the bt cost lists in the entity cache if it is enabled.
	 *
	 * @param btCostLists the bt cost lists
	 */
	@Override
	public void cacheResult(List<BtCostList> btCostLists) {
		for (BtCostList btCostList : btCostLists) {
			if (EntityCacheUtil.getResult(
						BtCostListModelImpl.ENTITY_CACHE_ENABLED,
						BtCostListImpl.class, btCostList.getPrimaryKey()) == null) {
				cacheResult(btCostList);
			}
			else {
				btCostList.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bt cost lists.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BtCostListImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BtCostListImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bt cost list.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BtCostList btCostList) {
		EntityCacheUtil.removeResult(BtCostListModelImpl.ENTITY_CACHE_ENABLED,
			BtCostListImpl.class, btCostList.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BtCostList> btCostLists) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BtCostList btCostList : btCostLists) {
			EntityCacheUtil.removeResult(BtCostListModelImpl.ENTITY_CACHE_ENABLED,
				BtCostListImpl.class, btCostList.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bt cost list with the primary key. Does not add the bt cost list to the database.
	 *
	 * @param btCostListId the primary key for the new bt cost list
	 * @return the new bt cost list
	 */
	@Override
	public BtCostList create(long btCostListId) {
		BtCostList btCostList = new BtCostListImpl();

		btCostList.setNew(true);
		btCostList.setPrimaryKey(btCostListId);

		return btCostList;
	}

	/**
	 * Removes the bt cost list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param btCostListId the primary key of the bt cost list
	 * @return the bt cost list that was removed
	 * @throws com.business.trip.NoSuchBtCostListException if a bt cost list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCostList remove(long btCostListId)
		throws NoSuchBtCostListException, SystemException {
		return remove((Serializable)btCostListId);
	}

	/**
	 * Removes the bt cost list with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bt cost list
	 * @return the bt cost list that was removed
	 * @throws com.business.trip.NoSuchBtCostListException if a bt cost list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCostList remove(Serializable primaryKey)
		throws NoSuchBtCostListException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BtCostList btCostList = (BtCostList)session.get(BtCostListImpl.class,
					primaryKey);

			if (btCostList == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBtCostListException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(btCostList);
		}
		catch (NoSuchBtCostListException nsee) {
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
	protected BtCostList removeImpl(BtCostList btCostList)
		throws SystemException {
		btCostList = toUnwrappedModel(btCostList);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(btCostList)) {
				btCostList = (BtCostList)session.get(BtCostListImpl.class,
						btCostList.getPrimaryKeyObj());
			}

			if (btCostList != null) {
				session.delete(btCostList);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (btCostList != null) {
			clearCache(btCostList);
		}

		return btCostList;
	}

	@Override
	public BtCostList updateImpl(com.business.trip.model.BtCostList btCostList)
		throws SystemException {
		btCostList = toUnwrappedModel(btCostList);

		boolean isNew = btCostList.isNew();

		BtCostListModelImpl btCostListModelImpl = (BtCostListModelImpl)btCostList;

		Session session = null;

		try {
			session = openSession();

			if (btCostList.isNew()) {
				session.save(btCostList);

				btCostList.setNew(false);
			}
			else {
				session.merge(btCostList);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BtCostListModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((btCostListModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TICKETNO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						btCostListModelImpl.getOriginalTicketNo()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TICKETNO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TICKETNO,
					args);

				args = new Object[] { btCostListModelImpl.getTicketNo() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TICKETNO, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TICKETNO,
					args);
			}

			if ((btCostListModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSINESSTRIPPKID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						btCostListModelImpl.getOriginalBusinessTripPkId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BUSINESSTRIPPKID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSINESSTRIPPKID,
					args);

				args = new Object[] { btCostListModelImpl.getBusinessTripPkId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BUSINESSTRIPPKID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUSINESSTRIPPKID,
					args);
			}

			if ((btCostListModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						btCostListModelImpl.getOriginalBusinessTripPkId(),
						btCostListModelImpl.getOriginalPaymentCurrency()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_B_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_C,
					args);

				args = new Object[] {
						btCostListModelImpl.getBusinessTripPkId(),
						btCostListModelImpl.getPaymentCurrency()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_B_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_B_C,
					args);
			}
		}

		EntityCacheUtil.putResult(BtCostListModelImpl.ENTITY_CACHE_ENABLED,
			BtCostListImpl.class, btCostList.getPrimaryKey(), btCostList);

		return btCostList;
	}

	protected BtCostList toUnwrappedModel(BtCostList btCostList) {
		if (btCostList instanceof BtCostListImpl) {
			return btCostList;
		}

		BtCostListImpl btCostListImpl = new BtCostListImpl();

		btCostListImpl.setNew(btCostList.isNew());
		btCostListImpl.setPrimaryKey(btCostList.getPrimaryKey());

		btCostListImpl.setBtCostListId(btCostList.getBtCostListId());
		btCostListImpl.setBusinessTripPkId(btCostList.getBusinessTripPkId());
		btCostListImpl.setTicketNo(btCostList.getTicketNo());
		btCostListImpl.setItem(btCostList.getItem());
		btCostListImpl.setInvoiceCurrency(btCostList.getInvoiceCurrency());
		btCostListImpl.setPaymentAmount(btCostList.getPaymentAmount());
		btCostListImpl.setPaymentCurrency(btCostList.getPaymentCurrency());
		btCostListImpl.setCountryCity(btCostList.getCountryCity());
		btCostListImpl.setType(btCostList.getType());
		btCostListImpl.setInvoiceAmount(btCostList.getInvoiceAmount());
		btCostListImpl.setTaxRate(btCostList.getTaxRate());
		btCostListImpl.setNetAmount(btCostList.getNetAmount());
		btCostListImpl.setTaxAmount(btCostList.getTaxAmount());
		btCostListImpl.setNetAmountRmb(btCostList.getNetAmountRmb());
		btCostListImpl.setEntertainmentDate(btCostList.getEntertainmentDate());
		btCostListImpl.setEntertainmentPlace(btCostList.getEntertainmentPlace());
		btCostListImpl.setReasonesInfo(btCostList.getReasonesInfo());
		btCostListImpl.setAttendeesTotal(btCostList.getAttendeesTotal());
		btCostListImpl.setAverageSpend(btCostList.getAverageSpend());
		btCostListImpl.setMealCategory(btCostList.getMealCategory());

		return btCostListImpl;
	}

	/**
	 * Returns the bt cost list with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bt cost list
	 * @return the bt cost list
	 * @throws com.business.trip.NoSuchBtCostListException if a bt cost list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCostList findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBtCostListException, SystemException {
		BtCostList btCostList = fetchByPrimaryKey(primaryKey);

		if (btCostList == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBtCostListException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return btCostList;
	}

	/**
	 * Returns the bt cost list with the primary key or throws a {@link com.business.trip.NoSuchBtCostListException} if it could not be found.
	 *
	 * @param btCostListId the primary key of the bt cost list
	 * @return the bt cost list
	 * @throws com.business.trip.NoSuchBtCostListException if a bt cost list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCostList findByPrimaryKey(long btCostListId)
		throws NoSuchBtCostListException, SystemException {
		return findByPrimaryKey((Serializable)btCostListId);
	}

	/**
	 * Returns the bt cost list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bt cost list
	 * @return the bt cost list, or <code>null</code> if a bt cost list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCostList fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BtCostList btCostList = (BtCostList)EntityCacheUtil.getResult(BtCostListModelImpl.ENTITY_CACHE_ENABLED,
				BtCostListImpl.class, primaryKey);

		if (btCostList == _nullBtCostList) {
			return null;
		}

		if (btCostList == null) {
			Session session = null;

			try {
				session = openSession();

				btCostList = (BtCostList)session.get(BtCostListImpl.class,
						primaryKey);

				if (btCostList != null) {
					cacheResult(btCostList);
				}
				else {
					EntityCacheUtil.putResult(BtCostListModelImpl.ENTITY_CACHE_ENABLED,
						BtCostListImpl.class, primaryKey, _nullBtCostList);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BtCostListModelImpl.ENTITY_CACHE_ENABLED,
					BtCostListImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return btCostList;
	}

	/**
	 * Returns the bt cost list with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param btCostListId the primary key of the bt cost list
	 * @return the bt cost list, or <code>null</code> if a bt cost list with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtCostList fetchByPrimaryKey(long btCostListId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)btCostListId);
	}

	/**
	 * Returns all the bt cost lists.
	 *
	 * @return the bt cost lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtCostList> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bt cost lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCostListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bt cost lists
	 * @param end the upper bound of the range of bt cost lists (not inclusive)
	 * @return the range of bt cost lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtCostList> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt cost lists.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtCostListModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bt cost lists
	 * @param end the upper bound of the range of bt cost lists (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bt cost lists
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtCostList> findAll(int start, int end,
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

		List<BtCostList> list = (List<BtCostList>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BTCOSTLIST);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BTCOSTLIST;

				if (pagination) {
					sql = sql.concat(BtCostListModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BtCostList>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtCostList>(list);
				}
				else {
					list = (List<BtCostList>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the bt cost lists from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BtCostList btCostList : findAll()) {
			remove(btCostList);
		}
	}

	/**
	 * Returns the number of bt cost lists.
	 *
	 * @return the number of bt cost lists
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

				Query q = session.createQuery(_SQL_COUNT_BTCOSTLIST);

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
	 * Initializes the bt cost list persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.business.trip.model.BtCostList")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BtCostList>> listenersList = new ArrayList<ModelListener<BtCostList>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BtCostList>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BtCostListImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BTCOSTLIST = "SELECT btCostList FROM BtCostList btCostList";
	private static final String _SQL_SELECT_BTCOSTLIST_WHERE = "SELECT btCostList FROM BtCostList btCostList WHERE ";
	private static final String _SQL_COUNT_BTCOSTLIST = "SELECT COUNT(btCostList) FROM BtCostList btCostList";
	private static final String _SQL_COUNT_BTCOSTLIST_WHERE = "SELECT COUNT(btCostList) FROM BtCostList btCostList WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "btCostList.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BtCostList exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BtCostList exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BtCostListPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
	private static BtCostList _nullBtCostList = new BtCostListImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BtCostList> toCacheModel() {
				return _nullBtCostListCacheModel;
			}
		};

	private static CacheModel<BtCostList> _nullBtCostListCacheModel = new CacheModel<BtCostList>() {
			@Override
			public BtCostList toEntityModel() {
				return _nullBtCostList;
			}
		};
}