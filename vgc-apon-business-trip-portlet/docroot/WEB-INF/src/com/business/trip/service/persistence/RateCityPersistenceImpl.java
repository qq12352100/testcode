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

import com.business.trip.NoSuchRateCityException;
import com.business.trip.model.RateCity;
import com.business.trip.model.impl.RateCityImpl;
import com.business.trip.model.impl.RateCityModelImpl;
import com.business.trip.service.persistence.RateCityPersistence;

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
import com.liferay.portal.kernel.util.SetUtil;
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
import java.util.Set;

/**
 * The persistence implementation for the rate city service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RateCityPersistence
 * @see RateCityUtil
 * @generated
 */
public class RateCityPersistenceImpl extends BasePersistenceImpl<RateCity>
	implements RateCityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RateCityUtil} to access the rate city persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RateCityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RateCityModelImpl.ENTITY_CACHE_ENABLED,
			RateCityModelImpl.FINDER_CACHE_ENABLED, RateCityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RateCityModelImpl.ENTITY_CACHE_ENABLED,
			RateCityModelImpl.FINDER_CACHE_ENABLED, RateCityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RateCityModelImpl.ENTITY_CACHE_ENABLED,
			RateCityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public RateCityPersistenceImpl() {
		setModelClass(RateCity.class);
	}

	/**
	 * Caches the rate city in the entity cache if it is enabled.
	 *
	 * @param rateCity the rate city
	 */
	@Override
	public void cacheResult(RateCity rateCity) {
		EntityCacheUtil.putResult(RateCityModelImpl.ENTITY_CACHE_ENABLED,
			RateCityImpl.class, rateCity.getPrimaryKey(), rateCity);

		rateCity.resetOriginalValues();
	}

	/**
	 * Caches the rate cities in the entity cache if it is enabled.
	 *
	 * @param rateCities the rate cities
	 */
	@Override
	public void cacheResult(List<RateCity> rateCities) {
		for (RateCity rateCity : rateCities) {
			if (EntityCacheUtil.getResult(
						RateCityModelImpl.ENTITY_CACHE_ENABLED,
						RateCityImpl.class, rateCity.getPrimaryKey()) == null) {
				cacheResult(rateCity);
			}
			else {
				rateCity.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rate cities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RateCityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RateCityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rate city.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RateCity rateCity) {
		EntityCacheUtil.removeResult(RateCityModelImpl.ENTITY_CACHE_ENABLED,
			RateCityImpl.class, rateCity.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RateCity> rateCities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RateCity rateCity : rateCities) {
			EntityCacheUtil.removeResult(RateCityModelImpl.ENTITY_CACHE_ENABLED,
				RateCityImpl.class, rateCity.getPrimaryKey());
		}
	}

	/**
	 * Creates a new rate city with the primary key. Does not add the rate city to the database.
	 *
	 * @param ratecityId the primary key for the new rate city
	 * @return the new rate city
	 */
	@Override
	public RateCity create(long ratecityId) {
		RateCity rateCity = new RateCityImpl();

		rateCity.setNew(true);
		rateCity.setPrimaryKey(ratecityId);

		return rateCity;
	}

	/**
	 * Removes the rate city with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ratecityId the primary key of the rate city
	 * @return the rate city that was removed
	 * @throws com.business.trip.NoSuchRateCityException if a rate city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateCity remove(long ratecityId)
		throws NoSuchRateCityException, SystemException {
		return remove((Serializable)ratecityId);
	}

	/**
	 * Removes the rate city with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rate city
	 * @return the rate city that was removed
	 * @throws com.business.trip.NoSuchRateCityException if a rate city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateCity remove(Serializable primaryKey)
		throws NoSuchRateCityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			RateCity rateCity = (RateCity)session.get(RateCityImpl.class,
					primaryKey);

			if (rateCity == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRateCityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(rateCity);
		}
		catch (NoSuchRateCityException nsee) {
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
	protected RateCity removeImpl(RateCity rateCity) throws SystemException {
		rateCity = toUnwrappedModel(rateCity);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rateCity)) {
				rateCity = (RateCity)session.get(RateCityImpl.class,
						rateCity.getPrimaryKeyObj());
			}

			if (rateCity != null) {
				session.delete(rateCity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rateCity != null) {
			clearCache(rateCity);
		}

		return rateCity;
	}

	@Override
	public RateCity updateImpl(com.business.trip.model.RateCity rateCity)
		throws SystemException {
		rateCity = toUnwrappedModel(rateCity);

		boolean isNew = rateCity.isNew();

		Session session = null;

		try {
			session = openSession();

			if (rateCity.isNew()) {
				session.save(rateCity);

				rateCity.setNew(false);
			}
			else {
				session.merge(rateCity);
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

		EntityCacheUtil.putResult(RateCityModelImpl.ENTITY_CACHE_ENABLED,
			RateCityImpl.class, rateCity.getPrimaryKey(), rateCity);

		return rateCity;
	}

	protected RateCity toUnwrappedModel(RateCity rateCity) {
		if (rateCity instanceof RateCityImpl) {
			return rateCity;
		}

		RateCityImpl rateCityImpl = new RateCityImpl();

		rateCityImpl.setNew(rateCity.isNew());
		rateCityImpl.setPrimaryKey(rateCity.getPrimaryKey());

		rateCityImpl.setRatecityId(rateCity.getRatecityId());
		rateCityImpl.setAreaName(rateCity.getAreaName());
		rateCityImpl.setRateOfDma(rateCity.getRateOfDma());
		rateCityImpl.setCurrency(rateCity.getCurrency());
		rateCityImpl.setParentId(rateCity.getParentId());

		return rateCityImpl;
	}

	/**
	 * Returns the rate city with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the rate city
	 * @return the rate city
	 * @throws com.business.trip.NoSuchRateCityException if a rate city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateCity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRateCityException, SystemException {
		RateCity rateCity = fetchByPrimaryKey(primaryKey);

		if (rateCity == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRateCityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return rateCity;
	}

	/**
	 * Returns the rate city with the primary key or throws a {@link com.business.trip.NoSuchRateCityException} if it could not be found.
	 *
	 * @param ratecityId the primary key of the rate city
	 * @return the rate city
	 * @throws com.business.trip.NoSuchRateCityException if a rate city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateCity findByPrimaryKey(long ratecityId)
		throws NoSuchRateCityException, SystemException {
		return findByPrimaryKey((Serializable)ratecityId);
	}

	/**
	 * Returns the rate city with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rate city
	 * @return the rate city, or <code>null</code> if a rate city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateCity fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		RateCity rateCity = (RateCity)EntityCacheUtil.getResult(RateCityModelImpl.ENTITY_CACHE_ENABLED,
				RateCityImpl.class, primaryKey);

		if (rateCity == _nullRateCity) {
			return null;
		}

		if (rateCity == null) {
			Session session = null;

			try {
				session = openSession();

				rateCity = (RateCity)session.get(RateCityImpl.class, primaryKey);

				if (rateCity != null) {
					cacheResult(rateCity);
				}
				else {
					EntityCacheUtil.putResult(RateCityModelImpl.ENTITY_CACHE_ENABLED,
						RateCityImpl.class, primaryKey, _nullRateCity);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RateCityModelImpl.ENTITY_CACHE_ENABLED,
					RateCityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rateCity;
	}

	/**
	 * Returns the rate city with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ratecityId the primary key of the rate city
	 * @return the rate city, or <code>null</code> if a rate city with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public RateCity fetchByPrimaryKey(long ratecityId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)ratecityId);
	}

	/**
	 * Returns all the rate cities.
	 *
	 * @return the rate cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RateCity> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rate cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.RateCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rate cities
	 * @param end the upper bound of the range of rate cities (not inclusive)
	 * @return the range of rate cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RateCity> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rate cities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.business.trip.model.impl.RateCityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rate cities
	 * @param end the upper bound of the range of rate cities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rate cities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<RateCity> findAll(int start, int end,
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

		List<RateCity> list = (List<RateCity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RATECITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RATECITY;

				if (pagination) {
					sql = sql.concat(RateCityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<RateCity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<RateCity>(list);
				}
				else {
					list = (List<RateCity>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the rate cities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (RateCity rateCity : findAll()) {
			remove(rateCity);
		}
	}

	/**
	 * Returns the number of rate cities.
	 *
	 * @return the number of rate cities
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

				Query q = session.createQuery(_SQL_COUNT_RATECITY);

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
	 * Initializes the rate city persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.business.trip.model.RateCity")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<RateCity>> listenersList = new ArrayList<ModelListener<RateCity>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<RateCity>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RateCityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RATECITY = "SELECT rateCity FROM RateCity rateCity";
	private static final String _SQL_COUNT_RATECITY = "SELECT COUNT(rateCity) FROM RateCity rateCity";
	private static final String _ORDER_BY_ENTITY_ALIAS = "rateCity.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RateCity exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RateCityPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"currency"
			});
	private static RateCity _nullRateCity = new RateCityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<RateCity> toCacheModel() {
				return _nullRateCityCacheModel;
			}
		};

	private static CacheModel<RateCity> _nullRateCityCacheModel = new CacheModel<RateCity>() {
			@Override
			public RateCity toEntityModel() {
				return _nullRateCity;
			}
		};
}