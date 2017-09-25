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

import com.business.trip.NoSuchBtReimbursementSAPInfoException;
import com.business.trip.model.BtReimbursementSAPInfo;
import com.business.trip.model.impl.BtReimbursementSAPInfoImpl;
import com.business.trip.model.impl.BtReimbursementSAPInfoModelImpl;

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
 * The persistence implementation for the bt reimbursement s a p info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtReimbursementSAPInfoPersistence
 * @see BtReimbursementSAPInfoUtil
 * @generated
 */
public class BtReimbursementSAPInfoPersistenceImpl extends BasePersistenceImpl<BtReimbursementSAPInfo>
	implements BtReimbursementSAPInfoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BtReimbursementSAPInfoUtil} to access the bt reimbursement s a p info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BtReimbursementSAPInfoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BtReimbursementSAPInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtReimbursementSAPInfoModelImpl.FINDER_CACHE_ENABLED,
			BtReimbursementSAPInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BtReimbursementSAPInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtReimbursementSAPInfoModelImpl.FINDER_CACHE_ENABLED,
			BtReimbursementSAPInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BtReimbursementSAPInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtReimbursementSAPInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_B_C = new FinderPath(BtReimbursementSAPInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtReimbursementSAPInfoModelImpl.FINDER_CACHE_ENABLED,
			BtReimbursementSAPInfoImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByB_C",
			new String[] { String.class.getName(), Long.class.getName() },
			BtReimbursementSAPInfoModelImpl.CURRENCY_COLUMN_BITMASK |
			BtReimbursementSAPInfoModelImpl.BUSINESSTRIPPKID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_B_C = new FinderPath(BtReimbursementSAPInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtReimbursementSAPInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByB_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the bt reimbursement s a p info where currency = &#63; and businessTripPkId = &#63; or throws a {@link com.business.trip.NoSuchBtReimbursementSAPInfoException} if it could not be found.
	 *
	 * @param currency the currency
	 * @param businessTripPkId the business trip pk ID
	 * @return the matching bt reimbursement s a p info
	 * @throws com.business.trip.NoSuchBtReimbursementSAPInfoException if a matching bt reimbursement s a p info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtReimbursementSAPInfo findByB_C(String currency,
		long businessTripPkId)
		throws NoSuchBtReimbursementSAPInfoException, SystemException {
		BtReimbursementSAPInfo btReimbursementSAPInfo = fetchByB_C(currency,
				businessTripPkId);

		if (btReimbursementSAPInfo == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("currency=");
			msg.append(currency);

			msg.append(", businessTripPkId=");
			msg.append(businessTripPkId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBtReimbursementSAPInfoException(msg.toString());
		}

		return btReimbursementSAPInfo;
	}

	/**
	 * Returns the bt reimbursement s a p info where currency = &#63; and businessTripPkId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param currency the currency
	 * @param businessTripPkId the business trip pk ID
	 * @return the matching bt reimbursement s a p info, or <code>null</code> if a matching bt reimbursement s a p info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtReimbursementSAPInfo fetchByB_C(String currency,
		long businessTripPkId) throws SystemException {
		return fetchByB_C(currency, businessTripPkId, true);
	}

	/**
	 * Returns the bt reimbursement s a p info where currency = &#63; and businessTripPkId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param currency the currency
	 * @param businessTripPkId the business trip pk ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching bt reimbursement s a p info, or <code>null</code> if a matching bt reimbursement s a p info could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtReimbursementSAPInfo fetchByB_C(String currency,
		long businessTripPkId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { currency, businessTripPkId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_B_C,
					finderArgs, this);
		}

		if (result instanceof BtReimbursementSAPInfo) {
			BtReimbursementSAPInfo btReimbursementSAPInfo = (BtReimbursementSAPInfo)result;

			if (!Validator.equals(currency, btReimbursementSAPInfo.getCurrency()) ||
					(businessTripPkId != btReimbursementSAPInfo.getBusinessTripPkId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_BTREIMBURSEMENTSAPINFO_WHERE);

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

			query.append(_FINDER_COLUMN_B_C_BUSINESSTRIPPKID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCurrency) {
					qPos.add(currency);
				}

				qPos.add(businessTripPkId);

				List<BtReimbursementSAPInfo> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_B_C,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BtReimbursementSAPInfoPersistenceImpl.fetchByB_C(String, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					BtReimbursementSAPInfo btReimbursementSAPInfo = list.get(0);

					result = btReimbursementSAPInfo;

					cacheResult(btReimbursementSAPInfo);

					if ((btReimbursementSAPInfo.getCurrency() == null) ||
							!btReimbursementSAPInfo.getCurrency()
													   .equals(currency) ||
							(btReimbursementSAPInfo.getBusinessTripPkId() != businessTripPkId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_B_C,
							finderArgs, btReimbursementSAPInfo);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_B_C,
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
			return (BtReimbursementSAPInfo)result;
		}
	}

	/**
	 * Removes the bt reimbursement s a p info where currency = &#63; and businessTripPkId = &#63; from the database.
	 *
	 * @param currency the currency
	 * @param businessTripPkId the business trip pk ID
	 * @return the bt reimbursement s a p info that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtReimbursementSAPInfo removeByB_C(String currency,
		long businessTripPkId)
		throws NoSuchBtReimbursementSAPInfoException, SystemException {
		BtReimbursementSAPInfo btReimbursementSAPInfo = findByB_C(currency,
				businessTripPkId);

		return remove(btReimbursementSAPInfo);
	}

	/**
	 * Returns the number of bt reimbursement s a p infos where currency = &#63; and businessTripPkId = &#63;.
	 *
	 * @param currency the currency
	 * @param businessTripPkId the business trip pk ID
	 * @return the number of matching bt reimbursement s a p infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByB_C(String currency, long businessTripPkId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_B_C;

		Object[] finderArgs = new Object[] { currency, businessTripPkId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_BTREIMBURSEMENTSAPINFO_WHERE);

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

			query.append(_FINDER_COLUMN_B_C_BUSINESSTRIPPKID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCurrency) {
					qPos.add(currency);
				}

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

	private static final String _FINDER_COLUMN_B_C_CURRENCY_1 = "btReimbursementSAPInfo.currency IS NULL AND ";
	private static final String _FINDER_COLUMN_B_C_CURRENCY_2 = "btReimbursementSAPInfo.currency = ? AND ";
	private static final String _FINDER_COLUMN_B_C_CURRENCY_3 = "(btReimbursementSAPInfo.currency IS NULL OR btReimbursementSAPInfo.currency = '') AND ";
	private static final String _FINDER_COLUMN_B_C_BUSINESSTRIPPKID_2 = "btReimbursementSAPInfo.businessTripPkId = ?";

	public BtReimbursementSAPInfoPersistenceImpl() {
		setModelClass(BtReimbursementSAPInfo.class);
	}

	/**
	 * Caches the bt reimbursement s a p info in the entity cache if it is enabled.
	 *
	 * @param btReimbursementSAPInfo the bt reimbursement s a p info
	 */
	@Override
	public void cacheResult(BtReimbursementSAPInfo btReimbursementSAPInfo) {
		EntityCacheUtil.putResult(BtReimbursementSAPInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtReimbursementSAPInfoImpl.class,
			btReimbursementSAPInfo.getPrimaryKey(), btReimbursementSAPInfo);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_B_C,
			new Object[] {
				btReimbursementSAPInfo.getCurrency(),
				btReimbursementSAPInfo.getBusinessTripPkId()
			}, btReimbursementSAPInfo);

		btReimbursementSAPInfo.resetOriginalValues();
	}

	/**
	 * Caches the bt reimbursement s a p infos in the entity cache if it is enabled.
	 *
	 * @param btReimbursementSAPInfos the bt reimbursement s a p infos
	 */
	@Override
	public void cacheResult(
		List<BtReimbursementSAPInfo> btReimbursementSAPInfos) {
		for (BtReimbursementSAPInfo btReimbursementSAPInfo : btReimbursementSAPInfos) {
			if (EntityCacheUtil.getResult(
						BtReimbursementSAPInfoModelImpl.ENTITY_CACHE_ENABLED,
						BtReimbursementSAPInfoImpl.class,
						btReimbursementSAPInfo.getPrimaryKey()) == null) {
				cacheResult(btReimbursementSAPInfo);
			}
			else {
				btReimbursementSAPInfo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bt reimbursement s a p infos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BtReimbursementSAPInfoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BtReimbursementSAPInfoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bt reimbursement s a p info.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BtReimbursementSAPInfo btReimbursementSAPInfo) {
		EntityCacheUtil.removeResult(BtReimbursementSAPInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtReimbursementSAPInfoImpl.class,
			btReimbursementSAPInfo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(btReimbursementSAPInfo);
	}

	@Override
	public void clearCache(List<BtReimbursementSAPInfo> btReimbursementSAPInfos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BtReimbursementSAPInfo btReimbursementSAPInfo : btReimbursementSAPInfos) {
			EntityCacheUtil.removeResult(BtReimbursementSAPInfoModelImpl.ENTITY_CACHE_ENABLED,
				BtReimbursementSAPInfoImpl.class,
				btReimbursementSAPInfo.getPrimaryKey());

			clearUniqueFindersCache(btReimbursementSAPInfo);
		}
	}

	protected void cacheUniqueFindersCache(
		BtReimbursementSAPInfo btReimbursementSAPInfo) {
		if (btReimbursementSAPInfo.isNew()) {
			Object[] args = new Object[] {
					btReimbursementSAPInfo.getCurrency(),
					btReimbursementSAPInfo.getBusinessTripPkId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_B_C, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_B_C, args,
				btReimbursementSAPInfo);
		}
		else {
			BtReimbursementSAPInfoModelImpl btReimbursementSAPInfoModelImpl = (BtReimbursementSAPInfoModelImpl)btReimbursementSAPInfo;

			if ((btReimbursementSAPInfoModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_B_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						btReimbursementSAPInfo.getCurrency(),
						btReimbursementSAPInfo.getBusinessTripPkId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_B_C, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_B_C, args,
					btReimbursementSAPInfo);
			}
		}
	}

	protected void clearUniqueFindersCache(
		BtReimbursementSAPInfo btReimbursementSAPInfo) {
		BtReimbursementSAPInfoModelImpl btReimbursementSAPInfoModelImpl = (BtReimbursementSAPInfoModelImpl)btReimbursementSAPInfo;

		Object[] args = new Object[] {
				btReimbursementSAPInfo.getCurrency(),
				btReimbursementSAPInfo.getBusinessTripPkId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_B_C, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_B_C, args);

		if ((btReimbursementSAPInfoModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_B_C.getColumnBitmask()) != 0) {
			args = new Object[] {
					btReimbursementSAPInfoModelImpl.getOriginalCurrency(),
					btReimbursementSAPInfoModelImpl.getOriginalBusinessTripPkId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_B_C, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_B_C, args);
		}
	}

	/**
	 * Creates a new bt reimbursement s a p info with the primary key. Does not add the bt reimbursement s a p info to the database.
	 *
	 * @param btReimbursementSAPInfoId the primary key for the new bt reimbursement s a p info
	 * @return the new bt reimbursement s a p info
	 */
	@Override
	public BtReimbursementSAPInfo create(long btReimbursementSAPInfoId) {
		BtReimbursementSAPInfo btReimbursementSAPInfo = new BtReimbursementSAPInfoImpl();

		btReimbursementSAPInfo.setNew(true);
		btReimbursementSAPInfo.setPrimaryKey(btReimbursementSAPInfoId);

		return btReimbursementSAPInfo;
	}

	/**
	 * Removes the bt reimbursement s a p info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param btReimbursementSAPInfoId the primary key of the bt reimbursement s a p info
	 * @return the bt reimbursement s a p info that was removed
	 * @throws com.business.trip.NoSuchBtReimbursementSAPInfoException if a bt reimbursement s a p info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtReimbursementSAPInfo remove(long btReimbursementSAPInfoId)
		throws NoSuchBtReimbursementSAPInfoException, SystemException {
		return remove((Serializable)btReimbursementSAPInfoId);
	}

	/**
	 * Removes the bt reimbursement s a p info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bt reimbursement s a p info
	 * @return the bt reimbursement s a p info that was removed
	 * @throws com.business.trip.NoSuchBtReimbursementSAPInfoException if a bt reimbursement s a p info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtReimbursementSAPInfo remove(Serializable primaryKey)
		throws NoSuchBtReimbursementSAPInfoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BtReimbursementSAPInfo btReimbursementSAPInfo = (BtReimbursementSAPInfo)session.get(BtReimbursementSAPInfoImpl.class,
					primaryKey);

			if (btReimbursementSAPInfo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBtReimbursementSAPInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(btReimbursementSAPInfo);
		}
		catch (NoSuchBtReimbursementSAPInfoException nsee) {
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
	protected BtReimbursementSAPInfo removeImpl(
		BtReimbursementSAPInfo btReimbursementSAPInfo)
		throws SystemException {
		btReimbursementSAPInfo = toUnwrappedModel(btReimbursementSAPInfo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(btReimbursementSAPInfo)) {
				btReimbursementSAPInfo = (BtReimbursementSAPInfo)session.get(BtReimbursementSAPInfoImpl.class,
						btReimbursementSAPInfo.getPrimaryKeyObj());
			}

			if (btReimbursementSAPInfo != null) {
				session.delete(btReimbursementSAPInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (btReimbursementSAPInfo != null) {
			clearCache(btReimbursementSAPInfo);
		}

		return btReimbursementSAPInfo;
	}

	@Override
	public BtReimbursementSAPInfo updateImpl(
		com.business.trip.model.BtReimbursementSAPInfo btReimbursementSAPInfo)
		throws SystemException {
		btReimbursementSAPInfo = toUnwrappedModel(btReimbursementSAPInfo);

		boolean isNew = btReimbursementSAPInfo.isNew();

		Session session = null;

		try {
			session = openSession();

			if (btReimbursementSAPInfo.isNew()) {
				session.save(btReimbursementSAPInfo);

				btReimbursementSAPInfo.setNew(false);
			}
			else {
				session.merge(btReimbursementSAPInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BtReimbursementSAPInfoModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(BtReimbursementSAPInfoModelImpl.ENTITY_CACHE_ENABLED,
			BtReimbursementSAPInfoImpl.class,
			btReimbursementSAPInfo.getPrimaryKey(), btReimbursementSAPInfo);

		clearUniqueFindersCache(btReimbursementSAPInfo);
		cacheUniqueFindersCache(btReimbursementSAPInfo);

		return btReimbursementSAPInfo;
	}

	protected BtReimbursementSAPInfo toUnwrappedModel(
		BtReimbursementSAPInfo btReimbursementSAPInfo) {
		if (btReimbursementSAPInfo instanceof BtReimbursementSAPInfoImpl) {
			return btReimbursementSAPInfo;
		}

		BtReimbursementSAPInfoImpl btReimbursementSAPInfoImpl = new BtReimbursementSAPInfoImpl();

		btReimbursementSAPInfoImpl.setNew(btReimbursementSAPInfo.isNew());
		btReimbursementSAPInfoImpl.setPrimaryKey(btReimbursementSAPInfo.getPrimaryKey());

		btReimbursementSAPInfoImpl.setBtReimbursementSAPInfoId(btReimbursementSAPInfo.getBtReimbursementSAPInfoId());
		btReimbursementSAPInfoImpl.setBusinessTripPkId(btReimbursementSAPInfo.getBusinessTripPkId());
		btReimbursementSAPInfoImpl.setTicketNo(btReimbursementSAPInfo.getTicketNo());
		btReimbursementSAPInfoImpl.setCurrency(btReimbursementSAPInfo.getCurrency());
		btReimbursementSAPInfoImpl.setStep(btReimbursementSAPInfo.getStep());
		btReimbursementSAPInfoImpl.setMessageType(btReimbursementSAPInfo.getMessageType());
		btReimbursementSAPInfoImpl.setMessage(btReimbursementSAPInfo.getMessage());
		btReimbursementSAPInfoImpl.setCertificateNo(btReimbursementSAPInfo.getCertificateNo());
		btReimbursementSAPInfoImpl.setCompany(btReimbursementSAPInfo.getCompany());
		btReimbursementSAPInfoImpl.setYear(btReimbursementSAPInfo.getYear());
		btReimbursementSAPInfoImpl.setCreateDate(btReimbursementSAPInfo.getCreateDate());
		btReimbursementSAPInfoImpl.setModifiedDate(btReimbursementSAPInfo.getModifiedDate());

		return btReimbursementSAPInfoImpl;
	}

	/**
	 * Returns the bt reimbursement s a p info with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bt reimbursement s a p info
	 * @return the bt reimbursement s a p info
	 * @throws com.business.trip.NoSuchBtReimbursementSAPInfoException if a bt reimbursement s a p info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtReimbursementSAPInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBtReimbursementSAPInfoException, SystemException {
		BtReimbursementSAPInfo btReimbursementSAPInfo = fetchByPrimaryKey(primaryKey);

		if (btReimbursementSAPInfo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBtReimbursementSAPInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return btReimbursementSAPInfo;
	}

	/**
	 * Returns the bt reimbursement s a p info with the primary key or throws a {@link com.business.trip.NoSuchBtReimbursementSAPInfoException} if it could not be found.
	 *
	 * @param btReimbursementSAPInfoId the primary key of the bt reimbursement s a p info
	 * @return the bt reimbursement s a p info
	 * @throws com.business.trip.NoSuchBtReimbursementSAPInfoException if a bt reimbursement s a p info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtReimbursementSAPInfo findByPrimaryKey(
		long btReimbursementSAPInfoId)
		throws NoSuchBtReimbursementSAPInfoException, SystemException {
		return findByPrimaryKey((Serializable)btReimbursementSAPInfoId);
	}

	/**
	 * Returns the bt reimbursement s a p info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bt reimbursement s a p info
	 * @return the bt reimbursement s a p info, or <code>null</code> if a bt reimbursement s a p info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtReimbursementSAPInfo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BtReimbursementSAPInfo btReimbursementSAPInfo = (BtReimbursementSAPInfo)EntityCacheUtil.getResult(BtReimbursementSAPInfoModelImpl.ENTITY_CACHE_ENABLED,
				BtReimbursementSAPInfoImpl.class, primaryKey);

		if (btReimbursementSAPInfo == _nullBtReimbursementSAPInfo) {
			return null;
		}

		if (btReimbursementSAPInfo == null) {
			Session session = null;

			try {
				session = openSession();

				btReimbursementSAPInfo = (BtReimbursementSAPInfo)session.get(BtReimbursementSAPInfoImpl.class,
						primaryKey);

				if (btReimbursementSAPInfo != null) {
					cacheResult(btReimbursementSAPInfo);
				}
				else {
					EntityCacheUtil.putResult(BtReimbursementSAPInfoModelImpl.ENTITY_CACHE_ENABLED,
						BtReimbursementSAPInfoImpl.class, primaryKey,
						_nullBtReimbursementSAPInfo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BtReimbursementSAPInfoModelImpl.ENTITY_CACHE_ENABLED,
					BtReimbursementSAPInfoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return btReimbursementSAPInfo;
	}

	/**
	 * Returns the bt reimbursement s a p info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param btReimbursementSAPInfoId the primary key of the bt reimbursement s a p info
	 * @return the bt reimbursement s a p info, or <code>null</code> if a bt reimbursement s a p info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtReimbursementSAPInfo fetchByPrimaryKey(
		long btReimbursementSAPInfoId) throws SystemException {
		return fetchByPrimaryKey((Serializable)btReimbursementSAPInfoId);
	}

	/**
	 * Returns all the bt reimbursement s a p infos.
	 *
	 * @return the bt reimbursement s a p infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtReimbursementSAPInfo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bt reimbursement s a p infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtReimbursementSAPInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bt reimbursement s a p infos
	 * @param end the upper bound of the range of bt reimbursement s a p infos (not inclusive)
	 * @return the range of bt reimbursement s a p infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtReimbursementSAPInfo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt reimbursement s a p infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtReimbursementSAPInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bt reimbursement s a p infos
	 * @param end the upper bound of the range of bt reimbursement s a p infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bt reimbursement s a p infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtReimbursementSAPInfo> findAll(int start, int end,
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

		List<BtReimbursementSAPInfo> list = (List<BtReimbursementSAPInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BTREIMBURSEMENTSAPINFO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BTREIMBURSEMENTSAPINFO;

				if (pagination) {
					sql = sql.concat(BtReimbursementSAPInfoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BtReimbursementSAPInfo>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtReimbursementSAPInfo>(list);
				}
				else {
					list = (List<BtReimbursementSAPInfo>)QueryUtil.list(q,
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
	 * Removes all the bt reimbursement s a p infos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BtReimbursementSAPInfo btReimbursementSAPInfo : findAll()) {
			remove(btReimbursementSAPInfo);
		}
	}

	/**
	 * Returns the number of bt reimbursement s a p infos.
	 *
	 * @return the number of bt reimbursement s a p infos
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

				Query q = session.createQuery(_SQL_COUNT_BTREIMBURSEMENTSAPINFO);

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
	 * Initializes the bt reimbursement s a p info persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.business.trip.model.BtReimbursementSAPInfo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BtReimbursementSAPInfo>> listenersList = new ArrayList<ModelListener<BtReimbursementSAPInfo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BtReimbursementSAPInfo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BtReimbursementSAPInfoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BTREIMBURSEMENTSAPINFO = "SELECT btReimbursementSAPInfo FROM BtReimbursementSAPInfo btReimbursementSAPInfo";
	private static final String _SQL_SELECT_BTREIMBURSEMENTSAPINFO_WHERE = "SELECT btReimbursementSAPInfo FROM BtReimbursementSAPInfo btReimbursementSAPInfo WHERE ";
	private static final String _SQL_COUNT_BTREIMBURSEMENTSAPINFO = "SELECT COUNT(btReimbursementSAPInfo) FROM BtReimbursementSAPInfo btReimbursementSAPInfo";
	private static final String _SQL_COUNT_BTREIMBURSEMENTSAPINFO_WHERE = "SELECT COUNT(btReimbursementSAPInfo) FROM BtReimbursementSAPInfo btReimbursementSAPInfo WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "btReimbursementSAPInfo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BtReimbursementSAPInfo exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BtReimbursementSAPInfo exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BtReimbursementSAPInfoPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"currency"
			});
	private static BtReimbursementSAPInfo _nullBtReimbursementSAPInfo = new BtReimbursementSAPInfoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BtReimbursementSAPInfo> toCacheModel() {
				return _nullBtReimbursementSAPInfoCacheModel;
			}
		};

	private static CacheModel<BtReimbursementSAPInfo> _nullBtReimbursementSAPInfoCacheModel =
		new CacheModel<BtReimbursementSAPInfo>() {
			@Override
			public BtReimbursementSAPInfo toEntityModel() {
				return _nullBtReimbursementSAPInfo;
			}
		};
}