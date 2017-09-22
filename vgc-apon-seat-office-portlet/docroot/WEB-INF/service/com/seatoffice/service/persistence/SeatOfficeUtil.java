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

package com.seatoffice.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.seatoffice.model.SeatOffice;

import java.util.List;

/**
 * The persistence utility for the seat office service. This utility wraps {@link SeatOfficePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alice.zou
 * @see SeatOfficePersistence
 * @see SeatOfficePersistenceImpl
 * @generated
 */
public class SeatOfficeUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(SeatOffice seatOffice) {
		getPersistence().clearCache(seatOffice);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SeatOffice> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SeatOffice> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SeatOffice> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SeatOffice update(SeatOffice seatOffice)
		throws SystemException {
		return getPersistence().update(seatOffice);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SeatOffice update(SeatOffice seatOffice,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(seatOffice, serviceContext);
	}

	/**
	* Returns all the seat offices where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the matching seat offices
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.seatoffice.model.SeatOffice> findByS_U(
		int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_U(status, userId);
	}

	/**
	* Returns a range of all the seat offices where status = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.seatoffice.model.impl.SeatOfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param userId the user ID
	* @param start the lower bound of the range of seat offices
	* @param end the upper bound of the range of seat offices (not inclusive)
	* @return the range of matching seat offices
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.seatoffice.model.SeatOffice> findByS_U(
		int status, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_U(status, userId, start, end);
	}

	/**
	* Returns an ordered range of all the seat offices where status = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.seatoffice.model.impl.SeatOfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param userId the user ID
	* @param start the lower bound of the range of seat offices
	* @param end the upper bound of the range of seat offices (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching seat offices
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.seatoffice.model.SeatOffice> findByS_U(
		int status, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_U(status, userId, start, end, orderByComparator);
	}

	/**
	* Returns the first seat office in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching seat office
	* @throws com.seatoffice.NoSuchSeatOfficeException if a matching seat office could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.seatoffice.model.SeatOffice findByS_U_First(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.seatoffice.NoSuchSeatOfficeException {
		return getPersistence()
				   .findByS_U_First(status, userId, orderByComparator);
	}

	/**
	* Returns the first seat office in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching seat office, or <code>null</code> if a matching seat office could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.seatoffice.model.SeatOffice fetchByS_U_First(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_U_First(status, userId, orderByComparator);
	}

	/**
	* Returns the last seat office in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching seat office
	* @throws com.seatoffice.NoSuchSeatOfficeException if a matching seat office could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.seatoffice.model.SeatOffice findByS_U_Last(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.seatoffice.NoSuchSeatOfficeException {
		return getPersistence().findByS_U_Last(status, userId, orderByComparator);
	}

	/**
	* Returns the last seat office in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching seat office, or <code>null</code> if a matching seat office could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.seatoffice.model.SeatOffice fetchByS_U_Last(int status,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_U_Last(status, userId, orderByComparator);
	}

	/**
	* Returns the seat offices before and after the current seat office in the ordered set where status = &#63; and userId = &#63;.
	*
	* @param seatId the primary key of the current seat office
	* @param status the status
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next seat office
	* @throws com.seatoffice.NoSuchSeatOfficeException if a seat office with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.seatoffice.model.SeatOffice[] findByS_U_PrevAndNext(
		long seatId, int status, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.seatoffice.NoSuchSeatOfficeException {
		return getPersistence()
				   .findByS_U_PrevAndNext(seatId, status, userId,
			orderByComparator);
	}

	/**
	* Removes all the seat offices where status = &#63; and userId = &#63; from the database.
	*
	* @param status the status
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByS_U(int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByS_U(status, userId);
	}

	/**
	* Returns the number of seat offices where status = &#63; and userId = &#63;.
	*
	* @param status the status
	* @param userId the user ID
	* @return the number of matching seat offices
	* @throws SystemException if a system exception occurred
	*/
	public static int countByS_U(int status, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByS_U(status, userId);
	}

	/**
	* Caches the seat office in the entity cache if it is enabled.
	*
	* @param seatOffice the seat office
	*/
	public static void cacheResult(com.seatoffice.model.SeatOffice seatOffice) {
		getPersistence().cacheResult(seatOffice);
	}

	/**
	* Caches the seat offices in the entity cache if it is enabled.
	*
	* @param seatOffices the seat offices
	*/
	public static void cacheResult(
		java.util.List<com.seatoffice.model.SeatOffice> seatOffices) {
		getPersistence().cacheResult(seatOffices);
	}

	/**
	* Creates a new seat office with the primary key. Does not add the seat office to the database.
	*
	* @param seatId the primary key for the new seat office
	* @return the new seat office
	*/
	public static com.seatoffice.model.SeatOffice create(long seatId) {
		return getPersistence().create(seatId);
	}

	/**
	* Removes the seat office with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param seatId the primary key of the seat office
	* @return the seat office that was removed
	* @throws com.seatoffice.NoSuchSeatOfficeException if a seat office with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.seatoffice.model.SeatOffice remove(long seatId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.seatoffice.NoSuchSeatOfficeException {
		return getPersistence().remove(seatId);
	}

	public static com.seatoffice.model.SeatOffice updateImpl(
		com.seatoffice.model.SeatOffice seatOffice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(seatOffice);
	}

	/**
	* Returns the seat office with the primary key or throws a {@link com.seatoffice.NoSuchSeatOfficeException} if it could not be found.
	*
	* @param seatId the primary key of the seat office
	* @return the seat office
	* @throws com.seatoffice.NoSuchSeatOfficeException if a seat office with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.seatoffice.model.SeatOffice findByPrimaryKey(long seatId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.seatoffice.NoSuchSeatOfficeException {
		return getPersistence().findByPrimaryKey(seatId);
	}

	/**
	* Returns the seat office with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param seatId the primary key of the seat office
	* @return the seat office, or <code>null</code> if a seat office with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.seatoffice.model.SeatOffice fetchByPrimaryKey(long seatId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(seatId);
	}

	/**
	* Returns all the seat offices.
	*
	* @return the seat offices
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.seatoffice.model.SeatOffice> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.seatoffice.model.SeatOffice> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the seat offices.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.seatoffice.model.impl.SeatOfficeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of seat offices
	* @param end the upper bound of the range of seat offices (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of seat offices
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.seatoffice.model.SeatOffice> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the seat offices from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of seat offices.
	*
	* @return the number of seat offices
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SeatOfficePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SeatOfficePersistence)PortletBeanLocatorUtil.locate(com.seatoffice.service.ClpSerializer.getServletContextName(),
					SeatOfficePersistence.class.getName());

			ReferenceRegistry.registerReference(SeatOfficeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SeatOfficePersistence persistence) {
	}

	private static SeatOfficePersistence _persistence;
}