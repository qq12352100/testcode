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

package com.company.car.service.persistence;

import com.company.car.NoSuchCompanyCarManagementException;
import com.company.car.model.CompanyCarManagement;
import com.company.car.model.impl.CompanyCarManagementImpl;
import com.company.car.model.impl.CompanyCarManagementModelImpl;

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
 * The persistence implementation for the company car management service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CompanyCarManagementPersistence
 * @see CompanyCarManagementUtil
 * @generated
 */
public class CompanyCarManagementPersistenceImpl extends BasePersistenceImpl<CompanyCarManagement>
	implements CompanyCarManagementPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CompanyCarManagementUtil} to access the company car management persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CompanyCarManagementImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CompanyCarManagementModelImpl.ENTITY_CACHE_ENABLED,
			CompanyCarManagementModelImpl.FINDER_CACHE_ENABLED,
			CompanyCarManagementImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CompanyCarManagementModelImpl.ENTITY_CACHE_ENABLED,
			CompanyCarManagementModelImpl.FINDER_CACHE_ENABLED,
			CompanyCarManagementImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CompanyCarManagementModelImpl.ENTITY_CACHE_ENABLED,
			CompanyCarManagementModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_CARNO = new FinderPath(CompanyCarManagementModelImpl.ENTITY_CACHE_ENABLED,
			CompanyCarManagementModelImpl.FINDER_CACHE_ENABLED,
			CompanyCarManagementImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchBycarNo", new String[] { String.class.getName() },
			CompanyCarManagementModelImpl.CARNO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CARNO = new FinderPath(CompanyCarManagementModelImpl.ENTITY_CACHE_ENABLED,
			CompanyCarManagementModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycarNo",
			new String[] { String.class.getName() });

	/**
	 * Returns the company car management where carNo = &#63; or throws a {@link com.company.car.NoSuchCompanyCarManagementException} if it could not be found.
	 *
	 * @param carNo the car no
	 * @return the matching company car management
	 * @throws com.company.car.NoSuchCompanyCarManagementException if a matching company car management could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompanyCarManagement findBycarNo(String carNo)
		throws NoSuchCompanyCarManagementException, SystemException {
		CompanyCarManagement companyCarManagement = fetchBycarNo(carNo);

		if (companyCarManagement == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("carNo=");
			msg.append(carNo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCompanyCarManagementException(msg.toString());
		}

		return companyCarManagement;
	}

	/**
	 * Returns the company car management where carNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param carNo the car no
	 * @return the matching company car management, or <code>null</code> if a matching company car management could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompanyCarManagement fetchBycarNo(String carNo)
		throws SystemException {
		return fetchBycarNo(carNo, true);
	}

	/**
	 * Returns the company car management where carNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param carNo the car no
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching company car management, or <code>null</code> if a matching company car management could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompanyCarManagement fetchBycarNo(String carNo,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { carNo };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CARNO,
					finderArgs, this);
		}

		if (result instanceof CompanyCarManagement) {
			CompanyCarManagement companyCarManagement = (CompanyCarManagement)result;

			if (!Validator.equals(carNo, companyCarManagement.getCarNo())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_COMPANYCARMANAGEMENT_WHERE);

			boolean bindCarNo = false;

			if (carNo == null) {
				query.append(_FINDER_COLUMN_CARNO_CARNO_1);
			}
			else if (carNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CARNO_CARNO_3);
			}
			else {
				bindCarNo = true;

				query.append(_FINDER_COLUMN_CARNO_CARNO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCarNo) {
					qPos.add(carNo);
				}

				List<CompanyCarManagement> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CARNO,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CompanyCarManagementPersistenceImpl.fetchBycarNo(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					CompanyCarManagement companyCarManagement = list.get(0);

					result = companyCarManagement;

					cacheResult(companyCarManagement);

					if ((companyCarManagement.getCarNo() == null) ||
							!companyCarManagement.getCarNo().equals(carNo)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CARNO,
							finderArgs, companyCarManagement);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CARNO,
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
			return (CompanyCarManagement)result;
		}
	}

	/**
	 * Removes the company car management where carNo = &#63; from the database.
	 *
	 * @param carNo the car no
	 * @return the company car management that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompanyCarManagement removeBycarNo(String carNo)
		throws NoSuchCompanyCarManagementException, SystemException {
		CompanyCarManagement companyCarManagement = findBycarNo(carNo);

		return remove(companyCarManagement);
	}

	/**
	 * Returns the number of company car managements where carNo = &#63;.
	 *
	 * @param carNo the car no
	 * @return the number of matching company car managements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countBycarNo(String carNo) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CARNO;

		Object[] finderArgs = new Object[] { carNo };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_COMPANYCARMANAGEMENT_WHERE);

			boolean bindCarNo = false;

			if (carNo == null) {
				query.append(_FINDER_COLUMN_CARNO_CARNO_1);
			}
			else if (carNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CARNO_CARNO_3);
			}
			else {
				bindCarNo = true;

				query.append(_FINDER_COLUMN_CARNO_CARNO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCarNo) {
					qPos.add(carNo);
				}

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

	private static final String _FINDER_COLUMN_CARNO_CARNO_1 = "companyCarManagement.carNo IS NULL";
	private static final String _FINDER_COLUMN_CARNO_CARNO_2 = "companyCarManagement.carNo = ?";
	private static final String _FINDER_COLUMN_CARNO_CARNO_3 = "(companyCarManagement.carNo IS NULL OR companyCarManagement.carNo = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_C_C = new FinderPath(CompanyCarManagementModelImpl.ENTITY_CACHE_ENABLED,
			CompanyCarManagementModelImpl.FINDER_CACHE_ENABLED,
			CompanyCarManagementImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_C_C_C",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_C =
		new FinderPath(CompanyCarManagementModelImpl.ENTITY_CACHE_ENABLED,
			CompanyCarManagementModelImpl.FINDER_CACHE_ENABLED,
			CompanyCarManagementImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_C_C_C",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			},
			CompanyCarManagementModelImpl.CARTYPE_COLUMN_BITMASK |
			CompanyCarManagementModelImpl.CONTRACTTYPE_COLUMN_BITMASK |
			CompanyCarManagementModelImpl.CARBRAND_COLUMN_BITMASK |
			CompanyCarManagementModelImpl.CARCATEGORY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C_C_C = new FinderPath(CompanyCarManagementModelImpl.ENTITY_CACHE_ENABLED,
			CompanyCarManagementModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C_C_C",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			});

	/**
	 * Returns all the company car managements where carType = &#63; and contractType = &#63; and carBrand = &#63; and carCategory = &#63;.
	 *
	 * @param carType the car type
	 * @param contractType the contract type
	 * @param carBrand the car brand
	 * @param carCategory the car category
	 * @return the matching company car managements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompanyCarManagement> findByC_C_C_C(String carType,
		String contractType, String carBrand, String carCategory)
		throws SystemException {
		return findByC_C_C_C(carType, contractType, carBrand, carCategory,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the company car managements where carType = &#63; and contractType = &#63; and carBrand = &#63; and carCategory = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.CompanyCarManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param carType the car type
	 * @param contractType the contract type
	 * @param carBrand the car brand
	 * @param carCategory the car category
	 * @param start the lower bound of the range of company car managements
	 * @param end the upper bound of the range of company car managements (not inclusive)
	 * @return the range of matching company car managements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompanyCarManagement> findByC_C_C_C(String carType,
		String contractType, String carBrand, String carCategory, int start,
		int end) throws SystemException {
		return findByC_C_C_C(carType, contractType, carBrand, carCategory,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the company car managements where carType = &#63; and contractType = &#63; and carBrand = &#63; and carCategory = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.CompanyCarManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param carType the car type
	 * @param contractType the contract type
	 * @param carBrand the car brand
	 * @param carCategory the car category
	 * @param start the lower bound of the range of company car managements
	 * @param end the upper bound of the range of company car managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching company car managements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompanyCarManagement> findByC_C_C_C(String carType,
		String contractType, String carBrand, String carCategory, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_C;
			finderArgs = new Object[] {
					carType, contractType, carBrand, carCategory
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_C_C_C;
			finderArgs = new Object[] {
					carType, contractType, carBrand, carCategory,
					
					start, end, orderByComparator
				};
		}

		List<CompanyCarManagement> list = (List<CompanyCarManagement>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CompanyCarManagement companyCarManagement : list) {
				if (!Validator.equals(carType, companyCarManagement.getCarType()) ||
						!Validator.equals(contractType,
							companyCarManagement.getContractType()) ||
						!Validator.equals(carBrand,
							companyCarManagement.getCarBrand()) ||
						!Validator.equals(carCategory,
							companyCarManagement.getCarCategory())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_COMPANYCARMANAGEMENT_WHERE);

			boolean bindCarType = false;

			if (carType == null) {
				query.append(_FINDER_COLUMN_C_C_C_C_CARTYPE_1);
			}
			else if (carType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_C_C_CARTYPE_3);
			}
			else {
				bindCarType = true;

				query.append(_FINDER_COLUMN_C_C_C_C_CARTYPE_2);
			}

			boolean bindContractType = false;

			if (contractType == null) {
				query.append(_FINDER_COLUMN_C_C_C_C_CONTRACTTYPE_1);
			}
			else if (contractType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_C_C_CONTRACTTYPE_3);
			}
			else {
				bindContractType = true;

				query.append(_FINDER_COLUMN_C_C_C_C_CONTRACTTYPE_2);
			}

			boolean bindCarBrand = false;

			if (carBrand == null) {
				query.append(_FINDER_COLUMN_C_C_C_C_CARBRAND_1);
			}
			else if (carBrand.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_C_C_CARBRAND_3);
			}
			else {
				bindCarBrand = true;

				query.append(_FINDER_COLUMN_C_C_C_C_CARBRAND_2);
			}

			boolean bindCarCategory = false;

			if (carCategory == null) {
				query.append(_FINDER_COLUMN_C_C_C_C_CARCATEGORY_1);
			}
			else if (carCategory.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_C_C_CARCATEGORY_3);
			}
			else {
				bindCarCategory = true;

				query.append(_FINDER_COLUMN_C_C_C_C_CARCATEGORY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CompanyCarManagementModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCarType) {
					qPos.add(carType);
				}

				if (bindContractType) {
					qPos.add(contractType);
				}

				if (bindCarBrand) {
					qPos.add(carBrand);
				}

				if (bindCarCategory) {
					qPos.add(carCategory);
				}

				if (!pagination) {
					list = (List<CompanyCarManagement>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CompanyCarManagement>(list);
				}
				else {
					list = (List<CompanyCarManagement>)QueryUtil.list(q,
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
	 * Returns the first company car management in the ordered set where carType = &#63; and contractType = &#63; and carBrand = &#63; and carCategory = &#63;.
	 *
	 * @param carType the car type
	 * @param contractType the contract type
	 * @param carBrand the car brand
	 * @param carCategory the car category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company car management
	 * @throws com.company.car.NoSuchCompanyCarManagementException if a matching company car management could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompanyCarManagement findByC_C_C_C_First(String carType,
		String contractType, String carBrand, String carCategory,
		OrderByComparator orderByComparator)
		throws NoSuchCompanyCarManagementException, SystemException {
		CompanyCarManagement companyCarManagement = fetchByC_C_C_C_First(carType,
				contractType, carBrand, carCategory, orderByComparator);

		if (companyCarManagement != null) {
			return companyCarManagement;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("carType=");
		msg.append(carType);

		msg.append(", contractType=");
		msg.append(contractType);

		msg.append(", carBrand=");
		msg.append(carBrand);

		msg.append(", carCategory=");
		msg.append(carCategory);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCompanyCarManagementException(msg.toString());
	}

	/**
	 * Returns the first company car management in the ordered set where carType = &#63; and contractType = &#63; and carBrand = &#63; and carCategory = &#63;.
	 *
	 * @param carType the car type
	 * @param contractType the contract type
	 * @param carBrand the car brand
	 * @param carCategory the car category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching company car management, or <code>null</code> if a matching company car management could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompanyCarManagement fetchByC_C_C_C_First(String carType,
		String contractType, String carBrand, String carCategory,
		OrderByComparator orderByComparator) throws SystemException {
		List<CompanyCarManagement> list = findByC_C_C_C(carType, contractType,
				carBrand, carCategory, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last company car management in the ordered set where carType = &#63; and contractType = &#63; and carBrand = &#63; and carCategory = &#63;.
	 *
	 * @param carType the car type
	 * @param contractType the contract type
	 * @param carBrand the car brand
	 * @param carCategory the car category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company car management
	 * @throws com.company.car.NoSuchCompanyCarManagementException if a matching company car management could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompanyCarManagement findByC_C_C_C_Last(String carType,
		String contractType, String carBrand, String carCategory,
		OrderByComparator orderByComparator)
		throws NoSuchCompanyCarManagementException, SystemException {
		CompanyCarManagement companyCarManagement = fetchByC_C_C_C_Last(carType,
				contractType, carBrand, carCategory, orderByComparator);

		if (companyCarManagement != null) {
			return companyCarManagement;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("carType=");
		msg.append(carType);

		msg.append(", contractType=");
		msg.append(contractType);

		msg.append(", carBrand=");
		msg.append(carBrand);

		msg.append(", carCategory=");
		msg.append(carCategory);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCompanyCarManagementException(msg.toString());
	}

	/**
	 * Returns the last company car management in the ordered set where carType = &#63; and contractType = &#63; and carBrand = &#63; and carCategory = &#63;.
	 *
	 * @param carType the car type
	 * @param contractType the contract type
	 * @param carBrand the car brand
	 * @param carCategory the car category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching company car management, or <code>null</code> if a matching company car management could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompanyCarManagement fetchByC_C_C_C_Last(String carType,
		String contractType, String carBrand, String carCategory,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByC_C_C_C(carType, contractType, carBrand, carCategory);

		if (count == 0) {
			return null;
		}

		List<CompanyCarManagement> list = findByC_C_C_C(carType, contractType,
				carBrand, carCategory, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the company car managements before and after the current company car management in the ordered set where carType = &#63; and contractType = &#63; and carBrand = &#63; and carCategory = &#63;.
	 *
	 * @param companyCarManagementId the primary key of the current company car management
	 * @param carType the car type
	 * @param contractType the contract type
	 * @param carBrand the car brand
	 * @param carCategory the car category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next company car management
	 * @throws com.company.car.NoSuchCompanyCarManagementException if a company car management with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompanyCarManagement[] findByC_C_C_C_PrevAndNext(
		long companyCarManagementId, String carType, String contractType,
		String carBrand, String carCategory, OrderByComparator orderByComparator)
		throws NoSuchCompanyCarManagementException, SystemException {
		CompanyCarManagement companyCarManagement = findByPrimaryKey(companyCarManagementId);

		Session session = null;

		try {
			session = openSession();

			CompanyCarManagement[] array = new CompanyCarManagementImpl[3];

			array[0] = getByC_C_C_C_PrevAndNext(session, companyCarManagement,
					carType, contractType, carBrand, carCategory,
					orderByComparator, true);

			array[1] = companyCarManagement;

			array[2] = getByC_C_C_C_PrevAndNext(session, companyCarManagement,
					carType, contractType, carBrand, carCategory,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CompanyCarManagement getByC_C_C_C_PrevAndNext(Session session,
		CompanyCarManagement companyCarManagement, String carType,
		String contractType, String carBrand, String carCategory,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_COMPANYCARMANAGEMENT_WHERE);

		boolean bindCarType = false;

		if (carType == null) {
			query.append(_FINDER_COLUMN_C_C_C_C_CARTYPE_1);
		}
		else if (carType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_C_C_C_CARTYPE_3);
		}
		else {
			bindCarType = true;

			query.append(_FINDER_COLUMN_C_C_C_C_CARTYPE_2);
		}

		boolean bindContractType = false;

		if (contractType == null) {
			query.append(_FINDER_COLUMN_C_C_C_C_CONTRACTTYPE_1);
		}
		else if (contractType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_C_C_C_CONTRACTTYPE_3);
		}
		else {
			bindContractType = true;

			query.append(_FINDER_COLUMN_C_C_C_C_CONTRACTTYPE_2);
		}

		boolean bindCarBrand = false;

		if (carBrand == null) {
			query.append(_FINDER_COLUMN_C_C_C_C_CARBRAND_1);
		}
		else if (carBrand.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_C_C_C_CARBRAND_3);
		}
		else {
			bindCarBrand = true;

			query.append(_FINDER_COLUMN_C_C_C_C_CARBRAND_2);
		}

		boolean bindCarCategory = false;

		if (carCategory == null) {
			query.append(_FINDER_COLUMN_C_C_C_C_CARCATEGORY_1);
		}
		else if (carCategory.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_C_C_C_C_CARCATEGORY_3);
		}
		else {
			bindCarCategory = true;

			query.append(_FINDER_COLUMN_C_C_C_C_CARCATEGORY_2);
		}

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
			query.append(CompanyCarManagementModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCarType) {
			qPos.add(carType);
		}

		if (bindContractType) {
			qPos.add(contractType);
		}

		if (bindCarBrand) {
			qPos.add(carBrand);
		}

		if (bindCarCategory) {
			qPos.add(carCategory);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(companyCarManagement);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CompanyCarManagement> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the company car managements where carType = &#63; and contractType = &#63; and carBrand = &#63; and carCategory = &#63; from the database.
	 *
	 * @param carType the car type
	 * @param contractType the contract type
	 * @param carBrand the car brand
	 * @param carCategory the car category
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByC_C_C_C(String carType, String contractType,
		String carBrand, String carCategory) throws SystemException {
		for (CompanyCarManagement companyCarManagement : findByC_C_C_C(
				carType, contractType, carBrand, carCategory,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(companyCarManagement);
		}
	}

	/**
	 * Returns the number of company car managements where carType = &#63; and contractType = &#63; and carBrand = &#63; and carCategory = &#63;.
	 *
	 * @param carType the car type
	 * @param contractType the contract type
	 * @param carBrand the car brand
	 * @param carCategory the car category
	 * @return the number of matching company car managements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByC_C_C_C(String carType, String contractType,
		String carBrand, String carCategory) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_C_C_C;

		Object[] finderArgs = new Object[] {
				carType, contractType, carBrand, carCategory
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_COMPANYCARMANAGEMENT_WHERE);

			boolean bindCarType = false;

			if (carType == null) {
				query.append(_FINDER_COLUMN_C_C_C_C_CARTYPE_1);
			}
			else if (carType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_C_C_CARTYPE_3);
			}
			else {
				bindCarType = true;

				query.append(_FINDER_COLUMN_C_C_C_C_CARTYPE_2);
			}

			boolean bindContractType = false;

			if (contractType == null) {
				query.append(_FINDER_COLUMN_C_C_C_C_CONTRACTTYPE_1);
			}
			else if (contractType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_C_C_CONTRACTTYPE_3);
			}
			else {
				bindContractType = true;

				query.append(_FINDER_COLUMN_C_C_C_C_CONTRACTTYPE_2);
			}

			boolean bindCarBrand = false;

			if (carBrand == null) {
				query.append(_FINDER_COLUMN_C_C_C_C_CARBRAND_1);
			}
			else if (carBrand.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_C_C_CARBRAND_3);
			}
			else {
				bindCarBrand = true;

				query.append(_FINDER_COLUMN_C_C_C_C_CARBRAND_2);
			}

			boolean bindCarCategory = false;

			if (carCategory == null) {
				query.append(_FINDER_COLUMN_C_C_C_C_CARCATEGORY_1);
			}
			else if (carCategory.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_C_C_C_C_CARCATEGORY_3);
			}
			else {
				bindCarCategory = true;

				query.append(_FINDER_COLUMN_C_C_C_C_CARCATEGORY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCarType) {
					qPos.add(carType);
				}

				if (bindContractType) {
					qPos.add(contractType);
				}

				if (bindCarBrand) {
					qPos.add(carBrand);
				}

				if (bindCarCategory) {
					qPos.add(carCategory);
				}

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

	private static final String _FINDER_COLUMN_C_C_C_C_CARTYPE_1 = "companyCarManagement.carType IS NULL AND ";
	private static final String _FINDER_COLUMN_C_C_C_C_CARTYPE_2 = "companyCarManagement.carType = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_C_CARTYPE_3 = "(companyCarManagement.carType IS NULL OR companyCarManagement.carType = '') AND ";
	private static final String _FINDER_COLUMN_C_C_C_C_CONTRACTTYPE_1 = "companyCarManagement.contractType IS NULL AND ";
	private static final String _FINDER_COLUMN_C_C_C_C_CONTRACTTYPE_2 = "companyCarManagement.contractType = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_C_CONTRACTTYPE_3 = "(companyCarManagement.contractType IS NULL OR companyCarManagement.contractType = '') AND ";
	private static final String _FINDER_COLUMN_C_C_C_C_CARBRAND_1 = "companyCarManagement.carBrand IS NULL AND ";
	private static final String _FINDER_COLUMN_C_C_C_C_CARBRAND_2 = "companyCarManagement.carBrand = ? AND ";
	private static final String _FINDER_COLUMN_C_C_C_C_CARBRAND_3 = "(companyCarManagement.carBrand IS NULL OR companyCarManagement.carBrand = '') AND ";
	private static final String _FINDER_COLUMN_C_C_C_C_CARCATEGORY_1 = "companyCarManagement.carCategory IS NULL";
	private static final String _FINDER_COLUMN_C_C_C_C_CARCATEGORY_2 = "companyCarManagement.carCategory = ?";
	private static final String _FINDER_COLUMN_C_C_C_C_CARCATEGORY_3 = "(companyCarManagement.carCategory IS NULL OR companyCarManagement.carCategory = '')";

	public CompanyCarManagementPersistenceImpl() {
		setModelClass(CompanyCarManagement.class);
	}

	/**
	 * Caches the company car management in the entity cache if it is enabled.
	 *
	 * @param companyCarManagement the company car management
	 */
	@Override
	public void cacheResult(CompanyCarManagement companyCarManagement) {
		EntityCacheUtil.putResult(CompanyCarManagementModelImpl.ENTITY_CACHE_ENABLED,
			CompanyCarManagementImpl.class,
			companyCarManagement.getPrimaryKey(), companyCarManagement);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CARNO,
			new Object[] { companyCarManagement.getCarNo() },
			companyCarManagement);

		companyCarManagement.resetOriginalValues();
	}

	/**
	 * Caches the company car managements in the entity cache if it is enabled.
	 *
	 * @param companyCarManagements the company car managements
	 */
	@Override
	public void cacheResult(List<CompanyCarManagement> companyCarManagements) {
		for (CompanyCarManagement companyCarManagement : companyCarManagements) {
			if (EntityCacheUtil.getResult(
						CompanyCarManagementModelImpl.ENTITY_CACHE_ENABLED,
						CompanyCarManagementImpl.class,
						companyCarManagement.getPrimaryKey()) == null) {
				cacheResult(companyCarManagement);
			}
			else {
				companyCarManagement.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all company car managements.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CompanyCarManagementImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CompanyCarManagementImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the company car management.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CompanyCarManagement companyCarManagement) {
		EntityCacheUtil.removeResult(CompanyCarManagementModelImpl.ENTITY_CACHE_ENABLED,
			CompanyCarManagementImpl.class, companyCarManagement.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(companyCarManagement);
	}

	@Override
	public void clearCache(List<CompanyCarManagement> companyCarManagements) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CompanyCarManagement companyCarManagement : companyCarManagements) {
			EntityCacheUtil.removeResult(CompanyCarManagementModelImpl.ENTITY_CACHE_ENABLED,
				CompanyCarManagementImpl.class,
				companyCarManagement.getPrimaryKey());

			clearUniqueFindersCache(companyCarManagement);
		}
	}

	protected void cacheUniqueFindersCache(
		CompanyCarManagement companyCarManagement) {
		if (companyCarManagement.isNew()) {
			Object[] args = new Object[] { companyCarManagement.getCarNo() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CARNO, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CARNO, args,
				companyCarManagement);
		}
		else {
			CompanyCarManagementModelImpl companyCarManagementModelImpl = (CompanyCarManagementModelImpl)companyCarManagement;

			if ((companyCarManagementModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CARNO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { companyCarManagement.getCarNo() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CARNO, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CARNO, args,
					companyCarManagement);
			}
		}
	}

	protected void clearUniqueFindersCache(
		CompanyCarManagement companyCarManagement) {
		CompanyCarManagementModelImpl companyCarManagementModelImpl = (CompanyCarManagementModelImpl)companyCarManagement;

		Object[] args = new Object[] { companyCarManagement.getCarNo() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CARNO, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CARNO, args);

		if ((companyCarManagementModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CARNO.getColumnBitmask()) != 0) {
			args = new Object[] { companyCarManagementModelImpl.getOriginalCarNo() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CARNO, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CARNO, args);
		}
	}

	/**
	 * Creates a new company car management with the primary key. Does not add the company car management to the database.
	 *
	 * @param companyCarManagementId the primary key for the new company car management
	 * @return the new company car management
	 */
	@Override
	public CompanyCarManagement create(long companyCarManagementId) {
		CompanyCarManagement companyCarManagement = new CompanyCarManagementImpl();

		companyCarManagement.setNew(true);
		companyCarManagement.setPrimaryKey(companyCarManagementId);

		return companyCarManagement;
	}

	/**
	 * Removes the company car management with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param companyCarManagementId the primary key of the company car management
	 * @return the company car management that was removed
	 * @throws com.company.car.NoSuchCompanyCarManagementException if a company car management with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompanyCarManagement remove(long companyCarManagementId)
		throws NoSuchCompanyCarManagementException, SystemException {
		return remove((Serializable)companyCarManagementId);
	}

	/**
	 * Removes the company car management with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the company car management
	 * @return the company car management that was removed
	 * @throws com.company.car.NoSuchCompanyCarManagementException if a company car management with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompanyCarManagement remove(Serializable primaryKey)
		throws NoSuchCompanyCarManagementException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CompanyCarManagement companyCarManagement = (CompanyCarManagement)session.get(CompanyCarManagementImpl.class,
					primaryKey);

			if (companyCarManagement == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCompanyCarManagementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(companyCarManagement);
		}
		catch (NoSuchCompanyCarManagementException nsee) {
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
	protected CompanyCarManagement removeImpl(
		CompanyCarManagement companyCarManagement) throws SystemException {
		companyCarManagement = toUnwrappedModel(companyCarManagement);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(companyCarManagement)) {
				companyCarManagement = (CompanyCarManagement)session.get(CompanyCarManagementImpl.class,
						companyCarManagement.getPrimaryKeyObj());
			}

			if (companyCarManagement != null) {
				session.delete(companyCarManagement);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (companyCarManagement != null) {
			clearCache(companyCarManagement);
		}

		return companyCarManagement;
	}

	@Override
	public CompanyCarManagement updateImpl(
		com.company.car.model.CompanyCarManagement companyCarManagement)
		throws SystemException {
		companyCarManagement = toUnwrappedModel(companyCarManagement);

		boolean isNew = companyCarManagement.isNew();

		CompanyCarManagementModelImpl companyCarManagementModelImpl = (CompanyCarManagementModelImpl)companyCarManagement;

		Session session = null;

		try {
			session = openSession();

			if (companyCarManagement.isNew()) {
				session.save(companyCarManagement);

				companyCarManagement.setNew(false);
			}
			else {
				session.merge(companyCarManagement);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CompanyCarManagementModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((companyCarManagementModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						companyCarManagementModelImpl.getOriginalCarType(),
						companyCarManagementModelImpl.getOriginalContractType(),
						companyCarManagementModelImpl.getOriginalCarBrand(),
						companyCarManagementModelImpl.getOriginalCarCategory()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_C,
					args);

				args = new Object[] {
						companyCarManagementModelImpl.getCarType(),
						companyCarManagementModelImpl.getContractType(),
						companyCarManagementModelImpl.getCarBrand(),
						companyCarManagementModelImpl.getCarCategory()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_C_C_C, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_C_C_C,
					args);
			}
		}

		EntityCacheUtil.putResult(CompanyCarManagementModelImpl.ENTITY_CACHE_ENABLED,
			CompanyCarManagementImpl.class,
			companyCarManagement.getPrimaryKey(), companyCarManagement);

		clearUniqueFindersCache(companyCarManagement);
		cacheUniqueFindersCache(companyCarManagement);

		return companyCarManagement;
	}

	protected CompanyCarManagement toUnwrappedModel(
		CompanyCarManagement companyCarManagement) {
		if (companyCarManagement instanceof CompanyCarManagementImpl) {
			return companyCarManagement;
		}

		CompanyCarManagementImpl companyCarManagementImpl = new CompanyCarManagementImpl();

		companyCarManagementImpl.setNew(companyCarManagement.isNew());
		companyCarManagementImpl.setPrimaryKey(companyCarManagement.getPrimaryKey());

		companyCarManagementImpl.setCompanyCarManagementId(companyCarManagement.getCompanyCarManagementId());
		companyCarManagementImpl.setCreateDate(companyCarManagement.getCreateDate());
		companyCarManagementImpl.setModifiedDate(companyCarManagement.getModifiedDate());
		companyCarManagementImpl.setCarNo(companyCarManagement.getCarNo());
		companyCarManagementImpl.setCarType(companyCarManagement.getCarType());
		companyCarManagementImpl.setContractType(companyCarManagement.getContractType());
		companyCarManagementImpl.setGradeType(companyCarManagement.getGradeType());
		companyCarManagementImpl.setGrade(companyCarManagement.getGrade());
		companyCarManagementImpl.setCarBrand(companyCarManagement.getCarBrand());
		companyCarManagementImpl.setCarModel(companyCarManagement.getCarModel());
		companyCarManagementImpl.setCarCategory(companyCarManagement.getCarCategory());

		return companyCarManagementImpl;
	}

	/**
	 * Returns the company car management with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the company car management
	 * @return the company car management
	 * @throws com.company.car.NoSuchCompanyCarManagementException if a company car management with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompanyCarManagement findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCompanyCarManagementException, SystemException {
		CompanyCarManagement companyCarManagement = fetchByPrimaryKey(primaryKey);

		if (companyCarManagement == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCompanyCarManagementException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return companyCarManagement;
	}

	/**
	 * Returns the company car management with the primary key or throws a {@link com.company.car.NoSuchCompanyCarManagementException} if it could not be found.
	 *
	 * @param companyCarManagementId the primary key of the company car management
	 * @return the company car management
	 * @throws com.company.car.NoSuchCompanyCarManagementException if a company car management with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompanyCarManagement findByPrimaryKey(long companyCarManagementId)
		throws NoSuchCompanyCarManagementException, SystemException {
		return findByPrimaryKey((Serializable)companyCarManagementId);
	}

	/**
	 * Returns the company car management with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the company car management
	 * @return the company car management, or <code>null</code> if a company car management with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompanyCarManagement fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CompanyCarManagement companyCarManagement = (CompanyCarManagement)EntityCacheUtil.getResult(CompanyCarManagementModelImpl.ENTITY_CACHE_ENABLED,
				CompanyCarManagementImpl.class, primaryKey);

		if (companyCarManagement == _nullCompanyCarManagement) {
			return null;
		}

		if (companyCarManagement == null) {
			Session session = null;

			try {
				session = openSession();

				companyCarManagement = (CompanyCarManagement)session.get(CompanyCarManagementImpl.class,
						primaryKey);

				if (companyCarManagement != null) {
					cacheResult(companyCarManagement);
				}
				else {
					EntityCacheUtil.putResult(CompanyCarManagementModelImpl.ENTITY_CACHE_ENABLED,
						CompanyCarManagementImpl.class, primaryKey,
						_nullCompanyCarManagement);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CompanyCarManagementModelImpl.ENTITY_CACHE_ENABLED,
					CompanyCarManagementImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return companyCarManagement;
	}

	/**
	 * Returns the company car management with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param companyCarManagementId the primary key of the company car management
	 * @return the company car management, or <code>null</code> if a company car management with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CompanyCarManagement fetchByPrimaryKey(long companyCarManagementId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)companyCarManagementId);
	}

	/**
	 * Returns all the company car managements.
	 *
	 * @return the company car managements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompanyCarManagement> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the company car managements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.CompanyCarManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of company car managements
	 * @param end the upper bound of the range of company car managements (not inclusive)
	 * @return the range of company car managements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompanyCarManagement> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the company car managements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.company.car.model.impl.CompanyCarManagementModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of company car managements
	 * @param end the upper bound of the range of company car managements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of company car managements
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CompanyCarManagement> findAll(int start, int end,
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

		List<CompanyCarManagement> list = (List<CompanyCarManagement>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_COMPANYCARMANAGEMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_COMPANYCARMANAGEMENT;

				if (pagination) {
					sql = sql.concat(CompanyCarManagementModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CompanyCarManagement>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CompanyCarManagement>(list);
				}
				else {
					list = (List<CompanyCarManagement>)QueryUtil.list(q,
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
	 * Removes all the company car managements from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CompanyCarManagement companyCarManagement : findAll()) {
			remove(companyCarManagement);
		}
	}

	/**
	 * Returns the number of company car managements.
	 *
	 * @return the number of company car managements
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

				Query q = session.createQuery(_SQL_COUNT_COMPANYCARMANAGEMENT);

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
	 * Initializes the company car management persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.company.car.model.CompanyCarManagement")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CompanyCarManagement>> listenersList = new ArrayList<ModelListener<CompanyCarManagement>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CompanyCarManagement>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CompanyCarManagementImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_COMPANYCARMANAGEMENT = "SELECT companyCarManagement FROM CompanyCarManagement companyCarManagement";
	private static final String _SQL_SELECT_COMPANYCARMANAGEMENT_WHERE = "SELECT companyCarManagement FROM CompanyCarManagement companyCarManagement WHERE ";
	private static final String _SQL_COUNT_COMPANYCARMANAGEMENT = "SELECT COUNT(companyCarManagement) FROM CompanyCarManagement companyCarManagement";
	private static final String _SQL_COUNT_COMPANYCARMANAGEMENT_WHERE = "SELECT COUNT(companyCarManagement) FROM CompanyCarManagement companyCarManagement WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "companyCarManagement.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CompanyCarManagement exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CompanyCarManagement exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CompanyCarManagementPersistenceImpl.class);
	private static CompanyCarManagement _nullCompanyCarManagement = new CompanyCarManagementImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CompanyCarManagement> toCacheModel() {
				return _nullCompanyCarManagementCacheModel;
			}
		};

	private static CacheModel<CompanyCarManagement> _nullCompanyCarManagementCacheModel =
		new CacheModel<CompanyCarManagement>() {
			@Override
			public CompanyCarManagement toEntityModel() {
				return _nullCompanyCarManagement;
			}
		};
}