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

package com.e.leave.service.persistence;

import com.e.leave.NoSuchELeaveInfoException;
import com.e.leave.model.ELeaveInfo;
import com.e.leave.model.impl.ELeaveInfoImpl;
import com.e.leave.model.impl.ELeaveInfoModelImpl;

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
 * The persistence implementation for the e leave info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author EZEYIFE
 * @see ELeaveInfoPersistence
 * @see ELeaveInfoUtil
 * @generated
 */
public class ELeaveInfoPersistenceImpl extends BasePersistenceImpl<ELeaveInfo>
	implements ELeaveInfoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ELeaveInfoUtil} to access the e leave info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ELeaveInfoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ELeaveInfoModelImpl.ENTITY_CACHE_ENABLED,
			ELeaveInfoModelImpl.FINDER_CACHE_ENABLED, ELeaveInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ELeaveInfoModelImpl.ENTITY_CACHE_ENABLED,
			ELeaveInfoModelImpl.FINDER_CACHE_ENABLED, ELeaveInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ELeaveInfoModelImpl.ENTITY_CACHE_ENABLED,
			ELeaveInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ELeaveInfoPersistenceImpl() {
		setModelClass(ELeaveInfo.class);
	}

	/**
	 * Caches the e leave info in the entity cache if it is enabled.
	 *
	 * @param eLeaveInfo the e leave info
	 */
	@Override
	public void cacheResult(ELeaveInfo eLeaveInfo) {
		EntityCacheUtil.putResult(ELeaveInfoModelImpl.ENTITY_CACHE_ENABLED,
			ELeaveInfoImpl.class, eLeaveInfo.getPrimaryKey(), eLeaveInfo);

		eLeaveInfo.resetOriginalValues();
	}

	/**
	 * Caches the e leave infos in the entity cache if it is enabled.
	 *
	 * @param eLeaveInfos the e leave infos
	 */
	@Override
	public void cacheResult(List<ELeaveInfo> eLeaveInfos) {
		for (ELeaveInfo eLeaveInfo : eLeaveInfos) {
			if (EntityCacheUtil.getResult(
						ELeaveInfoModelImpl.ENTITY_CACHE_ENABLED,
						ELeaveInfoImpl.class, eLeaveInfo.getPrimaryKey()) == null) {
				cacheResult(eLeaveInfo);
			}
			else {
				eLeaveInfo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all e leave infos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ELeaveInfoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ELeaveInfoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the e leave info.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ELeaveInfo eLeaveInfo) {
		EntityCacheUtil.removeResult(ELeaveInfoModelImpl.ENTITY_CACHE_ENABLED,
			ELeaveInfoImpl.class, eLeaveInfo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ELeaveInfo> eLeaveInfos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ELeaveInfo eLeaveInfo : eLeaveInfos) {
			EntityCacheUtil.removeResult(ELeaveInfoModelImpl.ENTITY_CACHE_ENABLED,
				ELeaveInfoImpl.class, eLeaveInfo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new e leave info with the primary key. Does not add the e leave info to the database.
	 *
	 * @param eLeaveInfoId the primary key for the new e leave info
	 * @return the new e leave info
	 */
	@Override
	public ELeaveInfo create(long eLeaveInfoId) {
		ELeaveInfo eLeaveInfo = new ELeaveInfoImpl();

		eLeaveInfo.setNew(true);
		eLeaveInfo.setPrimaryKey(eLeaveInfoId);

		return eLeaveInfo;
	}

	/**
	 * Removes the e leave info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eLeaveInfoId the primary key of the e leave info
	 * @return the e leave info that was removed
	 * @throws com.e.leave.NoSuchELeaveInfoException if a e leave info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ELeaveInfo remove(long eLeaveInfoId)
		throws NoSuchELeaveInfoException, SystemException {
		return remove((Serializable)eLeaveInfoId);
	}

	/**
	 * Removes the e leave info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the e leave info
	 * @return the e leave info that was removed
	 * @throws com.e.leave.NoSuchELeaveInfoException if a e leave info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ELeaveInfo remove(Serializable primaryKey)
		throws NoSuchELeaveInfoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ELeaveInfo eLeaveInfo = (ELeaveInfo)session.get(ELeaveInfoImpl.class,
					primaryKey);

			if (eLeaveInfo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchELeaveInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(eLeaveInfo);
		}
		catch (NoSuchELeaveInfoException nsee) {
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
	protected ELeaveInfo removeImpl(ELeaveInfo eLeaveInfo)
		throws SystemException {
		eLeaveInfo = toUnwrappedModel(eLeaveInfo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(eLeaveInfo)) {
				eLeaveInfo = (ELeaveInfo)session.get(ELeaveInfoImpl.class,
						eLeaveInfo.getPrimaryKeyObj());
			}

			if (eLeaveInfo != null) {
				session.delete(eLeaveInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (eLeaveInfo != null) {
			clearCache(eLeaveInfo);
		}

		return eLeaveInfo;
	}

	@Override
	public ELeaveInfo updateImpl(com.e.leave.model.ELeaveInfo eLeaveInfo)
		throws SystemException {
		eLeaveInfo = toUnwrappedModel(eLeaveInfo);

		boolean isNew = eLeaveInfo.isNew();

		Session session = null;

		try {
			session = openSession();

			if (eLeaveInfo.isNew()) {
				session.save(eLeaveInfo);

				eLeaveInfo.setNew(false);
			}
			else {
				session.merge(eLeaveInfo);
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

		EntityCacheUtil.putResult(ELeaveInfoModelImpl.ENTITY_CACHE_ENABLED,
			ELeaveInfoImpl.class, eLeaveInfo.getPrimaryKey(), eLeaveInfo);

		return eLeaveInfo;
	}

	protected ELeaveInfo toUnwrappedModel(ELeaveInfo eLeaveInfo) {
		if (eLeaveInfo instanceof ELeaveInfoImpl) {
			return eLeaveInfo;
		}

		ELeaveInfoImpl eLeaveInfoImpl = new ELeaveInfoImpl();

		eLeaveInfoImpl.setNew(eLeaveInfo.isNew());
		eLeaveInfoImpl.setPrimaryKey(eLeaveInfo.getPrimaryKey());

		eLeaveInfoImpl.setELeaveInfoId(eLeaveInfo.getELeaveInfoId());
		eLeaveInfoImpl.setELeaveId(eLeaveInfo.getELeaveId());
		eLeaveInfoImpl.setStartDate(eLeaveInfo.getStartDate());
		eLeaveInfoImpl.setEndDate(eLeaveInfo.getEndDate());
		eLeaveInfoImpl.setStartTime(eLeaveInfo.getStartTime());
		eLeaveInfoImpl.setEndTime(eLeaveInfo.getEndTime());
		eLeaveInfoImpl.setTypeOfLeave(eLeaveInfo.getTypeOfLeave());
		eLeaveInfoImpl.setTypeOfLeaveId(eLeaveInfo.getTypeOfLeaveId());
		eLeaveInfoImpl.setAbsenceDays(eLeaveInfo.getAbsenceDays());
		eLeaveInfoImpl.setRemark(eLeaveInfo.getRemark());

		return eLeaveInfoImpl;
	}

	/**
	 * Returns the e leave info with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the e leave info
	 * @return the e leave info
	 * @throws com.e.leave.NoSuchELeaveInfoException if a e leave info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ELeaveInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchELeaveInfoException, SystemException {
		ELeaveInfo eLeaveInfo = fetchByPrimaryKey(primaryKey);

		if (eLeaveInfo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchELeaveInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return eLeaveInfo;
	}

	/**
	 * Returns the e leave info with the primary key or throws a {@link com.e.leave.NoSuchELeaveInfoException} if it could not be found.
	 *
	 * @param eLeaveInfoId the primary key of the e leave info
	 * @return the e leave info
	 * @throws com.e.leave.NoSuchELeaveInfoException if a e leave info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ELeaveInfo findByPrimaryKey(long eLeaveInfoId)
		throws NoSuchELeaveInfoException, SystemException {
		return findByPrimaryKey((Serializable)eLeaveInfoId);
	}

	/**
	 * Returns the e leave info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the e leave info
	 * @return the e leave info, or <code>null</code> if a e leave info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ELeaveInfo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ELeaveInfo eLeaveInfo = (ELeaveInfo)EntityCacheUtil.getResult(ELeaveInfoModelImpl.ENTITY_CACHE_ENABLED,
				ELeaveInfoImpl.class, primaryKey);

		if (eLeaveInfo == _nullELeaveInfo) {
			return null;
		}

		if (eLeaveInfo == null) {
			Session session = null;

			try {
				session = openSession();

				eLeaveInfo = (ELeaveInfo)session.get(ELeaveInfoImpl.class,
						primaryKey);

				if (eLeaveInfo != null) {
					cacheResult(eLeaveInfo);
				}
				else {
					EntityCacheUtil.putResult(ELeaveInfoModelImpl.ENTITY_CACHE_ENABLED,
						ELeaveInfoImpl.class, primaryKey, _nullELeaveInfo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ELeaveInfoModelImpl.ENTITY_CACHE_ENABLED,
					ELeaveInfoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return eLeaveInfo;
	}

	/**
	 * Returns the e leave info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eLeaveInfoId the primary key of the e leave info
	 * @return the e leave info, or <code>null</code> if a e leave info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ELeaveInfo fetchByPrimaryKey(long eLeaveInfoId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)eLeaveInfoId);
	}

	/**
	 * Returns all the e leave infos.
	 *
	 * @return the e leave infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ELeaveInfo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the e leave infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.leave.model.impl.ELeaveInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e leave infos
	 * @param end the upper bound of the range of e leave infos (not inclusive)
	 * @return the range of e leave infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ELeaveInfo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the e leave infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.leave.model.impl.ELeaveInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of e leave infos
	 * @param end the upper bound of the range of e leave infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of e leave infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ELeaveInfo> findAll(int start, int end,
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

		List<ELeaveInfo> list = (List<ELeaveInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ELEAVEINFO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ELEAVEINFO;

				if (pagination) {
					sql = sql.concat(ELeaveInfoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ELeaveInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ELeaveInfo>(list);
				}
				else {
					list = (List<ELeaveInfo>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the e leave infos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ELeaveInfo eLeaveInfo : findAll()) {
			remove(eLeaveInfo);
		}
	}

	/**
	 * Returns the number of e leave infos.
	 *
	 * @return the number of e leave infos
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

				Query q = session.createQuery(_SQL_COUNT_ELEAVEINFO);

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
	 * Initializes the e leave info persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.e.leave.model.ELeaveInfo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ELeaveInfo>> listenersList = new ArrayList<ModelListener<ELeaveInfo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ELeaveInfo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ELeaveInfoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ELEAVEINFO = "SELECT eLeaveInfo FROM ELeaveInfo eLeaveInfo";
	private static final String _SQL_COUNT_ELEAVEINFO = "SELECT COUNT(eLeaveInfo) FROM ELeaveInfo eLeaveInfo";
	private static final String _ORDER_BY_ENTITY_ALIAS = "eLeaveInfo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ELeaveInfo exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ELeaveInfoPersistenceImpl.class);
	private static ELeaveInfo _nullELeaveInfo = new ELeaveInfoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ELeaveInfo> toCacheModel() {
				return _nullELeaveInfoCacheModel;
			}
		};

	private static CacheModel<ELeaveInfo> _nullELeaveInfoCacheModel = new CacheModel<ELeaveInfo>() {
			@Override
			public ELeaveInfo toEntityModel() {
				return _nullELeaveInfo;
			}
		};
}