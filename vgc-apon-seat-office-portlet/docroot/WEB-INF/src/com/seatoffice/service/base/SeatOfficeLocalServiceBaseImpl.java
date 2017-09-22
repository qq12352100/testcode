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

package com.seatoffice.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import com.seatoffice.model.SeatOffice;

import com.seatoffice.service.SeatOfficeLocalService;
import com.seatoffice.service.persistence.SeatOfficePersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the seat office local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.seatoffice.service.impl.SeatOfficeLocalServiceImpl}.
 * </p>
 *
 * @author Alice.zou
 * @see com.seatoffice.service.impl.SeatOfficeLocalServiceImpl
 * @see com.seatoffice.service.SeatOfficeLocalServiceUtil
 * @generated
 */
public abstract class SeatOfficeLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements SeatOfficeLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.seatoffice.service.SeatOfficeLocalServiceUtil} to access the seat office local service.
	 */

	/**
	 * Adds the seat office to the database. Also notifies the appropriate model listeners.
	 *
	 * @param seatOffice the seat office
	 * @return the seat office that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SeatOffice addSeatOffice(SeatOffice seatOffice)
		throws SystemException {
		seatOffice.setNew(true);

		return seatOfficePersistence.update(seatOffice);
	}

	/**
	 * Creates a new seat office with the primary key. Does not add the seat office to the database.
	 *
	 * @param seatId the primary key for the new seat office
	 * @return the new seat office
	 */
	@Override
	public SeatOffice createSeatOffice(long seatId) {
		return seatOfficePersistence.create(seatId);
	}

	/**
	 * Deletes the seat office with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param seatId the primary key of the seat office
	 * @return the seat office that was removed
	 * @throws PortalException if a seat office with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SeatOffice deleteSeatOffice(long seatId)
		throws PortalException, SystemException {
		return seatOfficePersistence.remove(seatId);
	}

	/**
	 * Deletes the seat office from the database. Also notifies the appropriate model listeners.
	 *
	 * @param seatOffice the seat office
	 * @return the seat office that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public SeatOffice deleteSeatOffice(SeatOffice seatOffice)
		throws SystemException {
		return seatOfficePersistence.remove(seatOffice);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(SeatOffice.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return seatOfficePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.seatoffice.model.impl.SeatOfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return seatOfficePersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.seatoffice.model.impl.SeatOfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return seatOfficePersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return seatOfficePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return seatOfficePersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public SeatOffice fetchSeatOffice(long seatId) throws SystemException {
		return seatOfficePersistence.fetchByPrimaryKey(seatId);
	}

	/**
	 * Returns the seat office with the primary key.
	 *
	 * @param seatId the primary key of the seat office
	 * @return the seat office
	 * @throws PortalException if a seat office with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SeatOffice getSeatOffice(long seatId)
		throws PortalException, SystemException {
		return seatOfficePersistence.findByPrimaryKey(seatId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return seatOfficePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the seat offices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.seatoffice.model.impl.SeatOfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of seat offices
	 * @param end the upper bound of the range of seat offices (not inclusive)
	 * @return the range of seat offices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<SeatOffice> getSeatOffices(int start, int end)
		throws SystemException {
		return seatOfficePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of seat offices.
	 *
	 * @return the number of seat offices
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getSeatOfficesCount() throws SystemException {
		return seatOfficePersistence.countAll();
	}

	/**
	 * Updates the seat office in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param seatOffice the seat office
	 * @return the seat office that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public SeatOffice updateSeatOffice(SeatOffice seatOffice)
		throws SystemException {
		return seatOfficePersistence.update(seatOffice);
	}

	/**
	 * Returns the seat office local service.
	 *
	 * @return the seat office local service
	 */
	public com.seatoffice.service.SeatOfficeLocalService getSeatOfficeLocalService() {
		return seatOfficeLocalService;
	}

	/**
	 * Sets the seat office local service.
	 *
	 * @param seatOfficeLocalService the seat office local service
	 */
	public void setSeatOfficeLocalService(
		com.seatoffice.service.SeatOfficeLocalService seatOfficeLocalService) {
		this.seatOfficeLocalService = seatOfficeLocalService;
	}

	/**
	 * Returns the seat office remote service.
	 *
	 * @return the seat office remote service
	 */
	public com.seatoffice.service.SeatOfficeService getSeatOfficeService() {
		return seatOfficeService;
	}

	/**
	 * Sets the seat office remote service.
	 *
	 * @param seatOfficeService the seat office remote service
	 */
	public void setSeatOfficeService(
		com.seatoffice.service.SeatOfficeService seatOfficeService) {
		this.seatOfficeService = seatOfficeService;
	}

	/**
	 * Returns the seat office persistence.
	 *
	 * @return the seat office persistence
	 */
	public SeatOfficePersistence getSeatOfficePersistence() {
		return seatOfficePersistence;
	}

	/**
	 * Sets the seat office persistence.
	 *
	 * @param seatOfficePersistence the seat office persistence
	 */
	public void setSeatOfficePersistence(
		SeatOfficePersistence seatOfficePersistence) {
		this.seatOfficePersistence = seatOfficePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.seatoffice.model.SeatOffice",
			seatOfficeLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.seatoffice.model.SeatOffice");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return SeatOffice.class;
	}

	protected String getModelClassName() {
		return SeatOffice.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = seatOfficePersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.seatoffice.service.SeatOfficeLocalService.class)
	protected com.seatoffice.service.SeatOfficeLocalService seatOfficeLocalService;
	@BeanReference(type = com.seatoffice.service.SeatOfficeService.class)
	protected com.seatoffice.service.SeatOfficeService seatOfficeService;
	@BeanReference(type = SeatOfficePersistence.class)
	protected SeatOfficePersistence seatOfficePersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private SeatOfficeLocalServiceClpInvoker _clpInvoker = new SeatOfficeLocalServiceClpInvoker();
}