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

import com.business.trip.NoSuchBtEntertainmentDetailException;
import com.business.trip.model.BtEntertainmentDetail;
import com.business.trip.model.impl.BtEntertainmentDetailImpl;
import com.business.trip.model.impl.BtEntertainmentDetailModelImpl;

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
 * The persistence implementation for the bt entertainment detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtEntertainmentDetailPersistence
 * @see BtEntertainmentDetailUtil
 * @generated
 */
public class BtEntertainmentDetailPersistenceImpl extends BasePersistenceImpl<BtEntertainmentDetail>
	implements BtEntertainmentDetailPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BtEntertainmentDetailUtil} to access the bt entertainment detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BtEntertainmentDetailImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BtEntertainmentDetailModelImpl.ENTITY_CACHE_ENABLED,
			BtEntertainmentDetailModelImpl.FINDER_CACHE_ENABLED,
			BtEntertainmentDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BtEntertainmentDetailModelImpl.ENTITY_CACHE_ENABLED,
			BtEntertainmentDetailModelImpl.FINDER_CACHE_ENABLED,
			BtEntertainmentDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BtEntertainmentDetailModelImpl.ENTITY_CACHE_ENABLED,
			BtEntertainmentDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BTCOSTLISTID =
		new FinderPath(BtEntertainmentDetailModelImpl.ENTITY_CACHE_ENABLED,
			BtEntertainmentDetailModelImpl.FINDER_CACHE_ENABLED,
			BtEntertainmentDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByBtCostListId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BTCOSTLISTID =
		new FinderPath(BtEntertainmentDetailModelImpl.ENTITY_CACHE_ENABLED,
			BtEntertainmentDetailModelImpl.FINDER_CACHE_ENABLED,
			BtEntertainmentDetailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByBtCostListId",
			new String[] { Long.class.getName() },
			BtEntertainmentDetailModelImpl.BTCOSTLISTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BTCOSTLISTID = new FinderPath(BtEntertainmentDetailModelImpl.ENTITY_CACHE_ENABLED,
			BtEntertainmentDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBtCostListId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the bt entertainment details where btCostListId = &#63;.
	 *
	 * @param btCostListId the bt cost list ID
	 * @return the matching bt entertainment details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtEntertainmentDetail> findByBtCostListId(long btCostListId)
		throws SystemException {
		return findByBtCostListId(btCostListId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bt entertainment details where btCostListId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtEntertainmentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param btCostListId the bt cost list ID
	 * @param start the lower bound of the range of bt entertainment details
	 * @param end the upper bound of the range of bt entertainment details (not inclusive)
	 * @return the range of matching bt entertainment details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtEntertainmentDetail> findByBtCostListId(long btCostListId,
		int start, int end) throws SystemException {
		return findByBtCostListId(btCostListId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt entertainment details where btCostListId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtEntertainmentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param btCostListId the bt cost list ID
	 * @param start the lower bound of the range of bt entertainment details
	 * @param end the upper bound of the range of bt entertainment details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching bt entertainment details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtEntertainmentDetail> findByBtCostListId(long btCostListId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BTCOSTLISTID;
			finderArgs = new Object[] { btCostListId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BTCOSTLISTID;
			finderArgs = new Object[] {
					btCostListId,
					
					start, end, orderByComparator
				};
		}

		List<BtEntertainmentDetail> list = (List<BtEntertainmentDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (BtEntertainmentDetail btEntertainmentDetail : list) {
				if ((btCostListId != btEntertainmentDetail.getBtCostListId())) {
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

			query.append(_SQL_SELECT_BTENTERTAINMENTDETAIL_WHERE);

			query.append(_FINDER_COLUMN_BTCOSTLISTID_BTCOSTLISTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(BtEntertainmentDetailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(btCostListId);

				if (!pagination) {
					list = (List<BtEntertainmentDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtEntertainmentDetail>(list);
				}
				else {
					list = (List<BtEntertainmentDetail>)QueryUtil.list(q,
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
	 * Returns the first bt entertainment detail in the ordered set where btCostListId = &#63;.
	 *
	 * @param btCostListId the bt cost list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt entertainment detail
	 * @throws com.business.trip.NoSuchBtEntertainmentDetailException if a matching bt entertainment detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtEntertainmentDetail findByBtCostListId_First(long btCostListId,
		OrderByComparator orderByComparator)
		throws NoSuchBtEntertainmentDetailException, SystemException {
		BtEntertainmentDetail btEntertainmentDetail = fetchByBtCostListId_First(btCostListId,
				orderByComparator);

		if (btEntertainmentDetail != null) {
			return btEntertainmentDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("btCostListId=");
		msg.append(btCostListId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtEntertainmentDetailException(msg.toString());
	}

	/**
	 * Returns the first bt entertainment detail in the ordered set where btCostListId = &#63;.
	 *
	 * @param btCostListId the bt cost list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bt entertainment detail, or <code>null</code> if a matching bt entertainment detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtEntertainmentDetail fetchByBtCostListId_First(long btCostListId,
		OrderByComparator orderByComparator) throws SystemException {
		List<BtEntertainmentDetail> list = findByBtCostListId(btCostListId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last bt entertainment detail in the ordered set where btCostListId = &#63;.
	 *
	 * @param btCostListId the bt cost list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt entertainment detail
	 * @throws com.business.trip.NoSuchBtEntertainmentDetailException if a matching bt entertainment detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtEntertainmentDetail findByBtCostListId_Last(long btCostListId,
		OrderByComparator orderByComparator)
		throws NoSuchBtEntertainmentDetailException, SystemException {
		BtEntertainmentDetail btEntertainmentDetail = fetchByBtCostListId_Last(btCostListId,
				orderByComparator);

		if (btEntertainmentDetail != null) {
			return btEntertainmentDetail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("btCostListId=");
		msg.append(btCostListId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchBtEntertainmentDetailException(msg.toString());
	}

	/**
	 * Returns the last bt entertainment detail in the ordered set where btCostListId = &#63;.
	 *
	 * @param btCostListId the bt cost list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bt entertainment detail, or <code>null</code> if a matching bt entertainment detail could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtEntertainmentDetail fetchByBtCostListId_Last(long btCostListId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBtCostListId(btCostListId);

		if (count == 0) {
			return null;
		}

		List<BtEntertainmentDetail> list = findByBtCostListId(btCostListId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the bt entertainment details before and after the current bt entertainment detail in the ordered set where btCostListId = &#63;.
	 *
	 * @param btEntertainmentDetailId the primary key of the current bt entertainment detail
	 * @param btCostListId the bt cost list ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bt entertainment detail
	 * @throws com.business.trip.NoSuchBtEntertainmentDetailException if a bt entertainment detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtEntertainmentDetail[] findByBtCostListId_PrevAndNext(
		long btEntertainmentDetailId, long btCostListId,
		OrderByComparator orderByComparator)
		throws NoSuchBtEntertainmentDetailException, SystemException {
		BtEntertainmentDetail btEntertainmentDetail = findByPrimaryKey(btEntertainmentDetailId);

		Session session = null;

		try {
			session = openSession();

			BtEntertainmentDetail[] array = new BtEntertainmentDetailImpl[3];

			array[0] = getByBtCostListId_PrevAndNext(session,
					btEntertainmentDetail, btCostListId, orderByComparator, true);

			array[1] = btEntertainmentDetail;

			array[2] = getByBtCostListId_PrevAndNext(session,
					btEntertainmentDetail, btCostListId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected BtEntertainmentDetail getByBtCostListId_PrevAndNext(
		Session session, BtEntertainmentDetail btEntertainmentDetail,
		long btCostListId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_BTENTERTAINMENTDETAIL_WHERE);

		query.append(_FINDER_COLUMN_BTCOSTLISTID_BTCOSTLISTID_2);

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
			query.append(BtEntertainmentDetailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(btCostListId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(btEntertainmentDetail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<BtEntertainmentDetail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the bt entertainment details where btCostListId = &#63; from the database.
	 *
	 * @param btCostListId the bt cost list ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByBtCostListId(long btCostListId)
		throws SystemException {
		for (BtEntertainmentDetail btEntertainmentDetail : findByBtCostListId(
				btCostListId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(btEntertainmentDetail);
		}
	}

	/**
	 * Returns the number of bt entertainment details where btCostListId = &#63;.
	 *
	 * @param btCostListId the bt cost list ID
	 * @return the number of matching bt entertainment details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByBtCostListId(long btCostListId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_BTCOSTLISTID;

		Object[] finderArgs = new Object[] { btCostListId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BTENTERTAINMENTDETAIL_WHERE);

			query.append(_FINDER_COLUMN_BTCOSTLISTID_BTCOSTLISTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(btCostListId);

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

	private static final String _FINDER_COLUMN_BTCOSTLISTID_BTCOSTLISTID_2 = "btEntertainmentDetail.btCostListId = ?";

	public BtEntertainmentDetailPersistenceImpl() {
		setModelClass(BtEntertainmentDetail.class);
	}

	/**
	 * Caches the bt entertainment detail in the entity cache if it is enabled.
	 *
	 * @param btEntertainmentDetail the bt entertainment detail
	 */
	@Override
	public void cacheResult(BtEntertainmentDetail btEntertainmentDetail) {
		EntityCacheUtil.putResult(BtEntertainmentDetailModelImpl.ENTITY_CACHE_ENABLED,
			BtEntertainmentDetailImpl.class,
			btEntertainmentDetail.getPrimaryKey(), btEntertainmentDetail);

		btEntertainmentDetail.resetOriginalValues();
	}

	/**
	 * Caches the bt entertainment details in the entity cache if it is enabled.
	 *
	 * @param btEntertainmentDetails the bt entertainment details
	 */
	@Override
	public void cacheResult(List<BtEntertainmentDetail> btEntertainmentDetails) {
		for (BtEntertainmentDetail btEntertainmentDetail : btEntertainmentDetails) {
			if (EntityCacheUtil.getResult(
						BtEntertainmentDetailModelImpl.ENTITY_CACHE_ENABLED,
						BtEntertainmentDetailImpl.class,
						btEntertainmentDetail.getPrimaryKey()) == null) {
				cacheResult(btEntertainmentDetail);
			}
			else {
				btEntertainmentDetail.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bt entertainment details.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BtEntertainmentDetailImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BtEntertainmentDetailImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bt entertainment detail.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BtEntertainmentDetail btEntertainmentDetail) {
		EntityCacheUtil.removeResult(BtEntertainmentDetailModelImpl.ENTITY_CACHE_ENABLED,
			BtEntertainmentDetailImpl.class,
			btEntertainmentDetail.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BtEntertainmentDetail> btEntertainmentDetails) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BtEntertainmentDetail btEntertainmentDetail : btEntertainmentDetails) {
			EntityCacheUtil.removeResult(BtEntertainmentDetailModelImpl.ENTITY_CACHE_ENABLED,
				BtEntertainmentDetailImpl.class,
				btEntertainmentDetail.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bt entertainment detail with the primary key. Does not add the bt entertainment detail to the database.
	 *
	 * @param btEntertainmentDetailId the primary key for the new bt entertainment detail
	 * @return the new bt entertainment detail
	 */
	@Override
	public BtEntertainmentDetail create(long btEntertainmentDetailId) {
		BtEntertainmentDetail btEntertainmentDetail = new BtEntertainmentDetailImpl();

		btEntertainmentDetail.setNew(true);
		btEntertainmentDetail.setPrimaryKey(btEntertainmentDetailId);

		return btEntertainmentDetail;
	}

	/**
	 * Removes the bt entertainment detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param btEntertainmentDetailId the primary key of the bt entertainment detail
	 * @return the bt entertainment detail that was removed
	 * @throws com.business.trip.NoSuchBtEntertainmentDetailException if a bt entertainment detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtEntertainmentDetail remove(long btEntertainmentDetailId)
		throws NoSuchBtEntertainmentDetailException, SystemException {
		return remove((Serializable)btEntertainmentDetailId);
	}

	/**
	 * Removes the bt entertainment detail with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bt entertainment detail
	 * @return the bt entertainment detail that was removed
	 * @throws com.business.trip.NoSuchBtEntertainmentDetailException if a bt entertainment detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtEntertainmentDetail remove(Serializable primaryKey)
		throws NoSuchBtEntertainmentDetailException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BtEntertainmentDetail btEntertainmentDetail = (BtEntertainmentDetail)session.get(BtEntertainmentDetailImpl.class,
					primaryKey);

			if (btEntertainmentDetail == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBtEntertainmentDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(btEntertainmentDetail);
		}
		catch (NoSuchBtEntertainmentDetailException nsee) {
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
	protected BtEntertainmentDetail removeImpl(
		BtEntertainmentDetail btEntertainmentDetail) throws SystemException {
		btEntertainmentDetail = toUnwrappedModel(btEntertainmentDetail);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(btEntertainmentDetail)) {
				btEntertainmentDetail = (BtEntertainmentDetail)session.get(BtEntertainmentDetailImpl.class,
						btEntertainmentDetail.getPrimaryKeyObj());
			}

			if (btEntertainmentDetail != null) {
				session.delete(btEntertainmentDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (btEntertainmentDetail != null) {
			clearCache(btEntertainmentDetail);
		}

		return btEntertainmentDetail;
	}

	@Override
	public BtEntertainmentDetail updateImpl(
		com.business.trip.model.BtEntertainmentDetail btEntertainmentDetail)
		throws SystemException {
		btEntertainmentDetail = toUnwrappedModel(btEntertainmentDetail);

		boolean isNew = btEntertainmentDetail.isNew();

		BtEntertainmentDetailModelImpl btEntertainmentDetailModelImpl = (BtEntertainmentDetailModelImpl)btEntertainmentDetail;

		Session session = null;

		try {
			session = openSession();

			if (btEntertainmentDetail.isNew()) {
				session.save(btEntertainmentDetail);

				btEntertainmentDetail.setNew(false);
			}
			else {
				session.merge(btEntertainmentDetail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BtEntertainmentDetailModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((btEntertainmentDetailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BTCOSTLISTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						btEntertainmentDetailModelImpl.getOriginalBtCostListId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BTCOSTLISTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BTCOSTLISTID,
					args);

				args = new Object[] {
						btEntertainmentDetailModelImpl.getBtCostListId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BTCOSTLISTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BTCOSTLISTID,
					args);
			}
		}

		EntityCacheUtil.putResult(BtEntertainmentDetailModelImpl.ENTITY_CACHE_ENABLED,
			BtEntertainmentDetailImpl.class,
			btEntertainmentDetail.getPrimaryKey(), btEntertainmentDetail);

		return btEntertainmentDetail;
	}

	protected BtEntertainmentDetail toUnwrappedModel(
		BtEntertainmentDetail btEntertainmentDetail) {
		if (btEntertainmentDetail instanceof BtEntertainmentDetailImpl) {
			return btEntertainmentDetail;
		}

		BtEntertainmentDetailImpl btEntertainmentDetailImpl = new BtEntertainmentDetailImpl();

		btEntertainmentDetailImpl.setNew(btEntertainmentDetail.isNew());
		btEntertainmentDetailImpl.setPrimaryKey(btEntertainmentDetail.getPrimaryKey());

		btEntertainmentDetailImpl.setBtEntertainmentDetailId(btEntertainmentDetail.getBtEntertainmentDetailId());
		btEntertainmentDetailImpl.setBtCostListId(btEntertainmentDetail.getBtCostListId());
		btEntertainmentDetailImpl.setBusinessTripPkId(btEntertainmentDetail.getBusinessTripPkId());
		btEntertainmentDetailImpl.setFullName(btEntertainmentDetail.getFullName());
		btEntertainmentDetailImpl.setPositionTitle(btEntertainmentDetail.getPositionTitle());
		btEntertainmentDetailImpl.setCompany(btEntertainmentDetail.getCompany());

		return btEntertainmentDetailImpl;
	}

	/**
	 * Returns the bt entertainment detail with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bt entertainment detail
	 * @return the bt entertainment detail
	 * @throws com.business.trip.NoSuchBtEntertainmentDetailException if a bt entertainment detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtEntertainmentDetail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBtEntertainmentDetailException, SystemException {
		BtEntertainmentDetail btEntertainmentDetail = fetchByPrimaryKey(primaryKey);

		if (btEntertainmentDetail == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBtEntertainmentDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return btEntertainmentDetail;
	}

	/**
	 * Returns the bt entertainment detail with the primary key or throws a {@link com.business.trip.NoSuchBtEntertainmentDetailException} if it could not be found.
	 *
	 * @param btEntertainmentDetailId the primary key of the bt entertainment detail
	 * @return the bt entertainment detail
	 * @throws com.business.trip.NoSuchBtEntertainmentDetailException if a bt entertainment detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtEntertainmentDetail findByPrimaryKey(long btEntertainmentDetailId)
		throws NoSuchBtEntertainmentDetailException, SystemException {
		return findByPrimaryKey((Serializable)btEntertainmentDetailId);
	}

	/**
	 * Returns the bt entertainment detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bt entertainment detail
	 * @return the bt entertainment detail, or <code>null</code> if a bt entertainment detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtEntertainmentDetail fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BtEntertainmentDetail btEntertainmentDetail = (BtEntertainmentDetail)EntityCacheUtil.getResult(BtEntertainmentDetailModelImpl.ENTITY_CACHE_ENABLED,
				BtEntertainmentDetailImpl.class, primaryKey);

		if (btEntertainmentDetail == _nullBtEntertainmentDetail) {
			return null;
		}

		if (btEntertainmentDetail == null) {
			Session session = null;

			try {
				session = openSession();

				btEntertainmentDetail = (BtEntertainmentDetail)session.get(BtEntertainmentDetailImpl.class,
						primaryKey);

				if (btEntertainmentDetail != null) {
					cacheResult(btEntertainmentDetail);
				}
				else {
					EntityCacheUtil.putResult(BtEntertainmentDetailModelImpl.ENTITY_CACHE_ENABLED,
						BtEntertainmentDetailImpl.class, primaryKey,
						_nullBtEntertainmentDetail);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BtEntertainmentDetailModelImpl.ENTITY_CACHE_ENABLED,
					BtEntertainmentDetailImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return btEntertainmentDetail;
	}

	/**
	 * Returns the bt entertainment detail with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param btEntertainmentDetailId the primary key of the bt entertainment detail
	 * @return the bt entertainment detail, or <code>null</code> if a bt entertainment detail with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtEntertainmentDetail fetchByPrimaryKey(long btEntertainmentDetailId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)btEntertainmentDetailId);
	}

	/**
	 * Returns all the bt entertainment details.
	 *
	 * @return the bt entertainment details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtEntertainmentDetail> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bt entertainment details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtEntertainmentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bt entertainment details
	 * @param end the upper bound of the range of bt entertainment details (not inclusive)
	 * @return the range of bt entertainment details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtEntertainmentDetail> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt entertainment details.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtEntertainmentDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bt entertainment details
	 * @param end the upper bound of the range of bt entertainment details (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bt entertainment details
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtEntertainmentDetail> findAll(int start, int end,
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

		List<BtEntertainmentDetail> list = (List<BtEntertainmentDetail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BTENTERTAINMENTDETAIL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BTENTERTAINMENTDETAIL;

				if (pagination) {
					sql = sql.concat(BtEntertainmentDetailModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BtEntertainmentDetail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtEntertainmentDetail>(list);
				}
				else {
					list = (List<BtEntertainmentDetail>)QueryUtil.list(q,
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
	 * Removes all the bt entertainment details from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BtEntertainmentDetail btEntertainmentDetail : findAll()) {
			remove(btEntertainmentDetail);
		}
	}

	/**
	 * Returns the number of bt entertainment details.
	 *
	 * @return the number of bt entertainment details
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

				Query q = session.createQuery(_SQL_COUNT_BTENTERTAINMENTDETAIL);

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
	 * Initializes the bt entertainment detail persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.business.trip.model.BtEntertainmentDetail")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BtEntertainmentDetail>> listenersList = new ArrayList<ModelListener<BtEntertainmentDetail>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BtEntertainmentDetail>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BtEntertainmentDetailImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BTENTERTAINMENTDETAIL = "SELECT btEntertainmentDetail FROM BtEntertainmentDetail btEntertainmentDetail";
	private static final String _SQL_SELECT_BTENTERTAINMENTDETAIL_WHERE = "SELECT btEntertainmentDetail FROM BtEntertainmentDetail btEntertainmentDetail WHERE ";
	private static final String _SQL_COUNT_BTENTERTAINMENTDETAIL = "SELECT COUNT(btEntertainmentDetail) FROM BtEntertainmentDetail btEntertainmentDetail";
	private static final String _SQL_COUNT_BTENTERTAINMENTDETAIL_WHERE = "SELECT COUNT(btEntertainmentDetail) FROM BtEntertainmentDetail btEntertainmentDetail WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "btEntertainmentDetail.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BtEntertainmentDetail exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BtEntertainmentDetail exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BtEntertainmentDetailPersistenceImpl.class);
	private static BtEntertainmentDetail _nullBtEntertainmentDetail = new BtEntertainmentDetailImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BtEntertainmentDetail> toCacheModel() {
				return _nullBtEntertainmentDetailCacheModel;
			}
		};

	private static CacheModel<BtEntertainmentDetail> _nullBtEntertainmentDetailCacheModel =
		new CacheModel<BtEntertainmentDetail>() {
			@Override
			public BtEntertainmentDetail toEntityModel() {
				return _nullBtEntertainmentDetail;
			}
		};
}