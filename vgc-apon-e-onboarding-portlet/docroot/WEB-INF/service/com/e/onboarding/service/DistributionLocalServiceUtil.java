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

package com.e.onboarding.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Distribution. This utility wraps
 * {@link com.e.onboarding.service.impl.DistributionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author sanguine
 * @see DistributionLocalService
 * @see com.e.onboarding.service.base.DistributionLocalServiceBaseImpl
 * @see com.e.onboarding.service.impl.DistributionLocalServiceImpl
 * @generated
 */
public class DistributionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.e.onboarding.service.impl.DistributionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the distribution to the database. Also notifies the appropriate model listeners.
	*
	* @param distribution the distribution
	* @return the distribution that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.Distribution addDistribution(
		com.e.onboarding.model.Distribution distribution)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDistribution(distribution);
	}

	/**
	* Creates a new distribution with the primary key. Does not add the distribution to the database.
	*
	* @param distributionId the primary key for the new distribution
	* @return the new distribution
	*/
	public static com.e.onboarding.model.Distribution createDistribution(
		long distributionId) {
		return getService().createDistribution(distributionId);
	}

	/**
	* Deletes the distribution with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param distributionId the primary key of the distribution
	* @return the distribution that was removed
	* @throws PortalException if a distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.Distribution deleteDistribution(
		long distributionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDistribution(distributionId);
	}

	/**
	* Deletes the distribution from the database. Also notifies the appropriate model listeners.
	*
	* @param distribution the distribution
	* @return the distribution that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.Distribution deleteDistribution(
		com.e.onboarding.model.Distribution distribution)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteDistribution(distribution);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.onboarding.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.onboarding.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.e.onboarding.model.Distribution fetchDistribution(
		long distributionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchDistribution(distributionId);
	}

	/**
	* Returns the distribution with the primary key.
	*
	* @param distributionId the primary key of the distribution
	* @return the distribution
	* @throws PortalException if a distribution with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.Distribution getDistribution(
		long distributionId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getDistribution(distributionId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the distributions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.e.onboarding.model.impl.DistributionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of distributions
	* @param end the upper bound of the range of distributions (not inclusive)
	* @return the range of distributions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.e.onboarding.model.Distribution> getDistributions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDistributions(start, end);
	}

	/**
	* Returns the number of distributions.
	*
	* @return the number of distributions
	* @throws SystemException if a system exception occurred
	*/
	public static int getDistributionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getDistributionsCount();
	}

	/**
	* Updates the distribution in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param distribution the distribution
	* @return the distribution that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.e.onboarding.model.Distribution updateDistribution(
		com.e.onboarding.model.Distribution distribution)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateDistribution(distribution);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.e.onboarding.model.Distribution addDistrition(
		com.e.onboarding.model.Distribution distribution,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addDistrition(distribution, serviceContext);
	}

	public static com.e.onboarding.model.Distribution save(
		java.lang.String emailAddress, java.lang.String name,
		java.lang.String comments, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().save(emailAddress, name, comments, type);
	}

	public static java.util.List<com.e.onboarding.model.Distribution> findByC_N_E_T(
		long companyId, java.lang.String name, java.lang.String emailAddress,
		java.lang.String type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findByC_N_E_T(companyId, name, emailAddress, type, start,
			end);
	}

	public static java.util.List<com.e.onboarding.model.Distribution> findByC_N_E_T(
		long companyId, java.lang.String name, java.lang.String emailAddress,
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByC_N_E_T(companyId, name, emailAddress, type);
	}

	public static java.util.List<com.e.onboarding.model.Distribution> findByC_T(
		long companyId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByC_T(companyId, type);
	}

	public static int findCountByC_T(long companyId, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findCountByC_T(companyId, type);
	}

	public static java.util.List<com.e.onboarding.model.Distribution> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll();
	}

	public static java.lang.String[] findAllEmailAddresses(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAllEmailAddresses(type);
	}

	public static java.util.List<com.e.onboarding.model.Distribution> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findAll(start, end);
	}

	public static com.e.onboarding.model.Distribution fetchByemailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchByemailAddress(emailAddress);
	}

	public static int findCountByC_N_E_T(long companyId, java.lang.String name,
		java.lang.String emailAddress, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .findCountByC_N_E_T(companyId, name, emailAddress, type);
	}

	public static void clearService() {
		_service = null;
	}

	public static DistributionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					DistributionLocalService.class.getName());

			if (invokableLocalService instanceof DistributionLocalService) {
				_service = (DistributionLocalService)invokableLocalService;
			}
			else {
				_service = new DistributionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(DistributionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(DistributionLocalService service) {
	}

	private static DistributionLocalService _service;
}