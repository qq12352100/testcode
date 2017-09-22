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

package com.e.onboarding.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.e.onboarding.model.Distribution;
import com.e.onboarding.service.base.DistributionLocalServiceBaseImpl;

/**
 * The implementation of the distribution local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.vw.onboarding.service.DistributionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author sanguine
 * @see com.vw.onboarding.service.base.DistributionLocalServiceBaseImpl
 * @see com.vw.onboarding.service.DistributionLocalServiceUtil
 */
public class DistributionLocalServiceImpl extends
		DistributionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.vw.onboarding.service.DistributionLocalServiceUtil} to access the
	 * distribution local service.
	 */
	public Distribution addDistrition(Distribution distribution,
			ServiceContext serviceContext) throws SystemException {
		User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
		distribution.setUserId(user.getUserId());
		distribution.setUserName(user.getFullName());
		distribution.setCreateDate(new Date());
		distribution.setCompanyId(PortalUtil.getDefaultCompanyId());
		distributionPersistence.update(distribution);
		return distribution;
	}

	public Distribution save(String emailAddress,String name,String comments,String type) throws SystemException {
		long distributionId = counterLocalService.increment(Distribution.class.getName(), 1);
		Distribution distribution = distributionPersistence.create(distributionId);
		distribution.setEmailAddress(emailAddress);
		distribution.setName(name);
		distribution.setComments(comments);
		distribution.setCompanyId(PortalUtil.getDefaultCompanyId());
		distribution.setCreateDate(new Date());
		distribution.setType(type);
		distribution = distributionPersistence.update(distribution);
		return distribution;
	}
	
	public Distribution deleteDistribution(long distributionId)
			throws SystemException {
		Distribution distribution = distributionPersistence
				.fetchByPrimaryKey(distributionId);
		distributionPersistence.remove(distribution);
		return distribution;
	}

	public List<Distribution> findByC_N_E_T(long companyId, String name,
			String emailAddress,String type, int start, int end) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(Distribution.class);
		if (Validator.isNotNull(companyId)) {
			query.add(PropertyFactoryUtil.forName("companyId").eq(companyId));
		}
		if (Validator.isNotNull(name)) {
			query.add(PropertyFactoryUtil.forName("name")
					.like("%" + name + "%"));
		}
		if (Validator.isNotNull(emailAddress)) {
			query.add(PropertyFactoryUtil.forName("emailAddress").like(
					"%" + emailAddress + "%"));
		}
		if (Validator.isNotNull(type)) {
			query.add(PropertyFactoryUtil.forName("type").eq(type));
		}
		query.setLimit(start, end);
		return dynamicQuery(query);
	}

	public List<Distribution> findByC_N_E_T(long companyId, String name,
			String emailAddress,String type) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(Distribution.class);
		if (Validator.isNotNull(companyId)) {
			query.add(PropertyFactoryUtil.forName("companyId").eq(companyId));
		}
		if (Validator.isNotNull(name)) {
			query.add(PropertyFactoryUtil.forName("name")
					.like("%" + name + "%"));
		}
		if (Validator.isNotNull(emailAddress)) {
			query.add(PropertyFactoryUtil.forName("emailAddress").like(
					"%" + emailAddress + "%"));
		}
		if (Validator.isNotNull(type)) {
			query.add(PropertyFactoryUtil.forName("type").eq(type));
		}
		return dynamicQuery(query);
	}
	
	public List<Distribution> findByC_T(long companyId, String type) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(Distribution.class);
		if (Validator.isNotNull(companyId)) {
			query.add(PropertyFactoryUtil.forName("companyId").eq(companyId));
		}
		if (Validator.isNotNull(type)) {
			query.add(PropertyFactoryUtil.forName("type").eq(type));
		}
		return dynamicQuery(query);
	}
	
	public int findCountByC_T(long companyId, String type) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(Distribution.class);
		if (Validator.isNotNull(companyId)) {
			query.add(PropertyFactoryUtil.forName("companyId").eq(companyId));
		}
		if (Validator.isNotNull(type)) {
			query.add(PropertyFactoryUtil.forName("type").eq(type));
		}
		return dynamicQuery(query).size();
	}
	
	//Get the all list of distribution
	public List<Distribution> findAll() throws SystemException {
		return distributionPersistence.findAll();
	}	
	
	public String[] findAllEmailAddresses(String type) throws SystemException  {
		List<Distribution> distributions = distributionPersistence.findByType(type);
		String[] emailAddresses = new String[distributions.size()];
		for(int i=0;i<distributions.size();i++) {
			emailAddresses[i] = distributions.get(i).getEmailAddress();
		}
		return emailAddresses;
	}

	//Get the all list of distribution
	public List<Distribution> findAll(int start,int end) throws SystemException {
		return distributionPersistence.findAll(start,end);
	}
	
	public Distribution fetchByemailAddress(String emailAddress) throws SystemException {
		return distributionPersistence.fetchByemailAddress(emailAddress);
	}

	public int findCountByC_N_E_T(long companyId, String name,
			String emailAddress,String type) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil
				.forClass(Distribution.class);
		if (Validator.isNotNull(companyId)) {
			query.add(PropertyFactoryUtil.forName("companyId").eq(companyId));
		}
		if (Validator.isNotNull(name)) {
			query.add(PropertyFactoryUtil.forName("name")
					.like("%" + name + "%"));
		}
		if (Validator.isNotNull(emailAddress)) {
			query.add(PropertyFactoryUtil.forName("emailAddress").like(
					"%" + emailAddress + "%"));
		}
		if (Validator.isNotNull(type)) {
			query.add(PropertyFactoryUtil.forName("type").eq(type));
		}
		return dynamicQuery(query).size();
	}
}