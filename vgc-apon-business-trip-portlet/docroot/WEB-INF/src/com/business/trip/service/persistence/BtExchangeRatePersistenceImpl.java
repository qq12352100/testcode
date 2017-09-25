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

import com.business.trip.NoSuchBtExchangeRateException;
import com.business.trip.model.BtExchangeRate;
import com.business.trip.model.impl.BtExchangeRateImpl;
import com.business.trip.model.impl.BtExchangeRateModelImpl;
import com.business.trip.service.persistence.BtExchangeRatePersistence;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the bt exchange rate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtExchangeRatePersistence
 * @see BtExchangeRateUtil
 * @generated
 */
public class BtExchangeRatePersistenceImpl extends BasePersistenceImpl<BtExchangeRate>
	implements BtExchangeRatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BtExchangeRateUtil} to access the bt exchange rate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BtExchangeRateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BtExchangeRateModelImpl.ENTITY_CACHE_ENABLED,
			BtExchangeRateModelImpl.FINDER_CACHE_ENABLED,
			BtExchangeRateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BtExchangeRateModelImpl.ENTITY_CACHE_ENABLED,
			BtExchangeRateModelImpl.FINDER_CACHE_ENABLED,
			BtExchangeRateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BtExchangeRateModelImpl.ENTITY_CACHE_ENABLED,
			BtExchangeRateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_S = new FinderPath(BtExchangeRateModelImpl.ENTITY_CACHE_ENABLED,
			BtExchangeRateModelImpl.FINDER_CACHE_ENABLED,
			BtExchangeRateImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByS",
			new String[] { Integer.class.getName() },
			BtExchangeRateModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_S = new FinderPath(BtExchangeRateModelImpl.ENTITY_CACHE_ENABLED,
			BtExchangeRateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS",
			new String[] { Integer.class.getName() });

	/**
	 * Returns the bt exchange rate where status = &#63; or throws a {@link com.business.trip.NoSuchBtExchangeRateException} if it could not be found.
	 *
	 * @param status the status
	 * @return the matching bt exchange rate
	 * @throws com.business.trip.NoSuchBtExchangeRateException if a matching bt exchange rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtExchangeRate findByS(int status)
		throws NoSuchBtExchangeRateException, SystemException {
		BtExchangeRate btExchangeRate = fetchByS(status);

		if (btExchangeRate == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBtExchangeRateException(msg.toString());
		}

		return btExchangeRate;
	}

	/**
	 * Returns the bt exchange rate where status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param status the status
	 * @return the matching bt exchange rate, or <code>null</code> if a matching bt exchange rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtExchangeRate fetchByS(int status) throws SystemException {
		return fetchByS(status, true);
	}

	/**
	 * Returns the bt exchange rate where status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param status the status
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching bt exchange rate, or <code>null</code> if a matching bt exchange rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtExchangeRate fetchByS(int status, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { status };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_S,
					finderArgs, this);
		}

		if (result instanceof BtExchangeRate) {
			BtExchangeRate btExchangeRate = (BtExchangeRate)result;

			if ((status != btExchangeRate.getStatus())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_BTEXCHANGERATE_WHERE);

			query.append(_FINDER_COLUMN_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				List<BtExchangeRate> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BtExchangeRatePersistenceImpl.fetchByS(int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					BtExchangeRate btExchangeRate = list.get(0);

					result = btExchangeRate;

					cacheResult(btExchangeRate);

					if ((btExchangeRate.getStatus() != status)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S,
							finderArgs, btExchangeRate);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_S, finderArgs);

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
			return (BtExchangeRate)result;
		}
	}

	/**
	 * Removes the bt exchange rate where status = &#63; from the database.
	 *
	 * @param status the status
	 * @return the bt exchange rate that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtExchangeRate removeByS(int status)
		throws NoSuchBtExchangeRateException, SystemException {
		BtExchangeRate btExchangeRate = findByS(status);

		return remove(btExchangeRate);
	}

	/**
	 * Returns the number of bt exchange rates where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching bt exchange rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByS(int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_S;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_BTEXCHANGERATE_WHERE);

			query.append(_FINDER_COLUMN_S_STATUS_2);

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

	private static final String _FINDER_COLUMN_S_STATUS_2 = "btExchangeRate.status = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_F_S_S = new FinderPath(BtExchangeRateModelImpl.ENTITY_CACHE_ENABLED,
			BtExchangeRateModelImpl.FINDER_CACHE_ENABLED,
			BtExchangeRateImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByF_S_S",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName()
			},
			BtExchangeRateModelImpl.FIRSTCURRENCY_COLUMN_BITMASK |
			BtExchangeRateModelImpl.SECONDCURRENCY_COLUMN_BITMASK |
			BtExchangeRateModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_F_S_S = new FinderPath(BtExchangeRateModelImpl.ENTITY_CACHE_ENABLED,
			BtExchangeRateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByF_S_S",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns the bt exchange rate where firstCurrency = &#63; and secondCurrency = &#63; and status = &#63; or throws a {@link com.business.trip.NoSuchBtExchangeRateException} if it could not be found.
	 *
	 * @param firstCurrency the first currency
	 * @param secondCurrency the second currency
	 * @param status the status
	 * @return the matching bt exchange rate
	 * @throws com.business.trip.NoSuchBtExchangeRateException if a matching bt exchange rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtExchangeRate findByF_S_S(String firstCurrency,
		String secondCurrency, int status)
		throws NoSuchBtExchangeRateException, SystemException {
		BtExchangeRate btExchangeRate = fetchByF_S_S(firstCurrency,
				secondCurrency, status);

		if (btExchangeRate == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("firstCurrency=");
			msg.append(firstCurrency);

			msg.append(", secondCurrency=");
			msg.append(secondCurrency);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchBtExchangeRateException(msg.toString());
		}

		return btExchangeRate;
	}

	/**
	 * Returns the bt exchange rate where firstCurrency = &#63; and secondCurrency = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param firstCurrency the first currency
	 * @param secondCurrency the second currency
	 * @param status the status
	 * @return the matching bt exchange rate, or <code>null</code> if a matching bt exchange rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtExchangeRate fetchByF_S_S(String firstCurrency,
		String secondCurrency, int status) throws SystemException {
		return fetchByF_S_S(firstCurrency, secondCurrency, status, true);
	}

	/**
	 * Returns the bt exchange rate where firstCurrency = &#63; and secondCurrency = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param firstCurrency the first currency
	 * @param secondCurrency the second currency
	 * @param status the status
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching bt exchange rate, or <code>null</code> if a matching bt exchange rate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtExchangeRate fetchByF_S_S(String firstCurrency,
		String secondCurrency, int status, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { firstCurrency, secondCurrency, status };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_F_S_S,
					finderArgs, this);
		}

		if (result instanceof BtExchangeRate) {
			BtExchangeRate btExchangeRate = (BtExchangeRate)result;

			if (!Validator.equals(firstCurrency,
						btExchangeRate.getFirstCurrency()) ||
					!Validator.equals(secondCurrency,
						btExchangeRate.getSecondCurrency()) ||
					(status != btExchangeRate.getStatus())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_BTEXCHANGERATE_WHERE);

			boolean bindFirstCurrency = false;

			if (firstCurrency == null) {
				query.append(_FINDER_COLUMN_F_S_S_FIRSTCURRENCY_1);
			}
			else if (firstCurrency.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_F_S_S_FIRSTCURRENCY_3);
			}
			else {
				bindFirstCurrency = true;

				query.append(_FINDER_COLUMN_F_S_S_FIRSTCURRENCY_2);
			}

			boolean bindSecondCurrency = false;

			if (secondCurrency == null) {
				query.append(_FINDER_COLUMN_F_S_S_SECONDCURRENCY_1);
			}
			else if (secondCurrency.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_F_S_S_SECONDCURRENCY_3);
			}
			else {
				bindSecondCurrency = true;

				query.append(_FINDER_COLUMN_F_S_S_SECONDCURRENCY_2);
			}

			query.append(_FINDER_COLUMN_F_S_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFirstCurrency) {
					qPos.add(firstCurrency);
				}

				if (bindSecondCurrency) {
					qPos.add(secondCurrency);
				}

				qPos.add(status);

				List<BtExchangeRate> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_F_S_S,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"BtExchangeRatePersistenceImpl.fetchByF_S_S(String, String, int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					BtExchangeRate btExchangeRate = list.get(0);

					result = btExchangeRate;

					cacheResult(btExchangeRate);

					if ((btExchangeRate.getFirstCurrency() == null) ||
							!btExchangeRate.getFirstCurrency()
											   .equals(firstCurrency) ||
							(btExchangeRate.getSecondCurrency() == null) ||
							!btExchangeRate.getSecondCurrency()
											   .equals(secondCurrency) ||
							(btExchangeRate.getStatus() != status)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_F_S_S,
							finderArgs, btExchangeRate);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_F_S_S,
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
			return (BtExchangeRate)result;
		}
	}

	/**
	 * Removes the bt exchange rate where firstCurrency = &#63; and secondCurrency = &#63; and status = &#63; from the database.
	 *
	 * @param firstCurrency the first currency
	 * @param secondCurrency the second currency
	 * @param status the status
	 * @return the bt exchange rate that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtExchangeRate removeByF_S_S(String firstCurrency,
		String secondCurrency, int status)
		throws NoSuchBtExchangeRateException, SystemException {
		BtExchangeRate btExchangeRate = findByF_S_S(firstCurrency,
				secondCurrency, status);

		return remove(btExchangeRate);
	}

	/**
	 * Returns the number of bt exchange rates where firstCurrency = &#63; and secondCurrency = &#63; and status = &#63;.
	 *
	 * @param firstCurrency the first currency
	 * @param secondCurrency the second currency
	 * @param status the status
	 * @return the number of matching bt exchange rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByF_S_S(String firstCurrency, String secondCurrency,
		int status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_F_S_S;

		Object[] finderArgs = new Object[] { firstCurrency, secondCurrency, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_BTEXCHANGERATE_WHERE);

			boolean bindFirstCurrency = false;

			if (firstCurrency == null) {
				query.append(_FINDER_COLUMN_F_S_S_FIRSTCURRENCY_1);
			}
			else if (firstCurrency.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_F_S_S_FIRSTCURRENCY_3);
			}
			else {
				bindFirstCurrency = true;

				query.append(_FINDER_COLUMN_F_S_S_FIRSTCURRENCY_2);
			}

			boolean bindSecondCurrency = false;

			if (secondCurrency == null) {
				query.append(_FINDER_COLUMN_F_S_S_SECONDCURRENCY_1);
			}
			else if (secondCurrency.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_F_S_S_SECONDCURRENCY_3);
			}
			else {
				bindSecondCurrency = true;

				query.append(_FINDER_COLUMN_F_S_S_SECONDCURRENCY_2);
			}

			query.append(_FINDER_COLUMN_F_S_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindFirstCurrency) {
					qPos.add(firstCurrency);
				}

				if (bindSecondCurrency) {
					qPos.add(secondCurrency);
				}

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

	private static final String _FINDER_COLUMN_F_S_S_FIRSTCURRENCY_1 = "btExchangeRate.firstCurrency IS NULL AND ";
	private static final String _FINDER_COLUMN_F_S_S_FIRSTCURRENCY_2 = "btExchangeRate.firstCurrency = ? AND ";
	private static final String _FINDER_COLUMN_F_S_S_FIRSTCURRENCY_3 = "(btExchangeRate.firstCurrency IS NULL OR btExchangeRate.firstCurrency = '') AND ";
	private static final String _FINDER_COLUMN_F_S_S_SECONDCURRENCY_1 = "btExchangeRate.secondCurrency IS NULL AND ";
	private static final String _FINDER_COLUMN_F_S_S_SECONDCURRENCY_2 = "btExchangeRate.secondCurrency = ? AND ";
	private static final String _FINDER_COLUMN_F_S_S_SECONDCURRENCY_3 = "(btExchangeRate.secondCurrency IS NULL OR btExchangeRate.secondCurrency = '') AND ";
	private static final String _FINDER_COLUMN_F_S_S_STATUS_2 = "btExchangeRate.status = ?";

	public BtExchangeRatePersistenceImpl() {
		setModelClass(BtExchangeRate.class);
	}

	/**
	 * Caches the bt exchange rate in the entity cache if it is enabled.
	 *
	 * @param btExchangeRate the bt exchange rate
	 */
	@Override
	public void cacheResult(BtExchangeRate btExchangeRate) {
		EntityCacheUtil.putResult(BtExchangeRateModelImpl.ENTITY_CACHE_ENABLED,
			BtExchangeRateImpl.class, btExchangeRate.getPrimaryKey(),
			btExchangeRate);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S,
			new Object[] { btExchangeRate.getStatus() }, btExchangeRate);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_F_S_S,
			new Object[] {
				btExchangeRate.getFirstCurrency(),
				btExchangeRate.getSecondCurrency(), btExchangeRate.getStatus()
			}, btExchangeRate);

		btExchangeRate.resetOriginalValues();
	}

	/**
	 * Caches the bt exchange rates in the entity cache if it is enabled.
	 *
	 * @param btExchangeRates the bt exchange rates
	 */
	@Override
	public void cacheResult(List<BtExchangeRate> btExchangeRates) {
		for (BtExchangeRate btExchangeRate : btExchangeRates) {
			if (EntityCacheUtil.getResult(
						BtExchangeRateModelImpl.ENTITY_CACHE_ENABLED,
						BtExchangeRateImpl.class, btExchangeRate.getPrimaryKey()) == null) {
				cacheResult(btExchangeRate);
			}
			else {
				btExchangeRate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bt exchange rates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BtExchangeRateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BtExchangeRateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bt exchange rate.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BtExchangeRate btExchangeRate) {
		EntityCacheUtil.removeResult(BtExchangeRateModelImpl.ENTITY_CACHE_ENABLED,
			BtExchangeRateImpl.class, btExchangeRate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(btExchangeRate);
	}

	@Override
	public void clearCache(List<BtExchangeRate> btExchangeRates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BtExchangeRate btExchangeRate : btExchangeRates) {
			EntityCacheUtil.removeResult(BtExchangeRateModelImpl.ENTITY_CACHE_ENABLED,
				BtExchangeRateImpl.class, btExchangeRate.getPrimaryKey());

			clearUniqueFindersCache(btExchangeRate);
		}
	}

	protected void cacheUniqueFindersCache(BtExchangeRate btExchangeRate) {
		if (btExchangeRate.isNew()) {
			Object[] args = new Object[] { btExchangeRate.getStatus() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_S, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S, args,
				btExchangeRate);

			args = new Object[] {
					btExchangeRate.getFirstCurrency(),
					btExchangeRate.getSecondCurrency(),
					btExchangeRate.getStatus()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_F_S_S, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_F_S_S, args,
				btExchangeRate);
		}
		else {
			BtExchangeRateModelImpl btExchangeRateModelImpl = (BtExchangeRateModelImpl)btExchangeRate;

			if ((btExchangeRateModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { btExchangeRate.getStatus() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_S, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_S, args,
					btExchangeRate);
			}

			if ((btExchangeRateModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_F_S_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						btExchangeRate.getFirstCurrency(),
						btExchangeRate.getSecondCurrency(),
						btExchangeRate.getStatus()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_F_S_S, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_F_S_S, args,
					btExchangeRate);
			}
		}
	}

	protected void clearUniqueFindersCache(BtExchangeRate btExchangeRate) {
		BtExchangeRateModelImpl btExchangeRateModelImpl = (BtExchangeRateModelImpl)btExchangeRate;

		Object[] args = new Object[] { btExchangeRate.getStatus() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_S, args);

		if ((btExchangeRateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_S.getColumnBitmask()) != 0) {
			args = new Object[] { btExchangeRateModelImpl.getOriginalStatus() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_S, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_S, args);
		}

		args = new Object[] {
				btExchangeRate.getFirstCurrency(),
				btExchangeRate.getSecondCurrency(), btExchangeRate.getStatus()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_F_S_S, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_F_S_S, args);

		if ((btExchangeRateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_F_S_S.getColumnBitmask()) != 0) {
			args = new Object[] {
					btExchangeRateModelImpl.getOriginalFirstCurrency(),
					btExchangeRateModelImpl.getOriginalSecondCurrency(),
					btExchangeRateModelImpl.getOriginalStatus()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_F_S_S, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_F_S_S, args);
		}
	}

	/**
	 * Creates a new bt exchange rate with the primary key. Does not add the bt exchange rate to the database.
	 *
	 * @param btExchangeRateId the primary key for the new bt exchange rate
	 * @return the new bt exchange rate
	 */
	@Override
	public BtExchangeRate create(long btExchangeRateId) {
		BtExchangeRate btExchangeRate = new BtExchangeRateImpl();

		btExchangeRate.setNew(true);
		btExchangeRate.setPrimaryKey(btExchangeRateId);

		return btExchangeRate;
	}

	/**
	 * Removes the bt exchange rate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param btExchangeRateId the primary key of the bt exchange rate
	 * @return the bt exchange rate that was removed
	 * @throws com.business.trip.NoSuchBtExchangeRateException if a bt exchange rate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtExchangeRate remove(long btExchangeRateId)
		throws NoSuchBtExchangeRateException, SystemException {
		return remove((Serializable)btExchangeRateId);
	}

	/**
	 * Removes the bt exchange rate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bt exchange rate
	 * @return the bt exchange rate that was removed
	 * @throws com.business.trip.NoSuchBtExchangeRateException if a bt exchange rate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtExchangeRate remove(Serializable primaryKey)
		throws NoSuchBtExchangeRateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BtExchangeRate btExchangeRate = (BtExchangeRate)session.get(BtExchangeRateImpl.class,
					primaryKey);

			if (btExchangeRate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBtExchangeRateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(btExchangeRate);
		}
		catch (NoSuchBtExchangeRateException nsee) {
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
	protected BtExchangeRate removeImpl(BtExchangeRate btExchangeRate)
		throws SystemException {
		btExchangeRate = toUnwrappedModel(btExchangeRate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(btExchangeRate)) {
				btExchangeRate = (BtExchangeRate)session.get(BtExchangeRateImpl.class,
						btExchangeRate.getPrimaryKeyObj());
			}

			if (btExchangeRate != null) {
				session.delete(btExchangeRate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (btExchangeRate != null) {
			clearCache(btExchangeRate);
		}

		return btExchangeRate;
	}

	@Override
	public BtExchangeRate updateImpl(
		com.business.trip.model.BtExchangeRate btExchangeRate)
		throws SystemException {
		btExchangeRate = toUnwrappedModel(btExchangeRate);

		boolean isNew = btExchangeRate.isNew();

		Session session = null;

		try {
			session = openSession();

			if (btExchangeRate.isNew()) {
				session.save(btExchangeRate);

				btExchangeRate.setNew(false);
			}
			else {
				session.merge(btExchangeRate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !BtExchangeRateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(BtExchangeRateModelImpl.ENTITY_CACHE_ENABLED,
			BtExchangeRateImpl.class, btExchangeRate.getPrimaryKey(),
			btExchangeRate);

		clearUniqueFindersCache(btExchangeRate);
		cacheUniqueFindersCache(btExchangeRate);

		return btExchangeRate;
	}

	protected BtExchangeRate toUnwrappedModel(BtExchangeRate btExchangeRate) {
		if (btExchangeRate instanceof BtExchangeRateImpl) {
			return btExchangeRate;
		}

		BtExchangeRateImpl btExchangeRateImpl = new BtExchangeRateImpl();

		btExchangeRateImpl.setNew(btExchangeRate.isNew());
		btExchangeRateImpl.setPrimaryKey(btExchangeRate.getPrimaryKey());

		btExchangeRateImpl.setBtExchangeRateId(btExchangeRate.getBtExchangeRateId());
		btExchangeRateImpl.setFirstCurrency(btExchangeRate.getFirstCurrency());
		btExchangeRateImpl.setSecondCurrency(btExchangeRate.getSecondCurrency());
		btExchangeRateImpl.setFirToSecExchangeRate(btExchangeRate.getFirToSecExchangeRate());
		btExchangeRateImpl.setSecToFirExchangeRate(btExchangeRate.getSecToFirExchangeRate());
		btExchangeRateImpl.setUserId(btExchangeRate.getUserId());
		btExchangeRateImpl.setUserName(btExchangeRate.getUserName());
		btExchangeRateImpl.setCreateDate(btExchangeRate.getCreateDate());
		btExchangeRateImpl.setModifiedDate(btExchangeRate.getModifiedDate());
		btExchangeRateImpl.setStatus(btExchangeRate.getStatus());

		return btExchangeRateImpl;
	}

	/**
	 * Returns the bt exchange rate with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bt exchange rate
	 * @return the bt exchange rate
	 * @throws com.business.trip.NoSuchBtExchangeRateException if a bt exchange rate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtExchangeRate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBtExchangeRateException, SystemException {
		BtExchangeRate btExchangeRate = fetchByPrimaryKey(primaryKey);

		if (btExchangeRate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBtExchangeRateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return btExchangeRate;
	}

	/**
	 * Returns the bt exchange rate with the primary key or throws a {@link com.business.trip.NoSuchBtExchangeRateException} if it could not be found.
	 *
	 * @param btExchangeRateId the primary key of the bt exchange rate
	 * @return the bt exchange rate
	 * @throws com.business.trip.NoSuchBtExchangeRateException if a bt exchange rate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtExchangeRate findByPrimaryKey(long btExchangeRateId)
		throws NoSuchBtExchangeRateException, SystemException {
		return findByPrimaryKey((Serializable)btExchangeRateId);
	}

	/**
	 * Returns the bt exchange rate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bt exchange rate
	 * @return the bt exchange rate, or <code>null</code> if a bt exchange rate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtExchangeRate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BtExchangeRate btExchangeRate = (BtExchangeRate)EntityCacheUtil.getResult(BtExchangeRateModelImpl.ENTITY_CACHE_ENABLED,
				BtExchangeRateImpl.class, primaryKey);

		if (btExchangeRate == _nullBtExchangeRate) {
			return null;
		}

		if (btExchangeRate == null) {
			Session session = null;

			try {
				session = openSession();

				btExchangeRate = (BtExchangeRate)session.get(BtExchangeRateImpl.class,
						primaryKey);

				if (btExchangeRate != null) {
					cacheResult(btExchangeRate);
				}
				else {
					EntityCacheUtil.putResult(BtExchangeRateModelImpl.ENTITY_CACHE_ENABLED,
						BtExchangeRateImpl.class, primaryKey,
						_nullBtExchangeRate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BtExchangeRateModelImpl.ENTITY_CACHE_ENABLED,
					BtExchangeRateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return btExchangeRate;
	}

	/**
	 * Returns the bt exchange rate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param btExchangeRateId the primary key of the bt exchange rate
	 * @return the bt exchange rate, or <code>null</code> if a bt exchange rate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtExchangeRate fetchByPrimaryKey(long btExchangeRateId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)btExchangeRateId);
	}

	/**
	 * Returns all the bt exchange rates.
	 *
	 * @return the bt exchange rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtExchangeRate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bt exchange rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtExchangeRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bt exchange rates
	 * @param end the upper bound of the range of bt exchange rates (not inclusive)
	 * @return the range of bt exchange rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtExchangeRate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt exchange rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtExchangeRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bt exchange rates
	 * @param end the upper bound of the range of bt exchange rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bt exchange rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtExchangeRate> findAll(int start, int end,
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

		List<BtExchangeRate> list = (List<BtExchangeRate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BTEXCHANGERATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BTEXCHANGERATE;

				if (pagination) {
					sql = sql.concat(BtExchangeRateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BtExchangeRate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtExchangeRate>(list);
				}
				else {
					list = (List<BtExchangeRate>)QueryUtil.list(q,
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
	 * Removes all the bt exchange rates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BtExchangeRate btExchangeRate : findAll()) {
			remove(btExchangeRate);
		}
	}

	/**
	 * Returns the number of bt exchange rates.
	 *
	 * @return the number of bt exchange rates
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

				Query q = session.createQuery(_SQL_COUNT_BTEXCHANGERATE);

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
	 * Initializes the bt exchange rate persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.business.trip.model.BtExchangeRate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BtExchangeRate>> listenersList = new ArrayList<ModelListener<BtExchangeRate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BtExchangeRate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BtExchangeRateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BTEXCHANGERATE = "SELECT btExchangeRate FROM BtExchangeRate btExchangeRate";
	private static final String _SQL_SELECT_BTEXCHANGERATE_WHERE = "SELECT btExchangeRate FROM BtExchangeRate btExchangeRate WHERE ";
	private static final String _SQL_COUNT_BTEXCHANGERATE = "SELECT COUNT(btExchangeRate) FROM BtExchangeRate btExchangeRate";
	private static final String _SQL_COUNT_BTEXCHANGERATE_WHERE = "SELECT COUNT(btExchangeRate) FROM BtExchangeRate btExchangeRate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "btExchangeRate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BtExchangeRate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No BtExchangeRate exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BtExchangeRatePersistenceImpl.class);
	private static BtExchangeRate _nullBtExchangeRate = new BtExchangeRateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BtExchangeRate> toCacheModel() {
				return _nullBtExchangeRateCacheModel;
			}
		};

	private static CacheModel<BtExchangeRate> _nullBtExchangeRateCacheModel = new CacheModel<BtExchangeRate>() {
			@Override
			public BtExchangeRate toEntityModel() {
				return _nullBtExchangeRate;
			}
		};
}