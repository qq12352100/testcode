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

import com.business.trip.NoSuchBtExchangeSAPRateException;
import com.business.trip.model.BtExchangeSAPRate;
import com.business.trip.model.impl.BtExchangeSAPRateImpl;
import com.business.trip.model.impl.BtExchangeSAPRateModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
 * The persistence implementation for the bt exchange s a p rate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BtExchangeSAPRatePersistence
 * @see BtExchangeSAPRateUtil
 * @generated
 */
public class BtExchangeSAPRatePersistenceImpl extends BasePersistenceImpl<BtExchangeSAPRate>
	implements BtExchangeSAPRatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link BtExchangeSAPRateUtil} to access the bt exchange s a p rate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = BtExchangeSAPRateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BtExchangeSAPRateModelImpl.ENTITY_CACHE_ENABLED,
			BtExchangeSAPRateModelImpl.FINDER_CACHE_ENABLED,
			BtExchangeSAPRateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BtExchangeSAPRateModelImpl.ENTITY_CACHE_ENABLED,
			BtExchangeSAPRateModelImpl.FINDER_CACHE_ENABLED,
			BtExchangeSAPRateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BtExchangeSAPRateModelImpl.ENTITY_CACHE_ENABLED,
			BtExchangeSAPRateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public BtExchangeSAPRatePersistenceImpl() {
		setModelClass(BtExchangeSAPRate.class);
	}

	/**
	 * Caches the bt exchange s a p rate in the entity cache if it is enabled.
	 *
	 * @param btExchangeSAPRate the bt exchange s a p rate
	 */
	@Override
	public void cacheResult(BtExchangeSAPRate btExchangeSAPRate) {
		EntityCacheUtil.putResult(BtExchangeSAPRateModelImpl.ENTITY_CACHE_ENABLED,
			BtExchangeSAPRateImpl.class, btExchangeSAPRate.getPrimaryKey(),
			btExchangeSAPRate);

		btExchangeSAPRate.resetOriginalValues();
	}

	/**
	 * Caches the bt exchange s a p rates in the entity cache if it is enabled.
	 *
	 * @param btExchangeSAPRates the bt exchange s a p rates
	 */
	@Override
	public void cacheResult(List<BtExchangeSAPRate> btExchangeSAPRates) {
		for (BtExchangeSAPRate btExchangeSAPRate : btExchangeSAPRates) {
			if (EntityCacheUtil.getResult(
						BtExchangeSAPRateModelImpl.ENTITY_CACHE_ENABLED,
						BtExchangeSAPRateImpl.class,
						btExchangeSAPRate.getPrimaryKey()) == null) {
				cacheResult(btExchangeSAPRate);
			}
			else {
				btExchangeSAPRate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all bt exchange s a p rates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(BtExchangeSAPRateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(BtExchangeSAPRateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the bt exchange s a p rate.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BtExchangeSAPRate btExchangeSAPRate) {
		EntityCacheUtil.removeResult(BtExchangeSAPRateModelImpl.ENTITY_CACHE_ENABLED,
			BtExchangeSAPRateImpl.class, btExchangeSAPRate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<BtExchangeSAPRate> btExchangeSAPRates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (BtExchangeSAPRate btExchangeSAPRate : btExchangeSAPRates) {
			EntityCacheUtil.removeResult(BtExchangeSAPRateModelImpl.ENTITY_CACHE_ENABLED,
				BtExchangeSAPRateImpl.class, btExchangeSAPRate.getPrimaryKey());
		}
	}

	/**
	 * Creates a new bt exchange s a p rate with the primary key. Does not add the bt exchange s a p rate to the database.
	 *
	 * @param btExchangeSAPRateId the primary key for the new bt exchange s a p rate
	 * @return the new bt exchange s a p rate
	 */
	@Override
	public BtExchangeSAPRate create(long btExchangeSAPRateId) {
		BtExchangeSAPRate btExchangeSAPRate = new BtExchangeSAPRateImpl();

		btExchangeSAPRate.setNew(true);
		btExchangeSAPRate.setPrimaryKey(btExchangeSAPRateId);

		return btExchangeSAPRate;
	}

	/**
	 * Removes the bt exchange s a p rate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param btExchangeSAPRateId the primary key of the bt exchange s a p rate
	 * @return the bt exchange s a p rate that was removed
	 * @throws com.business.trip.NoSuchBtExchangeSAPRateException if a bt exchange s a p rate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtExchangeSAPRate remove(long btExchangeSAPRateId)
		throws NoSuchBtExchangeSAPRateException, SystemException {
		return remove((Serializable)btExchangeSAPRateId);
	}

	/**
	 * Removes the bt exchange s a p rate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the bt exchange s a p rate
	 * @return the bt exchange s a p rate that was removed
	 * @throws com.business.trip.NoSuchBtExchangeSAPRateException if a bt exchange s a p rate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtExchangeSAPRate remove(Serializable primaryKey)
		throws NoSuchBtExchangeSAPRateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			BtExchangeSAPRate btExchangeSAPRate = (BtExchangeSAPRate)session.get(BtExchangeSAPRateImpl.class,
					primaryKey);

			if (btExchangeSAPRate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBtExchangeSAPRateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(btExchangeSAPRate);
		}
		catch (NoSuchBtExchangeSAPRateException nsee) {
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
	protected BtExchangeSAPRate removeImpl(BtExchangeSAPRate btExchangeSAPRate)
		throws SystemException {
		btExchangeSAPRate = toUnwrappedModel(btExchangeSAPRate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(btExchangeSAPRate)) {
				btExchangeSAPRate = (BtExchangeSAPRate)session.get(BtExchangeSAPRateImpl.class,
						btExchangeSAPRate.getPrimaryKeyObj());
			}

			if (btExchangeSAPRate != null) {
				session.delete(btExchangeSAPRate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (btExchangeSAPRate != null) {
			clearCache(btExchangeSAPRate);
		}

		return btExchangeSAPRate;
	}

	@Override
	public BtExchangeSAPRate updateImpl(
		com.business.trip.model.BtExchangeSAPRate btExchangeSAPRate)
		throws SystemException {
		btExchangeSAPRate = toUnwrappedModel(btExchangeSAPRate);

		boolean isNew = btExchangeSAPRate.isNew();

		Session session = null;

		try {
			session = openSession();

			if (btExchangeSAPRate.isNew()) {
				session.save(btExchangeSAPRate);

				btExchangeSAPRate.setNew(false);
			}
			else {
				session.merge(btExchangeSAPRate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(BtExchangeSAPRateModelImpl.ENTITY_CACHE_ENABLED,
			BtExchangeSAPRateImpl.class, btExchangeSAPRate.getPrimaryKey(),
			btExchangeSAPRate);

		return btExchangeSAPRate;
	}

	protected BtExchangeSAPRate toUnwrappedModel(
		BtExchangeSAPRate btExchangeSAPRate) {
		if (btExchangeSAPRate instanceof BtExchangeSAPRateImpl) {
			return btExchangeSAPRate;
		}

		BtExchangeSAPRateImpl btExchangeSAPRateImpl = new BtExchangeSAPRateImpl();

		btExchangeSAPRateImpl.setNew(btExchangeSAPRate.isNew());
		btExchangeSAPRateImpl.setPrimaryKey(btExchangeSAPRate.getPrimaryKey());

		btExchangeSAPRateImpl.setBtExchangeSAPRateId(btExchangeSAPRate.getBtExchangeSAPRateId());
		btExchangeSAPRateImpl.setFromCurrency(btExchangeSAPRate.getFromCurrency());
		btExchangeSAPRateImpl.setToCurrency(btExchangeSAPRate.getToCurrency());
		btExchangeSAPRateImpl.setCurrencyRate(btExchangeSAPRate.getCurrencyRate());
		btExchangeSAPRateImpl.setRateType(btExchangeSAPRate.getRateType());
		btExchangeSAPRateImpl.setSapDate(btExchangeSAPRate.getSapDate());
		btExchangeSAPRateImpl.setImportDate(btExchangeSAPRate.getImportDate());

		return btExchangeSAPRateImpl;
	}

	/**
	 * Returns the bt exchange s a p rate with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the bt exchange s a p rate
	 * @return the bt exchange s a p rate
	 * @throws com.business.trip.NoSuchBtExchangeSAPRateException if a bt exchange s a p rate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtExchangeSAPRate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBtExchangeSAPRateException, SystemException {
		BtExchangeSAPRate btExchangeSAPRate = fetchByPrimaryKey(primaryKey);

		if (btExchangeSAPRate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBtExchangeSAPRateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return btExchangeSAPRate;
	}

	/**
	 * Returns the bt exchange s a p rate with the primary key or throws a {@link com.business.trip.NoSuchBtExchangeSAPRateException} if it could not be found.
	 *
	 * @param btExchangeSAPRateId the primary key of the bt exchange s a p rate
	 * @return the bt exchange s a p rate
	 * @throws com.business.trip.NoSuchBtExchangeSAPRateException if a bt exchange s a p rate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtExchangeSAPRate findByPrimaryKey(long btExchangeSAPRateId)
		throws NoSuchBtExchangeSAPRateException, SystemException {
		return findByPrimaryKey((Serializable)btExchangeSAPRateId);
	}

	/**
	 * Returns the bt exchange s a p rate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the bt exchange s a p rate
	 * @return the bt exchange s a p rate, or <code>null</code> if a bt exchange s a p rate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtExchangeSAPRate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		BtExchangeSAPRate btExchangeSAPRate = (BtExchangeSAPRate)EntityCacheUtil.getResult(BtExchangeSAPRateModelImpl.ENTITY_CACHE_ENABLED,
				BtExchangeSAPRateImpl.class, primaryKey);

		if (btExchangeSAPRate == _nullBtExchangeSAPRate) {
			return null;
		}

		if (btExchangeSAPRate == null) {
			Session session = null;

			try {
				session = openSession();

				btExchangeSAPRate = (BtExchangeSAPRate)session.get(BtExchangeSAPRateImpl.class,
						primaryKey);

				if (btExchangeSAPRate != null) {
					cacheResult(btExchangeSAPRate);
				}
				else {
					EntityCacheUtil.putResult(BtExchangeSAPRateModelImpl.ENTITY_CACHE_ENABLED,
						BtExchangeSAPRateImpl.class, primaryKey,
						_nullBtExchangeSAPRate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(BtExchangeSAPRateModelImpl.ENTITY_CACHE_ENABLED,
					BtExchangeSAPRateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return btExchangeSAPRate;
	}

	/**
	 * Returns the bt exchange s a p rate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param btExchangeSAPRateId the primary key of the bt exchange s a p rate
	 * @return the bt exchange s a p rate, or <code>null</code> if a bt exchange s a p rate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public BtExchangeSAPRate fetchByPrimaryKey(long btExchangeSAPRateId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)btExchangeSAPRateId);
	}

	/**
	 * Returns all the bt exchange s a p rates.
	 *
	 * @return the bt exchange s a p rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtExchangeSAPRate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the bt exchange s a p rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtExchangeSAPRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bt exchange s a p rates
	 * @param end the upper bound of the range of bt exchange s a p rates (not inclusive)
	 * @return the range of bt exchange s a p rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtExchangeSAPRate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the bt exchange s a p rates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.BtExchangeSAPRateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of bt exchange s a p rates
	 * @param end the upper bound of the range of bt exchange s a p rates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of bt exchange s a p rates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<BtExchangeSAPRate> findAll(int start, int end,
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

		List<BtExchangeSAPRate> list = (List<BtExchangeSAPRate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_BTEXCHANGESAPRATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_BTEXCHANGESAPRATE;

				if (pagination) {
					sql = sql.concat(BtExchangeSAPRateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<BtExchangeSAPRate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<BtExchangeSAPRate>(list);
				}
				else {
					list = (List<BtExchangeSAPRate>)QueryUtil.list(q,
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
	 * Removes all the bt exchange s a p rates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (BtExchangeSAPRate btExchangeSAPRate : findAll()) {
			remove(btExchangeSAPRate);
		}
	}

	/**
	 * Returns the number of bt exchange s a p rates.
	 *
	 * @return the number of bt exchange s a p rates
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

				Query q = session.createQuery(_SQL_COUNT_BTEXCHANGESAPRATE);

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
	 * Initializes the bt exchange s a p rate persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.business.trip.model.BtExchangeSAPRate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<BtExchangeSAPRate>> listenersList = new ArrayList<ModelListener<BtExchangeSAPRate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<BtExchangeSAPRate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(BtExchangeSAPRateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_BTEXCHANGESAPRATE = "SELECT btExchangeSAPRate FROM BtExchangeSAPRate btExchangeSAPRate";
	private static final String _SQL_COUNT_BTEXCHANGESAPRATE = "SELECT COUNT(btExchangeSAPRate) FROM BtExchangeSAPRate btExchangeSAPRate";
	private static final String _ORDER_BY_ENTITY_ALIAS = "btExchangeSAPRate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No BtExchangeSAPRate exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(BtExchangeSAPRatePersistenceImpl.class);
	private static BtExchangeSAPRate _nullBtExchangeSAPRate = new BtExchangeSAPRateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<BtExchangeSAPRate> toCacheModel() {
				return _nullBtExchangeSAPRateCacheModel;
			}
		};

	private static CacheModel<BtExchangeSAPRate> _nullBtExchangeSAPRateCacheModel =
		new CacheModel<BtExchangeSAPRate>() {
			@Override
			public BtExchangeSAPRate toEntityModel() {
				return _nullBtExchangeSAPRate;
			}
		};
}