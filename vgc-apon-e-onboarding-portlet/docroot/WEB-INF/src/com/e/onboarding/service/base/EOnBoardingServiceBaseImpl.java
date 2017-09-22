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

package com.e.onboarding.service.base;

import com.e.onboarding.model.EOnBoarding;
import com.e.onboarding.service.EOnBoardingService;
import com.e.onboarding.service.persistence.DistributionPersistence;
import com.e.onboarding.service.persistence.EOnBoardingPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the e on boarding remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.e.onboarding.service.impl.EOnBoardingServiceImpl}.
 * </p>
 *
 * @author sanguine
 * @see com.e.onboarding.service.impl.EOnBoardingServiceImpl
 * @see com.e.onboarding.service.EOnBoardingServiceUtil
 * @generated
 */
public abstract class EOnBoardingServiceBaseImpl extends BaseServiceImpl
	implements EOnBoardingService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.e.onboarding.service.EOnBoardingServiceUtil} to access the e on boarding remote service.
	 */

	/**
	 * Returns the distribution local service.
	 *
	 * @return the distribution local service
	 */
	public com.e.onboarding.service.DistributionLocalService getDistributionLocalService() {
		return distributionLocalService;
	}

	/**
	 * Sets the distribution local service.
	 *
	 * @param distributionLocalService the distribution local service
	 */
	public void setDistributionLocalService(
		com.e.onboarding.service.DistributionLocalService distributionLocalService) {
		this.distributionLocalService = distributionLocalService;
	}

	/**
	 * Returns the distribution remote service.
	 *
	 * @return the distribution remote service
	 */
	public com.e.onboarding.service.DistributionService getDistributionService() {
		return distributionService;
	}

	/**
	 * Sets the distribution remote service.
	 *
	 * @param distributionService the distribution remote service
	 */
	public void setDistributionService(
		com.e.onboarding.service.DistributionService distributionService) {
		this.distributionService = distributionService;
	}

	/**
	 * Returns the distribution persistence.
	 *
	 * @return the distribution persistence
	 */
	public DistributionPersistence getDistributionPersistence() {
		return distributionPersistence;
	}

	/**
	 * Sets the distribution persistence.
	 *
	 * @param distributionPersistence the distribution persistence
	 */
	public void setDistributionPersistence(
		DistributionPersistence distributionPersistence) {
		this.distributionPersistence = distributionPersistence;
	}

	/**
	 * Returns the e on boarding local service.
	 *
	 * @return the e on boarding local service
	 */
	public com.e.onboarding.service.EOnBoardingLocalService getEOnBoardingLocalService() {
		return eOnBoardingLocalService;
	}

	/**
	 * Sets the e on boarding local service.
	 *
	 * @param eOnBoardingLocalService the e on boarding local service
	 */
	public void setEOnBoardingLocalService(
		com.e.onboarding.service.EOnBoardingLocalService eOnBoardingLocalService) {
		this.eOnBoardingLocalService = eOnBoardingLocalService;
	}

	/**
	 * Returns the e on boarding remote service.
	 *
	 * @return the e on boarding remote service
	 */
	public com.e.onboarding.service.EOnBoardingService getEOnBoardingService() {
		return eOnBoardingService;
	}

	/**
	 * Sets the e on boarding remote service.
	 *
	 * @param eOnBoardingService the e on boarding remote service
	 */
	public void setEOnBoardingService(
		com.e.onboarding.service.EOnBoardingService eOnBoardingService) {
		this.eOnBoardingService = eOnBoardingService;
	}

	/**
	 * Returns the e on boarding persistence.
	 *
	 * @return the e on boarding persistence
	 */
	public EOnBoardingPersistence getEOnBoardingPersistence() {
		return eOnBoardingPersistence;
	}

	/**
	 * Sets the e on boarding persistence.
	 *
	 * @param eOnBoardingPersistence the e on boarding persistence
	 */
	public void setEOnBoardingPersistence(
		EOnBoardingPersistence eOnBoardingPersistence) {
		this.eOnBoardingPersistence = eOnBoardingPersistence;
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
	}

	public void destroy() {
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
		return EOnBoarding.class;
	}

	protected String getModelClassName() {
		return EOnBoarding.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = eOnBoardingPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.e.onboarding.service.DistributionLocalService.class)
	protected com.e.onboarding.service.DistributionLocalService distributionLocalService;
	@BeanReference(type = com.e.onboarding.service.DistributionService.class)
	protected com.e.onboarding.service.DistributionService distributionService;
	@BeanReference(type = DistributionPersistence.class)
	protected DistributionPersistence distributionPersistence;
	@BeanReference(type = com.e.onboarding.service.EOnBoardingLocalService.class)
	protected com.e.onboarding.service.EOnBoardingLocalService eOnBoardingLocalService;
	@BeanReference(type = com.e.onboarding.service.EOnBoardingService.class)
	protected com.e.onboarding.service.EOnBoardingService eOnBoardingService;
	@BeanReference(type = EOnBoardingPersistence.class)
	protected EOnBoardingPersistence eOnBoardingPersistence;
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
	private EOnBoardingServiceClpInvoker _clpInvoker = new EOnBoardingServiceClpInvoker();
}